package mariobanay.diplomski.vfmsclientcc.presentation.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import mariobanay.diplomski.vfmsclientcc.R;
import mariobanay.diplomski.vfmsclientcc.presentation.ui.fragment.LoginFragment;

public class LoginActivity extends BaseActivity {

    public static Intent getCallingIntent(Context context) {
        Intent callingIntent = new Intent(context, LoginActivity.class);
        return callingIntent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(R.id.fragmentContainer, new LoginFragment());


    }
}
