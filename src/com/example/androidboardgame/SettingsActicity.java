package com.example.androidboardgame;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.example.androidboardgame.model.Settings;

/**
 * Created by Administrator on 30/12/2014.
 */

public class SettingsActicity extends Activity {

    Settings applicationSettings;
    Boolean isMusicEnabled;
    Boolean isSoundEnabled;
    Boolean isVibrationEnabled;

    //Back to Main Activity
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingslayout);

         applicationSettings = new Settings(getApplicationContext());

        ApplySettingsToUI(getApplicationContext());



        final Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                BackToMain(v);
            }
        });

    }
    //Applying Users settings to UI
    private void ApplySettingsToUI(Context applicationContext) {
        applicationSettings = new Settings(applicationContext);
        isMusicEnabled = applicationSettings.GetMusic();
        isSoundEnabled = applicationSettings.GetSound();
        isVibrationEnabled = applicationSettings.GetVibration();

        ((CheckBox)findViewById(R.id.chkMusic)).setChecked(isMusicEnabled);
        ((CheckBox)findViewById(R.id.chksound)).setChecked(isSoundEnabled);
        ((CheckBox)findViewById(R.id.chkvibrate)).setChecked(isVibrationEnabled);
    }
//Getting Setting Parameters (Vibrations, background music , sounds ) from user interface and apply to configurations .
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.chkMusic:
                if (checked){
                    if (applicationSettings!=null) applicationSettings.SetMusic(true);
                    StartBackgroundMusic();
                }
                else
                {
                    if (applicationSettings!=null) applicationSettings.SetMusic(false);
                    StopBackgroundMusic();
                }
                break;
            case R.id.chksound:
                if (checked){
                    if (applicationSettings!=null) applicationSettings.SetSound(true);
                }
                else
                {
                    if (applicationSettings!=null) applicationSettings.SetSound(false);
                }
                break;
            case R.id.chkvibrate:
                if (checked){
                    if (applicationSettings!=null) applicationSettings.SetVibration(true);
                }
                else
                {
                    if (applicationSettings!=null) applicationSettings.SetVibration(false);
                }
                break;
        }
    }
   // Stop Background Music Service .
    private void StopBackgroundMusic() {
        if (MainActivity.backgroundServiceIntent != null){
            stopService(MainActivity.backgroundServiceIntent);
        }
    }
   //Start Background Music
    private void StartBackgroundMusic() {
        if (MainActivity.backgroundServiceIntent != null){
            startService(MainActivity.backgroundServiceIntent);
        }

    }
    //Back to main Activity .
    public void BackToMain(View view) {
        finish();
    }
}
