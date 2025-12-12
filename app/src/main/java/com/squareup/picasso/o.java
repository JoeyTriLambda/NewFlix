package com.squareup.picasso;

import android.os.Process;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.ThreadFactory;
import okio.ByteString;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final StringBuilder f10621a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f10622b = ByteString.encodeUtf8("RIFF");

    /* renamed from: c, reason: collision with root package name */
    public static final ByteString f10623c = ByteString.encodeUtf8("WEBP");

    /* compiled from: Utils.java */
    public static class a extends Thread {
        public a(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* compiled from: Utils.java */
    public static class b implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new a(runnable);
        }
    }

    public static String a(c cVar) {
        return b(cVar, "");
    }

    public static String b(c cVar, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        com.squareup.picasso.a aVar = cVar.f10542v;
        if (aVar != null) {
            sb2.append(aVar.f10517b.a());
        }
        ArrayList arrayList = cVar.f10543w;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (i10 > 0 || aVar != null) {
                    sb2.append(", ");
                }
                sb2.append(((com.squareup.picasso.a) arrayList.get(i10)).f10517b.a());
            }
        }
        return sb2.toString();
    }

    public static void c(String str, String str2, String str3) {
        d(str, str2, str3, "");
    }

    public static void d(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }
}
