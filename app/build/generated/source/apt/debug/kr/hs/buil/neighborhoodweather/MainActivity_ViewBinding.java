// Generated code from Butter Knife. Do not modify!
package kr.hs.buil.neighborhoodweather;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131427430;

  private View view2131427429;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.tvLocation = Utils.findRequiredViewAsType(source, R.id.tvLocation, "field 'tvLocation'", TextView.class);
    target.tvSky = Utils.findRequiredViewAsType(source, R.id.tvSky, "field 'tvSky'", TextView.class);
    target.tvTemperMax = Utils.findRequiredViewAsType(source, R.id.tvTemperMax, "field 'tvTemperMax'", TextView.class);
    target.tvTemperMin = Utils.findRequiredViewAsType(source, R.id.tvTemperMin, "field 'tvTemperMin'", TextView.class);
    target.tvTemperNow = Utils.findRequiredViewAsType(source, R.id.tvTemperNow, "field 'tvTemperNow'", TextView.class);
    target.layoutTemperature = Utils.findRequiredViewAsType(source, R.id.layoutTemperature, "field 'layoutTemperature'", LinearLayout.class);
    target.layoutBackground = Utils.findRequiredViewAsType(source, R.id.layoutBackground, "field 'layoutBackground'", LinearLayout.class);
    target.rvForecast = Utils.findRequiredViewAsType(source, R.id.rvForecast, "field 'rvForecast'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.lvCity, "field 'lvCity', method 'onCityItemClick', and method 'onCityLongClick'");
    target.lvCity = Utils.castView(view, R.id.lvCity, "field 'lvCity'", ListView.class);
    view2131427430 = view;
    ((AdapterView<?>) view).setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> p0, View p1, int p2, long p3) {
        target.onCityItemClick(p0, p2);
      }
    });
    ((AdapterView<?>) view).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
      @Override
      public boolean onItemLongClick(AdapterView<?> p0, View p1, int p2, long p3) {
        return target.onCityLongClick(p0, p2);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnAddCity, "method 'showAddressDialog'");
    view2131427429 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showAddressDialog();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvLocation = null;
    target.tvSky = null;
    target.tvTemperMax = null;
    target.tvTemperMin = null;
    target.tvTemperNow = null;
    target.layoutTemperature = null;
    target.layoutBackground = null;
    target.rvForecast = null;
    target.lvCity = null;

    ((AdapterView<?>) view2131427430).setOnItemClickListener(null);
    ((AdapterView<?>) view2131427430).setOnItemLongClickListener(null);
    view2131427430 = null;
    view2131427429.setOnClickListener(null);
    view2131427429 = null;
  }
}
