package mariobanay.diplomski.vfmsclientcc.presentation.presenters.base;

import android.util.Log;
import mariobanay.diplomski.vfmsclientcc.domain.executor.Executor;
import mariobanay.diplomski.vfmsclientcc.domain.executor.MainThread;

import static mariobanay.diplomski.vfmsclientcc.Constants.TAG;

/**
 * This is a base class for all presenters which are communicating with interactors. This base class will hold a
 * reference to the Executor and MainThread objects that are needed for running interactors in a background thread.
 */
public abstract class AbstractPresenter {
    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {

        Log.d(TAG + Thread.currentThread().getId(), AbstractPresenter.class.getSimpleName() + " ->" + " Entered AbstractPresenter constructor");

        mExecutor = executor;
        mMainThread = mainThread;

        Log.d(TAG + Thread.currentThread().getId(), AbstractPresenter.class.getSimpleName() + " ->" + " Exiting AbstractPresenter constructor");

    }
}
