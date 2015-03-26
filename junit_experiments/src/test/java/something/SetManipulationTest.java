package something;

import java.util.*;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

public class SetManipulationTest {
    Set<String> oldNames = new HashSet<String>(){{
        add("one");
        add("two");
        add("three");
    }};
    Set<String> newNames = new HashSet<String>(){{
        add("three");
        add("four");
        add("five");
    }};

    @Test
    public void unionOfSets() {
        Set<String> nameUnion = new HashSet<String>(oldNames);
        nameUnion.addAll(newNames);
        assertThat(nameUnion, hasSize(5));
        assertThat(nameUnion, hasItems("one", "two", "three", "four", "five"));
    }

    @Test
    public void intersectionOfSets() {
        Set<String> nameUnion = new HashSet<String>(oldNames);
        nameUnion.retainAll(newNames);
        assertThat(nameUnion, hasSize(1));
        assertThat(nameUnion, hasItem("three"));
    }

    @Test
    public void differenceOfSets() {
        Set<String> nameUnion = new HashSet<String>(oldNames);
        nameUnion.removeAll(newNames);
        assertThat(nameUnion, hasSize(2));
        assertThat(nameUnion, hasItems("one", "two"));
    }

    @Test
    public void filteredSet() {
        Set<String> filteredNames = new HashSet<String>(oldNames);
        Iterator<String> it = filteredNames.iterator();
        while( it.hasNext() ) {
            String name = it.next();
            if ( name.equals("one") ) it.remove();
        }
        assertThat(filteredNames, hasSize(2));
        assertThat(filteredNames, hasItems("two", "three"));
    }

    @Test
    public void filteredSetWithGuava() {
        Set<String> filteredNames = Sets.filter(
            oldNames, 
            new Predicate<String>() {
                @Override
                public boolean apply(String input) {
                    if (input.equals("one")) return false;
                    return true;
                }
            });
        assertThat(filteredNames, hasSize(2));
        assertThat(filteredNames, hasItems("two", "three"));
    }

    @Test
    public void canConvertToList() {
        List<String> nameList = new ArrayList<String>(oldNames);
        assertThat(oldNames, hasSize(3));
        assertThat(oldNames, hasItems("one", "two", "three"));
    }

}
