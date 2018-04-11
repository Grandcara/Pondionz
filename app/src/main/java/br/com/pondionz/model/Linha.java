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

/**
 * Created by Iago on 29/12/2015.
 */
//Modelo da linha de onibus que utilizamos na aplicação
public class Linha {
    private int idLinha,cidade;
    private String name,pontoX,pontoY,empresa;
    private double tarifa;
    private boolean selected = false;
    public Linha(int idLinha, String name,String pontoX, String pontoY,double tarifa,String empresa,int cidade){
        this.idLinha = idLinha;

        this.name = name;
        this.pontoX = pontoX;
        this.pontoY = pontoY;
        this.tarifa = tarifa;
        this.empresa = empresa;
        this.cidade = cidade;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public int getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(int idLinha) {
        this.idLinha = idLinha;
    }
    public String getEmpresa(){
        return empresa;
    }
    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPontoX() {
        return pontoX;
    }

    public void setPontoX(String pontoX) {
        this.pontoX = pontoX;
    }

    public String getPontoY() {
        return pontoY;
    }

    public void setPontoY(String pontoY) {
        this.pontoY = pontoY;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
