package com.sda.warmUp.homework.moreless;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("waiting...");

        boolean flag = true;
        int counter = 0;
        while (flag) {  // ten while powoduje ze server dziala non stop, serversocket.accept czeka na nowych clientow
            Socket socket = serverSocket.accept();
            System.out.println("connected");

            Scanner socketIn = new Scanner(socket.getInputStream());
            BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Random randomNumber = new Random();
            int number = randomNumber.nextInt(100);
            System.out.println("Generated number: " + number);
            int compareResult;
            do {
                String value = socketIn.nextLine(); //otrzymujemy liczbe od klienta
                Integer incomeValue = Integer.valueOf(value); //zamieniamy Stringa na Int
                compareResult = Integer.compare(incomeValue, number); //porownujemy liczby
                compareResult = Integer.signum(compareResult); //generujemy -1, 0 lub 1 jako wynik porownania
                socketOut.write(compareResult + "\n"); //wysylamy do clienta
                socketOut.flush();
                counter++;
            } while (compareResult != 0);
            socketOut.write(counter + "\n");
            socketOut.flush();
            socket.close();
        }
        serverSocket.close();
    }
}
