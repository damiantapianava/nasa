package nasa.unam.mx.nasa.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import nasa.unam.mx.nasa.model.Photo;

public abstract class NasaApodAdapterDMO extends RecyclerView.Adapter<NasaApodViewHolder>
{
    protected List<Photo> photos;

    protected NasaApodAdapter.OnItemClickListener onItemClickListener;

    public interface OnItemClickListener
    {
        void onItemClick(Photo photo);
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public void setOnItemClickListener(NasaApodAdapter.OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener = onItemClickListener;
    }
}
