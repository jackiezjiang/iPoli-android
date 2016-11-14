package io.ipoli.android.challenge.activities;

/**
 * Created by YZ on 11/13/16.
 */

import android.app.Instrumentation;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputEditText;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import io.ipoli.android.quest.data.Quest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.ipoli.android.Constants;
import io.ipoli.android.R;




/**
 * Created by YZ on 11/8/16.
 */

@LargeTest

public class ChallengeActivityInstrumentTest extends ActivityInstrumentationTestCase2<ChallengeActivity> {
    private ChallengeActivity challengeActivity;
    private Instrumentation mInstrumentation;
    private TextInputEditText textInputEditText;
    public ChallengeActivityInstrumentTest() {
        super(ChallengeActivity.class);
    }


    @Override
    public void setUp() throws Exception {
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        super.setUp();
        challengeActivity = getActivity();
        //textInputEditText = (TextInputEditText) quickAddActivity.findViewById(R.id.quick_add_text);




    }

    @Test
    public void testAdd() {

        Toolbar toolbar=  (Toolbar) challengeActivity.findViewById(R.id.toolbar);
        assertNull(toolbar);



    }

}



