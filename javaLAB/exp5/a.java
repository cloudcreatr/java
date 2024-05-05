class Reserve implements Runnable { // available berths are 1
    int available = 1;
    int wanted;

    // accept wanted berths at run time
    Reserve(int i) {
            wanted = i;
        }

        public void run() {
            synchronized (this) // synchronize the current object
            { // display available berths
                System.out.println("Available Berths=" + available);
                if (available >= wanted) { // get the name of passenger
                    String name = Thread.currentThread().getName();
                    // allot the berth to him
                    System.out.println(wanted + " Berths reserved for " + name);
                    try {
                        Thread.sleep(1500);
                        available = available - wanted;
                        // update the number of available berths
                    } catch (InterruptedException ie) {
                    }
                }
                // if available berths are less then display sorry
                else
                    System.out.println("Sorry no berths available");
            } // end of synchronization block
        }

}

class a {

    public static void main(String args[]) {// tell that 1 berth is needed
        Reserve obj = new Reserve(1);
        // attach first thread to the object
        Thread t1 = new Thread(obj);
        // attach second thread to the same object
        Thread t2 = new Thread(obj);
        // take the thread names as person names
        t1.setName("First person");
        t2.setName("Second person");
        // send the requests for berth
        t1.start();
        t2.start();
    }
}
