package mariobanay.diplomski.vfmsclientcc.domain.interactors;

import mariobanay.diplomski.vfmsclientcc.domain.interactors.base.Interactor;

public interface LoginInteractor extends Interactor {

    interface Callback {
        void onAuthenticationSuccess(String message);
        void onAuthenticationFailed(String error);
        String getUsername();
        String getPassword();

    }
}
