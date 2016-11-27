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
    public void testAddReward() {
        String additionalText = textInputEditText.getEditableText().toString();
        //final Button button=  (Button) quickAddActivity.findViewById(R.id.add);
        //pressImeActionButton();
        final String text = "TEST a big reward";
        editRewardActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textInputEditText.setText(text);
            }


        });

        RelativeLayout rewardReason = (RelativeLayout) editRewardActivity.findViewById(R.id.reward_description_container);



            TextView rewardWhy = (TextView) editRewardActivity.findViewById(R.id.reward_description_value);
        TextView rewardAmount = (TextView) editRewardActivity.findViewById(R.id.reward_price_value);
            editRewardActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    rewardReason.performClick();
                }


            });


            //getViewFromDialogByIndex(solo, TextPickerFragment,




            final String reason = "Because I like i";
            final String price = "A Dollar";
            TextPickerFragment textPickerFragment = new TextPickerFragment();
            FragmentManager fragmentManager = editRewardActivity.getSupportFragmentManager();


            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(textPickerFragment, null);


            editRewardActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    fragmentManager.executePendingTransactions();
                }
            });









    }



    public static View getViewFromDialogByIndex(Solo solo, Class viewType , int index){
        ArrayList<View> dialogViews = solo.getCurrentViews();
        ArrayList<View> typeViews = new ArrayList<View>();
        for(View currentTypeView : dialogViews){
            if(viewType.isInstance(currentTypeView)){
                typeViews.add(currentTypeView);
            }
        }
        if(dialogViews.size() != 0){
            return typeViews.get(index);
        }else {
            return null;
        }
    }
}
