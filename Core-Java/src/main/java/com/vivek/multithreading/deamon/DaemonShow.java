package multithreading.deamon;



public class DaemonShow {
    public static void main(String[] args) {

        System.out.println("Main thread started");
        Thread th1= new Thread(()-> {
            System.out.println("child thread started");
            while(true){
                System.out.println("Hello");
            }

        });

        th1.setDaemon(true);
        th1.start();


        System.out.println("Main thread Stopped");


    }
}
