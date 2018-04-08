package br.com.pondionz.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Iago on 28/12/2015.
 */
//Modelo dos pontos de onibus da aplicação
public class Ponto {
    private int idPonto,idCidade,tipo;
    //tipo vai ser 0 para ponto de onibus, 1 moto taxi, 2 taxi
    private LatLng latLng;
    private String title,description,direcao;

    public void setIdPonto(int idPonto) {
        this.idPonto = idPonto;
    }

    @Override
    public String toString(){
        return "idPonto: "+idPonto+" LatLong: "+latLng.toString()+" title: "+ title+" description:"+ description+" direcao: "+direcao+" tipo: "+tipo;
    }
    public Ponto(){}


    public Ponto(int idPonto,int idCidade,LatLng latLng, String title, String description,String direcao,int tipo) {
        this.idPonto = idPonto;
        this.idCidade = idCidade;
        this.latLng = latLng;
        this.title = title;
        this.description = description;
        this.direcao = direcao;
        this.tipo = tipo;
    }
    public Ponto(int idPonto,int idCidade ,LatLng latLng, String title, String description,String direcao) {
        this.idPonto = idPonto;
        this.idCidade = idCidade;
        this.latLng = latLng;
        this.title = title;
        this.description = description;
        this.direcao = direcao;
        this.tipo = 0;
    }
    public Ponto(int idPonto,int idCidade ,LatLng latLng, String title, String description,int tipo) {
        this.idPonto = idPonto;
        this.idCidade = idCidade;
        this.latLng = latLng;
        this.title = title;
        this.description = description;
        this.tipo = tipo;
        this.direcao = null;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public Ponto(LatLng latLng, String title, String description){

        this.latLng = latLng;
        this.title = title;

        this.description = description;
    }
    //ponto static para cadastro



    public String getDirecao(){
        return direcao;
    }
    public LatLng getLatLng() {
        return latLng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getIdPonto() {

        return idPonto;
    }

   public int getTipo(){
       return tipo;
   }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }
}
