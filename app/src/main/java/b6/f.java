package b6;

import java.util.List;

/* compiled from: SubtitleDecoderFactory.java */
/* loaded from: classes.dex */
public interface f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4781a = new a();

    /* compiled from: SubtitleDecoderFactory.java */
    public static class a implements f {
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public e createDecoder(c5.i iVar) {
            String str = iVar.f5120q;
            str.getClass();
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals("application/dvbsubs")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1026075066:
                    if (str.equals("application/x-mp4-vtt")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals("application/x-quicktime-tx3g")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 822864842:
                    if (str.equals("text/x-ssa")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 930165504:
                    if (str.equals("application/x-mp4-cea-608")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 1566015601:
                    if (str.equals("application/cea-608")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 1566016562:
                    if (str.equals("application/cea-708")) {
                        c10 = 7;
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        c10 = '\b';
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals("application/ttml+xml")) {
                        c10 = '\t';
                        break;
                    }
                    break;
            }
            int i10 = iVar.K;
            List<byte[]> list = iVar.f5122s;
            switch (c10) {
                case 0:
                    return new d6.a(list);
                case 1:
                    return new i6.b();
                case 2:
                    return new i6.g();
                case 3:
                    return new h6.a(list);
                case 4:
                    return new e6.a(list);
                case 5:
                case 6:
                    return new c6.a(iVar.f5120q, i10);
                case 7:
                    return new c6.c(i10);
                case '\b':
                    return new f6.a();
                case '\t':
                    return new g6.a();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }

        public boolean supportsFormat(c5.i iVar) {
            String str = iVar.f5120q;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str);
        }
    }
}
