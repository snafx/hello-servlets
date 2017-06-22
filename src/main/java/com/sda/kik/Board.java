package com.sda.kik;

import java.util.Arrays;

public class Board {
    //tablica String[]
    //konstruktor tworzacy pusta tablice
    //metoda addMove(int position, char sign)
    //toString ->
    //1|2|3
    //X|O|6
    //O|X|X

    private String[] array;

    public Board() {
        array = new String[9];
    }

    /**
     * opis metody addMove
     *
     * @param position values (1-9)
     */
    public boolean addMove(int position, String sign) {
        boolean valueToReturn = false;
        if (checkRange(position) && isPositionEmpty(position)) {
            array[position - 1] = sign;
            valueToReturn = true;
        }
        return valueToReturn;
    }

//    private boolean isGameFinished() {
//
//    }
//
//    private boolean isFullfilled() {
//
//    }

    //sprawdzamy czy elementy lezace na danych pozycjach sa rowne i czy sa zajete
    private boolean areValuesEquals(int i, int j, int k) {
        return array[i] != null && array[i].equals(array[j]) && array[i].equals(array[k]);
    }

    private boolean checkRows() {
        boolean flag;
        int i = 0;
        do {
            flag = areValuesEquals(i, i + 1, i + 2);
            i += 3;
        } while (i < 9 && !flag);
        return flag;
    }

//    private boolean checkColumns() {
//
//    }
//
//    private boolean checkDiagonals() {
//
//    }

    private boolean checkRange(int position) {
        return (position > 0 && position < 10);
    }

    private boolean isPositionEmpty(int position) {
        return array[position - 1] == null;  //jezeli jest puste zwroci true
    }

    //1|2|3
    //X|O|6
    //O|X|X
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            //kiedy piszemy liczbe
            stringBuilder.append(array[i] == null ? (i + 1) : array[i]);
            stringBuilder.append((i + 1) % 3 == 0 ? "\n" : "|");
        }
        return stringBuilder.toString();
    }
}
