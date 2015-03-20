package something;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

import java.util.concurrent.Future;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorServiceTest {

    final static Logger LOG = LoggerFactory.getLogger(ExecutorServiceTest.class);

    public void doSomeWork() {
        LOG.debug("starting");
        long testStartTime = System.currentTimeMillis();
        long m = 0;
        long u = 0;
        for( int i=0; i<Integer.MAX_VALUE; i++) {
            /* for( int j=0; j<2; j++) { */
                m += i;
                /* u = m + i * u; */
            /* } */
        }
        LOG.debug("got: " + m);
        /* LOG.debug("got: " + Integer.MAX_VALUE); */
        long testDuration = System.currentTimeMillis() - testStartTime;
        LOG.debug("stopping: duration: " + testDuration);
        /* LOG.debug("stopping"); */
    }

    public void doSomeWait() {
        doSomeWait(1000);
    }

    public void doSomeWait(int milliseconds) {
        try {
            LOG.debug("starting");
            Thread.sleep(milliseconds);
            LOG.debug("stopping");
        } catch (InterruptedException e) {
            LOG.debug("InterruptedException: " + e);
        }
    }

    @Test
    public void foo() {
        LOG.debug("start test");
        long testStartTime = System.currentTimeMillis();
        int threadNumber = 4 * 10;
        final CountDownLatch doneSignal = new CountDownLatch(threadNumber);
        List<Future> futures = new ArrayList<Future>();
        /* ExecutorService executorService = Executors.newSingleThreadExecutor(); */
        ExecutorService executorService = Executors.newCachedThreadPool();
        /* ExecutorService executorService = Executors.newFixedThreadPool(threadNumber); */
        /* ExecutorService executorService = Executors.newFixedThreadPool(4); */
        for( int i=0; i<threadNumber; i++) {
            futures.add(
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        doSomeWork();
                        doneSignal.countDown();
                    }
                })
            );
        }

        LOG.debug("wait for count down");
        final List<Future> futuresToKill = new ArrayList<Future>(futures);
        Thread killAll = new Thread() {
            @Override
            public void run() {
                doSomeWait(200);
                LOG.debug("killall");
                for (Future future : futuresToKill) {
                    future.cancel(true);
                }
            }
        };
        killAll.start();
        try {
            while(true) {
                LOG.debug("checking countdown");
                if (doneSignal.await(1000, TimeUnit.MILLISECONDS)) {
                    LOG.debug("count down latch is done");
                    break;
                }
                boolean noOngoingTasks = true;
                for (Future future : futures) {
                    if (!future.isDone() && !future.isCancelled() ){
                        LOG.debug("found an ongoing task");
                        noOngoingTasks = false;
                        break;
                    }
                }
                if (noOngoingTasks) {
                    LOG.debug("all tasks are canceled or done");
                    break;
                }
            }
        } catch (InterruptedException e) {
            LOG.debug("InterruptedException: " + e);
        }
        LOG.debug("count down is finished");
        long testDuration = System.currentTimeMillis() - testStartTime;
        LOG.debug("stop test duration: " + testDuration);
    }

}
