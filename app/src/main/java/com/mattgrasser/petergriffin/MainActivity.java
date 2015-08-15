package com.mattgrasser.petergriffin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends Activity
{
    private static final String TAG = "MainActivity";
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.image);
        new FetchImageTask().execute();
    }

    private class FetchImageTask extends AsyncTask<Void, Void, Drawable> {
        ProgressDialog mSpinner;

        public FetchImageTask() {
            mSpinner = new ProgressDialog(MainActivity.this);
            mSpinner.setMessage("Loading Image");
        }

        @Override
        protected void onPreExecute() {
            mSpinner.show();
        }

        @Override
        protected Drawable doInBackground(Void... params) {
            try {
                String imageUrl = "https://i.imgur.com/fGKCiAj.gif";
                InputStream urlContent = (InputStream) new URL(imageUrl).getContent();
                Drawable image = Drawable.createFromStream(urlContent, "Image We're Loading");
                return image;
            } catch (IOException e) {
                Log.e(TAG, e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Drawable image) {
            if (image != null) {
                mImageView.setImageDrawable(image);
            } else {
                Toast.makeText(MainActivity.this, "An error occurred!", Toast.LENGTH_SHORT).show();
            }
            mSpinner.dismiss();
        }
    }
}
