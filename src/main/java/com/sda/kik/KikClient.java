package com.sda.kik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
/**
 * klient laczy sie do serwera i czeka na jego pierwszy ruch
 * klient dodaje "O" do tablicy
 */
public class KikClient {
    public static void main(String[] args) throws IOException {
        //tworzymy socket, podlaczamy sie do serwera
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connecting to the game server...");
        System.out.println("Connection established!");
        System.out.println("Game on!");

        //skaner do czytanie od usera-klienta
        Scanner scanner = new Scanner(System.in);

        //skaner do czytania tego co do nas przychodzi, czyli skaner tego co przychodzi do nas od Serwera
        Scanner socketIn = new Scanner(socket.getInputStream());
        //writer do wypisywania na zewnatrz
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Board board = new Board();
        System.out.println("Waiting for the Player 1 first move...");
        //petla tak dlugo dopoki gra sie nie skonczy
        while (!board.isGameFinished()) {
            System.out.println(board);
            //klient ma nieparzyste ruchy, czyli gre zaczyna serwer
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
            //podajemy pozycje (proba zajecia) na ktorej chcemy wstawic nasze O
            status = board.addMove(ourPositionNumber, "O");
            if (status) {
                //jesli udalo sie poprawnie zajac, dodajemy nasza pozycje i wysylamy do serwera
                socketOut.write(ourPositionNumber + "\n");
                socketOut.flush();
            } else {
                System.out.println("Invalid position! Insert again.");
            }
        } while (!status);
    }

    private static void opponentTurn(Scanner socketIn, Board board) {
        //nasluchujemy i otrzymujemy pozycje X od serwera(pierwszego gracza-serwera)
        String opponentPosition = socketIn.nextLine();
        //dodanie pozycji do tablicy
        Integer position = Integer.valueOf(opponentPosition);
        board.addMove(position, "X");
    }
}
