package com.sda.chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChatConnectionFacade {
    private Scanner in;

    private BufferedWriter out;

    private String nickName;

    public ChatConnectionFacade(Scanner in, BufferedWriter out, String nickName) {
        this.in = in;
        this.out = out;
        this.nickName = nickName;
    }

    public ChatConnectionFacade(Scanner in, BufferedWriter out) {
        this.in = in;
        this.out = out;
    }

    public void write(String message) throws IOException {
        System.out.print(nickName + ": " + message);
        out.write(message + "\n");
        out.flush();
    }

    public String read() {
        return in.nextLine();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
