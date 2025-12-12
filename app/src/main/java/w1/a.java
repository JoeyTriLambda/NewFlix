package w1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: LocalBroadcastManager.java */
@Deprecated
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f20848f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static a f20849g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f20850a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<c>> f20851b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f20852c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<b> f20853d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public final HandlerC0301a f20854e;

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: w1.a$a, reason: collision with other inner class name */
    public class HandlerC0301a extends Handler {
        public HandlerC0301a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int size;
            b[] bVarArr;
            if (message.what != 1) {
                super.handleMessage(message);
                return;
            }
            a aVar = a.this;
            while (true) {
                synchronized (aVar.f20851b) {
                    size = aVar.f20853d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    aVar.f20853d.toArray(bVarArr);
                    aVar.f20853d.clear();
                }
                for (int i10 = 0; i10 < size; i10++) {
                    b bVar = bVarArr[i10];
                    int size2 = bVar.f20857b.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        c cVar = bVar.f20857b.get(i11);
                        cVar.getClass();
                        cVar.f20859b.onReceive(aVar.f20850a, bVar.f20856a);
                    }
                }
            }
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f20856a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<c> f20857b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f20856a = intent;
            this.f20857b = arrayList;
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final IntentFilter f20858a;

        /* renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f20859b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f20860c;

        public c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
            this.f20858a = intentFilter;
            this.f20859b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sbQ = ac.c.q(128, "Receiver{");
            sbQ.append(this.f20859b);
            sbQ.append(" filter=");
            sbQ.append(this.f20858a);
            sbQ.append("}");
            return sbQ.toString();
        }
    }

    public a(Context context) {
        this.f20850a = context;
        this.f20854e = new HandlerC0301a(context.getMainLooper());
    }

    public static a getInstance(Context context) {
        a aVar;
        synchronized (f20848f) {
            if (f20849g == null) {
                f20849g = new a(context.getApplicationContext());
            }
            aVar = f20849g;
        }
        return aVar;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f20851b) {
            c cVar = new c(broadcastReceiver, intentFilter);
            ArrayList<c> arrayList = this.f20851b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f20851b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                String action = intentFilter.getAction(i10);
                ArrayList<c> arrayList2 = this.f20852c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f20852c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        ArrayList<c> arrayList;
        int i10;
        String str;
        synchronized (this.f20851b) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f20850a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z10 = (intent.getFlags() & 8) != 0;
            if (z10) {
                Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList2 = this.f20852c.get(intent.getAction());
            if (arrayList2 != null) {
                if (z10) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                }
                ArrayList arrayList3 = null;
                int i11 = 0;
                while (i11 < arrayList2.size()) {
                    c cVar = arrayList2.get(i11);
                    if (z10) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f20858a);
                    }
                    if (cVar.f20860c) {
                        if (z10) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        arrayList = arrayList2;
                        i10 = i11;
                        str = action;
                    } else {
                        arrayList = arrayList2;
                        i10 = i11;
                        str = action;
                        int iMatch = cVar.f20858a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z10) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            arrayList3.add(cVar);
                            cVar.f20860c = true;
                        } else if (z10) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : JsonStorageKeyNames.DATA_KEY : "action" : "category"));
                        }
                    }
                    i11 = i10 + 1;
                    arrayList2 = arrayList;
                    action = str;
                }
                if (arrayList3 != null) {
                    for (int i12 = 0; i12 < arrayList3.size(); i12++) {
                        ((c) arrayList3.get(i12)).f20860c = false;
                    }
                    this.f20853d.add(new b(intent, arrayList3));
                    if (!this.f20854e.hasMessages(1)) {
                        this.f20854e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
