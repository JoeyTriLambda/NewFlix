package r9;

import com.google.firebase.sessions.EventType;

/* compiled from: SessionEvent.kt */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final EventType f18875a;

    /* renamed from: b, reason: collision with root package name */
    public final p f18876b;

    /* renamed from: c, reason: collision with root package name */
    public final b f18877c;

    public m(EventType eventType, p pVar, b bVar) {
        zf.i.checkNotNullParameter(eventType, "eventType");
        zf.i.checkNotNullParameter(pVar, "sessionData");
        zf.i.checkNotNullParameter(bVar, "applicationInfo");
        this.f18875a = eventType;
        this.f18876b = pVar;
        this.f18877c = bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f18875a == mVar.f18875a && zf.i.areEqual(this.f18876b, mVar.f18876b) && zf.i.areEqual(this.f18877c, mVar.f18877c);
    }

    public final b getApplicationInfo() {
        return this.f18877c;
    }

    public final EventType getEventType() {
        return this.f18875a;
    }

    public final p getSessionData() {
        return this.f18876b;
    }

    public int hashCode() {
        return this.f18877c.hashCode() + ((this.f18876b.hashCode() + (this.f18875a.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.f18875a + ", sessionData=" + this.f18876b + ", applicationInfo=" + this.f18877c + ')';
    }
}
