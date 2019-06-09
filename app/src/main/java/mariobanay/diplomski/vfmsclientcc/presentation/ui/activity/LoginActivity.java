package mariobanay.diplomski.vfmsclientcc.presentation.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import mariobanay.diplomski.vfmsclientcc.R;
import mariobanay.diplomski.vfmsclientcc.presentation.ui.fragment.LoginFragment;
import mariobanay.diplomski.vfmsclientcc.presentation.ui.fragment.PermissionFragment;

import static mariobanay.diplomski.vfmsclientcc.Constants.PERMISSIONS_REQUEST;

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
