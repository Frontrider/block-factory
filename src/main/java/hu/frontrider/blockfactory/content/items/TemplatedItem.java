package hu.frontrider.blockfactory.content.items;

import hu.frontrider.blockfactory.templates.ItemTemplate;
import net.minecraft.item.Item;

public class TemplatedItem extends Item {
    public TemplatedItem(ItemTemplate template) {
        super(new Settings().maxCount(template.maxCount()));
    }
}
