package r4;

import android.content.Context;

/* compiled from: AutoValue_CreationContext.java */
/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f18584a;

    /* renamed from: b, reason: collision with root package name */
    public final a5.a f18585b;

    /* renamed from: c, reason: collision with root package name */
    public final a5.a f18586c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18587d;

    public b(Context context, a5.a aVar, a5.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f18584a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f18585b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f18586c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f18587d = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f18584a.equals(fVar.getApplicationContext()) && this.f18585b.equals(fVar.getWallClock()) && this.f18586c.equals(fVar.getMonotonicClock()) && this.f18587d.equals(fVar.getBackendName());
    }

    @Override // r4.f
    public Context getApplicationContext() {
        return this.f18584a;
    }

    @Override // r4.f
    public String getBackendName() {
        return this.f18587d;
    }

    @Override // r4.f
    public a5.a getMonotonicClock() {
        return this.f18586c;
    }

    @Override // r4.f
    public a5.a getWallClock() {
        return this.f18585b;
    }

    public int hashCode() {
        return ((((((this.f18584a.hashCode() ^ 1000003) * 1000003) ^ this.f18585b.hashCode()) * 1000003) ^ this.f18586c.hashCode()) * 1000003) ^ this.f18587d.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("CreationContext{applicationContext=");
        sb2.append(this.f18584a);
        sb2.append(", wallClock=");
        sb2.append(this.f18585b);
        sb2.append(", monotonicClock=");
        sb2.append(this.f18586c);
        sb2.append(", backendName=");
        return ac.c.o(sb2, this.f18587d, "}");
    }
}
