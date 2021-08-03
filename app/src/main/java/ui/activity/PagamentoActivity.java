package ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.artnocaifamviagens.R;
import com.example.artnocaifamviagens.ui.main.Pacote;
import com.example.artnocaifamviagens.ui.main.util.MoedaUtil;

import java.math.BigDecimal;

import static ui.activity.PacoteActivityConstante.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);

//        Pacote pacoteSaoPaulo = new Pacote("Sampa", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        carregaPacoteRecebido();

    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)){
            Pacote pacoteFluxo2 = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

        mostraPreco(pacoteFluxo2);

            configuraBotao(pacoteFluxo2);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button botao = findViewById(R.id.pagamento_botao_finaliza_compra);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaResumoCompra(pacote);

            }
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        preco.setText(MoedaUtil.formataMoedaParaEuro(pacote.getPreco()));
    }
}