package hu.frontrider.blockfactory.client;

import hu.frontrider.blockfactory.BlockFactory;
import hu.frontrider.blockfactory.core.templates.BlockTemplate;
import hu.frontrider.blockfactory.core.templates.ItemTemplate;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.List;


public class Main implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        List<Block> coloredBlocks = new LinkedList<>();
        for (Pair<BlockTemplate, Block> block : BlockFactory.getBlocks()) {
            if (block.getKey().isColored())
                coloredBlocks.add(block.getValue());
        }
        ColorProviderRegistry.BLOCK.register((blockState, extendedBlockView, blockPos, i) -> ColorManager.getInstance().getColor(i, Registry.BLOCK.getId(blockState.getBlock()), ColorManager.Type.BLOCK),coloredBlocks.toArray(new Block[0]));

        List<Item> coloredItems = new LinkedList<>();
        for (Pair<ItemTemplate, Item> item : BlockFactory.getItems()) {
            if (item.getKey().isColored())
                coloredItems.add(item.getValue());
        }

        ColorProviderRegistry.ITEM.register((itemStack, i) -> ColorManager.getInstance().getColor(i, Registry.ITEM.getId(itemStack.getItem()), ColorManager.Type.ITEM),coloredItems.toArray(new Item[0]));
    }
}
