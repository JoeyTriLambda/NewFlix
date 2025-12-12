package q5;

import c5.i;
import s5.g;

/* compiled from: MetadataDecoderFactory.java */
/* loaded from: classes.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f17887a = new a();

    /* compiled from: MetadataDecoderFactory.java */
    public static class a implements c {
        @Override // q5.c
        public b createDecoder(i iVar) {
            String str = iVar.f5120q;
            str.getClass();
            switch (str) {
                case "application/id3":
                    return new g();
                case "application/x-emsg":
                    return new r5.b();
                case "application/x-scte35":
                    return new t5.c();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }

        @Override // q5.c
        public boolean supportsFormat(i iVar) {
            String str = iVar.f5120q;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str);
        }
    }

    b createDecoder(i iVar);

    boolean supportsFormat(i iVar);
}
