package wd;

import a2.x;
import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: SolidTorrentsMovies.java */
/* loaded from: classes2.dex */
public final class c extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f21062f;

    /* renamed from: g, reason: collision with root package name */
    public final String f21063g = "https://solidtorrents.to";

    /* renamed from: h, reason: collision with root package name */
    public boolean f21064h = false;

    /* compiled from: SolidTorrentsMovies.java */
    public class a extends d4.m {
        public a(String str, x xVar, wd.a aVar) {
            super(0, str, xVar, aVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            return ac.c.w("authorization", RealDebridCommon.f12049n + StringUtils.SPACE + RealDebridCommon.f12047b);
        }
    }

    public c(Context context, Movie movie, gd.f fVar) {
        this.f21062f = movie;
        this.f12431b = fVar;
        EventBus.getDefault().register(this);
    }

    public final void b(String str, String str2) {
        App.getInstance().getRequestQueue().add(new a(str, new x(14, this, str2), new wd.a(this)));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.a aVar) {
        this.f21064h = true;
        EventBus.getDefault().unregister(this);
    }

    public void process(int i10) {
        String strReplace;
        if (i10 > 1) {
            this.f12430a = 8;
        }
        if (this.f21064h) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        Movie movie = this.f21062f;
        sb2.append(movie.getTitle().replace("&", ""));
        sb2.append(StringUtils.SPACE);
        sb2.append(movie.getYear());
        String strRemoveSpecialCharsKeepSpace = be.f.removeSpecialCharsKeepSpace(sb2.toString());
        String strO = ac.c.o(new StringBuilder(), this.f21063g, "/search?q=");
        try {
            strReplace = URLEncoder.encode(strRemoveSpecialCharsKeepSpace, StandardCharsets.UTF_8.toString());
        } catch (Exception unused) {
            strReplace = strO.replace(StringUtils.SPACE, "%20");
        }
        new b(this, ac.c.B(strO, strReplace), new ArrayList()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void appendLog(String str) {
    }
}
