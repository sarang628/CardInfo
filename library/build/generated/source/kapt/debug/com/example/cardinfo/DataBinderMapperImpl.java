package com.example.cardinfo;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.cardinfo.databinding.FragmentRestaurantInfoCardBindingImpl;
import com.example.cardinfo.databinding.FragmentTorangCardVpItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTRESTAURANTINFOCARD = 1;

  private static final int LAYOUT_FRAGMENTTORANGCARDVPITEM = 2;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(2);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.cardinfo.R.layout.fragment_restaurant_info_card, LAYOUT_FRAGMENTRESTAURANTINFOCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.cardinfo.R.layout.fragment_torang_card_vp_item, LAYOUT_FRAGMENTTORANGCARDVPITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTRESTAURANTINFOCARD: {
          if ("layout/fragment_restaurant_info_card_0".equals(tag)) {
            return new FragmentRestaurantInfoCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_restaurant_info_card is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTORANGCARDVPITEM: {
          if ("layout/fragment_torang_card_vp_item_0".equals(tag)) {
            return new FragmentTorangCardVpItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_torang_card_vp_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.sarang.torangimageloader.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "restaurantImage");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(2);

    static {
      sKeys.put("layout/fragment_restaurant_info_card_0", com.example.cardinfo.R.layout.fragment_restaurant_info_card);
      sKeys.put("layout/fragment_torang_card_vp_item_0", com.example.cardinfo.R.layout.fragment_torang_card_vp_item);
    }
  }
}
