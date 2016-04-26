package br.com.managersystems.guardasaude.exams.mainmenu.examoverview;


import java.util.ArrayList;

import br.com.managersystems.guardasaude.exams.domain.Exam;
import br.com.managersystems.guardasaude.exams.domain.ExamList;
import br.com.managersystems.guardasaude.ui.fragments.ExamOverviewFragment;

public class ExamOverviewPresenter implements IExamOverviewPresenter, OnCallExamListFinishedListener {
    ExamListInteractor examListInteractor;
    ExamOverviewFragment examOverview;


    public ExamOverviewPresenter(ExamOverviewFragment examOverview) {
        this.examOverview = examOverview;
        examListInteractor = new ExamListInteractor();
    }

    @Override
    public void getExamList() {
        examListInteractor.getExamList(this,"doctor","db55f27d4222c7919d15b4c04a5aa66c450d782945cacb31eff32a83c49c0640",null,null,null,null,null,"ROLE_HEALTH_PROFESSIONAL");
    }

    @Override
    public void onSuccess(ExamList examList) {
        ArrayList<Exam> exams = (ArrayList<Exam>) examList.getRows();
        examOverview.onSuccess(exams);
    }

    @Override
    public void onFailure() {
        examOverview.onFailure();
    }

}
