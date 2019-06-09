package mariobanay.diplomski.vfmsclientcc.security;

public interface PermissionRepository {

    boolean isGpsEnabled();

    boolean isLocationPermissionGranted();
}
