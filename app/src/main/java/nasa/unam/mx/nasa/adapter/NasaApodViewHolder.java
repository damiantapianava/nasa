package nasa.unam.mx.nasa.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import nasa.unam.mx.nasa.R;

public class NasaApodViewHolder extends RecyclerView.ViewHolder
{
    @BindView(R.id.item_apod_image)
    //protected ImageView image_view;
    protected SimpleDraweeView image_view;

    @BindView(R.id.item_apod_title)
    protected TextView txt_title;

    public NasaApodViewHolder(View itemView)
    {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
