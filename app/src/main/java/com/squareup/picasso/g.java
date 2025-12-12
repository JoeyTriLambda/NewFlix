package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.m;
import java.io.IOException;

/* compiled from: FileRequestHandler.java */
/* loaded from: classes2.dex */
public final class g extends e {
    public g(Context context) {
        super(context);
    }

    @Override // com.squareup.picasso.e, com.squareup.picasso.m
    public boolean canHandleRequest(k kVar) {
        return "file".equals(kVar.f10584c.getScheme());
    }

    @Override // com.squareup.picasso.e, com.squareup.picasso.m
    public m.a load(k kVar, int i10) throws IOException {
        return new m.a(null, ah.m.source(e(kVar)), Picasso.LoadedFrom.DISK, new o1.b(kVar.f10584c.getPath()).getAttributeInt("Orientation", 1));
    }
}
