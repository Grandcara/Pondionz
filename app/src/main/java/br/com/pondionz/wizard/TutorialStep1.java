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
public class TutorialStep1 extends WizardStep {

    //Wire the layout to the step
    public TutorialStep1() {
    }

    //Set your layout here
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.step_tutorial, container, false);
        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        img.setImageResource(R.mipmap.wizard0);
        return v;
    }
}