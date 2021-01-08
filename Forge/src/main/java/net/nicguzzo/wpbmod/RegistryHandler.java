package net.nicguzzo.wpbmod;

//import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
//import net.minecraft.block.SoundType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

//import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    // create DeferredRegister objects
    
   public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WPBMod.MODID);
   public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WPBMod.MODID);

    public static void init() {
        // attach DeferredRegisters to the event bus
       BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
       ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

   // register block
   public static final RegistryObject<Block> WPB = BLOCKS.register("witherproofblock", () ->
        new WitherProofBlock()
   );
   public static final RegistryObject<Block> WPBGLASS = BLOCKS.register("witherproofglass", () ->
        new WitherProofGlass()
   );
   public static final RegistryObject<Item> WPB_ITEM = ITEMS.register("witherproofblock", () ->
        new BlockItem(
                WPB.get(),
                new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
        )
   );
   public static final RegistryObject<Item> WPBGLASS_ITEM = ITEMS.register("witherproofglass", () ->
        new BlockItem(
                WPBGLASS.get(),
                new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
        )
   );
}