package net.nicguzzo;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WitherProofBlockMod implements ModInitializer {

	public static final Block WITHERPROOF_BLOCK = new WitherProofBlock();
	public static final Block WITHERPROOF_GLASS = new WitherProofGlass();

	@Override
	public void onInitialize() {
		
		Registry.register(Registry.BLOCK, new Identifier("wither_proof_block", "witherproofblock"), WITHERPROOF_BLOCK);
		Registry.register(Registry.ITEM , new Identifier("wither_proof_block", "witherproofblock"), new BlockItem(WITHERPROOF_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("wither_proof_block", "witherproofglass"), WITHERPROOF_GLASS);
		Registry.register(Registry.ITEM , new Identifier("wither_proof_block", "witherproofglass"), new BlockItem(WITHERPROOF_GLASS, new Item.Settings().group(ItemGroup.MISC)));
		
	}
}
