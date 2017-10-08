package br.edu.ifpb.splash2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends Activity implements Runnable{

    private static int splashTime = 4000;
    private ImageView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loading = (ImageView) findViewById(R.id.loading);
        loading.setBackgroundResource(R.drawable.loader);

        AnimationDrawable load = (AnimationDrawable) loading.getBackground();
        load.start();

        new Handler().postDelayed(new Runnable(){

            public void run(){
                Intent i = new Intent(SplashActivity.this, PrimeiraActivity.class);
                startActivity(i);

                finish();
            }
        }, splashTime);
    }


}
