package br.com.managersystems.guardasaude.examoverview;

import java.util.ArrayList;
import java.util.List;

import br.com.managersystems.guardasaude.examoverview.domain.Exam;

public interface IExamOverview {
    void onSuccess(ArrayList<Exam> exams);
    void onFailure();
}
