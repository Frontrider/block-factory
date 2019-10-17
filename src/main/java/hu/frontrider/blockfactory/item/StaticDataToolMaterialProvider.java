package hu.frontrider.blockfactory.item;

import com.google.gson.Gson;
import hu.frontrider.blockfactory.core.util.StaticDataTemplateHelper;
import hu.frontrider.blockfactory.core.templates.provider.ToolMaterialTemplateProvider;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

import java.util.Map;

public class StaticDataToolMaterialProvider implements ToolMaterialTemplateProvider {
    @Override
    public Map<Identifier, ToolMaterial> getTemplates() {
        return new StaticDataTemplateHelper<>(
                bufferedReader -> new Gson().fromJson(bufferedReader, ToolMaterial.class),
                "block_factory/tool_materials")
                .getElements();
    }
}
