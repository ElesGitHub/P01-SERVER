import exercises.ex07.Ex07;
import network.server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server(new Ex07());
        server.startServer();
    }
}