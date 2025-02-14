package com.fxd927.mekanismscience.common.tile.machine;

import com.fxd927.mekanismscience.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismscience.api.recipes.cache.MSItemStackConstantChemicalToObjectCachedRecipe;
import com.fxd927.mekanismscience.api.recipes.cache.MSTwoInputCachedRecipe;
import com.fxd927.mekanismscience.client.recipe_viewer.type.IMSRecipeViewerRecipeType;
import com.fxd927.mekanismscience.client.recipe_viewer.type.MSRecipeViewerRecipeType;
import com.fxd927.mekanismscience.common.recipe.IMSRecipeTypeProvider;
import com.fxd927.mekanismscience.common.recipe.MSRecipeType;
import com.fxd927.mekanismscience.common.recipe.lookup.IMSDoubleRecipeLookupHandler;
import com.fxd927.mekanismscience.common.recipe.lookup.IMSRecipeLookupHandler;
import com.fxd927.mekanismscience.common.recipe.lookup.cache.MSInputRecipeCache;
import com.fxd927.mekanismscience.common.registries.MSBlocks;
import com.fxd927.mekanismscience.common.tile.prefab.MSTileEntityProgressMachine;
import mekanism.api.IContentsListener;
import mekanism.api.RelativeSide;
import mekanism.api.SerializationConstants;
import mekanism.api.Upgrade;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.chemical.IChemicalTank;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.api.recipes.cache.ItemStackConstantChemicalToObjectCachedRecipe;
import mekanism.api.recipes.inputs.IInputHandler;
import mekanism.api.recipes.inputs.ILongInputHandler;
import mekanism.api.recipes.inputs.InputHelper;
import mekanism.api.recipes.outputs.IOutputHandler;
import mekanism.api.recipes.outputs.OutputHelper;
import mekanism.api.recipes.vanilla_input.SingleItemChemicalRecipeInput;
import mekanism.common.capabilities.energy.MachineEnergyContainer;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.capabilities.holder.energy.EnergyContainerHelper;
import mekanism.common.capabilities.holder.energy.IEnergyContainerHolder;
import mekanism.common.capabilities.holder.slot.IInventorySlotHolder;
import mekanism.common.capabilities.holder.slot.InventorySlotHelper;
import mekanism.common.integration.computer.SpecialComputerMethodWrapper;
import mekanism.common.integration.computer.annotation.ComputerMethod;
import mekanism.common.integration.computer.annotation.WrappingComputerMethod;
import mekanism.common.integration.computer.computercraft.ComputerConstants;
import mekanism.common.inventory.container.slot.SlotOverlay;
import mekanism.common.inventory.slot.EnergyInventorySlot;
import mekanism.common.inventory.slot.InputInventorySlot;
import mekanism.common.inventory.slot.chemical.ChemicalInventorySlot;
import mekanism.common.inventory.warning.WarningTracker;
import mekanism.common.lib.transmitter.TransmissionType;
import mekanism.common.tile.component.TileComponentEjector;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.StatUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TileEntityRadiationIrradiator extends MSTileEntityProgressMachine<RadiationIrradiatingRecipe> implements IMSRecipeLookupHandler.ConstantUsageRecipeLookupHandler,
        IMSDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<RadiationIrradiatingRecipe> {
    private static final List<CachedRecipe.OperationTracker.RecipeError> TRACKED_ERROR_TYPES = List.of(
            CachedRecipe.OperationTracker.RecipeError.NOT_ENOUGH_ENERGY,
            CachedRecipe.OperationTracker.RecipeError.NOT_ENOUGH_ENERGY_REDUCED_RATE,
            CachedRecipe.OperationTracker.RecipeError.NOT_ENOUGH_INPUT,
            CachedRecipe.OperationTracker.RecipeError.NOT_ENOUGH_SECONDARY_INPUT,
            CachedRecipe.OperationTracker.RecipeError.NOT_ENOUGH_OUTPUT_SPACE,
            CachedRecipe.OperationTracker.RecipeError.INPUT_DOESNT_PRODUCE_OUTPUT
    );
    public static final long MAX_CHEMICAL = 10_000;
    public static final int BASE_TICKS_REQUIRED = 25;
    private final ItemStackConstantChemicalToObjectCachedRecipe.ChemicalUsageMultiplier injectUsageMultiplier;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerChemicalTankWrapper.class, methodNames = {"getGasInput", "getGasInputCapacity", "getGasInputNeeded",
            "getChemicalInputFilledPercentage"}, docPlaceholder = "chemical input tank")
    public IChemicalTank injectTank;
    public IChemicalTank outputTank;
    public double injectUsage = 1;
    private long usedSoFar;

    private final IOutputHandler<ChemicalStack> outputHandler;
    private final IInputHandler<@NotNull ItemStack> itemInputHandler;
    private final ILongInputHandler<@NotNull ChemicalStack> gasInputHandler;

    private MachineEnergyContainer<TileEntityRadiationIrradiator> energyContainer;
    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getInputGasItem", docPlaceholder = "gas input item slot")
    ChemicalInventorySlot gasInputSlot;
    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getInputItem", docPlaceholder = "input slot")
    InputInventorySlot inputSlot;
    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getOutputItem", docPlaceholder = "output slot")
    ChemicalInventorySlot outputSlot;
    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getEnergyItem", docPlaceholder = "energy slot")
    EnergyInventorySlot energySlot;

    public TileEntityRadiationIrradiator(BlockPos pos, BlockState state) {
        super(null, pos, state, TRACKED_ERROR_TYPES, BASE_TICKS_REQUIRED);
        configComponent.setupItemIOExtraConfig(inputSlot, outputSlot, gasInputSlot, energySlot);
        configComponent.setupIOConfig(TransmissionType.CHEMICAL, injectTank, outputTank, RelativeSide.RIGHT);
        configComponent.setupInputConfig(TransmissionType.ENERGY, energyContainer);

        ejectorComponent = new TileComponentEjector(this);
        ejectorComponent.setOutputData(configComponent, TransmissionType.ITEM, TransmissionType.CHEMICAL)
                .setCanTankEject(tank -> tank != injectTank);

        itemInputHandler = InputHelper.getInputHandler(inputSlot, CachedRecipe.OperationTracker.RecipeError.NOT_ENOUGH_INPUT);
        gasInputHandler = InputHelper.getConstantInputHandler(injectTank);
        outputHandler = OutputHelper.getOutputHandler(outputTank, CachedRecipe.OperationTracker.RecipeError.NOT_ENOUGH_OUTPUT_SPACE);
        injectUsageMultiplier = (usedSoFar, operatingTicks) -> StatUtils.inversePoisson(injectUsage);
    }

    @NotNull
    @Override
    public IChemicalTankHolder getInitialChemicalTanks(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(injectTank = BasicChemicalTank.input(MAX_CHEMICAL, gas -> containsRecipeBA(inputSlot.getStack(), gas), this::containsRecipeB, recipeCacheListener));
        builder.addTank(outputTank = BasicChemicalTank.output(MAX_CHEMICAL, recipeCacheUnpauseListener));
        return builder.build();
    }

    @NotNull
    @Override
    protected IEnergyContainerHolder getInitialEnergyContainers(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        EnergyContainerHelper builder = EnergyContainerHelper.forSideWithConfig(this);
        builder.addContainer(energyContainer = MachineEnergyContainer.input(this, recipeCacheUnpauseListener));
        return builder.build();
    }


    @NotNull
    @Override
    protected IInventorySlotHolder getInitialInventory(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        InventorySlotHelper builder = InventorySlotHelper.forSideWithConfig(this);
        builder.addSlot(gasInputSlot = ChemicalInventorySlot.fillOrConvert(injectTank, this::getLevel, listener, 8, 65));
        builder.addSlot(inputSlot = InputInventorySlot.at(item -> containsRecipeAB(item, injectTank.getStack()), this::containsRecipeA, recipeCacheListener, 28, 36))
                .tracksWarnings(slot -> slot.warning(WarningTracker.WarningType.NO_MATCHING_RECIPE, getWarningCheck(CachedRecipe.OperationTracker.RecipeError.NOT_ENOUGH_INPUT)));
        builder.addSlot(outputSlot = ChemicalInventorySlot.drain(outputTank, listener, 152, 55));
        builder.addSlot(energySlot = EnergyInventorySlot.fillOrConvert(energyContainer, this::getLevel, listener, 152, 14));
        gasInputSlot.setSlotOverlay(SlotOverlay.MINUS);
        outputSlot.setSlotOverlay(SlotOverlay.PLUS);
        return builder.build();
    }

    @Override
    protected boolean onUpdateServer() {
        boolean sendUpdatePacket = super.onUpdateServer();
        energySlot.fillContainerOrConvert();
        gasInputSlot.fillTankOrConvert();
        outputSlot.drainTank();
        recipeCacheLookupMonitor.updateAndProcess();
        return sendUpdatePacket;
    }

    @NotNull
    @Override
    public IMSRecipeTypeProvider<SingleItemChemicalRecipeInput, RadiationIrradiatingRecipe, MSInputRecipeCache.ItemChemical<RadiationIrradiatingRecipe>> getMSRecipeType() {
        return MSRecipeType.RADIATION_IRRADIATING;
    }

    @Override
    public IMSRecipeViewerRecipeType<RadiationIrradiatingRecipe> recipeViewerType() {
        return MSRecipeViewerRecipeType.RADIATION_IRRADIATING;
    }

    @Nullable
    @Override
    public RadiationIrradiatingRecipe getRecipe(int cacheIndex) {
        return findFirstRecipe(itemInputHandler, gasInputHandler);
    }

    @NotNull
    @Override
    public CachedRecipe<RadiationIrradiatingRecipe> createNewCachedRecipe(@NotNull RadiationIrradiatingRecipe recipe, int cacheIndex) {
        CachedRecipe<RadiationIrradiatingRecipe> cachedRecipe;
        if (recipe.perTickUsage()) {
            cachedRecipe = MSItemStackConstantChemicalToObjectCachedRecipe.radiationIrradiating(recipe, recheckAllRecipeErrors, itemInputHandler, gasInputHandler,
                    injectUsageMultiplier, used -> usedSoFar = used, outputHandler);
        } else {
            cachedRecipe = MSTwoInputCachedRecipe.itemChemicalToChemical(recipe, recheckAllRecipeErrors, itemInputHandler, gasInputHandler, outputHandler);
        }
        return cachedRecipe
                .setErrorsChanged(this::onErrorsChanged)
                .setCanHolderFunction(this::canFunction)
                .setActive(this::setActive)
                .setEnergyRequirements(energyContainer::getEnergyPerTick, energyContainer)
                .setRequiredTicks(this::getTicksRequired)
                .setOnFinish(this::markForSave)
                .setOperatingTicksChanged(this::setOperatingTicks);
    }

    @Override
    public void recalculateUpgrades(Upgrade upgrade) {
        super.recalculateUpgrades(upgrade);
        if (upgrade == Upgrade.CHEMICAL || upgrade == Upgrade.SPEED) {
            injectUsage = MekanismUtils.getGasPerTickMeanMultiplier(this);
        }
    }

    public MachineEnergyContainer<TileEntityRadiationIrradiator> getEnergyContainer() {
        return energyContainer;
    }

    @Override
    public long getSavedUsedSoFar(int cacheIndex) {
        return usedSoFar;
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag nbt, @NotNull HolderLookup.Provider provider) {
        super.loadAdditional(nbt, provider);
        usedSoFar = nbt.getLong(SerializationConstants.USED_SO_FAR);
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag nbtTags, @NotNull HolderLookup.Provider provider) {
        super.saveAdditional(nbtTags, provider);
        nbtTags.putLong(SerializationConstants.USED_SO_FAR, usedSoFar);
    }

    //Methods relating to IComputerTile
    @ComputerMethod(methodDescription = ComputerConstants.DESCRIPTION_GET_ENERGY_USAGE)
    long getEnergyUsage() {
        return getActive() ? energyContainer.getEnergyPerTick() : 0L;
    }

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerChemicalTankWrapper.class, methodNames = {"getOutput", "getOutputCapacity", "getOutputNeeded",
            "getOutputFilledPercentage"}, docPlaceholder = "output tank")
    IChemicalTank getOutputTank() {
        return outputTank;
    }
}