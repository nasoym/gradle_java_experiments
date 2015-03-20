package something;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class EnumStringTest {

    enum SomeEnums {
      A,B

    };

    public void someMethod(Object name) {
        System.out.println(">>>" + name);
    }

    @Test
    public void doSomeTest() {
        someMethod(SomeEnums.A);
        someMethod(SomeEnums.A.toString());
    }

    public Object foo(String bla) {
        System.out.println("do stuff: " + bla);
        return null;
    }

    @Test
    public void someNullTest() {
        Object aa = null;

        //aa == null ? System.out.println("is null") : System.out.println("is not null");
        Object b;
        b = aa == null ? foo("is null") : foo("is not null");

    }

}
