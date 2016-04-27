package br.com.managersystems.guardasaude.exams.mainmenu.examoverview;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import br.com.managersystems.guardasaude.exams.domain.Exam;

public class FilterCustomerSearch extends Filter {
    private final ExamAdapter examAdapter;
    List<Exam> examList;
    List<Exam> filteredExamList;

    public FilterCustomerSearch(ExamAdapter examAdapter, List<Exam> examList) {
        super();
        this.examAdapter = examAdapter;
        this.examList = new LinkedList<>(examList);
        this.filteredExamList = new ArrayList<>();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        filteredExamList.clear();
        final FilterResults results = new FilterResults();

        if (constraint.length() == 0) {
            filteredExamList.addAll(examList);
        } else {
            final String filterPattern = constraint.toString().toLowerCase().trim();

            for (final Exam exam : examList) {
                if (exam.getPatient().contains(filterPattern)) {
                    filteredExamList.add(exam);
                }
            }
        }
        results.values = filteredExamList;
        results.count = filteredExamList.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        examAdapter.examList.clear();
        examAdapter.examList.addAll((ArrayList<Exam>) results.values);
        examAdapter.notifyDataSetChanged();
    }
}
