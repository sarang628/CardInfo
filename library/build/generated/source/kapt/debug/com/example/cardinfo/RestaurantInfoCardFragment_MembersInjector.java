// Generated by Dagger (https://dagger.dev).
package com.example.cardinfo;

import com.sryang.torang_core.navigation.RestaurantDetailNavigation;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RestaurantInfoCardFragment_MembersInjector implements MembersInjector<RestaurantInfoCardFragment> {
  private final Provider<RestaurantDetailNavigation> restaurantDetailNavigationProvider;

  public RestaurantInfoCardFragment_MembersInjector(
      Provider<RestaurantDetailNavigation> restaurantDetailNavigationProvider) {
    this.restaurantDetailNavigationProvider = restaurantDetailNavigationProvider;
  }

  public static MembersInjector<RestaurantInfoCardFragment> create(
      Provider<RestaurantDetailNavigation> restaurantDetailNavigationProvider) {
    return new RestaurantInfoCardFragment_MembersInjector(restaurantDetailNavigationProvider);
  }

  @Override
  public void injectMembers(RestaurantInfoCardFragment instance) {
    injectRestaurantDetailNavigation(instance, restaurantDetailNavigationProvider.get());
  }

  @InjectedFieldSignature("com.example.cardinfo.RestaurantInfoCardFragment.restaurantDetailNavigation")
  public static void injectRestaurantDetailNavigation(RestaurantInfoCardFragment instance,
      RestaurantDetailNavigation restaurantDetailNavigation) {
    instance.restaurantDetailNavigation = restaurantDetailNavigation;
  }
}
