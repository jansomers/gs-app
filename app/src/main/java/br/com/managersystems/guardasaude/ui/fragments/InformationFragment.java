package br.com.managersystems.guardasaude.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.exams.exammenu.information.ExamenInformationPresenter;
import br.com.managersystems.guardasaude.exams.exammenu.information.IExamInformationView;
import butterknife.ButterKnife;

public class InformationFragment extends Fragment implements IExamInformationView {

    ExamenInformationPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_information, container, false);
        ButterKnife.bind(this, view);
        presenter = new ExamenInformationPresenter(this);
        init();
        return view;
    }

    private void init() {
        presenter.retrieveInformation();
    }

    @Override
    public void showInformation() {

    }

    @Override
    public void showComments() {

    }

    @Override
    public void hideComments() {

    }

    @Override
    public void navigateToImages() {

    }
}
