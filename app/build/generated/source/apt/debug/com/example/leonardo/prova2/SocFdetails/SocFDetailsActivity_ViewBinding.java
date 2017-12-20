// Generated code from Butter Knife. Do not modify!
package com.example.leonardo.prova2.SocFdetails;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.leonardo.prova2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SocFDetailsActivity_ViewBinding implements Unbinder {
  private SocFDetailsActivity target;

  @UiThread
  public SocFDetailsActivity_ViewBinding(SocFDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SocFDetailsActivity_ViewBinding(SocFDetailsActivity target, View source) {
    this.target = target;

    target.imgHeader = Utils.findRequiredViewAsType(source, R.id.image_view_header, "field 'imgHeader'", ImageView.class);
    target.socfname = Utils.findRequiredViewAsType(source, R.id.socfname, "field 'socfname'", TextView.class);
    target.socfdesc = Utils.findRequiredViewAsType(source, R.id.socfdesc, "field 'socfdesc'", TextView.class);
    target.socfsite = Utils.findRequiredViewAsType(source, R.id.socfsite, "field 'socfsite'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SocFDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgHeader = null;
    target.socfname = null;
    target.socfdesc = null;
    target.socfsite = null;
  }
}
