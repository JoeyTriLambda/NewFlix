package sa;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.squareup.picasso.l;
import java.lang.ref.WeakReference;

/* compiled from: DeferredRequestCreator.java */
/* loaded from: classes2.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b, reason: collision with root package name */
    public final l f19182b;

    /* renamed from: m, reason: collision with root package name */
    public final WeakReference<ImageView> f19183m;

    /* renamed from: n, reason: collision with root package name */
    public b f19184n;

    public c(l lVar, ImageView imageView, b bVar) {
        this.f19182b = lVar;
        this.f19183m = new WeakReference<>(imageView);
        this.f19184n = bVar;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            onViewAttachedToWindow(imageView);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        WeakReference<ImageView> weakReference = this.f19183m;
        ImageView imageView = weakReference.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            imageView.removeOnAttachStateChangeListener(this);
            viewTreeObserver.removeOnPreDrawListener(this);
            weakReference.clear();
            l lVar = this.f19182b;
            lVar.f10613c = false;
            lVar.resize(width, height).into(imageView, this.f19184n);
        }
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
