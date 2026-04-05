package multithreading.producerProblem;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


class CustomBlockingMessagingQueue {

    public BlockingQueue<String> broker;
    int producerCounter;

    public CustomBlockingMessagingQueue( int bufferSize) {
        this.broker = new ArrayBlockingQueue<>(bufferSize);
    }

    public  void addMessages() {


        try {
            broker.put("Message "+ producerCounter);
            System.out.println("Message Produced : Message "+ producerCounter);
            producerCounter++;
        } catch (InterruptedException e) {

        }

    }

    public  void consumeMessage() {
        try {
            System.out.println("Message Consumed : " + broker.take());
        } catch (InterruptedException ignored) {

        }
    }
}

public class BlockingQueueSolution {

    public static void main(String[] args) {
        CustomBlockingMessagingQueue customMessagingQueue= new CustomBlockingMessagingQueue(3);

        Thread producerMessage= new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                customMessagingQueue.addMessages();
            }
        });

        Thread consumerMessage= new Thread(()-> {
            for (int i = 0; i < 6; i++) {
                customMessagingQueue.consumeMessage();
            }
        });

        producerMessage.start();
        consumerMessage.start();
    }
}



