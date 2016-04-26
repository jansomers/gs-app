package br.com.managersystems.guardasaude.examoverview;


import java.util.ArrayList;
import java.util.List;

import br.com.managersystems.guardasaude.examoverview.domain.Exam;
import br.com.managersystems.guardasaude.examoverview.domain.ExamList;
import br.com.managersystems.guardasaude.ui.ExamOverviewFragment;

public class ExamOverviewPresenter implements IExamOverviewPresenter, OnCallExamListFinishedListener {
    ExamListInteractor examListInteractor;
    ExamOverviewFragment examOverview;

    public ExamOverviewPresenter(ExamOverviewFragment examOverview) {
        this.examOverview = examOverview;
        examListInteractor = new ExamListInteractor();
    }

    @Override
    public void getExamList() {
        examListInteractor.getExamList(this,"doctor","acf92b98ead7e4874f54b80b14981dba1da3956dd428bd93e41e140c640edd5d",null,null,null,null,null,"ROLE_HEALTH_PROFESSIONAL");
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
