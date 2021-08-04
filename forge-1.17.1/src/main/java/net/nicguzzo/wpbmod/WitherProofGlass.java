package net.nicguzzo.wpbmod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;

public class WitherProofGlass extends GlassBlock {
    private static final float hardness = 50.0f;
    private static final float resistance = 2000.0f;
    public WitherProofGlass() {
        super(
            Properties.of(Material.GLASS)
                .strength(hardness, resistance)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isValidSpawn((state, world, pos, type) -> false)
                .isRedstoneConductor((state, world, pos) -> false)
                .isSuffocating((state, world, pos) -> false)
                .isViewBlocking((state, world, pos) -> false)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
        );
    }
    
}