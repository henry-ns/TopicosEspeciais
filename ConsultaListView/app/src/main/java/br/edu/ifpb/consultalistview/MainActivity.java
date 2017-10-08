package br.edu.ifpb.consultalistview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView lista;
    private List<String> listBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listBase = new ArrayList<>();
        listBase.add("Henrique");
        listBase.add("Renato");
        listBase.add("José");
        listBase.add("Jaum");
        listBase.add("Jaum II");
        listBase.add("Pedro");

        lista = (ListView) findViewById(R.id.lista);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listBase);
        lista.setAdapter(adapter);

        EditText edtNome = (EditText) findViewById(R.id.edtNome);
        edtNome.addTextChangedListener(new ConsultaTextWatcher(this));
    }

    public ListView getLista (){
        return this.lista;
    }

    public void setLista (List<String>  listPesquisa){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listPesquisa);
        this.lista.setAdapter(adapter);
    }

    public List<String> getListBase (){
        return this.listBase;
    }

}
