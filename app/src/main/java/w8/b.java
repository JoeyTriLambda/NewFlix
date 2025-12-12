package w8;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import o8.e;

/* compiled from: FileStore.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final File f21037a;

    /* renamed from: b, reason: collision with root package name */
    public final File f21038b;

    /* renamed from: c, reason: collision with root package name */
    public final File f21039c;

    /* renamed from: d, reason: collision with root package name */
    public final File f21040d;

    /* renamed from: e, reason: collision with root package name */
    public final File f21041e;

    /* renamed from: f, reason: collision with root package name */
    public final File f21042f;

    public b(Context context) {
        String str;
        File filesDir = context.getFilesDir();
        this.f21037a = filesDir;
        if (Build.VERSION.SDK_INT >= 28) {
            str = ".com.google.firebase.crashlytics.files.v2" + File.pathSeparator + Application.getProcessName().replaceAll("[^a-zA-Z0-9.]", "_");
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File file = new File(filesDir, str);
        b(file);
        this.f21038b = file;
        File file2 = new File(file, "open-sessions");
        b(file2);
        this.f21039c = file2;
        File file3 = new File(file, "reports");
        b(file3);
        this.f21040d = file3;
        File file4 = new File(file, "priority-reports");
        b(file4);
        this.f21041e = file4;
        File file5 = new File(file, "native-reports");
        b(file5);
        this.f21042f = file5;
    }

    public static void a(File file) {
        if (file.exists() && c(file)) {
            e.getLogger().d("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    public static synchronized void b(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            e.getLogger().d("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
            file.delete();
        }
        if (!file.mkdirs()) {
            e.getLogger().e("Could not create Crashlytics-specific directory: " + file);
        }
    }

    public static boolean c(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                c(file2);
            }
        }
        return file.delete();
    }

    public static <T> List<T> d(T[] tArr) {
        return tArr == null ? Collections.emptyList() : Arrays.asList(tArr);
    }

    public void cleanupPreviousFileSystems() {
        File file = this.f21037a;
        a(new File(file, ".com.google.firebase.crashlytics"));
        a(new File(file, ".com.google.firebase.crashlytics-ndk"));
        if (Build.VERSION.SDK_INT >= 28) {
            a(new File(file, ".com.google.firebase.crashlytics.files.v1"));
        }
    }

    public boolean deleteSessionFiles(String str) {
        return c(new File(this.f21039c, str));
    }

    public List<String> getAllOpenSessionIds() {
        return d(this.f21039c.list());
    }

    public File getCommonFile(String str) {
        return new File(this.f21038b, str);
    }

    public List<File> getCommonFiles(FilenameFilter filenameFilter) {
        return d(this.f21038b.listFiles(filenameFilter));
    }

    public File getNativeReport(String str) {
        return new File(this.f21042f, str);
    }

    public List<File> getNativeReports() {
        return d(this.f21042f.listFiles());
    }

    public File getNativeSessionDir(String str) {
        File file = new File(this.f21039c, str);
        file.mkdirs();
        File file2 = new File(file, "native");
        file2.mkdirs();
        return file2;
    }

    public File getPriorityReport(String str) {
        return new File(this.f21041e, str);
    }

    public List<File> getPriorityReports() {
        return d(this.f21041e.listFiles());
    }

    public File getReport(String str) {
        return new File(this.f21040d, str);
    }

    public List<File> getReports() {
        return d(this.f21040d.listFiles());
    }

    public File getSessionFile(String str, String str2) {
        File file = new File(this.f21039c, str);
        file.mkdirs();
        return new File(file, str2);
    }

    public List<File> getSessionFiles(String str, FilenameFilter filenameFilter) {
        File file = new File(this.f21039c, str);
        file.mkdirs();
        return d(file.listFiles(filenameFilter));
    }
}
