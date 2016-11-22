package io.ipoli.android.quest.activities;

import android.app.Instrumentation;
import android.support.design.widget.TextInputEditText;
import android.support.test.filters.LargeTest;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Test;

import io.ipoli.android.challenge.activities.ChallengeActivity;

/**
 * Created by YZ on 11/21/16.
 */


/**
 * Created by YZ on 11/13/16.
 */

    import android.app.Instrumentation;
    import android.support.design.widget.AppBarLayout;
    import android.support.design.widget.TextInputEditText;
    import android.support.test.filters.LargeTest;
    import android.support.test.rule.ActivityTestRule;
    import android.support.test.runner.AndroidJUnit4;
    import android.test.ActivityInstrumentationTestCase2;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.Toolbar;

    import io.ipoli.android.app.ui.CategoryView;
    import io.ipoli.android.challenge.data.Challenge;
    import io.ipoli.android.quest.data.Quest;
    import org.junit.Rule;
    import org.junit.Test;
    import org.junit.runner.RunWith;

    import io.ipoli.android.Constants;
    import io.ipoli.android.R;

    import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
    import static java.lang.Thread.sleep;


    /**
     * Created by YZ on 11/8/16.
     */

    @LargeTest

    public class QuestActivityInstrumentTest extends ActivityInstrumentationTestCase2<QuestActivity> {
        private QuestActivity questActivity ;
        private Instrumentation mInstrumentation;
        private TextInputEditText textInputEditText;
        public QuestActivityInstrumentTest() {
            super(QuestActivity.class);
        }


        @Override
        public void setUp() throws Exception {
            setActivityInitialTouchMode(true);
            mInstrumentation = getInstrumentation();
            super.setUp();
            questActivity = getActivity();



        }

        @Test
        public void testAdd1() {
            questActivity.findViewById((R.id.tabs));
        }




    }














