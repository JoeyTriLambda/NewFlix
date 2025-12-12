package o4;

import ac.c;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import p4.g;
import p4.h;
import p4.i;
import q4.i;
import r4.e;
import r4.k;

/* compiled from: CctTransportBackend.java */
/* loaded from: classes.dex */
public final class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final b9.a f17001a = g.createDataEncoder();

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f17002b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f17003c;

    /* renamed from: d, reason: collision with root package name */
    public final URL f17004d;

    /* renamed from: e, reason: collision with root package name */
    public final a5.a f17005e;

    /* renamed from: f, reason: collision with root package name */
    public final a5.a f17006f;

    /* renamed from: g, reason: collision with root package name */
    public final int f17007g;

    /* compiled from: CctTransportBackend.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final URL f17008a;

        /* renamed from: b, reason: collision with root package name */
        public final g f17009b;

        /* renamed from: c, reason: collision with root package name */
        public final String f17010c;

        public a(URL url, g gVar, String str) {
            this.f17008a = url;
            this.f17009b = gVar;
            this.f17010c = str;
        }
    }

    /* compiled from: CctTransportBackend.java */
    /* renamed from: o4.b$b, reason: collision with other inner class name */
    public static final class C0210b {

        /* renamed from: a, reason: collision with root package name */
        public final int f17011a;

        /* renamed from: b, reason: collision with root package name */
        public final URL f17012b;

        /* renamed from: c, reason: collision with root package name */
        public final long f17013c;

        public C0210b(int i10, URL url, long j10) {
            this.f17011a = i10;
            this.f17012b = url;
            this.f17013c = j10;
        }
    }

    public b(Context context, a5.a aVar, a5.a aVar2) {
        this.f17003c = context;
        this.f17002b = (ConnectivityManager) context.getSystemService("connectivity");
        String str = o4.a.f16995c;
        try {
            this.f17004d = new URL(str);
            this.f17005e = aVar2;
            this.f17006f = aVar;
            this.f17007g = 130000;
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException(c.j("Invalid url: ", str), e10);
        }
    }

    @Override // r4.k
    public i decorate(i iVar) {
        int subtype;
        NetworkInfo activeNetworkInfo = this.f17002b.getActiveNetworkInfo();
        i.a aVarAddMetadata = iVar.toBuilder().addMetadata("sdk-version", Build.VERSION.SDK_INT).addMetadata("model", Build.MODEL).addMetadata("hardware", Build.HARDWARE).addMetadata("device", Build.DEVICE).addMetadata("product", Build.PRODUCT).addMetadata("os-uild", Build.ID).addMetadata("manufacturer", Build.MANUFACTURER).addMetadata("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        i.a aVarAddMetadata2 = aVarAddMetadata.addMetadata("tz-offset", TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000).addMetadata("net-type", activeNetworkInfo == null ? NetworkConnectionInfo.NetworkType.NONE.getValue() : activeNetworkInfo.getType());
        int i10 = -1;
        if (activeNetworkInfo == null) {
            subtype = NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        } else {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                subtype = NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
            } else if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) == null) {
                subtype = 0;
            }
        }
        i.a aVarAddMetadata3 = aVarAddMetadata2.addMetadata("mobile-subtype", subtype).addMetadata("country", Locale.getDefault().getCountry()).addMetadata("locale", Locale.getDefault().getLanguage());
        Context context = this.f17003c;
        i.a aVarAddMetadata4 = aVarAddMetadata3.addMetadata("mcc_mnc", ((TelephonyManager) context.getSystemService("phone")).getSimOperator());
        try {
            i10 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            u4.a.e("CctTransportBackend", "Unable to find version code for package", e10);
        }
        return aVarAddMetadata4.addMetadata("application_build", Integer.toString(i10)).build();
    }

    @Override // r4.k
    public BackendResponse send(e eVar) {
        h.a aVarProtoBuilder;
        HashMap map = new HashMap();
        for (i iVar : eVar.getEvents()) {
            String transportName = iVar.getTransportName();
            if (map.containsKey(transportName)) {
                ((List) map.get(transportName)).add(iVar);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iVar);
                map.put(transportName, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            i iVar2 = (i) ((List) entry.getValue()).get(0);
            i.a clientInfo = p4.i.builder().setQosTier(QosTier.DEFAULT).setRequestTimeMs(this.f17006f.getTime()).setRequestUptimeMs(this.f17005e.getTime()).setClientInfo(ClientInfo.builder().setClientType(ClientInfo.ClientType.ANDROID_FIREBASE).setAndroidClientInfo(p4.a.builder().setSdkVersion(Integer.valueOf(iVar2.getInteger("sdk-version"))).setModel(iVar2.get("model")).setHardware(iVar2.get("hardware")).setDevice(iVar2.get("device")).setProduct(iVar2.get("product")).setOsBuild(iVar2.get("os-uild")).setManufacturer(iVar2.get("manufacturer")).setFingerprint(iVar2.get("fingerprint")).setCountry(iVar2.get("country")).setLocale(iVar2.get("locale")).setMccMnc(iVar2.get("mcc_mnc")).setApplicationBuild(iVar2.get("application_build")).build()).build());
            try {
                clientInfo.setSource(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                clientInfo.setSource((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (q4.i iVar3 : (List) entry.getValue()) {
                q4.h encodedPayload = iVar3.getEncodedPayload();
                n4.b encoding = encodedPayload.getEncoding();
                if (encoding.equals(n4.b.of("proto"))) {
                    aVarProtoBuilder = h.protoBuilder(encodedPayload.getBytes());
                } else if (encoding.equals(n4.b.of("json"))) {
                    aVarProtoBuilder = h.jsonBuilder(new String(encodedPayload.getBytes(), Charset.forName("UTF-8")));
                } else {
                    u4.a.w("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", encoding);
                }
                aVarProtoBuilder.setEventTimeMs(iVar3.getEventMillis()).setEventUptimeMs(iVar3.getUptimeMillis()).setTimezoneOffsetSeconds(iVar3.getLong("tz-offset")).setNetworkConnectionInfo(NetworkConnectionInfo.builder().setNetworkType(NetworkConnectionInfo.NetworkType.forNumber(iVar3.getInteger("net-type"))).setMobileSubtype(NetworkConnectionInfo.MobileSubtype.forNumber(iVar3.getInteger("mobile-subtype"))).build());
                if (iVar3.getCode() != null) {
                    aVarProtoBuilder.setEventCode(iVar3.getCode());
                }
                arrayList3.add(aVarProtoBuilder.build());
            }
            clientInfo.setLogEvents(arrayList3);
            arrayList2.add(clientInfo.build());
        }
        g gVarCreate = g.create(arrayList2);
        byte[] extras = eVar.getExtras();
        URL url = this.f17004d;
        if (extras != null) {
            try {
                o4.a aVarFromByteArray = o4.a.fromByteArray(eVar.getExtras());
                aPIKey = aVarFromByteArray.getAPIKey() != null ? aVarFromByteArray.getAPIKey() : null;
                if (aVarFromByteArray.getEndPoint() != null) {
                    String endPoint = aVarFromByteArray.getEndPoint();
                    try {
                        url = new URL(endPoint);
                    } catch (MalformedURLException e10) {
                        throw new IllegalArgumentException("Invalid url: " + endPoint, e10);
                    }
                }
            } catch (IllegalArgumentException unused2) {
                return BackendResponse.fatalError();
            }
        }
        try {
            C0210b c0210b = (C0210b) v4.b.retry(5, new a(url, gVarCreate, aPIKey), new c1.c(this, 1), new pd.a(8));
            int i10 = c0210b.f17011a;
            if (i10 == 200) {
                return BackendResponse.ok(c0210b.f17013c);
            }
            if (i10 < 500 && i10 != 404) {
                return i10 == 400 ? BackendResponse.invalidPayload() : BackendResponse.fatalError();
            }
            return BackendResponse.transientError();
        } catch (IOException e11) {
            u4.a.e("CctTransportBackend", "Could not make request to the backend", e11);
            return BackendResponse.transientError();
        }
    }
}
