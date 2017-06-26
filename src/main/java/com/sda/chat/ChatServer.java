package com.sda.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);

        boolean flag = true;

        ChatUsersStorage storage = new ChatUsersStorage();
        while (flag) {
            Socket socket = serverSocket.accept();
            ChatServerTask chatServerTask = new ChatServerTask(socket, storage);
            Thread thread = new Thread(chatServerTask);
            thread.start();
        }
        serverSocket.close();
    }
}
