package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import cz.msebera.android.httpclient.message.TokenParser;
import n0.i;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: b, reason: collision with root package name */
    public final Context f3793b;

    /* renamed from: m, reason: collision with root package name */
    public final int f3794m;

    /* renamed from: n, reason: collision with root package name */
    public final CharSequence f3795n;

    /* renamed from: o, reason: collision with root package name */
    public final CharSequence f3796o;

    /* renamed from: p, reason: collision with root package name */
    public final String f3797p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f3798q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f3799r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3800s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3801t;

    /* renamed from: u, reason: collision with root package name */
    public a f3802u;

    public interface a<T extends Preference> {
        CharSequence provideSummary(T t10);
    }

    public Preference(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f3794m = Integer.MAX_VALUE;
        this.f3798q = true;
        this.f3800s = true;
        this.f3801t = true;
        int i12 = R.layout.preference;
        this.f3793b = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i10, i11);
        i.getResourceId(typedArrayObtainStyledAttributes, R.styleable.Preference_icon, R.styleable.Preference_android_icon, 0);
        this.f3797p = i.getString(typedArrayObtainStyledAttributes, R.styleable.Preference_key, R.styleable.Preference_android_key);
        this.f3795n = i.getText(typedArrayObtainStyledAttributes, R.styleable.Preference_title, R.styleable.Preference_android_title);
        this.f3796o = i.getText(typedArrayObtainStyledAttributes, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        this.f3794m = i.getInt(typedArrayObtainStyledAttributes, R.styleable.Preference_order, R.styleable.Preference_android_order, Integer.MAX_VALUE);
        i.getString(typedArrayObtainStyledAttributes, R.styleable.Preference_fragment, R.styleable.Preference_android_fragment);
        i.getResourceId(typedArrayObtainStyledAttributes, R.styleable.Preference_layout, R.styleable.Preference_android_layout, i12);
        i.getResourceId(typedArrayObtainStyledAttributes, R.styleable.Preference_widgetLayout, R.styleable.Preference_android_widgetLayout, 0);
        this.f3798q = i.getBoolean(typedArrayObtainStyledAttributes, R.styleable.Preference_enabled, R.styleable.Preference_android_enabled, true);
        boolean z10 = i.getBoolean(typedArrayObtainStyledAttributes, R.styleable.Preference_selectable, R.styleable.Preference_android_selectable, true);
        i.getBoolean(typedArrayObtainStyledAttributes, R.styleable.Preference_persistent, R.styleable.Preference_android_persistent, true);
        i.getString(typedArrayObtainStyledAttributes, R.styleable.Preference_dependency, R.styleable.Preference_android_dependency);
        int i13 = R.styleable.Preference_allowDividerAbove;
        i.getBoolean(typedArrayObtainStyledAttributes, i13, i13, z10);
        int i14 = R.styleable.Preference_allowDividerBelow;
        i.getBoolean(typedArrayObtainStyledAttributes, i14, i14, z10);
        int i15 = R.styleable.Preference_defaultValue;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            this.f3799r = onGetDefaultValue(typedArrayObtainStyledAttributes, i15);
        } else {
            int i16 = R.styleable.Preference_android_defaultValue;
            if (typedArrayObtainStyledAttributes.hasValue(i16)) {
                this.f3799r = onGetDefaultValue(typedArrayObtainStyledAttributes, i16);
            }
        }
        i.getBoolean(typedArrayObtainStyledAttributes, R.styleable.Preference_shouldDisableView, R.styleable.Preference_android_shouldDisableView, true);
        int i17 = R.styleable.Preference_singleLineTitle;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            i.getBoolean(typedArrayObtainStyledAttributes, i17, R.styleable.Preference_android_singleLineTitle, true);
        }
        i.getBoolean(typedArrayObtainStyledAttributes, R.styleable.Preference_iconSpaceReserved, R.styleable.Preference_android_iconSpaceReserved, false);
        int i18 = R.styleable.Preference_isPreferenceVisible;
        i.getBoolean(typedArrayObtainStyledAttributes, i18, i18, true);
        int i19 = R.styleable.Preference_enableCopying;
        i.getBoolean(typedArrayObtainStyledAttributes, i19, i19, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean callChangeListener(Object obj) {
        return true;
    }

    public Context getContext() {
        return this.f3793b;
    }

    public boolean getPersistedBoolean(boolean z10) {
        if (!shouldPersist()) {
            return z10;
        }
        getPreferenceDataStore();
        throw null;
    }

    public c2.a getPreferenceDataStore() {
        return null;
    }

    public CharSequence getSummary() {
        return getSummaryProvider() != null ? getSummaryProvider().provideSummary(this) : this.f3796o;
    }

    public final a getSummaryProvider() {
        return this.f3802u;
    }

    public CharSequence getTitle() {
        return this.f3795n;
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.f3797p);
    }

    public boolean isEnabled() {
        return this.f3798q && this.f3800s && this.f3801t;
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return null;
    }

    public void onParentChanged(Preference preference, boolean z10) {
        if (this.f3801t == z10) {
            this.f3801t = !z10;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public boolean persistBoolean(boolean z10) {
        if (!shouldPersist()) {
            return false;
        }
        if (z10 == getPersistedBoolean(!z10)) {
            return true;
        }
        getPreferenceDataStore();
        throw null;
    }

    public final void setSummaryProvider(a aVar) {
        this.f3802u = aVar;
        notifyChanged();
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public boolean shouldPersist() {
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb2.append(title);
            sb2.append(TokenParser.SP);
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb2.append(summary);
            sb2.append(TokenParser.SP);
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Preference preference) {
        int i10 = preference.f3794m;
        int i11 = this.f3794m;
        if (i11 != i10) {
            return i11 - i10;
        }
        CharSequence charSequence = preference.f3795n;
        CharSequence charSequence2 = this.f3795n;
        if (charSequence2 == charSequence) {
            return 0;
        }
        if (charSequence2 == null) {
            return 1;
        }
        if (charSequence == null) {
            return -1;
        }
        return charSequence2.toString().compareToIgnoreCase(charSequence.toString());
    }

    public void notifyChanged() {
    }

    public void notifyDependencyChange(boolean z10) {
    }

    public void setLayoutResource(int i10) {
    }

    public void setWidgetLayoutResource(int i10) {
    }

    public Preference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.getAttr(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }
}
