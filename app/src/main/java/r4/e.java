package r4;

import com.google.auto.value.AutoValue;
import r4.a;

/* compiled from: BackendRequest.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class e {

    /* compiled from: BackendRequest.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract e build();

        public abstract a setEvents(Iterable<q4.i> iterable);

        public abstract a setExtras(byte[] bArr);
    }

    public static a builder() {
        return new a.C0238a();
    }

    public abstract Iterable<q4.i> getEvents();

    public abstract byte[] getExtras();
}
