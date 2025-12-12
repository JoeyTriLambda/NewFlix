package he;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import io.netas.Netas;
import io.netas.receiver.BatteryLevelReceiver;
import io.netas.service.NetasService;
import io.netas.support.NetworkStateReceiver;
import io.netas.task.ProtoAsyncTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class a implements Runnable {
    public String A;
    public String B;
    public String[] C;
    public String[][] D;
    public final NetworkStateReceiver E;
    public final BatteryLevelReceiver F;

    /* renamed from: b, reason: collision with root package name */
    public final Context f13053b;

    /* renamed from: m, reason: collision with root package name */
    public ProtoAsyncTask f13054m;

    /* renamed from: n, reason: collision with root package name */
    public ProtoAsyncTask[] f13055n;

    /* renamed from: o, reason: collision with root package name */
    public final Handler f13056o = new Handler();

    /* renamed from: p, reason: collision with root package name */
    public final PowerManager.WakeLock f13057p;

    /* renamed from: q, reason: collision with root package name */
    public String f13058q;

    /* renamed from: r, reason: collision with root package name */
    public String f13059r;

    /* renamed from: s, reason: collision with root package name */
    public String f13060s;

    /* renamed from: t, reason: collision with root package name */
    public String f13061t;

    /* renamed from: u, reason: collision with root package name */
    public String f13062u;

    /* renamed from: v, reason: collision with root package name */
    public String f13063v;

    /* renamed from: w, reason: collision with root package name */
    public String f13064w;

    /* renamed from: x, reason: collision with root package name */
    public String f13065x;

    /* renamed from: y, reason: collision with root package name */
    public String f13066y;

    /* renamed from: z, reason: collision with root package name */
    public String f13067z;

    public a(Context context, PowerManager.WakeLock wakeLock) {
        try {
            Netas.getInstance(context);
            this.f13053b = context;
            this.f13057p = wakeLock;
            new ArrayList(15);
            NetworkStateReceiver networkStateReceiver = new NetworkStateReceiver();
            this.E = networkStateReceiver;
            networkStateReceiver.a(this);
            context.registerReceiver(networkStateReceiver, NetworkStateReceiver.a());
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.intent.action.BATTERY_LOW");
            intentFilter.addAction("android.intent.action.BATTERY_OKAY");
            Intent intentRegisterReceiver = context.registerReceiver(null, intentFilter);
            intentRegisterReceiver.getIntExtra("level", 0);
            a(intentRegisterReceiver.getBooleanExtra("battery_low", false));
            BatteryLevelReceiver batteryLevelReceiver = new BatteryLevelReceiver();
            this.F = batteryLevelReceiver;
            batteryLevelReceiver.a(this);
            context.registerReceiver(batteryLevelReceiver, BatteryLevelReceiver.a());
        } catch (Exception e10) {
            je.a.b("a", "create BgClientJob failed! Error = %s ", e10.getMessage());
        }
    }

    public int a() {
        int iA;
        ProtoAsyncTask[] protoAsyncTaskArr = this.f13055n;
        if (protoAsyncTaskArr != null) {
            iA = 0;
            for (ProtoAsyncTask protoAsyncTask : protoAsyncTaskArr) {
                iA += protoAsyncTask.a();
            }
        } else {
            iA = 0;
        }
        ProtoAsyncTask protoAsyncTask2 = this.f13054m;
        if (protoAsyncTask2 != null) {
            return protoAsyncTask2.a() + iA;
        }
        return 0;
    }

    public void b(boolean z10) {
        this.f13066y = String.valueOf(z10);
        ProtoAsyncTask.b(z10);
        je.a.a("a", "Wifi State is %s", this.f13066y);
    }

    public boolean c() {
        ProtoAsyncTask protoAsyncTask = this.f13054m;
        return protoAsyncTask != null && protoAsyncTask.c();
    }

    public boolean d() {
        ProtoAsyncTask protoAsyncTask = this.f13054m;
        return protoAsyncTask != null && protoAsyncTask.d();
    }

    public void e() {
        je.a.a("a", "Shutdown configuration synchronization job", new Object[0]);
        Context context = this.f13053b;
        NetworkStateReceiver networkStateReceiver = this.E;
        if (networkStateReceiver != null) {
            context.unregisterReceiver(networkStateReceiver);
        }
        BatteryLevelReceiver batteryLevelReceiver = this.F;
        if (batteryLevelReceiver != null) {
            context.unregisterReceiver(batteryLevelReceiver);
        }
        PowerManager.WakeLock wakeLock = this.f13057p;
        if (wakeLock.isHeld()) {
            wakeLock.release();
        }
        this.f13056o.removeCallbacks(this);
        ProtoAsyncTask protoAsyncTask = this.f13054m;
        if (protoAsyncTask != null) {
            protoAsyncTask.i();
            this.f13054m.cancel(true);
        }
        ProtoAsyncTask[] protoAsyncTaskArr = this.f13055n;
        if (protoAsyncTaskArr != null) {
            for (ProtoAsyncTask protoAsyncTask2 : protoAsyncTaskArr) {
                protoAsyncTask2.i();
                protoAsyncTask2.cancel(true);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context = this.f13053b;
        try {
            long jG = Netas.getInstance(context).g() - (SystemClock.elapsedRealtime() % 1000);
            this.f13056o.postDelayed(this, jG);
            this.f13057p.acquire(jG);
            if (this.f13054m != null) {
                je.a.a("a", "Proxy task is running, check keepalive", new Object[0]);
                if (!this.f13054m.e()) {
                    e();
                    context.stopService(new Intent(context, (Class<?>) NetasService.class));
                }
                ProtoAsyncTask[] protoAsyncTaskArr = this.f13055n;
                if (protoAsyncTaskArr != null) {
                    for (ProtoAsyncTask protoAsyncTask : protoAsyncTaskArr) {
                        protoAsyncTask.e();
                    }
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f13058q);
            arrayList.add(this.f13059r);
            arrayList.add(this.f13060s);
            arrayList.add(this.f13061t);
            arrayList.add(this.f13062u);
            arrayList.add(this.f13063v);
            arrayList.add(this.f13064w);
            arrayList.add(this.f13065x);
            arrayList.add(this.f13066y);
            arrayList.add(this.A);
            arrayList.add(this.B);
            arrayList.addAll(Arrays.asList(this.C));
            ProtoAsyncTask protoAsyncTask2 = ProtoAsyncTask.getInstance(1);
            this.f13054m = protoAsyncTask2;
            protoAsyncTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String[]) arrayList.toArray(new String[0]));
            arrayList.removeAll(Arrays.asList(this.C));
            String[][] strArr = this.D;
            if (strArr == null) {
                return;
            }
            this.f13055n = new ProtoAsyncTask[strArr.length];
            int i10 = 0;
            while (true) {
                String[][] strArr2 = this.D;
                if (i10 >= strArr2.length) {
                    return;
                }
                arrayList.addAll(Arrays.asList(strArr2[i10]));
                this.f13055n[i10] = ProtoAsyncTask.getInstance(i10 + 2);
                this.f13055n[i10].executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String[]) arrayList.toArray(new String[0]));
                arrayList.removeAll(Arrays.asList(this.D[i10]));
                i10++;
            }
        } catch (Exception e10) {
            je.a.b("a", "run BgClientJob failed! Error = %s ", e10.getMessage());
        }
    }

    public long a(TimeUnit timeUnit) {
        ProtoAsyncTask protoAsyncTask = this.f13054m;
        if (protoAsyncTask != null) {
            return protoAsyncTask.a(timeUnit);
        }
        return 0L;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, boolean z11, String str8, String str9, String[] strArr, String[][] strArr2) {
        ProtoAsyncTask protoAsyncTask = this.f13054m;
        if (protoAsyncTask != null && protoAsyncTask.d()) {
            je.a.d("a", "The Netas task already running, cannot reschedule a new one", new Object[0]);
            return;
        }
        this.f13058q = str;
        this.f13059r = str2;
        this.f13060s = str3;
        this.f13061t = str4;
        this.f13062u = str5;
        this.f13063v = str6;
        this.f13064w = str7;
        this.f13065x = String.valueOf(z10);
        this.f13066y = String.valueOf(z11);
        this.A = str8;
        this.B = str9;
        this.C = strArr;
        this.D = strArr2;
        Handler handler = this.f13056o;
        handler.removeCallbacks(this);
        handler.post(this);
        je.a.a("a", "Scheduled configuration synchronization job", new Object[0]);
    }

    public void a(boolean z10) {
        this.f13067z = String.valueOf(z10);
        ProtoAsyncTask.a(z10);
        je.a.a("a", "Battery low level is %s", this.f13067z);
    }
}
