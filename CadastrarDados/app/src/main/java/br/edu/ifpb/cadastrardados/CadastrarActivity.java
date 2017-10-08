package br.edu.ifpb.cadastrardados;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifpb.cadastrardados.listiners.CadastarListiner;
import br.edu.ifpb.cadastrardados.listiners.TelaCadastarListiner;

public class CadastrarActivity extends Activity {

    private EditText txtNome;
    private EditText txtEnd;
    private EditText txtEmail;
    private EditText txtCPF ;

    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEnd = (EditText) findViewById(R.id.txtEnd);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtCPF = (EditText) findViewById(R.id.txtCPF);



        Button cadastrar = (Button) findViewById(R.id.cadastrar);
        cadastrar.setOnClickListener(new CadastarListiner(this));
    }

    public Pessoa getPessoa(){
        pessoa = new Pessoa(txtNome.getText().toString(),txtEmail.getText().toString(),txtEnd.getText().toString(),txtCPF.getText().toString());
        return this.pessoa;
    }

    public void setPessoa(Pessoa p){
        this.pessoa = p;
    }

    public void limparCampo(){
        this.txtNome.setText("");
        this.txtEnd.setText("");
        this.txtEmail.setText("");
        this.txtCPF.setText("");
    }
}
