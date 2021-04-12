package com.example.solicitarcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


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
        if (quantidade == 100) {
            return;
        }
        quantidade = quantidade + 1;
        mostrarQuantidade(quantidade);
    }

    /**
     * Este método é ativado quando o botão "-" é clicado.
     */
    public void subtracao(View view) {
        if (quantidade == 1) {
            return;
        }
        quantidade = quantidade - 1;
        mostrarQuantidade(quantidade);
    }

    /**
     * Este método é ativado quando o botão de "atualizar o carrinho" é clicado.
     */
    public void atualizar(View view) {
        EditText nomeUsuario = (EditText) findViewById(R.id.nome_usuario);
        String nome = nomeUsuario.getText().toString();
        CheckBox copoDescartavel = (CheckBox) findViewById(R.id.copo_descartavel);
        boolean adicionarDescartavel = copoDescartavel.isChecked();
        CheckBox comLeite = (CheckBox) findViewById(R.id.com_leite);
        boolean adicionarLeite = comLeite.isChecked();
        int preco = calcularPreco();
        String mensagemValor = resumoPedido(nome, preco, adicionarDescartavel, adicionarLeite);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pedido do café " + nome);
        intent.putExtra(intent.EXTRA_TEXT, mensagemValor);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calcularPreco() {
        return quantidade * 5;
    }

    private String resumoPedido(String nome, int preco, boolean adicionarDescartavel, boolean adicionarLeite) {
        String mensagemValor = getString(R.string.atualizar_pedido);
        mensagemValor += "\n" + getString(R.string.quantidade);
        mensagemValor += "\n" + getString(R.string.copo_descartavel);
        mensagemValor += "\n" + getString(R.string.com_leite);
        mensagemValor += "\n" + getString(R.string.calcular_preco);
        mensagemValor += "\n\n" + getString(R.string.obrigado);
        return mensagemValor;
    }

    /**
     * Este método exibe o valor de quantidade fornecido na tela.
     */
    private void mostrarQuantidade(int numeroCafes) {
        TextView quantidadeTextView = (TextView) findViewById(
                R.id.quantidade);
        quantidadeTextView.setText("" + numeroCafes);
    }
}