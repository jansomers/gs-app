package br.com.managersystems.guardasaude.exams.mainmenu.examoverview;

import java.util.ArrayList;

import br.com.managersystems.guardasaude.exams.domain.Exam;

public interface IExamOverview {
    void onClickFab();
    void onSuccess(ArrayList<Exam> exams);
    void onFailure();
}
