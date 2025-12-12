package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* compiled from: PickerFragment.java */
/* loaded from: classes.dex */
public abstract class x<S> extends Fragment {

    /* renamed from: h0, reason: collision with root package name */
    public final LinkedHashSet<w<S>> f9112h0 = new LinkedHashSet<>();

    public boolean addOnSelectionChangedListener(w<S> wVar) {
        return this.f9112h0.add(wVar);
    }
}
