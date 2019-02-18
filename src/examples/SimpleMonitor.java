package examples;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;


public class SimpleMonitor {
    final Lock lock = new ReentrantLock();

    public void testA() {
        lock.lock();

        try {
            //Some code
        } finally {
            lock.unlock();
        }
    }

    public void testB() {
        lock.lock();

        try {
            //Some code
        } finally {
            lock.unlock();
        }
    }

    public static void main(final String... args) {
        final Lock lock = new ReentrantLock();
        ArrayList<Integer> myList = new ArrayList<>();


        IntStream.range(0, 1000).parallel().forEach(value -> {
            for (int i = 0; i < 1000; i++ ) {
                lock.lock();
                if (!myList.contains(i)) {
                    myList.add(i);
                }
                lock.unlock();
            }
        });

        System.out.println(myList.size());
    }

}


//Locking

