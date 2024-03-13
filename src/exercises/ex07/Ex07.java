package exercises.ex07;

import network.server.Service;
import network.config.Protocol;
import utils.IOStreamUtils;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Ex07 extends Service {
    @Override
    public void onConnection(Socket socket) throws IOException {
        int num = new Random().nextInt(20) + 1;
        System.out.println("Number to guess: " + num);

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ){
            String action;
            boolean isValidAction = true;

            do {
                action = reader.readLine().trim();
                switch (action) {
                    case Protocol.GUESS -> handleGuess(num, reader, writer);

                    case null, default -> isValidAction = false;
                }
            } while (isValidAction && !action.equals(Protocol.END_CONNECTION));
        }
    }

    private void handleGuess(int num, BufferedReader reader, BufferedWriter writer) throws IOException {
        try {
            int guess = Integer.parseInt(reader.readLine().trim());
            IOStreamUtils.writeLines(writer, Integer.compare(num, guess));
        } catch (NumberFormatException e) {
            throw new IOException();
        }
    }
}
