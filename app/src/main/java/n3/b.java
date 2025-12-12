package n3;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.afollestad.materialdialogs.internal.MDRootLayout;

/* compiled from: MDRootLayout.java */
/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f16473b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f16474m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f16475n = true;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ MDRootLayout f16476o;

    public b(MDRootLayout mDRootLayout, View view, boolean z10) {
        this.f16476o = mDRootLayout;
        this.f16473b = view;
        this.f16474m = z10;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View view = this.f16473b;
        if (view.getMeasuredHeight() != 0) {
            WebView webView = (WebView) view;
            int i10 = MDRootLayout.E;
            boolean z10 = ((float) webView.getMeasuredHeight()) < webView.getScale() * ((float) webView.getContentHeight());
            boolean z11 = this.f16475n;
            boolean z12 = this.f16474m;
            MDRootLayout mDRootLayout = this.f16476o;
            if (z10) {
                mDRootLayout.a((ViewGroup) view, z12, z11);
            } else {
                if (z12) {
                    mDRootLayout.f5348n = false;
                }
                if (z11) {
                    mDRootLayout.f5349o = false;
                }
            }
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        return true;
    }
}
