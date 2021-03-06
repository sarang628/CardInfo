package com.example.cardinfo.databinding;
import com.example.cardinfo.R;
import com.example.cardinfo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentTorangCardVpItemBindingImpl extends FragmentTorangCardVpItemBinding implements com.example.cardinfo.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.recyclerView, 8);
        sViewsWithIds.put(R.id.textView6, 9);
        sViewsWithIds.put(R.id.guideline, 10);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentTorangCardVpItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentTorangCardVpItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.FrameLayout) bindings[0]
            , (androidx.constraintlayout.widget.Guideline) bindings[10]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.RatingBar) bindings[3]
            , (androidx.recyclerview.widget.RecyclerView) bindings[8]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[9]
            );
        this.iv.setTag(null);
        this.ratingBar.setTag(null);
        this.textView.setTag(null);
        this.textView2.setTag(null);
        this.textView3.setTag(null);
        this.textView4.setTag(null);
        this.textView5.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.cardinfo.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.cardInfoViewModel == variableId) {
            setCardInfoViewModel((com.example.cardinfo.RestaurantInfoCardViewModel) variable);
        }
        else if (BR.restaurant == variableId) {
            setRestaurant((com.example.torang_core.data.model.Restaurant) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCardInfoViewModel(@Nullable com.example.cardinfo.RestaurantInfoCardViewModel CardInfoViewModel) {
        this.mCardInfoViewModel = CardInfoViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.cardInfoViewModel);
        super.requestRebind();
    }
    public void setRestaurant(@Nullable com.example.torang_core.data.model.Restaurant Restaurant) {
        this.mRestaurant = Restaurant;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.restaurant);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String stringValueOfRestaurantRating = null;
        com.example.torang_core.data.model.Prices restaurantPrices = null;
        java.lang.String restaurantRestaurantName = null;
        float restaurantRating = 0f;
        com.example.cardinfo.RestaurantInfoCardViewModel cardInfoViewModel = mCardInfoViewModel;
        java.lang.String stringFormatJavaLangStringSStringValueOfRestaurantReviewCount = null;
        java.lang.String restaurantRestaurantTypeName = null;
        java.lang.String restaurantPricesName = null;
        java.lang.String stringValueOfRestaurantReviewCount = null;
        com.example.torang_core.data.model.Restaurant restaurant = mRestaurant;
        java.lang.String restaurantImgUrl1 = null;
        com.example.torang_core.data.model.RestaurantType restaurantRestaurantType = null;
        int restaurantReviewCount = 0;

        if ((dirtyFlags & 0x6L) != 0) {



                if (restaurant != null) {
                    // read restaurant.prices
                    restaurantPrices = restaurant.getPrices();
                    // read restaurant.restaurant_name
                    restaurantRestaurantName = restaurant.getRestaurant_name();
                    // read restaurant.rating
                    restaurantRating = restaurant.getRating();
                    // read restaurant.img_url1
                    restaurantImgUrl1 = restaurant.getImg_url1();
                    // read restaurant.restaurant_type
                    restaurantRestaurantType = restaurant.getRestaurant_type();
                    // read restaurant.review_count
                    restaurantReviewCount = restaurant.getReview_count();
                }


                if (restaurantPrices != null) {
                    // read restaurant.prices.name()
                    restaurantPricesName = restaurantPrices.name();
                }
                // read String.valueOf(restaurant.rating)
                stringValueOfRestaurantRating = java.lang.String.valueOf(restaurantRating);
                // read String.valueOf(restaurant.review_count)
                stringValueOfRestaurantReviewCount = java.lang.String.valueOf(restaurantReviewCount);
                if (restaurantRestaurantType != null) {
                    // read restaurant.restaurant_type.name()
                    restaurantRestaurantTypeName = restaurantRestaurantType.name();
                }


                // read String.format("(%s)", String.valueOf(restaurant.review_count))
                stringFormatJavaLangStringSStringValueOfRestaurantReviewCount = java.lang.String.format("(%s)", stringValueOfRestaurantReviewCount);
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.iv.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.sarang.torangimageloader.ImageLoadBindingAdapter.loadImage(this.iv, restaurantImgUrl1);
            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.ratingBar, restaurantRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView, restaurantRestaurantName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView2, stringFormatJavaLangStringSStringValueOfRestaurantReviewCount);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView3, stringValueOfRestaurantRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView4, restaurantRestaurantTypeName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView5, restaurantPricesName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // cardInfoViewModel != null
        boolean cardInfoViewModelJavaLangObjectNull = false;
        // cardInfoViewModel
        com.example.cardinfo.RestaurantInfoCardViewModel cardInfoViewModel = mCardInfoViewModel;
        // restaurant
        com.example.torang_core.data.model.Restaurant restaurant = mRestaurant;



        cardInfoViewModelJavaLangObjectNull = (cardInfoViewModel) != (null);
        if (cardInfoViewModelJavaLangObjectNull) {



            cardInfoViewModel.clickRestaurant(restaurant);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): cardInfoViewModel
        flag 1 (0x2L): restaurant
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}