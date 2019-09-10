package hu.frontrider.blockfactory.content;

import hu.frontrider.blockfactory.templates.ItemTemplate;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;

public class TemplatedBow extends BowItem {
    public TemplatedBow(ItemTemplate template) {
        super(new Settings().maxCount(template.maxCount()));
    }
}
