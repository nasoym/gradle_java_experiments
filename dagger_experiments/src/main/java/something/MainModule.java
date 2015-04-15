package something;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(
    injects = {
        Runner.class,
        Walker.class
    },
    library = true
)
public class MainModule {

    @Provides @Singleton Printer providePrinter() {
        System.out.println("providePrinter");
        return new Printer();
    }

    @Provides Walker provideWalker() {
        System.out.println("provideWalker");
        return new Walker(new Printer());
    }

}
