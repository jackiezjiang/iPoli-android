package io.ipoli.android.challenge.activities;

import android.app.Instrumentation;
import android.support.design.widget.TextInputEditText;
import android.support.test.filters.LargeTest;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

import com.robotium.solo.Solo;

import org.junit.Test;

import io.ipoli.android.R;

import static android.os.SystemClock.sleep;

/**
 * Created by YZ on 11/21/16.
 */

@LargeTest
public class ChallengeCompleteActivityInstrumentTest extends ActivityInstrumentationTestCase2<ChallengeCompleteActivity> {

    private ChallengeCompleteActivity challengeCompleteActivity;
    private Instrumentation mInstrumentation;
    public ChallengeCompleteActivityInstrumentTest() {
        super(ChallengeCompleteActivity.class);
    }


    @Override
    public void setUp() throws Exception {

        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        super.setUp();
        challengeCompleteActivity = getActivity();

    }


    @Test
    public void testTitle() {
        TextView textView = (TextView) challengeCompleteActivity.findViewById(R.id.experience_text);
        assertEquals("0", textView.getText());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void testDone() {
        Button done = (Button) challengeCompleteActivity.findViewById(R.id.done);
        challengeCompleteActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                done.callOnClick();
            }
        });


    }



}
