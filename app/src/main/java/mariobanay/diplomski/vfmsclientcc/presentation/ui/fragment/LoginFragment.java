package mariobanay.diplomski.vfmsclientcc.presentation.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;

import mariobanay.diplomski.vfmsclientcc.R;
import mariobanay.diplomski.vfmsclientcc.data.FirebaseDatabase;
import mariobanay.diplomski.vfmsclientcc.domain.executor.impl.ThreadExecutor;
import mariobanay.diplomski.vfmsclientcc.presentation.navigation.Navigator;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.MainPresenter;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.impl.LoginPresenterImpl;
import mariobanay.diplomski.vfmsclientcc.threading.MainThreadImpl;

import static mariobanay.diplomski.vfmsclientcc.Constants.LOGIN_TAG;


/**
 * Fragment representing the login screen for Shrine.
 */
public class LoginFragment extends BaseFragment implements MainPresenter.View {

    private MainPresenter mLoginPresenter;


    Navigator navigator;


    TextView tvUsername;
    TextView tvPassword;
    Button btnExit;
    Button btnLogin;
    Button btnResetPassword;
    String username;
    String password;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        navigator = Navigator.getInstance();

        // Snippet from "Navigate to the next Fragment" section goes here.

        mLoginPresenter = new LoginPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                new FirebaseDatabase()
        );


        tvUsername = view.findViewById(R.id.tvUsername);
        tvPassword = view.findViewById(R.id.tvPassword);
        btnExit = view.findViewById(R.id.btnExit);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnResetPassword = view.findViewById(R.id.btnResetPassword);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finishAffinity();
            }
        });

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastMessage("Reset Password Clicked");
                // Code to reset password
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = tvUsername.getText().toString();
                password = tvPassword.getText().toString();

                mLoginPresenter.resume();
            }
        });

        return view;
    }

    @Override
    public void displayWelcomeMessage(String msg) {
        Log.i(LOGIN_TAG,  LoginFragment.class.getSimpleName() + " -> " + "METHOD: " + "displayWelcomeMessage(String msg)");
        tvUsername.setText("SUCCESS");
        getActivity().finish();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {
        Log.i(LOGIN_TAG,  LoginFragment.class.getSimpleName() + " -> " + "METHOD: " + "showError(String message)");
        tvUsername.setText("FAILED");
    }

    @Override
    public String getUsernameFromScreen() {
        return username;
    }

    @Override
    public String getPasswordFromScreen() {
        return password;
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
}
