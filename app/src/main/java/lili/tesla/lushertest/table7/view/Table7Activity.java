package lili.tesla.lushertest.table7.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.base.BaseActivity;
import lili.tesla.lushertest.table7.presenter.Table7Presenter;

public class Table7Activity extends BaseActivity implements Table7View {

    private Table7Presenter mPresenter;

    @BindView(R.id.image0_table7) ImageView mImage0Tab7;
    @BindView(R.id.image1_table7) ImageView mImage1Tab7;
    @BindView(R.id.image2_table7) ImageView mImage2Tab7;
    @BindView(R.id.image3_table7) ImageView mImage3Tab7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table7);

        ButterKnife.bind(this);
        mPresenter = new Table7Presenter();
        mPresenter.setView(this);
        mPresenter.setImagesColors();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, Table7Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void setImagesColors() {
        mImage0Tab7.setBackgroundResource(R.color.lightBrown);
        mImage1Tab7.setBackgroundResource(R.color.greenYellow);
        mImage2Tab7.setBackgroundResource(R.color.redOrange);
        mImage3Tab7.setBackgroundResource(R.color.yellowRed);
    }
}
