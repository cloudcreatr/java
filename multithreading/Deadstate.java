package multithreading;

class A extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            if(i == 1) Thread.yield();
            System.out.println("Thread A: " + i);
        }
        System.out.println("Thread A completed");
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread B: " + i);
            if (i == 3)
                stop();
        }
        System.out.println("Thread B completed");
    }
}

class C extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread C: " + i);
            if (i == 1) {
                try {
                    sleep(1000);
                } catch (Exception e) {

                }

            }
            System.out.println("Thread C completed");
        }
    }

}

public class Deadstate {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        System.err.println("A thread started");
        a.start();
        System.err.println("B thread started");
        b.start();
        System.err.println("C thread started");
        c.start();
        System.err.println("End of program");
    }
}