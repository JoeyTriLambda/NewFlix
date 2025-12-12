package com.jakewharton.threetenabp;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.threeten.bp.zone.TzdbZoneRulesProvider;
import org.threeten.bp.zone.ZoneRulesInitializer;
import org.threeten.bp.zone.ZoneRulesProvider;

/* loaded from: classes.dex */
final class AssetsZoneRulesInitializer extends ZoneRulesInitializer {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10255a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10256b;

    public AssetsZoneRulesInitializer(Context context, String str) {
        this.f10255a = context;
        this.f10256b = str;
    }

    @Override // org.threeten.bp.zone.ZoneRulesInitializer
    public void initializeProviders() throws IOException {
        String str = this.f10256b;
        InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = this.f10255a.getAssets().open(str);
                TzdbZoneRulesProvider tzdbZoneRulesProvider = new TzdbZoneRulesProvider(inputStreamOpen);
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException unused) {
                    }
                }
                ZoneRulesProvider.registerProvider(tzdbZoneRulesProvider);
            } catch (IOException e10) {
                throw new IllegalStateException(str + " missing from assets", e10);
            }
        } catch (Throwable th2) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException unused2) {
                }
            }
            throw th2;
        }
    }
}
