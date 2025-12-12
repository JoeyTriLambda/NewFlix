package wc;

import android.graphics.Point;
import android.view.View;
import flix.com.vision.exomedia.core.video.scale.ScaleType;
import java.lang.ref.WeakReference;

/* compiled from: MatrixManager.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Point f21052a = new Point(0, 0);

    /* renamed from: b, reason: collision with root package name */
    public int f21053b = 0;

    /* renamed from: c, reason: collision with root package name */
    public ScaleType f21054c = ScaleType.FIT_CENTER;

    /* renamed from: d, reason: collision with root package name */
    public Integer f21055d = null;

    /* renamed from: e, reason: collision with root package name */
    public ScaleType f21056e = null;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<View> f21057f = new WeakReference<>(null);

    public void applyCenter(View view) {
        Point point = this.f21052a;
        setScale(view, point.x / view.getWidth(), point.y / view.getHeight());
    }

    public void applyCenterCrop(View view) {
        float width = view.getWidth();
        Point point = this.f21052a;
        float f10 = width / point.x;
        float height = view.getHeight() / point.y;
        float fMax = Math.max(f10, height);
        setScale(view, fMax / f10, fMax / height);
    }

    public void applyCenterInside(View view) {
        Point point = this.f21052a;
        if (point.x > view.getWidth() || point.y > view.getHeight()) {
            applyFitCenter(view);
        } else {
            applyCenter(view);
        }
    }

    public void applyFitCenter(View view) {
        float width = view.getWidth();
        Point point = this.f21052a;
        float f10 = width / point.x;
        float height = view.getHeight() / point.y;
        float fMin = Math.min(f10, height);
        setScale(view, fMin / f10, fMin / height);
    }

    public void applyRequestedModifications() {
        View view = this.f21057f.get();
        if (view != null) {
            Integer num = this.f21055d;
            if (num != null) {
                rotate(view, num.intValue());
                this.f21055d = null;
            }
            ScaleType scaleType = this.f21056e;
            if (scaleType != null) {
                scale(view, scaleType);
                this.f21056e = null;
            }
        }
        this.f21057f = new WeakReference<>(null);
    }

    public ScaleType getCurrentScaleType() {
        ScaleType scaleType = this.f21056e;
        return scaleType != null ? scaleType : this.f21054c;
    }

    public boolean ready() {
        Point point = this.f21052a;
        return point.x > 0 && point.y > 0;
    }

    public void rotate(View view, int i10) {
        if (!ready()) {
            this.f21055d = Integer.valueOf(i10);
            this.f21057f = new WeakReference<>(view);
            return;
        }
        if (((i10 / 90) % 2 == 1) != ((this.f21053b / 90) % 2 == 1)) {
            Point point = this.f21052a;
            int i11 = point.x;
            point.x = point.y;
            point.y = i11;
            scale(view, this.f21054c);
        }
        this.f21053b = i10;
        view.setRotation(i10);
    }

    public boolean scale(View view, ScaleType scaleType) {
        if (!ready()) {
            this.f21056e = scaleType;
            this.f21057f = new WeakReference<>(view);
            return false;
        }
        if (view.getHeight() == 0 || view.getWidth() == 0) {
            return false;
        }
        this.f21054c = scaleType;
        int iOrdinal = scaleType.ordinal();
        if (iOrdinal == 0) {
            applyCenter(view);
        } else if (iOrdinal == 1) {
            applyCenterCrop(view);
        } else if (iOrdinal == 2) {
            applyCenterInside(view);
        } else if (iOrdinal == 3) {
            applyFitCenter(view);
        } else if (iOrdinal == 4) {
            setScale(view, 1.0f, 1.0f);
        }
        return true;
    }

    public void setIntrinsicVideoSize(int i10, int i11) {
        boolean z10 = (this.f21053b / 90) % 2 == 1;
        Point point = this.f21052a;
        point.x = z10 ? i11 : i10;
        if (!z10) {
            i10 = i11;
        }
        point.y = i10;
        if (ready()) {
            applyRequestedModifications();
        }
    }

    public void setScale(View view, float f10, float f11) {
        if ((this.f21053b / 90) % 2 == 1) {
            float height = (f11 * view.getHeight()) / view.getWidth();
            f11 = (f10 * view.getWidth()) / view.getHeight();
            f10 = height;
        }
        view.setScaleX(f10);
        view.setScaleY(f11);
    }
}
