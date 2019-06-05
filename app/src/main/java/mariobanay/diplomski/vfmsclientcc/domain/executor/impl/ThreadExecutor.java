package mariobanay.diplomski.vfmsclientcc.domain.executor.impl;

import android.util.Log;

import mariobanay.diplomski.vfmsclientcc.domain.executor.Executor;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.base.AbstractInteractor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static mariobanay.diplomski.vfmsclientcc.Constants.TAG;

/**
 * This singleton class will make sure that each interactor operation gets a background thread.
 * <p/>
 */
public class ThreadExecutor implements Executor {

    // This is a singleton
    private static volatile ThreadExecutor sThreadExecutor;

    private static final int CORE_POOL_SIZE  = 3;
    private static final int MAX_POOL_SIZE   = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<Runnable>();

    private ThreadPoolExecutor mThreadPoolExecutor;

    private ThreadExecutor() {

        Log.d(TAG + Thread.currentThread().getId(), ThreadExecutor.class.getSimpleName() + " ->" + " Entered ThreadExecutor constructor");

        long keepAlive = KEEP_ALIVE_TIME;
        mThreadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                keepAlive,
                TIME_UNIT,
                WORK_QUEUE);

        Log.d(TAG + Thread.currentThread().getId(), ThreadExecutor.class.getSimpleName() + " ->" + " Exiting ThreadExecutor constructor");

    }

    @Override
    public void execute(final AbstractInteractor interactor) {

        Log.d(TAG + Thread.currentThread().getId(), ThreadExecutor.class.getSimpleName() + " ->" + " Entered execute()" );

        mThreadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG + Thread.currentThread().getId(), ThreadExecutor.class.getSimpleName() + " ->" + " Inside submit() running - " + interactor.toString() + " interactor on thread: " + Thread.currentThread().getId());

                // run the main logic
                interactor.run();

                // mark it as finished
                interactor.onFinished();

                Log.d(TAG + Thread.currentThread().getId(), ThreadExecutor.class.getSimpleName() + " ->" + " Inside submit() finished running - " + interactor.toString() + " interactor on thread: " + Thread.currentThread().getId());

            }
        });

        Log.d(TAG + Thread.currentThread().getId(), ThreadExecutor.class.getSimpleName() + " ->" + " Exiting execute()");

    }

    /**
     * Returns a singleton instance of this executor. If the executor is not initialized then it initializes it and returns
     * the instance.
     */
    public static Executor getInstance() {

        Log.d(TAG + Thread.currentThread().getId(), ThreadExecutor.class.getSimpleName() + " ->" + " Entered getInstance()");

        if (sThreadExecutor == null) {
            sThreadExecutor = new ThreadExecutor();
        }

        Log.d(TAG + Thread.currentThread().getId(), ThreadExecutor.class.getSimpleName() + " ->" + " Will exit from getInstance() after return...");

        return sThreadExecutor;
    }
}
