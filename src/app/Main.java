package app;

import datastructures.ExtendedLinkedList;

public class Main {
    public static void main(String[] args) {
        //! Tests, nicht löschen, lieber auskommentieren wenn das stört
        //! Jo, wenn die Liste größer ist auch schön beim print das i < auf einen höeren int stellen.
        ExtendedLinkedList list = new ExtendedLinkedList();
        ExtendedLinkedList list2 = new ExtendedLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);

        list.addI(1000, 1);
        System.out.println("addI an Stelle 1: \n");
        for (int i = 0; i < 4; i++) {
            System.out.println(list.get(i));
        }
        list.removeI(2);

        list.combineLists(list2);
        System.out.println("removeI an Stelle 2 und combineLists \n");
        for (int i = 0; i < 6; i++) {
            System.out.println(list.get(i));
        }
    }
}
