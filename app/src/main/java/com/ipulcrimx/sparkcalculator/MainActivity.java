package com.ipulcrimx.sparkcalculator;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ipulcrimx.sparkcalculator.models.RewardSource.DailyLogin;
import com.ipulcrimx.sparkcalculator.models.SparkStatus;
import com.ipulcrimx.sparkcalculator.utils.CustomExclusionStrategy;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText _crystalEditText;
    EditText _ticketEditText;
    EditText _10ticketEditText;
    TextView _resultText;
    Button _countButton;

    SparkStatus _sparkStatus;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    String json = "";

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
        _sparkStatus = new SparkStatus();

        pref = getSharedPreferences("spark status", MODE_PRIVATE);
        editor = pref.edit();

        json = pref.getString("json", "");
        // check if shared preferences is empty or not
        if(!json.equals(""))
        {
            Log.d("spark", json);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            _sparkStatus = gson.fromJson(json, SparkStatus.class);
            Toast.makeText(this, "Load data done...", Toast.LENGTH_SHORT).show();

            Log.d("spark", _sparkStatus.ToString());

            _crystalEditText.setText(_sparkStatus.getCrystal()+ "");
            _ticketEditText.setText(_sparkStatus.getTicket()+ "");
            _10ticketEditText.setText(_sparkStatus.getTicket10() + "");
        }
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
        ParseToJson();
    }

    private void ParseToJson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();

        Gson gson = builder.create();
        json = gson.toJson(_sparkStatus);

        editor.putString("json", json);
        editor.commit();

        Log.d("spark", json);
    }
}
