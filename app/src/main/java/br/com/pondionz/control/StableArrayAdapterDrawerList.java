package br.com.pondionz.control;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import br.com.pondionz.dao.DBFFavorite;
import br.com.pondionz.dao.DBFHorarios;
import br.com.pondionz.model.Horario;
import br.com.pondionz.R;
import br.com.pondionz.model.Linha;

/**
 * Created by Iago on 03/02/2016.
 */
public class StableArrayAdapterDrawerList extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public StableArrayAdapterDrawerList(Context context, String[] values) {
        super(context, R.layout.listcustomadapter, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.listcustomadapter, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.tvCustonadapter);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.ivCustomAdapter);
        textView.setText(values[position]);

        List<Linha> linhas = new DBFFavorite(getContext()).getAllLinhaFavoriteDAO();

        //futuramente eu queria deixar essa posição 0 mais bonita mas por bug nos scrollview n farei isso agora
        if (position == 0 && linhas.size() != 0) {

            View rowView2 = inflater.inflate(R.layout.info_favorites_drawer, parent, false);
            //Onde seram aparesetados os horarios
            TextView tvHorarios = (TextView) rowView2.findViewById(R.id.tvonibushorario);

            Calendar calendar =  Calendar.getInstance();

            //Horarios seram apresetados em formato String infelizmente.
            String horarios="";

            List<Horario> listhorarios;
            int qt = 0;
            //Como nao sabemos a direção desejada pelo usuario mostraremos os dois horarios
            String direcao= "xy";

            for(int j = 0;j<linhas.size();j++){
                //verifica o dia da semana e busca os horarios de acordo
                if (calendar.get(Calendar.DAY_OF_WEEK) >= 2 && calendar.get(Calendar.DAY_OF_WEEK) <= 6) {//segunda a sexta tipo 1
                    listhorarios = new DBFHorarios(getContext()).getRotaHorariosEspecificosDAO(linhas.get(j).getIdLinha(),calendar.get(Calendar.HOUR_OF_DAY),direcao,1);
                } else if (calendar.get(Calendar.DAY_OF_WEEK) == 7) { //sabado tipo 2
                    listhorarios = new DBFHorarios(getContext()).getRotaHorariosEspecificosDAO(linhas.get(j).getIdLinha(),calendar.get(Calendar.HOUR_OF_DAY),direcao,2);
                } else
                    listhorarios = new DBFHorarios(getContext()).getRotaHorariosEspecificosDAO(linhas.get(j).getIdLinha(),calendar.get(Calendar.HOUR_OF_DAY),direcao,3);

                if(listhorarios.size() > 0) {

                    Log.i("Script previa horarios", String.valueOf(listhorarios.size()) +" dia:"+String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)));

                    horarios += linhas.get(j).getName() + ", saindo do(a) " + linhas.get(j).getPontoX()+" \n| ";
                    for (int i = 0; i < listhorarios.size(); i++) {
                        if (listhorarios.get(i).getHorarioX().length() > 0){
                            horarios += listhorarios.get(i).getHorarioX() + " | ";
                        }
                    }
                    horarios += "\n\n";
                    horarios += linhas.get(j).getName() + ", saindo do(a) " + linhas.get(j).getPontoY()+" \n| ";
                    for (int i = 0; i < listhorarios.size(); i++) {
                        if (listhorarios.get(i).getHorarioX().length() > 0) {
                            horarios += listhorarios.get(i).getHorarioY() + " | ";
                        }
                    }
                    horarios += "\n\n";

                }else{
                    qt++;
                }
                if(qt == linhas.size())
                    horarios="Nenhum horário favorito previsto.";
            }
            tvHorarios.setText(horarios);
            return rowView2;
        }else if (position == 1) {
            imageView.setImageResource(R.drawable.ic_bus_drawer);
        }else if(position == 2){
            imageView.setImageResource(R.drawable.ic_star_drawer);
        }else if(position == 3){
            imageView.setImageResource(R.drawable.ic_sobre);
        }else if(position == 4){
            imageView.setImageResource(R.drawable.ic_settings_black_36dp);
        }
        else if(position == 5){
            View rowView3 = inflater.inflate(R.layout.listcustomadapterparceiros, parent, false);
            TextView textView2 = (TextView) rowView3.findViewById(R.id.tvCustonadapter);
            textView2.setText(values[position]);
            ImageView imageView2 = (ImageView) rowView3.findViewById(R.id.ivCustomAdapter);
            imageView2.setImageResource(R.drawable.contacnext);
            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage("com.griffin.contacnext");
                    if(launchIntent != null){
                        context.startActivity(launchIntent);
                    }else{
                        String url2 = "https://play.google.com/store/apps/details?id=com.griffin.contacnext";
                        Intent i2 = new Intent(Intent.ACTION_VIEW);
                        i2.setData(Uri.parse(url2));
                        context.startActivity(i2);
                    }
                }
            });
            return rowView3;
        }

        return rowView;
    }


}