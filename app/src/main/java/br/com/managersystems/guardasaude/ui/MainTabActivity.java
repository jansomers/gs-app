package br.com.managersystems.guardasaude.ui;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.mainmenu.TabsPagerAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainTabActivity extends AppCompatActivity {

    @Bind(R.id.pager)
    ViewPager viewPager;

    @Bind(R.id.toolbar)
    Toolbar toolbar;


    private String[] tabtitles;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        tabtitles = new String[]{(String) getResources().getText(R.string.Exams), (String) getResources().getText(R.string.Notifications), (String) getResources().getText(R.string.Messages)};
        viewPager.setAdapter(new TabsPagerAdapter(getSupportFragmentManager(), tabtitles));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

