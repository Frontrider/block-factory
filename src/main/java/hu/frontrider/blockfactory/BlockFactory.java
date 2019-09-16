package hu.frontrider.blockfactory;

import hu.frontrider.blockfactory.content.block.TemplatedBlock;
import hu.frontrider.blockfactory.content.TemplatedBow;
import hu.frontrider.blockfactory.content.TemplatedItem;
import hu.frontrider.blockfactory.content.TemplatedShield;
import hu.frontrider.blockfactory.content.block.TemplatedFence;
import hu.frontrider.blockfactory.content.block.TemplatedSlab;
import hu.frontrider.blockfactory.content.block.TemplatedStairs;
import hu.frontrider.blockfactory.templateprovider.BlockTemplateProvider;
import hu.frontrider.blockfactory.templateprovider.ItemTemplateProvider;
import hu.frontrider.blockfactory.templates.BlockTemplate;
import hu.frontrider.blockfactory.templates.ItemTemplate;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;
import java.util.ServiceLoader;

public class BlockFactory implements ModInitializer {

    private ServiceLoader<BlockTemplateProvider> blockTemplateProviders = ServiceLoader.load(BlockTemplateProvider.class);
    private ServiceLoader<ItemTemplateProvider> itemTemplateProviders = ServiceLoader.load(ItemTemplateProvider.class);


    @Override
    public void onInitialize() {
        blockTemplateProviders.iterator().forEachRemaining(templateProviders -> {
            for (Map.Entry<Identifier, BlockTemplate> templateEntry : templateProviders.getTemplates().entrySet()) {
                BlockTemplate blockTemplate = templateEntry.getValue();
                Identifier identifier = templateEntry.getKey();
                Block block;

                switch (blockTemplate.getType()) {
                    case FENCE:
                        block = Registry.register(Registry.BLOCK, identifier, new TemplatedFence(blockTemplate));
                        if (blockTemplate.hasItem()) {
                            Registry.register(Registry.ITEM, identifier, new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
                        }
                        break;

                    case SLAB:
                        block = Registry.register(Registry.BLOCK, identifier, new TemplatedSlab(blockTemplate));
                        if (blockTemplate.hasItem()) {
                            Registry.register(Registry.ITEM, identifier, new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
                        }
                        break;

                    case STAIRS:
                        block = Registry.register(Registry.BLOCK, identifier, new TemplatedStairs(blockTemplate));
                        if (blockTemplate.hasItem()) {
                            Registry.register(Registry.ITEM, identifier, new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
                        }
                        break;

                    default:
                        block = Registry.register(Registry.BLOCK, identifier, new TemplatedBlock(blockTemplate));
                        if (blockTemplate.hasItem()) {
                            Registry.register(Registry.ITEM, identifier, new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
                        }
                        break;
                }

            }
        });

        itemTemplateProviders.iterator().forEachRemaining(templateProviders -> {
            for (Map.Entry<Identifier, ItemTemplate> templateEntry : templateProviders.getTemplates().entrySet()) {
                ItemTemplate itemTemplate = templateEntry.getValue();

                Registry.register(Registry.ITEM, templateEntry.getKey(), new TemplatedItem(itemTemplate));
            }
        });
    }
}
