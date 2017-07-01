package com.sda.kik;

public class Board {
    //tablica String[]
    //konstruktor tworzacy pusta tablice
    //metoda addMove(int position, char sign)
    //toString ->
    //1|2|3
    //X|O|6
    //O|X|X

    private String[] array;

    private int counter = 0;

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
            counter++;
            valueToReturn = true;
        }
        return valueToReturn;
    }

    //metoda ta zwroci true jest ktores z 4 returnów bedzie true
    public boolean isGameFinished() {
        return isFullfilled() || checkRows() || checkColumns() || checkDiagonals();
    }

    //sprawdzamy czy wszystkie pola są zapełnione
    private boolean isFullfilled() {
        return counter == 9;
    }

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

    private boolean checkColumns() {
        boolean flag;
        int i = 0;
        do {
            flag = areValuesEquals(i, i + 3, i + 6);
            i++;
        } while (i < 3 && !flag);
        return flag;
    }

    private boolean checkDiagonals() {
        return array[4] != null && (areValuesEquals(0, 4, 8) || areValuesEquals(2, 4, 6));
    }

    private boolean checkRange(int position) {
        return (position > 0 && position < 10);
    }

    private boolean isPositionEmpty(int position) {
        return array[position - 1] == null;  //jezeli jest puste zwroci true
    }

    //metoda dla KIK okienkowego
    public void resetBoard() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        counter = 0;
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

    public int getCounter() {
        return counter;
    }
}
