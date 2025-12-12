package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* compiled from: UnprecomputeTextOnModificationSpannable.java */
/* loaded from: classes.dex */
public final class r implements Spannable {

    /* renamed from: b, reason: collision with root package name */
    public boolean f2665b = false;

    /* renamed from: m, reason: collision with root package name */
    public Spannable f2666m;

    /* compiled from: UnprecomputeTextOnModificationSpannable.java */
    public static class a {
        public boolean a(Spannable spannable) {
            return spannable instanceof v0.d;
        }
    }

    /* compiled from: UnprecomputeTextOnModificationSpannable.java */
    public static class b extends a {
        @Override // androidx.emoji2.text.r.a
        public final boolean a(Spannable spannable) {
            return (spannable instanceof PrecomputedText) || (spannable instanceof v0.d);
        }
    }

    public r(Spannable spannable) {
        this.f2666m = spannable;
    }

    public final void a() {
        Spannable spannable = this.f2666m;
        if (!this.f2665b) {
            if ((Build.VERSION.SDK_INT < 28 ? new a() : new b()).a(spannable)) {
                this.f2666m = new SpannableString(spannable);
            }
        }
        this.f2665b = true;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f2666m.charAt(i10);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return this.f2666m.chars();
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return this.f2666m.codePoints();
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f2666m.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f2666m.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f2666m.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return (T[]) this.f2666m.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f2666m.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f2666m.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f2666m.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        a();
        this.f2666m.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f2666m.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f2666m.toString();
    }

    public r(CharSequence charSequence) {
        this.f2666m = new SpannableString(charSequence);
    }
}
