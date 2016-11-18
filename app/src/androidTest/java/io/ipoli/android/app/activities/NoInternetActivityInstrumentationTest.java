package io.ipoli.android.app.activities;

import android.app.Instrumentation;
import android.support.design.widget.TextInputEditText;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.ipoli.android.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.*;

/**
 * Created by YZ on 11/8/16.
 */

@LargeTest

public class NoInternetActivityInstrumentationTest extends ActivityInstrumentationTestCase2<NoInternetActivity> {
        private NoInternetActivity noInternetActivity;
        private Instrumentation mInstrumentation;

        public NoInternetActivityInstrumentationTest() {
            super(NoInternetActivity.class);
        }



        @Override
    public void setUp() throws Exception {
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        super.setUp();
            noInternetActivity = getActivity();


    }



    @Test
    public void test1() {
        noInternetActivity.onConfirm();



    }




}
