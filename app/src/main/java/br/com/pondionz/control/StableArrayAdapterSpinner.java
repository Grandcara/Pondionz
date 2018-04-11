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

package br.com.pondionz.control;

/**
 * Created by Iago on 31/12/2015.
 * **/
 import java.util.ArrayList;
 import android.app.Activity;
 import android.content.Context;
 import android.graphics.Color;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.ArrayAdapter;
 import android.widget.TextView;

 import br.com.pondionz.R;

/***** Adapter class extends with ArrayAdapter ******/
public class StableArrayAdapterSpinner extends ArrayAdapter<String>{

    private ArrayList<String> data;
    private LayoutInflater inflater;

    /*************  CustomAdapter Constructor *****************/
    public StableArrayAdapterSpinner(Activity activitySpinner, int textViewResourceId, ArrayList<String> objects) {
        super(activitySpinner, textViewResourceId, objects);

        /********** Take passed values **********/
        data     = objects;

        /***********  Layout inflator to call external xml layout () **********************/
        inflater = (LayoutInflater) activitySpinner.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // This funtion called for each row ( Called data.size() times )
    private View getCustomView(int position, View convertView, ViewGroup parent) {

        /********** Inflate spinner_rows.xml file for each row ( Defined below ) ************/
        View row = inflater.inflate(R.layout.spinner_rows, parent, false);

        /***** Get each Model object from Arraylist ********/

        TextView label        = (TextView)row.findViewById(R.id.company);
        //ImageView imgView =(ImageView)row.findViewById(R.id.imageViewSpinnerHorario);
        //imgView.setImageResource(R.mipmap.ic_setatransparente);
        // Set values for spinner each row
        label.setText(data.get(position).toString());
        label.setTextColor(Color.parseColor("#000000"));
        label.setBackgroundResource(R.color.blue50);
        row.setBackgroundResource(R.color.blue50);

        return row;
    }
}