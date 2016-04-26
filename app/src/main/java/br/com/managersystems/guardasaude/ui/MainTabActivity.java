package br.com.managersystems.guardasaude.ui;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

    private final String MY_PREFS_NAME="MyPrefs";
    private SharedPreferences sp;
    private String[] tabtitles;
    SharedPreferences.Editor editor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        setSupportActionBar(toolbar);
        tabtitles = new String[]{(String) getResources().getText(R.string.Exams), (String) getResources().getText(R.string.Notifications), (String) getResources().getText(R.string.Messages)};
        viewPager.setAdapter(new TabsPagerAdapter(getSupportFragmentManager(), tabtitles,sp));
        getSharedPref();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //g etMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void getSharedPref() {
        sp = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
        String user= sp.getString("user",null);
        editor = sp.edit();
        editor.putString("role", getIntent().getStringExtra("role"));
        editor.commit();
    }
}

