package net.nicguzzo.wpbmod;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.world.ExplosionEvent.Detonate;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyForgeEventHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    @SubscribeEvent
    public void onEntityDestroyBlock(LivingDestroyBlockEvent event) {
        if(event.getEntity() instanceof WitherBoss || event.getEntity() instanceof WitherSkull) {
            BlockState bs = event.getState();
            if (bs != null) {
                Block blk = bs.getBlock();
                if (blk != null && (blk instanceof WitherProofBlock || blk instanceof WitherProofGlass)) {
                    event.setCanceled(true);
                }
            }
        }
    }
    @SubscribeEvent
    public void onExplosionEvent(Detonate event) {
        Level level=event.getWorld();
        Entity entity=event.getExplosion().getExploder();
        if( (entity instanceof WitherBoss) || (entity instanceof WitherSkull) ){
            List<BlockPos> list=event.getAffectedBlocks();
            List<BlockPos> remove=new ArrayList<>();
            for (BlockPos pos : list) {
                BlockState bs=level.getBlockState(pos);
                if(bs!=null){
                    Block blk=bs.getBlock();
                    if(blk!=null && (blk instanceof WitherProofBlock || blk instanceof WitherProofGlass)){
                        remove.add(pos);
                    }
                }
            }
            list.removeAll(remove);
        }
    }
    
}
