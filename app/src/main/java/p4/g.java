package p4;

import com.google.auto.value.AutoValue;
import java.util.List;

/* compiled from: BatchedLogRequest.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class g {
    public static g create(List<i> list) {
        return new c(list);
    }

    public static b9.a createDataEncoder() {
        return new d9.c().configureWith(com.google.android.datatransport.cct.internal.a.f5622a).ignoreNullValues(true).build();
    }

    public abstract List<i> getLogRequests();
}
