package app;

import datastructures.ExtendedLinkedList;
import maps.addI;
import maps.multiplyI;

public class Main {
    public static void main(String[] args) {
        //! Tests, nicht löschen, lieber auskommentieren wenn das stört
        //! Jo, wenn die Liste größer ist auch schön beim print das i < auf einen höeren int stellen.
        //? was wenn nicht
        //! dann schnappe ich mir dich 

        // make defaults
        ExtendedLinkedList list = new ExtendedLinkedList();
        ExtendedLinkedList list2 = new ExtendedLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);

        //* AddI test
        list.addI(1000, 1);
        System.out.println("\u001B[32m" + "addI an Stelle 1:" + "\u001B[0m");
        for (int i = 0; i < 4; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\n");

        //* RemoveI test
        list.removeI(2);

        list.combineLists(list2);
        System.out.println("\u001B[32m"+ "removeI an Stelle 2 und combineLists"+ "\u001B[0m");
        for (int i = 0; i < 6; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\n");


        ExtendedLinkedList list3 = new ExtendedLinkedList();
        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(3);
        list3.addLast(2);
        list3.addLast(4);
        list3.addLast(1);

        list3.removeDuplicates();

        System.out.println("\u001B[32m"+"Remove duplicates:"+ "\u001B[0m");
        for (int i = 0; i < 4; i++) {
            System.out.println(list3.get(i));
        }
        System.out.println("\n");

        
        
        //* map test

        multiplyI mult = new multiplyI(2);
        ExtendedLinkedList mappedList = list3.map(mult);


        System.out.println("\u001B[32m"+"map mit multiplyI(2)"+ "\u001B[0m");
        for (int i = 0; i < 4; i++) {
            System.out.println(mappedList.get(i));
        }

    }
}
