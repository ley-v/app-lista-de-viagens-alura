package com.example.artnocaifamviagens.ui.main.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBr = new SimpleDateFormat(DIA_E_MES);
        String dataFormatadaIda = formatoBr.format(dataIda.getTime());
        String dataFormatadaVolta = formatoBr.format(dataVolta.getTime());
        String dataFormatadaDaViagem = dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
        return dataFormatadaDaViagem;
    }
}
