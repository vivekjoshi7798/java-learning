package multithreading.producerProblem;

class SharedResources{

    boolean  itemAvailable= false;



    public synchronized void consumeItem(){
        System.out.println("Consumer Thread Started  ");
        while(!itemAvailable){
            System.out.println("Consumer Thread Started but There is no item");
            try {
                wait();
            } catch (InterruptedException ignored) {

            }
        }
        itemAvailable=false;
        System.out.println("Consumer thread executed Successfully");
    }

    public synchronized void produceItem(){
        itemAvailable=true;
        System.out.println("produceItem made itemAvailable true");
        notifyAll();
    }

}


public class Solution {

    public static void main(String[] args) {

    SharedResources sharedResources= new SharedResources();

    Thread producerThread= new Thread(()->
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        sharedResources.produceItem();
    });

    Thread consumerThread= new Thread(sharedResources::consumeItem);
    consumerThread.start();
    producerThread.start();

    }
}
