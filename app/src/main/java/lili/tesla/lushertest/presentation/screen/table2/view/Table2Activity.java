package lili.tesla.lushertest.presentation.screen.table2.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.presentation.application.App;
import lili.tesla.lushertest.presentation.screen.base.BaseActivity;
import lili.tesla.lushertest.presentation.screen.results.view.ResultActivity;
import lili.tesla.lushertest.presentation.screen.table2.presenter.Table2Presenter;
import lili.tesla.lushertest.presentation.screen.table3.view.Table3Activity;

public class Table2Activity extends BaseActivity implements Table2View {

    public static final String EXTRA_KEY_QUERY_NUM = "KEY_QUERY_NUM";
    public static final String KEY_CLICK_COUNT_TAB2 = "CLICK_COUNT_TAB2";
    public static final String KEY_SUM_NUM_TAB2 = "SUM_NUM_TAB2";

    public static void start(Context context, int queryNum) {
        Intent intent = new Intent(context, Table2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putInt( EXTRA_KEY_QUERY_NUM, queryNum);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private Table2Presenter mPresenter;
    private int mQueryNum;

    private ImageView[] images;

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

        images = new ImageView[8];
        images[0] = mImage0Tab2;
        images[1] = mImage3Tab2;
        images[2] = mImage2Tab2;
        images[3] = mImage1Tab2;
        images[4] = mImage6Tab2;
        images[5] = mImage5Tab2;
        images[6] = mImage4Tab2;
        images[7] = mImage7Tab2;

        if (savedInstanceState != null) {
            mPresenter.clickCount = savedInstanceState.getInt(KEY_CLICK_COUNT_TAB2, 0);
            mPresenter.sumNum = savedInstanceState.getInt(KEY_SUM_NUM_TAB2, 28);
            mQueryNum = savedInstanceState.getInt(EXTRA_KEY_QUERY_NUM, 0);
        }

        mPresenter.setImagesColors();
        mQueryNum = getIntent().getIntExtra(EXTRA_KEY_QUERY_NUM, 0);

        mPresenter.setImagesVisible();
    }

    @Override
    public void setImagesColors() {
        images[0].setBackgroundResource(R.color.gray);
        images[3].setBackgroundResource(R.color.redYellow);
        images[2].setBackgroundResource(R.color.teal);
        images[1].setBackgroundResource(R.color.darkBlue);
        images[6].setBackgroundResource(R.color.brown);
        images[5].setBackgroundResource(R.color.purple);
        images[4].setBackgroundResource(R.color.yellowRed);
        images[7].setBackgroundResource(R.color.black);
    }

    @Override
    public void showTable3Screen() {
        Table3Activity.start(this);
        finish();
    }

    @Override
    public void showResultScreen() {
        ResultActivity.start(this);
        finish();
    }


    @Override
    public void setImageVisible(int num) {
        images[num].setVisibility(View.INVISIBLE);
    }

    @Override
    public void setImagesVisible() {

        for (int i = 0; i < 8; i ++) {
            if (mQueryNum == 0) {
                if (App.arrayTab2_1[i] > -1) {
                    images[App.arrayTab2_1[i]].setVisibility(View.INVISIBLE);
                }
            } else {
                if (App.arrayTab2_2[i] > -1) {
                    images[App.arrayTab2_2[i]].setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    @OnClick(R.id.image0_table2)
    void onImage0Tab2Click() {
        mPresenter.setImageVisible(0, mQueryNum);
    }

    @OnClick(R.id.image1_table2)
    void onImage1Tab2Click() {
        mPresenter.setImageVisible(3, mQueryNum);
    }

    @OnClick(R.id.image2_table2)
    void onImage2Tab2Click() {
        mPresenter.setImageVisible(2, mQueryNum);
    }

    @OnClick(R.id.image3_table2)
    void onImage3Tab2Click() {
        mPresenter.setImageVisible(1, mQueryNum);
    }

    @OnClick(R.id.image4_table2)
    void onImage4Tab2Click() {
        mPresenter.setImageVisible(6, mQueryNum);
    }

    @OnClick(R.id.image5_table2)
    void onImage5Tab2Click() {
        mPresenter.setImageVisible(5, mQueryNum);
    }

    @OnClick(R.id.image6_table2)
    void onImage6Tab2Click() {
        mPresenter.setImageVisible(4, mQueryNum);
    }

    @OnClick(R.id.image7_table2)
    void onImage7Tab2Click() {
        mPresenter.setImageVisible(7, mQueryNum);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CLICK_COUNT_TAB2, mPresenter.clickCount);
        outState.putInt(KEY_SUM_NUM_TAB2, mPresenter.sumNum);
        outState.putInt(EXTRA_KEY_QUERY_NUM, mQueryNum);
    }
}
