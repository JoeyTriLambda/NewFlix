package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: v, reason: collision with root package name */
    public final int f3804v;

    /* renamed from: w, reason: collision with root package name */
    public int f3805w;

    /* renamed from: x, reason: collision with root package name */
    public int f3806x;

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBarPreference, i10, i11);
        this.f3804v = typedArrayObtainStyledAttributes.getInt(R.styleable.SeekBarPreference_min, 0);
        setMax(typedArrayObtainStyledAttributes.getInt(R.styleable.SeekBarPreference_android_max, 100));
        setSeekBarIncrement(typedArrayObtainStyledAttributes.getInt(R.styleable.SeekBarPreference_seekBarIncrement, 0));
        typedArrayObtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_adjustable, true);
        typedArrayObtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_showSeekBarValue, false);
        typedArrayObtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_updatesContinuously, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return Integer.valueOf(typedArray.getInt(i10, 0));
    }

    public final void setMax(int i10) {
        int i11 = this.f3804v;
        if (i10 < i11) {
            i10 = i11;
        }
        if (i10 != this.f3805w) {
            this.f3805w = i10;
            notifyChanged();
        }
    }

    public final void setSeekBarIncrement(int i10) {
        if (i10 != this.f3806x) {
            this.f3806x = Math.min(this.f3805w - this.f3804v, Math.abs(i10));
            notifyChanged();
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarPreferenceStyle);
    }
}
