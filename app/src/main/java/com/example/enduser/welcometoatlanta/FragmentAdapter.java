package com.example.enduser.welcometoatlanta;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by EndUser on 8/4/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fragmentManager){
        super((fragmentManager));

    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new Restaurants();
        }
        else if(position ==1){
            return new MustVisitFragment();
        }
        else{
            return new ThingsToDoFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0 ){
            return "Restaurants";
        }
        else if(position ==1){
            return "Must See!";
        }
        else{
            return "Activities";
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
