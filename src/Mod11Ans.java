/**
 * FileName: Mod11Ans
 * Author:   Chris Li
 * Date:     9/6/2018 8:36 PM
 * Description:
 * History:
 */

listing 1
// Make the TickTock class actually keep time.

class TickTock {

    synchronized void tick(boolean running) {
        if(!running) { // stop the clock
            notify(); // notify any waiting threads
            return;
        }

        System.out.print("Tick ");

        // wait 1/2 second
        try {
            Thread.sleep(500);
        } catch(InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }

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

        // wait 1/2 second
        try {
            Thread.sleep(500);
        } catch(InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }

        notify(); // let tick() run
        try {
            wait(); // wait for tick to complete
        }
        catch(InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
    }
}
