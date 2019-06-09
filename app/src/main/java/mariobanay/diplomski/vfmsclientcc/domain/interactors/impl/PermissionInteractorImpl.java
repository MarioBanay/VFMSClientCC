package mariobanay.diplomski.vfmsclientcc.domain.interactors.impl;

import mariobanay.diplomski.vfmsclientcc.domain.executor.Executor;
import mariobanay.diplomski.vfmsclientcc.domain.executor.MainThread;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.PermissionInteractor;
import mariobanay.diplomski.vfmsclientcc.domain.interactors.base.AbstractInteractor;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.impl.GpsPresenterImpl;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.impl.MainPresenterImpl;
import mariobanay.diplomski.vfmsclientcc.security.PermissionRepository;

public class PermissionInteractorImpl extends AbstractInteractor implements PermissionInteractor {

    private PermissionInteractor.Callback mCallback;
    private PermissionRepository mPermissionRepository;

    public PermissionInteractorImpl(Executor threadExecutor, MainThread mainThread, GpsPresenterImpl callback, PermissionRepository permissionRepository) {
        super(threadExecutor, mainThread);

        mCallback = callback;
        mPermissionRepository = permissionRepository;

    }

    @Override
    public void run() {

        boolean isGpsEnabled = mPermissionRepository.isGpsEnabled();

        // check if we have failed to retrieve our message
        if (!isGpsEnabled) {

            // notify the failure on the main thread
            notifyError();

            return;
        }

        notifySucess();
    }

    private void notifySucess() {

        mMainThread.post(new Runnable() {
            @Override
            public void run() {

                mCallback.onGpsEnabled("Gps is enabled");

            }
        });
    }

    private void notifyError() {

        mMainThread.post(new Runnable() {
            @Override
            public void run() {

                mCallback.onGpsDisabled("GPS is disabled");

            }
        });
    }
}
