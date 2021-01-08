package net.nicguzzo.wpbmod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraftforge.common.ToolType;

public class WitherProofGlass extends GlassBlock {
    private static final float hardness = 50.0f;
    private static final float resistance = 2000.0f;
    public WitherProofGlass() {
        super(
            Block.Properties.from(Blocks.GLASS)												
                .setAllowsSpawn((state, world, pos, type) -> false)
                .setOpaque((state,reader,pos)-> false)             
                .setSuffocates((state,reader,pos)-> false)
                .setBlocksVision((state,reader,pos)-> false)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(3)
                .hardnessAndResistance(hardness, resistance)
            );
       
    }    
}