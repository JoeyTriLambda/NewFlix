package r9;

import com.google.firebase.sessions.LogEnvironment;

/* compiled from: ApplicationInfo.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f18813a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18814b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18815c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18816d;

    /* renamed from: e, reason: collision with root package name */
    public final LogEnvironment f18817e;

    /* renamed from: f, reason: collision with root package name */
    public final a f18818f;

    public b(String str, String str2, String str3, String str4, LogEnvironment logEnvironment, a aVar) {
        zf.i.checkNotNullParameter(str, "appId");
        zf.i.checkNotNullParameter(str2, "deviceModel");
        zf.i.checkNotNullParameter(str3, "sessionSdkVersion");
        zf.i.checkNotNullParameter(str4, "osVersion");
        zf.i.checkNotNullParameter(logEnvironment, "logEnvironment");
        zf.i.checkNotNullParameter(aVar, "androidAppInfo");
        this.f18813a = str;
        this.f18814b = str2;
        this.f18815c = str3;
        this.f18816d = str4;
        this.f18817e = logEnvironment;
        this.f18818f = aVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return zf.i.areEqual(this.f18813a, bVar.f18813a) && zf.i.areEqual(this.f18814b, bVar.f18814b) && zf.i.areEqual(this.f18815c, bVar.f18815c) && zf.i.areEqual(this.f18816d, bVar.f18816d) && this.f18817e == bVar.f18817e && zf.i.areEqual(this.f18818f, bVar.f18818f);
    }

    public final a getAndroidAppInfo() {
        return this.f18818f;
    }

    public final String getAppId() {
        return this.f18813a;
    }

    public final String getDeviceModel() {
        return this.f18814b;
    }

    public final LogEnvironment getLogEnvironment() {
        return this.f18817e;
    }

    public final String getOsVersion() {
        return this.f18816d;
    }

    public final String getSessionSdkVersion() {
        return this.f18815c;
    }

    public int hashCode() {
        return this.f18818f.hashCode() + ((this.f18817e.hashCode() + ac.c.b(this.f18816d, ac.c.b(this.f18815c, ac.c.b(this.f18814b, this.f18813a.hashCode() * 31, 31), 31), 31)) * 31);
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.f18813a + ", deviceModel=" + this.f18814b + ", sessionSdkVersion=" + this.f18815c + ", osVersion=" + this.f18816d + ", logEnvironment=" + this.f18817e + ", androidAppInfo=" + this.f18818f + ')';
    }
}
