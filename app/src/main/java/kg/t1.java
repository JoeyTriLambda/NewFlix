package kg;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    public static final pg.b0 f15153a = new pg.b0("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final pg.b0 f15154b = new pg.b0("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    public static final pg.b0 f15155c = new pg.b0("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    public static final pg.b0 f15156d = new pg.b0("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    public static final pg.b0 f15157e = new pg.b0("SEALED");

    /* renamed from: f, reason: collision with root package name */
    public static final x0 f15158f = new x0(false);

    /* renamed from: g, reason: collision with root package name */
    public static final x0 f15159g = new x0(true);

    public static final Object boxIncomplete(Object obj) {
        return obj instanceof f1 ? new g1((f1) obj) : obj;
    }

    public static final Object unboxState(Object obj) {
        f1 f1Var;
        g1 g1Var = obj instanceof g1 ? (g1) obj : null;
        return (g1Var == null || (f1Var = g1Var.f15108a) == null) ? obj : f1Var;
    }
}
