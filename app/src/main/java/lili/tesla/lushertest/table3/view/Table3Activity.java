package lili.tesla.lushertest.table3.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.lushertest.R;
import lili.tesla.lushertest.table3.presenter.Table3Presenter;
import lili.tesla.lushertest.base.BaseActivity;

public class Table3Activity extends BaseActivity implements Table3View {

    private Table3Presenter mPresenter;

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
        mPresenter.setImagesColorsTable3();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, Table3Activity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void setImagesColorsTable3() {
        mImage0Tab3.setBackgroundResource(R.color.darkBlue);
        mImage1Tab3.setBackgroundResource(R.color.teal);
        mImage2Tab3.setBackgroundResource(R.color.redYellow);
        mImage3Tab3.setBackgroundResource(R.color.yellowRed);
    }

    @Override
    public void setImagesColorsTable4() {
        mImage0Tab3.setBackgroundResource(R.color.darkBlue);
        mImage1Tab3.setBackgroundResource(R.color.teal);
        mImage2Tab3.setBackgroundResource(R.color.purple);
        mImage3Tab3.setBackgroundResource(R.color.cyan);
    }

    @Override
    public void setImagesColorsTable5() {
        mImage0Tab3.setBackgroundResource(R.color.brownGreen);
        mImage1Tab3.setBackgroundResource(R.color.teal);
        mImage2Tab3.setBackgroundResource(R.color.green);
        mImage3Tab3.setBackgroundResource(R.color.yellowGreen);
    }

    @Override
    public void setImagesColorsTable6() {
        mImage0Tab3.setBackgroundResource(R.color.brown);
        mImage1Tab3.setBackgroundResource(R.color.redBrown);
        mImage2Tab3.setBackgroundResource(R.color.redYellow);
        mImage3Tab3.setBackgroundResource(R.color.orange);
    }

    @Override
    public void setImagesColorsTable7() {
        mImage0Tab3.setBackgroundResource(R.color.lightBrown);
        mImage1Tab3.setBackgroundResource(R.color.greenYellow);
        mImage2Tab3.setBackgroundResource(R.color.redOrange);
        mImage3Tab3.setBackgroundResource(R.color.yellowRed);
    }


}
