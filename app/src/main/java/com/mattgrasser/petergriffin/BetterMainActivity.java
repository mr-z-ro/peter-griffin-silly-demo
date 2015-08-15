package com.mattgrasser.petergriffin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class BetterMainActivity extends Activity {

    private static final String TAG = "BetterMainActivity";
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.image);
        Picasso.with(BetterMainActivity.this)
                .load("https://i.imgur.com/14VIa8T.png")
                .resize(500, 500)
                .centerCrop()
                .into(mImageView);
    }

}
