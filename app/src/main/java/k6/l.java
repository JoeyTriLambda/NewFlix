package k6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HttpDataSource.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f15010a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f15011b;

    public synchronized Map<String, String> getSnapshot() {
        if (this.f15011b == null) {
            this.f15011b = Collections.unmodifiableMap(new HashMap(this.f15010a));
        }
        return this.f15011b;
    }

    public synchronized void set(String str, String str2) {
        this.f15011b = null;
        this.f15010a.put(str, str2);
    }
}
