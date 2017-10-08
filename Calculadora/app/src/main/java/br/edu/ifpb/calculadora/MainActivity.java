package br.edu.ifpb.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

import br.edu.ifpb.calculadora.listeners.OnClickEqual;
import br.edu.ifpb.calculadora.listeners.OnClickNumber;
import br.edu.ifpb.calculadora.listeners.OnClickOperador;
import br.edu.ifpb.calculadora.listeners.OnClickClear;

public class MainActivity extends Activity {
    public TextView screen;
    public String tela = "";
    public String op = "";
    public Double number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (TextView) findViewById(R.id.screen);
        updateScreen();

        Button btn0 = (Button) findViewById(R.id.btn0);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btnp = (Button) findViewById(R.id.btnp);

        Button div = (Button) findViewById(R.id.div);
        Button mult = (Button) findViewById(R.id.mult);
        Button sub = (Button) findViewById(R.id.sub);
        Button add = (Button) findViewById(R.id.add);

        Button del = (Button) findViewById(R.id.del);
        Button iqual = (Button) findViewById(R.id.iqual);


        btn0.setOnClickListener(new OnClickNumber(this));
        btn1.setOnClickListener(new OnClickNumber(this));
        btn2.setOnClickListener(new OnClickNumber(this));
        btn3.setOnClickListener(new OnClickNumber(this));
        btn4.setOnClickListener(new OnClickNumber(this));
        btn5.setOnClickListener(new OnClickNumber(this));
        btn6.setOnClickListener(new OnClickNumber(this));
        btn7.setOnClickListener(new OnClickNumber(this));
        btn8.setOnClickListener(new OnClickNumber(this));
        btn9.setOnClickListener(new OnClickNumber(this));
        btnp.setOnClickListener(new OnClickNumber(this));

        div.setOnClickListener(new OnClickOperador(this));
        mult.setOnClickListener(new OnClickOperador(this));
        sub.setOnClickListener(new OnClickOperador(this));
        add.setOnClickListener(new OnClickOperador(this));

        del.setOnClickListener(new OnClickClear(this));

        iqual.setOnClickListener(new OnClickEqual(this));
    }

    public void updateScreen() {
        screen.setText(tela);
    }

    public double result() {
        String[] numbers = tela.split(Pattern.quote(op));
        if (numbers.length == 1) {
            return Double.parseDouble(numbers[0]);
        } else {
            switch (op) {
                case "+":
                    return Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                case "-":
                    return Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                case "/":
                    return Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                case "*":
                    return Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                default:
                    return 0;
            }
        }
    }

}
