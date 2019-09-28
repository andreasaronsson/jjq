package nu.aron.jjq;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.concurrent.Callable;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

import io.vavr.control.Try;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine;
/**
 * Entry point
 *
 */
@Command(description = "Returns data.",
         name = "jjq", mixinStandardHelpOptions = true)
public class Main implements Callable<Integer> {

    @Parameters(index = "0", description = "The json data.")
    private File file;

    @Option(names = {"-s", "--search"}, description = "Key to search for")
    private String search = "";

    public static void main(String... args) {
        int exitCode = CommandLine.call(new Main(), args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        byte[] fileContents = Try.of(() -> Files.readAllBytes(file.toPath())).getOrElse(new byte[] {});
        JsonObject object = Json.parse(new String(fileContents, StandardCharsets.UTF_8)).asObject();
        System.out.println(object);
        return 0;
    }
}

