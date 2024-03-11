package utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;

public class IOStreamUtils {
    public static void writeLines(BufferedWriter writer, Object... lines) throws IOException {
        writeLines(
                writer,
                Arrays.stream(lines).map(String::valueOf).toArray(String[]::new)
        );
    }

    public static void writeLines(BufferedWriter writer, String... lines) throws IOException {
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        writer.flush();
    }
}
