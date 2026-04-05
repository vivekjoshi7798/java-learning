package multithreading.ThreadLocal;

class SharedResourceThreadLocal {

    public void printLocalValue(ThreadLocal name){
        System.out.println("Thread local value "+name+" by Thread :"+Thread.currentThread().getName());

    }
}

public class ThreadLocalEx1 {
    public static void main(String[] args) {
        SharedResourceThreadLocal r1= new SharedResourceThreadLocal();
        ThreadLocal<String> name= new ThreadLocal<>();

        Thread t1= new Thread(()-> {
            try {
                name.set("SHAM");
                Thread.sleep(10000);
                r1.printLocalValue(name);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"SHAM");
        Thread t2= new Thread(()-> {
            name.set("RAM");
            r1.printLocalValue(name);
        },"RAM");

        t1.start();
        t2.start();
    }



}
