package com.ipulcrimx.sparkcalculator.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ipulcrimx.sparkcalculator.R;

public class MainLayoutFragment extends Fragment {
    View sparkView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        sparkView = inflater.inflate(R.layout.spark_main, container, false);
        return sparkView;
    }
}
