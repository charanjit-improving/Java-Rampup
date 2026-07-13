package src.MultithreadingAndConcurrency;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MultithreadingAndConcurrency {

    // ==========================================================
    // 1. Thread Safe Bank Account using ReentrantLock
    // ==========================================================

    static class BankAccount {

        private int balance;
        private final ReentrantLock lock = new ReentrantLock();

        BankAccount(int initialBalance) {
            balance = initialBalance;
        }

        void deposit(int amount) {
            lock.lock();
            try {
                balance += amount;
            } finally {
                lock.unlock();
            }
        }

        boolean withdraw(int amount) {
            lock.lock();
            try {
                if (balance >= amount) {
                    balance -= amount;
                    return true;
                }
                return false;
            } finally {
                lock.unlock();
            }
        }

        int getBalance() {
            return balance;
        }
    }

    static void testBankAccount() throws Exception {

        BankAccount account = new BankAccount(100);

        Runnable task = () -> {
            if (account.withdraw(15))
                System.out.println(Thread.currentThread().getName() + " -> Success");
            else
                System.out.println(Thread.currentThread().getName() + " -> Failed");
        };

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread t : threads)
            t.join();

        System.out.println("Final Balance = " + account.getBalance());
    }

    // ==========================================================
    // 2. Producer Consumer using BlockingQueue
    // ==========================================================

    static void produce(BlockingQueue<Integer> queue) throws Exception {

        for (int i = 1; i <= 20; i++) {
            queue.put(i);
        }

        // Stop both consumers
        queue.put(-1);
        queue.put(-1);
    }

    static void consume(BlockingQueue<Integer> queue) throws Exception {

        while (true) {

            int value = queue.take();

            if (value == -1)
                break;

            System.out.println(Thread.currentThread().getName() + " -> " + value);
        }
    }

    static void testProducerConsumer() throws Exception {

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            try {
                produce(queue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread consumer1 = new Thread(() -> {
            try {
                consume(queue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                consume(queue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer1.start();
        consumer2.start();

        producer.join();
        consumer1.join();
        consumer2.join();

        System.out.println("Producer Consumer Finished");
    }

    // ==========================================================
    // 3. Virtual Threads (Java 21)
    // ==========================================================

    static void runAllTasks() throws Exception {

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        List<Future<?>> futures = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {

            futures.add(executor.submit(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }));

        }

        for (Future<?> future : futures)
            future.get();

        executor.close();

        System.out.println("All Virtual Threads Completed");
    }

    // ==========================================================
    // 4. AtomicInteger ID Generator
    // ==========================================================

    static class IdGenerator {

        private static final AtomicInteger counter = new AtomicInteger();

        static int nextId() {
            return counter.incrementAndGet();
        }
    }

    static void testAtomicInteger() throws Exception {

        Runnable task = () ->
                System.out.println(Thread.currentThread().getName() +
                        " -> ID = " + IdGenerator.nextId());

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread t : threads)
            t.join();
    }

    // ==========================================================
    // Main
    // ==========================================================

    public static void main(String[] args) throws Exception {

        System.out.println("===== Bank Account =====");
        testBankAccount();

        System.out.println("\n===== Producer Consumer =====");
        testProducerConsumer();

        System.out.println("\n===== Virtual Threads =====");
        runAllTasks();

        System.out.println("\n===== AtomicInteger =====");
        testAtomicInteger();
    }
}