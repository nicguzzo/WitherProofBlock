package net.nicguzzo.wpbmod;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.world.ExplosionEvent.Detonate;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MyForgeEventHandler {
    /*@SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        System.out.println("Item picked up!");
    }*/
    @SubscribeEvent
    public void onExplosionEvent(Detonate event) {
        //System.out.println("ExplosionEvent! "+event.getExplosion().getSourceMob() );
        Level level=event.getWorld();
        if(event.getExplosion().getSourceMob() instanceof WitherBoss){
            //System.out.println("ExplosionEvent WitherBoss!");
            List<BlockPos> list=event.getAffectedBlocks();
            List<BlockPos> remove=new ArrayList<>();
            for (BlockPos pos : list) {
                BlockState bs=level.getBlockState(pos);
                //System.out.println("ExplosionEvent "+bs);
                if(bs!=null){
                    Block blk=bs.getBlock();
                    if(blk!=null && (blk instanceof WitherProofBlock || blk instanceof WitherProofGlass)){
                        System.out.println("removibd "+blk+" from explosion");
                        remove.add(pos);
                    }
                }
            }
            list.removeAll(remove);
        }
    }
    /*@SubscribeEvent
    public void onProjectileImpactEvent(ProjectileImpactEvent<Projectile> event) {
        Projectile p=event.getProjectile();
        if(p instanceof WitherSkull){
            System.out.println("WitherSkull projectile!");
            HitResult hitresult=event.getRayTraceResult();            
            if(hitresult.getType()==HitResult.Type.BLOCK && hitresult instanceof BlockHitResult){
                System.out.println("WitherSkull projectile hit a block!");
                BlockHitResult block_hit = (BlockHitResult) hitresult;
                Level level=event.getEntity().level;
                BlockState bs=level.getBlockState(block_hit.getBlockPos());
                if(bs!=null){
                    Block blk=bs.getBlock();
                    if(blk!=null && (blk instanceof WitherProofBlock || blk instanceof WitherProofGlass)){
                        System.out.println("WitherSkull projectile wpblock!");
                        event.setCanceled(true);
                    }
                }
            }
            
        }
    }*/
    /*@SubscribeEvent
    public void onEntityEvent(LivingEvent event) {
        //LOGGER.info("onEntityEvent"+event);
        LivingEntity entity=event.getEntityLiving();
        //if(entity!=null && entity instanceof WitherBoss){
            //System.out.println("onEntityEvent"+event);
        //}
    }*/
}
