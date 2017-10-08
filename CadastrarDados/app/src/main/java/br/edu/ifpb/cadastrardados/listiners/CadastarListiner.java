package br.edu.ifpb.cadastrardados.listiners;

import android.view.View;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

import br.edu.ifpb.cadastrardados.CadastrarActivity;
import br.edu.ifpb.cadastrardados.Pessoa;
import br.edu.ifpb.cadastrardados.asynctask.CadastrarAsyncTask;

/**
 * Created by Henrique on 05/10/2016.
 */
public class CadastarListiner implements View.OnClickListener {

    private CadastrarActivity activity;

    public CadastarListiner(CadastrarActivity activity){
        this.activity = activity;
    }


    @Override
    public void onClick(View view) {
        CadastrarAsyncTask c = new CadastrarAsyncTask();

        try {
            String msg = c.execute(activity.getPessoa()).get();
            Toast toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT);
            activity.limparCampo();

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
