package lili.tesla.lushertest.presentation.screen.table3.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.presentation.application.App;
import lili.tesla.lushertest.presentation.screen.table2.view.Table2Activity;
import lili.tesla.lushertest.presentation.screen.table3.presenter.Table3Presenter;
import lili.tesla.lushertest.presentation.screen.base.BaseActivity;

public class Table3Activity extends BaseActivity implements Table3View{

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
    private ImageView[] images;

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

        images = new ImageView[4];
        images[0] = mImage0Tab3;
        images[1] = mImage1Tab3;
        images[2] = mImage2Tab3;
        images[3] = mImage3Tab3;

        if (savedInstanceState != null) {
            mPresenter.clickCount = savedInstanceState.getInt(KEY_CLICK_COUNT_TAB3, 0);
            mPresenter.testNum = savedInstanceState.getInt(KEY_TEST_NUM_TAB3, -1);
            mPresenter.isSecondTry = savedInstanceState.getBoolean(KEY_IS_SECOND_TRY, false);
            mPresenter.isWasSecondTry = savedInstanceState.getBoolean(KEY_IS_WAS_SECOND_TRY, false);
        }
        mPresenter.testNum --;

        mPresenter.startNewTest();
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
        finish();
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

    @OnClick(R.id.image0_table3)
    void onImage0Table3Click() {
        mPresenter.onImageClick(0);
    }

    @OnClick(R.id.image1_table3)
    void onImage1Table3Click() {
        mPresenter.onImageClick(1);
    }

    @OnClick(R.id.image2_table3)
    void onImage2Table3Click() {
        mPresenter.onImageClick(2);
    }

    @OnClick(R.id.image3_table3)
    void onImage3Table3Click() {
        mPresenter.onImageClick(3);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CLICK_COUNT_TAB3, mPresenter.clickCount);
        outState.putInt(KEY_TEST_NUM_TAB3, mPresenter.testNum);
        outState.putBoolean(KEY_IS_SECOND_TRY, mPresenter.isSecondTry);
        outState.putBoolean(KEY_IS_WAS_SECOND_TRY, mPresenter.isWasSecondTry);
    }

}
