package nasa.unam.mx.nasa.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.model.Photo;

public class DetailActivity extends DetailActivityDMO
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Photo photo = (Photo) getIntent().getExtras().getSerializable("photo");

        image_view.setImageURI(photo.getImgSrc());
        txt_title.setText(photo.getCamera().getFullName());
        txt_date.setText(photo.getEarthDate());
        txt_explanation.setText(photo.getRover().getName());
    }
}
