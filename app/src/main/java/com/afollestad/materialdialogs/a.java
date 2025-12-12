package com.afollestad.materialdialogs;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import com.afollestad.materialdialogs.MaterialDialog;
import n3.c;

/* compiled from: DefaultAdapter.java */
/* loaded from: classes.dex */
public final class a extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final MaterialDialog f5339b;

    /* renamed from: m, reason: collision with root package name */
    public final int f5340m;

    public a(MaterialDialog materialDialog, int i10) {
        this.f5339b = materialDialog;
        this.f5340m = i10;
        GravityEnum gravityEnum = materialDialog.f5289n.f5315f;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        this.f5339b.f5289n.getClass();
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        this.f5339b.f5289n.getClass();
        throw null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongViewCast"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        MaterialDialog materialDialog = this.f5339b;
        if (view == null) {
            view = LayoutInflater.from(materialDialog.getContext()).inflate(this.f5340m, viewGroup, false);
        }
        int iOrdinal = materialDialog.B.ordinal();
        if (iOrdinal == 1) {
            RadioButton radioButton = (RadioButton) view.findViewById(R.id.control);
            MaterialDialog.c cVar = materialDialog.f5289n;
            boolean z10 = cVar.A == i10;
            c.setTint(radioButton, cVar.f5324o);
            radioButton.setChecked(z10);
        } else if (iOrdinal == 2) {
            materialDialog.getClass();
            throw null;
        }
        materialDialog.f5289n.getClass();
        throw null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
