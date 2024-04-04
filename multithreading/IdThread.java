package multithreading;

class A extends Thread {
    public void run() {
        System.out.println("This is thread A \t Thread ID: " + Thread.currentThread().getId() + "\t Thread Priority: "
                + Thread.currentThread().getPriority());
    }
}

class B extends Thread {
    public void run() {
        System.out.println("This is thread B \t Thread ID: " + Thread.currentThread().getId() + "\t Thread Priority: "
                + Thread.currentThread().getPriority());
    }
}

public class IdThread {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setPriority(Thread.MIN_PRIORITY);
        b.setPriority(Thread.MAX_PRIORITY);

        System.out.println("\n this is the main \t Thread ID:" + Thread.currentThread().getPriority());

        a.start();
        b.start();
    }
}
