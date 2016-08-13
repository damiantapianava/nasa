package nasa.unam.mx.nasa.activity;

import android.os.Bundle;
import butterknife.ButterKnife;
import nasa.unam.mx.nasa.R;

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
    }
}
