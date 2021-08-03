package com.example.artnocaifamviagens.ui.main.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolveDrawable(Context contexto, String drawableEmTexto) {
        // transformar string em drawable:   ##########
        Resources resources = contexto.getResources();
        //Com o resources temos a capacidade de pegar algum recurso a partir de alguma string
        int idDoDrawable = resources.getIdentifier(drawableEmTexto, DRAWABLE, contexto.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
        return drawableImagemPacote;
    }
}
