package l8;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: ComponentDiscovery.java */
/* loaded from: classes.dex */
public final class f<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f15950a;

    /* renamed from: b, reason: collision with root package name */
    public final b<T> f15951b;

    /* compiled from: ComponentDiscovery.java */
    public static class a implements b<Context> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends Service> f15952a;

        public a(Class cls) {
            this.f15952a = cls;
        }

        public List<String> retrieve(Context context) throws PackageManager.NameNotFoundException {
            Class<? extends Service> cls = this.f15952a;
            Bundle bundle = null;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                } else {
                    ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, cls), 128);
                    if (serviceInfo == null) {
                        Log.w("ComponentDiscovery", cls + " has no service info.");
                    } else {
                        bundle = serviceInfo.metaData;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
            }
            if (bundle == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    /* compiled from: ComponentDiscovery.java */
    public interface b<T> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Object obj, a aVar) {
        this.f15950a = obj;
        this.f15951b = aVar;
    }

    public static f<Context> forContext(Context context, Class<? extends Service> cls) {
        return new f<>(context, new a(cls));
    }

    public List<h9.b<ComponentRegistrar>> discoverLazy() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((a) this.f15951b).retrieve(this.f15950a).iterator();
        while (it.hasNext()) {
            arrayList.add(new e((String) it.next(), 0));
        }
        return arrayList;
    }
}
