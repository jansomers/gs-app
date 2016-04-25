package br.com.managersystems.guardasaude.examoverview;


import br.com.managersystems.guardasaude.examoverview.domain.ExamList;

public interface OnCallExamListFinishedListener {
    void onSuccess(ExamList examList);
    void onFailure();
}
