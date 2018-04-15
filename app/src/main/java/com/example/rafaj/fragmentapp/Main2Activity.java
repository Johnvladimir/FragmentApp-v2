package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView text;
    TextView text_2;
    TextView text_3;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = findViewById(R.id.textId);
        text_2 = findViewById(R.id.Text1);
        text_3 = findViewById(R.id.Text2);
        img = findViewById(R.id.img_portrait);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();

        if (Intent.ACTION_SEND.equals(intentAction) && intentType != null) {
            Bundle bunR = getIntent().getExtras();
            text.setText(bunR.getString("llave"));
            img.setImageResource(bunR.getInt("llave2"));
            text_2.setText(bunR.getString("llave3"));
            text_3.setText(bunR.getString("llave4"));
            if (intentType.equals("text/plain")) {
                handleReceivedText(callingIntent);
            }
        }
    }

    private void handleReceivedText(Intent intent) {
        String intentText = intent.getStringExtra(Intent.EXTRA_TEXT);

        if (text != null) {
            text.setText(intentText);
        }
    }
}
