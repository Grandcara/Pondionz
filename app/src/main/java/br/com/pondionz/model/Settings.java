package br.com.pondionz.model;

/**
 * Created by Iago on 15/03/2016.
 */
public class Settings {
    // conjunto de tags 0 inativo 1 ativo, OMTI sendo 0000 todos inativo, 1000, ativo somente o O Onibus, 0100, M moto taxi ativo,
    //0010 T taxi ativo, 0001 somente Intermunicipal ativo, e suas concatenaçõoes 0101, 1100...
    private static int idCidade,idMostraMarker;
    public Settings(int idCidade){
        Settings.idCidade = idCidade;
    }

    public static int getIdCidade() {
        return idCidade;
    }

    public static void setIdCidade(int idCidade) {
        Settings.idCidade = idCidade;
    }

    public static int getIdMostraMarker() {
        return idMostraMarker;
    }

    public static void setIdMostraMarker(int idMostraMarker) {
        Settings.idMostraMarker = idMostraMarker;
    }
}
