package domix.cli.poc.commands;

import java.util.List;
import java.util.Map;

public class DataPair {
    private List<Map<String, String>> data;

    public List<Map<String, String>> getData() {
        return data;
    }

    public void setData(List<Map<String, String>> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataPair{" +
            "data=" + data +
            '}';
    }
}
