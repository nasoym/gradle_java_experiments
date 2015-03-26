package something;

import java.util.*;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListOperationTest {
    List<String> oldNames = new ArrayList<String>(){{
        add("one");
        add("two");
        add("three");
    }};
    List<String> newNames = new ArrayList<String>(){{
        add("three");
        add("four");
        add("five");
    }};

    @Test
    public void unionOfLists() {
        List<String> nameUnion = new ArrayList<String>(oldNames);
        nameUnion.addAll(newNames);
        assertThat(nameUnion, hasSize(6));
        assertThat(nameUnion, hasItems("one", "two", "three", "four", "five"));
    }

    @Test
    public void intersectionOfLists() {
        List<String> nameUnion = new ArrayList<String>(oldNames);
        nameUnion.retainAll(newNames);
        assertThat(nameUnion, hasSize(1));
        assertThat(nameUnion, hasItem("three"));
    }

    @Test
    public void differenceOfLists() {
        List<String> nameUnion = new ArrayList<String>(oldNames);
        nameUnion.removeAll(newNames);
        assertThat(nameUnion, hasSize(2));
        assertThat(nameUnion, hasItems("one", "two"));
    }

    @Test
    public void filteredLists() {
        List<String> filteredNames = new ArrayList<String>(oldNames);
        Iterator<String> it = filteredNames.iterator();
        while( it.hasNext() ) {
            String name = it.next();
            if ( name.equals("one") ) it.remove();
        }
        assertThat(filteredNames, hasSize(2));
        assertThat(filteredNames, hasItems("two", "three"));
    }

}
