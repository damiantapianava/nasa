package nasa.unam.mx.nasa.fragment;

import android.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.app.ApodPreference;
import nasa.unam.mx.nasa.data.ApodServiceIMO;
import nasa.unam.mx.nasa.model.Apod;
import nasa.unam.mx.nasa.model.ApodFavorite;
import retrofit2.Call;

public class ApodTodayFragmentDMO extends Fragment
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

    protected View view;

    protected ApodFavorite favorite;
    protected ApodPreference preference;
}
