package com.ipulcrimx.sparkcalculator.Listeners;

import android.view.View;

import com.ipulcrimx.sparkcalculator.MainActivity;
import com.ipulcrimx.sparkcalculator.models.SparkStatus;

public class CountListener implements View.OnClickListener {

    private MainActivity _mainAct;

    public CountListener(MainActivity _mainAct) {
        this._mainAct = _mainAct;
    }

    @Override
    public void onClick(View v) {
        SparkStatus sparkStatus = _mainAct.GetSparkStatus();
        _mainAct.SetResultText(sparkStatus.GetTicketNeeded() * 300, sparkStatus.GetTicketNeeded(),sparkStatus.GetTotalDraw());
    }
}
