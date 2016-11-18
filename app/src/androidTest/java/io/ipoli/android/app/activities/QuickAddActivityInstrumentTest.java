package io.ipoli.android.app.activities;

import android.app.Instrumentation;
import android.support.design.widget.TextInputEditText;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import io.ipoli.android.app.ui.CategoryView;
import io.ipoli.android.quest.data.Quest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.ipoli.android.Constants;
import io.ipoli.android.R;


import static android.content.Intent.getIntentOld;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by YZ on 11/8/16.
 */

@LargeTest

public class QuickAddActivityInstrumentTest extends ActivityInstrumentationTestCase2<QuickAddActivity> {
    private QuickAddActivity quickAddActivity;
    private Instrumentation mInstrumentation;
    private TextInputEditText textInputEditText;
    public QuickAddActivityInstrumentTest() {
        super(QuickAddActivity.class);
    }


    @Override
    public void setUp() throws Exception {
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        super.setUp();
        quickAddActivity = getActivity();
        textInputEditText = (TextInputEditText) quickAddActivity.findViewById(R.id.quick_add_text);




    }

    @Test
    public void testAdd() {
         
        Button button=  (Button) quickAddActivity.findViewById(R.id.add);
       
       final String text = "TEST at 20:00 for 2 hours tomorrow";
        quickAddActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                textInputEditText.setText(text);
            }


        });



        CategoryView categoryView = (CategoryView) quickAddActivity.findViewById(R.id.quest_category);
        ImageView imageView = (ImageView) categoryView.findViewById(R.id.category_wellness);

        quickAddActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {

                imageView.callOnClick();

            }



        });
        Button button = (Button) quickAddActivity.findViewById(R.id.cancel);
        View.OnClickListener myhandler1 = new View.OnClickListener() {
            public void onClick(View v) {
                quickAddActivity.onAddQuest(v);
            }
        };

        quickAddActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        });


    }

/*

    @Test
    public void testCancel() {
        quickAddActivity = getActivity();
         quickAddActivity.hideKeyboard();
        Button button=  (Button) quickAddActivity.findViewById(R.id.cancel);
        pressImeActionButton();


    }

*/
    
    
       @Test
    public void testCancel() {
        quickAddActivity = getActivity();
        //quickAddActivity.hideKeyboard();

        Button button=  (Button) quickAddActivity.findViewById(R.id.cancel);
        View.OnClickListener myhandler1 = new View.OnClickListener() {
            public void onClick(View v) {
                quickAddActivity.onCancel(v);
            }
        };

        
       quickAddActivity.runOnUiThread(new Runnable() {
        @Override
        public void run() {

         button.performClick();
        }
    });

       


    }





}
