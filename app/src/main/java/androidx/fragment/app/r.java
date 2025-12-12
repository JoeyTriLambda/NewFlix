package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* compiled from: FragmentContainer.java */
/* loaded from: classes.dex */
public abstract class r {
    @Deprecated
    public Fragment instantiate(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }

    public abstract View onFindViewById(int i10);

    public abstract boolean onHasView();
}
