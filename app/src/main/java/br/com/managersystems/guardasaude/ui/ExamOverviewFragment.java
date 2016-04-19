package br.com.managersystems.guardasaude.ui;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.examoverview.IExamOverview;
import butterknife.ButterKnife;


public class ExamOverviewFragment extends Fragment implements IExamOverview {

    private FloatingActionButton fab;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_examoverview, container, false);
        ButterKnife.bind(this, view);

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

}
