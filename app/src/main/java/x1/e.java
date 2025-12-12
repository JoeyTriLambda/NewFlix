package x1;

import android.text.TextUtils;

/* compiled from: MediaSessionManagerImplBase.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f21375a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21376b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21377c;

    public e(String str, int i10, int i11) {
        this.f21375a = str;
        this.f21376b = i10;
        this.f21377c = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        int i10 = this.f21377c;
        String str = this.f21375a;
        int i11 = this.f21376b;
        return (i11 < 0 || eVar.f21376b < 0) ? TextUtils.equals(str, eVar.f21375a) && i10 == eVar.f21377c : TextUtils.equals(str, eVar.f21375a) && i11 == eVar.f21376b && i10 == eVar.f21377c;
    }

    public int hashCode() {
        return w0.c.hash(this.f21375a, Integer.valueOf(this.f21377c));
    }
}
