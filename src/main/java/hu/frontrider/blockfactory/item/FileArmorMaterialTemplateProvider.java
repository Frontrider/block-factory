package hu.frontrider.blockfactory.item;

import com.google.gson.Gson;
import hu.frontrider.blockfactory.core.templates.impl.DefaultArmormaterialTemplate;
import hu.frontrider.blockfactory.core.util.DirectoryManager;
import hu.frontrider.blockfactory.core.util.FileTemplateHelper;
import hu.frontrider.blockfactory.core.templates.provider.ArmorMaterialTemplateProvider;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.util.Identifier;

import java.io.FileReader;
import java.util.Map;

/**
 * reads json files from the run folder.
 */
public class FileArmorMaterialTemplateProvider implements ArmorMaterialTemplateProvider {
    private Gson gson = new Gson();

    @Override
    public Map<Identifier, ArmorMaterial> getTemplates() {
        return new FileTemplateHelper<ArmorMaterial>(
                (file)-> gson.fromJson(new FileReader(file), DefaultArmormaterialTemplate.class),
                DirectoryManager.getINSTANCE().getArmorMaterialFolderFolder()
        ).getTemplates();
    }
}
