package hu.frontrider.blockfactory.item;

import com.google.gson.Gson;
import hu.frontrider.blockfactory.core.util.StaticDataTemplateHelper;
import hu.frontrider.blockfactory.core.templates.provider.ArmorMaterialTemplateProvider;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.util.Identifier;

import java.util.Map;

public class StaticDataArmorMaterialProvider implements ArmorMaterialTemplateProvider {
    @Override
    public Map<Identifier, ArmorMaterial> getTemplates() {
        return new StaticDataTemplateHelper<>(
                bufferedReader -> new Gson().fromJson(bufferedReader, ArmorMaterial.class),
                "block_factory/armor_materials")
                .getElements();
    }
}
