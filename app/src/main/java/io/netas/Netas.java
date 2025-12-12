package io.netas;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import io.netas.service.NetasService;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes2.dex */
public class Netas extends BroadcastReceiver {

    /* renamed from: p, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Netas f13464p;

    /* renamed from: q, reason: collision with root package name */
    public static AlertDialog f13465q;

    /* renamed from: r, reason: collision with root package name */
    public static final String f13466r = String.format("/?pub=%s&uid=%s&local_ip=%s&ver=%s&in=%s", "{publisher}", "{uid}", "{localip}", "{ver}", "{init}");

    /* renamed from: a, reason: collision with root package name */
    public final Context f13467a;

    /* renamed from: b, reason: collision with root package name */
    public final ke.a f13468b;

    /* renamed from: c, reason: collision with root package name */
    public final ge.a f13469c;

    /* renamed from: d, reason: collision with root package name */
    public final c f13470d = new c();

    /* renamed from: e, reason: collision with root package name */
    public final String f13471e;

    /* renamed from: f, reason: collision with root package name */
    public final String f13472f;

    /* renamed from: g, reason: collision with root package name */
    public final String f13473g;

    /* renamed from: h, reason: collision with root package name */
    public final long f13474h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f13475i;

    /* renamed from: j, reason: collision with root package name */
    public String f13476j;

    /* renamed from: k, reason: collision with root package name */
    public String f13477k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f13478l;

    /* renamed from: m, reason: collision with root package name */
    public String f13479m;

    /* renamed from: n, reason: collision with root package name */
    public String f13480n;

    /* renamed from: o, reason: collision with root package name */
    public String f13481o;

    @Keep
    public static class Builder {
        private boolean enableNetasclientLogging;
        private boolean loggable;
        private boolean mobileForeground;
        private String publisher;
        private String userId;
        private String category = "888";
        private String regUrl = "https://lb.sklstech.com:443/devicereg";
        private String regEndpoint = Netas.f13466r;
        private long delayMillis = DateUtils.MILLIS_PER_MINUTE;
        private boolean foregroundService = false;

        public Netas build(Context context) {
            String str = this.publisher;
            if (str == null || str.trim().length() == 0) {
                throw new IllegalArgumentException("The publisher cannot be <null> or empty, you have to specify one");
            }
            return Netas.a(context, this);
        }

        public Builder enableNetasclientLogging() {
            this.enableNetasclientLogging = true;
            return this;
        }

        public Builder loggable() {
            this.loggable = true;
            return this;
        }

        public Builder withCategory(String str) {
            this.category = str;
            return this;
        }

        public Builder withDelayInMillis(long j10) {
            this.delayMillis = j10;
            return this;
        }

        public Builder withForegroundService(Boolean bool) {
            this.foregroundService = bool.booleanValue();
            je.a.a("netas", "withForegroundService: %s", Boolean.toString(bool.booleanValue()));
            return this;
        }

        public Builder withMobileForeground(Boolean bool) {
            this.mobileForeground = bool.booleanValue();
            je.a.a("netas", "withMobileForeground: %s", Boolean.toString(bool.booleanValue()));
            return this;
        }

        public Builder withPublisher(String str) {
            this.publisher = str;
            je.a.a("netas", "withPublisher: %s", str);
            return this;
        }

        public Builder withRegEndpoint(String str) {
            this.regEndpoint = str;
            return this;
        }

        public Builder withRegUrl(String str) {
            this.regUrl = str;
            return this;
        }

        public Netas build(Context context, String str, String str2, int i10) {
            return build(context, str, str2, i10, "io.netas.service.NetasService");
        }

        public Netas build(Context context, String str, String str2, int i10, String str3) {
            String str4 = this.publisher;
            if (str4 == null || str4.trim().length() == 0) {
                throw new IllegalArgumentException("The publisher cannot be <null> or empty, you have to specify one");
            }
            if (str == null || str.trim().length() == 0) {
                throw new IllegalArgumentException("The Appname cannot be <null> or empty, you have to specify one");
            }
            if (str2 == null || str2.trim().length() == 0) {
                throw new IllegalArgumentException("The message cannot be <null> or empty, you have to specify one");
            }
            if (i10 == 0) {
                throw new IllegalArgumentException("The icon cannot be <null> or empty, you have to specify one");
            }
            if (str3 == null || str3.trim().length() == 0) {
                throw new IllegalArgumentException("The className cannot be <null> or empty, you have to specify one");
            }
            ge.a aVar = new ge.a(context);
            withForegroundService(Boolean.TRUE);
            aVar.b("APPNAME", str);
            aVar.b("PUBLISHER_PACKAGE", context.getPackageName());
            aVar.b("ICON", i10);
            aVar.b("MESSAGE", str2);
            aVar.b("CLASS_NAME", str3);
            return Netas.a(context, this);
        }
    }

    public class a implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f13482b;

        public a(int[] iArr) {
            this.f13482b = iArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1) {
                Log.d("Netas", "On button click");
            }
            int i11 = this.f13482b[0];
            Netas netas = Netas.this;
            if (i11 == 0) {
                netas.f13469c.a(netas.f13467a.getString(R.string.netas_user_permission), true);
                Netas netas2 = Netas.f13464p;
                netas.start();
            } else {
                if (i11 != 1) {
                    return;
                }
                netas.stop();
                netas.f13469c.a(netas.f13467a.getString(R.string.netas_user_permission), false);
            }
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f13484b;

        public b(int[] iArr) {
            this.f13484b = iArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            this.f13484b[0] = i10;
        }
    }

    public class c implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public NetasService f13485a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f13486b = false;

        public NetasService a() {
            return this.f13485a;
        }

        public boolean b() {
            return this.f13486b;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f13485a = ((NetasService.b) iBinder).a();
            this.f13486b = true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f13486b = false;
        }
    }

    public Netas(Context context, Builder builder) {
        this.f13467a = context;
        ge.a aVar = new ge.a(context);
        this.f13469c = aVar;
        this.f13468b = new ke.a(context);
        new le.a(context).a(builder.enableNetasclientLogging);
        String unused = builder.category;
        int i10 = R.string.netas_publisher_key;
        String strA = aVar.a(context.getString(i10));
        if (TextUtils.isEmpty(builder.publisher)) {
            builder.withPublisher(strA);
            this.f13471e = strA;
        } else {
            String str = builder.publisher;
            this.f13471e = str;
            aVar.b(context.getString(i10), str);
        }
        String strA2 = aVar.a(context.getString(R.string.netas_country_key));
        this.f13476j = strA2;
        if (strA2 == null) {
            this.f13476j = "CC";
        }
        this.f13477k = aVar.a(context.getString(R.string.netas_state_key));
        this.f13479m = aVar.a(context.getString(R.string.netas_city_key));
        this.f13480n = aVar.a(context.getString(R.string.netas_asn_key));
        this.f13481o = aVar.a(context.getString(R.string.netas_extra_info_key));
        aVar.a(context.getString(R.string.netas_uid_key));
        this.f13472f = builder.regUrl;
        this.f13473g = builder.regEndpoint;
        this.f13474h = builder.delayMillis;
        this.f13475i = builder.loggable;
        boolean z10 = builder.foregroundService;
        this.f13478l = z10;
        aVar.a(context.getString(R.string.netas_is_foreground), z10);
        boolean unused2 = builder.mobileForeground;
        w1.a.getInstance(context).registerReceiver(this, new IntentFilter(Netas.class.getCanonicalName()));
    }

    public static Netas a(Context context, Builder builder) {
        if (f13464p == null) {
            synchronized (Netas.class) {
                if (f13464p == null) {
                    if (context == null) {
                        throw new NullPointerException("Context cannot be null");
                    }
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    f13464p = new Netas(context, builder);
                }
            }
        }
        return f13464p;
    }

    @Keep
    public static Builder builder() {
        return new Builder();
    }

    @Keep
    public static Netas getInstance() {
        return a(false);
    }

    public final void b(Context context) {
        AlertDialog alertDialog = f13465q;
        if (alertDialog == null || !alertDialog.isShowing()) {
            ge.a aVar = this.f13469c;
            String strA = aVar.a("APPNAME", "Netas");
            int i10 = R.string.netas_alert_message;
            Context context2 = this.f13467a;
            String.format(context2.getString(i10), strA);
            int iA = aVar.a("ICON", R.drawable.ic_android_notify);
            int[] iArr = {0};
            CharSequence[] charSequenceArr = {String.format(context2.getString(R.string.netas_ads_free_message), strA), String.format(context2.getString(R.string.netas_ads_in_message), strA)};
            a aVar2 = new a(iArr);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context2.getString(R.string.netas_ads_in_title)).setIcon(iA).setCancelable(false);
            builder.setSingleChoiceItems(charSequenceArr, iArr[0], new b(iArr));
            builder.setPositiveButton(context2.getString(R.string.netas_alert_startapp), aVar2);
            AlertDialog alertDialogCreate = builder.create();
            f13465q = alertDialogCreate;
            alertDialogCreate.show();
        }
    }

    public String c() {
        return this.f13480n;
    }

    public String d() {
        return this.f13479m;
    }

    @Keep
    public void disallowNetas(Context context) {
        b(context);
    }

    public String e() {
        return this.f13476j;
    }

    public ge.a f() {
        return this.f13469c;
    }

    public long g() {
        return this.f13474h;
    }

    @Keep
    public int getActiveTunnels() {
        c cVar = this.f13470d;
        if (cVar.b()) {
            return cVar.a().b();
        }
        return 0;
    }

    @Keep
    public long getUpTime() {
        c cVar = this.f13470d;
        if (cVar.b()) {
            return cVar.a().a(TimeUnit.MILLISECONDS);
        }
        return 0L;
    }

    public String h() {
        return this.f13481o;
    }

    public ke.a i() {
        return this.f13468b;
    }

    @Keep
    public boolean isConnected() {
        c cVar = this.f13470d;
        return cVar.b() && cVar.a().c();
    }

    @Keep
    public boolean isRunning() {
        c cVar = this.f13470d;
        return cVar.b() && cVar.a().d();
    }

    public String j() {
        return this.f13471e;
    }

    public String k() {
        return this.f13473g;
    }

    public String l() {
        return this.f13472f;
    }

    public String m() {
        return this.f13477k;
    }

    public boolean n() {
        return this.f13478l && Build.VERSION.SDK_INT >= 26;
    }

    public boolean o() {
        return this.f13475i;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        je.a.a("receiver", ac.c.j("Got message: ", intent.getStringExtra("message")), new Object[0]);
        if (intent.getBooleanExtra("need_restart", false)) {
            try {
                je.a.d("receiver", "Restarting Netas Service", new Object[0]);
                start();
            } catch (Exception unused) {
                je.a.d("receiver", "Failed To restart Netas Service", new Object[0]);
            }
        }
    }

    @Keep
    public void start() {
        Intent intent = new Intent();
        Context context = this.f13467a;
        intent.setClass(context, NetasService.class);
        this.f13468b.b();
        try {
            if (!n() || Build.VERSION.SDK_INT < 26) {
                context.startService(intent);
            } else {
                intent.putExtra("need_forground", true);
                context.startForegroundService(intent);
            }
        } catch (Exception unused) {
            je.a.b("netas", "start() failed on startService() with sdk " + Build.VERSION.SDK_INT, new Object[0]);
        }
        context.bindService(intent, this.f13470d, 1);
    }

    @Keep
    public void startAlert(Context context) {
        if (this.f13469c.b(this.f13467a.getString(R.string.netas_user_permission))) {
            start();
        } else {
            b(context);
        }
    }

    @Keep
    public void stop() {
        c cVar = this.f13470d;
        boolean zB = cVar.b();
        Context context = this.f13467a;
        if (zB) {
            context.unbindService(cVar);
        }
        context.stopService(new Intent(context, (Class<?>) NetasService.class));
    }

    public static Netas a(boolean z10) {
        if (f13464p == null) {
            synchronized (Netas.class) {
                if (f13464p == null && !z10) {
                    throw new IllegalStateException("You need to call create() at least once to create the singleton");
                }
            }
        }
        return f13464p;
    }

    @Keep
    public static Netas getInstance(Context context) {
        if (f13464p == null) {
            synchronized (Netas.class) {
                if (f13464p == null) {
                    ge.a aVar = new ge.a(context);
                    boolean zB = aVar.b(context.getString(R.string.netas_is_foreground));
                    String strA = aVar.a(context.getString(R.string.netas_publisher_key));
                    if (TextUtils.isEmpty(strA)) {
                        return null;
                    }
                    f13464p = new Builder().withPublisher(strA).withForegroundService(Boolean.valueOf(zB)).loggable().build(context);
                    je.a.a("netas", "call getInstance while instase equal null - netas self initiation with pub=%s", strA);
                }
            }
        }
        return f13464p;
    }

    public void b(String str) {
        this.f13479m = str;
    }

    public void c(String str) {
    }

    public void d(String str) {
        this.f13476j = str;
    }

    public void e(String str) {
        this.f13481o = str;
    }

    public void f(String str) {
        this.f13477k = str;
    }

    public void g(String str) {
    }

    public void a(String str) {
        this.f13480n = str;
    }
}
