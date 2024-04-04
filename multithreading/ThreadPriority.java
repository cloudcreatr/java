package multithreading;

class A extends Thread {
    public void run() {
        System.out.println("Thread A started");
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread A: " + i);
        }
        System.out.println("Thread A completed");
    }
}

class B extends Thread {
    public void run() {
        System.out.println("Thread B started");
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread B: " + i);
        }
        System.out.println("Thread B completed");
    }
}

class C extends Thread {
    public void run() {
        System.out.println("Thread C started");
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread C: " + i);
        }
        System.out.println("Thread C completed");
    }
}



public class ThreadPriority {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        c.setPriority(Thread.MAX_PRIORITY);
        b.setPriority(a.getPriority() + 1);
        a.setPriority(Thread.MIN_PRIORITY);

        System.out.println("start thread A");
        a.start();
        System.out.println("start thread B");
        b.start();
        System.out.println("start thread C");
        c.start();
        System.out.println("End of program");
    }
}
