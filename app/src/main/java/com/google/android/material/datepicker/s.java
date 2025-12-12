package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* compiled from: MaterialTextInputPicker.java */
/* loaded from: classes.dex */
public final class s<S> extends x<S> {

    /* renamed from: i0, reason: collision with root package name */
    public int f9084i0;

    /* renamed from: j0, reason: collision with root package name */
    public d<S> f9085j0;

    /* renamed from: k0, reason: collision with root package name */
    public com.google.android.material.datepicker.a f9086k0;

    /* compiled from: MaterialTextInputPicker.java */
    public class a extends w<S> {
        public a() {
        }

        @Override // com.google.android.material.datepicker.w
        public void onSelectionChanged(S s10) {
            Iterator<w<S>> it = s.this.f9112h0.iterator();
            while (it.hasNext()) {
                it.next().onSelectionChanged(s10);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f9084i0 = bundle.getInt("THEME_RES_ID_KEY");
        this.f9085j0 = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f9086k0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f9085j0.onCreateTextInputView(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f9084i0)), viewGroup, bundle, this.f9086k0, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f9084i0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f9085j0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f9086k0);
    }
}
