package com.websarva.wings.android.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> list2 = new ArrayList<Integer>();

    int count = 0;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int fs, ss,god,ob;
    int seikai =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btl).setOnClickListener(this);
        findViewById(R.id.btc).setOnClickListener(this);
        findViewById(R.id.btr).setOnClickListener(this);
        findViewById(R.id.onemore).setOnClickListener(this);
        AudioAttributes audioAttributes = new AudioAttributes.Builder()

                .setUsage(AudioAttributes.USAGE_GAME)

                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .build();

        // one.wav をロードしておく
        fs = soundPool.load(this, R.raw.faststop, 1);

        // two.wav をロードしておく
        ss = soundPool.load(this, R.raw.secondstop, 1);
        god = soundPool.load(this, R.raw.god, 1);
        ob = soundPool.load(this, R.raw.xbgm, 1);









    }


    @Override
    public void onClick(View v) {
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        Intent intent = new Intent(this, SubActivity.class);
        count += 1;

        if (1 == count) {
            list.clear();
            Random();

            if (v.getId() == R.id.btl) {
                ((ImageButton) findViewById(R.id.btl)).setImageResource(R.drawable.offb);

                if(1== list.get(0)){
                    soundPool.play(fs, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvl)).setText("〇");
                    seikai+=1;
                    ((ImageButton) findViewById(R.id.btl)).setEnabled(false);
                }
                else{
                    soundPool.play(ob, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvl)).setText("×");
                    count = 0;
                    seikai= 0;
                    ((ImageButton) findViewById(R.id.btl)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btc)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btr)).setEnabled(false);

                    ListView listView = (ListView)findViewById(R.id.lv);
                    listView.setAdapter(adapter);


                }


            }
            else if (v.getId() == R.id.btc) {
                ((ImageButton) findViewById(R.id.btc)).setImageResource(R.drawable.offb);
                if(2== list.get(0)){
                    soundPool.play(fs, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvc)).setText("〇");
                    seikai+=1;
                    ((ImageButton) findViewById(R.id.btc)).setEnabled(false);
                }
                else{
                    soundPool.play(ob, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvc)).setText("×");
                    count = 0;
                    seikai= 0;
                    ((ImageButton) findViewById(R.id.btl)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btc)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btr)).setEnabled(false);

                    ListView listView = (ListView)findViewById(R.id.lv);
                    listView.setAdapter(adapter);


                }
            }
            else if (v.getId() == R.id.btr) {
                ((ImageButton) findViewById(R.id.btr)).setImageResource(R.drawable.offb);
                if(3== list.get(0)){
                    soundPool.play(fs, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvr)).setText("〇");
                    seikai+=1;
                    ((ImageButton) findViewById(R.id.btr)).setEnabled(false);
                }
                else{
                    soundPool.play(ob, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvr)).setText("×");
                    count = 0;
                    seikai= 0;

                    ((ImageButton) findViewById(R.id.btl)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btc)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btr)).setEnabled(false);
                    ListView listView = (ListView)findViewById(R.id.lv);
                    listView.setAdapter(adapter);


                }
            }
            else if (v.getId() == R.id.onemore) {
                seikai= 0;
                count = 0;

                ((TextView) findViewById(R.id.tvl)).setText("？");
                ((TextView) findViewById(R.id.tvc)).setText("？");
                ((TextView) findViewById(R.id.tvr)).setText("？");
                ((ImageButton) findViewById(R.id.btl)).setImageResource(R.drawable.onb);
                ((ImageButton) findViewById(R.id.btc)).setImageResource(R.drawable.onb);
                ((ImageButton) findViewById(R.id.btr)).setImageResource(R.drawable.onb);
                ((ImageButton) findViewById(R.id.btl)).setEnabled(true);
                ((ImageButton) findViewById(R.id.btc)).setEnabled(true);
                ((ImageButton) findViewById(R.id.btr)).setEnabled(true);

            }
        }
        else if (2 == count) {
            if (v.getId() == R.id.btl) {
                ((ImageButton) findViewById(R.id.btl)).setImageResource(R.drawable.offb);
                if(1== list.get(1)&&seikai==1){
                    soundPool.play(ss, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvl)).setText("〇");
                    seikai+=1;
                    ((ImageButton) findViewById(R.id.btl)).setEnabled(false);

                }
                else{
                    soundPool.play(ob, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvl)).setText("×");
                    count = 0;
                    seikai= 0;

                    ((ImageButton) findViewById(R.id.btl)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btc)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btr)).setEnabled(false);
                    ListView listView = (ListView)findViewById(R.id.lv);
                    listView.setAdapter(adapter);


                }
            }
            else if (v.getId() == R.id.btc) {
                ((ImageButton) findViewById(R.id.btc)).setImageResource(R.drawable.offb);
                if(2== list.get(1)&&seikai==1){
                    soundPool.play(ss, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvc)).setText("〇");
                    seikai+=1;
                    ((ImageButton) findViewById(R.id.btc)).setEnabled(false);
                }
                else{
                    soundPool.play(ob, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvc)).setText("×");
                    count = 0;
                    seikai= 0;
                    ((ImageButton) findViewById(R.id.btl)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btc)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btr)).setEnabled(false);

                    ListView listView = (ListView)findViewById(R.id.lv);
                    listView.setAdapter(adapter);


                }
            }
            else if (v.getId() == R.id.btr) {
                ((ImageButton) findViewById(R.id.btr)).setImageResource(R.drawable.offb);
                if(3== list.get(1)&&seikai==1){
                    soundPool.play(ss, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvr)).setText("〇");
                    seikai+=1;
                    ((ImageButton) findViewById(R.id.btr)).setEnabled(false);
                }
                else{
                    soundPool.play(ob, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvr)).setText("×");
                    count = 0;
                    seikai= 0;
                    ((ImageButton) findViewById(R.id.btl)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btc)).setEnabled(false);
                    ((ImageButton) findViewById(R.id.btr)).setEnabled(false);
                    ListView listView = (ListView)findViewById(R.id.lv);
                    listView.setAdapter(adapter);


                }
            }
            else if (v.getId() == R.id.onemore) {
                seikai= 0;
                count=0;
                ((TextView) findViewById(R.id.tvl)).setText("？");
                ((TextView) findViewById(R.id.tvc)).setText("？");
                ((TextView) findViewById(R.id.tvr)).setText("？");
                ((ImageButton) findViewById(R.id.btl)).setImageResource(R.drawable.onb);
                ((ImageButton) findViewById(R.id.btc)).setImageResource(R.drawable.onb);
                ((ImageButton) findViewById(R.id.btr)).setImageResource(R.drawable.onb);
                ((ImageButton) findViewById(R.id.btl)).setEnabled(true);
                ((ImageButton) findViewById(R.id.btc)).setEnabled(true);
                ((ImageButton) findViewById(R.id.btr)).setEnabled(true);

            }
        }
        else if (3 == count) {
            if (v.getId() == R.id.btl) {
                ((ImageButton) findViewById(R.id.btl)).setImageResource(R.drawable.offb);
                if (seikai == 2) {
                    soundPool.play(god, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvl)).setText("〇");
                    ListView listView = (ListView)findViewById(R.id.lv);
                    listView.setAdapter(adapter);
                    ((ImageButton) findViewById(R.id.btl)).setEnabled(false);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);


                    }
                }


            } else if (v.getId() == R.id.btc) {
                ((ImageButton) findViewById(R.id.btc)).setImageResource(R.drawable.offb);
                if (seikai == 2) {
                    soundPool.play(god, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvc)).setText("〇");
                    ListView listView = (ListView)findViewById(R.id.lv);
                    listView.setAdapter(adapter);
                    ((ImageButton) findViewById(R.id.btc)).setEnabled(false);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);


                    }
                }


            } else if (v.getId() == R.id.btr) {
                ((ImageButton) findViewById(R.id.btr)).setImageResource(R.drawable.offb);
                if (seikai == 2) {
                    soundPool.play(god, 1.0f, 1.0f, 0, 0, 1);
                    ((TextView) findViewById(R.id.tvr)).setText("〇");
                    ListView listView = (ListView)findViewById(R.id.lv);
                    listView.setAdapter(adapter);
                    ((ImageButton) findViewById(R.id.btr)).setEnabled(false);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);

                    }
                }
            }
        }
        else if(count==4) {
             if (v.getId() == R.id.onemore) {
                 seikai = 0;
                 count = 0;
                 ((TextView) findViewById(R.id.tvl)).setText("？");
                 ((TextView) findViewById(R.id.tvc)).setText("？");
                 ((TextView) findViewById(R.id.tvr)).setText("？");
                 ((ImageButton) findViewById(R.id.btl)).setImageResource(R.drawable.onb);
                 ((ImageButton) findViewById(R.id.btc)).setImageResource(R.drawable.onb);
                 ((ImageButton) findViewById(R.id.btr)).setImageResource(R.drawable.onb);
                 ((ImageButton) findViewById(R.id.btl)).setEnabled(true);
                 ((ImageButton) findViewById(R.id.btc)).setEnabled(true);
                 ((ImageButton) findViewById(R.id.btr)).setEnabled(true);
             }
        }


        // ②遷移先画面の起動

    }

    public void Random() {
        // listに値を入れる。この段階では昇順
        for(int i = 1;i <= 3;i++){
                list.add(i);
                list2.add(i);
        }
        // シャッフルして、順番を変える
        Collections.shuffle(list);
    }

}
