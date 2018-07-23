package com.ipulcrimx.sparkcalculator.models;

import com.ipulcrimx.sparkcalculator.utils.RewardType;

import java.util.ArrayList;
import java.util.List;

public class DailyLogin {
    public List<Reward> rewardList = new ArrayList<Reward>();

    private final int TOTAL_REWARD = 15;
    private final int BATCH_REWARD = 5;

    public DailyLogin() {
        for(int i = 0; i < TOTAL_REWARD; i++)
        {
            if(i % BATCH_REWARD == 4)
            {
                rewardList.add(new Reward(RewardType.Ticket, 1));
            }
            else if (i % BATCH_REWARD == 3)
            {
                rewardList.add(new Reward(RewardType.Crystal, 150 + (50 * (i / BATCH_REWARD))));
            }
            else
            {
                rewardList.add(new Reward(RewardType.none, 0));
            }
        }
    }

    public int GetReward()
}
