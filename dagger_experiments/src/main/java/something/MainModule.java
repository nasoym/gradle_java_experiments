package something;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(
    injects = {
        Runner.class,
        Walker.class
    }
)
public class MainModule {

    @Provides @Singleton Printer providePrinter() {
        System.out.println("providePrinter");
        return new Printer();
    }

}
