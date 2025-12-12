package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import b0.k;
import java.util.ArrayList;
import n0.i;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f3803v;

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        new k();
        new Handler();
        this.f3803v = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceGroup, i10, i11);
        int i12 = R.styleable.PreferenceGroup_orderingFromXml;
        i.getBoolean(typedArrayObtainStyledAttributes, i12, i12, true);
        int i13 = R.styleable.PreferenceGroup_initialExpandedChildrenCount;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            setInitialExpandedChildrenCount(i.getInt(typedArrayObtainStyledAttributes, i13, i13, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public Preference getPreference(int i10) {
        return (Preference) this.f3803v.get(i10);
    }

    public int getPreferenceCount() {
        return this.f3803v.size();
    }

    @Override // androidx.preference.Preference
    public void notifyDependencyChange(boolean z10) {
        super.notifyDependencyChange(z10);
        int preferenceCount = getPreferenceCount();
        for (int i10 = 0; i10 < preferenceCount; i10++) {
            getPreference(i10).onParentChanged(this, z10);
        }
    }

    public void setInitialExpandedChildrenCount(int i10) {
        if (i10 == Integer.MAX_VALUE || hasKey()) {
            return;
        }
        Log.e("PreferenceGroup", getClass().getSimpleName().concat(" should have a key defined if it contains an expandable preference"));
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
