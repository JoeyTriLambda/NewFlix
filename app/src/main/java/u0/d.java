package u0;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Comparator;
import t8.f0;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19931b;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f19931b) {
            case 0:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i10 = 0; i10 < bArr.length; i10++) {
                    byte b10 = bArr[i10];
                    byte b11 = bArr2[i10];
                    if (b10 != b11) {
                        return b10 - b11;
                    }
                }
                return 0;
            case 1:
                return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
            case 2:
                return ((f0.c) obj).getKey().compareTo(((f0.c) obj2).getKey());
            case 3:
                Charset charset = w8.a.f21028e;
                String name = ((File) obj).getName();
                int i11 = w8.a.f21029f;
                return name.substring(0, i11).compareTo(((File) obj2).getName().substring(0, i11));
            default:
                Charset charset2 = w8.a.f21028e;
                return ((File) obj2).getName().compareTo(((File) obj).getName());
        }
    }
}
