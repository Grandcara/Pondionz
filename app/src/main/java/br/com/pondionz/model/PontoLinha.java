package br.com.pondionz.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Iago on 29/12/2015.
 */
//Modelo de ponto linha onde vai ficar armazenados a relação de linha ponto do app
public class PontoLinha {
    private int idLinha,idPonto;
    private String sentido;
    private static List<PontoLinha> lista = new ArrayList<PontoLinha>();
    public PontoLinha(int idLinha, int idPonto){
        this.idLinha = idLinha;
        this.idPonto = idPonto;
        this.sentido = null;

    }
    public PontoLinha(int idLinha, int idPonto,String sentido){
        this.idLinha = idLinha;
        this.idPonto = idPonto;
        this.sentido = sentido;
    }

    public int getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(int idLinha) {
        this.idLinha = idLinha;
    }

    public static List<PontoLinha> getLista() {
        return lista;
    }

    public static void setLista(List<PontoLinha> lista) {
        PontoLinha.lista = lista;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public int getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(int idPonto) {
        this.idPonto = idPonto;
    }
}
