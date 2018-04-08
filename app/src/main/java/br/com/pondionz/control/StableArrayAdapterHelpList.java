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