package mariobanay.diplomski.vfmsclientcc.presentation.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import mariobanay.diplomski.vfmsclientcc.R;

/**
 * Fragment representing the login screen for Shrine.
 */
public class PermissionFragment extends BaseFragment {

    Button btnExit;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_permission, container, false);

        btnExit = view.findViewById(R.id.btnExit);

        // Snippet from "Navigate to the next Fragment" section goes here.
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finishAffinity();

            }
        });


        return view;
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
}
