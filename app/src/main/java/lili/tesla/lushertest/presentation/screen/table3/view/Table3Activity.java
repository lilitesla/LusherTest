package lili.tesla.lushertest.presentation.screen.table3.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.presentation.application.App;
import lili.tesla.lushertest.presentation.screen.table2.view.Table2Activity;
import lili.tesla.lushertest.presentation.screen.table3.presenter.Table3Presenter;
import lili.tesla.lushertest.presentation.screen.base.BaseActivity;

public class Table3Activity extends BaseActivity implements Table3View, View.OnClickListener {

    public static final String KEY_CLICK_COUNT_TAB3 = "CLICK_COUNT_TAB3";
    public static final String KEY_TEST_NUM_TAB3 = "TEST_NUM_TAB3";
    public static final String KEY_IS_SECOND_TRY = "IS_SECOND_TRY";
    public static final String KEY_IS_WAS_SECOND_TRY = "IS_WAS_SECOND_TRY";




    public static void start(Context context) {
        Intent intent = new Intent(context, Table3Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private Table3Presenter mPresenter;
    private int testNum;
    private int clickCount;
    private boolean isSecondTry;
    private boolean isWasSecondTry;

    @BindView(R.id.image0_table3) ImageView mImage0Tab3;
    @BindView(R.id.image1_table3) ImageView mImage1Tab3;
    @BindView(R.id.image2_table3) ImageView mImage2Tab3;
    @BindView(R.id.image3_table3) ImageView mImage3Tab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table3);

        ButterKnife.bind(this);
        mPresenter = new Table3Presenter();
        mPresenter.setView(this);

        mImage0Tab3.setOnClickListener(this);
        mImage1Tab3.setOnClickListener(this);
        mImage2Tab3.setOnClickListener(this);
        mImage3Tab3.setOnClickListener(this);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                App.arrayTab3[i][j] = 0;
            }
        }

        isSecondTry = false;
        isWasSecondTry = false;
        testNum = 0;
        clickCount = 0;

        if (savedInstanceState != null) {
            clickCount = savedInstanceState.getInt(KEY_CLICK_COUNT_TAB3, 0);
            testNum = savedInstanceState.getInt(KEY_TEST_NUM_TAB3, -1);
            isSecondTry = savedInstanceState.getBoolean(KEY_IS_SECOND_TRY, false);
            isWasSecondTry = savedInstanceState.getBoolean(KEY_IS_WAS_SECOND_TRY, false);
        }

        testNum --;
        addTestNumber();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.image0_table3: {
                App.arrayTab3[testNum][0] ++;
                break;
            }
            case R.id.image1_table3: {
                App.arrayTab3[testNum][1] ++;
                break;
            }
            case R.id.image2_table3: {
                App.arrayTab3[testNum][2] ++;
                break;
            }
            case R.id.image3_table3: {
                App.arrayTab3[testNum][3] ++;
                break;
            }            
        }

        onClickAction();
    }

    private void onClickAction(){

        clickCount ++;

        if (clickCount <  6 ) {
            mPresenter.setImagesVisible(clickCount);

        } else {
            if (!isSecondTry) {
                if (testNum < 4) {
                    addTestNumber();
                } else {
                    isSecondTry = true;
                    testNum = 0;
                }
            }
            if (isSecondTry) {
                while ((testNum < 5)&&(isRightTest()||isWasSecondTry)) {
                    isWasSecondTry = false;
                    testNum ++;
                }
                if (testNum < 5) {
                    testNum --;
                    isWasSecondTry = true;
                    addTestNumber();

                } else {
                    mPresenter.showTable2Activity();
                    finish();
                }
            }
        }

    }

    private void addTestNumber() {        
        testNum ++;
        if (clickCount == 6) {
            clickCount = 0;
        }
        for (int i = 0; i < 4; i ++) {
            App.arrayTab3[testNum][i] = 0;
        }
        mPresenter.setImagesColors(testNum);
        mPresenter.setImagesVisible(clickCount);
    } 

    @Override
    public void setImagesColors(int testColorNum) {
        switch (testColorNum) {
            case 0: {
                mImage0Tab3.setBackgroundResource(R.color.darkBlue);
                mImage1Tab3.setBackgroundResource(R.color.teal);
                mImage2Tab3.setBackgroundResource(R.color.redYellow);
                mImage3Tab3.setBackgroundResource(R.color.yellowRed);
                break;
            }
            case 1: {
                mImage0Tab3.setBackgroundResource(R.color.darkBlue);
                mImage1Tab3.setBackgroundResource(R.color.teal);
                mImage2Tab3.setBackgroundResource(R.color.purple);
                mImage3Tab3.setBackgroundResource(R.color.cyan);
                break;
            }
            case 2: {
                mImage0Tab3.setBackgroundResource(R.color.brownGreen);
                mImage1Tab3.setBackgroundResource(R.color.teal);
                mImage2Tab3.setBackgroundResource(R.color.green);
                mImage3Tab3.setBackgroundResource(R.color.yellowGreen);
                break;
            }
            case 3: {
                mImage0Tab3.setBackgroundResource(R.color.brown);
                mImage1Tab3.setBackgroundResource(R.color.redBrown);
                mImage2Tab3.setBackgroundResource(R.color.redYellow);
                mImage3Tab3.setBackgroundResource(R.color.orange);
                break;
            }
            case 4: {
                mImage0Tab3.setBackgroundResource(R.color.lightBrown);
                mImage1Tab3.setBackgroundResource(R.color.greenYellow);
                mImage2Tab3.setBackgroundResource(R.color.redOrange);
                mImage3Tab3.setBackgroundResource(R.color.yellowRed);
                break;
            }
        }
    }

    @Override
    public void showTable2Screen() {
        Table2Activity.start(this, 1);
    }

    @Override
    public void setImagesVisible(int testVisibleNum) {
        mImage0Tab3.setVisibility(View.GONE);
        mImage1Tab3.setVisibility(View.GONE);
        mImage2Tab3.setVisibility(View.GONE);
        mImage3Tab3.setVisibility(View.GONE);

        switch (testVisibleNum) {
            case 0: {
                mImage0Tab3.setVisibility(View.VISIBLE);
                mImage3Tab3.setVisibility(View.VISIBLE);
                break;
            }
            case 1: {
                mImage1Tab3.setVisibility(View.VISIBLE);
                mImage2Tab3.setVisibility(View.VISIBLE);
                break;
            }
            case 2: {
                mImage0Tab3.setVisibility(View.VISIBLE);
                mImage1Tab3.setVisibility(View.VISIBLE);
                break;
            }
            case 3: {
                mImage3Tab3.setVisibility(View.VISIBLE);
                mImage2Tab3.setVisibility(View.VISIBLE);
                break;
            }
            case 4: {
                mImage0Tab3.setVisibility(View.VISIBLE);
                mImage2Tab3.setVisibility(View.VISIBLE);
                break;
            }
            case 5: {
                mImage1Tab3.setVisibility(View.VISIBLE);
                mImage3Tab3.setVisibility(View.VISIBLE);
                break;
            }
        }
    }

    private boolean isRightTest(){

        int countsIsZero = 0;
        int countsIsOne = 0;
        int countsIsTwo = 0;
        int countsIsThree = 0;

        for (int i = 0; i < 4; i ++) {
            switch (App.arrayTab3[testNum][i]) {
                case 0:
                    countsIsZero ++;
                    break;
                case 1:
                    countsIsOne ++;
                    break;
                case 2:
                    countsIsTwo ++;
                    break;
                case 3:
                    countsIsThree ++;
            }
        }

        if ((countsIsZero > 1)||(countsIsOne > 1) ||(countsIsTwo > 1) ||(countsIsThree > 1)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CLICK_COUNT_TAB3, clickCount);
        outState.putInt(KEY_TEST_NUM_TAB3, testNum);
        outState.putBoolean(KEY_IS_SECOND_TRY, isSecondTry);
        outState.putBoolean(KEY_IS_WAS_SECOND_TRY, isWasSecondTry);
    }



}
