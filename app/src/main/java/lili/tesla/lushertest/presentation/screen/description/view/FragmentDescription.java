package lili.tesla.lushertest.presentation.screen.description.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lili.tesla.lushertest.R;
import lili.tesla.lushertest.presentation.application.App;

/**
 * Created by Лилия on 11.11.2017.
 */

public class FragmentDescription extends Fragment {

    private MyAdapter mAdapter;
    private ViewPager mPager;

    private static String KEY_POSITION = "POSITION";
    private int fPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);



        mAdapter = new MyAdapter(getChildFragmentManager());

        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        fPosition = 0;

        if (savedInstanceState != null) {
            fPosition = savedInstanceState.getInt(KEY_POSITION, 0);
        }

        mPager.setCurrentItem(fPosition); // выводим экран

        return view;
    }


}
