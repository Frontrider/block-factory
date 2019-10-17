package hu.frontrider.blockfactory.core.util;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class DirectoryManager {

    private static DirectoryManager INSTANCE = new DirectoryManager();

    private String rootFolder = "block-factory";
    private String blockFolder = "/blocks";
    private String itemFolder = "/items";
    private String toolMaterialFolder = "/tool_materials";
    private String armorMaterialFolder = "/armor_materials";

    private DirectoryManager() {
    }

    public static DirectoryManager getINSTANCE() {
        return INSTANCE;
    }

    public List<File> getBlockFolder() {
        createRoot();
        File file = new File(rootFolder);

        List<File> blockFolders = new LinkedList<>();

        if (file.exists()) {
            File[] namespaces = file.listFiles();
            if (namespaces != null)
                for (File namespace : namespaces) {
                    String namespaceAbsolutePath = namespace.getAbsolutePath();
                    blockFolders.add(new File(namespaceAbsolutePath+blockFolder));
                }
        }

        return blockFolders;
    }

    public List<File> getToolMaterialFolderFolder() {
        createRoot();
        File file = new File(rootFolder);

        List<File> blockFolders = new LinkedList<>();

        if (file.exists()) {
            File[] namespaces = file.listFiles();
            if (namespaces != null)
                for (File namespace : namespaces) {
                    String namespaceAbsolutePath = namespace.getAbsolutePath();
                    blockFolders.add(new File(namespaceAbsolutePath+toolMaterialFolder));
                }
        }

        return blockFolders;
    }

    public List<File> getArmorMaterialFolderFolder() {
        createRoot();
        File file = new File(rootFolder);

        List<File> blockFolders = new LinkedList<>();

        if (file.exists()) {
            File[] namespaces = file.listFiles();
            if (namespaces != null)
                for (File namespace : namespaces) {
                    String namespaceAbsolutePath = namespace.getAbsolutePath();
                    blockFolders.add(new File(namespaceAbsolutePath+armorMaterialFolder));
                }
        }

        return blockFolders;
    }

    public List<File> getItemFolder() {
        createRoot();
        File file = new File(rootFolder);

        List<File> blockFolders = new LinkedList<>();

        if (file.exists()) {
            File[] namespaces = file.listFiles();
            if (namespaces != null)
                for (File namespace : namespaces) {
                    String namespaceAbsolutePath = namespace.getAbsolutePath();
                    blockFolders.add(new File(namespaceAbsolutePath+itemFolder));
                }
        }

        return blockFolders;
    }


    private void createRoot(){
        File file = new File(rootFolder);
        file.mkdirs();
        if(!file.exists()){
            throw new DirectoryStateException(file);
        }
    }
    class DirectoryStateException extends RuntimeException {
        DirectoryStateException(File directory) {
            super("Could not create directory: " + directory.getAbsolutePath());
        }
    }

}
