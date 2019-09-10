package hu.frontrider.blockfactory;

import hu.frontrider.blockfactory.content.TemplatedBlock;
import hu.frontrider.blockfactory.content.TemplatedBow;
import hu.frontrider.blockfactory.content.TemplatedItem;
import hu.frontrider.blockfactory.content.TemplatedShield;
import hu.frontrider.blockfactory.templateprovider.BlockTemplateProvider;
import hu.frontrider.blockfactory.templateprovider.ItemTemplateProvider;
import hu.frontrider.blockfactory.templates.BlockTemplate;
import hu.frontrider.blockfactory.templates.ItemTemplate;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
                registerItemBlock(templateEntry.getKey(), templateEntry.getValue());
            }
        });

        itemTemplateProviders.iterator().forEachRemaining(templateProviders -> {
            for (Map.Entry<Identifier, ItemTemplate> templateEntry : templateProviders.getTemplates().entrySet()) {
                ItemTemplate itemTemplate = templateEntry.getValue();
                switch (itemTemplate.getType()) {
                    case SHIELD:
                        Registry.register(Registry.ITEM, templateEntry.getKey(), new TemplatedShield(itemTemplate));
                    case BOW:
                        Registry.register(Registry.ITEM, templateEntry.getKey(), new TemplatedBow(itemTemplate));
                    default:
                        Registry.register(Registry.ITEM, templateEntry.getKey(), new TemplatedItem(itemTemplate));
                }
            }
        });
    }

    private void registerItemBlock(Identifier identifier, BlockTemplate template) {
        Block block = registerBlock(identifier, template);
        if (template.hasItem())
            Registry.register(Registry.ITEM, identifier, new BlockItem(block, new Item.Settings()));
    }

    private Block registerBlock(Identifier identifier, BlockTemplate template) {
        return Registry.register(Registry.BLOCK, identifier, new TemplatedBlock(template));
    }
}
