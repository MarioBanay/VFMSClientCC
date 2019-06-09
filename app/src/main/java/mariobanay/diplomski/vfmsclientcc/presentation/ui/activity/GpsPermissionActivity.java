package mariobanay.diplomski.vfmsclientcc.presentation.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import mariobanay.diplomski.vfmsclientcc.R;
import mariobanay.diplomski.vfmsclientcc.presentation.ui.fragment.PermissionFragment;

public class GpsPermissionActivity extends BaseActivity {

    public static Intent getCallingIntent(Context context) {
        Intent callingIntent = new Intent(context, GpsPermissionActivity.class);
        return callingIntent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check GPS is enabled
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            addFragment(R.id.fragmentContainer, new PermissionFragment());

        } else {
            finish();
        }
    }
}
