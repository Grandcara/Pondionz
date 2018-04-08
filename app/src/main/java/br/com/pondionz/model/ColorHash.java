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
        colorhash.put(0, R.drawable.bg_yellow);
        colorhash.put(1, R.drawable.bg_blue);
        colorhash.put(2, R.drawable.bg_red);
        colorhash.put(3, R.drawable.bg_green);
        colorhash.put(4, R.drawable.bg_pink);
        colorhash.put(5, R.drawable.bg_orage);
        colorhash.put(6, R.drawable.bg_marrom);
        colorhash.put(7, R.drawable.bg_maguenta);
        colorhash.put(8, R.drawable.bg_maguentaa);
        colorhash.put(9, R.drawable.bg_marromb);
        colorhash.put(10, R.drawable.bg_oragec);
    }
    public int getColor(int key){
        if(key > 10){
            return colorhash.get(10);
        }
        return colorhash.get(key);
    }
}
