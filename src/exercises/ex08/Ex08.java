package exercises.ex08;

import network.config.Protocol;
import network.server.Service;
import utils.IOStreamUtils;

import java.io.*;
import java.net.Socket;

public class Ex08 extends Service {
    @Override
    public void onConnection(Socket socket) throws IOException {
        String action;
        boolean isValidAction = true;

        do {
            action = reader.readLine().trim();
            switch (action) {
                case Protocol.SEE_FILE_TREE -> sendFileTree();
                case Protocol.GET_FILE -> sendFile();

                case null, default -> isValidAction = false;
            }
        } while (isValidAction && !action.equals(Protocol.END_CONNECTION));

    }

    private void sendFileTree() throws IOException {
        IOStreamUtils.writeLines(writer, "File tree! \uD83D\uDCC1 \uD83D\uDCC2 \uD83D\uDCC4");
    }

    private void sendFile() throws IOException {
        IOStreamUtils.writeLines(writer, "File to download!");
    }
}
