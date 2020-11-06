package domix.cli.poc.commands;

import picocli.CommandLine;

import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
    name = "mapper",
    description = "Mapper command",
    mixinStandardHelpOptions = true)
public class MapperCommand implements Callable<Void> {
    @CommandLine.Option(names = {"-host", "--hostname"}, description = "Service hostname or ip", defaultValue = "localhost")
    private String host;

    @CommandLine.Option(names = {"-p", "--port"}, description = "Service port number", defaultValue = "8080")
    private Integer port;

    @CommandLine.Option(names = {"-v", "--verbose"}, description = "Verbose mapper option")
    boolean verbose;

    @CommandLine.Option(names = {"-s", "--service"}, description = "The service name you want to execute.", required = true)
    private String serviceName;

    @CommandLine.Option(names = {"-d", "--data"}, description = "A map of multiple values.", arity = "0..*", converter = DataPairConverter.class)
    private List<DataPair> data;


    @Override
    public Void call() throws Exception {

        if (verbose) {
            System.out.printf("Making request to %s:%d%n", host, port);
            System.out.printf("Service to call: %s%n", serviceName);
            System.out.println(data);
        }

        return null;
    }
}
