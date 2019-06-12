package mariobanay.diplomski.vfmsclientcc.presentation.presenters.impl;

import android.util.Log;

import mariobanay.diplomski.vfmsclientcc.domain.executor.Executor;
import mariobanay.diplomski.vfmsclientcc.domain.executor.MainThread;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.LoginInteractor;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.impl.LoginInteractorImpl;
import mariobanay.diplomski.vfmsclientcc.domain.repository.DatabaseRepository;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.MainPresenter;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.base.AbstractPresenter;
import mariobanay.diplomski.vfmsclientcc.presentation.ui.fragment.LoginFragment;

import static mariobanay.diplomski.vfmsclientcc.Constants.LOGIN_TAG;

public class LoginPresenterImpl extends AbstractPresenter implements MainPresenter,
        LoginInteractor.Callback {


    private MainPresenter.View mView;
    private DatabaseRepository mDatabaseRepository;

    public LoginPresenterImpl(Executor executor, MainThread mainThread, View view, DatabaseRepository databaseRepository) {
        super(executor, mainThread);

        mView = view;
        mDatabaseRepository = databaseRepository;
    }


    @Override
    public void resume() {


        mView.showProgress();

        // initialize the interactor
        LoginInteractor interactor = new LoginInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                mDatabaseRepository
        );


        // HERE IS INTERACTOR STARTED!!!!!!!!!!

        // run the interactor
        interactor.execute();

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {
        // calling method showError() in classes that implement this Presenter
        mView.showError(message);
    }

    @Override
    public void onAuthenticationSuccess(String message) {
        // calling method displayWelcomeMessage() in classes that implement this Presenter

        mView.hideProgress();
        mView.displayWelcomeMessage(message);
        Log.i(LOGIN_TAG,  LoginPresenterImpl.class.getSimpleName() + " -> " + "METHOD: " + "onAuthenticationSuccess(String msg)");
    }

    @Override
    public void onAuthenticationFailed(String error) {
        // calling method hideProgress() in classes that implement this Presenter

        mView.hideProgress();
        onError(error);
        Log.i(LOGIN_TAG,  LoginPresenterImpl.class.getSimpleName() + " -> " + "METHOD: " + "onAuthenticationFailed(String msg)");

    }

    @Override
    public String getUsername() {
        String username = mView.getUsernameFromScreen();
        return username;
    }

    @Override
    public String getPassword() {
        String password = mView.getPasswordFromScreen();
        return password;    }

}
