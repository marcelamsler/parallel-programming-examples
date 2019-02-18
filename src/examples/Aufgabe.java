package examples;

import java.util.stream.IntStream;

public class Aufgabe {

    public static void main(final String... args) {

        IntStream.range(0, 1000).parallel().forEach(value -> {
            System.out.println(value * value);
        });

    }
}
