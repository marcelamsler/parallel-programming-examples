//package ch.umb.solutions.curo;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//import java.util.stream.IntStream;
//
//
//public class ParallelStream {
//
//    public static void main(final String... args) {
//
//        List<Object> adresses = new ArrayList<>();
//
//        adresses.stream().parallel().map(o -> getDetailedAddressFor(o));
//
//        IntStream.range(0, 1000).parallel().forEach(value -> {
//            try {
//                Thread.sleep(new Random().nextInt(6) * 10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("call:" + Thread.currentThread().getName());
//        });
//
//    }
//
//    private static Object getDetailedAddressFor(Object o) {
//        Future<Object> requestResult = new CompletableFuture<>();
//
//        try {
//            return requestResult.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
