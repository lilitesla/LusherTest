package lili.tesla.lushertest.presentation.screen.results.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.presentation.application.App;
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

        arrayTab2_results = new String[4][8];

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 8; j++) {
              arrayTab2_results[i][j] = "";
            }

        calcResultTab2();
    }

    private void calcResultTab2() {
        arrayTab2_results[0][0] = arrayTab2_results[0][1] = "+";
        arrayTab2_results[0][2] = arrayTab2_results[0][3] = "x";
        arrayTab2_results[0][4] = arrayTab2_results[0][5] = "=";
        arrayTab2_results[0][6] = arrayTab2_results[0][7] = "-";

        arrayTab2_results[3][0] = "+";
        arrayTab2_results[3][7] = "-";

        // если неосновные цвета расположены на первых трех позициях, обозначаем их и любой цвет перед ними C
        // неосновному цвету на 1 позиции ставим !!!, на 2 - !!, на 1 - !

        if ((App.arrayTab2_2[2] == 0) || (App.arrayTab2_2[2] > 5)) {
            arrayTab2_results[1][2] = "C";
            arrayTab2_results[3][2] = "+";

            arrayTab2_results[1][1] = "C";
            arrayTab2_results[3][1] = "+";

            arrayTab2_results[2][2] = "!";
        }

        if ((App.arrayTab2_2[1] == 0) || (App.arrayTab2_2[1] > 5)) {
            arrayTab2_results[1][1] = "C";
            arrayTab2_results[3][1] = "+";

            arrayTab2_results[1][0] = "C";
            arrayTab2_results[3][0] = "+";

            arrayTab2_results[2][1] = "!!";
        }

        if ((App.arrayTab2_2[0] == 0) || (App.arrayTab2_2[0] > 5)) {
            arrayTab2_results[1][0] = "C";
            arrayTab2_results[3][0] = "+";

            arrayTab2_results[2][0] = "!!!";
        }

        // если есть хотя бы один C - последний цвет в ряду обозначаем А
        if ((arrayTab2_results[1][0] != "")||(arrayTab2_results[1][1] != "")||(arrayTab2_results[1][2] != "")) {
            arrayTab2_results[1][7] = "A";
        }

        // если основные цвета расположены на последних 3 позициях, обозначаем их и любой цвет после них А
        // основному цвету на 8 позиции ставим !!!, на 7 - !!, на 6 - !
        if ((App.arrayTab2_2[5] > 0) && (App.arrayTab2_2[5] < 5)) {
            arrayTab2_results[1][5] = "A";
            arrayTab2_results[3][5] = "-";

            arrayTab2_results[1][6] = "A";
            arrayTab2_results[3][6] = "-";

            arrayTab2_results[1][7] = "A";
            arrayTab2_results[3][7] = "-";

            arrayTab2_results[2][5] = "!";
        }

        if ((App.arrayTab2_2[6] > 0) && (App.arrayTab2_2[6] < 5)) {
            arrayTab2_results[1][6] = "A";
            arrayTab2_results[3][6] = "-";

            arrayTab2_results[1][7] = "A";
            arrayTab2_results[3][7] = "-";

            arrayTab2_results[2][6] = "!!";
        }

        if ((App.arrayTab2_2[7] > 0) && (App.arrayTab2_2[7] < 5)) {
            arrayTab2_results[1][7] = "A";
            arrayTab2_results[3][7] = "-";

            arrayTab2_results[2][7] = "!!!";
        }

        // если есть хотя бы один А - первый цвет в ряду обозначаем С
        if ((arrayTab2_results[1][7] != "")||(arrayTab2_results[1][6] != "")||(arrayTab2_results[1][5] != "")) {
            arrayTab2_results[1][0] = "C";
        }

        colExclamation = 0;
        for (int i = 0; i < 8; i ++) {
            colExclamation += arrayTab2_results[2][i].length();
        }

        mPresenter.showPositiveNegativeResult(
                App.arrayTab1[0] + "" + App.arrayTab1[1] + "" + App.arrayTab1[2],
                App.arrayTab2_2[0] + "" + App.arrayTab2_2[1],
                App.arrayTab2_2[2] + "" + App.arrayTab2_2[3],
                App.arrayTab2_2[4] + "" + App.arrayTab2_2[5],
                App.arrayTab2_2[6] + "" + App.arrayTab2_2[7],
                App.arrayTab2_2[0] + "" + App.arrayTab2_2[7],
                colExclamation,
                App.arrayTab3[0][0] + "" + App.arrayTab3[0][1] + "" + App.arrayTab3[0][2] + "" + App.arrayTab3[0][3],
                App.arrayTab3[1][0] + "" + App.arrayTab3[1][1] + "" + App.arrayTab3[1][2] + "" + App.arrayTab3[1][3],
                App.arrayTab3[2][0] + "" + App.arrayTab3[2][1] + "" + App.arrayTab3[2][2] + "" + App.arrayTab3[2][3],
                App.arrayTab3[3][0] + "" + App.arrayTab3[3][1] + "" + App.arrayTab3[3][2] + "" + App.arrayTab3[3][3],
                App.arrayTab3[4][0] + "" + App.arrayTab3[4][1] + "" + App.arrayTab3[4][2] + "" + App.arrayTab3[4][3]);

    }

    @Override
    public void showResult(String achromaticResult, String positiveResult, String xResult, String neitralResult,
                           String negativeResult, String posNegResult, String colExclamation,
                           String mainColorResult, String blueColorResult, String greenColorResult,
                           String redColorResult, String yellowColorResult) {
        mTextViewResults.setText(Html.fromHtml(
                achromaticResult + "\n\n" +
                positiveResult + "\n\n" +
                xResult + "\n\n" +
                neitralResult + "\n\n" +
                negativeResult + "\n\n" +
                posNegResult + "\n\n" +
                colExclamation + "\n\n" +
                mainColorResult + "\n\n" +
                blueColorResult + "\n\n" +
                greenColorResult + "\n\n" +
                redColorResult + "\n\n" +
                yellowColorResult)
        );
    }
}
