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

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.pondionz.R;
import br.com.pondionz.model.Linha;
import br.com.pondionz.model.Rotas;
import br.com.pondionz.view.Imagem;
import br.com.pondionz.view.MarkerSetMap;
import br.com.pondionz.view.Horarios;

/**
 * Created by Iago on 04/02/2016.
 *
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter implements View.OnClickListener {
    private Activity context;
    private Map<String, Linha> itemCollections;
    private List<String> item;


    public ExpandableListAdapter(Activity context, List<String> item_names, Map<String, Linha> collections){
        this.context = context;
        this.item = item_names;
        this.itemCollections = collections;
    }
    //vai retornar uma Linha
    @Override
    public Object getChild(int groupposition, int childposition) {
        // TODO Auto-generated method stub
        return itemCollections.get(item.get(groupposition));
    }

    @Override
    public long getChildId(int groupposition, int childposition) {
        // TODO Auto-generated method stub
        return childposition;
    }

    @Override
    public View getChildView(int groupposition, int childpostion, boolean isLastchild, View convertview,
                             ViewGroup parent) {
        // TODO Auto-generated method stub
        final Linha childitem = (Linha) getChild(groupposition, childpostion);

        if(convertview==null){
            LayoutInflater inflater = context.getLayoutInflater();
            convertview = inflater.inflate(R.layout.listexpandcustomadapteritens, null);
        }

        ImageView imEmpresa = (ImageView) convertview.findViewById(R.id.imageViewEmpresa);
        ImageView imOnibus = (ImageView) convertview.findViewById(R.id.imageViewOnibus);

        //futuramente será necessario criar uma hash com essas informações para tornar o codigo mais dinamico a partir do ponto que
        //existir muitas empresas
        if(childitem.getEmpresa().equalsIgnoreCase("Viação Presidente São João del Rey")){
            imEmpresa.setImageResource(R.drawable.viacaopresidente);
            imOnibus.setImageResource(R.drawable.bus_presidente);
            imOnibus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Imagem(R.drawable.bus_presidente);
                    Intent intent = new Intent(context, Imagem.class);
                    context.startActivity(intent);
                }
            });
        }else if(childitem.getEmpresa().equalsIgnoreCase("Transoeste")){
            imEmpresa.setImageResource(R.drawable.transoeste);
           // imOnibus.setImageResource(R.drawable.bus_presidente);
            imOnibus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Imagem(R.drawable.transoeste);
                    Intent intent = new Intent(context, Imagem.class);
                    context.startActivity(intent);
                }
            });
        }else if(childitem.getEmpresa().equalsIgnoreCase("Viação Presidente Lafaite")){
            imEmpresa.setImageResource(R.drawable.viacaopresidente);
            imOnibus.setImageResource(R.drawable.bus_presidente);
            imOnibus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Imagem(R.drawable.bus_presidente);
                    Intent intent = new Intent(context, Imagem.class);
                    context.startActivity(intent);
                }
            });
        }else if(childitem.getEmpresa().equalsIgnoreCase("Viação Porto Real")){
            //imEmpresa.setImageResource(R.drawable.viacaopresidente);
            imOnibus.setImageResource(R.drawable.bus_portoreal);
            imOnibus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Imagem(R.drawable.bus_portoreal);
                    Intent intent = new Intent(context, Imagem.class);
                    context.startActivity(intent);
                }
            });
        }else if(childitem.getEmpresa().equalsIgnoreCase("Viação Formiga")){
            imEmpresa.setImageResource(R.drawable.viacaoformiga);
            imOnibus.setImageResource(R.drawable.bus_formiga);
            imOnibus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Imagem(R.drawable.bus_formiga);
                    Intent intent = new Intent(context, Imagem.class);
                    context.startActivity(intent);
                }
            });
        }
        //futuramente será necessario cadastrar a meia no banco de dados
        double tarifaEstudante = childitem.getTarifa()/2;

        TextView childtv = (TextView) convertview.findViewById(R.id.tvCustonadapterTarifa);
        if(childitem.getEmpresa().equalsIgnoreCase("Viação Presidente São João del Rey"))
            if(tarifaEstudante < 2)
                childtv.setText("Tarifa: "+String.format("%.2f",childitem.getTarifa())+"      Estudante: " +String.format("%.2f",tarifaEstudante));
            else
                childtv.setText("Tarifa: "+String.format("%.2f",childitem.getTarifa()));
        else if(childitem.getEmpresa().equalsIgnoreCase("Transoeste"))
            childtv.setText("Tarifa: "+String.format("%.2f",childitem.getTarifa())+"      Cartão: 3.60");
        else if((childitem.getEmpresa().equalsIgnoreCase("Viação Porto Real")))
            childtv.setText("Tarifa: "+String.format("%.2f",childitem.getTarifa()));
        else if((childitem.getEmpresa().equalsIgnoreCase("Viação Presidente Lafaite")))
            childtv.setText("Tarifa: "+String.format("%.2f",childitem.getTarifa()));
        else if(childitem.getEmpresa().equalsIgnoreCase("Viação Formiga"))
            childtv.setText("Tarifa: "+String.format("%.2f",childitem.getTarifa())+"      Cartão: 3.10");
        Button bt1 = (Button) convertview.findViewById(R.id.btRotasExpand);
        Button bt2 = (Button) convertview.findViewById(R.id.btHorariosExpand);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Horarios(childitem);
                Intent intent = new Intent(context, Horarios.class);
                context.startActivity(intent);
            }
        });

        ArrayList<String> itens = new ArrayList<String>();
        if(!childitem.getPontoX().equals(childitem.getPontoY())){
            itens.add("Saindo do(a) "+childitem.getPontoX());
            itens.add("Saindo do(a) "+childitem.getPontoY());
        }else itens.add("Saindo do(a) "+childitem.getPontoX());

        final ArrayAdapter<String> adapterMap = new ArrayAdapter<String>(context, R.layout.item_alerta, itens);
        final Rotas rotas = new Rotas();

        //Botão que adiciona no mapa as rotas caso ela exista
        if(!rotas.getRotas().containsKey(String.valueOf(childitem.getIdLinha()) + "x") && !rotas.getRotas().containsKey(String.valueOf(childitem.getIdLinha()) + "y")){
            bt1.setVisibility(View.INVISIBLE);
        }else     bt1.setVisibility(View.VISIBLE);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lista de itens
                AlertDialog alerta;
                AlertDialog.Builder builderMap= new AlertDialog.Builder(context);
                builderMap.setTitle("Escolha a direção:"); //define o diálogo como uma lista, passa o adapter.
                builderMap.setSingleChoiceItems(adapterMap, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                            if (arg1 == 0) {
                                Log.i("Mapa", "Mapa x foi adicionado");
                                new MarkerSetMap().setRotas(rotas.getRotas().get(String.valueOf(childitem.getIdLinha()) + "x"));
                            }
                            if (arg1 == 1) {
                                Log.i("Mapa", "Mapa Y foi adicionado");
                                new MarkerSetMap().setRotas(rotas.getRotas().get(String.valueOf(childitem.getIdLinha()) + "y"));

                            }
                            context.finish();
                    }
                });
                alerta = builderMap.create();
                alerta.show();
            }
        });
        return convertview;
    }

    @Override
    public int getChildrenCount(int groupposition) {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return item.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return item.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        String itemname = (String) getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater groupinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = groupinflater.inflate(R.layout.listexpandcustomadapter, null);

        }
        TextView tv = (TextView) convertView.findViewById(R.id.tvCustonadapter);
        tv.setText(itemname);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

    }

}