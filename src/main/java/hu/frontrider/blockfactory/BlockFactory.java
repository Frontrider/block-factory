package hu.frontrider.blockfactory;

import hu.frontrider.blockfactory.core.templates.BlockTemplate;
import hu.frontrider.blockfactory.core.templates.ItemTemplate;
import hu.frontrider.blockfactory.core.templates.initializers.BlockTemplateInitializer;
import hu.frontrider.blockfactory.core.templates.initializers.ItemTemplateInitializer;
import hu.frontrider.blockfactory.core.templates.provider.ArmorMaterialTemplateProvider;
import hu.frontrider.blockfactory.core.templates.provider.BlockTemplateProvider;
import hu.frontrider.blockfactory.core.templates.provider.ItemTemplateProvider;
import hu.frontrider.blockfactory.core.templates.provider.ToolMaterialTemplateProvider;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

public class BlockFactory implements ModInitializer {

    private ServiceLoader<BlockTemplateProvider> blockTemplateProviders = ServiceLoader.load(BlockTemplateProvider.class);
    private ServiceLoader<BlockTemplateInitializer> blockTemplateInitializers = ServiceLoader.load(BlockTemplateInitializer.class);
    private ServiceLoader<ItemTemplateProvider> itemTemplateProviders = ServiceLoader.load(ItemTemplateProvider.class);
    private ServiceLoader<ItemTemplateInitializer> itemTemplateInitializers = ServiceLoader.load(ItemTemplateInitializer.class);
    private ServiceLoader<ArmorMaterialTemplateProvider> armorMaterialTemplateProviders = ServiceLoader.load(ArmorMaterialTemplateProvider.class);
    private ServiceLoader<ToolMaterialTemplateProvider> templateProviders = ServiceLoader.load(ToolMaterialTemplateProvider.class);

    private static List<Pair<BlockTemplate,Block>> blocks = new LinkedList<>();
    private static List<Pair<ItemTemplate,Item>> items = new LinkedList<>();

    public static List<Pair<BlockTemplate, Block>> getBlocks() {
        return blocks;
    }

    public static List<Pair<ItemTemplate, Item>> getItems() {
        return items;
    }

    @Override
    public void onInitialize() {
        LinkedList<BlockTemplateInitializer> blockinitializers = new LinkedList<>();
        blockTemplateInitializers.iterator().forEachRemaining(blockinitializers::add);

        blockTemplateProviders.iterator().forEachRemaining(templateProviders -> {
            for (Map.Entry<Identifier, BlockTemplate> templateEntry : templateProviders.getTemplates().entrySet()) {
                BlockTemplate blockTemplate = templateEntry.getValue();
                Identifier identifier = templateEntry.getKey();
                //initialize the template for all of the valid types.
                for (BlockTemplateInitializer blockinitializer : blockinitializers) {
                    if (blockinitializer.isValid(blockTemplate.getType())) {
                        blocks.add(new ImmutablePair<>(blockTemplate,blockinitializer.initialize(blockTemplate, identifier)));
                    }
                }
            }
        });

        LinkedList<ItemTemplateInitializer> itemInitializers = new LinkedList<>();
        itemTemplateInitializers.iterator().forEachRemaining(itemInitializers::add);

        LinkedList<ToolMaterialTemplateProvider> toolMaterialTemplateProviders = new LinkedList<>();
        templateProviders.iterator().forEachRemaining(toolMaterialTemplateProviders::add);


        //TODO: sort out this mess!!
        itemTemplateProviders.iterator().forEachRemaining(templateProviders -> {
            for (Map.Entry<Identifier, ItemTemplate> templateEntry : templateProviders.getTemplates().entrySet()) {
                ItemTemplate itemTemplate = templateEntry.getValue();
                for (ItemTemplateInitializer itemInitializer : itemInitializers) {

                    if (itemInitializer.itemType() != ItemTemplateInitializer.ItemType.NORMAL) {
                        if (itemInitializer.itemType() == ItemTemplateInitializer.ItemType.TOOL) {
                            for (ToolMaterialTemplateProvider toolMaterialTemplateProvider : toolMaterialTemplateProviders) {
                                toolMaterialTemplateProvider.getTemplates().forEach((identifier, toolMaterial) -> {
                                    if (itemInitializer.isValid(itemTemplate, identifier)) {
                                        List<Item> initialize = itemInitializer.initialize(itemTemplate, toolMaterial, null, templateEntry.getKey());
                                        for (Item item : initialize) {
                                            items.add(new ImmutablePair<>(itemTemplate,item));
                                        }
                                    }
                                });

                            }
                        } else {
                            for (ArmorMaterialTemplateProvider armorMaterialTemplateProvider : armorMaterialTemplateProviders) {
                                armorMaterialTemplateProvider.getTemplates().forEach((identifier, armorMaterial) -> {
                                    if (itemInitializer.isValid(itemTemplate, identifier)) {
                                        List<Item> initialize = itemInitializer.initialize(itemTemplate, null, armorMaterial, templateEntry.getKey());
                                        for (Item item : initialize) {
                                            items.add(new ImmutablePair<>(itemTemplate,item));
                                        }                                    }
                                });
                            }
                        }
                    } else {
                        if (itemInitializer.isValid(itemTemplate, null)) {
                            List<Item> initialize = itemInitializer.initialize(itemTemplate, null, null, templateEntry.getKey());
                            for (Item item : initialize) {
                                items.add(new ImmutablePair<>(itemTemplate,item));
                            }
                        }
                    }
                }
            }
        });
    }
}
