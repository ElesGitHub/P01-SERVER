package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final Service service;

    public Server(Service service) {
        this.service = service;
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        service.onStartService(serverSocket);

        while (true) {
            Socket socket = serverSocket.accept();
            launchTask(socket);
        }
    }

    private void launchTask(Socket socket) {
        new Thread(() -> {
            try {
                service.setIOStreams(socket.getInputStream(), socket.getOutputStream());
                service.onConnection(socket);
                service.closeIOStreams();
            } catch (IOException e) {
                service.onError(e);
            }
        }).start();
    }
}
