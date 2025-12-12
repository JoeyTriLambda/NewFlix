package o0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import cz.msebera.android.httpclient.HttpStatus;
import java.io.IOException;
import java.io.InputStream;
import n0.d;
import u0.m;

/* compiled from: TypefaceCompatApi29Impl.java */
/* loaded from: classes.dex */
public final class k extends l {
    public static Font b(FontFamily fontFamily, int i10) {
        FontStyle fontStyle = new FontStyle((i10 & 1) != 0 ? 700 : HttpStatus.SC_BAD_REQUEST, (i10 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iC = c(fontStyle, font.getStyle());
        for (int i11 = 1; i11 < fontFamily.getSize(); i11++) {
            Font font2 = fontFamily.getFont(i11);
            int iC2 = c(fontStyle, font2.getStyle());
            if (iC2 < iC) {
                font = font2;
                iC = iC2;
            }
        }
        return font;
    }

    public static int c(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // o0.l
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, d.c cVar, Resources resources, int i10) throws IOException {
        try {
            FontFamily.Builder builder = null;
            for (d.C0204d c0204d : cVar.getEntries()) {
                try {
                    Font fontBuild = new Font.Builder(resources, c0204d.getResourceId()).setWeight(c0204d.getWeight()).setSlant(c0204d.isItalic() ? 1 : 0).setTtcIndex(c0204d.getTtcIndex()).setFontVariationSettings(c0204d.getVariationSettings()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(b(fontFamilyBuild, i10).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // o0.l
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, m.b[] bVarArr, int i10) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (m.b bVar : bVarArr) {
                try {
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(bVar.getUri(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                    }
                } else {
                    try {
                        Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(bVar.getWeight()).setSlant(bVar.isItalic() ? 1 : 0).setTtcIndex(bVar.getTtcIndex()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(fontBuild);
                        } else {
                            builder.addFont(fontBuild);
                        }
                    } catch (Throwable th2) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
                parcelFileDescriptorOpenFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(b(fontFamilyBuild, i10).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // o0.l
    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // o0.l
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i10, String str, int i11) throws IOException {
        try {
            Font fontBuild = new Font.Builder(resources, i10).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // o0.l
    public m.b findBestInfo(m.b[] bVarArr, int i10) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
