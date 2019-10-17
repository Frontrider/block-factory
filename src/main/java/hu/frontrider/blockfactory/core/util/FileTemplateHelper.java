package hu.frontrider.blockfactory.core.util;

import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileTemplateHelper<T> {

    private final TemplateFunction<T> templateCreator;
    private final List<File> rootFolder;

    public FileTemplateHelper(TemplateFunction<T> templateCreator, List<File> rootFolder) {
        this.templateCreator = templateCreator;
        this.rootFolder = rootFolder;
    }


    public Map<Identifier, T> getTemplates() {

        Map<Identifier, T> result = new HashMap<>();

        for (File namespaceRoot : rootFolder) {
            String namespace = namespaceRoot.getParentFile().getName();
            String[] files = namespaceRoot.list();
            if (files != null) {
                for (String childFile : files) {
                    File templateFile = new File(namespaceRoot.getAbsolutePath() + "/" + childFile);
                    String path = templateFile.getAbsolutePath().split(namespace, 2)[1].replace(".json", "").replaceFirst("^/\\w*/", "");
                    try {
                        result.put(new Identifier(namespace.replaceAll(":",""), path), templateCreator.get(templateFile));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return result;
    }

    public interface TemplateFunction<T> {
        T get(File source) throws FileNotFoundException;
    }
}
