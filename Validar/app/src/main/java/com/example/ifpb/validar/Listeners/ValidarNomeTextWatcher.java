package com.example.ifpb.validar.Listeners;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.ifpb.validar.MainActivity;
import com.example.ifpb.validar.R;

import java.util.regex.Pattern;

/**
 * Created by IFPB on 14/09/2016.
 */
public class ValidarNomeTextWatcher implements TextWatcher{
    MainActivity main;

    public ValidarNomeTextWatcher(MainActivity main){
        this.main = main;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String s = String.valueOf(charSequence);
        Button enviar  = main.getEnviar();
        String[] nom = s.split("\\s+");

        if (nom.length > 1){
           int c = 0;

           for (int j = 0; j < nom.length; j++){
                if(nom[j].matches("[A-Z][a-z]+")){
                    c ++;
                }
            }

           if(c == nom.length){
               main.setNomeColor("#7fa87f");
           } else {
               main.setNomeColor("#FF0000");
           }

        } else {
            main.setNomeColor("#FF0000");
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
