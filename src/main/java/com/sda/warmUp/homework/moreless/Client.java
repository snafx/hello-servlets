package com.sda.warmUp.homework.moreless;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner socketIn = new Scanner(socket.getInputStream());

        Scanner scannerFromUser = new Scanner(System.in);
        int result =0;
        do {
            System.out.println("Insert number: ");
            int number = scannerFromUser.nextInt();

            socketOut.write(number + "\n");
            socketOut.flush();

            String serverResponse = socketIn.nextLine();
            result = Integer.valueOf(serverResponse);
            if (1 == result) {
                System.out.println("Value too high");
            } else if (-1 == result) {
                System.out.println("Value too low");
            }
        } while (result != 0);
        System.out.println("Correct value!");
        String counterResult = socketIn.nextLine();
        System.out.println("You did it in " + counterResult + " steps!\n");
        socket.close();
    }
}
