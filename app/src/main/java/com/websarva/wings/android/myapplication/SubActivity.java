package com.websarva.wings.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.VideoView;

public class SubActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        final VideoView videoView = (VideoView)findViewById(R.id.videoView);
        //ビデオファイルの取得
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.godmove);

        // 先頭に戻す
        videoView.seekTo(0);
        //再生
        videoView.start();
    }
}