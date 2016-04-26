package br.com.managersystems.guardasaude.exams.exammenu.information;

import br.com.managersystems.guardasaude.ui.fragments.InformationFragment;

/**
 * Created by Jan on 26/04/2016.
 */
public class ExamenInformationPresenter implements IExamInformationPresenter, OnInformationRetrievedListener {
    
    IExamInformationView informationFragment;
    ExamInteractor examInteractor;

    public ExamenInformationPresenter(InformationFragment informationFragment) {
        this.informationFragment = informationFragment;
        examInteractor = new ExamInteractor(this);
    }

    @Override
    public void retrieveInformation() {
        examInteractor.getExam();

    }
}
