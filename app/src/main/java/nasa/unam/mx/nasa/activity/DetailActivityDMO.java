package nasa.unam.mx.nasa.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.data.ApodFavoriteDAO;
import nasa.unam.mx.nasa.model.ApodFavorite;
import nasa.unam.mx.nasa.model.Photo;

public abstract class DetailActivityDMO extends AppCompatActivity
{
    @BindView(R.id.detail_image_view)
    protected SimpleDraweeView image_view;

    @BindView(R.id.detail_txt_title)
    protected TextView txt_title;

    @BindView(R.id.detail_date_txt)
    protected TextView txt_date;

    @BindView(R.id.detail_txt_explanation)
    protected TextView txt_explanation;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    protected ApodFavoriteDAO dao;

    protected Photo photo;

    protected ApodFavorite favorite;

/*
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
*/
}
