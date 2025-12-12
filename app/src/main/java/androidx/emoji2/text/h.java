package androidx.emoji2.text;

import androidx.emoji2.text.f;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: EmojiCompatInitializer.java */
/* loaded from: classes.dex */
public final class h extends f.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.h f2621a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f2622b;

    public h(f.h hVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f2621a = hVar;
        this.f2622b = threadPoolExecutor;
    }

    @Override // androidx.emoji2.text.f.h
    public void onFailed(Throwable th2) {
        ThreadPoolExecutor threadPoolExecutor = this.f2622b;
        try {
            this.f2621a.onFailed(th2);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // androidx.emoji2.text.f.h
    public void onLoaded(o oVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f2622b;
        try {
            this.f2621a.onLoaded(oVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
