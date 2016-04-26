package br.com.managersystems.guardasaude.ui.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.exams.mainmenu.examoverview.ExamAdapter;
import br.com.managersystems.guardasaude.exams.mainmenu.examoverview.ExamOverviewPresenter;
import br.com.managersystems.guardasaude.exams.mainmenu.examoverview.IExamOverview;
import br.com.managersystems.guardasaude.exams.domain.Exam;
import br.com.managersystems.guardasaude.ui.dialogs.NewExamDialogFragment;
import butterknife.ButterKnife;


public class ExamOverviewFragment extends Fragment implements IExamOverview {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private ExamOverviewPresenter presenter;
    private ExamAdapter adapter;
    private List<Exam> examList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_examoverview, container, false);
        ButterKnife.bind(this, view);

        presenter = new ExamOverviewPresenter(this);
        presenter.getExamList();

       /* recyclerView=(RecyclerView)view.findViewById(R.id.examOverviewList);
        adapter = new ExamAdapter(getActivity(),this.examList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));*/

        fab = (FloatingActionButton)view.findViewById(R.id.fab);
        onClickFab();
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onClickFab() {
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
        this.examList = new ArrayList<>(exams);
    }


    @Override
    public void onFailure() {
        Toast.makeText(getContext(),"FAIL",Toast.LENGTH_LONG).show();
    }

}
