package ra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.skydoves.powerspinner.R;

/* compiled from: ItemDefaultPowerSpinnerLibraryBinding.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final AppCompatTextView f18896a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f18897b;

    public a(AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f18896a = appCompatTextView;
        this.f18897b = appCompatTextView2;
    }

    public static a bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) view;
        return new a(appCompatTextView, appCompatTextView);
    }

    public static a inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.item_default_power_spinner_library, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public AppCompatTextView getRoot() {
        return this.f18896a;
    }
}
