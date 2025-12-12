package r9;

import com.google.firebase.sessions.DataCollectionState;

/* compiled from: SessionEvent.kt */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final DataCollectionState f18855a;

    /* renamed from: b, reason: collision with root package name */
    public final DataCollectionState f18856b;

    /* renamed from: c, reason: collision with root package name */
    public final double f18857c;

    public d() {
        this(null, null, 0.0d, 7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f18855a == dVar.f18855a && this.f18856b == dVar.f18856b && zf.i.areEqual(Double.valueOf(this.f18857c), Double.valueOf(dVar.f18857c));
    }

    public final DataCollectionState getCrashlytics() {
        return this.f18856b;
    }

    public final DataCollectionState getPerformance() {
        return this.f18855a;
    }

    public final double getSessionSamplingRate() {
        return this.f18857c;
    }

    public int hashCode() {
        int iHashCode = (this.f18856b.hashCode() + (this.f18855a.hashCode() * 31)) * 31;
        long jDoubleToLongBits = Double.doubleToLongBits(this.f18857c);
        return iHashCode + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.f18855a + ", crashlytics=" + this.f18856b + ", sessionSamplingRate=" + this.f18857c + ')';
    }

    public d(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d10) {
        zf.i.checkNotNullParameter(dataCollectionState, "performance");
        zf.i.checkNotNullParameter(dataCollectionState2, "crashlytics");
        this.f18855a = dataCollectionState;
        this.f18856b = dataCollectionState2;
        this.f18857c = d10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ d(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d10, int i10, zf.f fVar) {
        int i11 = i10 & 1;
        DataCollectionState dataCollectionState3 = DataCollectionState.COLLECTION_SDK_NOT_INSTALLED;
        this(i11 != 0 ? dataCollectionState3 : dataCollectionState, (i10 & 2) != 0 ? dataCollectionState3 : dataCollectionState2, (i10 & 4) != 0 ? 1.0d : d10);
    }
}
