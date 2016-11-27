package io.ipoli.android.challenge.activities;

import android.app.Instrumentation;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.robotium.solo.Solo;

import org.junit.Test;

import io.ipoli.android.R;
import io.ipoli.android.app.ui.CategoryView;
import io.ipoli.android.challenge.ui.dialogs.MultiTextPickerFragment;
import io.ipoli.android.quest.ui.dialogs.TextPickerFragment;

import static android.view.MotionEvent.ACTION_BUTTON_PRESS;
import static java.lang.Thread.sleep;

/**
 * Created by YZ on 11/13/16.
 */

public class EditChallengeActivityInstrumentTest extends ActivityInstrumentationTestCase2<EditChallengeActivity> {

    private EditChallengeActivity editChallengeActivity;
    private Instrumentation mInstrumentation;
    private TextInputEditText textInputEditText;
    private Solo solo;
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

        solo = new Solo(getInstrumentation(),getActivity());


    }


/*
    @Test
    public void testAdd() {

        final String text = "TESTChallenge at 20:00 for 2 hours tomorrow";
        solo.enterText(0, text);

        this.solo.clickOnView(solo.getView(R.id.challenge_category).findViewById(R.id.category_personal));


        this.solo.clickOnView(solo.getView(R.id.challenge_expected_results_container));

        solo.enterText(1, "result");
        solo.clickOnButton("OK");

        this.solo.clickOnView((solo.getView(R.id.challenge_reasons_container)));
        solo.enterText(1, "like it");
        solo.clickOnButton("OK");



        this.solo.clickOnView((solo.getView(R.id.challenge_end_date_container)));
        solo.clickOnButton("OK");

        this.solo.clickOnView((solo.getView(R.id.challenge_difficulty_container)));
        solo.clickOnButton("OK");

        //solo.clickOnView(solo.getView(R.id.action_save));




    }


*/

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


        editChallengeActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {

                imageView.callOnClick();

            }
        });

        RelativeLayout relativeLayout = (RelativeLayout)  editChallengeActivity.findViewById(R.id.challenge_expected_results_container);



        editChallengeActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {


                relativeLayout.performClick();
            }


        });


        TextView challengeQuestion = (TextView) editChallengeActivity.findViewById(R.id.challenge_expected_results_question);
        assertNotNull(challengeQuestion.getText().toString());


        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Hello Android!");

        getInstrumentation().waitForIdleSync();




        solo.clickOnButton("OK");




        RelativeLayout relativeLayoutResons = (RelativeLayout)  editChallengeActivity.findViewById(R.id.challenge_reasons_container);



        editChallengeActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {


                relativeLayoutResons.performClick();
            }


        });



        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("To keep healthy");
        getInstrumentation().waitForIdleSync();
        solo.clickOnButton("OK");

        solo.clickOnView(solo.getView(R.id.action_save));




        


        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



}
