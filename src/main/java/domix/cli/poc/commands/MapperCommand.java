package domix.cli.poc.commands;

import com.diogonunes.jcolor.AnsiFormat;
import picocli.CommandLine;

import java.util.List;
import java.util.concurrent.Callable;

import static com.diogonunes.jcolor.Attribute.GREEN_TEXT;
import static com.diogonunes.jcolor.Attribute.YELLOW_TEXT;

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
            AnsiFormat fNormal = new AnsiFormat(GREEN_TEXT());
            AnsiFormat fNormasl = new AnsiFormat(YELLOW_TEXT());
            String format = String.format("Making request to %s:%d", host, port);

            System.out.println(fNormal.format(format));
            System.out.println(fNormal.format("Calling service: ") + fNormasl.format(serviceName));
            System.out.println(data);
        }

        return null;
    }
}
