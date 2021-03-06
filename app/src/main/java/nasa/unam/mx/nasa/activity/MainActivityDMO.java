package nasa.unam.mx.nasa.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.data.ApodServiceIMO;
import nasa.unam.mx.nasa.model.Apod;
import retrofit2.Call;

public abstract class MainActivityDMO extends AppCompatActivity
{
    @BindView(R.id.iv_app_ic)
    protected ImageView image_view;

    @BindView(R.id.txt_title)
    protected TextView txt_title;

    @BindView(R.id.txt_date)
    protected TextView txt_date;

    @BindView(R.id.txt_explanation)
    protected TextView txt_explanation;

    protected ApodServiceIMO service;

    protected Call<Apod> request;

    protected StringBuilder sb;
}
