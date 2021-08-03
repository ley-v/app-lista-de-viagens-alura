package ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artnocaifamviagens.R;
import com.example.artnocaifamviagens.ui.main.util.DiasUtil;
import com.example.artnocaifamviagens.ui.main.util.MoedaUtil;
import com.example.artnocaifamviagens.ui.main.Pacote;
import com.example.artnocaifamviagens.ui.main.util.ResourceUtil;

import java.util.List;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context contexto;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context contexto){

        this.pacotes = pacotes;
        this.contexto = contexto;
    }
    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(contexto).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(position);

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String moedaPortuguesa = MoedaUtil.formataMoedaParaEuro(pacote.getPreco());
        preco.setText(moedaPortuguesa);
    }



    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }



    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = ResourceUtil.devolveDrawable(contexto, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }



    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}