import exercises.*;
import network.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server(new Ex06());
        server.startServer();
    }
}