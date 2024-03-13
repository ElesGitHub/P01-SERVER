import exercises.ex06.Ex06;
import exercises.ex07.Ex07;
import exercises.ex08.Ex08;
import network.server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server(new Ex08());
        server.startServer();
    }
}
