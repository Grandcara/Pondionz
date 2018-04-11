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

/**
 * Created by Iago on 09/02/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.pondionz.R;
import br.com.pondionz.control.StableArrayAdapterSpinner;
import br.com.pondionz.control.GMailSender;

public class MailSenderActivity extends Activity {
    private static String msg = "";
    private static int i = 0;
    public MailSenderActivity(String msg, int i){
        MailSenderActivity.msg =msg;
        MailSenderActivity.i =i;
    }
    public MailSenderActivity(){

    }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mailsend);
        Spinner sp = (Spinner) findViewById(R.id.spinnermailsend);
        final ArrayList<String> listStringSpinner = new ArrayList<String>();
        listStringSpinner.add("Elogio");
        listStringSpinner.add("Problemas");
        listStringSpinner.add("Sugestões");
        listStringSpinner.add("Outros");
        // Chama a o adapter do spinner para poder customizar.
        StableArrayAdapterSpinner adapter = new StableArrayAdapterSpinner(this, R.layout.spinner_rows, listStringSpinner);
        sp.setAdapter(adapter);
        sp.setSelection(i);
        final String[] tipo = new String[1];
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipo[0] = listStringSpinner.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final EditText edNome = (EditText) findViewById(R.id.mail_ednome);
        final EditText edEmail = (EditText) findViewById(R.id.mail_edmail);
        final EditText edMsg = (EditText) findViewById(R.id.body);
        final Button send = (Button) this.findViewById(R.id.sendEmail);
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    if(edMsg.getText().length() > 0){
                        try {
                            String vetor[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","1","2","3","4","5","z"};
                            GMailSender sender = new GMailSender();
                            sender.sendMail(tipo[0],
                                    String.valueOf(edNome.getText()+"\n"+edEmail.getText()+"\n"+msg+"\n"+edMsg.getText()),
                                    "pondionzi@gmail.com",
                                    "pondionzi@gmail.com");
                            Log.e("SendMail", "Enviado sucesso!");
                            Toast.makeText(getApplicationContext(),"Enviado, obrigado por compartilhar sua opinião!",Toast.LENGTH_LONG).show();
                            edMsg.setText("");
                        } catch (Exception e) {
                            Log.e("SendMail", e.getMessage(), e);
                            Toast.makeText(getApplicationContext(),"Ocorreu algum problema",Toast.LENGTH_LONG).show();
                        }
                    }else Toast.makeText(getApplicationContext(),"Deixe pelo menos alguma mensagem!",Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(),"É necessário estar conectado para concluir essa tarefa",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}