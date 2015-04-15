package something;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;

public class Main {

    public static void main(String[] args) {
        ObjectGraph objectGraph = ObjectGraph.create(new MainModule());

        Runner runner = objectGraph.get(Runner.class);
        runner.run();

        Walker walker = objectGraph.get(Walker.class);
        walker.run();
    }

}
