package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.f;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements n2.a<Boolean> {

    public static class a extends f.c {
        public a(Context context) {
            super(new b(context));
            setMetadataLoadStrategy(1);
        }
    }

    public static class b implements f.g {

        /* renamed from: a, reason: collision with root package name */
        public final Context f2590a;

        public b(Context context) {
            this.f2590a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.f.g
        public void load(f.h hVar) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.a("EmojiCompatInitializer"));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            threadPoolExecutor.execute(new g(0, this, hVar, threadPoolExecutor));
        }
    }

    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                t0.m.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (f.isConfigured()) {
                    f.get().load();
                }
            } finally {
                t0.m.endSection();
            }
        }
    }

    @Override // n2.a
    public List<Class<? extends n2.a<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // n2.a
    public Boolean create(Context context) {
        f.init(new a(context));
        final Lifecycle lifecycle = ((androidx.lifecycle.l) androidx.startup.a.getInstance(context).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.addObserver(new androidx.lifecycle.c() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.c
            public final /* synthetic */ void onCreate(androidx.lifecycle.l lVar) {
                androidx.lifecycle.b.a(this, lVar);
            }

            @Override // androidx.lifecycle.c
            public final /* synthetic */ void onDestroy(androidx.lifecycle.l lVar) {
                androidx.lifecycle.b.b(this, lVar);
            }

            @Override // androidx.lifecycle.c
            public final /* synthetic */ void onPause(androidx.lifecycle.l lVar) {
                androidx.lifecycle.b.c(this, lVar);
            }

            @Override // androidx.lifecycle.c
            public void onResume(androidx.lifecycle.l lVar) {
                EmojiCompatInitializer.this.getClass();
                (Build.VERSION.SDK_INT >= 28 ? androidx.emoji2.text.b.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new c(), 500L);
                lifecycle.removeObserver(this);
            }

            @Override // androidx.lifecycle.c
            public final /* synthetic */ void onStart(androidx.lifecycle.l lVar) {
                androidx.lifecycle.b.e(this, lVar);
            }

            @Override // androidx.lifecycle.c
            public final /* synthetic */ void onStop(androidx.lifecycle.l lVar) {
                androidx.lifecycle.b.f(this, lVar);
            }
        });
        return Boolean.TRUE;
    }
}
