package c6;

import android.text.Layout;

/* compiled from: Cea708Cue.java */
/* loaded from: classes.dex */
public final class b extends b6.a implements Comparable<b> {

    /* renamed from: o, reason: collision with root package name */
    public final int f5199o;

    public b(CharSequence charSequence, Layout.Alignment alignment, float f10, int i10, int i11, float f11, int i12, float f12, boolean z10, int i13, int i14) {
        super(charSequence, alignment, f10, i10, i11, f11, i12, f12, z10, i13);
        this.f5199o = i14;
    }

    @Override // java.lang.Comparable
    public int compareTo(b bVar) {
        int i10 = bVar.f5199o;
        int i11 = this.f5199o;
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }
}
