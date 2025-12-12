package r9;

import com.unity3d.services.core.device.reader.JsonStorageKeyNames;

/* compiled from: SessionGenerator.kt */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final String f18871a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18872b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18873c;

    /* renamed from: d, reason: collision with root package name */
    public final long f18874d;

    public l(String str, String str2, int i10, long j10) {
        zf.i.checkNotNullParameter(str, JsonStorageKeyNames.SESSION_ID_KEY);
        zf.i.checkNotNullParameter(str2, "firstSessionId");
        this.f18871a = str;
        this.f18872b = str2;
        this.f18873c = i10;
        this.f18874d = j10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return zf.i.areEqual(this.f18871a, lVar.f18871a) && zf.i.areEqual(this.f18872b, lVar.f18872b) && this.f18873c == lVar.f18873c && this.f18874d == lVar.f18874d;
    }

    public final String getFirstSessionId() {
        return this.f18872b;
    }

    public final String getSessionId() {
        return this.f18871a;
    }

    public final int getSessionIndex() {
        return this.f18873c;
    }

    public final long getSessionStartTimestampUs() {
        return this.f18874d;
    }

    public int hashCode() {
        int iB = (ac.c.b(this.f18872b, this.f18871a.hashCode() * 31, 31) + this.f18873c) * 31;
        long j10 = this.f18874d;
        return iB + ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.f18871a + ", firstSessionId=" + this.f18872b + ", sessionIndex=" + this.f18873c + ", sessionStartTimestampUs=" + this.f18874d + ')';
    }
}
