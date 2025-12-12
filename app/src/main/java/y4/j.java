package y4;

import com.google.auto.value.AutoValue;

/* compiled from: PersistedEvent.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class j {
    public static j create(long j10, q4.o oVar, q4.i iVar) {
        return new b(j10, oVar, iVar);
    }

    public abstract q4.i getEvent();

    public abstract long getId();

    public abstract q4.o getTransportContext();
}
