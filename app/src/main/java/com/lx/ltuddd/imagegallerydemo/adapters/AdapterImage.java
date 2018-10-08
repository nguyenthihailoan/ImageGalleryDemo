package com.lx.ltuddd.imagegallerydemo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lx.ltuddd.imagegallerydemo.R;
import com.lx.ltuddd.imagegallerydemo.objects.ImageObject;

import java.util.List;

/**
 * Created by DaiPhongPC on 7/16/2018.
 */

public class AdapterImage extends RecyclerView.Adapter<AdapterImage.ViewHolderImage> {
    private Context mContext;
    private List<ImageObject> mImages;
private var onListener: OnClickImageListener
    public AdapterImage(Context context, List<ImageObject> images) {
        this.mContext = context;
        this.mImages = images;
    }

    public void setArrImage(List<ImageObject> images) {
        this.mImages = images;
    }

    @NonNull
    @Override
    public ViewHolderImage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_image, parent, false);
        return new ViewHolderImage(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderImage holder, int position) {
        ImageObject ImageObject = getItem(position);
        Glide.with(mContext)
                .load(ImageObject.getPath())
                .into(holder.mImage);
        holder.mImage.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    onListener.onClickImage(position)
                }
            })
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public ImageObject getItem(int position) {
        return mImages.get(position);
    }

    public class ViewHolderImage extends RecyclerView.ViewHolder {
        private ImageView mImage;

        public ViewHolderImage(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.image);
        }
    }
    
    
}
