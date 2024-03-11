package exercises;

import network.Service;
import utils.IOStreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex06 implements Service {
    private volatile int count;

    @Override
    public void onStartService(ServerSocket serverSocket) {
        System.out.println("Service started at port: " + serverSocket.getLocalPort());

        count = 0;
    }

    @Override
    public void onConnection(Socket socket) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            int in = Integer.parseInt(reader.readLine());

            System.out.println(socket.getInetAddress() + ": " + in);

            int newTotal = addToCount(in);
            IOStreamUtils.writeLines(writer, newTotal);
            System.out.println("New count: " + newTotal);
        }
    }

    @Override
    public void onError(IOException e) {
        System.err.println("Error! Closing connection.");
        System.err.println(e.toString());
    }

    private synchronized int addToCount(int n) {
        return (count += n);
    }
}
