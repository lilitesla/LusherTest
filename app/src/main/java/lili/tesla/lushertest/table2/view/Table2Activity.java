package lili.tesla.lushertest.table2.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.base.BaseActivity;
import lili.tesla.lushertest.results.view.ResultActivity;
import lili.tesla.lushertest.table1.presenter.Table1Presenter;
import lili.tesla.lushertest.table2.presenter.Table2Presenter;
import lili.tesla.lushertest.table3.view.Table3Activity;

public class Table2Activity extends BaseActivity implements Table2View, View.OnClickListener {

    public static final String EXTRA_KEY_QUERY_NUM = "KEY_QUERY_NUM";

    public static void start(Context context, int queryNum) {
        Intent intent = new Intent(context, Table2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putInt( EXTRA_KEY_QUERY_NUM, queryNum);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private Table2Presenter mPresenter;
    private int mQueryNum;
    private int clickCount;
    private int[] arrayTab1;

    @BindView(R.id.image0_table2) ImageView mImage0Tab2;
    @BindView(R.id.image1_table2) ImageView mImage1Tab2;
    @BindView(R.id.image2_table2) ImageView mImage2Tab2;
    @BindView(R.id.image3_table2) ImageView mImage3Tab2;
    @BindView(R.id.image4_table2) ImageView mImage4Tab2;
    @BindView(R.id.image5_table2) ImageView mImage5Tab2;
    @BindView(R.id.image6_table2) ImageView mImage6Tab2;
    @BindView(R.id.image7_table2) ImageView mImage7Tab2;

    @BindView(R.id.textViewTable2_description) TextView mTextTab2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table2);

        ButterKnife.bind(this);
        mPresenter = new Table2Presenter();
        mPresenter.setView(this);
        mPresenter.setImagesColors();

        mQueryNum = getIntent().getIntExtra(EXTRA_KEY_QUERY_NUM, 0);

        mImage0Tab2.setOnClickListener(this);
        mImage1Tab2.setOnClickListener(this);
        mImage2Tab2.setOnClickListener(this);
        mImage3Tab2.setOnClickListener(this);
        mImage4Tab2.setOnClickListener(this);
        mImage5Tab2.setOnClickListener(this);
        mImage6Tab2.setOnClickListener(this);
        mImage7Tab2.setOnClickListener(this);

        clickCount = 0;
        arrayTab1 = new int[6];
    }

    @Override
    public void setImagesColors() {
        mImage0Tab2.setBackgroundResource(R.color.gray);
        mImage1Tab2.setBackgroundResource(R.color.darkBlue);
        mImage2Tab2.setBackgroundResource(R.color.teal);
        mImage3Tab2.setBackgroundResource(R.color.redYellow);
        mImage4Tab2.setBackgroundResource(R.color.yellowRed);
        mImage5Tab2.setBackgroundResource(R.color.purple);
        mImage6Tab2.setBackgroundResource(R.color.brown);
        mImage7Tab2.setBackgroundResource(R.color.black);
    }

    @Override
    public void showTable3Screen() {
        Table3Activity.start(this);
    }

    @Override
    public void showResultScreen() {
        ResultActivity.start(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image0_table2: {
                mImage0Tab2.setVisibility(View.INVISIBLE);
                onClickAction(0);
                break;
            }
            case R.id.image1_table2: {
                mImage1Tab2.setVisibility(View.INVISIBLE);
                onClickAction(1);
                break;
            }
            case R.id.image2_table2: {
                mImage2Tab2.setVisibility(View.INVISIBLE);
                onClickAction(2);
                break;
            }
            case R.id.image3_table2: {
                mImage3Tab2.setVisibility(View.INVISIBLE);
                onClickAction(3);
                break;
            }
            case R.id.image4_table2: {
                mImage4Tab2.setVisibility(View.INVISIBLE);
                onClickAction(4);
                break;
            }
            case R.id.image5_table2: {
                mImage5Tab2.setVisibility(View.INVISIBLE);
                onClickAction(5);
                break;
            }
            case R.id.image6_table2: {
                mImage6Tab2.setVisibility(View.INVISIBLE);
                onClickAction(6);
                break;
            }
            case R.id.image7_table2: {
                mImage7Tab2.setVisibility(View.INVISIBLE);
                onClickAction(7);
                break;
            }
        }
    }

    private void onClickAction( int num) {
        arrayTab1[clickCount] = num;

        if (clickCount == 4) {
            mTextTab2.setText(R.string.text_worst);
        }
        if (clickCount == 5) {
            // TODO: 05.11.2017 сохранение
            if (mQueryNum == 0) {
                mPresenter.showTable3Screen();
            } else {
                mPresenter.showResultScreen();
            }
        }

        clickCount ++;
    }
}
