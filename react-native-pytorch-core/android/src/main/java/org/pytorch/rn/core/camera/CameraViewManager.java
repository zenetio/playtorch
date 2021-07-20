/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package org.pytorch.rn.core.camera;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class CameraViewManager extends SimpleViewManager<CameraView> {

  public static final String REACT_CLASS = "PyTorchCoreCameraView";

  private final ReactApplicationContext mReactContext;

  public CameraViewManager(ReactApplicationContext reactContext) {
    this.mReactContext = reactContext;
  }

  @NonNull
  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @NonNull
  @Override
  protected CameraView createViewInstance(@NonNull ThemedReactContext reactContext) {
    return new CameraView(mReactContext);
  }

  @Nullable
  @Override
  public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
    final MapBuilder.Builder<String, Object> builder = MapBuilder.builder();
    return builder
        .put(
            "onFrame",
            MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onFrame")))
        .put(
            "onCapture",
            MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onCapture")))
        .build();
  }

  @ReactProp(name = "hideCaptureButton")
  public void setCaptureButtonVisibility(CameraView view, boolean hideCaptureButton) {
    view.setHideCaptureButton(hideCaptureButton);
  }
}
