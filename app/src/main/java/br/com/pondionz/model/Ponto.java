/*
 *  Copyright (C) 2016 Iago de Castro Alvarenga <iagodecastro@yahoo.com.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 *
 */

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
