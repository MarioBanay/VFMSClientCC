package mariobanay.diplomski.vfmsclientcc.presentation.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import mariobanay.diplomski.vfmsclientcc.R;

/**
 * Fragment representing the login screen for Shrine.
 */
public class LoginFragment extends BaseFragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Snippet from "Navigate to the next Fragment" section goes here.

        return view;
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
}
