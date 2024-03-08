package utils;

import java.io.BufferedWriter;
import java.io.IOException;

public class IOStreamUtils {
    public static void writeLines(BufferedWriter writer, String... lines) throws IOException {
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        writer.flush();
    }
}
