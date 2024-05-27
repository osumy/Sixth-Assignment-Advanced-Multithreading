package sbu.cs.Semaphore;

public class Resource {

    public static void accessResource() {
        try {
            Controller.semaphore.acquire();
            Thread.sleep(1000);
            Controller.semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
