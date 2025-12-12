package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import zf.i;

/* compiled from: GetTargetFragmentUsageViolation.kt */
/* loaded from: classes.dex */
public final class GetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTargetFragmentUsageViolation(Fragment fragment) {
        super(fragment, "Attempting to get target fragment from fragment " + fragment);
        i.checkNotNullParameter(fragment, "fragment");
    }
}
