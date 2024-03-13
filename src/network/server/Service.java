package network.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Service implements IService {
    protected BufferedReader reader;
    protected BufferedWriter writer;

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

    public void setIOStreams(InputStream in, OutputStream out) {
        reader = new BufferedReader(new InputStreamReader(in));
        writer = new BufferedWriter(new OutputStreamWriter(out));
    }

    public void closeIOStreams() throws IOException {
        reader.close();
        writer.close();
    }
}
