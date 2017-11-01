package lili.tesla.lushertest.table5.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.base.BaseActivity;
import lili.tesla.lushertest.table5.presenter.Table5Presenter;

public class Table5Activity extends BaseActivity implements Table5View {

    private Table5Presenter mPresenter;

    @BindView(R.id.image0_table5) ImageView mImage0;
    @BindView(R.id.image1_table5) ImageView mImage1;
    @BindView(R.id.image2_table5) ImageView mImage2;
    @BindView(R.id.image3_table5) ImageView mImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table5);
        ButterKnife.bind(this);
        mPresenter = new Table5Presenter();
        mPresenter.setView(this);
        mPresenter.setImagesColors();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, Table5Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void setImagesColors() {
        mImage0.setBackgroundResource(R.color.brownGreen);
        mImage1.setBackgroundResource(R.color.teal);
        mImage2.setBackgroundResource(R.color.green);
        mImage3.setBackgroundResource(R.color.yellowGreen);
    }
}
