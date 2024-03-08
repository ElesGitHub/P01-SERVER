package exercises;

import network.Service;
import utils.IOStreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex06 implements Service {


    @Override
    public void onStartService(ServerSocket serverSocket) {
        System.out.println("Service started at port: " + serverSocket.getLocalPort());
    }

    @Override
    public void onConnection(Socket socket) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            IOStreamUtils.writeLines(writer, "Holaaaa");
        }
    }

    @Override
    public void onError(IOException e) {
        System.err.println("Error! Closing connection.");
        e.printStackTrace();
    }
}
