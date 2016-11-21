package io.ipoli.android.challenge.activities;

import android.app.Fragment;
import android.app.Instrumentation;
import android.support.design.widget.TextInputEditText;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import org.junit.Test;

import io.ipoli.android.R;
import io.ipoli.android.app.ui.CategoryView;
import io.ipoli.android.challenge.ui.dialogs.MultiTextPickerFragment;
import io.ipoli.android.quest.ui.dialogs.TextPickerFragment;

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
        textInputEditText = (TextInputEditText) editChallengeActivity.findViewById(R.id.challenge_name);




    }

    @Test
    public void testAdd() {


        final String text = "TESTChallenge at 20:00 for 2 hours tomorrow";
        editChallengeActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                textInputEditText.setText(text);
            }


        });

        CategoryView categoryView = (CategoryView) editChallengeActivity.findViewById(R.id.challenge_category);
        ImageView imageView = (ImageView) categoryView.findViewById(R.id.category_personal);

        RelativeLayout relativeLayout = (RelativeLayout)  editChallengeActivity.findViewById(R.id.challenge_expected_results_container);

        editChallengeActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                imageView.callOnClick();
                relativeLayout.performClick();
            }


        });


        TextView challengeQuestion = (TextView) editChallengeActivity.findViewById(R.id.challenge_expected_results_question);
        assertNotNull(challengeQuestion.getText().toString());



        ActionMenuItemView save=  (ActionMenuItemView) editChallengeActivity.findViewById(R.id.action_save);
        assertNotNull(save);
        editChallengeActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                save.performClick();



            }
        });




    }



}
