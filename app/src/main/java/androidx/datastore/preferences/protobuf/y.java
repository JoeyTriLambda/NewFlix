package androidx.datastore.preferences.protobuf;

/* compiled from: LazyFieldLite.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public volatile k0 f2553a;

    /* renamed from: b, reason: collision with root package name */
    public volatile ByteString f2554b;

    static {
        n.getEmptyRegistry();
    }

    public void ensureInitialized(k0 k0Var) {
        if (this.f2553a != null) {
            return;
        }
        synchronized (this) {
            if (this.f2553a != null) {
                return;
            }
            try {
                this.f2553a = k0Var;
                this.f2554b = ByteString.f2316m;
            } catch (InvalidProtocolBufferException unused) {
                this.f2553a = k0Var;
                this.f2554b = ByteString.f2316m;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        k0 k0Var = this.f2553a;
        k0 k0Var2 = yVar.f2553a;
        return (k0Var == null && k0Var2 == null) ? toByteString().equals(yVar.toByteString()) : (k0Var == null || k0Var2 == null) ? k0Var != null ? k0Var.equals(yVar.getValue(k0Var.getDefaultInstanceForType())) : getValue(k0Var2.getDefaultInstanceForType()).equals(k0Var2) : k0Var.equals(k0Var2);
    }

    public int getSerializedSize() {
        if (this.f2554b != null) {
            return this.f2554b.size();
        }
        if (this.f2553a != null) {
            return this.f2553a.getSerializedSize();
        }
        return 0;
    }

    public k0 getValue(k0 k0Var) {
        ensureInitialized(k0Var);
        return this.f2553a;
    }

    public int hashCode() {
        return 1;
    }

    public k0 setValue(k0 k0Var) {
        k0 k0Var2 = this.f2553a;
        this.f2554b = null;
        this.f2553a = k0Var;
        return k0Var2;
    }

    public ByteString toByteString() {
        if (this.f2554b != null) {
            return this.f2554b;
        }
        synchronized (this) {
            if (this.f2554b != null) {
                return this.f2554b;
            }
            if (this.f2553a == null) {
                this.f2554b = ByteString.f2316m;
            } else {
                this.f2554b = this.f2553a.toByteString();
            }
            return this.f2554b;
        }
    }
}
