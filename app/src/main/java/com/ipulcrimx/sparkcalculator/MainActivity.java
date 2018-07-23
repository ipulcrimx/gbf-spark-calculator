package com.ipulcrimx.sparkcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText _crystalEditText;
    EditText _ticketEditText;
    EditText _10ticketEditText;
    TextView _resultText;
    Button _countButton;

    int _totalCrystals;
    int _totalTickets;
    int _total10Tickets;

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
        _totalCrystals = Integer.parseInt(_crystalEditText.getText().toString());
        _totalTickets = Integer.parseInt(_ticketEditText.getText().toString());
        _total10Tickets = Integer.parseInt((_10ticketEditText.getText().toString()));

        int xtal = GetTicketNeeded(_totalCrystals, _totalTickets, _total10Tickets) * 300;
        int tix = GetTicketNeeded(_totalCrystals, _totalTickets, _total10Tickets);
        int tot = GetTotalDraw(_totalCrystals, _totalTickets, _total10Tickets);

        _resultText.setText("You can draw " + tot + " times now.\nYou need " + xtal + " more crystals or " + tix +" tickets to spark");
    }

    protected int GetTicketNeeded(int crystal, int tickets, int ticket10)
    {
        return 300 - GetTotalDraw(crystal, tickets, ticket10);
    }

    protected int GetTotalDraw(int crystal, int tickets, int ticket10)
    {
        crystal = crystal / 300;
        tickets = tickets + (ticket10 * 10);

        return tickets + crystal;
    }
}
