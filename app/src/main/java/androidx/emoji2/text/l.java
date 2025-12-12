package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.f;
import androidx.emoji2.text.l;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import u0.m;

/* compiled from: FontRequestEmojiCompatConfig.java */
/* loaded from: classes.dex */
public final class l extends f.c {

    /* renamed from: e, reason: collision with root package name */
    public static final a f2642e = new a();

    /* compiled from: FontRequestEmojiCompatConfig.java */
    public static class a {
        public Typeface buildTypeface(Context context, m.b bVar) throws PackageManager.NameNotFoundException {
            return u0.m.buildTypeface(context, null, new m.b[]{bVar});
        }

        public m.a fetchFonts(Context context, u0.g gVar) throws PackageManager.NameNotFoundException {
            return u0.m.fetchFonts(context, null, gVar);
        }

        public void unregisterObserver(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* compiled from: FontRequestEmojiCompatConfig.java */
    public static class b implements f.g {

        /* renamed from: a, reason: collision with root package name */
        public final Context f2643a;

        /* renamed from: b, reason: collision with root package name */
        public final u0.g f2644b;

        /* renamed from: c, reason: collision with root package name */
        public final a f2645c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f2646d = new Object();

        /* renamed from: e, reason: collision with root package name */
        public Handler f2647e;

        /* renamed from: f, reason: collision with root package name */
        public Executor f2648f;

        /* renamed from: g, reason: collision with root package name */
        public ThreadPoolExecutor f2649g;

        /* renamed from: h, reason: collision with root package name */
        public f.h f2650h;

        public b(Context context, u0.g gVar, a aVar) {
            w0.h.checkNotNull(context, "Context cannot be null");
            w0.h.checkNotNull(gVar, "FontRequest cannot be null");
            this.f2643a = context.getApplicationContext();
            this.f2644b = gVar;
            this.f2645c = aVar;
        }

        public final void a() {
            synchronized (this.f2646d) {
                this.f2650h = null;
                Handler handler = this.f2647e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f2647e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f2649g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f2648f = null;
                this.f2649g = null;
            }
        }

        public final void b() {
            synchronized (this.f2646d) {
                if (this.f2650h == null) {
                    return;
                }
                if (this.f2648f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f2649g = threadPoolExecutor;
                    this.f2648f = threadPoolExecutor;
                }
                final int i10 = 0;
                this.f2648f.execute(new Runnable(this) { // from class: androidx.emoji2.text.m

                    /* renamed from: m, reason: collision with root package name */
                    public final /* synthetic */ l.b f2652m;

                    {
                        this.f2652m = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i10) {
                            case 0:
                                l.b bVar = this.f2652m;
                                synchronized (bVar.f2646d) {
                                    if (bVar.f2650h == null) {
                                        return;
                                    }
                                    try {
                                        m.b bVarC = bVar.c();
                                        int resultCode = bVarC.getResultCode();
                                        if (resultCode == 2) {
                                            synchronized (bVar.f2646d) {
                                            }
                                        }
                                        if (resultCode != 0) {
                                            throw new RuntimeException("fetchFonts result is not OK. (" + resultCode + ")");
                                        }
                                        try {
                                            t0.m.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                            Typeface typefaceBuildTypeface = bVar.f2645c.buildTypeface(bVar.f2643a, bVarC);
                                            ByteBuffer byteBufferMmap = o0.m.mmap(bVar.f2643a, null, bVarC.getUri());
                                            if (byteBufferMmap == null || typefaceBuildTypeface == null) {
                                                throw new RuntimeException("Unable to open file.");
                                            }
                                            o oVarCreate = o.create(typefaceBuildTypeface, byteBufferMmap);
                                            t0.m.endSection();
                                            synchronized (bVar.f2646d) {
                                                f.h hVar = bVar.f2650h;
                                                if (hVar != null) {
                                                    hVar.onLoaded(oVarCreate);
                                                }
                                            }
                                            bVar.a();
                                            return;
                                        } catch (Throwable th2) {
                                            t0.m.endSection();
                                            throw th2;
                                        }
                                    } catch (Throwable th3) {
                                        synchronized (bVar.f2646d) {
                                            f.h hVar2 = bVar.f2650h;
                                            if (hVar2 != null) {
                                                hVar2.onFailed(th3);
                                            }
                                            bVar.a();
                                            return;
                                        }
                                    }
                                }
                            default:
                                this.f2652m.b();
                                return;
                        }
                    }
                });
            }
        }

        public final m.b c() {
            try {
                m.a aVarFetchFonts = this.f2645c.fetchFonts(this.f2643a, this.f2644b);
                if (aVarFetchFonts.getStatusCode() != 0) {
                    throw new RuntimeException("fetchFonts failed (" + aVarFetchFonts.getStatusCode() + ")");
                }
                m.b[] fonts = aVarFetchFonts.getFonts();
                if (fonts == null || fonts.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return fonts[0];
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }

        @Override // androidx.emoji2.text.f.g
        public void load(f.h hVar) {
            w0.h.checkNotNull(hVar, "LoaderCallback cannot be null");
            synchronized (this.f2646d) {
                this.f2650h = hVar;
            }
            b();
        }

        public void setExecutor(Executor executor) {
            synchronized (this.f2646d) {
                this.f2648f = executor;
            }
        }
    }

    public l(Context context, u0.g gVar) {
        super(new b(context, gVar, f2642e));
    }

    public l setLoadingExecutor(Executor executor) {
        ((b) getMetadataRepoLoader()).setExecutor(executor);
        return this;
    }
}
