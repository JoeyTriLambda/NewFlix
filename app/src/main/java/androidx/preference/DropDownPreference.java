package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* renamed from: y, reason: collision with root package name */
    public final Context f3786y;

    /* renamed from: z, reason: collision with root package name */
    public final ArrayAdapter f3787z;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dropdownPreferenceStyle);
    }

    public ArrayAdapter createAdapter() {
        return new ArrayAdapter(this.f3786y, android.R.layout.simple_spinner_dropdown_item);
    }

    @Override // androidx.preference.Preference
    public void notifyChanged() {
        super.notifyChanged();
        ArrayAdapter arrayAdapter = this.f3787z;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f3786y = context;
        ArrayAdapter arrayAdapterCreateAdapter = createAdapter();
        this.f3787z = arrayAdapterCreateAdapter;
        arrayAdapterCreateAdapter.clear();
        if (getEntries() != null) {
            for (CharSequence charSequence : getEntries()) {
                arrayAdapterCreateAdapter.add(charSequence.toString());
            }
        }
    }
}
