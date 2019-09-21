package hu.frontrider.blockfactory.content.items.dynagear;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.impl.SyntaxError;
import com.google.common.collect.ImmutableSet;
import io.github.cottonmc.dynagear.EquipmentSet;
import io.github.cottonmc.dynagear.MaterialConfig;
import io.github.cottonmc.dynagear.api.ConfiguredMaterial;
import io.github.cottonmc.jankson.JanksonFactory;
import io.github.cottonmc.staticdata.StaticData;
import io.github.cottonmc.staticdata.StaticDataItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class StaticToolSetLoader {

    public static final Jankson jankson = JanksonFactory.createJankson();

    public void loadStaticMaterials() {

        ImmutableSet<StaticDataItem> materials = StaticData.getAllInDirectory("block_factory/dynagear/materials");

        materials
                //load materials, and register
                .forEach(staticDataItem -> {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(staticDataItem.createInputStream()));
                        JsonObject materialJson = jankson.load(bufferedReader.lines().collect(Collectors.joining()));

                        ConfiguredMaterial material = MaterialConfig.getMaterial(staticDataItem.getIdentifier().toString(), materialJson);
                        EquipmentSet.create(material);

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SyntaxError syntaxError) {
                        syntaxError.printStackTrace();
                    }
                });
    }
}
