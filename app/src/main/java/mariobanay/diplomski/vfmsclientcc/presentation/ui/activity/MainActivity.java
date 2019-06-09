package mariobanay.diplomski.vfmsclientcc.presentation.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import mariobanay.diplomski.vfmsclientcc.R;
import mariobanay.diplomski.vfmsclientcc.domain.executor.impl.ThreadExecutor;
import mariobanay.diplomski.vfmsclientcc.presentation.navigation.Navigator;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.MainPresenter;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.MainPresenter.View;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.impl.GpsPresenterImpl;
import mariobanay.diplomski.vfmsclientcc.security.GpsPermissionRepository;
import mariobanay.diplomski.vfmsclientcc.threading.MainThreadImpl;

import static mariobanay.diplomski.vfmsclientcc.Constants.TAG;

public class MainActivity extends AppCompatActivity implements View {

    //@BindView(R.id.welcome_textview)
    TextView mWelcomeTextView;

    private MainPresenter mPresenter;

    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Entered onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigator = Navigator.getInstance();

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Returned from GpsPermissionActivity()");

        // create a presenter for this view
        mPresenter = new GpsPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                new GpsPermissionRepository()
        );
        navigateToLocationPermissionFragment();
        navigateToGpsPermissionFragment();
    }

    private void navigateToGpsPermissionFragment() {
        this.navigator.navigateToGpsPermission(this);

    }

    void navigateToLocationPermissionFragment() {
        this.navigator.navigateToLocationPermission(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Entered onResume()");


        // let's start welcome message retrieval when the app resumes
        mPresenter.resume();

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Exiting onResume()");

    }

    @Override
    public void showProgress() {

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Entered showProgress()");

        //mWelcomeTextView.setText("Retrieving...");
        Toast.makeText(this, "Retrieving...", Toast.LENGTH_LONG).show();

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Exiting showProgress()");

    }

    @Override
    public void hideProgress() {

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Entered hideProgress()");

        Toast.makeText(this, "Retrieved!", Toast.LENGTH_LONG).show();

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Exiting hideProgress()");

    }

    @Override
    public void showError(String message) {

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Entered showError()");

        //mWelcomeTextView.setText(message);

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Exiting showError()");

    }

    @Override
    public void displayWelcomeMessage(String msg) {

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Entered displayWelcomeMessage()");

        //mWelcomeTextView.setText(msg);

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Exiting displayWelcomeMessage()");

    }
}
