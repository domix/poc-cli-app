package domix.cli.poc;

import domix.cli.poc.commands.MapperCommand;
import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "App", description = "...",
    mixinStandardHelpOptions = true, subcommands = {MapperCommand.class})
public class AppCommand implements Runnable {
    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(AppCommand.class, args);
    }


    @Override
    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
