package com.jakewharton.threetenabp;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import org.threeten.bp.zone.ZoneRulesInitializer;

/* loaded from: classes.dex */
public final class AndroidThreeTen {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f10254a = new AtomicBoolean();

    private AndroidThreeTen() {
        throw new AssertionError();
    }

    public static void init(Application application) {
        init((Context) application);
    }

    public static void init(Context context) {
        init(context, "org/threeten/bp/TZDB.dat");
    }

    public static void init(Context context, String str) {
        if (f10254a.getAndSet(true)) {
            return;
        }
        ZoneRulesInitializer.setInitializer(new AssetsZoneRulesInitializer(context, str));
    }
}
