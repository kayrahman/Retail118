package com.treasurehunt.retail118.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.treasurehunt.retail118.R;
import com.treasurehunt.retail118.model.MenuItems;
import com.treasurehunt.retail118.model.Product;

import java.util.ArrayList;

/**
 * Created by neel on 01/11/2016.
 */

public abstract class RecyclerAdapters extends RecyclerView.Adapter{


  //  protected Product[] mProducts;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(getLayoutId(),parent,false);

        return new ViewHolder(view) ;
    }

    protected abstract int getLayoutId();

    protected abstract ArrayList<Product> getProducts();

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder)holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return getProducts().size();
    }


    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mImageView;
        private TextView mTextView;
        private int mIndex;



        public ViewHolder(View itemView) {
            super(itemView);

            mImageView=(ImageView) itemView.findViewById(getImageIdView());
            mTextView=(TextView) itemView.findViewById(getProductNameView());
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mIndex=position;
            mTextView.setText(getProducts().get(position).getProductName());
           // mImageView.setImageResource(MenuItems.resourcesIds[position]);


            Picasso.with(itemView.getContext())
                    .load("http://retail118.com/image"+getProducts().get(position).getImage())
                    //.load("http://image.tmdb.org/t/p/w500/"+movieNowPlaying[position].getPoster())
                    .placeholder(R.drawable.placeholder2)
                    .into(mImageView);

        }

        @Override
        public void onClick(View v) {
            onMenuItemsSelected(mIndex);
        }
    }

    protected abstract int getProductNameView();
    protected abstract int getImageIdView();

    protected abstract void onMenuItemsSelected(int mIndex);


}
