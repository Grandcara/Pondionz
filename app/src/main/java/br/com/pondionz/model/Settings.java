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
