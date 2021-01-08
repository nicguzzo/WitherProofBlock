package net.nicguzzo;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings ;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;



public class WitherProofGlass extends GlassBlock {

    private static final float hardness = 50.0f;
    private static final float resistance = 2000.0f;

    public WitherProofGlass() {
        super(
            FabricBlockSettings.copyOf(Blocks.GLASS)
            .allowsSpawning((state, world, pos, type) -> false)
            .strength(hardness, resistance)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .nonOpaque()
            .blockVision((state,reader,pos)-> false)            
            );
        
    }
    
}