package com.example.ifpb.validar.Listeners;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.ifpb.validar.MainActivity;

/**
 * Created by IFPB on 14/09/2016.
 */
public class ValidarEndTextWatcher implements TextWatcher {
    MainActivity main;

    public ValidarEndTextWatcher(MainActivity main){
        this.main = main;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        EditText end = main.getEnd();
        Button enviar  = main.getEnviar();

        if (charSequence.length() >= 1){
            end.setTextColor(Color.parseColor("#7fa87f"));
            main.setNome(end);
        } else {
            end.setTextColor(Color.parseColor("#FF0000"));
            main.setNome(end);
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}