// Generated by Dagger (https://dagger.dev).
package com.example.cardinfo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RestaurantInfoCardViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static RestaurantInfoCardViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(RestaurantInfoCardViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final RestaurantInfoCardViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new RestaurantInfoCardViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}