package com.ipulcrimx.sparkcalculator.models;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ipulcrimx.sparkcalculator.MainActivity;
import com.ipulcrimx.sparkcalculator.models.RewardSource.DailyLogin;

public class SparkStatus {
    private int crystal;
    private int ticket;
    @SerializedName("10draw_ticket")
    private int ticket10;
    @SerializedName("daily_day")
    public int dailyDay;

    public transient DailyLogin _dailyLogin;

    public SparkStatus(MainActivity mainAct, int crystal, int ticket, int ticket10, int day) {

        this.crystal = crystal;
        this.ticket = ticket;
        this.ticket10 = ticket10;

        _dailyLogin = new DailyLogin(mainAct);
        dailyDay = day;
    }

    public int GetTicketNeeded()
    {
        return 300 - GetTotalDraw();
    }

    public int GetTotalDraw()
    {
        int drawFromCrystal = crystal / 300;
        int drawFromTicket = ticket + (ticket10 * 10);

        return drawFromCrystal + drawFromTicket;
    }


//region Setter and Getter

    public int getCrystal() {
        return crystal;
    }

    public void setCrystal(int crystal) {
        this.crystal = crystal;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getTicket10() {
        return ticket10;
    }

    public void setTicket10(int ticket10) {
        this.ticket10 = ticket10;
    }
//endregion
}
