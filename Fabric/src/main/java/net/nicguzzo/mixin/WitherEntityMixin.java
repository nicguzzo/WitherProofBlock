package net.nicguzzo.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.boss.WitherEntity;
import net.nicguzzo.WitherProofBlock;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WitherEntity.class)
public abstract class WitherEntityMixin {
	
	@Inject(at = @At("HEAD"), method = "canDestroy", cancellable = true)
	private static void canDestroy(BlockState block,CallbackInfoReturnable<Boolean>  cir) {
		//System.out.println("block!: "+block.getBlock().toString());
		if(block.getBlock() instanceof WitherProofBlock)
			cir.setReturnValue(false);
	}
	
}
