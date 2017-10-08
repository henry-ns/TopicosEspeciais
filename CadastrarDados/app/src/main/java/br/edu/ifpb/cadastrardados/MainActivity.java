package br.edu.ifpb.cadastrardados;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import br.edu.ifpb.cadastrardados.listiners.TelaCadastarListiner;
import br.edu.ifpb.cadastrardados.listiners.TelaListarListiner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cadastrar = (Button) findViewById(R.id.cadastrar);
        Button listar = (Button) findViewById(R.id.listar);

        cadastrar.setOnClickListener(new TelaCadastarListiner(this));
        listar.setOnClickListener(new TelaListarListiner(this));
    }

}
