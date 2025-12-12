package androidx.datastore.preferences.protobuf;

/* compiled from: RawMessageInfo.java */
/* loaded from: classes.dex */
public final class w0 implements i0 {

    /* renamed from: a, reason: collision with root package name */
    public final k0 f2547a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2548b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f2549c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2550d;

    public w0(k0 k0Var, String str, Object[] objArr) {
        this.f2547a = k0Var;
        this.f2548b = str;
        this.f2549c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f2550d = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 < 55296) {
                this.f2550d = i10 | (cCharAt2 << i11);
                return;
            } else {
                i10 |= (cCharAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            }
        }
    }

    public final Object[] a() {
        return this.f2549c;
    }

    public final String b() {
        return this.f2548b;
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public k0 getDefaultInstance() {
        return this.f2547a;
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public ProtoSyntax getSyntax() {
        return (this.f2550d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public boolean isMessageSetWireFormat() {
        return (this.f2550d & 2) == 2;
    }
}
