package com.ipulcrimx.sparkcalculator.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ipulcrimx.sparkcalculator.R;

public class DailyLoginFragment extends Fragment {
    View calendarView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        calendarView = inflater.inflate(R.layout.daily_login_view, container, false);
        return calendarView;
    }
}
