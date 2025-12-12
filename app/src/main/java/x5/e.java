package x5;

import java.util.Collections;
import java.util.List;

/* compiled from: Period.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f21584a;

    /* renamed from: b, reason: collision with root package name */
    public final long f21585b;

    /* renamed from: c, reason: collision with root package name */
    public final List<a> f21586c;

    public e(String str, long j10, List<a> list) {
        this.f21584a = str;
        this.f21585b = j10;
        this.f21586c = Collections.unmodifiableList(list);
    }

    public int getAdaptationSetIndex(int i10) {
        List<a> list = this.f21586c;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (list.get(i11).f21558b == i10) {
                return i11;
            }
        }
        return -1;
    }
}
