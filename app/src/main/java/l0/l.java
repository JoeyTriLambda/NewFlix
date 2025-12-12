package l0;

import android.content.res.Configuration;

/* compiled from: MultiWindowModeChangedInfo.kt */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f15657a;

    public l(boolean z10) {
        this.f15657a = z10;
    }

    public final boolean isInMultiWindowMode() {
        return this.f15657a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(boolean z10, Configuration configuration) {
        this(z10);
        zf.i.checkNotNullParameter(configuration, "newConfig");
    }
}
