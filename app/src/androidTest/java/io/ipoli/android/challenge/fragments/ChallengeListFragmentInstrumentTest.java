package io.ipoli.android.challenge.fragments;

import android.app.Instrumentation;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.test.filters.LargeTest;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.test.ActivityInstrumentationTestCase2;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.robotium.solo.Solo;

import org.junit.Test;

import io.ipoli.android.MainActivity;
import io.ipoli.android.R;


/**
 * Created by YZ on 11/23/16.
 */



/**
 * Created by YZ on 11/23/16.
 */

@LargeTest



public class ChallengeListFragmentInstrumentTest  extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;
    private MainActivity mMainActivity;
    private Instrumentation mInstrumentation;
    private NavigationView navigationView;
    private View contentContainer;
    private DrawerLayout drawerLayout;

    private ChallengeListFragment challengeListFragment;
    public ChallengeListFragmentInstrumentTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        super.setUp();
        mMainActivity = getActivity();
        challengeListFragment = new ChallengeListFragment();

        contentContainer = mMainActivity.findViewById(R.id.content_container );
        drawerLayout = (DrawerLayout) mMainActivity.findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) mMainActivity.findViewById(R.id.navigation_view);

    }




    @Test
    public void testGetFragment() throws Exception {
        Menu menu = navigationView.getMenu();
        MenuItem challenges = menu.findItem(R.id.challenges);


        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                drawerLayout.openDrawer(navigationView);
                assertNotNull(challenges);
                FragmentManager fragmentManager = mMainActivity.getSupportFragmentManager();
                mMainActivity.onNavigationItemSelected(challenges);


                ChallengeListFragment fragment = (ChallengeListFragment)fragmentManager.findFragmentById(R.id.content_container);
                FloatingActionButton addChallenge = (FloatingActionButton) fragment.getView().findViewById(R.id.add_challenge);
                assertNotNull(addChallenge);


                addChallenge.performClick();

            }
        });





    }



}



