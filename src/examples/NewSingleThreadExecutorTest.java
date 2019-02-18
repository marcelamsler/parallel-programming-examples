package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class NewSingleThreadExecutorTest {

    public static void main(final String... args) throws InterruptedException, ExecutionException {

        final ExecutorService exService = Executors.newFixedThreadPool(1000);

        List<Future<Integer>> futureList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            final Future<Integer> submit = exService.submit(() -> {
                calculate();
                System.out.println("call:" + Thread.currentThread().getName());
                return 42;
            });

            futureList.add(submit);
        }

        futureList.forEach(integerFuture -> {
            try {
                integerFuture.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        exService.shutdownNow();
    }

    private static void calculate() throws InterruptedException {
        Thread.sleep(new Random().nextInt(6) * 10);
    }

}
