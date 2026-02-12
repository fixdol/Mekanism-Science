package com.fxd927.mekanismelements.client.recipe_viewer;

import com.fxd927.mekanismelements.common.recipe.IMSRecipeTypeProvider;
import com.fxd927.mekanismelements.common.recipe.MSRecipeType;
import mekanism.api.MekanismAPITags;
import mekanism.api.chemical.Chemical;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.recipes.ItemStackToChemicalRecipe;
import mekanism.api.recipes.ItemStackToFluidOptionalItemRecipe;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import mekanism.client.gui.element.bar.GuiBar;
import mekanism.client.gui.element.progress.IProgressInfoHandler;
import mekanism.common.Mekanism;
import mekanism.common.MekanismLang;
import mekanism.common.recipe.MekanismRecipeType;
import mekanism.common.tier.ChemicalTankTier;
import mekanism.common.tile.machine.TileEntityNutritionalLiquifier;
import mekanism.common.util.ChemicalUtil;
import mekanism.common.util.RegistryUtils;
import net.minecraft.SharedConstants;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.TimeUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

public class MSRecipeViewerUtils {
    private MSRecipeViewerUtils() {
    }

    public static final IProgressInfoHandler CONSTANT_PROGRESS = () -> 1;
    public static final GuiBar.IBarInfoHandler FULL_BAR = () -> 1;

    public static IProgressInfoHandler progressHandler(int processTime) {
        int time = SharedConstants.MILLIS_PER_TICK * processTime;
        return () -> {
            double subTime = System.currentTimeMillis() % (long) time;
            return subTime / time;
        };
    }

    public static GuiBar.IBarInfoHandler barProgressHandler(int processTime) {
        Component tooltip = MekanismLang.TICKS_REQUIRED.translate(processTime);
        int time = SharedConstants.MILLIS_PER_TICK * processTime;
        return new GuiBar.IBarInfoHandler() {
            @Override
            public Component getTooltip() {
                return tooltip;
            }

            @Override
            public double getLevel() {
                double subTime = System.currentTimeMillis() % (long) time;
                return subTime / time;
            }
        };
    }

    public static ResourceLocation synthetic(ResourceLocation id, String prefix, String namespace) {
        return synthetic(ResourceLocation.fromNamespaceAndPath(namespace, id.toString().replace(':', '_')), prefix);
    }

    public static ResourceLocation synthetic(ResourceLocation id, String prefix) {
        return id.withPrefix("/" + prefix + "/");
    }

    public static <T> T getCurrent(List<T> elements) {
        return elements.get(getIndex(elements));
    }

    public static int getIndex(List<?> elements) {
        return (int) (System.currentTimeMillis() / TimeUtil.MILLISECONDS_PER_SECOND % elements.size());
    }

    public static long getCurrent(long[] elements) {
        return elements[getIndex(elements)];
    }

    public static <T> int getIndex(long[] elements) {
        return (int) (System.currentTimeMillis() / TimeUtil.MILLISECONDS_PER_SECOND % elements.length);
    }

    public static List<ItemStack> getStacksFor(ChemicalStackIngredient ingredient, boolean displayConversions) {
        Set<Chemical> chemicals = ingredient.getRepresentations().stream().map(ChemicalStack::getChemical).collect(Collectors.toSet());
        return getStacksFor(chemicals, displayConversions ? MSRecipeType.CHEMICAL_CONVERSION : null);
    }

    private static List<ItemStack> getStacksFor(Set<Chemical> supportedTypes, @Nullable IMSRecipeTypeProvider<?, ? extends ItemStackToChemicalRecipe, ?> recipeType) {
        List<ItemStack> stacks = new ArrayList<>();
        for (Chemical type : supportedTypes) {
            // Fixed: Chemical is a Holder<Chemical> (intrusive holder), getFullChemicalTank expects Holder<Chemical>
            // Cast Chemical to Holder<Chemical> since Chemical implements Holder
            stacks.add(ChemicalUtil.getFullChemicalTank(ChemicalTankTier.BASIC, (net.minecraft.core.Holder<Chemical>) type));
        }
        if (recipeType != null) {
            for (RecipeHolder<? extends ItemStackToChemicalRecipe> recipeHolder : recipeType.getRecipes(null)) {
                ItemStackToChemicalRecipe recipe = recipeHolder.value();
                for (ChemicalStack output : recipe.getOutputDefinition()) {
                    if (supportedTypes.contains(output.getChemical())) {
                        stacks.addAll(recipe.getInput().getRepresentations());
                        break;
                    }
                }
            }
        }
        return stacks;
    }

    public static Map<ResourceLocation, ItemStackToFluidOptionalItemRecipe> getLiquificationRecipes() {
        Map<ResourceLocation, ItemStackToFluidOptionalItemRecipe> liquification = new HashMap<>();
        //TODO: Do we want to loop creative tabs or something instead?
        // In theory recipe loaders should init the creative tabs before we are called so we wouldn't need to call
        // CreativeModeTab#buildContents, and in theory we only need to care about things in search so could use:
        // CreativeModeTabs.searchTab().getDisplayItems(). The bigger issue is how to come up with unique synthetic
        // names for the recipes as EMI requires they be unique. (Maybe index them?)
        for (Item item : BuiltInRegistries.ITEM) {
            ItemStackToFluidOptionalItemRecipe recipe = TileEntityNutritionalLiquifier.getRecipe(item.getDefaultInstance());
            if (recipe != null) {
                liquification.put(MSRecipeViewerUtils.synthetic(RegistryUtils.getName(BuiltInRegistries.ITEM.wrapAsHolder(item)), "liquification", Mekanism.MODID), recipe);
            }
        }
        return liquification;
    }

    public static List<ItemStack> getDisplayItems(ChemicalStackIngredient ingredient) {
        SequencedSet<HolderSet.Named<Item>> tags = new LinkedHashSet<>();
        for (ChemicalStack chemicalStack : ingredient.getRepresentations()) {
            Chemical chemical = chemicalStack.getChemical();
            if (!chemical.is(MekanismAPITags.Chemicals.DIRTY)) {
                TagKey<Item> oreTag = chemical.getOreTag();
                if (oreTag != null) {
                    BuiltInRegistries.ITEM.getTag(oreTag).ifPresent(tags::add);
                }
            }
        }
        if (tags.size() == 1) {
            //TODO: Eventually come up with a better way to do this to allow for if there outputs based on the input and multiple input types
            return tags.getFirst().stream().map(ItemStack::new).toList();
        }
        return Collections.emptyList();
    }
}