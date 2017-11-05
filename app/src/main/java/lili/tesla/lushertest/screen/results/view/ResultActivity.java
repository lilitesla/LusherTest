package lili.tesla.lushertest.screen.results.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.application.App;
import lili.tesla.lushertest.screen.base.BaseActivity;
import lili.tesla.lushertest.screen.results.presenter.ResultPresenter;

public class ResultActivity extends BaseActivity implements ResultView {

    public static void start(Context context) {
        Intent intent = new Intent(context, ResultActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private ResultPresenter mPresenter;

    @BindView(R.id.textview_results) TextView mTextViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        mPresenter = new ResultPresenter();
        mPresenter.setView(this);


    }
}
