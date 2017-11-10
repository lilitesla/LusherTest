package lili.tesla.lushertest.presentation.screen.description.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lili.tesla.lushertest.R;

/**
 * Created by Лилия on 11.11.2017.
 */

public class Fragment1 extends Fragment {

    public static Fragment1 newInstance(int test) {
        Bundle bundle = new Bundle();
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        return view;
    }
}
