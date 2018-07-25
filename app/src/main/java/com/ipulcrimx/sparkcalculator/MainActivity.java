package com.ipulcrimx.sparkcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ipulcrimx.sparkcalculator.models.RewardSource.DailyLogin;
import com.ipulcrimx.sparkcalculator.models.SparkStatus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText _crystalEditText;
    EditText _ticketEditText;
    EditText _10ticketEditText;
    TextView _resultText;
    Button _countButton;

    SparkStatus _sparkStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _crystalEditText = findViewById(R.id.total_crystal_edit_text);
        _ticketEditText = findViewById(R.id.total_single_ticket_edit_text);
        _10ticketEditText = findViewById(R.id.total_10_tickets_edit_text);
        _resultText = findViewById(R.id.result_text);
        _countButton = findViewById(R.id.count_button);

        _countButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        int totalCrystals = Integer.parseInt(_crystalEditText.getText().toString());
        int totalTickets = Integer.parseInt(_ticketEditText.getText().toString());
        int total10Tickets = Integer.parseInt((_10ticketEditText.getText().toString()));

        _sparkStatus = new SparkStatus(this, totalCrystals,totalTickets, total10Tickets, 0);
        int xtal = _sparkStatus.GetTicketNeeded() * 300;
        int tix = _sparkStatus.GetTicketNeeded();
        int tot = _sparkStatus.GetTotalDraw();

        _resultText.setText("You can draw " + tot + " times now.\nYou need " + xtal + " more crystals or " + tix +" tickets to spark");
    }
}
