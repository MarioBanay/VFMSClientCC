package mariobanay.diplomski.vfmsclientcc.security;

import android.content.Context;
import android.location.LocationManager;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import static android.content.Context.LOCATION_SERVICE;

public class GpsPermissionRepository implements PermissionRepository {
    @Override
    public boolean isGpsEnabled() {

        return false;
    }

    @Override
    public boolean isLocationPermissionGranted() {
        return false;
    }
}
