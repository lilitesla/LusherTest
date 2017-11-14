package lili.tesla.lushertest.presentation.screen.description.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.presentation.screen.base.BaseActivity;
import lili.tesla.lushertest.presentation.screen.description.presenter.DescriptionPresenter;
import lili.tesla.lushertest.presentation.screen.table1.view.Table1Activity;

public class DescriptionActivity extends BaseActivity implements DescriptionView {

    private DescriptionPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ButterKnife.bind(this);
        mPresenter = new DescriptionPresenter();
        mPresenter.setView(this);

        showFragment(new FragmentDescription());
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(fragment.getClass() == Fragment.class) {
            transaction.add(R.id.container, fragment);
            transaction.addToBackStack("tag");
        } else {
            transaction.replace(R.id.container, fragment);
        }
        transaction.commit();
    }

    @OnClick(R.id.button_start_test)
    void startClicked() {mPresenter.startTable1Screen();}


    @Override
    public void startTable1Screen() {
        Table1Activity.start(this);
    }
}
