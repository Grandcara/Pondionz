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
