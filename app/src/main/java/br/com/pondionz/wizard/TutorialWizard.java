package br.com.pondionz.wizard;

import org.codepond.wizardroid.WizardFlow;
import org.codepond.wizardroid.layouts.BasicWizardLayout;

/**
 * Created by Iago on 19/02/2016.
 */
public class TutorialWizard extends BasicWizardLayout {

    /**
     * Note that initially BasicWizardLayout inherits from {@link android.support.v4.app.Fragment} and therefore you must have an empty constructor
     */
    public TutorialWizard() {
        super();
    }

    //You must override this method and create a wizard flow by
    //using WizardFlow.Builder as shown in this example
    @Override
    public WizardFlow onSetup() {
        /* Optionally, you can set different labels for the control buttons */
        this.setNextButtonText("Próximo");
        this.setBackButtonText("Voltar");
        this.setFinishButtonText("Finalizar");
        return new WizardFlow.Builder()
                .addStep(TutorialStep1.class)           //Add your steps in the order you want them
                .addStep(TutorialStep2.class)           //to appear and eventually call create()
                .addStep(TutorialStep3.class)           //to appear and eventually call create()
                .addStep(TutorialStep4.class)           //to appear and eventually call create()
                .addStep(TutorialStep5.class)           //to appear and eventually call create()
                .create();                              //to create the wizard flow.
    }
    @Override
    public void onWizardComplete() {
        super.onWizardComplete();   //Make sure to first call the super method before anything else
        //... Access context variables here before terminating the wizard
        //...
        //String fullname = firstname + lastname;
        //Store the data in the DB or pass it back to the calling activity
        getActivity().finish();     //Terminate the wizard
    }
}