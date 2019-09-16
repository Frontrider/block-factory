package hu.frontrider.blockfactory.content.block;

import hu.frontrider.blockfactory.templates.BlockTemplate;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.function.Supplier;

/**
 * Block that takes the block template and builds up itself from it.
 * */
public class TemplatedBlock extends Block {
    private final BlockTemplate template;

    public TemplatedBlock(BlockTemplate template) {
        //ugly trick to run code before the super happens, so I can keep this code contained.
        super(
                ((Supplier<Settings>) () -> {
                    FabricBlockSettings blockSettings = FabricBlockSettings
                            .of(template.getMaterial().getMaterial())
                            .lightLevel(template.getLightLevel())
                            .collidable(template.isCollideable())
                            .hardness(template.getHardness())
                            ;
                    return blockSettings.build();
                }).get()
        );
        this.template = template;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return template.getRenderLayer();
    }

    @Override
    public boolean hasRandomTicks(BlockState blockState_1) {
        return template.ticksRandomly();
    }

    @Override
    public boolean isAir(BlockState blockState_1) {
        return template.isAir();
    }

    @Override
    public boolean allowsSpawning(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityType<?> entityType_1) {
        return template.canSpawnMobs();
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState_1) {
        if(template.isInvisible()){
            return BlockRenderType.INVISIBLE;
        }
        return super.getRenderType(blockState_1);
    }
}
