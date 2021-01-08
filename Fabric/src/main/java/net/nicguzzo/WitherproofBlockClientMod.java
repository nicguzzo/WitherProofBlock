package net.nicguzzo;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class WitherproofBlockClientMod implements ClientModInitializer {
    @Override
	public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(WitherProofBlockMod.WITHERPROOF_GLASS, RenderLayer.getTranslucent());
        //BlockRenderLayerMap.INSTANCE.putBlock(WitherProofBlockMod.WITHERPROOF_GLASS, RenderLayer.getCutout());
    }
}