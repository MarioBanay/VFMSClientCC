package mariobanay.diplomski.vfmsclientcc.presentation.presenters.impl;

import android.util.Log;
import mariobanay.diplomski.vfmsclientcc.domain.executor.Executor;
import mariobanay.diplomski.vfmsclientcc.domain.executor.MainThread;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.WelcomingInteractor;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.impl.WelcomingInteractorImpl;
import mariobanay.diplomski.vfmsclientcc.domain.repository.MessageRepository;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.MainPresenter;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.base.AbstractPresenter;

import static mariobanay.diplomski.vfmsclientcc.Constants.TAG;

/**
 * Created by dmilicic on 12/13/15.
 */
public class MainPresenterImpl extends AbstractPresenter implements MainPresenter,
        WelcomingInteractor.Callback {

    private MainPresenter.View mView;
    private MessageRepository  mMessageRepository;

    public MainPresenterImpl(Executor executor, MainThread mainThread,
                             View view, MessageRepository messageRepository) {
        super(executor, mainThread);

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Entered MainPresenterImpl constructor");

        mView = view;
        mMessageRepository = messageRepository;

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Exiting MainPresenterImpl constructor");

    }

    @Override
    public void resume() {
        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Entered resume()");

        mView.showProgress();

        // initialize the interactor
        WelcomingInteractor interactor = new WelcomingInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                mMessageRepository
        );

        // run the interactor
        interactor.execute();

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Exiting resume()");

    }

    @Override
    public void pause() {

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Entered pause()");
        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Exiting pause()");

    }

    @Override
    public void stop() {

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Entered stop()");
        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Exiting stop()");

    }

    @Override
    public void destroy() {

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Entered destroy()");
        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Exiting destroy()");

    }

    @Override
    public void onError(String message) {

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Entered onError()");

        mView.showError(message);

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Exiting onError()");

    }

    @Override
    public void onMessageRetrieved(String message) {

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Entered onMessageRetrieved()");

        mView.hideProgress();
        mView.displayWelcomeMessage(message);

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Exiting onMessageRetrieved()");

    }

    @Override
    public void onRetrievalFailed(String error) {

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Entered onRetrievalFailed()");

        mView.hideProgress();
        onError(error);

        Log.d(TAG + Thread.currentThread().getId(), MainPresenterImpl.class.getSimpleName() + " ->" + " Exiting onRetrievalFailed()");

    }
}
