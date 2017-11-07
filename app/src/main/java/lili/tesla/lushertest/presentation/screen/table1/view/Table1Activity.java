package lili.tesla.lushertest.presentation.screen.table1.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.presentation.application.App;
import lili.tesla.lushertest.presentation.screen.base.BaseActivity;
import lili.tesla.lushertest.presentation.screen.table1.presenter.Table1Presenter;
import lili.tesla.lushertest.presentation.screen.table2.view.Table2Activity;

public class Table1Activity extends BaseActivity implements Table1View, View.OnClickListener {

    private static final String KEY_CLICK_COUNT_TAB1 = "CLICK_COUNT_TAB1";
    private static final String KEY_SUM_NUM_TAB1 = "SUM_NUM_TAB1";

    public static void start(Context context ) {
        Intent intent = new Intent(context, Table1Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private Table1Presenter mPresenter;
    private int clickCount;
    private int sumNum;

    @BindView(R.id.image0_table1) ImageView mImage0Tab1;
    @BindView(R.id.image1_table1) ImageView mImage1Tab1;
    @BindView(R.id.image2_table1) ImageView mImage2Tab1;
    @BindView(R.id.image3_table1) ImageView mImage3Tab1;
    @BindView(R.id.image4_table1) ImageView mImage4Tab1;

    @BindView(R.id.textViewTable1_description) TextView mTextTab1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table1);

        ButterKnife.bind(this);
        mPresenter = new Table1Presenter();
        mPresenter.setView(this);
        mPresenter.setImagesColors();

        mImage0Tab1.setOnClickListener(this);
        mImage1Tab1.setOnClickListener(this);
        mImage2Tab1.setOnClickListener(this);
        mImage3Tab1.setOnClickListener(this);
        mImage4Tab1.setOnClickListener(this);

        clickCount = 0;
        sumNum = 10;

        if (savedInstanceState != null) {
            clickCount = savedInstanceState.getInt(KEY_CLICK_COUNT_TAB1, 0);
            sumNum = savedInstanceState.getInt(KEY_SUM_NUM_TAB1, 10);
        }
    }

    @Override
    public void setImagesColors() {
        mImage0Tab1.setBackgroundResource(R.color.gray);
        mImage1Tab1.setBackgroundResource(R.color.darkGray);
        mImage2Tab1.setBackgroundResource(R.color.black);
        mImage3Tab1.setBackgroundResource(R.color.lightGray);
        mImage4Tab1.setBackgroundResource(R.drawable.borders);
    }

    @Override
    public void showTable2Screen() {
        Table2Activity.start(this, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image0_table1: {
                mImage0Tab1.setVisibility(View.INVISIBLE);
                onClickAction(0);
                break;
            }
            case R.id.image1_table1: {
                mImage1Tab1.setVisibility(View.INVISIBLE);
                onClickAction(1);
                break;
            }
            case R.id.image2_table1: {
                mImage2Tab1.setVisibility(View.INVISIBLE);
                onClickAction(2);
                break;
            }
            case R.id.image3_table1: {
                mImage3Tab1.setVisibility(View.INVISIBLE);
                onClickAction(3);
                break;
            }
            case R.id.image4_table1: {
                mImage4Tab1.setVisibility(View.INVISIBLE);
                onClickAction(4);
                break;
            }
        }
    }

    private void onClickAction( int num) {
        App.arrayTab1[clickCount] = num;
        sumNum -= num;

        if (clickCount == 3) {
            App.arrayTab1[4] = sumNum;
            mPresenter.showTable2Screen();
        }

        clickCount ++;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SUM_NUM_TAB1, clickCount);
        outState.putInt(KEY_SUM_NUM_TAB1, clickCount);
    }
}
