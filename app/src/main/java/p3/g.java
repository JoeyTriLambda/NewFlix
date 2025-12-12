package p3;

import android.graphics.Bitmap;

/* compiled from: LottieImageAsset.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f17501a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17502b;

    /* renamed from: c, reason: collision with root package name */
    public final String f17503c;

    /* renamed from: d, reason: collision with root package name */
    public final String f17504d;

    /* renamed from: e, reason: collision with root package name */
    public Bitmap f17505e;

    public g(int i10, int i11, String str, String str2, String str3) {
        this.f17501a = i10;
        this.f17502b = i11;
        this.f17503c = str;
        this.f17504d = str2;
    }

    public Bitmap getBitmap() {
        return this.f17505e;
    }

    public String getFileName() {
        return this.f17504d;
    }

    public int getHeight() {
        return this.f17502b;
    }

    public String getId() {
        return this.f17503c;
    }

    public int getWidth() {
        return this.f17501a;
    }

    public void setBitmap(Bitmap bitmap) {
        this.f17505e = bitmap;
    }
}
