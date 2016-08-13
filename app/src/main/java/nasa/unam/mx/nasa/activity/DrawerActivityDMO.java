package nasa.unam.mx.nasa.activity;

import android.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.fragment.ApodTodayFragment;

public abstract class DrawerActivityDMO extends AppCompatActivity
{
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.navigation_view)
    protected NavigationView navigationView;

    @BindView(R.id.navigation_drawer)
    protected DrawerLayout drawerLayout;

    protected ApodTodayFragment apodTodayFragment;

    protected FragmentManager manager;
}
