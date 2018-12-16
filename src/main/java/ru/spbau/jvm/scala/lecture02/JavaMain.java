package ru.spbau.jvm.scala.lecture02;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JavaMain {

    // f1(f2<A, B>(x + 1)); // unsolvable parsing problem

    public static void main(String[] args) {
        if (args.length == 0) return;

        args[0] = "hello";
        System.out.println(args[0]);

        printList(Collections.singletonList(1));
    }

    private static <T> void printList(List<T> list) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
