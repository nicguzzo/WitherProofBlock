package net.nicguzzo;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings ;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;


public class WitherProofBlock extends Block {

    private static final float hardness = 50.0f;
    private static final float resistance = 2000.0f;

    public WitherProofBlock() {
        super(
            FabricBlockSettings.of(Material.STONE)
            .breakByHand(false)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .sounds(BlockSoundGroup.STONE)
            .strength(hardness, resistance));
        
    }
    
}