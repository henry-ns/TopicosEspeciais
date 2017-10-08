package br.edu.ifpb.splash2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends Activity {

    @Override
    protected void onCreate(Bundle save) {
        super.onCreate(save);
        setContentView(R.layout.activity_segunda);
    }

    protected void onClickBuscar(View v){
        EditText txt = (EditText) findViewById(R.id.txt);
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.br/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q="+
                txt.getText().toString()));
        startActivity(i);
    }
}
