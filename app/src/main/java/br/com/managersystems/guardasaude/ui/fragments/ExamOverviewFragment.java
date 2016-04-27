package br.com.managersystems.guardasaude.ui.fragments;


import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.exams.domain.Exam;
import br.com.managersystems.guardasaude.exams.mainmenu.examoverview.ExamAdapter;
import br.com.managersystems.guardasaude.exams.mainmenu.examoverview.ExamOverviewPresenter;
import br.com.managersystems.guardasaude.exams.mainmenu.examoverview.IExamOverview;
import br.com.managersystems.guardasaude.ui.activities.ExamTabActivity;
import br.com.managersystems.guardasaude.ui.dialogs.NewExamDialogFragment;
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
    private List<Exam> examList = Collections.emptyList();
    SearchView.OnQueryTextListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_examoverview, container, false);
        ButterKnife.bind(this, view);

        presenter = new ExamOverviewPresenter(this, sp);
        presenter.getExamList();

        adapter = new ExamAdapter(getActivity(), this.examList, this);

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)MenuItemCompat.getActionView(item);
        initiateSearchViewListener();
        searchView.setOnQueryTextListener(listener);
    }


    @OnClick(R.id.fab)
    public void getNewExam() {
        NewExamDialogFragment newExamDialogFragment = new NewExamDialogFragment();
        newExamDialogFragment.show(getActivity().getFragmentManager(), "dialog");
    }

    @Override
    public void onSuccess(ArrayList<Exam> exams) {
        this.examList = exams;
        adapter.addAllExams(this.examList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    @Override
    public void onFailure() {
        Toast.makeText(getContext(), "FAIL", Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToExamDetail(Exam exam) {
        Intent intent = new Intent(getContext(), ExamTabActivity.class);
        intent.putExtra("exam", exam);
        startActivity(intent);
    }

    @Override
    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sp = sharedPreferences;
    }

    @Override
    public void initiateSearchViewListener() {
        listener =  new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String query) {
                query = query.toLowerCase();

                final List<Exam> filteredList = new ArrayList<>();

                for (int i = 0; i < examList.size(); i++) {

                    final String patientName = examList.get(i).getPatient().toLowerCase();
                    final String examId = examList.get(i).getId().toString();
                    //TODO add clinicName
                    if (patientName.contains(query) || examId.contains(query)) {
                        filteredList.add(examList.get(i));
                    }
                }

                adapter.addAllExams(filteredList);
                adapter.notifyDataSetChanged();
                return true;

            }
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
        };

    }


}
