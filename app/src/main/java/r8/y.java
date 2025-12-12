package r8;

import java.io.IOException;

/* compiled from: CrashlyticsFileMarker.java */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final String f18797a;

    /* renamed from: b, reason: collision with root package name */
    public final w8.b f18798b;

    public y(String str, w8.b bVar) {
        this.f18797a = str;
        this.f18798b = bVar;
    }

    public boolean create() {
        String str = this.f18797a;
        try {
            return this.f18798b.getCommonFile(str).createNewFile();
        } catch (IOException e10) {
            o8.e.getLogger().e("Error creating marker: " + str, e10);
            return false;
        }
    }

    public boolean isPresent() {
        return this.f18798b.getCommonFile(this.f18797a).exists();
    }

    public boolean remove() {
        return this.f18798b.getCommonFile(this.f18797a).delete();
    }
}
