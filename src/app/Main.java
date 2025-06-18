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

        System.out.println("\u001B[32m" + "OG liste:" + "\u001B[0m");
        printList(list);
        System.out.println("\u001B[32m" + "OG liste2:" + "\u001B[0m");
        printList(list2);

        //* AddI test
        list.addI(1, 1);

        System.out.println("\u001B[32m" + "addI an Stelle 1:" + "\u001B[0m");
        printList(list);
        
        //* RemoveI test
        list.removeI(2);

        System.out.println("\u001B[32m" + "RemoveI an Stelle 2:" + "\u001B[0m");
        printList(list);

        //* CombineLists test
        list.combineLists(list2);

        System.out.println("\u001B[32m"+ "combineLists:"+ "\u001B[0m");
        printList(list);

        //* RemoveDuplicates test
        list.removeDuplicates();

        System.out.println("\u001B[32m"+"Remove duplicates:"+ "\u001B[0m");
        printList(list);

        //* map test
        multiplyI mult = new multiplyI(2);
        ExtendedLinkedList mappedList = list.map(mult);
        
        System.out.println("\u001B[32m"+"map mit multiplyI(2)"+ "\u001B[0m");
        printList(mappedList);


        //* rotation test
        list.rotation(2,"right");

        System.out.println("\u001B[32m"+"rotate list right:"+ "\u001B[0m");
        printList(list);
        
        list = new ExtendedLinkedList();
        for (int i = 1; i <= 5; i++) list.addLast(i);

        System.out.println("\u001B[32m"+"reset list1:"+ "\u001B[0m");
        printList(list);

        list.rotation(2,"left");
        System.out.println("\u001B[32m"+"rotate list2 left:"+ "\u001B[0m");
        printList(list);
    }

    private static void printList(ExtendedLinkedList list) {
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println("\n");

        
        

    }
}
