package oa;

import zf.i;

/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class e<Event, State> {

    /* renamed from: a, reason: collision with root package name */
    public final State f17061a;

    /* renamed from: b, reason: collision with root package name */
    public final Event f17062b;

    /* renamed from: c, reason: collision with root package name */
    public final State f17063c;

    public e(State state, Event event, State state2) {
        this.f17061a = state;
        this.f17062b = event;
        this.f17063c = state2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return i.areEqual(this.f17061a, eVar.f17061a) && i.areEqual(this.f17062b, eVar.f17062b) && i.areEqual(this.f17063c, eVar.f17063c);
    }

    public int hashCode() {
        State state = this.f17061a;
        int iHashCode = (state == null ? 0 : state.hashCode()) * 31;
        Event event = this.f17062b;
        int iHashCode2 = (iHashCode + (event == null ? 0 : event.hashCode())) * 31;
        State state2 = this.f17063c;
        return iHashCode2 + (state2 != null ? state2.hashCode() : 0);
    }

    public String toString() {
        return "Transition(state=" + this.f17061a + ", event=" + this.f17062b + ", newState=" + this.f17063c + ')';
    }
}
