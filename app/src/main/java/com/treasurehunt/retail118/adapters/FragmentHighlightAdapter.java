package com.treasurehunt.retail118.adapters;

import com.treasurehunt.retail118.R;
import com.treasurehunt.retail118.callback.MyInterface;
import com.treasurehunt.retail118.model.Product;

import java.util.ArrayList;

/**
 * Created by neel on 01/11/2016.
 */
public class FragmentHighlightAdapter extends RecyclerAdapters{

    private ArrayList<Product> mProducts;

   // private final MenuFragments.OnMenuSelectedInterface mListener;
    private final MyInterface mListener;


    public FragmentHighlightAdapter(MyInterface listener, ArrayList<Product> products) {
        mListener=listener;
        mProducts=products;
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_highlighted;
    }

    @Override
    protected ArrayList<Product> getProducts() {
        return mProducts;
    }

    @Override
    protected int getProductNameView() {
        return R.id.titleTextView;
    }

    @Override
    protected int getImageIdView() {
        return R.id.coverImageView ;
    }

    @Override
    protected void onMenuItemsSelected(int mIndex) {
        mListener.onProductListSelected(mIndex);
    }
}
