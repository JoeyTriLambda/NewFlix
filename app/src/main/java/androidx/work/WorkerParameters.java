package androidx.work;

import android.net.Uri;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import w2.d;
import w2.k;
import w2.p;

/* loaded from: classes.dex */
public final class WorkerParameters {

    /* renamed from: a, reason: collision with root package name */
    public final UUID f4487a;

    /* renamed from: b, reason: collision with root package name */
    public final b f4488b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f4489c;

    /* renamed from: d, reason: collision with root package name */
    public final p f4490d;

    /* renamed from: e, reason: collision with root package name */
    public final d f4491e;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public List<String> f4492a = Collections.emptyList();

        /* renamed from: b, reason: collision with root package name */
        public List<Uri> f4493b = Collections.emptyList();
    }

    public WorkerParameters(UUID uuid, b bVar, Collection<String> collection, a aVar, int i10, int i11, Executor executor, i3.c cVar, p pVar, k kVar, d dVar) {
        this.f4487a = uuid;
        this.f4488b = bVar;
        new HashSet(collection);
        this.f4489c = executor;
        this.f4490d = pVar;
        this.f4491e = dVar;
    }

    public Executor getBackgroundExecutor() {
        return this.f4489c;
    }

    public d getForegroundUpdater() {
        return this.f4491e;
    }

    public UUID getId() {
        return this.f4487a;
    }

    public b getInputData() {
        return this.f4488b;
    }

    public p getWorkerFactory() {
        return this.f4490d;
    }
}
