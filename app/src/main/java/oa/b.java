package oa;

import zf.i;

/* compiled from: Change.kt */
/* loaded from: classes.dex */
public final class b<State> {

    /* renamed from: a, reason: collision with root package name */
    public final State f17059a;

    /* renamed from: b, reason: collision with root package name */
    public final State f17060b;

    public b(State state, State state2) {
        this.f17059a = state;
        this.f17060b = state2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return i.areEqual(this.f17059a, bVar.f17059a) && i.areEqual(this.f17060b, bVar.f17060b);
    }

    public final State getNewState() {
        return this.f17060b;
    }

    public final State getState() {
        return this.f17059a;
    }

    public int hashCode() {
        State state = this.f17059a;
        int iHashCode = (state == null ? 0 : state.hashCode()) * 31;
        State state2 = this.f17060b;
        return iHashCode + (state2 != null ? state2.hashCode() : 0);
    }

    public String toString() {
        return "Change(state=" + this.f17059a + ", newState=" + this.f17060b + ')';
    }
}
