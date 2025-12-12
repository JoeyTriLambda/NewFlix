package sa;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.LruCache;
import com.squareup.picasso.o;

/* compiled from: LruCache.java */
/* loaded from: classes2.dex */
public final class e implements sa.a {

    /* renamed from: a, reason: collision with root package name */
    public final a f19185a;

    /* compiled from: LruCache.java */
    public class a extends LruCache<String, b> {
        public a(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        public int sizeOf(String str, b bVar) {
            return bVar.f19187b;
        }
    }

    /* compiled from: LruCache.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f19186a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19187b;

        public b(Bitmap bitmap, int i10) {
            this.f19186a = bitmap;
            this.f19187b = i10;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e(Context context) {
        StringBuilder sb2 = o.f10621a;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this((int) ((((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass()) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) / 7));
    }

    public Bitmap get(String str) {
        b bVar = this.f19185a.get(str);
        if (bVar != null) {
            return bVar.f19186a;
        }
        return null;
    }

    public int maxSize() {
        return this.f19185a.maxSize();
    }

    public void set(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        StringBuilder sb2 = o.f10621a;
        int allocationByteCount = bitmap.getAllocationByteCount();
        if (allocationByteCount < 0) {
            throw new IllegalStateException("Negative size: " + bitmap);
        }
        int iMaxSize = maxSize();
        a aVar = this.f19185a;
        if (allocationByteCount > iMaxSize) {
            aVar.remove(str);
        } else {
            aVar.put(str, new b(bitmap, allocationByteCount));
        }
    }

    public int size() {
        return this.f19185a.size();
    }

    public e(int i10) {
        this.f19185a = new a(i10);
    }
}
