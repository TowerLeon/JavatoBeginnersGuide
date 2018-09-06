/**
 * FileName: JavaBeginnersGuideChapter11
 * Author:   Chris Li
 * Date:     9/6/2018 8:31 PM
 * Description:
 * History:
 */

listing 1
// Create a thread by implementing Runnable.

class MyThread implements Runnable {
    int count;
    String thrdName;

    MyThread(String name) {
        count = 0;
        thrdName = name;
    }

    // Entry point of thread.
    public void run() {
        System.out.println(thrdName + " starting.");
        try {
            do {
                Thread.sleep(500);
                System.out.println("In " + thrdName +
                        ", count is " + count);
                count++;
            } while(count < 10);
        }
        catch(InterruptedException exc) {
            System.out.println(thrdName + " interrupted.");
        }
        System.out.println(thrdName + " terminating.");
    }
}

class UseThreads {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");

        // First, construct a MyThread object.
        MyThread mt = new MyThread("Child #1");

        // Next, construct a thread from that object.
        Thread newThrd = new Thread(mt);

        // Finally, start execution of the thread.
        newThrd.start();

        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        } while (mt.count != 10);

        System.out.println("Main thread ending.");
    }
}



listing 2
// Improved MyThread.

class MyThread implements Runnable {
    int count;
    Thread thrd;

    // Construct a new thread.
    MyThread(String name) {
        thrd = new Thread(this, name);
        count = 0;
        thrd.start(); // start the thread
    }

    // Begin execution of new thread.
    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            do {
                Thread.sleep(500);
                System.out.println("In " + thrd.getName() +
                        ", count is " + count);
                count++;
            } while(count < 10);
        }
        catch(InterruptedException exc) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " terminating.");
    }
}

class UseThreadsImproved {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");

        MyThread mt = new MyThread("Child #1");

        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        } while (mt.count != 10);

        System.out.println("Main thread ending.");
    }
}

listing 3
/*
   Project 11-1

   Extend Thread.
*/
class MyThread extends Thread {
    int count;

    // Construct a new thread.
    MyThread(String name) {
        super(name); // name thread
        count = 0;
        start(); // start the thread
    }

    // Begin execution of new thread.
    public void run() {
        System.out.println(getName() + " starting.");
        try {
            do {
                Thread.sleep(500);
                System.out.println("In " + getName() +
                        ", count is " + count);
                count++;
            } while(count < 10);
        }
        catch(InterruptedException exc) {
            System.out.println(getName() + " interrupted.");
        }
        System.out.println(getName() + " terminating.");
    }
}

class ExtendThread {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");

        MyThread mt = new MyThread("Child #1");

        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        } while (mt.count != 10);

        System.out.println("Main thread ending.");
    }
}


listing 4
// Create multiple threads.

class MyThread implements Runnable {
    int count;
    Thread thrd;

    // Construct a new thread.
    MyThread(String name) {
        thrd = new Thread(this, name);
        count = 0;
        thrd.start(); // start the thread
    }

    // Begin execution of new thread.
    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            do {
                Thread.sleep(500);
                System.out.println("In " + thrd.getName() +
                        ", count is " + count);
                count++;
            } while(count < 10);
        }
        catch(InterruptedException exc) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " terminating.");
    }
}

class MoreThreads {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");

        MyThread mt1 = new MyThread("Child #1");
        MyThread mt2 = new MyThread("Child #2");
        MyThread mt3 = new MyThread("Child #3");

        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        } while (mt1.count < 10 ||
                mt2.count < 10 ||
                mt3.count < 10);

        System.out.println("Main thread ending.");
    }
}


listing 5
// Use isAlive().
class MoreThreads {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");

        MyThread mt1 = new MyThread("Child #1");
        MyThread mt2 = new MyThread("Child #2");
        MyThread mt3 = new MyThread("Child #3");

        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        } while (mt1.thrd.isAlive() ||
                mt2.thrd.isAlive() ||
                mt3.thrd.isAlive());

        System.out.println("Main thread ending.");
    }
}

listing 6
// Use join().

class MyThread implements Runnable {
    int count;
    Thread thrd;

    // Construct a new thread.
    MyThread(String name) {
        thrd = new Thread(this, name);
        count = 0;
        thrd.start(); // start the thread
    }

    // Begin execution of new thread.
    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            do {
                Thread.sleep(500);
                System.out.println("In " + thrd.getName() +
                        ", count is " + count);
                count++;
            } while(count < 10);
        }
        catch(InterruptedException exc) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " terminating.");
    }
}

class JoinThreads {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");

        MyThread mt1 = new MyThread("Child #1");
        MyThread mt2 = new MyThread("Child #2");
        MyThread mt3 = new MyThread("Child #3");

        try {
            mt1.thrd.join();
            System.out.println("Child #1 joined.");
            mt2.thrd.join();
            System.out.println("Child #2 joined.");
            mt3.thrd.join();
            System.out.println("Child #3 joined.");
        }
        catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread ending.");
    }
}

listing 7
// Demonstrate thread priorities.

class Priority implements Runnable {
    int count;
    Thread thrd;

    static boolean stop = false;
    static String currentName;

    /* Construct a new thread. Notice that this
       constructor does not actually start the
       threads running. */
    Priority(String name) {
        thrd = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    // Begin execution of new thread.
    public void run() {
        System.out.println(thrd.getName() + " starting.");
        do {
            count++;

            if(currentName != thrd.getName()) {
                currentName = thrd.getName();
                System.out.println("In " + currentName);
            }

        } while(stop == false && count < 1000);
        stop = true;

        System.out.println("\n" + thrd.getName() +
                " terminating.");
    }
}

class PriorityDemo {
    public static void main(String args[]) {
        Priority mt1 = new Priority("High Priority");
        Priority mt2 = new Priority("Low Priority");

        // set the priorities
        mt1.thrd.setPriority(Thread.NORM_PRIORITY+2);
        mt2.thrd.setPriority(Thread.NORM_PRIORITY-2);

        // start the threads
        mt1.thrd.start();
        mt2.thrd.start();

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        }
        catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nHigh priority thread counted to " +
                mt1.count);
        System.out.println("Low priority thread counted to " +
                mt2.count);
    }
}

listing 8
// Use synchronize to control access.

class SumArray {
    private int sum;

    synchronized int sumArray(int nums[]) {
        sum = 0; // reset sum

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            System.out.println("Running total for " +
                    Thread.currentThread().getName() +
                    " is " + sum);
            try {
                Thread.sleep(10); // allow task-switch
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        return sum;
    }
}

class MyThread implements Runnable {
    Thread thrd;
    static SumArray sa = new SumArray();
    int a[];
    int answer;

    // Construct a new thread.
    MyThread(String name, int nums[]) {
        thrd = new Thread(this, name);
        thrd.start(); // start the thread
        a = nums;
    }

    // Begin execution of new thread.
    public void run() {
        int sum;

        System.out.println(thrd.getName() + " starting.");

        answer = sa.sumArray(a);
        System.out.println("Sum for " + thrd.getName() +
                " is " + answer);

        System.out.println(thrd.getName() + " terminating.");
    }
}

class Sync {
    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4, 5};

        MyThread mt1 = new MyThread("Child #1", a);
        MyThread mt2 = new MyThread("Child #2", a);
    }
}


listing 9
// Use a synchronized block to control access to SumArray.
class SumArray {
    private int sum;

    int sumArray(int nums[]) {
        sum = 0; // reset sum

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            System.out.println("Running total for " +
                    Thread.currentThread().getName() +
                    " is " + sum);
            try {
                Thread.sleep(10); // allow task-switch
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        return sum;
    }
}

class MyThread implements Runnable {
    Thread thrd;
    static SumArray sa = new SumArray();
    int a[];
    int answer;

    // Construct a new thread.
    MyThread(String name, int nums[]) {
        thrd = new Thread(this, name);
        thrd.start(); // start the thread
        a = nums;
    }

    // Begin execution of new thread.
    public void run() {
        int sum;

        System.out.println(thrd.getName() + " starting.");

        // synchronize calls to sumArray()
        synchronized(sa) {
            answer = sa.sumArray(a);
        }
        System.out.println("Sum for " + thrd.getName() +
                " is " + answer);

        System.out.println(thrd.getName() + " terminating.");
    }
}

class Sync {
    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4, 5};

        MyThread mt1 = new MyThread("Child #1", a);
        MyThread mt2 = new MyThread("Child #2", a);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}


listing 10
// Use wait() and notify() to create a ticking clock.

class TickTock {

    synchronized void tick(boolean running) {
        if(!running) { // stop the clock
            notify(); // notify any waiting threads
            return;
        }

        System.out.print("Tick ");
        notify(); // let tock() run
        try {
            wait(); // wait for tock() to complete
        }
        catch(InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
    }

    synchronized void tock(boolean running) {
        if(!running) { // stop the clock
            notify(); // notify any waiting threads
            return;
        }

        System.out.println("Tock");
        notify(); // let tick() run
        try {
            wait(); // wait for tick to complete
        }
        catch(InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
    }
}

class MyThread implements Runnable {
    Thread thrd;
    TickTock ttOb;

    // Construct a new thread.
    MyThread(String name, TickTock tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
        thrd.start(); // start the thread
    }

    // Begin execution of new thread.
    public void run() {

        if(thrd.getName().compareTo("Tick") == 0) {
            for(int i=0; i<5; i++) ttOb.tick(true);
            ttOb.tick(false);
        }
        else {
            for(int i=0; i<5; i++) ttOb.tock(true);
            ttOb.tock(false);
        }
    }
}

class ThreadCom {
    public static void main(String args[]) {
        TickTock tt = new TickTock();
        MyThread mt1 = new MyThread("Tick", tt);
        MyThread mt2 = new MyThread("Tock", tt);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}

listing 11
// No calls to wait() or notify().
class TickTock {

    synchronized void tick(boolean running) {
        if(!running) { // stop the clock
            return;
        }

        System.out.print("Tick ");
    }

    synchronized void tock(boolean running) {
        if(!running) { // stop the clock
            return;
        }

        System.out.println("Tock");
    }
}

listing 12
// Suspending, resuming, and stopping a thread.

class MyThread implements Runnable {
    Thread thrd;
    volatile boolean suspended;
    volatile boolean stopped;

    MyThread(String name) {
        thrd = new Thread(this, name);
        suspended = false;
        stopped = false;
        thrd.start();
    }

    // This is the entry point for thread.
    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            for(int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if((i%10)==0) {
                    System.out.println();
                    Thread.sleep(250);
                }

                // Use synchronized block to check suspended and stopped.
                synchronized(this) {
                    while(suspended) {
                        wait();
                    }
                    if(stopped) break;
                }
            }
        } catch (InterruptedException exc) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " exiting.");
    }

    // Stop the thread.
    synchronized void mystop() {
        stopped = true;

        // The following lets a suspended thread be stopped.
        suspended = false;
        notify();
    }

    // Suspend the thread.
    synchronized void mysuspend() {
        suspended = true;
    }

    // Resume the thread.
    synchronized void myresume() {
        suspended = false;
        notify();
    }
}

class Suspend {
    public static void main(String args[]) {
        MyThread ob1 = new MyThread("My Thread");

        try {
            Thread.sleep(1000); // let ob1 thread start executing

            ob1.mysuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            ob1.myresume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);


            ob1.mysuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            ob1.myresume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            ob1.mysuspend();
            System.out.println("Stopping thread.");
            ob1.mystop();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        // wait for thread to finish
        try {
            ob1.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("Main thread exiting.");
    }
}

listing 13
/*
   Project 11-2

   Controlling the main thread.
*/

class UseMain {
    public static void main(String args[]) {
        Thread thrd;

        // Get the main thread.
        thrd = Thread.currentThread();

        // Display main thread's name.
        System.out.println("Main thread is called: " +
                thrd.getName());

        // Display main thread's priority.
        System.out.println("Priority: " +
                thrd.getPriority());

        System.out.println();

        // Set the name and priority.
        System.out.println("Setting name and priority.\n");
        thrd.setName("Thread #1");
        thrd.setPriority(Thread.NORM_PRIORITY+3);

        System.out.println("Main thread is now called: " +
                thrd.getName());

        System.out.println("Priority is now: " +
                thrd.getPriority());
    }
}
