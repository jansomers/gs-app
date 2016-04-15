package br.com.managersystems.guardasaude.examoverview;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

import br.com.managersystems.guardasaude.R;

public class NotificationFragment extends Fragment implements IMainTab{
    IMainTabPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        presenter = new MainTabPresenter(this);
        notificationsClicked();
        return view;
    }

    @Override
    public void notificationsClicked() {
        presenter.attemptFetchDummyData();
    }

    @Override
    public void dummyDataSucces(String[] dummyData) {
        for (String dum : dummyData) {
//           Toast.makeText(getContext(),dum,Toast.LENGTH_LONG).show();
        }
    }

}
