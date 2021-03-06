package io.ipoli.android;

import android.app.Fragment;
import android.app.Instrumentation;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.DrawerLayout;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.robotium.solo.Solo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.ipoli.android.app.activities.QuickAddActivity;
import io.ipoli.android.quest.activities.EditQuestActivity;
import io.ipoli.android.quest.events.DuplicateQuestRequestEvent;
import io.ipoli.android.quest.events.EditQuestRequestEvent;

import static android.os.SystemClock.sleep;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


import static com.flurry.sdk.kp.a.f;
import static java.lang.Enum.valueOf;


/**
 * Created by YZ on 11/8/16.
 */
@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public static final String ACTION_ADD_QUEST_FROM_WIDGET = "io.ipoli.android.intent.action.ADD_QUEST_FROM_WIDGET";
    private Solo solo;
    private MainActivity mMainActivity;
    private Instrumentation mInstrumentation;
    private NavigationView navigationView;
    private View contentContainer;
    private DrawerLayout drawerLayout;




    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        super.setUp();
        mMainActivity = getActivity();
        solo = new Solo(mInstrumentation, mMainActivity);
        contentContainer = mMainActivity.findViewById(R.id.content_container );
        drawerLayout = (DrawerLayout) mMainActivity.findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) mMainActivity.findViewById(R.id.navigation_view);

    }



    @Test
    public void testAddButton() {
        sleep(10000);

        FloatingActionButton quickAdd = (FloatingActionButton) mMainActivity.findViewById(R.id.add_quest);
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                quickAdd.callOnClick();

            }
        });


    }


     @Test
    public void testMenu() {


        Menu menu = navigationView.getMenu();
        MenuItem challenges = menu.findItem(R.id.challenges);
        MenuItem  overView= menu.findItem(R.id.overview);
         MenuItem calendar = menu.findItem(R.id.calendar);
         MenuItem inbox = menu.findItem(R.id.inbox);
         MenuItem repeating_quests = menu.findItem(R.id.repeating_quests);
         MenuItem growth = menu.findItem(R.id.growth);
         MenuItem rewards = menu.findItem(R.id.rewards);
         MenuItem invite_friends = menu.findItem(R.id.invite_friends);
         MenuItem settings = menu.findItem(R.id.settings);
         MenuItem feedback = menu.findItem(R.id.feedback);
         MenuItem contact_us = menu.findItem(R.id.contact_us);






        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                drawerLayout.openDrawer(navigationView);
                assertNotNull(challenges);
                mMainActivity.onNavigationItemSelected(challenges);



            }
        });

         try {
             Thread.currentThread().sleep(10000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         mMainActivity.runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 drawerLayout.openDrawer(navigationView);
                 assertNotNull(overView);
                 mMainActivity.onNavigationItemSelected(overView);



             }
         });




         try {
             Thread.currentThread().sleep(10000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         mMainActivity.runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 drawerLayout.openDrawer(navigationView);
                 assertNotNull(inbox);
                 mMainActivity.onNavigationItemSelected(inbox);



             }
         });



         try {
             Thread.currentThread().sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         mMainActivity.runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 drawerLayout.openDrawer(navigationView);
                 assertNotNull(repeating_quests);
                 mMainActivity.onNavigationItemSelected(repeating_quests);



             }
         });


         try {
             Thread.currentThread().sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         mMainActivity.runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 drawerLayout.openDrawer(navigationView);
                 assertNotNull(growth);
                 mMainActivity.onNavigationItemSelected(growth);



             }
         });



         try {
             Thread.currentThread().sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         mMainActivity.runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 drawerLayout.openDrawer(navigationView);
                 assertNotNull(rewards);
                 mMainActivity.onNavigationItemSelected(rewards);



             }
         });



         mMainActivity.runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 drawerLayout.openDrawer(navigationView);
                 assertNotNull(settings);
                 mMainActivity.onNavigationItemSelected(settings);



             }
         });

         try {
             Thread.currentThread().sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }


         try {
             Thread.currentThread().sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }



         mMainActivity.runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 drawerLayout.openDrawer(navigationView);
                 assertNotNull(feedback);
                 mMainActivity.onNavigationItemSelected(feedback);



             }
         });


    }
    

}
