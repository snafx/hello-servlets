package sockets;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.100.100", 1234); //podłączamy sie do gniazdka (socket) 1234 z Servera

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(socket.getInputStream());
        Scanner scannerToUser = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            writer.write(scannerToUser.nextLine() + "\n");
            writer.flush();
            System.out.println("Guest: " + scanner.nextLine());
        }
        socket.close();

    }
}
