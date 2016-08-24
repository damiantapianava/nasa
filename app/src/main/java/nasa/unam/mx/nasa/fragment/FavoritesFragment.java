package nasa.unam.mx.nasa.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.adapter.FavoritesAdapter;
import nasa.unam.mx.nasa.data.ApodFavoriteDAO;
import nasa.unam.mx.nasa.model.ApodFavorite;

public class FavoritesFragment extends Fragment
{
    protected View view;

    protected FavoritesAdapter adapter;

    protected ApodFavoriteDAO dao;

    @BindView(R.id.favorites_list_view)
    protected ListView list_view;

    protected List<ApodFavorite> favorites;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.favorites_list_view, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        dao = new ApodFavoriteDAO(getActivity());

        favorites = dao.getLista_ApodFavorite();

        adapter = new FavoritesAdapter(getActivity(), favorites);

        list_view.setAdapter(adapter);
    }
}
