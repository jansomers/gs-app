package br.com.managersystems.guardasaude.exams.exammenu.information;

import android.content.Intent;

import br.com.managersystems.guardasaude.exams.domain.Exam;

/**
 * Created by Jan on 26/04/2016.
 */
public class ExamInteractor implements  IExamInteractor {

    OnInformationRetrievedListener listener;

    public ExamInteractor(OnInformationRetrievedListener listener) {
        this.listener = listener;
    }

    @Override
    public void getExam(Intent intent) {
        Exam exam =intent.getParcelableExtra("exam");
        if (exam.getId() != null) listener.onSucces(exam);
        else listener.onFailure();

    }
}
