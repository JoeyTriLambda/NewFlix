package d5;

import android.media.AudioAttributes;

/* compiled from: AudioAttributes.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f10861e = new a().build();

    /* renamed from: a, reason: collision with root package name */
    public final int f10862a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f10863b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f10864c;

    /* renamed from: d, reason: collision with root package name */
    public AudioAttributes f10865d;

    /* compiled from: AudioAttributes.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f10866a = 1;

        public b build() {
            return new b(this.f10866a);
        }
    }

    public b(int i10) {
        this.f10864c = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f10862a == bVar.f10862a && this.f10863b == bVar.f10863b && this.f10864c == bVar.f10864c;
    }

    public int hashCode() {
        return ((((527 + this.f10862a) * 31) + this.f10863b) * 31) + this.f10864c;
    }
}
