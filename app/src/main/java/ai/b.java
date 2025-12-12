package ai;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: GifRenderingExecutor.java */
/* loaded from: classes2.dex */
public final class b extends ScheduledThreadPoolExecutor {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f734b = 0;

    /* compiled from: GifRenderingExecutor.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f735a = new b();
    }

    public b() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }
}
