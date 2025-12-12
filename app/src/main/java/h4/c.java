package h4;

import android.content.Context;
import android.util.Log;
import h4.b;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: ReLinkerInstance.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f12910a;

    /* renamed from: b, reason: collision with root package name */
    public final b.InterfaceC0160b f12911b;

    /* renamed from: c, reason: collision with root package name */
    public final b.a f12912c;

    /* compiled from: ReLinkerInstance.java */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f12913b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f12914m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f12915n;

        public a(Context context, String str, String str2) {
            this.f12913b = context;
            this.f12914m = str;
            this.f12915n = str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r5 = this;
                r0 = 0
                h4.c r1 = h4.c.this     // Catch: com.getkeepsafe.relinker.MissingLibraryException -> Ld java.lang.UnsatisfiedLinkError -> Le
                android.content.Context r2 = r5.f12913b     // Catch: com.getkeepsafe.relinker.MissingLibraryException -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r3 = r5.f12914m     // Catch: com.getkeepsafe.relinker.MissingLibraryException -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r4 = r5.f12915n     // Catch: com.getkeepsafe.relinker.MissingLibraryException -> Ld java.lang.UnsatisfiedLinkError -> Le
                r1.a(r2, r3, r4)     // Catch: com.getkeepsafe.relinker.MissingLibraryException -> Ld java.lang.UnsatisfiedLinkError -> Le
                throw r0
            Ld:
                throw r0
            Le:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: h4.c.a.run():void");
        }
    }

    /* compiled from: ReLinkerInstance.java */
    public class b implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12917a;

        public b(String str) {
            this.f12917a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f12917a);
        }
    }

    public c() {
        this(new d(), new h4.a());
    }

    public final void a(Context context, String str, String str2) {
        b.InterfaceC0160b interfaceC0160b = this.f12911b;
        HashSet hashSet = this.f12910a;
        if (hashSet.contains(str)) {
            log("%s already loaded previously!", str);
            return;
        }
        try {
            ((d) interfaceC0160b).loadLibrary(str);
            hashSet.add(str);
            log("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e10) {
            log("Loading the library normally failed: %s", Log.getStackTraceString(e10));
            log("%s (%s) was not loaded normally, re-linking...", str, str2);
            File workaroundLibFile = getWorkaroundLibFile(context, str, str2);
            if (!workaroundLibFile.exists()) {
                cleanupOldLibFiles(context, str, str2);
                d dVar = (d) interfaceC0160b;
                ((h4.a) this.f12912c).installLibrary(context, dVar.supportedAbis(), dVar.mapLibraryName(str), workaroundLibFile, this);
            }
            ((d) interfaceC0160b).loadPath(workaroundLibFile.getAbsolutePath());
            hashSet.add(str);
            log("%s (%s) was re-linked!", str, str2);
        }
    }

    public void cleanupOldLibFiles(Context context, String str, String str2) {
        File workaroundLibDir = getWorkaroundLibDir(context);
        File workaroundLibFile = getWorkaroundLibFile(context, str, str2);
        File[] fileArrListFiles = workaroundLibDir.listFiles(new b(((d) this.f12911b).mapLibraryName(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (!file.getAbsolutePath().equals(workaroundLibFile.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public File getWorkaroundLibDir(Context context) {
        return context.getDir("lib", 0);
    }

    public File getWorkaroundLibFile(Context context, String str, String str2) {
        String strMapLibraryName = ((d) this.f12911b).mapLibraryName(str);
        return e.isEmpty(str2) ? new File(getWorkaroundLibDir(context), strMapLibraryName) : new File(getWorkaroundLibDir(context), ac.c.C(strMapLibraryName, ".", str2));
    }

    public void loadLibrary(Context context, String str, String str2, b.c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (e.isEmpty(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        log("Beginning load of %s...", str);
        if (cVar == null) {
            a(context, str, str2);
        } else {
            new Thread(new a(context, str, str2)).start();
        }
    }

    public void log(String str) {
    }

    public c(b.InterfaceC0160b interfaceC0160b, b.a aVar) {
        this.f12910a = new HashSet();
        if (interfaceC0160b == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f12911b = interfaceC0160b;
        this.f12912c = aVar;
    }

    public void log(String str, Object... objArr) {
        log(String.format(Locale.US, str, objArr));
    }
}
