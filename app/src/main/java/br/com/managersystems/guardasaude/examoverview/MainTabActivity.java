package br.com.managersystems.guardasaude.examoverview;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import br.com.managersystems.guardasaude.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainTabActivity extends FragmentActivity{

    @Bind(R.id.pager)
    ViewPager viewPager;

    private String[] tabtitles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);
        tabtitles= new String[]{(String) getResources().getText(R.string.Exams), (String) getResources().getText(R.string.Notifications), (String) getResources().getText(R.string.Messages)};
        viewPager.setAdapter(new TabsPagerAdapter(getSupportFragmentManager(), tabtitles));
    }




}
