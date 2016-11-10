package io.ipoli.android;

import android.app.Fragment;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.DrawerLayout;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;

import com.robotium.solo.Solo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.ipoli.android.app.activities.QuickAddActivity;
import io.ipoli.android.quest.activities.EditQuestActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.flurry.sdk.kp.a.f;


/**
 * Created by YZ on 11/8/16.
 */

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public static final String ACTION_ADD_QUEST_FROM_WIDGET = "io.ipoli.android.intent.action.ADD_QUEST_FROM_WIDGET";
    private Solo solo;
    private MainActivity mMainActivity;
    private Instrumentation mInstrumentation;

    private View contentContainer;;



    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        super.setUp();
        mMainActivity = getActivity();

        contentContainer = mMainActivity.findViewById(R.id.content_container );

    }


    @Test
    public void test1() {
        View mainActivityDecorView = mMainActivity.getWindow().getDecorView();
        ViewAsserts.assertOnScreen(mainActivityDecorView, contentContainer);
    }






}
