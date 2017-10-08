package br.edu.ifpb.calculadora.listeners;

import android.view.View;
import android.widget.Button;
import br.edu.ifpb.calculadora.MainActivity;

/**
 * Created by Henrique on 10/09/2016.
 */
public class OnClickNumber implements View.OnClickListener {

    MainActivity main;

    public OnClickNumber(MainActivity main){
        this.main = main;
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        main.tela += b.getText();
        main.updateScreen();
    }
}
