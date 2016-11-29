package io.ipoli.android.app.activities;

import android.app.Instrumentation;
import android.support.design.widget.TextInputEditText;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.ipoli.android.R;
import io.ipoli.android.app.ui.NoInternetDialogFragment;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static java.lang.Thread.sleep;

/**
 * Created by YZ on 11/8/16.
 */

@LargeTest

public class NoInternetActivityInstrumentationTest extends ActivityInstrumentationTestCase2<NoInternetActivity> {
    private NoInternetActivity noInternetActivity;
    private Instrumentation mInstrumentation;
    private Solo solo;
    private NoInternetDialogFragment noInternetDialogFragment;
    public NoInternetActivityInstrumentationTest() {
            super(NoInternetActivity.class);
        }

    @Override
    public void setUp() throws Exception {
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        super.setUp();
        noInternetDialogFragment = new NoInternetDialogFragment();
        noInternetActivity = getActivity();
        solo = new Solo(getInstrumentation(),getActivity());

    }


    @Test
    public void testConfirm() {

        FragmentManager fragmentManager = noInternetActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(noInternetDialogFragment, null);

        assertNotNull(fragmentTransaction.commit());
        noInternetActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fragmentManager.executePendingTransactions();
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        this.solo.clickOnButton("OK");
        //noInternetActivity.onConfirm();

    }



}
