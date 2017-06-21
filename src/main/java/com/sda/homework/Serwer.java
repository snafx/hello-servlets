package com.sda.homework;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serwer {
    //laczymy sie do serwera
    //wysyla 5 liczb podanych z reki
    //czeka na wynik
    //wyswietla wynik
    //*jezeli nie mozna bylo podlaczyc, to wyswietla info

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("waiting for connection");
        boolean flag = true;
        while (flag) {  //serwer teraz moze dzialac na nieskonczonosc, klienci ciagle moga sie do niego podlaczac
            Socket socket = serverSocket.accept(); //serverSocket czeka na polaczenie i gdy do niego dojdzie tworzy obiekt socket
            System.out.println("conncection established");

            Scanner scanner = new Scanner(socket.getInputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                String input = scanner.nextLine();
                Integer integer = Integer.valueOf(input);
                System.out.println("Received number:" + input);
                sum += integer;
            }
            writer.write(sum + "\n");
            writer.flush();

            socket.close();
        }
        serverSocket.close();

    }
}
