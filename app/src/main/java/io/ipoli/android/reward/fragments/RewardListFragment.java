package io.ipoli.android.reward.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.ipoli.android.Constants;
import io.ipoli.android.MainActivity;
import io.ipoli.android.R;
import io.ipoli.android.app.App;
import io.ipoli.android.app.BaseFragment;
import io.ipoli.android.app.help.HelpDialog;
import io.ipoli.android.app.ui.DividerItemDecoration;
import io.ipoli.android.app.ui.EmptyStateRecyclerView;
import io.ipoli.android.avatar.persistence.AvatarPersistenceService;
import io.ipoli.android.quest.persistence.OnDataChangedListener;
import io.ipoli.android.reward.activities.EditRewardActivity;
import io.ipoli.android.reward.adapters.RewardListAdapter;
import io.ipoli.android.reward.data.Reward;
import io.ipoli.android.reward.events.BuyRewardEvent;
import io.ipoli.android.reward.events.DeleteRewardRequestEvent;
import io.ipoli.android.reward.events.EditRewardRequestEvent;
import io.ipoli.android.reward.persistence.RewardPersistenceService;
import io.ipoli.android.reward.viewmodels.RewardViewModel;

/**
 * Created by Venelin Valkov <venelin@curiousily.com>
 * on 5/27/16.
 */
public class RewardListFragment extends BaseFragment implements OnDataChangedListener<List<Reward>> {

    private Unbinder unbinder;

    @Inject
    Bus eventBus;

    @Inject
    AvatarPersistenceService avatarPersistenceService;

    @Inject
    RewardPersistenceService rewardPersistenceService;

    @BindView(R.id.reward_list)
    EmptyStateRecyclerView rewardList;

    @BindView(R.id.root_container)
    CoordinatorLayout rootLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private List<Reward> rewards;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_reward_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        App.getAppComponent(getContext()).inject(this);
        ((MainActivity) getActivity()).initToolbar(toolbar, R.string.title_fragment_rewards);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rewardList.setLayoutManager(layoutManager);
        rewardList.setEmptyView(rootLayout, R.string.empty_text_rewards, R.drawable.ic_gift_grey_24dp);
        rewardList.addItemDecoration(new DividerItemDecoration(getContext()));
        RewardListAdapter rewardListAdapter = new RewardListAdapter(new ArrayList<>(), eventBus);
        rewardList.setAdapter(rewardListAdapter);
        rewards = new ArrayList<>();

        rewardPersistenceService.findAll(this);
        return view;
    }

    @Override
    protected boolean useOptionsMenu() {
        return true;
    }

    @Override
    protected void showHelpDialog() {
        HelpDialog.newInstance(R.layout.fragment_help_dialog_rewards, R.string.help_dialog_rewards_title, "rewards").show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void onResume() {
        super.onResume();
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        rewardPersistenceService.removeAllListeners();
        super.onDestroyView();
    }

    @OnClick(R.id.add_reward)
    public void onAddReward(View view) {
        startActivity(new Intent(getActivity(), EditRewardActivity.class));
    }

    @Subscribe
    public void onBuyReward(BuyRewardEvent e) {
        Reward r = e.reward;
        avatarPersistenceService.find(avatar -> {
            if (avatar.getCoins() - r.getPrice() < 0) {
                showTooExpensiveMessage();
                return;
            }
            avatar.removeCoins(r.getPrice());
            avatarPersistenceService.save(avatar);
            updateRewards(rewards);
            Snackbar.make(rootLayout, e.reward.getPrice() + " coins spent", Snackbar.LENGTH_SHORT).show();

        });
    }

    private void showTooExpensiveMessage() {
        Toast.makeText(getContext(), R.string.reward_too_expensive, Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void onEditRewardRequest(EditRewardRequestEvent e) {
        Intent i = new Intent(getContext(), EditRewardActivity.class);
        i.putExtra(Constants.REWARD_ID_EXTRA_KEY, e.reward.getId());
        startActivity(i);
    }

    @Subscribe
    public void onDeleteRewardRequest(DeleteRewardRequestEvent e) {
        rewardPersistenceService.delete(e.reward);
        Toast.makeText(getActivity(), R.string.reward_removed, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataChanged(List<Reward> rewards) {
        this.rewards = rewards;
        updateRewards(rewards);
    }

    private void updateRewards(List<Reward> rewards) {
        List<RewardViewModel> rewardViewModels = new ArrayList<>();
        avatarPersistenceService.find(avatar -> {
            for (Reward r : rewards) {
                rewardViewModels.add(new RewardViewModel(r, (r.getPrice() <= avatar.getCoins())));
            }
            RewardListAdapter rewardListAdapter = new RewardListAdapter(rewardViewModels, eventBus);
            rewardList.setAdapter(rewardListAdapter);
        });
    }
}
