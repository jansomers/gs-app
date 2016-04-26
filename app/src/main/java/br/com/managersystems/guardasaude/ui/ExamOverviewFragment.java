package br.com.managersystems.guardasaude.ui;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.examoverview.ExamAdapter;
import br.com.managersystems.guardasaude.examoverview.ExamOverviewPresenter;
import br.com.managersystems.guardasaude.examoverview.IExamOverview;
import br.com.managersystems.guardasaude.examoverview.domain.Exam;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ExamOverviewFragment extends Fragment implements IExamOverview {

    @Bind(R.id.examOverviewList)
    RecyclerView recyclerView;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    private ExamOverviewPresenter presenter;
    private ExamAdapter adapter;
    private SharedPreferences sp;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_examoverview, container, false);
        ButterKnife.bind(this,view);

        presenter = new ExamOverviewPresenter(this,sp);
        presenter.getExamList();

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @OnClick(R.id.fab)
    public void getNewExam() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewExamDialogFragment newExamDialogFragment = new NewExamDialogFragment();
                newExamDialogFragment.show(getActivity().getFragmentManager(), "dialog");
            }
        });
    }

    @Override
    public void onSuccess(ArrayList<Exam> exams) {
        adapter = new ExamAdapter(getActivity(),exams);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    @Override
    public void onFailure() {
        Toast.makeText(getContext(),"FAIL",Toast.LENGTH_LONG).show();
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sp = sharedPreferences;
    }
}
