package hu.frontrider.blockfactory.content;

import hu.frontrider.blockfactory.templates.ItemTemplate;
import net.minecraft.item.BowItem;
import net.minecraft.item.ShieldItem;

public class TemplatedShield extends ShieldItem {
    public TemplatedShield(ItemTemplate template) {
        super(new Settings().maxCount(template.maxCount()));
    }
}
