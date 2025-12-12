package a2;

import android.os.Bundle;

/* compiled from: MediaRouteDiscoveryRequest.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f143a;

    /* renamed from: b, reason: collision with root package name */
    public m f144b;

    public h(m mVar, boolean z10) {
        if (mVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        Bundle bundle = new Bundle();
        this.f143a = bundle;
        this.f144b = mVar;
        bundle.putBundle("selector", mVar.asBundle());
        bundle.putBoolean("activeScan", z10);
    }

    public Bundle asBundle() {
        return this.f143a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return getSelector().equals(hVar.getSelector()) && isActiveScan() == hVar.isActiveScan();
    }

    public m getSelector() {
        if (this.f144b == null) {
            m mVarFromBundle = m.fromBundle(this.f143a.getBundle("selector"));
            this.f144b = mVarFromBundle;
            if (mVarFromBundle == null) {
                this.f144b = m.f182c;
            }
        }
        return this.f144b;
    }

    public int hashCode() {
        return getSelector().hashCode() ^ isActiveScan();
    }

    public boolean isActiveScan() {
        return this.f143a.getBoolean("activeScan");
    }

    public boolean isValid() {
        if (this.f144b == null) {
            m mVarFromBundle = m.fromBundle(this.f143a.getBundle("selector"));
            this.f144b = mVarFromBundle;
            if (mVarFromBundle == null) {
                this.f144b = m.f182c;
            }
        }
        return this.f144b.isValid();
    }

    public String toString() {
        return "DiscoveryRequest{ selector=" + getSelector() + ", activeScan=" + isActiveScan() + ", isValid=" + isValid() + " }";
    }
}
