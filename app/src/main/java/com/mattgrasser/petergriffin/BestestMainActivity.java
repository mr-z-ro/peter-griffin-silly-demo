package com.mattgrasser.petergriffin;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BestestMainActivity extends Activity {

    private static final String TAG = "BestestMainActivity";
    @Bind(R.id.image) ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_main);
        ButterKnife.bind(this);

        Picasso.with(BestestMainActivity.this)
                .load("https://i.imgur.com/14VIa8T.png")
                .resize(500, 500)
                .centerCrop()
                .into(mImageView);
    }

    @OnClick(R.id.button)
    void playSound() {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.bird_is_the_word);
        mp.start();
    }
}
