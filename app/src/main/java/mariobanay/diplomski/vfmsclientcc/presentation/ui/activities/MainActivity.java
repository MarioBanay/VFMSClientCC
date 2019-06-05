package mariobanay.diplomski.vfmsclientcc.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import mariobanay.diplomski.vfmsclientcc.R;
import mariobanay.diplomski.vfmsclientcc.domain.executor.impl.ThreadExecutor;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.MainPresenter;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.MainPresenter.View;
import mariobanay.diplomski.vfmsclientcc.presentation.presenters.impl.MainPresenterImpl;
import mariobanay.diplomski.vfmsclientcc.storage.WelcomeMessageRepository;
import mariobanay.diplomski.vfmsclientcc.threading.MainThreadImpl;

import butterknife.ButterKnife;
import static mariobanay.diplomski.vfmsclientcc.Constants.TAG;

public class MainActivity extends AppCompatActivity implements View {

    @BindView(R.id.welcome_textview)
    TextView mWelcomeTextView;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Entered onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // create a presenter for this view
        mPresenter = new MainPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                new WelcomeMessageRepository()
        );

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Exiting onCreate()");

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

        mWelcomeTextView.setText("Retrieving...");

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

        mWelcomeTextView.setText(message);

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Exiting showError()");

    }

    @Override
    public void displayWelcomeMessage(String msg) {

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Entered displayWelcomeMessage()");

        mWelcomeTextView.setText(msg);

        Log.d(TAG + Thread.currentThread().getId(), MainActivity.class.getSimpleName() + " ->" + " Exiting displayWelcomeMessage()");

    }
}
