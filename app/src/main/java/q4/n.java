package q4;

import com.google.auto.value.AutoValue;
import q4.c;

/* compiled from: SendRequest.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class n {

    /* compiled from: SendRequest.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract a setTransportContext(o oVar);
    }

    public static a builder() {
        return new c.a();
    }

    public abstract n4.c<?> a();

    public abstract n4.d<?, byte[]> b();

    public abstract n4.b getEncoding();

    public byte[] getPayload() {
        return b().apply(a().getPayload());
    }

    public abstract o getTransportContext();

    public abstract String getTransportName();
}
