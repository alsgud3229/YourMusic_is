package com.example.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button MusicPool;
    public Button Search;
    public Button MyPlaylist;
    public Button Recommendation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MusicPool = (Button)findViewById(R.id.button2);
        Search = (Button)findViewById(R.id.button3);
        MyPlaylist = (Button)findViewById(R.id.button5);
        Recommendation = (Button)findViewById(R.id.button4);
    }

    public void onClick1(View view){
        Intent intent = new Intent(getApplicationContext(), MusicPool.class);
        startActivity(intent);
    }
    public void onClick2(View view){
        Intent intent = new Intent(getApplicationContext(), Search.class);
        startActivity(intent);
    }
    public void onClick3(View view){
        Intent intent = new Intent(getApplicationContext(), MyPlaylist.class);
        startActivity(intent);
    }
    public void onClick4(View view){
        Intent intent = new Intent(getApplicationContext(), Recommendation.class);
        startActivity(intent);
    }
}

