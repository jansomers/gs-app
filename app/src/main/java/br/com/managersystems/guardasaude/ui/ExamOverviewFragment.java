package br.com.managersystems.guardasaude.ui;


import android.app.DialogFragment;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


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
        return view;
    }



    @Override
    public void onClickFab() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewExamDialogFragment newExamDialogFragment = new NewExamDialogFragment();
                newExamDialogFragment.show(getActivity().getFragmentManager(),"dialog");
            }
        });
    }


}
