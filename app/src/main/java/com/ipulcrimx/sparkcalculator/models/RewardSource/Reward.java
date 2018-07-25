package com.ipulcrimx.sparkcalculator.models.RewardSource;

import com.ipulcrimx.sparkcalculator.utils.RewardType;

public class Reward
{
    protected RewardType rewardType;
    protected int rewardValue;

    public Reward(RewardType rewardType, int rewardValue) {
        this.rewardType = rewardType;
        this.rewardValue = rewardValue;
    }
}
