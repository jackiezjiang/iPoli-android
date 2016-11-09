package io.ipoli.android.app.activities;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.ipoli.android.Constants;
import io.ipoli.android.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by YZ on 11/8/16.
 */

@LargeTest
@RunWith(AndroidJUnit4.class)
public class QuickAddActivityInstrumentTest {

    @Rule
    public ActivityTestRule<QuickAddActivity> quickAddActivityActivityTestRule = new ActivityTestRule<QuickAddActivity>(QuickAddActivity.class);



    @Test
    public void testCancel() {
        Intent i = new Intent(mainActivityTestRule.getActivity(), MainActivity.class);
        i.setAction(ACTION_ADD_QUEST_FROM_WIDGET);

            onView(withId(R.id.drawer_layout)).perform(click());

    }

    


}
