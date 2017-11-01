package lili.tesla.lushertest.table4.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.base.BaseActivity;
import lili.tesla.lushertest.table4.presenter.Table4Presenter;

public class Table4Activity extends BaseActivity implements Table4View {

    private Table4Presenter mPresenter;

    @BindView(R.id.image0_table4) ImageView mImage0;
    @BindView(R.id.image1_table4) ImageView mImage1;
    @BindView(R.id.image2_table4) ImageView mImage2;
    @BindView(R.id.image3_table4) ImageView mImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table4);

        ButterKnife.bind(this);
        mPresenter = new Table4Presenter();
        mPresenter.setView(this);
        mPresenter.setImagesColors();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, Table4Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void setImagesColors() {
        mImage0.setBackgroundResource(R.color.darkBlue);
        mImage1.setBackgroundResource(R.color.teal);
        mImage2.setBackgroundResource(R.color.purple);
        mImage3.setBackgroundResource(R.color.cyan);
    }
}
