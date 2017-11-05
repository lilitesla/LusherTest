package lili.tesla.lushertest.screen.description.view;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.screen.base.BaseActivity;
import lili.tesla.lushertest.screen.description.presenter.DescriptionPresenter;
import lili.tesla.lushertest.screen.table1.view.Table1Activity;

public class DescriptionActivity extends BaseActivity implements DescriptionView {

    private DescriptionPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ButterKnife.bind(this);
        mPresenter = new DescriptionPresenter();
        mPresenter.setView(this);
    }

    @OnClick(R.id.button_start_test)
    void startClicked() {mPresenter.startTable1Screen();}


    @Override
    public void startTable1Screen() {
        Table1Activity.start(this);
    }
}