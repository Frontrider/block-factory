package hu.frontrider.blockfactory.staticdata;

import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import hu.frontrider.blockfactory.templates.BlockTemplate;
import hu.frontrider.blockfactory.templates.DefaultBlockTemplate;
import io.github.cottonmc.staticdata.StaticData;
import io.github.cottonmc.staticdata.StaticDataItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StaticDataTemplateHelper<T> {

    private final Function<BufferedReader, T> parser;
    private final String path;

    StaticDataTemplateHelper(Function<BufferedReader, T> parser,String path) {
        this.parser = parser;
        this.path = path;
    }

    public Map<Identifier, T> getElements() {

        ImmutableSet<StaticDataItem> blocks = StaticData.getAllInDirectory(path);

        return blocks.stream()
                //we expect a lot of data
                .parallel()
                //convert the data item into a pair of identifiers and block templates.
                .map(staticDataItem -> {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(staticDataItem.createInputStream()));
                        T blockTemplate = parser.apply(bufferedReader);

                        return new Pair<>(staticDataItem.getIdentifier(), blockTemplate);

                    } catch (IOException e) {
                        e.printStackTrace();
                        return new Pair<>(staticDataItem.getIdentifier(), null);
                    }
                })
                .filter(identifierPair -> identifierPair.getRight() != null)
                .collect(Collectors.toMap(Pair::getLeft, pair -> (T) pair.getRight()));
    }
}
