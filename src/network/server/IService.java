package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public interface IService {

    void onStartService(ServerSocket serverSocket);
    void onConnection(Socket socket) throws IOException;
    void onError(IOException e);
}
