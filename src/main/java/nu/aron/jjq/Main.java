package nu.aron.jjq;

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine;

/**
 * Entry point
 *
 */
@Command(description = "Returns data.",
         name = "jjq", mixinStandardHelpOptions = true)
public class Main implements Callable<Void> {
    public static void main(String[] args) {
        CommandLine.call(new Main(), args);
    }

    @Override
    public Void call() {
        System.out.println("BIOI");
        return null;
    }
}

