package mariobanay.diplomski.vfmsclientcc.domain.interactors.base;

import android.util.Log;

import mariobanay.diplomski.vfmsclientcc.domain.executor.Executor;
import mariobanay.diplomski.vfmsclientcc.domain.executor.MainThread;

import static mariobanay.diplomski.vfmsclientcc.Constants.TAG;

/**
 * Created by dmilicic on 8/4/15.
 * <p/>
 * This abstract class implements some common methods for all interactors. Cancelling an interactor, check if its running
 * and finishing an interactor has mostly the same code throughout so that is why this class was created. Field methods
 * are declared volatile as we might use these methods from different threads (mainly from UI).
 * <p/>
 * For example, when an activity is getting destroyed then we should probably cancel an interactor
 * but the request will come from the UI thread unless the request was specifically assigned to a background thread.
 */
public abstract class AbstractInteractor implements Interactor {

    protected Executor   mThreadExecutor;
    protected MainThread mMainThread;

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    public AbstractInteractor(Executor threadExecutor, MainThread mainThread) {

        Log.d(TAG + Thread.currentThread().getId(), AbstractInteractor.class.getSimpleName() + " ->" + " Entered AbstractInteractor constructor");

        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;

        Log.d(TAG + Thread.currentThread().getId(), AbstractInteractor.class.getSimpleName() + " ->" + " Exiting AbstractInteractor constructor");

    }

    /**
     * This method contains the actual business logic of the interactor. It SHOULD NOT BE USED DIRECTLY but, instead, a
     * developer should call the execute() method of an interactor to make sure the operation is done on a background thread.
     * <p/>
     * This method should only be called directly while doing unit/integration tests. That is the only reason it is declared
     * public as to help with easier testing.
     */
    public abstract void run();

    public void cancel() {

        Log.d(TAG + Thread.currentThread().getId(), AbstractInteractor.class.getSimpleName() + " ->" + " Entered cancel()");

        mIsCanceled = true;
        mIsRunning = false;

        Log.d(TAG + Thread.currentThread().getId(), AbstractInteractor.class.getSimpleName() + " ->" + " Exiting cancel()");

    }

    public boolean isRunning() {

        Log.d(TAG + Thread.currentThread().getId(), AbstractInteractor.class.getSimpleName() + " ->" + " Entered isRunning()");
        Log.d(TAG + Thread.currentThread().getId(), AbstractInteractor.class.getSimpleName() + " ->" + " Will exit from isRunning() after return...");

        return mIsRunning;
    }

    public void onFinished() {

        Log.d(TAG + Thread.currentThread().getId(), AbstractInteractor.class.getSimpleName() + " ->" + " Entered onFinished()");

        mIsRunning = false;
        mIsCanceled = false;

        Log.d(TAG + Thread.currentThread().getId(), AbstractInteractor.class.getSimpleName() + " ->" + " Exiting onFinished()");

    }

    public void execute() {

        Log.d(TAG + Thread.currentThread().getId(), AbstractInteractor.class.getSimpleName() + " ->" + " Entered execute()");

        // mark this interactor as running
        this.mIsRunning = true;

        // start running this interactor in a background thread
        mThreadExecutor.execute(this);

        Log.d(TAG + Thread.currentThread().getId(), AbstractInteractor.class.getSimpleName() + " ->" + " Exiting execute()");

    }
}
