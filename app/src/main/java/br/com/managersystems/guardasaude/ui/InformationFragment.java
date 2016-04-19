package br.com.managersystems.guardasaude.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.managersystems.guardasaude.R;
import butterknife.ButterKnife;

public class InformationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_information, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
