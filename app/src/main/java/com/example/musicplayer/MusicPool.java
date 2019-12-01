package com.example.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicPool extends AppCompatActivity {

    ArrayList<SampleData> musicDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_pool);

        this.InitializeMovieData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this,musicDataList);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(), myAdapter.getItem(position).getSongName()+"가(이) 재생목록에 추가되었습니다.", Toast.LENGTH_LONG).show();
                SampleData obj = myAdapter.getItem(position);
                MyPlaylist.MyList.add(new SampleData(obj.getCover(), obj.getSongName(), obj.getArtist()));
                MyPlaylist.renew();
            }
        });
    }

    public void InitializeMovieData(){
        musicDataList = new ArrayList<SampleData>();

        musicDataList.add(new SampleData(R.drawable.pic1, "구르미 그린 달빛","거미"));
        musicDataList.add(new SampleData(R.drawable.pic2, "구름","로시"));
        musicDataList.add(new SampleData(R.drawable.pic3, "구름","한해"));
        musicDataList.add(new SampleData(R.drawable.pic4, "겨울아이","수지"));
        musicDataList.add(new SampleData(R.drawable.pic5, "날씨 좋은 날","산들"));
        musicDataList.add(new SampleData(R.drawable.pic6, "눈","김호진"));
        musicDataList.add(new SampleData(R.drawable.pic7, "눈의 꽃","박효신"));
        musicDataList.add(new SampleData(R.drawable.pic8, "눈사람","정승환"));
        musicDataList.add(new SampleData(R.drawable.pic9, "달달한 사랑이야기","러브래빗"));
        musicDataList.add(new SampleData(R.drawable.pic10, "먹구름","헤이즈"));
        musicDataList.add(new SampleData(R.drawable.pic11, "미리메리크리스마스","아이유"));
        musicDataList.add(new SampleData(R.drawable.pic12, "바람만바람만","SG워너비"));
        musicDataList.add(new SampleData(R.drawable.pic13, "바람이 분다","이소라"));
        musicDataList.add(new SampleData(R.drawable.pic14, "밖에 비온다 주룩주룩","Dok2"));
        musicDataList.add(new SampleData(R.drawable.pic15, "봄날","방탄소년단(BTS)"));
        musicDataList.add(new SampleData(R.drawable.pic16, "불안","한희정"));
        musicDataList.add(new SampleData(R.drawable.pic17, "비","폴 킴"));
        musicDataList.add(new SampleData(R.drawable.pic18, "비 오는 거리","SG워너비"));
        musicDataList.add(new SampleData(R.drawable.pic19, "빗속으로","장범준"));
        musicDataList.add(new SampleData(R.drawable.pic20, "새벽","조권"));
        musicDataList.add(new SampleData(R.drawable.pic21, "슬픔활용법","김범수"));
        musicDataList.add(new SampleData(R.drawable.pic22, "아침에","영비"));
        musicDataList.add(new SampleData(R.drawable.pic23, "안개","짙은"));
        musicDataList.add(new SampleData(R.drawable.pic24, "우산","에픽하이"));
        musicDataList.add(new SampleData(R.drawable.pic25, "이별","폴 킴"));
        musicDataList.add(new SampleData(R.drawable.pic26, "이별한 사람만의 아는 진실","최재훈"));
        musicDataList.add(new SampleData(R.drawable.pic27, "외로워","김우성"));
        musicDataList.add(new SampleData(R.drawable.pic28, "장마","정인"));
        musicDataList.add(new SampleData(R.drawable.pic29, "장마전선","쏜애플"));
        musicDataList.add(new SampleData(R.drawable.pic30, "좋은 날","아이유"));
        musicDataList.add(new SampleData(R.drawable.pic31, "코끝에 겨울","어반자카파"));
        musicDataList.add(new SampleData(R.drawable.pic32, "태양을 피하는 방법","비"));
        musicDataList.add(new SampleData(R.drawable.pic33, "허전해","폴 킴"));
        musicDataList.add(new SampleData(R.drawable.pic34, "화창한 봄날에","제리케이"));
        musicDataList.add(new SampleData(R.drawable.pic35, "화창한 날에","케이윌"));
        musicDataList.add(new SampleData(R.drawable.pic36, "행복한 나를","허각"));
        musicDataList.add(new SampleData(R.drawable.pic37, "흰눈","이루"));

    }

}
