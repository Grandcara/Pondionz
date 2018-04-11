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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.pondionz.R;

/**
 * Created by Iago on 03/02/2016.
 */
public class StableArrayAdapterHelpList extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public StableArrayAdapterHelpList(Context context, String[] values) {
        super(context, R.layout.listcustomadapter, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listcustomadapter, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.tvCustonadapter);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.ivCustomAdapter);
        textView.setText(values[position]);
        // Change the icon for Windows and iPhone
        if (position == 0) {
            imageView.setImageResource(R.mipmap.ic_fb);
        }else if(position == 1){
            imageView.setImageResource(R.mipmap.ic_star);
        }else if(position == 2){
            imageView.setImageResource(R.mipmap.ic_msg);
        }
        else if(position == 3){
            imageView.setImageResource(R.mipmap.ic_grana);
        }


        return rowView;
    }

}