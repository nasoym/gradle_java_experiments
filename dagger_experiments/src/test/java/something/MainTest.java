package something;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;

public class MainTest {

    @Module(
        includes = MainModule.class,
        overrides = true
    )
    static class TestModule {
        @Provides Printer providePrinter() {
            System.out.println("provideTestPrinter");
            return new TestPrinter();
        }
    }

    ObjectGraph objectGraph;

    @Before
    public void setupModule() {
        objectGraph = ObjectGraph.create(new TestModule());
    }

    @Test
    public void testRunner() {
        Runner runner = objectGraph.get(Runner.class);
        runner.run();
    }

    @Test
    public void testWalker() {
        Walker walker = objectGraph.get(Walker.class);
        walker.run();
    }

}
