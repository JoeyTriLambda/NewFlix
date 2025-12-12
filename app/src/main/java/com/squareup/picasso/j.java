package com.squareup.picasso;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.o;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PicassoExecutorService.java */
/* loaded from: classes2.dex */
public final class j extends ThreadPoolExecutor {

    /* compiled from: PicassoExecutorService.java */
    public static final class a extends FutureTask<c> implements Comparable<a> {

        /* renamed from: b, reason: collision with root package name */
        public final c f10580b;

        public a(c cVar) {
            super(cVar, null);
            this.f10580b = cVar;
        }

        @Override // java.lang.Comparable
        public int compareTo(a aVar) {
            c cVar = this.f10580b;
            Picasso.Priority priority = cVar.D;
            c cVar2 = aVar.f10580b;
            Picasso.Priority priority2 = cVar2.D;
            return priority == priority2 ? cVar.f10532b - cVar2.f10532b : priority2.ordinal() - priority.ordinal();
        }
    }

    public j() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new o.b());
    }

    public final void a(int i10) {
        setCorePoolSize(i10);
        setMaximumPoolSize(i10);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        a aVar = new a((c) runnable);
        execute(aVar);
        return aVar;
    }
}
