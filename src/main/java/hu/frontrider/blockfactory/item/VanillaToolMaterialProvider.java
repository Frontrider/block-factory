package hu.frontrider.blockfactory.item;

import hu.frontrider.blockfactory.core.templates.provider.ToolMaterialTemplateProvider;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class VanillaToolMaterialProvider implements ToolMaterialTemplateProvider {

    @Override
    public Map<Identifier, ToolMaterial> getTemplates() {
        HashMap<Identifier, ToolMaterial> materials = new HashMap<>();
        materials.put(new Identifier("iron"), ToolMaterials.IRON);
        materials.put(new Identifier("wood"), ToolMaterials.WOOD);
        materials.put(new Identifier("stone"), ToolMaterials.STONE);
        materials.put(new Identifier("gold"), ToolMaterials.GOLD);
        materials.put(new Identifier("diamond"), ToolMaterials.DIAMOND);
        return materials;
    }
}
