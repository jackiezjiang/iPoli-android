package io.ipoli.android.quest.activities;

import android.app.Instrumentation;
import android.support.design.widget.TextInputEditText;
import android.support.v7.view.menu.ActionMenuItemView;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.robotium.solo.Solo;

import org.junit.Test;

import io.ipoli.android.R;
import io.ipoli.android.quest.ui.AddQuestAutocompleteTextView;

import static android.support.test.InstrumentationRegistry.getInstrumentation;


/**
 * Created by YZ on 11/21/16.
 */

public class EditQuestActivityInstrumentTest extends ActivityInstrumentationTestCase2<EditQuestActivity> {
        private EditQuestActivity editQuestActivity;
        private Instrumentation mInstrumentation;
        private AddQuestAutocompleteTextView addQuestAutocompleteTextView;
        private Solo solo;
        public EditQuestActivityInstrumentTest() {
            super(EditQuestActivity.class);
        }


        @Override
        public void setUp() throws Exception {

            setActivityInitialTouchMode(true);
            mInstrumentation = getInstrumentation();
            super.setUp();
            editQuestActivity= getActivity();
            addQuestAutocompleteTextView = (AddQuestAutocompleteTextView) editQuestActivity.findViewById(R.id.quest_text);
            solo = new Solo(getInstrumentation(),getActivity());
        }


    @Test
    public void testEmptyText() {

        String text = "Test today at 17:00 for 10 min";


        editQuestActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                addQuestAutocompleteTextView.setText(text);


            }
        });


        solo.clickOnView(solo.getView(R.id.action_save));

        solo.clickOnView(solo.getView(R.id.quest_end_date_container));
        solo.clickOnButton("OK");

        solo.clickOnView(solo.getView(R.id.quest_start_time_container));
        solo.clickOnButton("OK");

        solo.clickOnView(solo.getView(R.id.quest_duration_container));
        solo.clickOnButton("OK");

        solo.clickOnView(solo.getView(R.id.quest_frequency_container));
        solo.clickOnButton("DONE");

        //solo.clickOnView(solo.getView(R.id.quest_add_reminder_container));
        //solo.enterText(0, "lazy");
        //solo.clickOnButton("OK");

       // solo.clickOnView(solo.getView(R.id.quest_note_container));
        //solo.enterText(1, "test");
        //solo.clickOnButton("OK");





        solo.clickOnView(solo.getView(R.id.action_save));



    }



}
