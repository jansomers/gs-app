package br.com.managersystems.guardasaude.examoverview;


import android.content.SharedPreferences;

import java.util.ArrayList;

import br.com.managersystems.guardasaude.examoverview.domain.Exam;
import br.com.managersystems.guardasaude.examoverview.domain.ExamList;
import br.com.managersystems.guardasaude.ui.ExamOverviewFragment;

public class ExamOverviewPresenter implements IExamOverviewPresenter, OnCallExamListFinishedListener {
    ExamListInteractor examListInteractor;
    ExamOverviewFragment examOverview;
    SharedPreferences sp;


    public ExamOverviewPresenter(ExamOverviewFragment examOverview,SharedPreferences sharedPreferences) {
        this.examOverview = examOverview;
        this.sp = sharedPreferences;
        examListInteractor = new ExamListInteractor();
    }

    @Override
    public void getExamList() {
        String user= sp.getString("user",null);
        String token = sp.getString("token",null);
        String role = sp.getString("role",null);
        examListInteractor.getExamList(this,user,token,null,null,null,null,null,role);
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
