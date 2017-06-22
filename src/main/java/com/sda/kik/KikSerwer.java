package com.sda.kik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class KikSerwer {
    public static void main(String[] args) throws IOException {

        /**
         * Board board = new Board();
         * System.out.println(board);
         * board.addMove(5, "X");
         * System.out.println(board);
         * board.addMove(2, "O");
         * System.out.println(board);
         */

        //zakladamy ze serwer jest X
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Waiting for connection with another player...");
        Socket socket = serverSocket.accept();
        System.out.println("Connection established with new opponent");
        System.out.println("Game on!");

        Scanner scanner = new Scanner(System.in);

        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //wysylamy jako pierwsi X do clienta na pozycji na ktorej wstawimy
        Scanner socketIn = new Scanner(socket.getInputStream());

        Board board = new Board();
        System.out.println("You are first!");
        while (!board.isGameFinished()) {
            System.out.println(board);
            if (board.getCounter() % 2 == 0) {
                myTurn(scanner, socketOut, board);
            } else {
                opponentsTurn(socketIn, board);
            }
        }
    }

    private static void opponentsTurn(Scanner socketIn, Board board) {
        //dostajemy pozycje "O" od naszego przeciwnika
        String opponentPosition = socketIn.nextLine();
        board.addMove(Integer.valueOf(opponentPosition), "O");
    }

    private static void myTurn(Scanner scanner, BufferedWriter socketOut, Board board) throws IOException {
        boolean status;
        do {
            System.out.println("Insert position: ");
            String number = scanner.nextLine();
            //podajemy pozycje na ktorej chcemy wstawic naszego X
            status = board.addMove(Integer.valueOf(number), "X");
            if (status) {
                socketOut.write(number + "\n");
                socketOut.flush();
            } else {
                System.out.println("Invalid position! Insert it again.");
            }
        } while (!status);
    }
}
