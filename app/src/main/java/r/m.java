package r;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.j1;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import r.c;
import r.y;

/* compiled from: AppCompatDelegate.java */
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: b, reason: collision with root package name */
    public static final y.a f18247b = new y.a(new y.b());

    /* renamed from: m, reason: collision with root package name */
    public static final int f18248m = -100;

    /* renamed from: n, reason: collision with root package name */
    public static t0.h f18249n = null;

    /* renamed from: o, reason: collision with root package name */
    public static t0.h f18250o = null;

    /* renamed from: p, reason: collision with root package name */
    public static Boolean f18251p = null;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f18252q = false;

    /* renamed from: r, reason: collision with root package name */
    public static final b0.d<WeakReference<m>> f18253r = new b0.d<>();

    /* renamed from: s, reason: collision with root package name */
    public static final Object f18254s = new Object();

    /* renamed from: t, reason: collision with root package name */
    public static final Object f18255t = new Object();

    /* compiled from: AppCompatDelegate.java */
    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* compiled from: AppCompatDelegate.java */
    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    public static boolean a(Context context) {
        if (f18251p == null) {
            try {
                Bundle bundle = w.getServiceInfo(context).metaData;
                if (bundle != null) {
                    f18251p = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f18251p = Boolean.FALSE;
            }
        }
        return f18251p.booleanValue();
    }

    public static void b(m mVar) {
        synchronized (f18254s) {
            Iterator<WeakReference<m>> it = f18253r.iterator();
            while (it.hasNext()) {
                m mVar2 = it.next().get();
                if (mVar2 == mVar || mVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public static m create(Activity activity, k kVar) {
        return new n(activity, null, kVar, activity);
    }

    public static t0.h getApplicationLocales() {
        Object systemService;
        Context contextForDelegate;
        if (t0.a.isAtLeastT()) {
            Iterator<WeakReference<m>> it = f18253r.iterator();
            while (true) {
                if (!it.hasNext()) {
                    systemService = null;
                    break;
                }
                m mVar = it.next().get();
                if (mVar != null && (contextForDelegate = mVar.getContextForDelegate()) != null) {
                    systemService = contextForDelegate.getSystemService("locale");
                    break;
                }
            }
            if (systemService != null) {
                return t0.h.wrap(b.a(systemService));
            }
        } else {
            t0.h hVar = f18249n;
            if (hVar != null) {
                return hVar;
            }
        }
        return t0.h.getEmptyLocaleList();
    }

    public static int getDefaultNightMode() {
        return f18248m;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z10) {
        j1.setCompatVectorFromResourcesEnabled(z10);
    }

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    public Context attachBaseContext2(Context context) {
        attachBaseContext(context);
        return context;
    }

    public abstract <T extends View> T findViewById(int i10);

    public Context getContextForDelegate() {
        return null;
    }

    public abstract c.a getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract MenuInflater getMenuInflater();

    public abstract r.a getSupportActionBar();

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle bundle);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i10);

    public abstract void setContentView(int i10);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setSupportActionBar(Toolbar toolbar);

    public abstract void setTitle(CharSequence charSequence);

    public static m create(Dialog dialog, k kVar) {
        return new n(dialog.getContext(), dialog.getWindow(), kVar, dialog);
    }

    @Deprecated
    public void attachBaseContext(Context context) {
    }

    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public void setTheme(int i10) {
    }
}
