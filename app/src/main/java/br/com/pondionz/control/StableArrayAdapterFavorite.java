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

import java.util.ArrayList;
import java.util.List;

import br.com.pondionz.R;
import br.com.pondionz.model.Linha;

/**
 * Created by Iago on 03/02/2016.
 */
public class StableArrayAdapterFavorite extends ArrayAdapter<String> {
    private Context context;
    private String[] values;
    private List<Integer> favorites;
    private List<Linha> linhas;


    public StableArrayAdapterFavorite(Context context, String[] values,List<Integer> favorites, List<Linha> linhas) {
        super(context, R.layout.listcustomadapter, values);
        this.context = context;
        this.values = values;
        this.favorites = favorites;
        this.linhas = linhas;
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
        if (linhas.size() != 0 && favorites.contains(linhas.get(position).getIdLinha())) {
            imageView.setImageResource(R.drawable.ic_star_on);
        }else
        imageView.setImageResource(R.drawable.ic_star_off);
        return rowView;
    }
    public void atualizarLista(List<Integer> favorites) {

        this.favorites = favorites;
        //notifica que existe uma atualização e recontroe a listview
        notifyDataSetChanged();
    }

}