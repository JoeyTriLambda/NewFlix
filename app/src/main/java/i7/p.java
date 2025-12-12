package i7;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* compiled from: TextDrawableHelper.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    public float f13317c;

    /* renamed from: d, reason: collision with root package name */
    public float f13318d;

    /* renamed from: g, reason: collision with root package name */
    public n7.d f13321g;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f13315a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final a f13316b = new a();

    /* renamed from: e, reason: collision with root package name */
    public boolean f13319e = true;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<b> f13320f = new WeakReference<>(null);

    /* compiled from: TextDrawableHelper.java */
    public class a extends n7.f {
        public a() {
        }

        @Override // n7.f
        public void onFontRetrievalFailed(int i10) {
            p pVar = p.this;
            pVar.f13319e = true;
            b bVar = pVar.f13320f.get();
            if (bVar != null) {
                bVar.onTextSizeChange();
            }
        }

        @Override // n7.f
        public void onFontRetrieved(Typeface typeface, boolean z10) {
            if (z10) {
                return;
            }
            p pVar = p.this;
            pVar.f13319e = true;
            b bVar = pVar.f13320f.get();
            if (bVar != null) {
                bVar.onTextSizeChange();
            }
        }
    }

    /* compiled from: TextDrawableHelper.java */
    public interface b {
        int[] getState();

        boolean onStateChange(int[] iArr);

        void onTextSizeChange();
    }

    public p(b bVar) {
        setDelegate(bVar);
    }

    public final void a(String str) {
        TextPaint textPaint = this.f13315a;
        this.f13317c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        this.f13318d = str != null ? Math.abs(textPaint.getFontMetrics().ascent) : 0.0f;
        this.f13319e = false;
    }

    public n7.d getTextAppearance() {
        return this.f13321g;
    }

    public float getTextHeight(String str) {
        if (!this.f13319e) {
            return this.f13318d;
        }
        a(str);
        return this.f13318d;
    }

    public TextPaint getTextPaint() {
        return this.f13315a;
    }

    public float getTextWidth(String str) {
        if (!this.f13319e) {
            return this.f13317c;
        }
        a(str);
        return this.f13317c;
    }

    public void setDelegate(b bVar) {
        this.f13320f = new WeakReference<>(bVar);
    }

    public void setTextAppearance(n7.d dVar, Context context) {
        if (this.f13321g != dVar) {
            this.f13321g = dVar;
            if (dVar != null) {
                TextPaint textPaint = this.f13315a;
                a aVar = this.f13316b;
                dVar.updateMeasureState(context, textPaint, aVar);
                b bVar = this.f13320f.get();
                if (bVar != null) {
                    textPaint.drawableState = bVar.getState();
                }
                dVar.updateDrawState(context, textPaint, aVar);
                this.f13319e = true;
            }
            b bVar2 = this.f13320f.get();
            if (bVar2 != null) {
                bVar2.onTextSizeChange();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void setTextSizeDirty(boolean z10) {
        this.f13319e = z10;
    }

    public void setTextWidthDirty(boolean z10) {
        this.f13319e = z10;
    }

    public void updateTextPaintDrawState(Context context) {
        this.f13321g.updateDrawState(context, this.f13315a, this.f13316b);
    }
}
