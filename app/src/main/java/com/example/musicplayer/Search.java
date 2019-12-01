package com.example.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    private ArrayList<SampleData> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private MyAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<SampleData> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);

        // 리스트를 생성한다.
        list = new ArrayList<SampleData>();

        // 검색에 사용할 데이터을 미리 저장한다.
        settingList();

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<SampleData>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new MyAdapter(this, list);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(), adapter.getItem(position).getSongName()+"가(이) 재생목록에 추가되었습니다.", Toast.LENGTH_LONG).show();
                SampleData obj = adapter.getItem(position);
                MyPlaylist.MyList.add(new SampleData(obj.getCover(), obj.getSongName(), obj.getArtist()));
                MyPlaylist.renew();
            }
        });

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });
    }

    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).getSongName().toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){
        list.add(new SampleData(R.drawable.pic1, "구르미 그린 달빛","거미"));
        list.add(new SampleData(R.drawable.pic2, "구름","로시"));
        list.add(new SampleData(R.drawable.pic3, "구름","한해"));
        list.add(new SampleData(R.drawable.pic4, "겨울아이","수지"));
        list.add(new SampleData(R.drawable.pic5, "날씨 좋은 날","산들"));
        list.add(new SampleData(R.drawable.pic6, "눈","김호진"));
        list.add(new SampleData(R.drawable.pic7, "눈의 꽃","박효신"));
        list.add(new SampleData(R.drawable.pic8, "눈사람","정승환"));
        list.add(new SampleData(R.drawable.pic9, "달달한 사랑이야기","러브래빗"));
        list.add(new SampleData(R.drawable.pic10, "먹구름","헤이즈"));
        list.add(new SampleData(R.drawable.pic11, "미리메리크리스마스","아이유"));
        list.add(new SampleData(R.drawable.pic12, "바람만바람만","SG워너비"));
        list.add(new SampleData(R.drawable.pic13, "바람이 분다","이소라"));
        list.add(new SampleData(R.drawable.pic14, "밖에 비온다 주룩주룩","Dok2"));
        list.add(new SampleData(R.drawable.pic15, "봄날","방탄소년단(BTS)"));
        list.add(new SampleData(R.drawable.pic16, "불안","한희정"));
        list.add(new SampleData(R.drawable.pic17, "비","폴 킴"));
        list.add(new SampleData(R.drawable.pic18, "비 오는 거리","SG워너비"));
        list.add(new SampleData(R.drawable.pic19, "빗속으로","장범준"));
        list.add(new SampleData(R.drawable.pic20, "새벽","조권"));
        list.add(new SampleData(R.drawable.pic21, "슬픔활용법","김범수"));
        list.add(new SampleData(R.drawable.pic22, "아침에","영비"));
        list.add(new SampleData(R.drawable.pic23, "안개","짙은"));
        list.add(new SampleData(R.drawable.pic24, "우산","에픽하이"));
        list.add(new SampleData(R.drawable.pic25, "이별","폴 킴"));
        list.add(new SampleData(R.drawable.pic26, "이별한 사람만의 아는 진실","최재훈"));
        list.add(new SampleData(R.drawable.pic27, "외로워","김우성"));
        list.add(new SampleData(R.drawable.pic28, "장마","정인"));
        list.add(new SampleData(R.drawable.pic29, "장마전선","쏜애플"));
        list.add(new SampleData(R.drawable.pic30, "좋은 날","아이유"));
        list.add(new SampleData(R.drawable.pic31, "코끝에 겨울","어반자카파"));
        list.add(new SampleData(R.drawable.pic32, "태양을 피하는 방법","비"));
        list.add(new SampleData(R.drawable.pic33, "허전해","폴 킴"));
        list.add(new SampleData(R.drawable.pic34, "화창한 봄날에","제리케이"));
        list.add(new SampleData(R.drawable.pic35, "화창한 날에","케이윌"));
        list.add(new SampleData(R.drawable.pic36, "행복한 나를","허각"));
        list.add(new SampleData(R.drawable.pic37, "흰눈","이루"));
    }

}
