package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import n0.i;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: v, reason: collision with root package name */
    public final CharSequence[] f3789v;

    /* renamed from: w, reason: collision with root package name */
    public final CharSequence[] f3790w;

    /* renamed from: x, reason: collision with root package name */
    public final String f3791x;

    public static final class a implements Preference.a<ListPreference> {

        /* renamed from: a, reason: collision with root package name */
        public static a f3792a;

        public static a getInstance() {
            if (f3792a == null) {
                f3792a = new a();
            }
            return f3792a;
        }

        @Override // androidx.preference.Preference.a
        public CharSequence provideSummary(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.getEntry()) ? listPreference.getContext().getString(R.string.not_set) : listPreference.getEntry();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPreference, i10, i11);
        this.f3789v = i.getTextArray(typedArrayObtainStyledAttributes, R.styleable.ListPreference_entries, R.styleable.ListPreference_android_entries);
        this.f3790w = i.getTextArray(typedArrayObtainStyledAttributes, R.styleable.ListPreference_entryValues, R.styleable.ListPreference_android_entryValues);
        int i12 = R.styleable.ListPreference_useSimpleSummaryProvider;
        if (i.getBoolean(typedArrayObtainStyledAttributes, i12, i12, false)) {
            setSummaryProvider(a.getInstance());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i10, i11);
        this.f3791x = i.getString(typedArrayObtainStyledAttributes2, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public int findIndexOfValue(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f3790w) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (charSequenceArr[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] getEntries() {
        return this.f3789v;
    }

    public CharSequence getEntry() {
        CharSequence[] charSequenceArr;
        int iFindIndexOfValue = findIndexOfValue(null);
        if (iFindIndexOfValue < 0 || (charSequenceArr = this.f3789v) == null) {
            return null;
        }
        return charSequenceArr[iFindIndexOfValue];
    }

    @Override // androidx.preference.Preference
    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().provideSummary(this);
        }
        CharSequence entry = getEntry();
        CharSequence summary = super.getSummary();
        String str = this.f3791x;
        if (str == null) {
            return summary;
        }
        Object[] objArr = new Object[1];
        if (entry == null) {
            entry = "";
        }
        objArr[0] = entry;
        String str2 = String.format(str, objArr);
        if (TextUtils.equals(str2, summary)) {
            return summary;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return str2;
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.getAttr(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
