package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import zf.i;

/* compiled from: Violation.kt */
/* loaded from: classes.dex */
public abstract class Violation extends RuntimeException {

    /* renamed from: b, reason: collision with root package name */
    public final Fragment f2925b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Violation(Fragment fragment, String str) {
        super(str);
        i.checkNotNullParameter(fragment, "fragment");
        this.f2925b = fragment;
    }

    public final Fragment getFragment() {
        return this.f2925b;
    }
}
