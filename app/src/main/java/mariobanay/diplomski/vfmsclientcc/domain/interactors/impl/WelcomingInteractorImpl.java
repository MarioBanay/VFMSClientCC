package mariobanay.diplomski.vfmsclientcc.domain.interactors.impl;

import android.util.Log;

import mariobanay.diplomski.vfmsclientcc.domain.interactors.WelcomingInteractor;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.base.AbstractInteractor;

import mariobanay.diplomski.vfmsclientcc.domain.executor.Executor;
import mariobanay.diplomski.vfmsclientcc.domain.executor.MainThread;
import mariobanay.diplomski.vfmsclientcc.domain.repository.MessageRepository;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.impl.MainPresenterImpl;

import static mariobanay.diplomski.vfmsclientcc.Constants.TAG;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class WelcomingInteractorImpl extends AbstractInteractor implements WelcomingInteractor {

    private WelcomingInteractor.Callback mCallback;
    private MessageRepository            mMessageRepository;

    public WelcomingInteractorImpl(Executor threadExecutor,
                                   MainThread mainThread,
                                   MainPresenterImpl callback, MessageRepository messageRepository) {
        super(threadExecutor, mainThread);

        Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Entered WelcomingInteractorImpl constructor");

        mCallback = callback;
        mMessageRepository = messageRepository;

        Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Exiting WelcomingInteractorImpl constructor");

    }

    private void notifyError() {

        Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Entered notifyError()");

        mMainThread.post(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Inside notifyError() posting error message on thread: " + Thread.currentThread().getId());


                mCallback.onRetrievalFailed("Nothing to welcome you with :(");

                Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Inside notifyError() finishing posting error message on thread: " + Thread.currentThread().getId());

            }
        });

        Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Exiting notifyError()");

    }

    private void postMessage(final String msg) {

        Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Entered postMessage()");


        mMainThread.post(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Inside postMessage() posting message: " + msg  + " on thread: " + Thread.currentThread().getId());

                mCallback.onMessageRetrieved(msg);

                Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Inside postMessage() finishing posting message: " + msg  + " on thread: " + Thread.currentThread().getId());

            }
        });

        Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Exiting postMessage()");

    }

    @Override
    public void run() {

        Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Entered run()");

        // retrieve the message
        final String message = mMessageRepository.getWelcomeMessage();

        // check if we have failed to retrieve our message
        if (message == null || message.length() == 0) {

            // notify the failure on the main thread
            notifyError();

            return;
        }

        // we have retrieved our message, notify the UI on the main thread
        postMessage(message);

        Log.d(TAG + Thread.currentThread().getId(), WelcomingInteractorImpl.class.getSimpleName() + " ->" + " Exiting run()");

    }

    @Override
    public String toString() {
        return "WelcomingInteractorImpl";
    }
}
