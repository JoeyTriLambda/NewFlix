package pd;

import android.content.Context;
import android.os.AsyncTask;
import gd.f;
import gd.g;
import hd.o;
import java.util.ArrayList;

/* compiled from: M3USpliter.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public boolean f17674a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<o> f17675b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final f f17676c;

    /* renamed from: d, reason: collision with root package name */
    public g f17677d;

    /* renamed from: e, reason: collision with root package name */
    public o f17678e;

    public c(Context context, f fVar) {
        this.f17676c = fVar;
    }

    public void addLink(String str, String str2) {
        StringBuilder sbR;
        String str3;
        if (this.f17677d != null) {
            addLinkHindiSplit(str, str2);
            return;
        }
        o oVar = new o();
        if (this.f17674a) {
            sbR = ac.c.r(str2);
            str3 = " - [GOGOSTREAM] - [DIRECT]";
        } else {
            sbR = ac.c.r(str2);
            str3 = " - [FVSTREAM] - [DIRECT] - English";
        }
        sbR.append(str3);
        oVar.C = sbR.toString();
        oVar.f13047w = true;
        try {
            oVar.f13043s = Integer.parseInt(str2.replace("p", "").trim());
        } catch (Exception unused) {
        }
        oVar.E = true;
        oVar.D = str;
        if (str2 == null || !str2.contains("1080")) {
            this.f17675b.add(oVar);
        } else {
            this.f17678e = oVar;
            oVar.f13043s = 1080;
        }
    }

    public void addLinkHindiSplit(String str, String str2) {
        o oVar = new o();
        oVar.C = str2;
        oVar.f13047w = true;
        oVar.f13046v = true;
        try {
            oVar.f13043s = Integer.parseInt(str2.replace("p", "").trim());
        } catch (Exception unused) {
        }
        oVar.f13038n = true;
        oVar.E = true;
        oVar.D = str;
        if (str2 == null || !str2.contains("1080")) {
            this.f17675b.add(oVar);
        } else {
            this.f17678e = oVar;
        }
    }

    public void process(o oVar) {
        new b(this, oVar.D).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void setHindiM3uSpliCallBack(g gVar) {
        this.f17677d = gVar;
    }
}
