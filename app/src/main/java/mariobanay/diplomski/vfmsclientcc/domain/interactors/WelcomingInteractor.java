package mariobanay.diplomski.vfmsclientcc.domain.interactors;


import mariobanay.diplomski.vfmsclientcc.domain.interactors.base.Interactor;


public interface WelcomingInteractor extends Interactor {

    interface Callback {
        void onMessageRetrieved(String message);

        void onRetrievalFailed(String error);
    }
}
