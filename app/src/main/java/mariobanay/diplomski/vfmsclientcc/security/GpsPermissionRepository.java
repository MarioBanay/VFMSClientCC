package mariobanay.diplomski.vfmsclientcc.security;

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
