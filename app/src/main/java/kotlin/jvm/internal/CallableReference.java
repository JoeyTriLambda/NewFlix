package kotlin.jvm.internal;

import gg.a;
import gg.c;
import java.io.Serializable;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import zf.k;

/* loaded from: classes2.dex */
public abstract class CallableReference implements a, Serializable {

    /* renamed from: r, reason: collision with root package name */
    public static final Object f15248r = NoReceiver.f15255b;

    /* renamed from: b, reason: collision with root package name */
    public transient a f15249b;

    /* renamed from: m, reason: collision with root package name */
    public final Object f15250m;

    /* renamed from: n, reason: collision with root package name */
    public final Class f15251n;

    /* renamed from: o, reason: collision with root package name */
    public final String f15252o;

    /* renamed from: p, reason: collision with root package name */
    public final String f15253p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f15254q;

    public static class NoReceiver implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public static final NoReceiver f15255b = new NoReceiver();

        private NoReceiver() {
        }
    }

    public CallableReference() {
        this(f15248r);
    }

    public a compute() {
        a aVar = this.f15249b;
        if (aVar != null) {
            return aVar;
        }
        a aVarComputeReflected = computeReflected();
        this.f15249b = aVarComputeReflected;
        return aVarComputeReflected;
    }

    public abstract a computeReflected();

    public Object getBoundReceiver() {
        return this.f15250m;
    }

    public String getName() {
        return this.f15252o;
    }

    public c getOwner() {
        Class cls = this.f15251n;
        if (cls == null) {
            return null;
        }
        return this.f15254q ? k.getOrCreateKotlinPackage(cls) : k.getOrCreateKotlinClass(cls);
    }

    public a getReflected() {
        a aVarCompute = compute();
        if (aVarCompute != this) {
            return aVarCompute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public String getSignature() {
        return this.f15253p;
    }

    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z10) {
        this.f15250m = obj;
        this.f15251n = cls;
        this.f15252o = str;
        this.f15253p = str2;
        this.f15254q = z10;
    }
}
