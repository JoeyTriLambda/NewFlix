package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import n0.i;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            Boolean boolValueOf = Boolean.valueOf(z10);
            SwitchPreference switchPreference = SwitchPreference.this;
            if (switchPreference.callChangeListener(boolValueOf)) {
                switchPreference.setChecked(z10);
            } else {
                compoundButton.setChecked(!z10);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreference, i10, i11);
        setSummaryOn(i.getString(typedArrayObtainStyledAttributes, R.styleable.SwitchPreference_summaryOn, R.styleable.SwitchPreference_android_summaryOn));
        setSummaryOff(i.getString(typedArrayObtainStyledAttributes, R.styleable.SwitchPreference_summaryOff, R.styleable.SwitchPreference_android_summaryOff));
        setSwitchTextOn(i.getString(typedArrayObtainStyledAttributes, R.styleable.SwitchPreference_switchTextOn, R.styleable.SwitchPreference_android_switchTextOn));
        setSwitchTextOff(i.getString(typedArrayObtainStyledAttributes, R.styleable.SwitchPreference_switchTextOff, R.styleable.SwitchPreference_android_switchTextOff));
        setDisableDependentsState(i.getBoolean(typedArrayObtainStyledAttributes, R.styleable.SwitchPreference_disableDependentsState, R.styleable.SwitchPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setSwitchTextOff(CharSequence charSequence) {
        notifyChanged();
    }

    public void setSwitchTextOn(CharSequence charSequence) {
        notifyChanged();
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.getAttr(context, R.attr.switchPreferenceStyle, android.R.attr.switchPreferenceStyle));
    }
}
