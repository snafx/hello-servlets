package com.sda.chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.100.185", 1234);
        Scanner socketIn = new Scanner(socket.getInputStream());
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Scanner scanner = new Scanner(System.in);
        String input;
        myLoginToServer(socketOut, scanner);
        createReadThread(socketIn);
        do {
            input = scanner.nextLine();
            socketOut.write(input + "\n");
            socketOut.flush();
        } while (!"exit".equals(input));
        socket.close();
    }

    private static void createReadThread(Scanner socketIn) {
        ChatClientReadTask chatClientReadTask = new ChatClientReadTask(socketIn);
        Thread thread = new Thread(chatClientReadTask);
        thread.start();
    }

    //nasza pierwsza wiadomosc jakos Client bedzie naszym nickiem na chacie
    private static void myLoginToServer(BufferedWriter socketOut, Scanner scanner) throws IOException {
        System.out.println("Insert your nickName: ");
        String nickName = scanner.nextLine();
        socketOut.write(nickName + "\n");
        socketOut.flush();
    }
}




