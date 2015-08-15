package com.mattgrasser.petergriffin;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class BestMainActivity extends Activity {

    private static final String TAG = "BestMainActivity";
    private ImageView mImageView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_main);

        mImageView = (ImageView) findViewById(R.id.image);
        Picasso.with(BestMainActivity.this)
                .load("https://i.imgur.com/14VIa8T.png")
                .resize(500, 500)
                .centerCrop()
                .into(mImageView);

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
            }
        });
    }

    private void playSound() {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.bird_is_the_word);
        mp.start();
    }
}
