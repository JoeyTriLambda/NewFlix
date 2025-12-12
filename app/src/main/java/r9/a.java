package r9;

import java.util.List;

/* compiled from: ApplicationInfo.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f18807a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18808b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18809c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18810d;

    /* renamed from: e, reason: collision with root package name */
    public final h f18811e;

    /* renamed from: f, reason: collision with root package name */
    public final List<h> f18812f;

    public a(String str, String str2, String str3, String str4, h hVar, List<h> list) {
        zf.i.checkNotNullParameter(str, "packageName");
        zf.i.checkNotNullParameter(str2, "versionName");
        zf.i.checkNotNullParameter(str3, "appBuildVersion");
        zf.i.checkNotNullParameter(str4, "deviceManufacturer");
        zf.i.checkNotNullParameter(hVar, "currentProcessDetails");
        zf.i.checkNotNullParameter(list, "appProcessDetails");
        this.f18807a = str;
        this.f18808b = str2;
        this.f18809c = str3;
        this.f18810d = str4;
        this.f18811e = hVar;
        this.f18812f = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return zf.i.areEqual(this.f18807a, aVar.f18807a) && zf.i.areEqual(this.f18808b, aVar.f18808b) && zf.i.areEqual(this.f18809c, aVar.f18809c) && zf.i.areEqual(this.f18810d, aVar.f18810d) && zf.i.areEqual(this.f18811e, aVar.f18811e) && zf.i.areEqual(this.f18812f, aVar.f18812f);
    }

    public final String getAppBuildVersion() {
        return this.f18809c;
    }

    public final List<h> getAppProcessDetails() {
        return this.f18812f;
    }

    public final h getCurrentProcessDetails() {
        return this.f18811e;
    }

    public final String getDeviceManufacturer() {
        return this.f18810d;
    }

    public final String getPackageName() {
        return this.f18807a;
    }

    public final String getVersionName() {
        return this.f18808b;
    }

    public int hashCode() {
        return this.f18812f.hashCode() + ((this.f18811e.hashCode() + ac.c.b(this.f18810d, ac.c.b(this.f18809c, ac.c.b(this.f18808b, this.f18807a.hashCode() * 31, 31), 31), 31)) * 31);
    }

    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f18807a + ", versionName=" + this.f18808b + ", appBuildVersion=" + this.f18809c + ", deviceManufacturer=" + this.f18810d + ", currentProcessDetails=" + this.f18811e + ", appProcessDetails=" + this.f18812f + ')';
    }
}
