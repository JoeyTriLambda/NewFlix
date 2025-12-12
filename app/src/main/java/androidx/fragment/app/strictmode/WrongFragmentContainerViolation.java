package androidx.fragment.app.strictmode;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import zf.i;

/* compiled from: WrongFragmentContainerViolation.kt */
/* loaded from: classes.dex */
public final class WrongFragmentContainerViolation extends Violation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrongFragmentContainerViolation(Fragment fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView");
        i.checkNotNullParameter(fragment, "fragment");
        i.checkNotNullParameter(viewGroup, "container");
    }
}
