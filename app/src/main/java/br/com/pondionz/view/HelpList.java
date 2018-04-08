package br.com.pondionz.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.pondionz.control.StableArrayAdapterHelpList;
import br.com.pondionz.R;

/**
 * Created by Iago on 31/12/2015.
 */
//Aqui é seção (nos ajude) para os usuarios, esperamos que muitos nos ajudem!
public class HelpList extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helplist);
        createList();
    }

    private void createList() {
        final ListView listview = (ListView) findViewById(R.id.lvHelp);
        //doações foi retirada ate algum momento
        String[] values = new String[] {"Deixe seu Like no Facebook", "Avalie já na Google Play", "Deixe uma mensagem"};
        StableArrayAdapterHelpList adapter = new StableArrayAdapterHelpList(this, values);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        String url = "https://www.facebook.com/Pondionz-488581981330034/";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 1:
                        String url2 = "https://play.google.com/store/apps/details?id=br.com.pondionzi";
                        Intent i2 = new Intent(Intent.ACTION_VIEW);
                        i2.setData(Uri.parse(url2));
                        startActivity(i2);
                        break;
                    case 2:
                        new MailSenderActivity("",0);
                        Intent intent = new Intent(getApplicationContext(), MailSenderActivity.class);
                        startActivity(intent);
                        break;

                }
            }

        });
    }


}
