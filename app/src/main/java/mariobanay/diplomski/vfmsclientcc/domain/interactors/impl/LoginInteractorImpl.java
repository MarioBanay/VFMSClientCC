package mariobanay.diplomski.vfmsclientcc.domain.interactors.impl;

import mariobanay.diplomski.vfmsclientcc.domain.executor.Executor;
import mariobanay.diplomski.vfmsclientcc.domain.executor.MainThread;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.LoginInteractor;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.base.AbstractInteractor;
import mariobanay.diplomski.vfmsclientcc.domain.repository.DatabaseRepository;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.impl.LoginPresenterImpl;

public class LoginInteractorImpl extends AbstractInteractor implements LoginInteractor {

    private LoginInteractor.Callback mCallback;
    private DatabaseRepository mDatabaseRepository;

    public LoginInteractorImpl(Executor threadExecutor, MainThread mainThread, LoginPresenterImpl callback, DatabaseRepository databaseRepository) {
        super(threadExecutor, mainThread);

        mCallback = callback;
        mDatabaseRepository = databaseRepository;

    }

    @Override
    public void run() {


        String username = mCallback.getUsername();
        String password = mCallback.getPassword();

        // retrieve the message OR AUTHENTICATE HERE!!!
        final boolean loginResult = mDatabaseRepository.loginToFirebase(username, password);

        // check if we have failed to retrieve our message
        if (!loginResult) {

            // notify the failure on the main thread
            notifyError("Authentication failed");

            return;
        }

        // we have retrieved our message, notify the UI on the main thread
        postMessage("Authentication Successful");
    }

    private void notifyError(final String error) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onAuthenticationFailed(error);
            }
        });
    }

    private void postMessage(final String message) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onAuthenticationSuccess(message);
            }
        });
    }

}
