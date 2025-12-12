package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import n0.i;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, i.getAttr(context, R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle));
    }
}
