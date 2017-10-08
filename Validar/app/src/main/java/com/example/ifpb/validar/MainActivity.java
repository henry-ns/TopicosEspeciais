package com.example.ifpb.validar;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ifpb.validar.Listeners.OnClickData;
import com.example.ifpb.validar.Listeners.ValidarEndTextWatcher;
import com.example.ifpb.validar.Listeners.ValidarNomeTextWatcher;

public class MainActivity extends Activity {
    private EditText nome;
    private EditText data;
    private EditText end;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.nome);
        end = (EditText) findViewById(R.id.end);

        nome.addTextChangedListener(new ValidarNomeTextWatcher(this));
        end.addTextChangedListener(new ValidarEndTextWatcher(this));

        Button enviar = (Button) findViewById(R.id.enviar);
    }

    public void setEnviar(Button enviar){
        this.enviar = enviar;
    }

    public Button getEnviar(){
        return this.enviar;
    }

    public void setNome(EditText nome){
        this.nome = nome;
    }

    public EditText getNome(){
        return this.nome;
    }

    public void setData(int ano, int mes, int dia){
        this.data.setText(dia+"/"+mes+"/"+ano);
    }

    public EditText getData(){
        return this.data;
    }

    public void setEnd(EditText end){
        this.end = end;
    }

    public EditText getEnd(){
        return this.end;
    }

    public void setNomeColor (String c){
        this.nome.setTextColor(Color.parseColor(c));
    }

}
