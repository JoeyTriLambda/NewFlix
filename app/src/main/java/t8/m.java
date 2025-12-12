package t8;

import java.util.List;
import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
/* loaded from: classes.dex */
public final class m extends f0.e.d.a {

    /* renamed from: a, reason: collision with root package name */
    public final f0.e.d.a.b f19764a;

    /* renamed from: b, reason: collision with root package name */
    public final List<f0.c> f19765b;

    /* renamed from: c, reason: collision with root package name */
    public final List<f0.c> f19766c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f19767d;

    /* renamed from: e, reason: collision with root package name */
    public final f0.e.d.a.c f19768e;

    /* renamed from: f, reason: collision with root package name */
    public final List<f0.e.d.a.c> f19769f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19770g;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
    public static final class a extends f0.e.d.a.AbstractC0264a {

        /* renamed from: a, reason: collision with root package name */
        public f0.e.d.a.b f19771a;

        /* renamed from: b, reason: collision with root package name */
        public List<f0.c> f19772b;

        /* renamed from: c, reason: collision with root package name */
        public List<f0.c> f19773c;

        /* renamed from: d, reason: collision with root package name */
        public Boolean f19774d;

        /* renamed from: e, reason: collision with root package name */
        public f0.e.d.a.c f19775e;

        /* renamed from: f, reason: collision with root package name */
        public List<f0.e.d.a.c> f19776f;

        /* renamed from: g, reason: collision with root package name */
        public Integer f19777g;

        public a() {
        }

        @Override // t8.f0.e.d.a.AbstractC0264a
        public f0.e.d.a build() {
            String strConcat = this.f19771a == null ? " execution" : "";
            if (this.f19777g == null) {
                strConcat = strConcat.concat(" uiOrientation");
            }
            if (strConcat.isEmpty()) {
                return new m(this.f19771a, this.f19772b, this.f19773c, this.f19774d, this.f19775e, this.f19776f, this.f19777g.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strConcat));
        }

        @Override // t8.f0.e.d.a.AbstractC0264a
        public f0.e.d.a.AbstractC0264a setAppProcessDetails(List<f0.e.d.a.c> list) {
            this.f19776f = list;
            return this;
        }

        @Override // t8.f0.e.d.a.AbstractC0264a
        public f0.e.d.a.AbstractC0264a setBackground(Boolean bool) {
            this.f19774d = bool;
            return this;
        }

        @Override // t8.f0.e.d.a.AbstractC0264a
        public f0.e.d.a.AbstractC0264a setCurrentProcessDetails(f0.e.d.a.c cVar) {
            this.f19775e = cVar;
            return this;
        }

        @Override // t8.f0.e.d.a.AbstractC0264a
        public f0.e.d.a.AbstractC0264a setCustomAttributes(List<f0.c> list) {
            this.f19772b = list;
            return this;
        }

        @Override // t8.f0.e.d.a.AbstractC0264a
        public f0.e.d.a.AbstractC0264a setExecution(f0.e.d.a.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null execution");
            }
            this.f19771a = bVar;
            return this;
        }

        @Override // t8.f0.e.d.a.AbstractC0264a
        public f0.e.d.a.AbstractC0264a setInternalKeys(List<f0.c> list) {
            this.f19773c = list;
            return this;
        }

        @Override // t8.f0.e.d.a.AbstractC0264a
        public f0.e.d.a.AbstractC0264a setUiOrientation(int i10) {
            this.f19777g = Integer.valueOf(i10);
            return this;
        }

        public a(f0.e.d.a aVar) {
            this.f19771a = aVar.getExecution();
            this.f19772b = aVar.getCustomAttributes();
            this.f19773c = aVar.getInternalKeys();
            this.f19774d = aVar.getBackground();
            this.f19775e = aVar.getCurrentProcessDetails();
            this.f19776f = aVar.getAppProcessDetails();
            this.f19777g = Integer.valueOf(aVar.getUiOrientation());
        }
    }

    public m() {
        throw null;
    }

    public m(f0.e.d.a.b bVar, List list, List list2, Boolean bool, f0.e.d.a.c cVar, List list3, int i10) {
        this.f19764a = bVar;
        this.f19765b = list;
        this.f19766c = list2;
        this.f19767d = bool;
        this.f19768e = cVar;
        this.f19769f = list3;
        this.f19770g = i10;
    }

    public boolean equals(Object obj) {
        List<f0.c> list;
        List<f0.c> list2;
        Boolean bool;
        f0.e.d.a.c cVar;
        List<f0.e.d.a.c> list3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a)) {
            return false;
        }
        f0.e.d.a aVar = (f0.e.d.a) obj;
        return this.f19764a.equals(aVar.getExecution()) && ((list = this.f19765b) != null ? list.equals(aVar.getCustomAttributes()) : aVar.getCustomAttributes() == null) && ((list2 = this.f19766c) != null ? list2.equals(aVar.getInternalKeys()) : aVar.getInternalKeys() == null) && ((bool = this.f19767d) != null ? bool.equals(aVar.getBackground()) : aVar.getBackground() == null) && ((cVar = this.f19768e) != null ? cVar.equals(aVar.getCurrentProcessDetails()) : aVar.getCurrentProcessDetails() == null) && ((list3 = this.f19769f) != null ? list3.equals(aVar.getAppProcessDetails()) : aVar.getAppProcessDetails() == null) && this.f19770g == aVar.getUiOrientation();
    }

    @Override // t8.f0.e.d.a
    public List<f0.e.d.a.c> getAppProcessDetails() {
        return this.f19769f;
    }

    @Override // t8.f0.e.d.a
    public Boolean getBackground() {
        return this.f19767d;
    }

    @Override // t8.f0.e.d.a
    public f0.e.d.a.c getCurrentProcessDetails() {
        return this.f19768e;
    }

    @Override // t8.f0.e.d.a
    public List<f0.c> getCustomAttributes() {
        return this.f19765b;
    }

    @Override // t8.f0.e.d.a
    public f0.e.d.a.b getExecution() {
        return this.f19764a;
    }

    @Override // t8.f0.e.d.a
    public List<f0.c> getInternalKeys() {
        return this.f19766c;
    }

    @Override // t8.f0.e.d.a
    public int getUiOrientation() {
        return this.f19770g;
    }

    public int hashCode() {
        int iHashCode = (this.f19764a.hashCode() ^ 1000003) * 1000003;
        List<f0.c> list = this.f19765b;
        int iHashCode2 = (iHashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<f0.c> list2 = this.f19766c;
        int iHashCode3 = (iHashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f19767d;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        f0.e.d.a.c cVar = this.f19768e;
        int iHashCode5 = (iHashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List<f0.e.d.a.c> list3 = this.f19769f;
        return ((iHashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.f19770g;
    }

    @Override // t8.f0.e.d.a
    public f0.e.d.a.AbstractC0264a toBuilder() {
        return new a(this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Application{execution=");
        sb2.append(this.f19764a);
        sb2.append(", customAttributes=");
        sb2.append(this.f19765b);
        sb2.append(", internalKeys=");
        sb2.append(this.f19766c);
        sb2.append(", background=");
        sb2.append(this.f19767d);
        sb2.append(", currentProcessDetails=");
        sb2.append(this.f19768e);
        sb2.append(", appProcessDetails=");
        sb2.append(this.f19769f);
        sb2.append(", uiOrientation=");
        return ac.c.m(sb2, this.f19770g, "}");
    }
}
