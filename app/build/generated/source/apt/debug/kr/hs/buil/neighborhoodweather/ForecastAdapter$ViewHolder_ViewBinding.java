// Generated code from Butter Knife. Do not modify!
package kr.hs.buil.neighborhoodweather;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ForecastAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ForecastAdapter.ViewHolder target;

  @UiThread
  public ForecastAdapter$ViewHolder_ViewBinding(ForecastAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvForeTime = Utils.findRequiredViewAsType(source, R.id.tvForeTime, "field 'tvForeTime'", TextView.class);
    target.tvForeSky = Utils.findRequiredViewAsType(source, R.id.tvForeSky, "field 'tvForeSky'", TextView.class);
    target.tvForeTemp = Utils.findRequiredViewAsType(source, R.id.tvForeTemp, "field 'tvForeTemp'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ForecastAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvForeTime = null;
    target.tvForeSky = null;
    target.tvForeTemp = null;
  }
}
