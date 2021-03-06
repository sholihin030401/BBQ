package com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Khusus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.AlifLam.SyamsiyahActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class TashilActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer playerTashil;
ImageButton btntashil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ktashil);

        TextView textView = findViewById(R.id.textNextBtn);
        textView.setOnClickListener(this);
        btntashil = findViewById(R.id.play_toggle_tashil);
        btntashil.setOnClickListener(this);
        playerTashil = MediaPlayer.create(this,R.raw.tahsil);

        TextView tvTashil = findViewById(R.id.imgTashil);
        String txTashil = getString(R.string.tashil1);

        SpannableString sTashil = new SpannableString(txTashil);

        ForegroundColorSpan fcTashil = new ForegroundColorSpan(Color.RED);

        sTashil.setSpan(fcTashil,91,97, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvTashil.setText(sTashil);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNextBtn:
                Intent intent = new Intent(TashilActivity.this, SyamsiyahActivity.class);
                startActivity(intent);
                break;
            case R.id.play_toggle_tashil:
                setmptashil();
                break;
        }
    }

    private void setmptashil(){
        if (playerTashil.isPlaying()){
            playerTashil.pause();
            btntashil.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            playerTashil.start();
            btntashil.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (playerTashil != null){
            playerTashil.stop();
        }
        super.onDestroy();
    }
}
