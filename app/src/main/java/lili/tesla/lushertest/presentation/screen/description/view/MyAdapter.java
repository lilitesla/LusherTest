package lili.tesla.lushertest.presentation.screen.description.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import lili.tesla.lushertest.presentation.application.App;

/**
 * Created by Лилия on 11.11.2017.
 */

public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                App.fragmentPosition = 0;
                return new Fragment1();
            case 1:
                App.fragmentPosition = 1;
                return new Fragment2();

            default:
                return null;
        }
    }

}
