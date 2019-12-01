package com.example.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyPlaylist extends AppCompatActivity {

    static ArrayList<SampleData> MyList = new ArrayList<SampleData>();
    static MyAdapter myAdapter;
    MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_playlist);


        ListView listView = (ListView)findViewById(R.id.listView);
        myAdapter = new MyAdapter(this, MyList);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(), myAdapter.getItem(position).getSongName()+"가(이) 재생됩니다.", Toast.LENGTH_LONG).show();
                // 재생
                mediaPlayer = MediaPlayer.create(MyPlaylist.this, R.raw.goodday);
                mediaPlayer.start();
            }
        });
    }

    public static void renew(){
        myAdapter.notifyDataSetChanged();
    }

    public static void gara(){
        // 산들 노래 넣기
        MyList.add(new SampleData(R.drawable.pic5, "날씨 좋은 날", "산들"));
        renew();
    }

}
