package net.nicguzzo.wpbmod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;


public class WitherProofBlock extends Block {

    private static final float hardness = 50.0f;
    private static final float resistance = 2000.0f;

    public WitherProofBlock() {
        super(
            Block.Properties
                           .of(Material.STONE)
                           .strength(hardness, resistance)
                           .sound(SoundType.STONE)
                           .harvestLevel(3)
                           .harvestTool(ToolType.PICKAXE));
    }
    
}