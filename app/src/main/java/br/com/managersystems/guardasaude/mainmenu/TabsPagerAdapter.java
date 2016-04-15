package br.com.managersystems.guardasaude.mainmenu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.managersystems.guardasaude.ui.ExamOverviewFragment;
import br.com.managersystems.guardasaude.ui.MessagesFragment;
import br.com.managersystems.guardasaude.ui.NotificationFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter{

    final int PAGE_COUNT = 3;
    private String tabtitles[];

    public TabsPagerAdapter(FragmentManager fm, String[] tabtitles) {
        super(fm);
        this.tabtitles = tabtitles;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                ExamOverviewFragment examOverviewFragment = new ExamOverviewFragment();
                return examOverviewFragment;

            case 1:
                NotificationFragment notificationFragment = new NotificationFragment();
                return notificationFragment;

            case 2:
                MessagesFragment messagesFragment = new MessagesFragment();
                return messagesFragment;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}
