package com.sda.warmUp.homework.hw;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class HwClient {
    //laczy sie do server
    //po podlaczeniu wysyla liczbe n
    //czeka na odpowiedz
    //po otrzymaniu wysyla ja w odwrotnej kolejnosci
    //StringUtils.reverse
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 666);

        Scanner socketIn = new Scanner(socket.getInputStream());
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

//        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        int number = randomNumber.nextInt(100);
        System.out.println("Random number: " + number);

        socketOut.write(number + "\n");
        socketOut.flush();
        String message = socketIn.nextLine();
        System.out.println("Received message from server: " + message);
        String reversedMessage = StringUtils.reverse(message);
        System.out.println("Reversed message: " + reversedMessage);
        socket.close();

    }





}
