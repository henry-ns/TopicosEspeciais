package br.edu.ifpb.intentapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PrimeiraActivity extends Activity {

    private GoogleApiClient client;
    ImageView iv;

    @Override
    protected void onCreate(Bundle save) {
        super.onCreate(save);
        setContentView(R.layout.activity_primeira);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        iv = (ImageView) findViewById(R.id.iv);

        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("img");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        iv.setImageBitmap(bmp);
    }

    protected void onClickConf(View v) {
        Log.i("PrimeiraActivity","onClickConf");
        Intent i = new Intent(Settings.ACTION_SETTINGS);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    protected void onClickMapa(View v) {
        Log.i("PrimeiraActivity","onClickMapa");
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps"));
        startActivity(i);
    }

    protected void onClickMusic(View v) {
        Log.i("PrimeiraActivity","onMusic");
        Intent i = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);

        startActivity(i);
    }

    protected void onClickSMS(View v) {
        Log.i("PrimeiraActivity","onClickSMS");
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "989898989", null));
        startActivity(i);
    }

    protected void onClickAlarme(View v) {
        Log.i("PrimeiraActivity","onClickAlarme");
        Intent i = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
        startActivity(i);
    }

    protected void onClickBusca(View v) {
        Log.i("PrimeiraActivity","onClickBusca");
        Intent i = new Intent(this, SegundaActivity.class);
        startActivity(i);
    }
}