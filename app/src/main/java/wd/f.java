package wd;

import a2.x;
import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: SolidTorrentsSeries.java */
/* loaded from: classes2.dex */
public final class f extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f21071f;

    /* renamed from: g, reason: collision with root package name */
    public int f21072g;

    /* renamed from: h, reason: collision with root package name */
    public int f21073h;

    /* renamed from: i, reason: collision with root package name */
    public String f21074i;

    /* renamed from: j, reason: collision with root package name */
    public final String f21075j = "https://solidtorrents.to";

    /* renamed from: k, reason: collision with root package name */
    public boolean f21076k = false;

    /* compiled from: SolidTorrentsSeries.java */
    public class a extends d4.m {
        public a(String str, x xVar, pd.a aVar) {
            super(0, str, xVar, aVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            return ac.c.w("authorization", RealDebridCommon.f12049n + StringUtils.SPACE + RealDebridCommon.f12047b);
        }
    }

    public f(Context context, Movie movie, gd.f fVar) {
        this.f21071f = movie;
        this.f12431b = fVar;
        EventBus.getDefault().register(this);
    }

    public final void b(String str, String str2) {
        App.getInstance().getRequestQueue().add(new a(str, new x(15, this, str2), new pd.a(14)));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.a aVar) {
        this.f21076k = true;
        EventBus.getDefault().unregister(this);
    }

    public void process(int i10, int i11, int i12) throws UnsupportedEncodingException {
        String strReplace;
        if (i12 > 1) {
            this.f12430a = 8;
        }
        this.f21072g = i10;
        this.f21073h = i11;
        if (this.f21076k) {
            return;
        }
        this.f21074i = "S" + be.f.formatSeasonnumber(this.f21072g) + "E" + be.f.formatSeasonnumber(this.f21073h);
        String strRemoveSpecialCharsKeepSpace = be.f.removeSpecialCharsKeepSpace(be.f.removeSpecialCharsKeepSpace(this.f21071f.getTitle()) + StringUtils.SPACE + this.f21074i);
        String strO = ac.c.o(new StringBuilder(), this.f21075j, "/search?q=");
        try {
            strReplace = URLEncoder.encode(strRemoveSpecialCharsKeepSpace, StandardCharsets.UTF_8.toString());
        } catch (Exception unused) {
            strReplace = strO.replace(StringUtils.SPACE, "%20");
        }
        new e(this, ac.c.B(strO, strReplace), new ArrayList()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
