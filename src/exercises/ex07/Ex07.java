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

        String action;
        boolean isValidAction = true;

        do {
            action = reader.readLine().trim();
            switch (action) {
                case Protocol.GUESS -> handleGuess(num);

                case null, default -> isValidAction = false;
            }
        } while (isValidAction && !action.equals(Protocol.END_CONNECTION));
    }

    private void handleGuess(int num) throws IOException {
        try {
            int guess = Integer.parseInt(reader.readLine().trim());
            IOStreamUtils.writeLines(writer, Integer.compare(num, guess));
        } catch (NumberFormatException e) {
            throw new IOException();
        }
    }
}
