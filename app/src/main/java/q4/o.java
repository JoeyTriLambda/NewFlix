package q4;

import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.auto.value.AutoValue;
import q4.d;

/* compiled from: TransportContext.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class o {

    /* compiled from: TransportContext.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract o build();

        public abstract a setBackendName(String str);

        public abstract a setExtras(byte[] bArr);

        public abstract a setPriority(Priority priority);
    }

    public static a builder() {
        return new d.a().setPriority(Priority.DEFAULT);
    }

    public abstract String getBackendName();

    public abstract byte[] getExtras();

    public abstract Priority getPriority();

    public boolean shouldUploadClientHealthMetrics() {
        return getExtras() != null;
    }

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = getBackendName();
        objArr[1] = getPriority();
        objArr[2] = getExtras() == null ? "" : Base64.encodeToString(getExtras(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }

    public o withPriority(Priority priority) {
        return builder().setBackendName(getBackendName()).setPriority(priority).setExtras(getExtras()).build();
    }
}
