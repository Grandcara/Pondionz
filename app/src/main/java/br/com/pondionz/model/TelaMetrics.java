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

import android.content.res.Configuration;

/**
 * Created by Iago on 21/02/2016.
 */
public class TelaMetrics {
    public int getMetrics(int metrics,int display_mode){
        int tamanhoHorizontal;
        if(metrics >= 1920 && display_mode == Configuration.ORIENTATION_PORTRAIT){
            tamanhoHorizontal = 9;//
        }
        else if(metrics >= 1500 && metrics < 2160 && display_mode == Configuration.ORIENTATION_PORTRAIT){
            tamanhoHorizontal = 7;//
        }
        else if(metrics >= 1196 && metrics < 1500 && display_mode == Configuration.ORIENTATION_PORTRAIT){
            tamanhoHorizontal = 7;//
        }else if(metrics >= 1080 && metrics < 1196 && display_mode == Configuration.ORIENTATION_PORTRAIT){
            tamanhoHorizontal = 6;//ok
        }else if(metrics >= 720 && metrics < 1080 && display_mode == Configuration.ORIENTATION_PORTRAIT){
            tamanhoHorizontal = 6;//ok
        }else if(metrics >= 640 && metrics < 720 && display_mode == Configuration.ORIENTATION_PORTRAIT){
            tamanhoHorizontal = 6;//ok
        }else if(metrics >= 480 && metrics < 640 && display_mode == Configuration.ORIENTATION_PORTRAIT){
            tamanhoHorizontal = 5;//ok
        }else if(metrics >= 320 && metrics < 480 && display_mode == Configuration.ORIENTATION_PORTRAIT) {
            tamanhoHorizontal = 4;//ok
        }else if(metrics >= 240 && metrics < 320 && display_mode == Configuration.ORIENTATION_PORTRAIT){
                tamanhoHorizontal = 4;//ok
        }else if(metrics > 2400 && display_mode == Configuration.ORIENTATION_LANDSCAPE){
            tamanhoHorizontal = 14;//ok
        }
        else if(metrics >= 2300 && metrics < 2400 && display_mode == Configuration.ORIENTATION_LANDSCAPE){
            tamanhoHorizontal = 12;//
        }
        else if(metrics >= 1700 && metrics < 2300 && display_mode == Configuration.ORIENTATION_LANDSCAPE){
            tamanhoHorizontal = 10;//ok
        }
        else if(metrics >= 1000 && metrics < 1700 && display_mode == Configuration.ORIENTATION_LANDSCAPE){
            tamanhoHorizontal = 10;//ok
        }else if(metrics >= 854 && metrics < 1000 && display_mode == Configuration.ORIENTATION_LANDSCAPE){
            tamanhoHorizontal = 8;//ok
        }else if(metrics >= 800 && metrics < 854 && display_mode == Configuration.ORIENTATION_LANDSCAPE){
            tamanhoHorizontal = 8;//ok
        }else if(metrics >= 480 && metrics < 800 && display_mode == Configuration.ORIENTATION_LANDSCAPE){
            tamanhoHorizontal = 7;//ok

        }else if(metrics >= 432 && metrics < 480 && display_mode == Configuration.ORIENTATION_LANDSCAPE){
            tamanhoHorizontal = 7;//ok
        }else if(metrics >= 400 && metrics < 432 && display_mode == Configuration.ORIENTATION_LANDSCAPE){
            tamanhoHorizontal = 7;//ok

        } else if(metrics >= 320 && metrics < 400 && display_mode == Configuration.ORIENTATION_LANDSCAPE){
            tamanhoHorizontal = 5;//ok
        }else tamanhoHorizontal=4;
        return tamanhoHorizontal;
    }
}
