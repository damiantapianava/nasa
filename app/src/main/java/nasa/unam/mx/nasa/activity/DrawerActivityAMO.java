package nasa.unam.mx.nasa.activity;

import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;

import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.fragment.ApodTodayFragment;
import nasa.unam.mx.nasa.fragment.MarsRoverPhotosFragment;

public abstract class DrawerActivityAMO extends DrawerActivityDMO
{
    protected void init_navigation_view()
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(MenuItem item)
            {
                drawerLayout.closeDrawers();

                manager = getFragmentManager();

                switch (item.getItemId())
                {
                    case R.id.mars_rover_item:
                        manager.beginTransaction().replace(R.id.holder_fragment, new MarsRoverPhotosFragment()).commit();
                    break;

                    case R.id.today_apod_item:
                        manager.beginTransaction().replace(R.id.holder_fragment, new ApodTodayFragment()).commit();
                        break;

                    case R.id.favorite_item:
                        Snackbar.make(findViewById(android.R.id.content), "Welcome to AndroidHive", Snackbar.LENGTH_LONG).show();
                        break;
                }

                return true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name)
        {
            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
    }
}
