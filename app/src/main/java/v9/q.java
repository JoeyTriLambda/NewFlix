package v9;

import com.google.gson.JsonIOException;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class q implements u<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20639a;

    public q(String str) {
        this.f20639a = str;
    }

    @Override // v9.u
    public Object construct() {
        throw new JsonIOException(this.f20639a);
    }
}
