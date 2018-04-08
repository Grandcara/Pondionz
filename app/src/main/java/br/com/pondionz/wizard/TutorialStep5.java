package br.com.pondionz.wizard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.codepond.wizardroid.WizardStep;

import br.com.pondionz.R;

/**
 * Created by Iago on 19/02/2016.
 */
public class TutorialStep5 extends WizardStep {

    //You must have an empty constructor for every step
    public TutorialStep5() {
    }

    //Set your layout here
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.step_tutorial, container, false);
        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        img.setImageResource(R.mipmap.wizard4);
        return v;
    }
}