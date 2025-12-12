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

/* compiled from: TorrentBaySeries.java */
/* loaded from: classes2.dex */
public final class m extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f21094f;

    /* renamed from: h, reason: collision with root package name */
    public int f21096h;

    /* renamed from: i, reason: collision with root package name */
    public int f21097i;

    /* renamed from: j, reason: collision with root package name */
    public String f21098j;

    /* renamed from: g, reason: collision with root package name */
    public final String f21095g = "https://thepiratebay.party/search";

    /* renamed from: k, reason: collision with root package name */
    public boolean f21099k = false;

    /* compiled from: TorrentBaySeries.java */
    public class a extends d4.m {
        public a(String str, x xVar, pd.a aVar) {
            super(0, str, xVar, aVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            return ac.c.w("authorization", RealDebridCommon.f12049n + StringUtils.SPACE + RealDebridCommon.f12047b);
        }
    }

    public m(Context context, Movie movie, gd.f fVar) {
        this.f21094f = movie;
        this.f12431b = fVar;
        EventBus.getDefault().register(this);
    }

    public final void b(String str, String str2) {
        App.getInstance().getRequestQueue().add(new a(str, new x(17, this, str2), new pd.a(18)));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.a aVar) {
        this.f21099k = true;
        EventBus.getDefault().unregister(this);
    }

    public void process(int i10, int i11, int i12) {
        if (i12 == 2) {
            this.f12430a = 8;
        }
        this.f21096h = i10;
        this.f21097i = i11;
        if (this.f21099k) {
            return;
        }
        this.f21098j = "S" + be.f.formatSeasonnumber(this.f21096h) + "E" + be.f.formatSeasonnumber(this.f21097i);
        String strReplace = be.f.removeSpecialCharsKeepSpace(this.f21094f.getTitle().replace("&", "") + StringUtils.SPACE + this.f21098j).replace(StringUtils.SPACE, "%20");
        new l(this, ac.c.B(ac.c.o(new StringBuilder(), this.f21095g, "/"), strReplace), new ArrayList()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
