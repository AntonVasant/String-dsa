package multithreading;

public class ThreadOne implements Runnable{
    
    @Override
    public void run(){
        for (int i = 0; i < 30; i++)
            System.out.println(i+" one");
    }
}
