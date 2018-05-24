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

import android.graphics.Color;

import java.util.Hashtable;
import java.util.Random;

import br.com.pondionz.R;

/**
 * Created by Iago on 21/02/2016.
 */
public class ColorHash {
    private Hashtable<Integer, Integer> colorhash = new Hashtable<Integer, Integer>();
    public ColorHash() {
        colorhash.put(0, R.drawable.bg_yellow); //!
        colorhash.put(1, R.drawable.bg_blue); //"
        colorhash.put(2, R.drawable.bg_red); //#
        colorhash.put(3, R.drawable.bg_green); //$
        colorhash.put(4, R.drawable.bg_pink); //%
        colorhash.put(5, R.drawable.bg_orage); //¨
        colorhash.put(6, R.drawable.bg_marrom); //&
        colorhash.put(7, R.drawable.bg_maguenta); //*
        colorhash.put(8, R.drawable.bg_maguentaa); //(
        colorhash.put(9, R.drawable.bg_marromb); //-
        colorhash.put(10, R.drawable.bg_oragec); //)
    }

    public int getColor(int key){
        if(key > 10){
            return colorhash.get(10);
        }
        return colorhash.get(key);
    }

    public String getCaracter(int key){
        switch (key){
            case 0:  return "!";
            case 1:  return "\"";
            case 2:  return "#";
            case 3:  return "$";
            case 4:  return "%";
            case 5:  return "¨";
            case 6:  return "&";
            case 7:  return "*";
            case 8:  return "(";
            case 9:  return "-";
            case 10:  return ")";
            default: return "";
        }
    }
}
