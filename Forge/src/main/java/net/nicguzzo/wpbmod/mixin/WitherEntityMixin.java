package net.nicguzzo.wpbmod.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.boss.WitherEntity;
import net.nicguzzo.wpbmod.WitherProofBlock;
import net.nicguzzo.wpbmod.WitherProofGlass;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


@Mixin(WitherEntity.class)
public abstract class WitherEntityMixin {
	//private static final Logger LOGGER = LogManager.getLogger();
	
	@Inject(at = @At("HEAD"), method = "canDestroyBlock", cancellable = true)
	private static void canDestroyBlock(BlockState block,CallbackInfoReturnable<Boolean>  cir) {
		//System.out.println("block!: "+block.getBlock().toString());
		
		if( (block.getBlock() instanceof WitherProofBlock) || (block.getBlock() instanceof WitherProofGlass))
			//LOGGER.info("canDestroyBlock??? "+block.getBlock().toString());
			cir.setReturnValue(false);
	}
	
}
