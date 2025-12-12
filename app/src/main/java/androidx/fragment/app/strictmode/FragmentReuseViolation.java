package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import zf.i;

/* compiled from: FragmentReuseViolation.kt */
/* loaded from: classes.dex */
public final class FragmentReuseViolation extends Violation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentReuseViolation(Fragment fragment, String str) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str);
        i.checkNotNullParameter(fragment, "fragment");
        i.checkNotNullParameter(str, "previousFragmentId");
    }
}
