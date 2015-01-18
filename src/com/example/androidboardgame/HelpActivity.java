package com.example.androidboardgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpActivity extends Activity {

//This Activity shows Help contents to user .
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helplayout);
        final Button btnBack = (Button) findViewById(R.id.btnBackHelp);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                BackToMain(v);
            }
        });
    }
//On this button click user will be redirect to Main Activity .
    public void BackToMain(View view) {
        finish();
    }
}
