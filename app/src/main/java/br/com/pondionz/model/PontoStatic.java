package br.com.pondionz.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Iago on 28/12/2015.
 */
//Modelo dos pontos de onibus da aplicação
public class PontoStatic {
    private static Ponto pontoStatic;

    public static Ponto getPontoStatic() {
        if(pontoStatic == null){
            pontoStatic = new Ponto();
            pontoStatic.setIdPonto(0);
            pontoStatic.setDirecao(null);
            //falso ser sempre 1

        }
        return pontoStatic;
    }

    public static void  setTipoStatic(int tipo) {
        pontoStatic.setTipo(tipo);
    }
    public static void setLatLngStatic(LatLng latLng) {

        pontoStatic.setLatLng(latLng);
    }
    public static void setDirecaoStatic(String direcao) {

       pontoStatic.setDirecao(direcao);
    }

    public static void setTitleStatic(String title) {

        pontoStatic.setTitle(title);
    }
    public static void setDescriptionStatic(String description) {

        pontoStatic.setDescription(description);
    }

}
