package nasa.unam.mx.nasa.activity;

import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONObject;

import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.fragment.ApodTodayFragment;
import nasa.unam.mx.nasa.fragment.FavoritesFragment;
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

                        add_favorites_ENABLED = false;
                    break;

                    case R.id.today_apod_item:
                        manager.beginTransaction().replace(R.id.holder_fragment, new ApodTodayFragment()).commit();

                        add_favorites_ENABLED = true;
                        break;

                    case R.id.favorite_item:
                        manager.beginTransaction().replace(R.id.holder_fragment, new FavoritesFragment()).commit();

                        add_favorites_ENABLED = false;
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

    protected void init_graph_request()
    {
        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback()
        {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response)
            {
                try
                {
                    SimpleDraweeView userImage = (SimpleDraweeView) findViewById(R.id.img_user_fb);
                    TextView user_name = (TextView) findViewById(R.id.txt_user_name);

                    userImage.setImageURI("http://graph.facebook.com/" + object.getString("id") + "/picture?type=large");

                    user_name.setText(object.getString("name"));

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        request.executeAsync();
    }
}
