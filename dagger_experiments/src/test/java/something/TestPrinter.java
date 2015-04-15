package something;

public class TestPrinter extends Printer {

    public TestPrinter() {
        System.out.println("Test Printer is created");
    }

    @Override
    public String print() {
        return "hello from test printer";
    }

}
