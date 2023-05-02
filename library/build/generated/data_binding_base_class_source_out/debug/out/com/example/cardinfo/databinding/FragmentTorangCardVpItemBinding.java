// Generated by data binding compiler. Do not edit!
package com.example.cardinfo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cardinfo.R;
import com.example.cardinfo.RestaurantInfoCardViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentTorangCardVpItemBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout container;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final ImageView iv;

  @NonNull
  public final RatingBar ratingBar;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @Bindable
  protected RestaurantInfoCardViewModel mCardInfoViewModel;

  protected FragmentTorangCardVpItemBinding(Object _bindingComponent, View _root,
      int _localFieldCount, FrameLayout container, Guideline guideline, ImageView iv,
      RatingBar ratingBar, RecyclerView recyclerView, TextView textView, TextView textView2,
      TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
    super(_bindingComponent, _root, _localFieldCount);
    this.container = container;
    this.guideline = guideline;
    this.iv = iv;
    this.ratingBar = ratingBar;
    this.recyclerView = recyclerView;
    this.textView = textView;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView6 = textView6;
  }

  public abstract void setCardInfoViewModel(
      @Nullable RestaurantInfoCardViewModel cardInfoViewModel);

  @Nullable
  public RestaurantInfoCardViewModel getCardInfoViewModel() {
    return mCardInfoViewModel;
  }

  @NonNull
  public static FragmentTorangCardVpItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_torang_card_vp_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentTorangCardVpItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentTorangCardVpItemBinding>inflateInternal(inflater, R.layout.fragment_torang_card_vp_item, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentTorangCardVpItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_torang_card_vp_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentTorangCardVpItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentTorangCardVpItemBinding>inflateInternal(inflater, R.layout.fragment_torang_card_vp_item, null, false, component);
  }

  public static FragmentTorangCardVpItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentTorangCardVpItemBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentTorangCardVpItemBinding)bind(component, view, R.layout.fragment_torang_card_vp_item);
  }
}
