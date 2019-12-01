package com.example.musicplayer;

import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Input extends AppCompatActivity {

    private String[] genre = {"슬픈 노래","행복한 노래","이별 노래","사랑 노래"};
    private TextView music;
    private AlertDialog musicSelectDialog;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        music = (TextView) findViewById(R.id.musiclist); // Click !
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicSelectDialog.show();
            }
        });

        musicSelectDialog = new AlertDialog.Builder(Input.this).setItems(genre, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        View popupView = getLayoutInflater().inflate(R.layout.activity_popup, null);

                        mPopupWindow = new PopupWindow(popupView, 1200, 1800, true);

                        mPopupWindow.setFocusable(true);
                        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);


                        Button cancel = (Button) popupView.findViewById(R.id.Cancel);
                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mPopupWindow.dismiss();
                            }
                        });

                        Button ok = (Button) popupView.findViewById(R.id.Ok);
                        ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // 플레이리스트에 넣기
                                MyPlaylist.gara();
                                Toast.makeText(getApplicationContext(), "Playlist에 추가되었습니다.", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                })
                .setTitle("현재 듣고 싶은 노래를 선택해주세요.")
                .setPositiveButton("확인", null)
                .setNegativeButton("취소", null)
                .create();
    }
}
