package lili.tesla.lushertest.presentation.screen.table1.view;

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
import lili.tesla.lushertest.presentation.screen.table1.presenter.Table1Presenter;
import lili.tesla.lushertest.presentation.screen.table2.view.Table2Activity;

public class Table1Activity extends BaseActivity implements Table1View {

    private static final String KEY_CLICK_COUNT_TAB1 = "CLICK_COUNT_TAB1";
    private static final String KEY_SUM_NUM_TAB1 = "SUM_NUM_TAB1";

    public static void start(Context context ) {
        Intent intent = new Intent(context, Table1Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private Table1Presenter mPresenter;
    private ImageView[] images;

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

        images = new ImageView[5];
        images[0] = mImage0Tab1;
        images[1] = mImage1Tab1;
        images[2] = mImage2Tab1;
        images[3] = mImage3Tab1;
        images[4] = mImage4Tab1;

        if (savedInstanceState != null) {
            mPresenter.clickCount = savedInstanceState.getInt(KEY_CLICK_COUNT_TAB1, 0);
            mPresenter.sumNum = savedInstanceState.getInt(KEY_SUM_NUM_TAB1, 10);
        }

        mPresenter.setImagesColors();
        mPresenter.setImagesVisible();
    }

    @Override
    public void setImagesColors() {
        images[0].setBackgroundResource(R.color.gray);
        images[1].setBackgroundResource(R.color.darkGray);
        images[2].setBackgroundResource(R.color.black);
        images[3].setBackgroundResource(R.color.lightGray);
        images[4].setBackgroundResource(R.drawable.borders);
    }

    @Override
    public void showTable2Screen() {
        Table2Activity.start(this, 0);
        finish();
    }

    @Override
    public void setImageVisible(int num) {
        images[num].setVisibility(View.INVISIBLE);
    }

    @Override
    public void setImagesVisible() {

        for (int i = 0; i < 5; i ++) {
            if (App.arrayTab1[i] > -1) {
                images[App.arrayTab1[i]].setVisibility(View.INVISIBLE);
            }
        }

    }

    @OnClick (R.id.image0_table1)
    void onImage0Click() {
        mPresenter.setImageVisible(0);
    }

    @OnClick (R.id.image1_table1)
    void onImage1Click() {
        mPresenter.setImageVisible(1);
    }

    @OnClick (R.id.image2_table1)
    void onImage2Click() {
        mPresenter.setImageVisible(2);
    }

    @OnClick (R.id.image3_table1)
    void onImage3Click() {
        mPresenter.setImageVisible(3);
    }

    @OnClick (R.id.image4_table1)
    void onImage4Click() {
        mPresenter.setImageVisible(4);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CLICK_COUNT_TAB1, mPresenter.clickCount);
        outState.putInt(KEY_SUM_NUM_TAB1, mPresenter.sumNum);
    }


}
