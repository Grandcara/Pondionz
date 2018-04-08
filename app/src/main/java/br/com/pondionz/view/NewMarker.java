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
