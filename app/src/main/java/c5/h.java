package c5;

import java.util.HashSet;

/* compiled from: ExoPlayerLibraryInfo.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f5113a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    public static String f5114b = "goog.exo.core";

    public static synchronized void registerModule(String str) {
        if (f5113a.add(str)) {
            f5114b += ", " + str;
        }
    }

    public static synchronized String registeredModules() {
        return f5114b;
    }
}
