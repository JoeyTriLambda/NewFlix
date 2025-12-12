package o0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import cz.msebera.android.httpclient.HttpStatus;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import n0.d;
import u0.m;

/* compiled from: TypefaceCompatBaseImpl.java */
/* loaded from: classes.dex */
public class l {

    /* compiled from: TypefaceCompatBaseImpl.java */
    public class a implements b<m.b> {
        @Override // o0.l.b
        public int getWeight(m.b bVar) {
            return bVar.getWeight();
        }

        @Override // o0.l.b
        public boolean isItalic(m.b bVar) {
            return bVar.isItalic();
        }
    }

    /* compiled from: TypefaceCompatBaseImpl.java */
    public interface b<T> {
        int getWeight(T t10);

        boolean isItalic(T t10);
    }

    public l() {
        new ConcurrentHashMap();
    }

    public static <T> T a(T[] tArr, int i10, b<T> bVar) {
        int i11 = (i10 & 1) == 0 ? HttpStatus.SC_BAD_REQUEST : 700;
        boolean z10 = (i10 & 2) != 0;
        T t10 = null;
        int i12 = Integer.MAX_VALUE;
        for (T t11 : tArr) {
            int iAbs = (Math.abs(bVar.getWeight(t11) - i11) * 2) + (bVar.isItalic(t11) == z10 ? 0 : 1);
            if (t10 == null || i12 > iAbs) {
                t10 = t11;
                i12 = iAbs;
            }
        }
        return t10;
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, d.c cVar, Resources resources, int i10) {
        throw null;
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, m.b[] bVarArr, int i10) {
        throw null;
    }

    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        File tempFile = m.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (m.copyToFile(tempFile, inputStream)) {
                return Typeface.createFromFile(tempFile.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i10, String str, int i11) {
        File tempFile = m.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (m.copyToFile(tempFile, resources, i10)) {
                return Typeface.createFromFile(tempFile.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public m.b findBestInfo(m.b[] bVarArr, int i10) {
        return (m.b) a(bVarArr, i10, new a());
    }
}
