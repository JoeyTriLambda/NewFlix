package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: Action.java */
/* loaded from: classes2.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Picasso f10516a;

    /* renamed from: b, reason: collision with root package name */
    public final k f10517b;

    /* renamed from: c, reason: collision with root package name */
    public final C0115a f10518c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f10519d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10520e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10521f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10522g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f10523h;

    /* renamed from: i, reason: collision with root package name */
    public final String f10524i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f10525j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10526k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10527l;

    /* compiled from: Action.java */
    /* renamed from: com.squareup.picasso.a$a, reason: collision with other inner class name */
    public static class C0115a<M> extends WeakReference<M> {

        /* renamed from: a, reason: collision with root package name */
        public final a f10528a;

        public C0115a(a aVar, M m10, ReferenceQueue<? super M> referenceQueue) {
            super(m10, referenceQueue);
            this.f10528a = aVar;
        }
    }

    public a(Picasso picasso, Object obj, k kVar, int i10, String str) {
        this.f10516a = picasso;
        this.f10517b = kVar;
        this.f10518c = obj == null ? null : new C0115a(this, obj, picasso.f10494i);
        this.f10520e = 0;
        this.f10521f = 0;
        this.f10519d = false;
        this.f10522g = i10;
        this.f10523h = null;
        this.f10524i = str;
        this.f10525j = this;
    }

    public void a() {
        this.f10527l = true;
    }

    public final T b() {
        C0115a c0115a = this.f10518c;
        if (c0115a == null) {
            return null;
        }
        return (T) c0115a.get();
    }

    public abstract void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom);

    public abstract void error(Exception exc);
}
