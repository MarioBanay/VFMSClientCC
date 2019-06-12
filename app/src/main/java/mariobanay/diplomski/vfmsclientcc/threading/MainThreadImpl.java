package mariobanay.diplomski.vfmsclientcc.threading;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import mariobanay.diplomski.vfmsclientcc.domain.executor.MainThread;

import static mariobanay.diplomski.vfmsclientcc.Constants.TAG;


/**
 * This class makes sure that the runnable we provide will be run on the main UI thread.
 */
public class MainThreadImpl implements MainThread {

    private static MainThread sMainThread;

    private Handler mHandler;

    private MainThreadImpl() {

        Log.d(TAG + Thread.currentThread().getId(), MainThreadImpl.class.getSimpleName() + " ->" + " Entered MainThreadImpl constructor");

        mHandler = new Handler(Looper.getMainLooper());

        Log.d(TAG + Thread.currentThread().getId(), MainThreadImpl.class.getSimpleName() + " ->" + " Exiting MainThreadImpl constructor");

    }

    @Override
    public void post(Runnable runnable) {

        Log.d(TAG + Thread.currentThread().getId(), MainThreadImpl.class.getSimpleName() + " ->" + " Entered post()");

        mHandler.post(runnable);

        Log.d(TAG + Thread.currentThread().getId(), MainThreadImpl.class.getSimpleName() + " ->" + " Exiting post()");

    }

    public static MainThread getInstance() {

        Log.d(TAG + Thread.currentThread().getId(), MainThreadImpl.class.getSimpleName() + " ->" + " Entered getInstance()");

        if (sMainThread == null) {
            sMainThread = new MainThreadImpl();
        }

        Log.d(TAG + Thread.currentThread().getId(), MainThreadImpl.class.getSimpleName() + " ->" + " Will exit from getInstance() after return...");

        return sMainThread;
    }
}
