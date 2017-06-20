package com.sda.sockets;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);  //ustawiamy jakis port
        System.out.println("waiting for connection");
        Socket socket = serverSocket.accept();  //metida accept "zawiesza" dzialanie programu i czeka na polaczenie
        System.out.println("connection established");

        //program ten odbiera cos z InputStream i wysyla go zwrotnie "input" plus dopisane przez nas "pong"

        Scanner scanner = new Scanner(socket.getInputStream()); //input stream, to co przychodzi do mnie (serwera)
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //output stream, zwraca to co wychodzi
        Scanner scannerToUser = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String input = scanner.nextLine();
            System.out.println("Guest: " + input);
//            writer.write(input + " pong\n");
            writer.write(scannerToUser.nextLine()+"\n");
            System.out.println("Flushing output");
            writer.flush();  //flash faktycznie wysyla
        }
        socket.close();
        serverSocket.close();

    }
}
