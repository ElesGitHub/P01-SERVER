package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Service implements IService {
    @Override
    public void onStartService(ServerSocket serverSocket) {
        System.out.println("Service started at port: " + serverSocket.getLocalPort());
    }

    @Override
    public void onConnection(Socket socket) throws IOException {}

    @Override
    public void onError(IOException e) {
        System.err.println("Error! Closing connection.");
        System.err.println(e.toString());
    }
}
