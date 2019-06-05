package mariobanay.diplomski.vfmsclientcc.domain.model;

import android.util.Log;


import static mariobanay.diplomski.vfmsclientcc.Constants.TAG;

/**
 * A sample model. Replace this with your own.
 */
public class SampleModel {

    private int mValue;

    public SampleModel(int value) {

        Log.d(TAG + Thread.currentThread().getId(), SampleModel.class.getSimpleName() + " ->" + " Entered SampleModel constructor");

        mValue = value;

        Log.d(TAG + Thread.currentThread().getId(), SampleModel.class.getSimpleName() + " ->" + " Exiting SampleModel constructor");

    }

    public int getValue() {

        Log.d(TAG + Thread.currentThread().getId(), SampleModel.class.getSimpleName() + " ->" + " Entered getValue()");
        Log.d(TAG + Thread.currentThread().getId(), SampleModel.class.getSimpleName() + " ->" + " Will exit from getValue() after return...");

        return mValue;
    }
}
