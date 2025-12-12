package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import zf.i;

/* compiled from: SetUserVisibleHintViolation.kt */
/* loaded from: classes.dex */
public final class SetUserVisibleHintViolation extends Violation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetUserVisibleHintViolation(Fragment fragment, boolean z10) {
        super(fragment, "Attempting to set user visible hint to " + z10 + " for fragment " + fragment);
        i.checkNotNullParameter(fragment, "fragment");
    }
}
