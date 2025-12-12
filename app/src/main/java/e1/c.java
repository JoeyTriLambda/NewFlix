package e1;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter.java */
/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: t, reason: collision with root package name */
    public final int f11125t;

    /* renamed from: u, reason: collision with root package name */
    public final int f11126u;

    /* renamed from: v, reason: collision with root package name */
    public final LayoutInflater f11127v;

    @Deprecated
    public c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f11126u = i10;
        this.f11125t = i10;
        this.f11127v = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // e1.a
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f11127v.inflate(this.f11126u, viewGroup, false);
    }

    @Override // e1.a
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f11127v.inflate(this.f11125t, viewGroup, false);
    }
}
