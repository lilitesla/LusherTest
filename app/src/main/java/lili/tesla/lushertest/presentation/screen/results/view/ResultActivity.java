package lili.tesla.lushertest.presentation.screen.results.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.data.Test1;
import lili.tesla.lushertest.data.Test2;
import lili.tesla.lushertest.data.Test3;
import lili.tesla.lushertest.presentation.screen.base.BaseActivity;
import lili.tesla.lushertest.presentation.screen.description.view.DescriptionActivity;
import lili.tesla.lushertest.presentation.screen.results.presenter.ResultPresenter;

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
        mPresenter.showResults();
    }

    @Override
    public void showResult(String str) {
        mTextViewResults.setText(Html.fromHtml(str));
    }

    @Override
    public void showDescriptionScreen() {
        finish();
    }

    @OnClick (R.id.button_back_to_main)
    void onBackClick() {
        mPresenter.showDescriptionScreen();
    }
}
