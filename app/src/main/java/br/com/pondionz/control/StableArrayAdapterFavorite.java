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