package com.example.solicitarcafe;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * Este aplicativo exibe um pedido de café.
 */
public class MainActivity extends AppCompatActivity {

    int quantidade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Este método é ativado quando o botão "+" é clicado.
     */
    public void adicao(View view) {
        quantidade = quantidade + 1;
        display(quantidade);
    }

    /**
     * Este método é ativado quando o botão "-" é clicado.
     */
    public void subtracao(View view) {
        quantidade = quantidade - 1;
        display(quantidade);
    }

    /**
     * Este método é ativado quando o botão de "atualizar o carrinho" é clicado.
     */
    public void atualizar(View view) {
        displayPrice(quantidade * 5);
    }

    /**
     * Este método exibe o valor de quantidade fornecido na tela.
     */
    private void display(int number) {
        TextView quantidadeTextView = (TextView) findViewById(
                R.id.quantidade);
        quantidadeTextView.setText("" + number);
    }

    /**
     * Este método exibe o valor do preço fornecido na tela.
     */
    private void displayPrice(int number) {
        TextView valorTotal = (TextView) findViewById(R.id.valorTotal);
        valorTotal.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}