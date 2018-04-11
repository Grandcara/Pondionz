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
