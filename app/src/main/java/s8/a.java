package s8;

import java.io.IOException;

/* compiled from: AutoRolloutAssignmentEncoder.java */
/* loaded from: classes.dex */
public final class a implements c9.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19119a = new a();

    /* compiled from: AutoRolloutAssignmentEncoder.java */
    /* renamed from: s8.a$a, reason: collision with other inner class name */
    public static final class C0248a implements b9.d<k> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0248a f19120a = new C0248a();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19121b = b9.c.of("rolloutId");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19122c = b9.c.of("parameterKey");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19123d = b9.c.of("parameterValue");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19124e = b9.c.of("variantId");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19125f = b9.c.of("templateVersion");

        @Override // b9.b
        public void encode(k kVar, b9.e eVar) throws IOException {
            eVar.add(f19121b, kVar.getRolloutId());
            eVar.add(f19122c, kVar.getParameterKey());
            eVar.add(f19123d, kVar.getParameterValue());
            eVar.add(f19124e, kVar.getVariantId());
            eVar.add(f19125f, kVar.getTemplateVersion());
        }
    }

    @Override // c9.a
    public void configure(c9.b<?> bVar) {
        C0248a c0248a = C0248a.f19120a;
        bVar.registerEncoder(k.class, c0248a);
        bVar.registerEncoder(b.class, c0248a);
    }
}
