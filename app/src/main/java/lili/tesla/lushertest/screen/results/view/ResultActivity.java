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
    private String[][] arrayTab2_results;
    private int colExclamation;  //количество восклицательных знаков

    @BindView(R.id.textview_results) TextView mTextViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        mPresenter = new ResultPresenter();
        mPresenter.setView(this);

        arrayTab2_results = new String[3][8];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 8; j++) {
              arrayTab2_results[i][j] = "";
            }

        calcResultTab2();
    }

    private void calcResultTab2() {
        arrayTab2_results[0][0] = "+";
        arrayTab2_results[0][1] = "+";
        arrayTab2_results[0][2] = "x";
        arrayTab2_results[0][3] = "x";
        arrayTab2_results[0][4] = "=";
        arrayTab2_results[0][5] = "=";
        arrayTab2_results[0][6] = "-";
        arrayTab2_results[0][7] = "-";

        if ((App.arrayTab2_2[0] == 0) || (App.arrayTab2_2[0] > 5)) {
            arrayTab2_results[1][0] = "C";
            arrayTab2_results[2][0] = "!!!";
        }

        if ((App.arrayTab2_2[1] == 0) || (App.arrayTab2_2[1] > 5)) {
            arrayTab2_results[1][1] = "C";
            arrayTab2_results[2][1] = "!!";
        }

        if ((App.arrayTab2_2[2] == 0) || (App.arrayTab2_2[2] > 5)) {
            arrayTab2_results[1][2] = "C";
            arrayTab2_results[2][2] = "!";
        }

        boolean flag = false;

        if ((App.arrayTab2_2[5] > 0) && (App.arrayTab2_2[5] < 5)) {
            arrayTab2_results[1][5] = "A";
            arrayTab2_results[1][6] = "A";
            arrayTab2_results[1][7] = "A";
            arrayTab2_results[2][5] = "!";
            flag = true;
        }

        if ((App.arrayTab2_2[6] > 0) && (App.arrayTab2_2[6] < 5)) {
            arrayTab2_results[1][6] = "A";
            arrayTab2_results[1][7] = "A";
            arrayTab2_results[2][6] = "!!";
            flag = true;
        }

        if ((App.arrayTab2_2[7] > 0) && (App.arrayTab2_2[7] < 5)) {
            arrayTab2_results[1][7] = "A";
            arrayTab2_results[2][7] = "!!!";
            flag = true;
        }

        if (flag) {
            arrayTab2_results[1][0] = "C";
        }

        colExclamation = 0;
        for (int i = 0; i < 8; i ++) {
            colExclamation += arrayTab2_results[2][i].length();
        }

    }
}
