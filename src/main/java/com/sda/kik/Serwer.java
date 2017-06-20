package com.sda.kik;


public class Serwer {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
        board.addMove(5, "X");
        System.out.println(board);
        board.addMove(2, "O");
        System.out.println(board);
    }
}
