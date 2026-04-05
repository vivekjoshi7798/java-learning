package multithreading.deadlock;

class SharedResource{


    public synchronized void doTask() {
        System.out.println("Lock is Performed by "+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


public class DeadlockSolution {

    public static void main(String[] args) {
        System.out.println("executing dead lock solution ");

        SharedResource sharedResource = new SharedResource();

        Thread th1= new Thread(sharedResource::doTask);
        Thread th2= new Thread(()->{
            System.out.println("th2 is created");
            Thread.currentThread().setName("Thread2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }

            sharedResource.doTask();

        } );

        th1.start();
        th2.start();
        try {
            Thread.sleep(3000);
            System.out.println("main task");
            th1.suspend();
        }catch (Exception ignored){

        }

        System.out.println("Main Task is finished");
        }

}
