package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.unity3d.services.ads.adunit.AdUnitActivity;

/* loaded from: classes2.dex */
public final class MediaStoreRequestHandler extends e {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f10471b = {AdUnitActivity.EXTRA_ORIENTATION};

    public enum PicassoKind {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);


        /* renamed from: b, reason: collision with root package name */
        public final int f10476b;

        /* renamed from: m, reason: collision with root package name */
        public final int f10477m;

        /* renamed from: n, reason: collision with root package name */
        public final int f10478n;

        PicassoKind(int i10, int i11, int i12) {
            this.f10476b = i10;
            this.f10477m = i11;
            this.f10478n = i12;
        }
    }

    public MediaStoreRequestHandler(Context context) {
        super(context);
    }

    @Override // com.squareup.picasso.e, com.squareup.picasso.m
    public boolean canHandleRequest(k kVar) {
        Uri uri = kVar.f10584c;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[PHI: r2
  0x003d: PHI (r2v2 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v7 android.database.Cursor) binds: [B:20:0x003b, B:13:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c5  */
    @Override // com.squareup.picasso.e, com.squareup.picasso.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.squareup.picasso.m.a load(com.squareup.picasso.k r18, int r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.MediaStoreRequestHandler.load(com.squareup.picasso.k, int):com.squareup.picasso.m$a");
    }
}
