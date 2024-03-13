package exercises.ex06;

import network.server.Service;
import utils.IOStreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex06 extends Service {
    private volatile int count;

    @Override
    public void onStartService(ServerSocket serverSocket) {
        super.onStartService(serverSocket);
        count = 0;
    }

    @Override
    public void onConnection(Socket socket) throws IOException {
        int in = Integer.parseInt(reader.readLine());

        System.out.println(socket.getInetAddress() + ": " + in);

        int newTotal = addToCount(in);
        IOStreamUtils.writeLines(writer, newTotal);
        System.out.println("New count: " + newTotal);

    }

    private synchronized int addToCount(int n) {
        return (count += n);
    }
}
