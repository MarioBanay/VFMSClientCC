package mariobanay.diplomski.vfmsclientcc.domain.interactors;

import mariobanay.diplomski.vfmsclientcc.domain.interactors.base.Interactor;

public interface PermissionInteractor extends Interactor {

    interface Callback {
        void onGpsEnabled(String message);
        void onGpsDisabled(String message);

        void onPermissionGranted(String error);
    }
}
