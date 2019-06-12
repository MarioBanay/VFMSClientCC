package mariobanay.diplomski.vfmsclientcc.data;

import android.util.Log;
import mariobanay.diplomski.vfmsclientcc.domain.repository.MessageRepository;

import static mariobanay.diplomski.vfmsclientcc.Constants.TAG;

/**
 * Created by dmilicic on 1/29/16.
 */
public class WelcomeMessageRepository implements MessageRepository {

    @Override
    public String getWelcomeMessage() {

        Log.d(TAG + Thread.currentThread().getId(), WelcomeMessageRepository.class.getSimpleName() + " ->" + " Entered getWelcomeMessage()");

        String msg = "Welcome, friend!"; // let's be friendly

        // let's simulate some network/database lag
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG + Thread.currentThread().getId(), WelcomeMessageRepository.class.getSimpleName() + " ->" + " Will exit from getWelcomeMessage() after return...");

        return msg;
    }
}
