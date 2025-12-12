package r9;

import com.unity3d.services.core.device.reader.JsonStorageKeyNames;

/* compiled from: SessionEvent.kt */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f18882a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18883b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18884c;

    /* renamed from: d, reason: collision with root package name */
    public final long f18885d;

    /* renamed from: e, reason: collision with root package name */
    public final d f18886e;

    /* renamed from: f, reason: collision with root package name */
    public final String f18887f;

    /* renamed from: g, reason: collision with root package name */
    public final String f18888g;

    public p(String str, String str2, int i10, long j10, d dVar, String str3, String str4) {
        zf.i.checkNotNullParameter(str, JsonStorageKeyNames.SESSION_ID_KEY);
        zf.i.checkNotNullParameter(str2, "firstSessionId");
        zf.i.checkNotNullParameter(dVar, "dataCollectionStatus");
        zf.i.checkNotNullParameter(str3, "firebaseInstallationId");
        zf.i.checkNotNullParameter(str4, "firebaseAuthenticationToken");
        this.f18882a = str;
        this.f18883b = str2;
        this.f18884c = i10;
        this.f18885d = j10;
        this.f18886e = dVar;
        this.f18887f = str3;
        this.f18888g = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return zf.i.areEqual(this.f18882a, pVar.f18882a) && zf.i.areEqual(this.f18883b, pVar.f18883b) && this.f18884c == pVar.f18884c && this.f18885d == pVar.f18885d && zf.i.areEqual(this.f18886e, pVar.f18886e) && zf.i.areEqual(this.f18887f, pVar.f18887f) && zf.i.areEqual(this.f18888g, pVar.f18888g);
    }

    public final d getDataCollectionStatus() {
        return this.f18886e;
    }

    public final long getEventTimestampUs() {
        return this.f18885d;
    }

    public final String getFirebaseAuthenticationToken() {
        return this.f18888g;
    }

    public final String getFirebaseInstallationId() {
        return this.f18887f;
    }

    public final String getFirstSessionId() {
        return this.f18883b;
    }

    public final String getSessionId() {
        return this.f18882a;
    }

    public final int getSessionIndex() {
        return this.f18884c;
    }

    public int hashCode() {
        int iB = (ac.c.b(this.f18883b, this.f18882a.hashCode() * 31, 31) + this.f18884c) * 31;
        long j10 = this.f18885d;
        return this.f18888g.hashCode() + ac.c.b(this.f18887f, (this.f18886e.hashCode() + ((iB + ((int) (j10 ^ (j10 >>> 32)))) * 31)) * 31, 31);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SessionInfo(sessionId=");
        sb2.append(this.f18882a);
        sb2.append(", firstSessionId=");
        sb2.append(this.f18883b);
        sb2.append(", sessionIndex=");
        sb2.append(this.f18884c);
        sb2.append(", eventTimestampUs=");
        sb2.append(this.f18885d);
        sb2.append(", dataCollectionStatus=");
        sb2.append(this.f18886e);
        sb2.append(", firebaseInstallationId=");
        sb2.append(this.f18887f);
        sb2.append(", firebaseAuthenticationToken=");
        return ac.c.n(sb2, this.f18888g, ')');
    }
}
