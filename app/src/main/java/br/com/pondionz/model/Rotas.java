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

import java.util.Hashtable;

import br.com.pondionz.R;

/**
 * Created by Iago on 23/01/2016.
 */

public class Rotas {
    private final static Hashtable<String, Integer> rotas = new Hashtable<String, Integer>();

    public Rotas(){
        inicalizeHash();
    }
    private static void inicalizeHash(){
        rotas.put("1x", R.raw.l1cidadetrevox);
        rotas.put("1y", R.raw.l1cidadetrevoy);
        rotas.put("2x", R.raw.l2cidadedscmx);
        rotas.put("2y", R.raw.l2cidadedscmy);
        rotas.put("3x", R.raw.l3tijucogiarolax);
        rotas.put("3y", R.raw.l3tijucogiarolay);
        rotas.put("4x", R.raw.l4tijucoaltardasaguasx);
        rotas.put("4y", R.raw.l4tijucoaltardasaguasy);
        rotas.put("5x", R.raw.l5tijucosolardaserrax);
        rotas.put("5y", R.raw.l5tijucosolardaserray);
        rotas.put("6x", R.raw.l6tijucobengox);
        rotas.put("6y", R.raw.l6tijucobengoy);
        rotas.put("7x", R.raw.l7tijucopioiix);
        rotas.put("7y", R.raw.l7tijucopioiiy);
        rotas.put("8x", R.raw.l8barropretopioiix);
        rotas.put("8y", R.raw.l8barropretopioiiy);
        rotas.put("9x", R.raw.l9maquineguardamox);
        rotas.put("9y", R.raw.l9maquineguardamoy);
    }
    public Hashtable<String, Integer> getRotas(){
        return rotas;
    }
}
