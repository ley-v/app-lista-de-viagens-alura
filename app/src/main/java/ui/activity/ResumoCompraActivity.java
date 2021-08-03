package ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artnocaifamviagens.R;
import com.example.artnocaifamviagens.ui.main.Pacote;
import com.example.artnocaifamviagens.ui.main.util.DataUtil;
import com.example.artnocaifamviagens.ui.main.util.MoedaUtil;
import com.example.artnocaifamviagens.ui.main.util.ResourceUtil;

import java.math.BigDecimal;

import static ui.activity.PacoteActivityConstante.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);

//        Pacote pacoteSaoPaulo = new Pacote("Sampa", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        carregaPacoteRecebido();


    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)){
            Pacote pacoteFluxo3 = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            inicializaCampos(pacoteFluxo3);
        }
    }

    private void inicializaCampos(Pacote pacoteFluxo3) {
        mostraLocal(pacoteFluxo3);
        mostraImagem(pacoteFluxo3);
        mostraData(pacoteFluxo3);
        mostraPreco(pacoteFluxo3);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        preco.setText(MoedaUtil.formataMoedaParaEuro(pacote.getPreco()));
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data_viagem);
        data.setText(DataUtil.periodoEmTexto(pacote.getDias()));
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        imagem.setImageDrawable(ResourceUtil.devolveDrawable(this, pacote.getImagem()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacote.getLocal());
    }
}