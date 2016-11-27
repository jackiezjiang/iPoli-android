package io.ipoli.android.reward.activities;

import android.animation.LayoutTransition;
import android.app.Instrumentation;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.robotium.solo.Solo;

import org.junit.Test;

import java.util.ArrayList;

import io.ipoli.android.R;
import io.ipoli.android.app.activities.QuickAddActivity;
import io.ipoli.android.app.ui.EmptyStateRecyclerView;
import io.ipoli.android.challenge.fragments.ChallengeListFragment;
import io.ipoli.android.quest.ui.dialogs.TextPickerFragment;
import io.ipoli.android.reward.fragments.RewardListFragment;

import static android.view.KeyEvent.KEYCODE_ENTER;
import static java.lang.Thread.sleep;

/**
 * Created by YZ on 11/26/16.
 */

public class EditRewardActivityInstrumentTest extends ActivityInstrumentationTestCase2<EditRewardActivity> {
    private EditRewardActivity editRewardActivity;
    private Instrumentation mInstrumentation;
    private TextInputEditText textInputEditText;
    private Solo solo;
    public EditRewardActivityInstrumentTest() {
        super(EditRewardActivity.class);
    }


    @Override
    public void setUp() throws Exception {
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();

        super.setUp();
        editRewardActivity = getActivity();
        textInputEditText = (TextInputEditText) editRewardActivity.findViewById(R.id.reward_name);

        solo = new Solo(mInstrumentation,editRewardActivity);
    }



    @Test
    public void testAdd() {

        solo.enterText(0, "Test A reward");

        this.solo.clickOnView(solo.getView(R.id.reward_description_container));


        solo.enterText(1, "I like it");
        solo.clickOnButton("OK");


        this.solo.clickOnView(solo.getView(R.id.reward_price_container));
        solo.scrollToBottom();
        solo.clickOnButton("OK");

        this.solo.clickOnView(solo.getView(R.id.action_save));


    }





}
