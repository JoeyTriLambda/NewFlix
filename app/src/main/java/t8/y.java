package t8;

import java.util.List;
import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutsState.java */
/* loaded from: classes.dex */
public final class y extends f0.e.d.f {

    /* renamed from: a, reason: collision with root package name */
    public final List<f0.e.d.AbstractC0277e> f19862a;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutsState.java */
    public static final class a extends f0.e.d.f.a {

        /* renamed from: a, reason: collision with root package name */
        public List<f0.e.d.AbstractC0277e> f19863a;

        @Override // t8.f0.e.d.f.a
        public f0.e.d.f build() {
            String str = this.f19863a == null ? " rolloutAssignments" : "";
            if (str.isEmpty()) {
                return new y(this.f19863a);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        @Override // t8.f0.e.d.f.a
        public f0.e.d.f.a setRolloutAssignments(List<f0.e.d.AbstractC0277e> list) {
            if (list == null) {
                throw new NullPointerException("Null rolloutAssignments");
            }
            this.f19863a = list;
            return this;
        }
    }

    public y() {
        throw null;
    }

    public y(List list) {
        this.f19862a = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.f) {
            return this.f19862a.equals(((f0.e.d.f) obj).getRolloutAssignments());
        }
        return false;
    }

    @Override // t8.f0.e.d.f
    public List<f0.e.d.AbstractC0277e> getRolloutAssignments() {
        return this.f19862a;
    }

    public int hashCode() {
        return this.f19862a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f19862a + "}";
    }
}
