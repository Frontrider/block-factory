package hu.frontrider.blockfactory.item.templates;

import hu.frontrider.blockfactory.core.templates.ItemTemplate;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

import java.util.Collections;

public class TemplatedItem extends Item {
    public TemplatedItem(ItemTemplate template) {
        super(new Settings().maxCount(template.maxCount()));
    }

    @Override
    public boolean isFood() {
        return super.isFood();
    }

    @Override
    public FoodComponent getFoodComponent() {
        return super.getFoodComponent();
    }
}
