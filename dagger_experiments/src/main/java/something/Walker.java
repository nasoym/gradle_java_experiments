package something;

import javax.inject.Inject;

public class Walker extends Runner {

    Printer newPrinter;

    @Inject
    public Walker(Printer printer) {
        System.out.println("Walker is created");
        this.newPrinter = printer;
    }

    @Override
    public void run() {
        System.out.println("Walker run: " + newPrinter.print());
    }

}
