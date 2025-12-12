package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;

/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
public final class c0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f1287b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Typeface f1288m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f1289n;

    public c0(TextView textView, Typeface typeface, int i10) {
        this.f1287b = textView;
        this.f1288m = typeface;
        this.f1289n = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1287b.setTypeface(this.f1288m, this.f1289n);
    }
}
