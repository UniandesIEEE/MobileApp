package ramaieeeuniandes.ramaieeeuniandes.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ramaieeeuniandes.ramaieeeuniandes.fragments.EventsFragment;
import ramaieeeuniandes.ramaieeeuniandes.fragments.LeaderboardFragment;
import ramaieeeuniandes.ramaieeeuniandes.fragments.MyEventsFragment;

/**
 * Created by juanm on 26/07/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new EventsFragment();
        }
        else if (position == 1)
        {
            fragment = new MyEventsFragment();
        }
        else if (position == 2)
        {
            fragment = new LeaderboardFragment();
        }
        return fragment;
    }

    /**
     * Returns the number of tabs
     * @return number of tabls
     */
    @Override
    public int getCount() {
        return 3;
    }

    /**
     * Sets the tabs' titles
     * @param position position of tab
     * @return tab's name
     */
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "EVENTS";
        }
        else if (position == 1)
        {
            title = "MY EVENTS";
        }
        else if (position == 2)
        {
            title = "LEADERBOARD";
        }
        return title;
    }
}