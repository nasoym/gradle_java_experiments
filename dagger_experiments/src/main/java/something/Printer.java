package something;

import javax.inject.Singleton;

@Singleton
public class Printer {

    public Printer() {
        System.out.println("Printer is created");
    }

    public String print() {
        return "hello from printer";
    }

}
