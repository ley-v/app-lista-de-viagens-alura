package com.example.artnocaifamviagens.ui.main.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {
    public static String formataMoedaParaEuro(BigDecimal valor) {
//        BigDecimal precoDoPacote = pacote.getPreco();
        NumberFormat formatoPt = DecimalFormat.getCurrencyInstance(new Locale("pt", "pt"));
        String moedaPortuguesa = formatoPt.format(valor);
        return moedaPortuguesa;
    }
}
