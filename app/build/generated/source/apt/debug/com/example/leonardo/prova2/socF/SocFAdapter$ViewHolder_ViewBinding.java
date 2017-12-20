// Generated code from Butter Knife. Do not modify!
package com.example.leonardo.prova2.socF;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.leonardo.prova2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SocFAdapter$ViewHolder_ViewBinding implements Unbinder {
  private SocFAdapter.ViewHolder target;

  private View view2131230768;

  @UiThread
  public SocFAdapter$ViewHolder_ViewBinding(final SocFAdapter.ViewHolder target, View source) {
    this.target = target;

    View view;
    target.txSocFName = Utils.findRequiredViewAsType(source, R.id.soc_name, "field 'txSocFName'", TextView.class);
    target.imgBackgroudSocF = Utils.findRequiredViewAsType(source, R.id.image_view_socf, "field 'imgBackgroudSocF'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.container, "method 'onItemClick'");
    view2131230768 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onItemClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SocFAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txSocFName = null;
    target.imgBackgroudSocF = null;

    view2131230768.setOnClickListener(null);
    view2131230768 = null;
  }
}
