package hu.frontrider.blockfactory.block;

import com.google.gson.Gson;
import hu.frontrider.blockfactory.core.util.DirectoryManager;
import hu.frontrider.blockfactory.core.util.FileTemplateHelper;
import hu.frontrider.blockfactory.core.templates.provider.BlockTemplateProvider;
import hu.frontrider.blockfactory.core.templates.BlockTemplate;
import hu.frontrider.blockfactory.core.templates.impl.DefaultBlockTemplate;
import net.minecraft.util.Identifier;

import java.io.FileReader;
import java.util.Map;

/**
 * reads json files from the run folder.
 */
public class FileBlockTemplateProvider implements BlockTemplateProvider {
    private Gson gson = new Gson();

    @Override
    public Map<Identifier, BlockTemplate> getTemplates() {
        return new FileTemplateHelper<BlockTemplate>(
                (file)-> gson.fromJson(new FileReader(file), DefaultBlockTemplate.class),
                DirectoryManager.getINSTANCE().getBlockFolder()
        ).getTemplates();
    }
}
