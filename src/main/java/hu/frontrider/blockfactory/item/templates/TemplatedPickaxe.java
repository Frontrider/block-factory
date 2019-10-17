package hu.frontrider.blockfactory.item.templates;

import hu.frontrider.blockfactory.core.templates.ItemTemplate;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class TemplatedPickaxe extends PickaxeItem {
    public TemplatedPickaxe(ToolMaterial material,ItemTemplate template) {
        super(material,0,3,new Settings().maxCount(template.maxCount()));
    }
}
