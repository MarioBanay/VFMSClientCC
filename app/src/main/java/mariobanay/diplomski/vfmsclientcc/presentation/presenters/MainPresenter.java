package mariobanay.diplomski.vfmsclientcc.presentation.presenters;

import mariobanay.diplomski.vfmsclientcc.presentation.presenters.base.BasePresenter;
import mariobanay.diplomski.vfmsclientcc.presentation.ui.BaseView;


public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {
        void displayWelcomeMessage(String msg);
    }
}
