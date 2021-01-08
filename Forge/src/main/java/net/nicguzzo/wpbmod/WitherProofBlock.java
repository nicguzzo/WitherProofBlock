package net.nicguzzo.wpbmod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraftforge.common.ToolType;


public class WitherProofBlock extends Block {

    private static final float hardness = 50.0f;
    private static final float resistance = 2000.0f;

    public WitherProofBlock() {
        super(
            Block.Properties
                           .create(Material.ROCK)
                           .hardnessAndResistance(hardness, resistance)
                           .sound(SoundType.STONE)
                           .harvestLevel(3)
                           .harvestTool(ToolType.PICKAXE));
    }
    
}