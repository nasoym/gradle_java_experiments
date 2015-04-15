package something;

import javax.inject.Inject;

public class Runner implements Runnable {

    @Inject Printer printer;

    @Inject
    public Runner() {
        System.out.println("Runner is created");
    }

    @Override
    public void run() {
        System.out.println("Runner run: " + printer.print());
    }

}
