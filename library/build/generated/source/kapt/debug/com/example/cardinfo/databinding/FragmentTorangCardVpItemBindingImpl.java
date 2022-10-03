package com.example.cardinfo.databinding;
import com.example.cardinfo.R;
import com.example.cardinfo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentTorangCardVpItemBindingImpl extends FragmentTorangCardVpItemBinding  {

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
            setRestaurant((com.sryang.torang_repository.data.entity.RestaurantEntity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCardInfoViewModel(@Nullable com.example.cardinfo.RestaurantInfoCardViewModel CardInfoViewModel) {
        this.mCardInfoViewModel = CardInfoViewModel;
    }
    public void setRestaurant(@Nullable com.sryang.torang_repository.data.entity.RestaurantEntity Restaurant) {
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
        java.lang.String restaurantPrices = null;
        java.lang.String restaurantRestaurantName = null;
        java.lang.Float restaurantRating = null;
        float androidxDatabindingViewDataBindingSafeUnboxRestaurantRating = 0f;
        java.lang.String stringFormatJavaLangStringSStringValueOfRestaurantReviewCount = null;
        java.lang.String stringValueOfRestaurantReviewCount = null;
        com.sryang.torang_repository.data.entity.RestaurantEntity restaurant = mRestaurant;
        java.lang.String restaurantImgUrl1 = null;
        java.lang.String restaurantRestaurantType = null;
        java.lang.String restaurantReviewCount = null;

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


                // read androidx.databinding.ViewDataBinding.safeUnbox(restaurant.rating)
                androidxDatabindingViewDataBindingSafeUnboxRestaurantRating = androidx.databinding.ViewDataBinding.safeUnbox(restaurantRating);
                // read String.valueOf(restaurant.review_count)
                stringValueOfRestaurantReviewCount = java.lang.String.valueOf(restaurantReviewCount);


                // read String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(restaurant.rating))
                stringValueOfRestaurantRating = java.lang.String.valueOf(androidxDatabindingViewDataBindingSafeUnboxRestaurantRating);
                // read String.format("(%s)", String.valueOf(restaurant.review_count))
                stringFormatJavaLangStringSStringValueOfRestaurantReviewCount = java.lang.String.format("(%s)", stringValueOfRestaurantReviewCount);
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.sarang.torangimageloader.ImageLoadBindingAdapter.loadImage(this.iv, restaurantImgUrl1);
            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.ratingBar, androidxDatabindingViewDataBindingSafeUnboxRestaurantRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView, restaurantRestaurantName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView2, stringFormatJavaLangStringSStringValueOfRestaurantReviewCount);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView3, stringValueOfRestaurantRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView4, restaurantRestaurantType);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView5, restaurantPrices);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): cardInfoViewModel
        flag 1 (0x2L): restaurant
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}