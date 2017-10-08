package br.edu.ifpb.consultalistview;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrique on 23/09/2016.
 */
public class ConsultaTextWatcher implements TextWatcher {
    private MainActivity main;

    public ConsultaTextWatcher(MainActivity main){
        this.main = main;
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        List<String> lista = new ArrayList<>();
        lista.clear();

        for (int j = 0; j < main.getListBase().size(); j++){
            if (main.getListBase().get(j).matches(".*(?i)"+charSequence+".*")){
                lista.add(main.getListBase().get(j));
            }
        }

        main.setLista(lista);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
