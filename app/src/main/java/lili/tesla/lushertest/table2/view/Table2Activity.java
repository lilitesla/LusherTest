package lili.tesla.lushertest.table2.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.base.BaseActivity;
import lili.tesla.lushertest.results.view.ResultActivity;
import lili.tesla.lushertest.table1.presenter.Table1Presenter;
import lili.tesla.lushertest.table2.presenter.Table2Presenter;
import lili.tesla.lushertest.table3.view.Table3Activity;

public class Table2Activity extends BaseActivity implements Table2View {

    public static void start(Context context) {
        Intent intent = new Intent(context, Table2Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private Table2Presenter mPresenter;

    @BindView(R.id.image0_table2) ImageView mImage0Tab2;
    @BindView(R.id.image1_table2) ImageView mImage1Tab2;
    @BindView(R.id.image2_table2) ImageView mImage2Tab2;
    @BindView(R.id.image3_table2) ImageView mImage3Tab2;
    @BindView(R.id.image4_table2) ImageView mImage4Tab2;
    @BindView(R.id.image5_table2) ImageView mImage5Tab2;
    @BindView(R.id.image6_table2) ImageView mImage6Tab2;
    @BindView(R.id.image7_table2) ImageView mImage7Tab2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table2);

        ButterKnife.bind(this);
        mPresenter = new Table2Presenter();
        mPresenter.setView(this);
        mPresenter.setImagesColors();
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
}
