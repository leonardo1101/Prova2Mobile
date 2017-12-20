// Generated code from Butter Knife. Do not modify!
package com.example.leonardo.prova2.socF;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.leonardo.prova2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SocFActivity_ViewBinding implements Unbinder {
  private SocFActivity target;

  @UiThread
  public SocFActivity_ViewBinding(SocFActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SocFActivity_ViewBinding(SocFActivity target, View source) {
    this.target = target;

    target.rvSocF = Utils.findRequiredViewAsType(source, R.id.rv_socFilan, "field 'rvSocF'", RecyclerView.class);
    target.loadingLayout = Utils.findRequiredViewAsType(source, R.id.linear_layout_loading, "field 'loadingLayout'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SocFActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvSocF = null;
    target.loadingLayout = null;
  }
}
