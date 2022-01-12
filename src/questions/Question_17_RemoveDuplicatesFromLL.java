package questions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Question_17_RemoveDuplicatesFromLL {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>(List.of(1, 1, 3, 4, 4, 4, 5, 6, 6));
        System.out.println("list1 = " + list1);
        removeDuplicates(list1);
        System.out.println("list1 = " + list1);
    }

    public static void removeDuplicates(LinkedList<Integer> list) {

        Iterator<Integer> it = list.iterator();
        int prev = it.next();
        int current;

        while (it.hasNext()) {
            current = it.next();
            if (prev == current) {
                it.remove();
            }
            prev = current;
        }
        System.out.println(list);
    }

}
