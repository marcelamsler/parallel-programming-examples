package ch.umb.solutions.curo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;


public class RaceCondition {
    static Semaphore semaphore = new Semaphore(1);

    static int counter = 0;

    public static void main(final String... args) throws InterruptedException {

        ArrayList<Integer> myList = new ArrayList<>();

        IntStream.range(0, 1000).parallel().forEach(value -> {

            for (int i = 0; i < 1000; i++ ) {
                addIfNotContains(myList, i);
            }

        });

        System.out.println(myList.size());

        final String mystring = "MYSTRING";

        final Bla input = new Bla();
        input.bla = mystring;

        toLowerCase(mystring);

        System.out.println(input.bla);
    }


    public static String toLowerCase (String myString) {

        counter++;
        return myString.toLowerCase();
    }

    static class Bla {
        public String bla;
    }



    private synchronized static void addIfNotContains(ArrayList<Integer> myList, int i) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!myList.contains(i)) {
            myList.add(i);
        }

        semaphore.release();
    }

}

//Locking

