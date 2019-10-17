package hu.frontrider.blockfactory.item.templates;

import hu.frontrider.blockfactory.core.templates.ItemTemplate;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class TemplatedAxe extends AxeItem {
    public TemplatedAxe(ToolMaterial material, ItemTemplate template) {
        super(material,0,3,new Settings().maxCount(template.maxCount()));
    }
}