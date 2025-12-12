package wd;

import a2.x;
import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: TorrentBayMovies.java */
/* loaded from: classes2.dex */
public final class i extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f21083f;

    /* renamed from: g, reason: collision with root package name */
    public final String f21084g = "https://thepiratebay.party/search";

    /* renamed from: h, reason: collision with root package name */
    public boolean f21085h = false;

    /* compiled from: TorrentBayMovies.java */
    public class a extends d4.m {
        public a(String str, x xVar, pd.a aVar) {
            super(0, str, xVar, aVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            return ac.c.w("authorization", RealDebridCommon.f12049n + StringUtils.SPACE + RealDebridCommon.f12047b);
        }
    }

    public i(Context context, Movie movie, gd.f fVar) {
        this.f21083f = movie;
        this.f12431b = fVar;
        EventBus.getDefault().register(this);
    }

    public final void b(String str, String str2) {
        App.getInstance().getRequestQueue().add(new a(str, new x(16, this, str2), new pd.a(16)));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.a aVar) {
        this.f21085h = true;
        EventBus.getDefault().unregister(this);
    }

    public void process(int i10) {
        if (i10 > 1) {
            this.f12430a = 8;
        }
        if (this.f21085h) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        Movie movie = this.f21083f;
        sb2.append(movie.getTitle().replace("&", ""));
        sb2.append(StringUtils.SPACE);
        sb2.append(movie.getYear());
        String strReplace = be.f.removeSpecialCharsKeepSpace(sb2.toString()).replace(StringUtils.SPACE, "%20");
        String strO = ac.c.o(new StringBuilder(), this.f21084g, "/");
        new h(this, ac.c.B(strO, strReplace), new ArrayList()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
