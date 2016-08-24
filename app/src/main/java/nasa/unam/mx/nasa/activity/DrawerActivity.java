package nasa.unam.mx.nasa.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.app.ApodPreference;
import nasa.unam.mx.nasa.data.ApodFavoriteDAO;

public class DrawerActivity extends DrawerActivityAMO
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        init_navigation_view();
        init_graph_request();
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

                if(add_favorites_ENABLED)
                {
                    add_to_favorites();

                } else {

                    Snackbar.make(findViewById(android.R.id.content), "Select an image", Snackbar.LENGTH_LONG).show();
                }


                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void add_to_favorites()
    {
        preference = new ApodPreference(getApplicationContext());

        favorite = preference.getApodFavorite();

        if(favorite != null)
        {
            dao = new ApodFavoriteDAO(getApplicationContext());

            boolean persist_OK = dao.persist(favorite);

            if(persist_OK)
            {
                Snackbar.make(findViewById(android.R.id.content), favorite.getImgSrc() + " added", Snackbar.LENGTH_LONG).show();
            }
        }
    }
}
