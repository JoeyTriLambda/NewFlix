package wd;

import cz.msebera.android.httpclient.HttpHost;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.Util;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class k implements se.f, EventListener.Factory {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21089b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f21090m;

    public /* synthetic */ k(Object obj, int i10) {
        this.f21089b = i10;
        this.f21090m = obj;
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = this.f21089b;
        Object obj2 = this.f21090m;
        switch (i10) {
            case 0:
                m mVar = (m) obj2;
                com.google.gson.o oVar = (com.google.gson.o) obj;
                if (!mVar.f21099k) {
                    com.google.gson.q asJsonObject = oVar.getAsJsonObject();
                    String asString = asJsonObject.get("id").getAsString();
                    String asString2 = asJsonObject.get("uri").getAsString();
                    if (asString2 != null && asString2.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                        mVar.b(asString2, asString);
                        break;
                    } else if (asString != null && asString.length() > 0) {
                        mVar.b("https://api.real-debrid.com/rest/1.0/torrents/info/".concat(asString), asString);
                        break;
                    }
                }
                break;
            case 1:
                p pVar = (p) obj2;
                com.google.gson.o oVar2 = (com.google.gson.o) obj;
                if (!pVar.f21108h) {
                    com.google.gson.q asJsonObject2 = oVar2.getAsJsonObject();
                    String asString3 = asJsonObject2.get("id").getAsString();
                    String asString4 = asJsonObject2.get("uri").getAsString();
                    if (asString4 != null && asString4.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                        pVar.b(asString4, asString3);
                        break;
                    } else if (asString3 != null && asString3.length() > 0) {
                        pVar.b("https://api.real-debrid.com/rest/1.0/torrents/info/".concat(asString3), asString3);
                        break;
                    }
                }
                break;
            default:
                s sVar = (s) obj2;
                com.google.gson.o oVar3 = (com.google.gson.o) obj;
                if (!sVar.f21120l) {
                    com.google.gson.q asJsonObject3 = oVar3.getAsJsonObject();
                    String asString5 = asJsonObject3.get("id").getAsString();
                    String asString6 = asJsonObject3.get("uri").getAsString();
                    if (asString6 != null && asString6.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                        sVar.b(asString6, asString5);
                        break;
                    } else if (asString5 != null && asString5.length() > 0) {
                        sVar.b("https://api.real-debrid.com/rest/1.0/torrents/info/".concat(asString5), asString5);
                        break;
                    }
                }
                break;
        }
    }

    @Override // okhttp3.EventListener.Factory
    public final EventListener create(Call call) {
        return Util.m223asFactory$lambda8((EventListener) this.f21090m, call);
    }
}
