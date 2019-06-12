package mariobanay.diplomski.vfmsclientcc.data;

import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import mariobanay.diplomski.vfmsclientcc.domain.repository.DatabaseRepository;

import static mariobanay.diplomski.vfmsclientcc.Constants.LOGIN_TAG;

public class FirebaseDatabase implements DatabaseRepository {


    @Override
    public boolean loginToFirebase(String username, String password) {


        final boolean[] isLoginSuccessful = new boolean[1];
        Log.i(LOGIN_TAG, FirebaseDatabase.class.getSimpleName() + " -> " + "METHOD: " + "loginToFirebase(String username, String password) -> BEFORE");

        // Authenticate with Firebase, and request location updates
        FirebaseAuth.getInstance().signInWithEmailAndPassword(
                username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i(LOGIN_TAG, FirebaseDatabase.class.getSimpleName() + " -> " + "METHOD: " + "loginToFirebase(String username, String password) -> SUCCESS");
                    //FirebaseUser user = mAuth.getCurrentUser();
                    isLoginSuccessful[0] = true;
                } else {
                    Log.i(LOGIN_TAG, FirebaseDatabase.class.getSimpleName() + " -> " + "METHOD: " + "loginToFirebase(String username, String password) -> FAILED");
                    isLoginSuccessful[0] = false;

                }
            }
        });

        // TREBA RIJEŠITI DRUGAČIJE DA NE ZAUSTAVLJAŠ TREAD!!!
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return isLoginSuccessful[0];
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

}

