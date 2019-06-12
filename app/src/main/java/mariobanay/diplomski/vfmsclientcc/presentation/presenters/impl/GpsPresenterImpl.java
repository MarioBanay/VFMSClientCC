package mariobanay.diplomski.vfmsclientcc.presentation.presenters.impl;

import mariobanay.diplomski.vfmsclientcc.domain.executor.Executor;
import mariobanay.diplomski.vfmsclientcc.domain.executor.MainThread;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.PermissionInteractor;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.impl.PermissionInteractorImpl;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.MainPresenter;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.base.AbstractPresenter;
import mariobanay.diplomski.vfmsclientcc.security.PermissionRepository;

public class GpsPresenterImpl extends AbstractPresenter implements MainPresenter, PermissionInteractor.Callback {

    private MainPresenter.View mView;
    private PermissionRepository mPermissionRepository;

    public GpsPresenterImpl(Executor executor, MainThread mainThread, View view, PermissionRepository permissionRepository) {
        super(executor, mainThread);

        mView = view;
        mPermissionRepository = permissionRepository;
    }

    @Override
    public void onGpsEnabled(String message) {
        mView.hideProgress();
        mView.displayWelcomeMessage("Permission GPS is enabled");
    }

    @Override
    public void onGpsDisabled(String message) {
        mView.hideProgress();
        mView.displayWelcomeMessage("Permission GPS is disabled");
    }

    @Override
    public void onPermissionGranted(String error) {

    }

    @Override
    public void resume() {

        mView.showProgress();

        // initialize the interactor
        PermissionInteractor interactor = new PermissionInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                mPermissionRepository
        );

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
        mView.showError(message);

    }
}
