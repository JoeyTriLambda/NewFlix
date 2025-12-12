package l0;

import android.content.res.Configuration;

/* compiled from: PictureInPictureModeChangedInfo.kt */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f15716a;

    public x(boolean z10) {
        this.f15716a = z10;
    }

    public final boolean isInPictureInPictureMode() {
        return this.f15716a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(boolean z10, Configuration configuration) {
        this(z10);
        zf.i.checkNotNullParameter(configuration, "newConfig");
    }
}
