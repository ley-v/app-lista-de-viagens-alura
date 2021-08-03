package ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artnocaifamviagens.R;
import com.example.artnocaifamviagens.ui.main.Pacote;
import com.example.artnocaifamviagens.ui.main.util.DataUtil;
import com.example.artnocaifamviagens.ui.main.util.DiasUtil;
import com.example.artnocaifamviagens.ui.main.util.MoedaUtil;
import com.example.artnocaifamviagens.ui.main.util.ResourceUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static ui.activity.PacoteActivityConstante.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);

//        Pacote pacoteSaoPaulo = new Pacote("Sampa", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        carregaPacoteRecebido();


    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)){
            Pacote pacoteFluxo = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            inicializaCampos(pacoteFluxo);
            configuraBotao(pacoteFluxo);
        }
    }

    private void configuraBotao(Pacote pacoteFluxo) {
        Button botao = findViewById(R.id.resumo_pacote_botao_realiza_pagamento);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vaiParaPagamento(pacoteFluxo);


            }
        });
    }

    private void vaiParaPagamento(Pacote pacoteFluxo) {
        //                    startActivity(new Intent(ResumoPacoteActivity.this, PagamentoActivity.class));
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteFluxo);
        startActivity(intent);
    }

    private void inicializaCampos(Pacote pacoteFluxo) {
        mostraLocal(pacoteFluxo);
        mostraImagem(pacoteFluxo);
        mostraDias(pacoteFluxo);
        mostraPreco(pacoteFluxo);
        mostraData(pacoteFluxo);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaDaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }



    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        preco.setText(MoedaUtil.formataMoedaParaEuro(pacote.getPreco()));
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        dias.setText(DiasUtil.formataEmTexto(pacote.getDias()));
//        dias.setText(String.valueOf(pacoteSaoPaulo.getDias()));
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        imagem.setImageDrawable(ResourceUtil.devolveDrawable(this, pacote.getImagem()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}