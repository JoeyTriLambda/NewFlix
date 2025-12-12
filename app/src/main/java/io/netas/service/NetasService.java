package io.netas.service;

import ac.c;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.i;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import d4.m;
import io.netas.Netas;
import io.netas.R;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NetasService extends Service {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f13488s = 0;

    /* renamed from: b, reason: collision with root package name */
    public he.a f13489b;

    /* renamed from: m, reason: collision with root package name */
    public ke.a f13490m;

    /* renamed from: o, reason: collision with root package name */
    public Handler f13492o;

    /* renamed from: n, reason: collision with root package name */
    public int f13491n = 0;

    /* renamed from: p, reason: collision with root package name */
    public final b f13493p = new b();

    /* renamed from: q, reason: collision with root package name */
    public final NetasService f13494q = this;

    /* renamed from: r, reason: collision with root package name */
    public final a f13495r = new a();

    public class a implements Runnable {

        /* renamed from: io.netas.service.NetasService$a$a, reason: collision with other inner class name */
        public class C0168a implements Response.Listener<String> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f13497b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ Netas f13498m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ boolean f13499n;

            /* renamed from: o, reason: collision with root package name */
            public final /* synthetic */ String f13500o;

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ a f13501p;

            public C0168a(Netas netas, a aVar, String str, String str2, boolean z10) {
                this.f13501p = aVar;
                this.f13497b = str;
                this.f13498m = netas;
                this.f13499n = z10;
                this.f13500o = str2;
            }

            @Override // com.android.volley.Response.Listener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(String str) throws JSONException {
                int i10 = NetasService.f13488s;
                String str2 = this.f13497b;
                je.a.a("NetasService", String.format("Device %s successfully registered", str2), new Object[0]);
                a aVar = this.f13501p;
                String[] strArrB = NetasService.this.b(str);
                if (strArrB != null) {
                    Netas netas = this.f13498m;
                    ge.a aVarF = netas.f();
                    int i11 = R.string.netas_uid_key;
                    NetasService netasService = NetasService.this;
                    aVarF.b(netasService.getString(i11), str2);
                    netas.g(str2);
                    netas.f().b(netasService.getString(R.string.netas_ver_key), "5.0.29");
                    netasService.f13489b.a(this.f13497b, netas.e(), netas.m(), netas.d(), netas.j(), netas.c(), ((TelephonyManager) netasService.getSystemService("phone")).getNetworkOperatorName(), this.f13499n, NetasService.b(netasService.f13494q), this.f13500o, netas.h(), strArrB, netasService.a(str));
                }
            }
        }

        public class b implements Response.ErrorListener {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Netas f13502b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ String f13503m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ boolean f13504n;

            /* renamed from: o, reason: collision with root package name */
            public final /* synthetic */ String f13505o;

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ a f13506p;

            public b(Netas netas, a aVar, String str, String str2, boolean z10) {
                this.f13506p = aVar;
                this.f13502b = netas;
                this.f13503m = str;
                this.f13504n = z10;
                this.f13505o = str2;
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                String message = volleyError.getCause() != null ? volleyError.getCause().getMessage() : volleyError.toString();
                if (message == null) {
                    message = "No Cause Received";
                } else if (message.length() > 150) {
                    message = message.substring(0, 150);
                }
                a aVar = this.f13506p;
                String str = String.format("An error retry %d occurred while calling registration service: %s ", Integer.valueOf(NetasService.this.f13491n), message);
                int i10 = NetasService.f13488s;
                je.a.b("NetasService", str, new Object[0]);
                NetasService netasService = NetasService.this;
                int i11 = netasService.f13491n;
                if (i11 < 3) {
                    netasService.f13491n = i11 + 1;
                    netasService.f13492o.postDelayed(netasService.f13495r, r4 * 30000);
                } else {
                    Netas netas = this.f13502b;
                    if (netas.f().a(netasService.getString(R.string.netas_uid_key)) != null) {
                        netasService.f13489b.a(this.f13503m, netas.e(), "Unknown", "Unknown", netas.j(), netas.c(), c.j("failed register: ", message), this.f13504n, NetasService.b(netasService.f13494q), this.f13505o, netas.h(), new String[]{"s1.gmslb.net:6000"}, null);
                        netasService.f13491n = 0;
                    }
                }
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NetasService netasService = NetasService.this;
            try {
                NetasService netasService2 = netasService.f13494q;
                NetasService netasService3 = netasService.f13494q;
                Netas netas = Netas.getInstance(netasService2);
                String strA = Netas.getInstance(netasService3).f().a(netasService.getString(R.string.netas_uid_key));
                String string = strA == null ? UUID.randomUUID().toString() : strA;
                String strA2 = Netas.getInstance(netasService3).f().a(netasService.getString(R.string.netas_ver_key));
                ge.a aVarF = netas.f();
                int i10 = R.string.netas_is_foreground;
                aVarF.b(netasService.getString(i10));
                new ge.a(netasService3).b(netasService3.getString(i10));
                boolean z10 = netas.f().b(netasService.getString(i10)) && Build.VERSION.SDK_INT >= 26;
                String str = z10 ? "5.0.29fg" : "5.0.29";
                String str2 = strA == null ? "new" : (strA2 == null || strA2.equals("5.0.29")) ? "old" : "up";
                String strJ = netas.j();
                String strE = NetasService.e();
                String strA3 = NetasService.a(netasService3);
                String strL = netas.l();
                String strK = netas.k();
                if (!strL.endsWith("/") && !strK.startsWith("/")) {
                    strL = strL.concat("/");
                }
                String str3 = strL + strK.replace("{publisher}", strJ).replace("{uid}", string).replace("{localip}", strE).replace("{ver}", str).replace("{init}", str2);
                je.a.a("NetasService", "Trying to register the device %s using url %s", string, str3);
                m mVar = new m(0, str3, new C0168a(netas, this, string, strA3, z10), new b(netas, this, string, strA3, z10));
                mVar.setRetryPolicy(new DefaultRetryPolicy(30000, 2, 1.0f));
                netasService.f13490m.a(mVar);
            } catch (Exception e10) {
                int i11 = NetasService.f13488s;
                je.a.b("NetasService", "Failed on registration: ", e10.toString());
            }
        }
    }

    public class b extends Binder {
        public b() {
        }

        public NetasService a() {
            return NetasService.this;
        }
    }

    public static String e() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (hostAddress.indexOf(58) < 0) {
                            return hostAddress;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public long a(TimeUnit timeUnit) {
        he.a aVar = this.f13489b;
        if (aVar != null) {
            return aVar.a(timeUnit);
        }
        return 0L;
    }

    public int b() {
        he.a aVar = this.f13489b;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    public boolean c() {
        he.a aVar = this.f13489b;
        return aVar != null && aVar.c();
    }

    public boolean d() {
        he.a aVar = this.f13489b;
        return aVar != null && aVar.d();
    }

    public final void f() throws ClassNotFoundException {
        Class<?> cls;
        ge.a aVarA = ge.a.a(this);
        String strA = aVarA.a("APPNAME", "Netas");
        String strA2 = aVarA.a("CLASS_NAME", "NetasService.class");
        int iA = aVarA.a("ICON", R.drawable.ic_android_notify);
        String strA3 = aVarA.a("MESSAGE", "Background service is running");
        NotificationChannel notificationChannel = new NotificationChannel("netas_service_chan", strA, 0);
        notificationChannel.setLightColor(-16776961);
        notificationChannel.setLockscreenVisibility(0);
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        try {
            cls = Class.forName(strA2);
        } catch (ClassNotFoundException unused) {
            je.a.b("NetasService", "class name %s supplied by publisher is not valid!", strA2);
            cls = NetasService.class;
        }
        Intent intent = new Intent(this, cls);
        intent.setAction("ACTION_NOTIFY_CLICKED");
        PendingIntent service = cls == NetasService.class ? PendingIntent.getService(this, 0, intent, 335544320) : PendingIntent.getActivity(this, 0, intent, 201326592);
        startForeground(1, new Notification.Builder(this, "netas_service_chan").setContentTitle(strA).setContentText(strA3).setSmallIcon(iA).setContentIntent(service).addAction(new Notification.Action.Builder(iA, "Open", service).build()).build());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f13493p;
    }

    @Override // android.app.Service
    public void onCreate() {
        PowerManager powerManager = (PowerManager) getSystemService("power");
        ge.a aVar = new ge.a(this);
        try {
            this.f13492o = new Handler();
            Netas netas = Netas.getInstance(this);
            if (netas != null) {
                this.f13490m = netas.i();
                this.f13489b = new he.a(this, powerManager.newWakeLock(1, "NetasService"));
                if (Build.VERSION.SDK_INT >= 26 && aVar.b(getString(R.string.netas_is_foreground))) {
                    je.a.a("NetasService", "foreground Service - create notification", new Object[0]);
                    f();
                }
                je.a.a("NetasService", "Service was created", new Object[0]);
            }
        } catch (Exception e10) {
            je.a.a("NetasService", "Failed to getInstance on NetasService onCreate: ", e10, new Object[0]);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ke.a aVar = this.f13490m;
        if (aVar != null) {
            aVar.c();
        }
        he.a aVar2 = this.f13489b;
        if (aVar2 != null) {
            aVar2.e();
        }
        je.a.d("NetasService", "Service was stopped", new Object[0]);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        je.a.a("NetasService", "Detected low memory", new Object[0]);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        try {
            this.f13495r.run();
        } catch (Exception e10) {
            je.a.b("NetasService", "OnStartCommand failed! Error = %s ", e10.getMessage());
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        je.a.a("NetasService", "Task removed", new Object[0]);
    }

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "-";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() != 0) {
            return "Fail2Retrieve";
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
            case 18:
            case 19:
                return "4G";
            case 20:
                return "5G";
            default:
                return "Unknown";
        }
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    public String[][] a(String str) {
        i iVar = new i();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("secondary_servers")) {
                return null;
            }
            return (String[][]) iVar.fromJson(jSONObject.get("secondary_servers").toString(), String[][].class);
        } catch (Exception e10) {
            je.a.b("NetasService", String.format("failed parsing seconday servers %s", e10.toString()), new Object[0]);
            return null;
        }
    }

    public String[] b(String str) throws JSONException {
        if (str != null && !str.isEmpty()) {
            try {
                Netas netas = Netas.getInstance(this);
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("ip");
                String string2 = jSONObject.getString("country");
                String string3 = jSONObject.getString("city");
                String string4 = jSONObject.getString(AdOperationMetric.INIT_STATE);
                String string5 = jSONObject.getString("asn");
                ge.a aVarF = netas.f();
                String string6 = !jSONObject.isNull("extra") ? jSONObject.getString("extra") : "";
                netas.e(string6);
                aVarF.b(getString(R.string.netas_extra_info_key), string6);
                JSONArray jSONArray = (JSONArray) jSONObject.get("servers");
                int length = jSONArray.length();
                if (length > 0) {
                    String[] strArr = new String[length];
                    for (int i10 = 0; i10 < length; i10++) {
                        strArr[i10] = jSONArray.getString(i10);
                    }
                    aVarF.b(getString(R.string.netas_country_key), string2);
                    netas.d(string2);
                    aVarF.b(getString(R.string.netas_state_key), string4);
                    netas.f(string4);
                    aVarF.b(getString(R.string.netas_city_key), string3);
                    netas.b(string3);
                    aVarF.b(getString(R.string.netas_asn_key), string5);
                    netas.a(string5);
                    netas.c(string);
                    return strArr;
                }
            } catch (Exception e10) {
                je.a.b("NetasService", String.format("failed parsing server response of Json: %s", e10.toString()), new Object[0]);
            }
        }
        je.a.b("NetasService", "Error Registration Response is null or empty", new Object[0]);
        return null;
    }
}
