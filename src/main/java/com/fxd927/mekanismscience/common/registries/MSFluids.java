package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.gas.MSChemicalConstants;
import mekanism.common.registration.impl.FluidDeferredRegister;
import mekanism.common.registration.impl.FluidRegistryObject;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class MSFluids {
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(MekanismScience.MODID);

    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> AMMONIA = FLUIDS.registerLiquidChemical(MSChemicalConstants.AMMONIA);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> AMMONIUM_NITRATE = FLUIDS.registerLiquidChemical(MSChemicalConstants.AMMONIUM_NITRATE);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> BARIUM = FLUIDS.registerLiquidChemical(MSChemicalConstants.BARIUM);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> BARIUM_SULFATE = FLUIDS.registerLiquidChemical(MSChemicalConstants.BARIUM_SULFATE);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> BENZODIAZEPINE = FLUIDS.registerLiquidChemical(MSChemicalConstants.BENZODIAZEPINE);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> BERYLLIUM = FLUIDS.registerLiquidChemical(MSChemicalConstants.BERYLLIUM);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> BROMINE = FLUIDS.registerLiquidChemical(MSChemicalConstants.BROMINE);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> CHLOROMETHANE = FLUIDS.registerLiquidChemical(MSChemicalConstants.CHLOROMETHANE);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> CONCENTRATED_SEAWATER = FLUIDS.registerLiquidChemical(MSChemicalConstants.CONCENTRATED_SEAWATER);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> ETHANOL = FLUIDS.registerLiquidChemical(MSChemicalConstants.ETHANOL);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> HELIUM = FLUIDS.registerLiquidChemical(MSChemicalConstants.HELIUM);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> SUPERHEATED_HELIUM = FLUIDS.registerLiquidChemical(MSChemicalConstants.SUPERHEATED_HELIUM);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> IODINE = FLUIDS.registerLiquidChemical(MSChemicalConstants.IODINE);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> LACTOSE = FLUIDS.registerLiquidChemical(MSChemicalConstants.LACTOSE);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> NITRIC_ACID = FLUIDS.registerLiquidChemical(MSChemicalConstants.NITRIC_ACID);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> NITROGEN = FLUIDS.registerLiquidChemical(MSChemicalConstants.NITROGEN);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> NITROGEN_DIOXIDE = FLUIDS.registerLiquidChemical(MSChemicalConstants.NITROGEN_DIOXIDE);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> NITROGEN_OXIDE = FLUIDS.registerLiquidChemical(MSChemicalConstants.NITROGEN_OXIDE);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> METHANOL = FLUIDS.registerLiquidChemical(MSChemicalConstants.METHANOL);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> METHYLAMINE = FLUIDS.registerLiquidChemical(MSChemicalConstants.METHYLAMINE);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> METHYLAMMONIUM_LEAD_IODIDE = FLUIDS.registerLiquidChemical(MSChemicalConstants.METHYLAMMONIUM_LEAD_IODIDE);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> MILK = FLUIDS.registerLiquidChemical(MSChemicalConstants.MILK);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> POTASSIUM = FLUIDS.registerLiquidChemical(MSChemicalConstants.POTASSIUM);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> POTASSIUM_IODIDE = FLUIDS.registerLiquidChemical(MSChemicalConstants.POTASSIUM_IODIDE);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> SEAWATER = FLUIDS.registerLiquidChemical(MSChemicalConstants.SEAWATER);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> STRONTIUM = FLUIDS.registerLiquidChemical(MSChemicalConstants.STRONTIUM);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> TETRODOTOXIN = FLUIDS.registerLiquidChemical(MSChemicalConstants.TETRODOTOXIN);
    //public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> WHEY = FLUIDS.registerLiquidChemical(MSChemicalConstants.WHEY);
    public static final FluidRegistryObject<FluidDeferredRegister.MekanismFluidType, ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing, LiquidBlock, BucketItem> YTTRIUM = FLUIDS.registerLiquidChemical(MSChemicalConstants.YTTRIUM);

    private MSFluids(){
    }
}
