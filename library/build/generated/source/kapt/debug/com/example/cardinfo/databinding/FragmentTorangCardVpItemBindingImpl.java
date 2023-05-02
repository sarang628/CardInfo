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
        sViewsWithIds.put(R.id.recyclerView, 1);
        sViewsWithIds.put(R.id.iv, 2);
        sViewsWithIds.put(R.id.tv_restaurant_name, 3);
        sViewsWithIds.put(R.id.ratingBar, 4);
        sViewsWithIds.put(R.id.textView4, 5);
        sViewsWithIds.put(R.id.textView6, 6);
        sViewsWithIds.put(R.id.textView3, 7);
        sViewsWithIds.put(R.id.textView5, 8);
        sViewsWithIds.put(R.id.textView2, 9);
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
            , (android.widget.ImageView) bindings[2]
            , (android.widget.RatingBar) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[3]
            );
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}