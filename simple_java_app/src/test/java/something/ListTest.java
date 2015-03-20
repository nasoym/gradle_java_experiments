package something;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ListTest {

    List<String> returnAList() {
        System.out.println("returnAList");
        return new ArrayList<String>(){{
            add("abc");
            add("abc");
            add("abc");
        }};
    }

    @Test
    public void doSomeTest() {
        for (String name : returnAList() ) {
            System.out.println(">>>" + name);
        }
    }

    @Test
    public void insertInList() {
        List<String> someList = new ArrayList<String>();
        System.out.println("0: ");
        printList(someList);
        someList.add(0, "one");
        System.out.println("1: ");
        printList(someList);
        someList.add(0, "two");
        System.out.println("2: ");
        printList(someList);
        
    }

    public void printList(List<String> list) {
        for (String name : list) {
            System.out.println(">>>" + name);
        }
    }

}
