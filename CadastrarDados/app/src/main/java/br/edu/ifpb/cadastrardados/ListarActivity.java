package br.edu.ifpb.cadastrardados;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.concurrent.ExecutionException;

import br.edu.ifpb.cadastrardados.asynctask.ListarAsyncTask;

public class ListarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        ListView list = (ListView) findViewById(R.id.list);
        ListarAsyncTask listPessoa = new ListarAsyncTask();

        try {

            ArrayAdapter<Pessoa> adapter = new ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1, listPessoa.execute("http://ladoss.info:8773/Convite_SERVICE/convidado/listar").get());
            list.setAdapter(adapter);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
