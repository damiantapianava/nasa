package nasa.unam.mx.nasa.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.model.Photo;

public class NasaApodAdapter extends NasaApodAdapterDMO
{
    public NasaApodAdapter()
    {
        super();
    }

    @Override
    public NasaApodViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nasa_apod_item, parent, false);

        return new NasaApodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NasaApodViewHolder holder, int position)
    {
        Photo photo = photos.get(position);

        //Picasso.with(holder.image_view.getContext()).load(photo.getImgSrc()).into((holder.image_view));

        //Fresco: SimpleDraweeView
        holder.image_view.setImageURI(photo.getImgSrc());
        holder.txt_title.setText(photo.getCamera().getFullName());

        holder.setItemClick(photo, onItemClickListener);
    }

    @Override
    public int getItemCount()
    {
        int itemCount = photos != null ? photos.size() : 0;

        Log.d("APOD", "itemCount = " + itemCount);

        return itemCount;
    }
}
