package v9;

import com.google.gson.JsonIOException;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class p implements u<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20638a;

    public p(String str) {
        this.f20638a = str;
    }

    @Override // v9.u
    public Object construct() {
        throw new JsonIOException(this.f20638a);
    }
}
