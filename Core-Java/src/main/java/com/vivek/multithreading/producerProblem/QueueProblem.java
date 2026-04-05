package multithreading.producerProblem;

import java.util.LinkedList;
import java.util.Queue;


class CustomMessagingQueue {

    public Queue<String> broker= new LinkedList<>();
    int bufferSize ;
    int producerCounter;

    public CustomMessagingQueue( int bufferSize) {
        this.broker = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void addMessages() {

        while(broker.size()==bufferSize){
            try {
                wait();
            } catch (InterruptedException ignored) {

            }
        }
        broker.offer("Message "+ producerCounter);
        System.out.println("Message Produced : Message "+ producerCounter);
        producerCounter++;

        notify();
    }

    public synchronized void consumeMessage() {
        while(broker.isEmpty()){
            try {
                System.out.println("Message Consumer Stop  as Queue is empty ");
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println("Message Consumed : " + broker.poll());

        notify();
    }
}

public class QueueProblem {

    public static void main(String[] args) {
        CustomMessagingQueue customMessagingQueue= new CustomMessagingQueue(3);

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
