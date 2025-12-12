package o8;

import android.content.Context;
import android.content.res.Resources;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DevelopmentPlatformProvider.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f17041a;

    /* renamed from: b, reason: collision with root package name */
    public a f17042b = null;

    /* compiled from: DevelopmentPlatformProvider.java */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f17043a;

        /* renamed from: b, reason: collision with root package name */
        public final String f17044b;

        public a(d dVar) throws Resources.NotFoundException, IOException {
            boolean z10;
            int resourcesIdentifier = CommonUtils.getResourcesIdentifier(dVar.f17041a, "com.google.firebase.crashlytics.unity_version", "string");
            Context context = dVar.f17041a;
            if (resourcesIdentifier != 0) {
                this.f17043a = "Unity";
                String string = context.getResources().getString(resourcesIdentifier);
                this.f17044b = string;
                e.getLogger().v("Unity Editor version is: " + string);
                return;
            }
            if (context.getAssets() == null) {
                z10 = false;
            } else {
                try {
                    InputStream inputStreamOpen = context.getAssets().open("flutter_assets/NOTICES.Z");
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    z10 = true;
                } catch (IOException unused) {
                }
            }
            if (!z10) {
                this.f17043a = null;
                this.f17044b = null;
            } else {
                this.f17043a = "Flutter";
                this.f17044b = null;
                e.getLogger().v("Development platform is: Flutter");
            }
        }
    }

    public d(Context context) {
        this.f17041a = context;
    }

    public String getDevelopmentPlatform() {
        if (this.f17042b == null) {
            this.f17042b = new a(this);
        }
        return this.f17042b.f17043a;
    }

    public String getDevelopmentPlatformVersion() {
        if (this.f17042b == null) {
            this.f17042b = new a(this);
        }
        return this.f17042b.f17044b;
    }
}
