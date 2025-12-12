package n7;

import android.graphics.Typeface;

/* compiled from: CancelableFontCallback.java */
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f16732a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0207a f16733b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16734c;

    /* compiled from: CancelableFontCallback.java */
    /* renamed from: n7.a$a, reason: collision with other inner class name */
    public interface InterfaceC0207a {
        void apply(Typeface typeface);
    }

    public a(InterfaceC0207a interfaceC0207a, Typeface typeface) {
        this.f16732a = typeface;
        this.f16733b = interfaceC0207a;
    }

    public void cancel() {
        this.f16734c = true;
    }

    @Override // n7.f
    public void onFontRetrievalFailed(int i10) {
        if (this.f16734c) {
            return;
        }
        this.f16733b.apply(this.f16732a);
    }

    @Override // n7.f
    public void onFontRetrieved(Typeface typeface, boolean z10) {
        if (this.f16734c) {
            return;
        }
        this.f16733b.apply(typeface);
    }
}
