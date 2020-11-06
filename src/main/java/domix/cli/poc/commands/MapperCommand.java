package domix.cli.poc.commands;

import picocli.CommandLine;

import java.util.Map;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "mapper", description = "Mapper command",
    mixinStandardHelpOptions = true)
public class MapperCommand implements Callable<Void> {
    @CommandLine.Option(names = {"-v", "--verbose"}, description = "Verbose mapper option")
    boolean verbose;

    @CommandLine.Option(names = {"-s", "--service"}, description = "The service name you want to execute.", required = true)
    private String serviceName;

    @CommandLine.Option(names = {"-d", "--data"}, split = ",", description = "A map of multiple values.", arity = "1..*")
    private Map<String, String> map;


    @Override
    public Void call() throws Exception {

        if (verbose) {
            System.out.println("Mapper in action!");
        }

        map.forEach((s, s2) -> System.out.println("key=" + s + ", value=" + s2));


        return null;
    }
}
