package app;

import datastructures.ExtendedLinkedList;

public class Main {
    public static void main(String[] args) {
        //! Tests, nicht löschen, lieber auskommentieren wenn das stört
        ExtendedLinkedList list = new ExtendedLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.addI(1000, 1);

        for (int i = 0; i < 4; i++) {
            System.out.println(list.get(i));
        }
    }
}
