package v9;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class k implements u<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final z f20624a = z.create();

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f20625b;

    public k(Class cls) {
        this.f20625b = cls;
    }

    @Override // v9.u
    public Object construct() {
        Class cls = this.f20625b;
        try {
            return this.f20624a.newInstance(cls);
        } catch (Exception e10) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
        }
    }
}
