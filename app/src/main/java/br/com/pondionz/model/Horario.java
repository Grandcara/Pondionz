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
//Modelo do horario ultilizado na aplicação
public class Horario {
    private int idLinha;
    private String horarioX,horarioY,infoAdicionaisX,infoAdicionaisY ;
    private int tipo; //Determina: 1 = Segunda a sexta , 2 = sabado , 3 = domingo e feriados, 4 = todos os dias sao os msm
    public Horario(int idLinha, String horarioX,String infoAdicionaisX, String horarioY,String infoAdicionaisY,int tipo){
        this.idLinha = idLinha;
        this.horarioX = horarioX;
        this.horarioY = horarioY;
        this.infoAdicionaisX = infoAdicionaisX;
        this.infoAdicionaisY = infoAdicionaisY;
        this.tipo = tipo;
    }



    public int getTipo() {
        return tipo;
    }

    public int getIdLinha() {
        return idLinha;
    }

    public String getInfoAdicionaisX() {
        return infoAdicionaisX;
    }

    public void setInfoAdicionaisX(String infoAdicionaisX) {
        this.infoAdicionaisX = infoAdicionaisX;
    }

    public String getInfoAdicionaisY() {
        return infoAdicionaisY;
    }

    public void setInfoAdicionaisY(String infoAdicionaisY) {
        this.infoAdicionaisY = infoAdicionaisY;
    }

    public void setIdLinha(int idLinha) {
        this.idLinha = idLinha;
    }

    public String getHorarioX() {
        return horarioX;
    }

    public void setHorarioX(String horarioX) {
        this.horarioX = horarioX;
    }

    public String getHorarioY() {
        return horarioY;
    }

    public void setHorarioY(String horarioY) {
        this.horarioY = horarioY;
    }
}
