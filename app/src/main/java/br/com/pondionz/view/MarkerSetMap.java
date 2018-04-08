package br.com.pondionz.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.BuildConfig;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.pondionz.control.GMailSender;
import br.com.pondionz.control.MapsActivity;
import br.com.pondionz.dao.DBFPonto;
import br.com.pondionz.dao.MySQLiteHelper;
import br.com.pondionz.model.Linha;
import br.com.pondionz.model.MarkerCustom;
import br.com.pondionz.model.Ponto;
import br.com.pondionz.R;
import br.com.pondionz.model.PontoLinha;
import br.com.pondionz.model.PontoStatic;
import br.com.pondionz.model.Settings;

/**
 * Created by Iago on 29/12/2015.
 */
//As principais mudanças no mapa para não serem feita no control e na treadh principal elas são alteradas diretamente aqui, tudo que vai ter alteração no mapa(na tread principal) tem de estar nesta classe
public class MarkerSetMap extends MapsActivity {
    private static GoogleMap mMap;
    private static ClusterManager<MarkerCustom> mClusterManager;
    private static Context context;
    private static boolean adicionarPonto = false;

    public MarkerSetMap(GoogleMap mMap, Context context) {
        MarkerSetMap.mMap = mMap;
        MarkerSetMap.context = context;
        //Marca todos os pontos disponiveis
        setUpClusterer();
        adicionarPonto = false;
    }

    public MarkerSetMap() {
    }

    //Retorna o map é um problema deixar ele public mas é necessario para controle em outras partes
    //(Criar uma classe pra rotas?)
    public void setRotas(int rota){
        if(mMap != null) {
            KmlLayer layer;
            try {
                layer = new KmlLayer(mMap, rota, context);
                reloadMarker();
                layer.addLayerToMap();
                fabAddMarker.setVisibility(View.INVISIBLE);
                fabAddMarkerCancel.setVisibility(View.VISIBLE);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Aqui a magia acontece para marcar os pontos bonitinhos no mapa e com a diminuição do zoo eles viram 1, aqui tbm ta contido a inicialização da camera que futuramente vai ser onde o usuario vai estar
    public void setUpClusterer() {
        // Initialize the manager with the context and the map.
        // (Activity extends context, so we can pass 'this' in the constructor.)
        mClusterManager = new ClusterManager<MarkerCustom>(context, mMap);
        //bússola é retirada por ficar lugar ruim
        mMap.getUiSettings().setCompassEnabled(false);
        //ativa os botoes de zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);
        // Point the map's listeners at the listeners implemented by the cluster
        // manager.
        mMap.setOnCameraChangeListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
        mClusterManager.setRenderer(new OwnIconRendered(context, mMap, mClusterManager));
        // Add cluster items (markers) to the cluster manager.
        reloadMarker();

        fabAddMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarPonto = true;
                Snackbar.make(v, "Clique no mapa onde deseja adicionar novo ponto", Snackbar.LENGTH_LONG).show();
                fabAddMarker.setVisibility(View.INVISIBLE);
                fabAddMarkerCancel.setVisibility(View.VISIBLE);
            }
        });
        fabAddMarkerCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarPonto = false;
                fabAddMarker.setVisibility(View.VISIBLE);
                fabAddMarkerCancel.setVisibility(View.INVISIBLE);
                reloadMarker();
            }
        });

        //adapater events
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            //Nao usado mas é necessario.
            @Override
            public View getInfoContents(Marker marker) {
               // TextView tv = new TextView(context);
                //tv.setText(Html.fromHtml("<b><font color=\"#ff0000\">" + marker.getTitle() + ":</font></b> " + marker.getSnippet()+""));
                return null;
            }

            //Controla a caixa dos marker no caso chamaos um linear layout
            @Override
            public View getInfoWindow(Marker marker) {
                LayoutInflater inflater = LayoutInflater.from(context);

                //A impreção do id é somente de texte para que o db seja populado
                if (marker.getTitle() != null && marker.getSnippet() != null) {
                    int tipo = new DBFPonto(context).getPontoTipoDAO(marker.getTitle());
                    Log.i("Tipo marker", "Tipo = "+ tipo);
                    if(tipo == 0) {
                        final View view = inflater.inflate(R.layout.bus_box, null);
                        TextView tvtitle = (TextView) view.findViewById(R.id.tvLinearCuston1);
                        TextView tvsnippet = (TextView) view.findViewById(R.id.tvLinearCuston2);
                        tvtitle.setText(String.valueOf(marker.getTitle()));
                        tvsnippet.setText(String.valueOf(marker.getSnippet()));//+ " Id:"+new MySQLiteHelper(context).getAllPontoNameDAO(marker.getTitle())));
                        return view;
                    }else if(tipo == 1){
                        View view = inflater.inflate(R.layout.moto_taxi_box, null);
                        TextView tvtitle = (TextView) view.findViewById(R.id.tvLinearCuston1);
                        TextView tvsnippet = (TextView) view.findViewById(R.id.tvLinearCuston2);
                        tvtitle.setText(String.valueOf(marker.getTitle()));
                        tvsnippet.setText(String.valueOf(marker.getSnippet()).substring(0,String.valueOf(marker.getSnippet()).indexOf("\n\nTelefone")));//+ " Id:"+new MySQLiteHelper(context).getAllPontoNameDAO(marker.getTitle())));
                        return view;
                    }else if(tipo == 2){
                        View view = inflater.inflate(R.layout.taxi_box, null);
                        TextView tvtitle = (TextView) view.findViewById(R.id.tvLinearCuston1);
                        TextView tvsnippet = (TextView) view.findViewById(R.id.tvLinearCuston2);
                        tvtitle.setText(String.valueOf(marker.getTitle()));
                        tvsnippet.setText(String.valueOf(marker.getSnippet()).substring(0,String.valueOf(marker.getSnippet()).indexOf("\n\nTelefone")));//+ " Id:"+new MySQLiteHelper(context).getAllPontoNameDAO(marker.getTitle())));
                        return view;
                    }
                }
                else  {
                    View view = inflater.inflate(R.layout.bus_box, null);
                    TextView tvtitle = (TextView) view.findViewById(R.id.tvLinearCuston1);
                    TextView tvsnippet = (TextView) view.findViewById(R.id.tvLinearCuston2);
                    tvtitle.setText("Aviso");
                    tvsnippet.setText("Aumente o zoom para mais detalhes");
                    return view;
                }

            return null;
            }
        });
        //ao clicar na view do marcador vc pode abrir mais coisas
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                //abrir nova activity (por algum motivo ele nao deixou usar o market direto no if)
                String markerTitle = marker.getTitle();
                if(markerTitle != null) {
                    int tipo = new DBFPonto(context).getPontoTipoDAO(marker.getTitle());
                    if(tipo == 0) {
                        //Vale a pena sempre criar um novo? ou tem como criar um e ir alterando ele?
                        new MarkerInfoBus(marker);

                        Intent intent = new Intent(context, MarkerInfoBus.class);
                        context.startActivity(intent);
                    }
                    else if(tipo == 1){
                        //Vale a pena sempre criar um novo? ou tem como criar um e ir alterando ele?
                        new MarkerInfoMotoTaxi(marker);
                        Intent intent = new Intent(context, MarkerInfoMotoTaxi.class);
                        context.startActivity(intent);
                    }else if(tipo == 2){
                        //Vale a pena sempre criar um novo? ou tem como criar um e ir alterando ele?
                        new MarkerInfoTaxi(marker);
                        Intent intent = new Intent(context, MarkerInfoTaxi.class);
                        context.startActivity(intent);
                    }
                }else mMap.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });
        //Controla o click no mapa, pode ser bom no futuro caso tenhamos alguma estrategia para que as pessoa possam popular de modo mais facil o banco de dados e ter controle em mais locais
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if(adicionarPonto){
                    PontoStatic.getPontoStatic().setLatLng(latLng);
                    PontoStatic.getPontoStatic().setIdCidade(Settings.getIdCidade());
                    fabAddMarker.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(context, NewMarker.class);
                    context.startActivity(intent);
                }
            }
        });
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker markerDragStart) {
                // TODO Auto-generated method stub
                if (BuildConfig.DEBUG)
                    Log.i("Marker drag", "start");
            }

            @Override
            public void onMarkerDragEnd(Marker markerDragEnd) {
                //atualiza o ponto
                PontoStatic.getPontoStatic().setLatLng(markerDragEnd.getPosition());
                if (BuildConfig.DEBUG)
                    Log.i("Marker drag", "start");
            }

            @Override
            public void onMarkerDrag(Marker markerDrag) {
                if (BuildConfig.DEBUG)
                    Log.i("Marker drag", "start");
            }
        });
    }

    public static void addNewMarker(){
        MarkerCustom offsetItem = new MarkerCustom(PontoStatic.getPontoStatic().getIdPonto(),PontoStatic.getPontoStatic().getLatLng().latitude,PontoStatic.getPontoStatic().getLatLng().longitude,PontoStatic.getPontoStatic().getTitle(),PontoStatic.getPontoStatic().getDescription(),PontoStatic.getPontoStatic().getTipo());
        mClusterManager.addItem(offsetItem);
        mClusterManager.cluster();
        fabAddMarkerCancel.setVisibility(View.INVISIBLE);
        fabAddMarkerSalve.setVisibility(View.VISIBLE);
        adicionarPonto = false;
        Toast.makeText(context, "Arraste o ponto até o lugar exato onde deve ficar, depois, clique em salvar.", Toast.LENGTH_LONG).show();
        fabAddMarkerSalve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DBFPonto(context).addNewMarker(PontoStatic.getPontoStatic());
                for (PontoLinha pl: PontoLinha.getLista()) {
                    Log.i("PONTOLINHA"," ADICIONAADO "+ pl.getIdLinha()+ " title "+new DBFPonto(context).getAllPontoIDDAO(PontoStatic.getPontoStatic().getTitle())+ " sentido: "+pl.getSentido());
                    new MySQLiteHelper(context).addNewLinhaPonto(new DBFPonto(context).getAllPontoIDDAO(PontoStatic.getPontoStatic().getTitle()),pl.getIdLinha(),pl.getSentido());
                }

                fabAddMarkerSalve.setVisibility(View.INVISIBLE);
                fabAddMarker.setVisibility(View.VISIBLE);
                AlertDialog alerta;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                //define o titulo
                builder.setTitle("Novo ponto!");
                // define a mensagem
                builder.setMessage("Deseja enviar as informações para que o ponto seja adicionado a todos?");
                //define um botão como positivo
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        mandarInformacoes();
                        Toast.makeText(context, "Salvo com sucesso", Toast.LENGTH_LONG).show();
                        mClusterManager.cluster();

                    }
                }); //define um botão como negativo.
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(context, "Salvo com sucesso", Toast.LENGTH_LONG).show();
                        mClusterManager.cluster();

                    }
                }); //cria o AlertDialog
                alerta = builder.create();
                alerta.show(); //Exibe
            }

            private void mandarInformacoes() {
                String msg = "insertValues.add(values(new Ponto(idPonto,"+PontoStatic.getPontoStatic().getIdCidade()+",new LatLng("+PontoStatic.getPontoStatic().getLatLng().latitude+","+PontoStatic.getPontoStatic().getLatLng().longitude+"),\""+PontoStatic.getPontoStatic().getTitle()+"\",\""+PontoStatic.getPontoStatic().getDescription()+"\",\"NULL\","+PontoStatic.getPontoStatic().getTipo()+")));";
                String vetor[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","1","2","3","4","5","z"};
                GMailSender sender = new GMailSender();
                for (PontoLinha pl: PontoLinha.getLista()) {
                    msg += "\ninsertValues.add(values(new PontoLinha("+pl.getIdLinha()+","+","+PontoStatic.getPontoStatic().getTitle()+")));"+pl.getSentido();//ok
                }
                try {
                    sender.sendMail("Novo Marker Adicionado",
                                              msg,
                            "pondionzi@gmail.com",
                            "pondionzi@gmail.com");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.e("SendMail", "Enviado sucesso");


            }
        });

    }
    public void reloadMarker(){
        if(mMap !=null) {
            mMap.clear();
            mClusterManager.clearItems();
            addItems();
        }
    }
    //Aqui é onde são adicionado os pontos LatLng Para a criação dos pontos no mapa
    //futuramente teremos que carregar de acordo com o zoom ou de acordo com a cidade onde o usuario esta
    //o banco de dados tem como fazer por cidade(mas é complicado)
    private void addItems() {

        // Set some lat/lng coordinates to start with.
        //Como carregar somente pontos na area? seria mto pessado ? teria que ficar recarregando sempre que existir um zoom?
        List<Ponto> pontoLista = new DBFPonto(context).getAllPontoDAO(Settings.getIdCidade());
        List<Ponto> pontoListaUser =  new DBFPonto(context).getAllPontoUsuarioDAO(Settings.getIdCidade());

        for(Ponto ponto : pontoLista) {
            MarkerCustom offsetItem = new MarkerCustom(-1,ponto.getLatLng().latitude, ponto.getLatLng().longitude,ponto.getTitle(), ponto.getDescription(),ponto.getTipo());
            mClusterManager.addItem(offsetItem);

        }
        for(Ponto ponto : pontoListaUser) {
            MarkerCustom offsetItem = new MarkerCustom(-1,ponto.getLatLng().latitude, ponto.getLatLng().longitude,ponto.getTitle(), ponto.getDescription(),ponto.getTipo());
            mClusterManager.addItem(offsetItem);

        }
        mClusterManager.cluster();
    }


    //Aqui é a customização dos pontos na hora de clicar neles icon titulo
    private class OwnIconRendered extends DefaultClusterRenderer<MarkerCustom> {

        public OwnIconRendered(Context context, GoogleMap map,
                               ClusterManager<MarkerCustom> clusterManager) {
            super(context, map, clusterManager);
        }

        @Override
        protected void onBeforeClusterItemRendered(MarkerCustom markerCustom, MarkerOptions markerOptions) {

            markerOptions.icon(markerCustom.getIcon());
            markerOptions.snippet(markerCustom.getDescription());
            markerOptions.title(markerCustom.getTitle());
            if(markerCustom.getId() != -1) {
                markerOptions.draggable(true);
            }
            super.onBeforeClusterItemRendered(markerCustom, markerOptions);
        }
    }
}