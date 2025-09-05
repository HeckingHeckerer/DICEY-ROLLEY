package com.kayeltech.diceroller;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DiceView diceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        diceView = findViewById(R.id.diceView);
        Button rollButton = findViewById(R.id.rollButton);

        rollButton.setOnClickListener(v -> diceView.rollDice());
    }
}
