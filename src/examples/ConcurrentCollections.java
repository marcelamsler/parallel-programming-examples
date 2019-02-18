package ch.umb.solutions.curo;

import import java.util.TimeZone;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;


public class ConcurrentCollections {

    public static void main(final String... args) {



        CopyOnWriteArrayList<Integer> myList = new CopyOnWriteArrayList<>();

        IntStream.range(0, 1000).parallel().forEach(value -> {
            for (int i = 0; i < 1000; i++) {
                myList.addIfAbsent(i);
            }
        });

        final TimeZone aDefault = TimeZone.;


        System.out.println(myList.size());
    }

}


