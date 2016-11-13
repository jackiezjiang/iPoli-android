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


    }

    public void testCancel() {
        pressImeActionButton();

    }




}
