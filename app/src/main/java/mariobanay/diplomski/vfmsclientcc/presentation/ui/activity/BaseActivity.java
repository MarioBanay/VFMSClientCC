package mariobanay.diplomski.vfmsclientcc.presentation.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Base {@link android.app.Activity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  /**
   * Adds a {@link Fragment} to this activity's layout.
   *
   * @param containerViewId The container view to where add the fragment.
   * @param fragment The fragment to be added.
   */
  protected void addFragment(int containerViewId, Fragment fragment) {
    final FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
    fragmentTransaction.add(containerViewId, fragment);
    fragmentTransaction.commit();
  }


}
