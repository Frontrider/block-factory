package hu.frontrider.blockfactory.item;

import hu.frontrider.blockfactory.core.templates.provider.ArmorMaterialTemplateProvider;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class VanillaArmorMaterialProvider implements ArmorMaterialTemplateProvider {

    @Override
    public Map<Identifier, ArmorMaterial> getTemplates() {
        HashMap<Identifier, ArmorMaterial> materials = new HashMap<>();
        materials.put(new Identifier("iron"), ArmorMaterials.LEATHER);
        materials.put(new Identifier("chain"), ArmorMaterials.CHAIN);
        materials.put(new Identifier("turtle"), ArmorMaterials.TURTLE);
        materials.put(new Identifier("gold"), ArmorMaterials.GOLD);
        materials.put(new Identifier("diamond"), ArmorMaterials.DIAMOND);
        return materials;
    }
}
