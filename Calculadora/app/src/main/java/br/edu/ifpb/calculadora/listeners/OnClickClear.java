package br.edu.ifpb.calculadora.listeners;

import android.view.View;

import br.edu.ifpb.calculadora.MainActivity;

/**
 * Created by Henrique on 10/09/2016.
 */
public class OnClickClear implements View.OnClickListener {

    MainActivity main;

    public OnClickClear(MainActivity main){
        this.main = main;
    }

    @Override
    public void onClick(View view) {
        main.tela = "";
        main.op = "";
        main.updateScreen();

    }
}
