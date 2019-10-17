package hu.frontrider.blockfactory.data;

import net.minecraft.block.BlockRenderLayer;

public enum BlockRendering {
    SOLID(BlockRenderLayer.SOLID),
    CUTOUT_MIPPED(BlockRenderLayer.CUTOUT_MIPPED),
    CUTOUT(BlockRenderLayer.CUTOUT),
    TRANSLUCENT(BlockRenderLayer.TRANSLUCENT);

    private final BlockRenderLayer renderLayer;


    BlockRendering(BlockRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }

    public BlockRenderLayer getRenderLayer() {
        return renderLayer;
    }
}
