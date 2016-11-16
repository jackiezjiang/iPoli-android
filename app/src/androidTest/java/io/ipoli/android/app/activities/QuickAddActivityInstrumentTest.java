package io.ipoli.android.app.activities;

import android.app.Instrumentation;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.ipoli.android.Constants;
import io.ipoli.android.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

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


         Button button=  (Button) quickAddActivity.findViewById(R.id.cancel);
          textInputEditText = (TextInputEditText) quickAddActivity.findViewById(R.id.quick_add_text);




    }

   
    @Test
    public void testAdd() {
        String additionalText = "TEST";
        Button button=  (Button) quickAddActivity.findViewById(R.id.add);
        pressImeActionButton();
        
        
        
         final String text = "TEST" + additionalText;
        quickAddActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                textInputEditText.setText(text);
            }


        });


    }



    @Test
    public void testCancel() {

        Button button=  (Button) quickAddActivity.findViewById(R.id.cancel);
        pressImeActionButton();


    }




}
