package lili.tesla.lushertest.table1.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.base.BaseActivity;
import lili.tesla.lushertest.table1.presenter.Table1Presenter;
import lili.tesla.lushertest.table2.view.Table2Activity;

public class Table1Activity extends BaseActivity implements Table1View {

    private Table1Presenter mPresenter;

    @BindView(R.id.image0_table1) ImageView mImage0;
    @BindView(R.id.image1_table1) ImageView mImage1;
    @BindView(R.id.image2_table1) ImageView mImage2;
    @BindView(R.id.image3_table1) ImageView mImage3;
    @BindView(R.id.image4_table1) ImageView mImage4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table1);

        ButterKnife.bind(this);
        mPresenter = new Table1Presenter();
        mPresenter.setView(this);
        mPresenter.setImagesColors();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, Table1Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void setImagesColors() {
        mImage0.setBackgroundResource(R.color.gray);
        mImage1.setBackgroundResource(R.color.darkGray);
        mImage2.setBackgroundResource(R.color.black);
        mImage3.setBackgroundResource(R.color.lightGray);
        mImage4.setBackgroundResource(R.drawable.borders);
    }
}
