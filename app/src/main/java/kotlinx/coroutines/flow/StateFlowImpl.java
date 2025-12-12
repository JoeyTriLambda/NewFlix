package kotlinx.coroutines.flow;

import cz.msebera.android.httpclient.HttpStatus;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kg.k1;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import lf.h;
import ng.b;
import ng.g;
import ng.m;
import og.a;
import og.j;
import pg.b0;
import qf.c;
import sf.d;
import zf.i;

/* compiled from: StateFlow.kt */
/* loaded from: classes2.dex */
public final class StateFlowImpl<T> extends a<m> implements g<T>, ng.a {

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15472p = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: o, reason: collision with root package name */
    public int f15473o;

    /* compiled from: StateFlow.kt */
    @d(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, HttpStatus.SC_UNAUTHORIZED}, m = "collect")
    /* renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: b, reason: collision with root package name */
        public StateFlowImpl f15474b;

        /* renamed from: m, reason: collision with root package name */
        public b f15475m;

        /* renamed from: n, reason: collision with root package name */
        public m f15476n;

        /* renamed from: o, reason: collision with root package name */
        public k1 f15477o;

        /* renamed from: p, reason: collision with root package name */
        public Object f15478p;

        /* renamed from: q, reason: collision with root package name */
        public /* synthetic */ Object f15479q;

        /* renamed from: r, reason: collision with root package name */
        public final /* synthetic */ StateFlowImpl<T> f15480r;

        /* renamed from: s, reason: collision with root package name */
        public int f15481s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StateFlowImpl<T> stateFlowImpl, c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.f15480r = stateFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f15479q = obj;
            this.f15481s |= Integer.MIN_VALUE;
            return this.f15480r.collect(null, this);
        }
    }

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    public final boolean a(Object obj, Object obj2) {
        int i10;
        m[] slots;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15472p;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !i.areEqual(obj3, obj)) {
                return false;
            }
            if (i.areEqual(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i11 = this.f15473o;
            if ((i11 & 1) != 0) {
                this.f15473o = i11 + 2;
                return true;
            }
            int i12 = i11 + 1;
            this.f15473o = i12;
            m[] slots2 = getSlots();
            h hVar = h.f16056a;
            while (true) {
                m[] mVarArr = slots2;
                if (mVarArr != null) {
                    for (m mVar : mVarArr) {
                        if (mVar != null) {
                            mVar.makePending();
                        }
                    }
                }
                synchronized (this) {
                    i10 = this.f15473o;
                    if (i10 == i12) {
                        this.f15473o = i12 + 1;
                        return true;
                    }
                    slots = getSlots();
                    h hVar2 = h.f16056a;
                }
                slots2 = slots;
                i12 = i10;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:38:0x009b, B:40:0x00a1], limit reached: 58 */
    /* JADX WARN: Path cross not found for [B:40:0x00a1, B:38:0x009b], limit reached: 58 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0096 A[Catch: all -> 0x005b, TryCatch #1 {all -> 0x005b, blocks: (B:14:0x0036, B:34:0x008e, B:36:0x0096, B:38:0x009b, B:48:0x00bc, B:50:0x00c2, B:40:0x00a1, B:44:0x00a8, B:19:0x004c, B:22:0x0057, B:33:0x007f), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009b A[Catch: all -> 0x005b, TryCatch #1 {all -> 0x005b, blocks: (B:14:0x0036, B:34:0x008e, B:36:0x0096, B:38:0x009b, B:48:0x00bc, B:50:0x00c2, B:40:0x00a1, B:44:0x00a8, B:19:0x004c, B:22:0x0057, B:33:0x007f), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c2 A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #1 {all -> 0x005b, blocks: (B:14:0x0036, B:34:0x008e, B:36:0x0096, B:38:0x009b, B:48:0x00bc, B:50:0x00c2, B:40:0x00a1, B:44:0x00a8, B:19:0x004c, B:22:0x0057, B:33:0x007f), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v5, types: [ng.m] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00c0 -> B:34:0x008e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00d2 -> B:34:0x008e). Please report as a decompilation issue!!! */
    @Override // ng.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(ng.b<? super T> r11, qf.c<?> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(ng.b, qf.c):java.lang.Object");
    }

    @Override // ng.g
    public boolean compareAndSet(T t10, T t11) {
        if (t10 == null) {
            t10 = (T) j.f17095a;
        }
        if (t11 == null) {
            t11 = (T) j.f17095a;
        }
        return a(t10, t11);
    }

    @Override // ng.f, ng.b
    public Object emit(T t10, c<? super h> cVar) {
        setValue(t10);
        return h.f16056a;
    }

    @Override // ng.g
    public T getValue() {
        b0 b0Var = j.f17095a;
        T t10 = (T) f15472p.get(this);
        if (t10 == b0Var) {
            return null;
        }
        return t10;
    }

    @Override // ng.g
    public void setValue(T t10) {
        if (t10 == null) {
            t10 = (T) j.f17095a;
        }
        a(null, t10);
    }

    @Override // og.a
    public m createSlot() {
        return new m();
    }

    @Override // og.a
    public m[] createSlotArray(int i10) {
        return new m[i10];
    }
}
