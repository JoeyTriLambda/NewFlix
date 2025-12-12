package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
import n0.i;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    public static final class a implements Preference.a<EditTextPreference> {

        /* renamed from: a, reason: collision with root package name */
        public static a f3788a;

        public static a getInstance() {
            if (f3788a == null) {
                f3788a = new a();
            }
            return f3788a;
        }

        @Override // androidx.preference.Preference.a
        public CharSequence provideSummary(EditTextPreference editTextPreference) {
            return TextUtils.isEmpty(editTextPreference.getText()) ? editTextPreference.getContext().getString(R.string.not_set) : editTextPreference.getText();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditTextPreference, i10, i11);
        int i12 = R.styleable.EditTextPreference_useSimpleSummaryProvider;
        if (i.getBoolean(typedArrayObtainStyledAttributes, i12, i12, false)) {
            setSummaryProvider(a.getInstance());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public String getText() {
        return null;
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(null) || super.shouldDisableDependents();
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.getAttr(context, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle));
    }
}
