package domix.cli.poc.commands;

import picocli.CommandLine;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataPairConverter implements CommandLine.ITypeConverter<DataPair> {

    @Override
    public DataPair convert(String value) throws Exception {
        List<Map<String, String>> collect = Stream.of(value.split(","))
            .map(s -> s.split("="))
            .filter(strings -> strings.length == 2)
            .map(strings -> Map.of(strings[0], strings[1]))
            .collect(Collectors.toList());

        DataPair dataPair = new DataPair();
        dataPair.setData(collect);

        return dataPair;
    }
}
