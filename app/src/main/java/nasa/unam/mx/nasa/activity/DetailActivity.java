package nasa.unam.mx.nasa.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.app.ApodPreference;
import nasa.unam.mx.nasa.data.ApodFavoriteDAO;
import nasa.unam.mx.nasa.model.ApodFavorite;
import nasa.unam.mx.nasa.model.Photo;

public class DetailActivity extends DetailActivityDMO
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        photo = (Photo) getIntent().getExtras().getSerializable("photo");

        image_view.setImageURI(photo.getImgSrc());
        txt_title.setText(photo.getCamera().getFullName());
        txt_date.setText(photo.getEarthDate());
        txt_explanation.setText(photo.getRover().getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_add_favorites, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_add_favorites:

                add_to_favorites();

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void add_to_favorites()
    {
        favorite = new ApodFavorite();
        favorite.setImgSrc(photo.getImgSrc());
        favorite.setCameraFullName(photo.getCamera().getFullName());
        favorite.setEarthDate(photo.getEarthDate());
        favorite.setRoverName(photo.getRover().getName());

        dao = new ApodFavoriteDAO(getApplicationContext());

        boolean persist_OK = dao.persist(favorite);

        if(persist_OK)
        {
            Snackbar.make(findViewById(android.R.id.content), photo.getImgSrc() + " added", Snackbar.LENGTH_LONG).show();
        }
    }
}
