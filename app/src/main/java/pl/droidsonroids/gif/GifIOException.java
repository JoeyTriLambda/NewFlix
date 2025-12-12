package pl.droidsonroids.gif;

import java.io.IOException;
import java.util.Locale;

/* loaded from: classes2.dex */
public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;

    /* renamed from: b, reason: collision with root package name */
    public final GifError f17744b;

    /* renamed from: m, reason: collision with root package name */
    public final String f17745m;

    public GifIOException(int i10, String str) {
        GifError gifError;
        GifError[] gifErrorArrValues = GifError.values();
        int length = gifErrorArrValues.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                gifError = GifError.f17740o;
                gifError.f17743m = i10;
                break;
            } else {
                gifError = gifErrorArrValues[i11];
                if (gifError.f17743m == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        this.f17744b = gifError;
        this.f17745m = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        GifError gifError = this.f17744b;
        String str = this.f17745m;
        if (str == null) {
            gifError.getClass();
            return String.format(Locale.ENGLISH, "GifError %d: %s", Integer.valueOf(gifError.f17743m), gifError.f17742b);
        }
        StringBuilder sb2 = new StringBuilder();
        gifError.getClass();
        sb2.append(String.format(Locale.ENGLISH, "GifError %d: %s", Integer.valueOf(gifError.f17743m), gifError.f17742b));
        sb2.append(": ");
        sb2.append(str);
        return sb2.toString();
    }
}
