package kg;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public class m1 extends r1 implements x {

    /* renamed from: n, reason: collision with root package name */
    public final boolean f15127n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(k1 k1Var) {
        r1 job;
        super(true);
        boolean z10 = true;
        initParentJob(k1Var);
        r parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        s sVar = parentHandle$kotlinx_coroutines_core instanceof s ? (s) parentHandle$kotlinx_coroutines_core : null;
        if (sVar == null || (job = sVar.getJob()) == null) {
            z10 = false;
            break;
        }
        while (!job.getHandlesException$kotlinx_coroutines_core()) {
            r parentHandle$kotlinx_coroutines_core2 = job.getParentHandle$kotlinx_coroutines_core();
            s sVar2 = parentHandle$kotlinx_coroutines_core2 instanceof s ? (s) parentHandle$kotlinx_coroutines_core2 : null;
            if (sVar2 == null || (job = sVar2.getJob()) == null) {
                z10 = false;
                break;
            }
        }
        this.f15127n = z10;
    }

    @Override // kg.r1
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.f15127n;
    }

    @Override // kg.r1
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
