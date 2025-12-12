package com.squareup.picasso;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.m;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/* compiled from: ResourceRequestHandler.java */
/* loaded from: classes2.dex */
public final class n extends m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10620a;

    public n(Context context) {
        this.f10620a = context;
    }

    @Override // com.squareup.picasso.m
    public boolean canHandleRequest(k kVar) {
        if (kVar.f10585d != 0) {
            return true;
        }
        return "android.resource".equals(kVar.f10584c.getScheme());
    }

    @Override // com.squareup.picasso.m
    public m.a load(k kVar, int i10) throws PackageManager.NameNotFoundException, NumberFormatException, IOException {
        Resources resources;
        int identifier;
        StringBuilder sb2 = o.f10621a;
        int i11 = kVar.f10585d;
        Uri uri = kVar.f10584c;
        Context context = this.f10620a;
        if (i11 != 0 || uri == null) {
            resources = context.getResources();
        } else {
            String authority = uri.getAuthority();
            if (authority == null) {
                throw new FileNotFoundException(ac.c.i("No package provided: ", uri));
            }
            try {
                resources = context.getPackageManager().getResourcesForApplication(authority);
            } catch (PackageManager.NameNotFoundException unused) {
                throw new FileNotFoundException(ac.c.i("Unable to obtain resources for package: ", uri));
            }
        }
        int i12 = kVar.f10585d;
        if (i12 == 0 && uri != null) {
            String authority2 = uri.getAuthority();
            if (authority2 == null) {
                throw new FileNotFoundException(ac.c.i("No package provided: ", uri));
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null || pathSegments.isEmpty()) {
                throw new FileNotFoundException(ac.c.i("No path segments: ", uri));
            }
            if (pathSegments.size() == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused2) {
                    throw new FileNotFoundException(ac.c.i("Last path segment is not a resource ID: ", uri));
                }
            } else {
                if (pathSegments.size() != 2) {
                    throw new FileNotFoundException(ac.c.i("More than two path segments: ", uri));
                }
                identifier = resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority2);
            }
            i12 = identifier;
        }
        BitmapFactory.Options optionsB = m.b(kVar);
        if (optionsB != null && optionsB.inJustDecodeBounds) {
            BitmapFactory.decodeResource(resources, i12, optionsB);
            m.a(kVar.f10587f, kVar.f10588g, optionsB.outWidth, optionsB.outHeight, optionsB, kVar);
        }
        return new m.a(BitmapFactory.decodeResource(resources, i12, optionsB), Picasso.LoadedFrom.DISK);
    }
}
