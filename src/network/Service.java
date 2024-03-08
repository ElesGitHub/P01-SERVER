package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public interface Service {

    void onStartService(ServerSocket serverSocket);

    void onConnection(Socket socket) throws IOException;
    void onError(IOException e);
}
