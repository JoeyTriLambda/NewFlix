package b8;

import java.util.Arrays;

/* compiled from: MoreObjects.java */
/* loaded from: classes.dex */
public final class c {
    public static <T> T firstNonNull(T t10, T t11) {
        if (t10 != null) {
            return t10;
        }
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static a toStringHelper(Object obj) {
        return new a(obj.getClass().getSimpleName());
    }

    /* compiled from: MoreObjects.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f4792a;

        /* renamed from: b, reason: collision with root package name */
        public final b f4793b;

        /* renamed from: c, reason: collision with root package name */
        public b f4794c;

        /* compiled from: MoreObjects.java */
        /* renamed from: b8.c$a$a, reason: collision with other inner class name */
        public static final class C0054a extends b {
        }

        /* compiled from: MoreObjects.java */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public String f4795a;

            /* renamed from: b, reason: collision with root package name */
            public Object f4796b;

            /* renamed from: c, reason: collision with root package name */
            public b f4797c;
        }

        public a(String str) {
            b bVar = new b();
            this.f4793b = bVar;
            this.f4794c = bVar;
            this.f4792a = (String) e.checkNotNull(str);
        }

        public a add(String str, int i10) {
            String strValueOf = String.valueOf(i10);
            C0054a c0054a = new C0054a();
            this.f4794c.f4797c = c0054a;
            this.f4794c = c0054a;
            c0054a.f4796b = strValueOf;
            c0054a.f4795a = (String) e.checkNotNull(str);
            return this;
        }

        public a addValue(Object obj) {
            b bVar = new b();
            this.f4794c.f4797c = bVar;
            this.f4794c = bVar;
            bVar.f4796b = obj;
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f4792a);
            sb2.append('{');
            b bVar = this.f4793b.f4797c;
            String str = "";
            while (bVar != null) {
                Object obj = bVar.f4796b;
                boolean z10 = bVar instanceof C0054a;
                sb2.append(str);
                String str2 = bVar.f4795a;
                if (str2 != null) {
                    sb2.append(str2);
                    sb2.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb2.append(obj);
                } else {
                    String strDeepToString = Arrays.deepToString(new Object[]{obj});
                    sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                }
                bVar = bVar.f4797c;
                str = ", ";
            }
            sb2.append('}');
            return sb2.toString();
        }

        public a add(String str, Object obj) {
            b bVar = new b();
            this.f4794c.f4797c = bVar;
            this.f4794c = bVar;
            bVar.f4796b = obj;
            bVar.f4795a = (String) e.checkNotNull(str);
            return this;
        }
    }
}
