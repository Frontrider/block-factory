package hu.frontrider.blockfactory.block.initializers;

import hu.frontrider.blockfactory.block.templates.TemplatedBlock;
import hu.frontrider.blockfactory.core.templates.BlockTemplate;
import hu.frontrider.blockfactory.core.templates.initializers.BlockTemplateInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class BlockInitializer implements BlockTemplateInitializer {
    @Override
    public Block initialize(BlockTemplate template, Identifier identifier) {
        Block block = Registry.register(Registry.BLOCK, identifier, new TemplatedBlock(template));

        if (template.hasItem()) {
            Registry.register(Registry.ITEM, identifier, new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        }
        return block;
    }

    @Override
    public boolean isValid(List<String> types) {
        return types.contains("normal");
    }
}
