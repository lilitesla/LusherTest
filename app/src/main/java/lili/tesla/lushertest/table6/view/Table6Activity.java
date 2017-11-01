package lili.tesla.lushertest.table6.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.base.BaseActivity;
import lili.tesla.lushertest.table6.presenter.Table6Presenter;

public class Table6Activity extends BaseActivity implements Table6View{

    private Table6Presenter mPresenter;

    @BindView(R.id.image0_table6) ImageView mImage0Tab6;
    @BindView(R.id.image1_table6) ImageView mImage1Tab6;
    @BindView(R.id.image2_table6) ImageView mImage2Tab6;
    @BindView(R.id.image3_table6) ImageView mImage3Tab6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table6);
        ButterKnife.bind(this);
        mPresenter = new Table6Presenter();
        mPresenter.setView(this);
        mPresenter.setImagesColors();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, Table6Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void setImagesColors() {
        mImage0Tab6.setBackgroundResource(R.color.brown);
        mImage1Tab6.setBackgroundResource(R.color.redBrown);
        mImage2Tab6.setBackgroundResource(R.color.redYellow);
        mImage3Tab6.setBackgroundResource(R.color.orange);
    }
}
