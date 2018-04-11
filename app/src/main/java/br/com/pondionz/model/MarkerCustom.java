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