package com.sda.kik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 * serwer bedzie wpisywal krzyzyki na boarda "X"
 * czyli niedosc,ze jest serwerem, to jeszcze jest jednym z graczy
 */
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
        //otwieramy port
        ServerSocket serverSocket = new ServerSocket(1234);

        //serwer bedzie dzialal w nieskonczonej petli
        //po zakonczonej grze bedzie oczekiwal na kolejne polaczenie od klienta
        boolean flag = true;
        while (flag) {
            //nasluchujemy az do momentu kiedy jakis klient sie podlaczy
            System.out.println("Waiting for connection with another player...");

            Socket socket = serverSocket.accept();
            System.out.println("Connection established with new opponent");
            System.out.println("Game on!");

            //skaner do czytanie od usera-serwera
            Scanner scanner = new Scanner(System.in);

            //writer do wypisywania na zewnatrz
            BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //wysylamy jako pierwsi X do clienta na pozycji na ktorej wstawimy
            //skaner do czytania wiadomosci od klienta
            Scanner socketIn = new Scanner(socket.getInputStream());

            Board board = new Board();
            System.out.println("You are first!");
            //petla tak dlugo dopoki gra sie nie skonczy
            while (!board.isGameFinished()) {
                System.out.println("Current board:");
                System.out.println(board);
                //serwer zaczyna gre i ma parzyste ruchy
                if (board.getCounter() % 2 == 0) {
                    myTurn(scanner, socketOut, board);
                } else {
                    opponentsTurn(socketIn, board);
                }
            }
            System.out.println("Final board:");
            System.out.println(board);

            System.out.println("Finisking connection");
            socket.close();
        }
    }

    private static void opponentsTurn(Scanner socketIn, Board board) {
        //dostajemy pozycje "O" od naszego przeciwnika-klienta
        String opponentPosition = socketIn.nextLine();
        board.addMove(Integer.valueOf(opponentPosition), "O");
    }

    private static void myTurn(Scanner scanner, BufferedWriter socketOut, Board board) throws IOException {
        boolean status;
        do {
            System.out.println("Insert position: ");
            //zaczytanie pozycji od gracza-serwera
            String number = scanner.nextLine();
            //podajemy pozycje na ktorej chcemy wstawic naszego X
            status = board.addMove(Integer.valueOf(number), "X");
            if (status) {
                //jesli udalo sie poprawnie dodac pozycje do tablicy to wysylamy klientowi te pozycje
                socketOut.write(number + "\n");
                socketOut.flush();
            } else {
                System.out.println("Invalid position! Insert it again.");
            }
        } while (!status);
    }
}
