package com.example.androidboardgame.model;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import com.example.androidboardgame.R;

/**
 * Created by administrator on 11/01/2015.
 */
//This class acts as background music service
public class BackgroundMusicService extends Service {
    private static final String TAG = null;
    MediaPlayer player;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    //Creating Music giving path to file and allow looping to play background service
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.backgroundmusic);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);

    }
    //Start Music Service
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return 1;
    }

//Stop Music Service
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }


}
