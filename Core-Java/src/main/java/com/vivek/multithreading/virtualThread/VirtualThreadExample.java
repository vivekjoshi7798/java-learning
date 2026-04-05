package multithreading.virtualThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadExample {
    public static void main(String[] args) {

        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 1_000; i++) {

            final int id=i;
            service.submit(() -> {
                System.out.println("Running task " + id + " on thread " + Thread.currentThread());
                Thread.sleep(1000); // Simulated blocking
                return null;
            });

        }

        service.shutdown();
        try {
            boolean value=service.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
* What’s happening

newVirtualThreadPerTaskExecutor() creates daemon virtual threads

Your main() method finishes

JVM exits

Remaining virtual threads are killed ❌
*
*
*
*
*
* service.shutdown();

What it does
	• Tells the executor: “No more tasks are coming.”
	• Already submitted tasks continue running
	• New submissions are rejected


Without shutdown():
	• Executor stays open
	• JVM has no reason to wait
	• Program exits early

-------------------------------------------

service.awaitTermination(10, TimeUnit.SECONDS);


What it does
	• Blocks the calling thread (usually main)
	• Waits until:
		○ All tasks finish ✅
		○ OR timeout expires ⏱
		○ OR thread is interrupted


main thread
   |
   | submit 1000 tasks
   |
   | shutdown()   --> stop accepting new tasks
   |
   | awaitTermination()
   |   ├─ wait
   |   ├─ wait
   |   └─ tasks done
   |
program exits cleanly


Method	            Purpose	            Blocks?	    Stops   tasks?
shutdown()	        Graceful shutdown	❌ No	    ❌ No
awaitTermination()	Wait for completion	✅ Yes	    ❌ No
shutdownNow()	    Force shutdown	    ❌ No	    ⚠️ Attempts interrupt

Java 21 Best Practice (Cleaner)
Use try-with-resources — no manual shutdown needed:

try (ExecutorService service =
         Executors.newVirtualThreadPerTaskExecutor()) {

    for (int i = 0; i < 1000; i++) {
        service.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
    }
}
*
*
*
*
*
* */
