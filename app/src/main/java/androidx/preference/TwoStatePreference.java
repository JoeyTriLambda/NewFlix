package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: v, reason: collision with root package name */
    public boolean f3809v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f3810w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f3811x;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    public boolean isChecked() {
        return this.f3809v;
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return Boolean.valueOf(typedArray.getBoolean(i10, false));
    }

    public void setChecked(boolean z10) {
        boolean z11 = this.f3809v != z10;
        if (z11 || !this.f3810w) {
            this.f3809v = z10;
            this.f3810w = true;
            persistBoolean(z10);
            if (z11) {
                notifyDependencyChange(shouldDisableDependents());
                notifyChanged();
            }
        }
    }

    public void setDisableDependentsState(boolean z10) {
        this.f3811x = z10;
    }

    public void setSummaryOff(CharSequence charSequence) {
        if (isChecked()) {
            return;
        }
        notifyChanged();
    }

    public void setSummaryOn(CharSequence charSequence) {
        if (isChecked()) {
            notifyChanged();
        }
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        return (this.f3811x ? this.f3809v : !this.f3809v) || super.shouldDisableDependents();
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
