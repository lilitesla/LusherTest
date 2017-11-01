package lili.tesla.lushertest.table2.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.base.BaseActivity;
import lili.tesla.lushertest.table1.presenter.Table1Presenter;
import lili.tesla.lushertest.table2.presenter.Table2Presenter;

public class Table2Activity extends BaseActivity implements Table2View {

    private Table2Presenter mPresenter;

    @BindView(R.id.image0_table2) ImageView mImage0;
    @BindView(R.id.image1_table2) ImageView mImage1;
    @BindView(R.id.image2_table2) ImageView mImage2;
    @BindView(R.id.image3_table2) ImageView mImage3;
    @BindView(R.id.image4_table2) ImageView mImage4;
    @BindView(R.id.image5_table2) ImageView mImage5;
    @BindView(R.id.image6_table2) ImageView mImage6;
    @BindView(R.id.image7_table2) ImageView mImage7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table2);

        ButterKnife.bind(this);
        mPresenter = new Table2Presenter();
        mPresenter.setView(this);
        mPresenter.setImagesColors();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, Table2Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void setImagesColors() {
        mImage0.setBackgroundResource(R.color.gray);
        mImage1.setBackgroundResource(R.color.darkBlue);
        mImage2.setBackgroundResource(R.color.teal);
        mImage3.setBackgroundResource(R.color.redYellow);
        mImage4.setBackgroundResource(R.color.yellowRed);
        mImage5.setBackgroundResource(R.color.purple);
        mImage6.setBackgroundResource(R.color.brown);
        mImage7.setBackgroundResource(R.color.black);
    }
}
