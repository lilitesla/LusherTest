package lili.tesla.lushertest.table3.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.table2.view.Table2Activity;
import lili.tesla.lushertest.table3.presenter.Table3Presenter;
import lili.tesla.lushertest.base.BaseActivity;

public class Table3Activity extends BaseActivity implements Table3View, View.OnClickListener {

    private int[][] arrayTab3;
    private int testNum;
    private int clickCount;
    private boolean isSecondTry;

    public static void start(Context context) {
        Intent intent = new Intent(context, Table3Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private Table3Presenter mPresenter;

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

        arrayTab3 = new int[6][4];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                arrayTab3[i][j] = 0;
            }
        }

        isSecondTry = false;

        testNum = -1;
        addTestNumber();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.image0_table3: {
                arrayTab3[testNum][0] ++;
                break;
            }
            case R.id.image1_table3: {
                arrayTab3[testNum][1] ++;
                break;
            }
            case R.id.image2_table3: {
                arrayTab3[testNum][2] ++;
                break;
            }
            case R.id.image3_table3: {
                arrayTab3[testNum][3] ++;
                break;
            }            
        }

        onClickAction();
    }

    private void calcResultSums(){
        for (int i = 0; i < 4; i ++) {
            arrayTab3[5][i] = 0;
            for (int j = 0; j < 5; j ++) {
                arrayTab3[5][i] = arrayTab3[5][i] + arrayTab3[j][i];
            }
        }
    }

    private void onClickAction(){

        clickCount ++;

        if (clickCount <  6 ){
            mPresenter.setImagesVisible( clickCount );

        } else {
            if (isSecondTry || isRightTest()) {
                isSecondTry = false;
                if (testNum < 4) {
                    addTestNumber();
                } else {
                    calcResultSums();
                    // TODO: 05.11.2017 Сохранение
                    mPresenter.showTable2Activity();
                }
            } else {
                testNum --;
                isSecondTry = true;
                addTestNumber();
            }
        }

    }

    private void addTestNumber() {        
        testNum ++;
        clickCount = 0;
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
                mImage1Tab3.setVisibility(View.VISIBLE);
                break;
            }
            case 1: {
                mImage0Tab3.setVisibility(View.VISIBLE);
                mImage2Tab3.setVisibility(View.VISIBLE);
                break;
            }
            case 2: {
                mImage0Tab3.setVisibility(View.VISIBLE);
                mImage3Tab3.setVisibility(View.VISIBLE);
                break;
            }
            case 3: {
                mImage1Tab3.setVisibility(View.VISIBLE);
                mImage2Tab3.setVisibility(View.VISIBLE);
                break;
            }
            case 4: {
                mImage1Tab3.setVisibility(View.VISIBLE);
                mImage3Tab3.setVisibility(View.VISIBLE);
                break;
            }
            case 5: {
                mImage2Tab3.setVisibility(View.VISIBLE);
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
            switch (arrayTab3[testNum][i]) {
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



}
