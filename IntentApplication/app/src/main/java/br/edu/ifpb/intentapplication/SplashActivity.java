package br.edu.ifpb.intentapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SplashActivity extends Activity implements Runnable{

    private  Handler handler;
    private ImageView loading;
    Bitmap img;

    @Override
    protected void onCreate(Bundle save) {

        super.onCreate(save);
        setContentView(R.layout.activity_splash);

        loading = (ImageView) findViewById(R.id.loading);
        loading.setBackgroundResource(R.drawable.loader);

        AnimationDrawable load = (AnimationDrawable) loading.getBackground();
        load.start();

        handler = new Handler();
        handler.post(this);

    }

    @Override
    public void run() {

        new Thread(){
            public void run(){

                try{
                    URL url = new URL("http://img.talkandroid.com/uploads/2012/02/Android-G-b_46.jpg");
                    HttpURLConnection c = (HttpURLConnection) url.openConnection();
                    InputStream input = c.getInputStream();
                    img = BitmapFactory.decodeStream(input);

                    sleep(2000);
                }
                catch(IOException | InterruptedException e) {
                    e.printStackTrace();
                }


                runOnUiThread(new Runnable() {
                    public void run() {

                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        img.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                        byte[] byteArray = stream.toByteArray();

                        Intent i = new Intent(SplashActivity.this, PrimeiraActivity.class);
                        i.putExtra("img",byteArray);

                        startActivity(i);
                        finish();
                    }
                });
            }
        }.start();
    }
}
