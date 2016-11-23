package io.ipoli.android.settings;


import android.app.Instrumentation;
import android.support.design.widget.NavigationView;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;


import com.robotium.solo.Solo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import io.ipoli.android.MainActivity;
import io.ipoli.android.R;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static java.lang.Thread.sleep;

/**
 * Created by YZ on 11/23/16.
 */

@LargeTest
public class SettingsFragmentInstrumentTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;
    private MainActivity mMainActivity;
    private Instrumentation mInstrumentation;
    private NavigationView navigationView;
    private View contentContainer;
    private DrawerLayout drawerLayout;
    private SettingsFragment settingsFragment;
    public SettingsFragmentInstrumentTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        super.setUp();
        mMainActivity = getActivity();
        settingsFragment = new SettingsFragment();

        //contentContainer = mMainActivity.findViewById(R.id.content_container );
        //drawerLayout = (DrawerLayout) mMainActivity.findViewById(R.id.drawer_layout);
        //navigationView = (NavigationView) mMainActivity.findViewById(R.id.navigation_view);

    }




    @Test
    public void testGetFragment() throws Exception {


        FragmentManager fragmentManager = mMainActivity.getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(settingsFragment, null);

        assertNotNull(fragmentTransaction.commit());

        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fragmentManager.executePendingTransactions();
            }
        });

        getInstrumentation().waitForIdleSync();

        //Thread.currentThread().sleep(10000);

        RelativeLayout relativeLayout = (RelativeLayout) settingsFragment.getView().findViewById(R.id.ongoing_notification_container);
       Switch switch_notify = (Switch) settingsFragment.getView().findViewById(R.id.ongoing_notification);


        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch_notify.performClick();
                switch_notify.performClick();
            }
        });

    }





}



