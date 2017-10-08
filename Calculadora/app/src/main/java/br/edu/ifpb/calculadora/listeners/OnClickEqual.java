package br.edu.ifpb.calculadora.listeners;

import android.view.View;

import br.edu.ifpb.calculadora.MainActivity;

/**
 * Created by Henrique on 10/09/2016.
 */
public class OnClickEqual implements View.OnClickListener {
    MainActivity main;

    public OnClickEqual (MainActivity main){
        this.main = main;
    }

    @Override
    public void onClick(View view) {

        main.screen.setText( String.valueOf (main.result()) );

    }

}
