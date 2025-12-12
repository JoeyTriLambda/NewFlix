package f3;

import com.unity3d.ads.metadata.MediationMetaData;

/* compiled from: WorkName.kt */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f11418a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11419b;

    public n(String str, String str2) {
        zf.i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        zf.i.checkNotNullParameter(str2, "workSpecId");
        this.f11418a = str;
        this.f11419b = str2;
    }

    public final String getName() {
        return this.f11418a;
    }

    public final String getWorkSpecId() {
        return this.f11419b;
    }
}
