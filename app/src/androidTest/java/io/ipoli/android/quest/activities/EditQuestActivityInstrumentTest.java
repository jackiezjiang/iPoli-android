package io.ipoli.android.quest.activities;

import android.app.Instrumentation;
import android.support.design.widget.TextInputEditText;
import android.support.v7.view.menu.ActionMenuItemView;
import android.test.ActivityInstrumentationTestCase2;
import android.view.MenuItem;
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


        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        ActionMenuItemView button = (ActionMenuItemView) editQuestActivity.findViewById(R.id.action_save);

        editQuestActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {

                button.callOnClick();

            }
        });

        /*
        editQuestActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {

                editQuestActivity.saveQuest();

            }
        });


*/








    }

}
