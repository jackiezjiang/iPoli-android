package io.ipoli.android.challenge.activities;
import android.app.Instrumentation;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;


import org.junit.Test;

import io.ipoli.android.R;

/**
 * Created by YZ on 11/13/16.
 */

public class EditChallengeActivityInstrumentTest extends ActivityInstrumentationTestCase2<EditChallengeActivity> {

    private EditChallengeActivity editChallengeActivity;
    private Instrumentation mInstrumentation;
    private TextInputEditText textInputEditText;
    public EditChallengeActivityInstrumentTest() {
        super(EditChallengeActivity.class);
    }


    @Override
    public void setUp() throws Exception {
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        super.setUp();
        editChallengeActivity = getActivity();
        //textInputEditText = (TextInputEditText) quickAddActivity.findViewById(R.id.quick_add_text);




    }

    @Test
    public void testAdd() {

        TextInputEditText textInputEditText=  (TextInputEditText) editChallengeActivity.findViewById(R.id.challenge_name);
        assertNotNull(textInputEditText);



    }



}
