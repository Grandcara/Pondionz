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

package br.com.pondionz.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.pondionz.R;
import br.com.pondionz.control.StableArrayAdapterNewMarker;
import br.com.pondionz.model.PontoStatic;

/**
 * Created by Iago on 28/02/2016.
 */
public class NewMarker extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_marker_selection);
        createList();
    }

    private void createList() {
        final ListView listview = (ListView) findViewById(R.id.lvNewMarker);

        String[] values = new String[] {"Ônibus", "Moto Táxi", "Táxi"};
        StableArrayAdapterNewMarker adapter = new StableArrayAdapterNewMarker(this, values);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        // onibus
                        PontoStatic.getPontoStatic().setTipo(0);
                        Intent intent = new Intent(getApplicationContext(), NewMarkerBlue.class);

                        startActivity(intent);
                        break;
                    case 1:
                        //moto taxi
                        PontoStatic.getPontoStatic().setTipo(1);
                        Intent intent2 = new Intent(getApplicationContext(), NewMarkerRed.class);

                        startActivity(intent2);
                        break;
                    case 2:
                        //taxi
                        PontoStatic.getPontoStatic().setTipo(2);
                        Intent intent3 = new Intent(getApplicationContext(), NewMarkerGreen.class);

                        startActivity(intent3);
                        break;

                }
            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
