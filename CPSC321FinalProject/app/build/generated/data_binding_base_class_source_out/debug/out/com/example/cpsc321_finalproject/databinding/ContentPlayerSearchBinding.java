// Generated by view binder compiler. Do not edit!
package com.example.cpsc321_finalproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.cpsc321_finalproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContentPlayerSearchBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView addItemsMessage;

  @NonNull
  public final RecyclerView searchRecyclerView;

  private ContentPlayerSearchBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView addItemsMessage, @NonNull RecyclerView searchRecyclerView) {
    this.rootView = rootView;
    this.addItemsMessage = addItemsMessage;
    this.searchRecyclerView = searchRecyclerView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentPlayerSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentPlayerSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_player_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentPlayerSearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addItemsMessage;
      TextView addItemsMessage = ViewBindings.findChildViewById(rootView, id);
      if (addItemsMessage == null) {
        break missingId;
      }

      id = R.id.search_recycler_view;
      RecyclerView searchRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (searchRecyclerView == null) {
        break missingId;
      }

      return new ContentPlayerSearchBinding((ConstraintLayout) rootView, addItemsMessage,
          searchRecyclerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}