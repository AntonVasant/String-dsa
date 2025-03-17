package multithreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadOne());
        Thread thread1 = new Thread(new ThreadTwo());
        thread1.start();
        thread1.join();
        System.out.println("here "+Thread.currentThread().getName());
        thread.start();
        System.out.println(Thread.currentThread().getName());
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20; i++)
                System.out.println(i+" three");
        });
        thread2.start();
    }
}

