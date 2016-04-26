package br.com.managersystems.guardasaude.exams.exammenu.information;

/**
 * Created by Jan on 26/04/2016.
 */
public class ExamInteractor implements  IExamInteractor {

    OnInformationRetrievedListener listener;

    public ExamInteractor(OnInformationRetrievedListener listener) {
        this.listener = listener;
    }

    @Override
    public void getExam() {

    }
}
