package br.com.pondionz.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import br.com.pondionz.R;

/**
 * Created by Iago on 18/03/2016.
 */
public class Imagem extends Activity {
    private static int img2=0;

    public Imagem(int img2){
        Imagem.img2 = img2;
    }
    public Imagem(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.imgem);
        ImageView img = (ImageView) findViewById(R.id.imageView2);
        img.setImageResource(img2);
    }
}
