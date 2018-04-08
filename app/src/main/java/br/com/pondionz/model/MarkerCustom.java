package br.com.pondionz.model;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

import br.com.pondionz.R;

/**
 * Created by Iago on 30/12/2015.
 */
//Myitem(mal nome) é o modelo dos pontos de onibus marcados no mapa
public class MarkerCustom implements ClusterItem {
    private final LatLng mPosition;
    private String title, description;
    private int tipo,id;

    public int getId() {
        return id;
    }

    public MarkerCustom(int id, double lat, double lng, String title, String description, int tipo) {
        mPosition = new LatLng(lat, lng);
        this.title = title;
        this.description = description;
        this.tipo = tipo;
        this.id = id;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    public BitmapDescriptor getIcon(){
        if(tipo == 0)
            return BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_marker);
        else if(tipo == 1)
            return BitmapDescriptorFactory.fromResource(R.mipmap.ic_moto_taxi);
        else if(tipo == 2)
            return BitmapDescriptorFactory.fromResource(R.mipmap.ic_taxi);
        return null;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }


}