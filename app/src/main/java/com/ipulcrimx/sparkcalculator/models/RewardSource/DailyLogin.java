package com.ipulcrimx.sparkcalculator.models.RewardSource;

import android.widget.Toast;

import com.ipulcrimx.sparkcalculator.MainActivity;
import com.ipulcrimx.sparkcalculator.utils.RewardType;

import java.util.ArrayList;
import java.util.List;

public class DailyLogin {
    public MainActivity mainActivity;
    public List<Reward> rewardList = new ArrayList<Reward>();
    private int day = -1;

    private final int TOTAL_REWARD = 15;
    private final int BATCH_REWARD = 5;

    public DailyLogin(MainActivity mainAct) {
        day = -1;
        mainActivity = mainAct;

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

    public void SetDay(int i)
    {
        day = i;
        if(day != -1)
        {
            Toast.makeText(mainActivity, "Day set to " + i, Toast.LENGTH_SHORT).show();
        }
    }

    public void ChangeDay()
    {
        day++;
    }

    public int GetDay()
    {
        return day;
    }


    public int GetReward()
    {
        return -1;
    }
}
