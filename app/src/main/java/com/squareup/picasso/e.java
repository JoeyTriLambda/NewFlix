package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.m;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentStreamRequestHandler.java */
/* loaded from: classes2.dex */
public class e extends m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10554a;

    public e(Context context) {
        this.f10554a = context;
    }

    @Override // com.squareup.picasso.m
    public boolean canHandleRequest(k kVar) {
        return "content".equals(kVar.f10584c.getScheme());
    }

    public final InputStream e(k kVar) throws FileNotFoundException {
        return this.f10554a.getContentResolver().openInputStream(kVar.f10584c);
    }

    @Override // com.squareup.picasso.m
    public m.a load(k kVar, int i10) throws IOException {
        return new m.a(ah.m.source(e(kVar)), Picasso.LoadedFrom.DISK);
    }
}
