package h4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.getkeepsafe.relinker.MissingLibraryException;
import h4.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: ApkLibraryInstaller.java */
/* loaded from: classes.dex */
public final class a implements b.a {

    /* compiled from: ApkLibraryInstaller.java */
    /* renamed from: h4.a$a, reason: collision with other inner class name */
    public static class C0159a {

        /* renamed from: a, reason: collision with root package name */
        public final ZipFile f12908a;

        /* renamed from: b, reason: collision with root package name */
        public final ZipEntry f12909b;

        public C0159a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f12908a = zipFile;
            this.f12909b = zipEntry;
        }
    }

    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static C0159a b(Context context, String[] strArr, String str, c cVar) throws IOException {
        String[] strArrD = d(context);
        int length = strArrD.length;
        char c10 = 0;
        int i10 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i10 >= length) {
                return null;
            }
            String str2 = strArrD[i10];
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i11 = i12;
                }
            }
            if (zipFile != null) {
                int i13 = 0;
                while (true) {
                    int i14 = i13 + 1;
                    if (i13 < 5) {
                        int length2 = strArr.length;
                        int i15 = 0;
                        while (i15 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i15] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c10] = str3;
                            objArr[1] = str2;
                            cVar.log("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new C0159a(zipFile, entry);
                            }
                            i15++;
                            c10 = 0;
                        }
                        i13 = i14;
                        c10 = 0;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i10++;
            c10 = 0;
        }
    }

    public static String[] c(Context context, String str) {
        Pattern patternCompile = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
        HashSet hashSet = new HashSet();
        for (String str2 : d(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str2), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public static String[] d(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    @SuppressLint({"SetWorldReadable"})
    public void installLibrary(Context context, String[] strArr, String str, File file, c cVar) {
        C0159a c0159aB;
        String[] strArrC;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        C0159a c0159a = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            c0159aB = b(context, strArr, str, cVar);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (c0159aB == null) {
                try {
                    strArrC = c(context, str);
                } catch (Exception e10) {
                    strArrC = new String[]{e10.toString()};
                }
                throw new MissingLibraryException(str, strArr, strArrC);
            }
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                ZipFile zipFile = c0159aB.f12908a;
                if (i10 >= 5) {
                    cVar.log("FATAL! Couldn't extract the library from the APK!");
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    return;
                }
                cVar.log("Found %s! Extracting...", str);
                try {
                    if (file.exists() || file.createNewFile()) {
                        try {
                            inputStream = zipFile.getInputStream(c0159aB.f12909b);
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    try {
                                        byte[] bArr = new byte[4096];
                                        long j10 = 0;
                                        while (true) {
                                            int i12 = inputStream.read(bArr);
                                            if (i12 == -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, i12);
                                            j10 += i12;
                                        }
                                        fileOutputStream.flush();
                                        fileOutputStream.getFD().sync();
                                        if (j10 == file.length()) {
                                            a(inputStream);
                                            a(fileOutputStream);
                                            file.setReadable(true, false);
                                            file.setExecutable(true, false);
                                            file.setWritable(true);
                                            try {
                                                zipFile.close();
                                                return;
                                            } catch (IOException unused2) {
                                                return;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fileOutputStream2 = fileOutputStream;
                                        a(inputStream);
                                        a(fileOutputStream2);
                                        throw th;
                                    }
                                } catch (FileNotFoundException | IOException unused3) {
                                }
                            } catch (FileNotFoundException unused4) {
                                fileOutputStream = null;
                                a(inputStream);
                                a(fileOutputStream);
                                i10 = i11;
                            } catch (IOException unused5) {
                                fileOutputStream = null;
                                a(inputStream);
                                a(fileOutputStream);
                                i10 = i11;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (FileNotFoundException unused6) {
                            inputStream = null;
                        } catch (IOException unused7) {
                            inputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = null;
                        }
                        a(inputStream);
                        a(fileOutputStream);
                    }
                } catch (IOException unused8) {
                }
                i10 = i11;
            }
        } catch (Throwable th6) {
            th = th6;
            c0159a = c0159aB;
            if (c0159a != null) {
                try {
                    ZipFile zipFile2 = c0159a.f12908a;
                    if (zipFile2 != null) {
                        zipFile2.close();
                    }
                } catch (IOException unused9) {
                }
            }
            throw th;
        }
    }
}
