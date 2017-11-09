package lili.tesla.lushertest.presentation.screen.results.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.data.Test1;
import lili.tesla.lushertest.data.Test2;
import lili.tesla.lushertest.data.Test3;
import lili.tesla.lushertest.presentation.screen.base.BaseActivity;
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

        mPresenter.calcResultTab2();
        mPresenter.calcResultTab3();
        mPresenter.showPositiveNegativeResult();
    }

    @Override
    public void showResult(Test1 test1, Test2 test2, Test3 test3) {
        mTextViewResults.setText(Html.fromHtml(
                test1.getResultText() + test3.getColorsResultText() + test2.getResultText() + test3.getCoubResultText() + test2.getExlamation())
        );
    }
}
