package com.sda.kik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class KikClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connecting to the game server...");
        System.out.println("Connection established!");
        System.out.println("Game on!");

        Scanner scanner = new Scanner(System.in);

        Scanner socketIn = new Scanner(socket.getInputStream());
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Board board = new Board();
        System.out.println("Waiting for the Player 1 first move...");
        while (!board.isGameFinished()) {
            System.out.println(board);
            if (board.getCounter() % 2 == 1) {
                myTurn(scanner, socketOut, board);
            } else {
                opponentTurn(socketIn, board);
            }
        }
    }

    private static void myTurn(Scanner scanner, BufferedWriter socketOut, Board board) throws IOException {
        boolean status;
        do {
            System.out.println("Insert position: ");
            String ourPosition = scanner.nextLine();
            Integer ourPositionNumber = Integer.valueOf(ourPosition);
            //podajemy pozycje na ktorej chcemy wstawic nasze O
            status = board.addMove(ourPositionNumber, "O");
            if (status) {
                //dodajemy nasza pozycje i wysylamy do serwera
                socketOut.write(ourPositionNumber + "\n");
                socketOut.flush();
            } else {
                System.out.println("Invalid position! Insert again.");
            }
        } while (!status);
    }

    private static void opponentTurn(Scanner socketIn, Board board) {
        //nasluchujemy i otrzymujemy pozycje X od serwera(pierwszego gracza)
        String opponentPosition = socketIn.nextLine();
        Integer position = Integer.valueOf(opponentPosition);
        board.addMove(position, "X");
    }
}
