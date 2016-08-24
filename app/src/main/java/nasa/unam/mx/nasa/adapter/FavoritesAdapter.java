package nasa.unam.mx.nasa.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.model.ApodFavorite;

public class FavoritesAdapter extends ArrayAdapter<ApodFavorite>
{
    protected SimpleDraweeView image_view;
    protected TextView txt_title;
    protected TextView txt_date;
    protected TextView txt_explanation;

    public FavoritesAdapter(Context context, List<ApodFavorite> favorites)
    {
        super(context, 0, favorites);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_adapter, parent, false);
        }

        image_view = (SimpleDraweeView)  convertView.findViewById(R.id.detail_image_view);
        txt_title       = (TextView) convertView.findViewById(R.id.detail_txt_title);
        txt_date        = (TextView) convertView.findViewById(R.id.detail_date_txt);
        txt_explanation = (TextView) convertView.findViewById(R.id.detail_txt_explanation);

        ApodFavorite favorite = getItem(position);

        image_view.setImageURI(favorite.getImgSrc());
        txt_title.setText(favorite.getCameraFullName());
        txt_date.setText(favorite.getEarthDate());
        txt_explanation.setText(favorite.getRoverName());

        return convertView;
    }
}
