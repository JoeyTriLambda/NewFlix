package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.m;
import java.io.IOException;

/* compiled from: AssetRequestHandler.java */
/* loaded from: classes2.dex */
public final class b extends m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10529a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10530b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public AssetManager f10531c;

    public b(Context context) {
        this.f10529a = context;
    }

    @Override // com.squareup.picasso.m
    public boolean canHandleRequest(k kVar) {
        Uri uri = kVar.f10584c;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // com.squareup.picasso.m
    public m.a load(k kVar, int i10) throws IOException {
        if (this.f10531c == null) {
            synchronized (this.f10530b) {
                if (this.f10531c == null) {
                    this.f10531c = this.f10529a.getAssets();
                }
            }
        }
        return new m.a(ah.m.source(this.f10531c.open(kVar.f10584c.toString().substring(22))), Picasso.LoadedFrom.DISK);
    }
}
