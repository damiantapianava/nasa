package nasa.unam.mx.nasa;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import nasa.unam.mx.nasa.model.Photo;

public class NasaApodAdapter extends RecyclerView.Adapter<NasaApodViewHolder>
{
    private List<Photo> photos;

    public NasaApodAdapter(List<Photo> photos)
    {
        this.photos = photos;
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

        Picasso.with(holder.image_view.getContext()).load(photo.getImgSrc()).into((holder.image_view));

        holder.txt_title.setText(photo.getCamera().getFullName());
    }

    @Override
    public int getItemCount()
    {
        int itemCount = photos != null ? photos.size() : 0;

        Log.d("APOD", "itemCount = " + itemCount);

        return itemCount;
    }
}
