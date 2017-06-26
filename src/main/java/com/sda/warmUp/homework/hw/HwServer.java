package com.sda.warmUp.homework.hw;


import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HwServer {
    //server czeka na polaczenie
    //po podlaczeniu odb iera liczbe n
    //wysyla losowego String o rozmiarze n
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(666);
        System.out.println("waiting for connection");
        boolean flag = true;
        while (flag) {
            Socket socket = serverSocket.accept();
            System.out.println("connected");
            Scanner socketIn = new Scanner(socket.getInputStream());
            BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            String input = socketIn.nextLine();
//            System.out.println("Received: " + input);

            int counter = Integer.valueOf(socketIn.nextLine());
            String random = RandomStringUtils.random(counter, true, true);
            socketOut.write(random + "\n");
            socketOut.flush();
            socket.close();

        }
        serverSocket.close();
    }
}
