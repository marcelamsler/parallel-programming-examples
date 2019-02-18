package examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MyAtomicInteger {

    public static void main(final String... args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Bla bla = new Bla();

        IntStream.range(0, 1000).parallel().forEach(i -> executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return bla.i.incrementAndGet();
            }
        }));

        executor.shutdown();

//        Thread.sleep(2000);

        System.out.println(bla.i);
    }

    private static class Bla {
       public AtomicInteger i = new AtomicInteger();
    }
}
