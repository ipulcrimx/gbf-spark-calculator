package com.ipulcrimx.sparkcalculator.models;

import android.util.Log;

public class SparkStatus {
    private int crystal;
    private int ticket;
    private int ticket10;

    public SparkStatus(int crystal, int ticket, int ticket10) {
        this.crystal = crystal;
        this.ticket = ticket;
        this.ticket10 = ticket10;
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
}
