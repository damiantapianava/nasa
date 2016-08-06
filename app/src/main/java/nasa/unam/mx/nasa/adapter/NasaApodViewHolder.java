package nasa.unam.mx.nasa.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nasa.unam.mx.nasa.R;
import nasa.unam.mx.nasa.model.Photo;

public class NasaApodViewHolder extends RecyclerView.ViewHolder
{
    @BindView(R.id.item_apod_image)
    //protected ImageView image_view;
    protected SimpleDraweeView image_view;

    @BindView(R.id.item_apod_title)
    protected TextView txt_title;

    private NasaApodAdapter.OnItemClickListener onItemListener;
    private Photo photo;

    public NasaApodViewHolder(View itemView)
    {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setItemClick(Photo photo, NasaApodAdapter.OnItemClickListener onItemListener)
    {
        this.photo = photo;
        this.onItemListener = onItemListener;
    }

    @OnClick(R.id.item_apod_image)
    public void onViewClick(View view)
    {
        if(onItemListener != null)
        {
            onItemListener.onItemClick(photo);
        }
    }
}
