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