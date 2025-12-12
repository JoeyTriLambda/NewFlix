package flix.com.vision.activities;

import ac.c0;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.d;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.squareup.picasso.Picasso;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import flix.com.vision.activities.player.WebPlayerActivity;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.events.SystemEvent;
import flix.com.vision.helpers.CenterLayoutManager;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.models.MySourceArrayList;
import flix.com.vision.providers.FlixTorFetcher;
import flix.com.vision.providers.NineAnimeFetcher;
import flix.com.vision.tv.Constant;
import gd.f;
import gd.g;
import gd.h;
import hd.o;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import kc.d;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import pd.c;
import qd.b0;
import qd.d0;
import qd.k;
import qd.q;
import qd.s;
import qd.u;
import qd.v;
import qd.x;
import qd.z;
import ub.i0;
import ub.k0;
import ub.l0;
import ub.m0;
import ub.n0;
import ub.o0;
import ub.p0;
import ub.q0;
import vd.j;
import vd.l;
import wd.i;
import wd.m;
import wd.p;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
public class LinksActivity extends wb.a implements f, h, g {
    public static final /* synthetic */ int C0 = 0;
    public ArrayList<o> A0;
    public d B0;
    public LinearLayout K;
    public RelativeLayout L;
    public RelativeLayout M;
    public RelativeLayout N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public SpinKitView S;
    public c4.a T;
    public Typeface U;
    public Typeface V;
    public RecyclerView W;
    public MySourceArrayList X;
    public Movie Y;
    public c0 Z;

    /* renamed from: a0, reason: collision with root package name */
    public ImageView f11671a0;

    /* renamed from: b0, reason: collision with root package name */
    public ImageView f11672b0;

    /* renamed from: c0, reason: collision with root package name */
    public ImageView f11673c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f11674d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f11675e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f11676f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f11677g0;

    /* renamed from: h0, reason: collision with root package name */
    public ImageView f11678h0;

    /* renamed from: i0, reason: collision with root package name */
    public ImageView f11679i0;

    /* renamed from: j0, reason: collision with root package name */
    public TextView f11680j0;

    /* renamed from: k0, reason: collision with root package name */
    public TextView f11681k0;

    /* renamed from: l0, reason: collision with root package name */
    public TextView f11682l0;

    /* renamed from: m0, reason: collision with root package name */
    public qe.b f11683m0;

    /* renamed from: n0, reason: collision with root package name */
    public String f11684n0 = null;

    /* renamed from: o0, reason: collision with root package name */
    public String f11685o0 = null;

    /* renamed from: p0, reason: collision with root package name */
    public String f11686p0 = App.getInstance().f11578z;

    /* renamed from: q0, reason: collision with root package name */
    public Bundle f11687q0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f11688r0;

    /* renamed from: s0, reason: collision with root package name */
    public Handler f11689s0;

    /* renamed from: t0, reason: collision with root package name */
    public i0 f11690t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f11691u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f11692v0;

    /* renamed from: w0, reason: collision with root package name */
    public String f11693w0;

    /* renamed from: x0, reason: collision with root package name */
    public String f11694x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f11695y0;

    /* renamed from: z0, reason: collision with root package name */
    public Menu f11696z0;

    private transient OkHttpClient flixtorClient;

    public LinksActivity() {
        new ArrayList();
        this.f11692v0 = 0;
        this.f11694x0 = "";
        this.A0 = new ArrayList<>();
        this.B0 = null;
    }

    public static void PlayExternal(int i10, o oVar, String str, Movie movie, Activity activity, int i11) {
        if (movie != null) {
            App.getInstance().f11566n = true;
            try {
                App.getInstance().f11573u.addtoWatching(movie);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (i10 == 1) {
            fd.h.PlayMXPlayer(activity, str, oVar.D, null, oVar.f13040p, i11);
        } else if (i10 == 2) {
            fd.h.PlayVLC(activity, str, oVar.D, null, oVar.f13040p, i11);
        } else {
            if (i10 != 3) {
                return;
            }
            fd.h.PlayXPlayer(activity, null, oVar.D);
        }
    }

    public static void setRDQtyLabel(o oVar) {
        String str;
        if (oVar == null || (str = oVar.D) == null) {
            return;
        }
        if (str.contains("480p")) {
            oVar.C = "480p - " + oVar.C;
            oVar.f13043s = 480;
            return;
        }
        if (oVar.D.contains("720p")) {
            oVar.f13043s = 720;
            oVar.C = "720p - " + oVar.C;
            return;
        }
        if (oVar.D.contains("1080p")) {
            oVar.f13043s = 1080;
            oVar.C = "1080p - " + oVar.C;
            return;
        }
        if (oVar.D.contains("1440")) {
            oVar.f13043s = 1440;
            oVar.C = "1440 - " + oVar.C;
            return;
        }
        if (oVar.D.contains("2160p")) {
            oVar.f13043s = 4000;
            oVar.C = "4K - " + oVar.C;
            return;
        }
        if (oVar.D.contains("4320p")) {
            oVar.f13043s = 8000;
            oVar.C = "8K - " + oVar.C;
            return;
        }
        if (oVar.D.toLowerCase().contains(".sd")) {
            oVar.f13043s = 720;
            oVar.C = "720p - " + oVar.C;
            return;
        }
        if (oVar.D.toLowerCase().contains(".4k")) {
            oVar.f13043s = 4000;
            oVar.C = "4K - " + oVar.C;
            return;
        }
        if (oVar.D.toLowerCase().contains(".hdtv")) {
            oVar.f13043s = 1080;
            oVar.C = "1080p - " + oVar.C;
            return;
        }
        if (oVar.D.toLowerCase().contains(".hd")) {
            oVar.f13043s = 1080;
            oVar.C = "1080p - " + oVar.C;
        }
    }

    @Override // gd.g
    public void OnM3USuccess(ArrayList<o> arrayList) {
        d dVar = this.B0;
        if (dVar != null) {
            try {
                dVar.dismiss();
            } catch (Exception unused) {
            }
        }
        this.A0 = arrayList;
        try {
            ArrayList arrayList2 = new ArrayList();
            int i10 = 0;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                arrayList2.add(arrayList.get(i11).C.toUpperCase(Locale.ROOT));
            }
            CharSequence[] charSequenceArr = (CharSequence[]) arrayList2.toArray(new CharSequence[arrayList2.size()]);
            d.a aVar = new d.a(new ContextThemeWrapper(this, R.style.AlertDialogNoHeader));
            aVar.setSingleChoiceItems(charSequenceArr, -1, new o0(this, arrayList, i10));
            aVar.setOnDismissListener(new p0(0));
            aVar.show();
        } catch (Exception unused2) {
        }
    }

    @Override // gd.f
    public void OnSuccess(ArrayList<o> arrayList) {
        if (arrayList.size() > 0) {
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next.D.contains("google")) {
                    next.f13047w = true;
                    if (new Random().nextBoolean()) {
                        next.C = "720p -  " + next.C;
                    } else {
                        next.C = "1080p -  " + next.C;
                    }
                }
                if (next.D.contains("loadvid") || next.D.contains("vidcloud") || next.D.contains("vcstream")) {
                    EventBus.getDefault().post(next);
                }
                if (!next.C.contains("HLS") && next.f13047w) {
                    this.X.add(0, next);
                } else {
                    this.X.add(next);
                }
                if (next.f13047w) {
                    this.f11692v0++;
                }
            }
        }
    }

    public final void d(final o oVar) {
        final int i10 = 1;
        if (oVar.f13049y) {
            FragmentManager fragmentManager = getFragmentManager();
            kc.d dVarNewInstance = kc.d.newInstance(this, true);
            dVarNewInstance.setTitle("Play With MX Player");
            dVarNewInstance.setMessage("This File Format can only be played with MX Player. \nPlease make sure MX Player is installed");
            dVarNewInstance.setButton1("CANCEL", new q0(i10));
            dVarNewInstance.setButton2("PLAY WITH MX Player", new View.OnClickListener(this) { // from class: ub.r0

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ LinksActivity f20259m;

                {
                    this.f20259m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i11 = i10;
                    LinksActivity linksActivity = this.f20259m;
                    hd.o oVar2 = oVar;
                    switch (i11) {
                        case 0:
                            int i12 = LinksActivity.C0;
                            linksActivity.getClass();
                            try {
                                String title = linksActivity.Y.getTitle();
                                if (linksActivity.Y.isSeries()) {
                                    title = title + " - S" + linksActivity.f11674d0 + "E" + linksActivity.f11675e0 + " - " + linksActivity.f11694x0;
                                }
                                fd.h.PlayVLC(linksActivity, title, oVar2.D, null, oVar2.f13040p, App.getInstance().f11574v.getInt(linksActivity.f11685o0, -1));
                                App.getInstance().f11566n = true;
                                try {
                                    App.getInstance().f11573u.addtoWatching(linksActivity.Y);
                                    break;
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                }
                            } catch (Exception unused) {
                                return;
                            }
                        default:
                            int i13 = LinksActivity.C0;
                            linksActivity.getClass();
                            try {
                                String title2 = linksActivity.Y.getTitle();
                                if (linksActivity.Y.isSeries()) {
                                    title2 = title2 + " - S" + linksActivity.f11674d0 + "E" + linksActivity.f11675e0 + " - " + linksActivity.f11694x0;
                                }
                                fd.h.PlayMXPlayer(linksActivity, title2, oVar2.D, null, oVar2.f13040p, App.getInstance().f11574v.getInt(linksActivity.f11685o0, -1));
                                App.getInstance().f11566n = true;
                                try {
                                    App.getInstance().f11573u.addtoWatching(linksActivity.Y);
                                    break;
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                    return;
                                }
                            } catch (Exception unused2) {
                                return;
                            }
                    }
                }
            });
            try {
                dVarNewInstance.show(fragmentManager, "");
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        final int i11 = 0;
        if (oVar.f13039o) {
            FragmentManager fragmentManager2 = getFragmentManager();
            kc.d dVarNewInstance2 = kc.d.newInstance(this, true);
            dVarNewInstance2.setTitle("Play With VLC");
            dVarNewInstance2.setMessage("This File Format can only be played with VLC. \nPlease make sure VLC is installed");
            dVarNewInstance2.setButton1("CANCEL", new q0(i11));
            dVarNewInstance2.setButton2("PLAY WITH VLC", new View.OnClickListener(this) { // from class: ub.r0

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ LinksActivity f20259m;

                {
                    this.f20259m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i112 = i11;
                    LinksActivity linksActivity = this.f20259m;
                    hd.o oVar2 = oVar;
                    switch (i112) {
                        case 0:
                            int i12 = LinksActivity.C0;
                            linksActivity.getClass();
                            try {
                                String title = linksActivity.Y.getTitle();
                                if (linksActivity.Y.isSeries()) {
                                    title = title + " - S" + linksActivity.f11674d0 + "E" + linksActivity.f11675e0 + " - " + linksActivity.f11694x0;
                                }
                                fd.h.PlayVLC(linksActivity, title, oVar2.D, null, oVar2.f13040p, App.getInstance().f11574v.getInt(linksActivity.f11685o0, -1));
                                App.getInstance().f11566n = true;
                                try {
                                    App.getInstance().f11573u.addtoWatching(linksActivity.Y);
                                    break;
                                } catch (Exception e102) {
                                    e102.printStackTrace();
                                }
                            } catch (Exception unused) {
                                return;
                            }
                        default:
                            int i13 = LinksActivity.C0;
                            linksActivity.getClass();
                            try {
                                String title2 = linksActivity.Y.getTitle();
                                if (linksActivity.Y.isSeries()) {
                                    title2 = title2 + " - S" + linksActivity.f11674d0 + "E" + linksActivity.f11675e0 + " - " + linksActivity.f11694x0;
                                }
                                fd.h.PlayMXPlayer(linksActivity, title2, oVar2.D, null, oVar2.f13040p, App.getInstance().f11574v.getInt(linksActivity.f11685o0, -1));
                                App.getInstance().f11566n = true;
                                try {
                                    App.getInstance().f11573u.addtoWatching(linksActivity.Y);
                                    break;
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                    return;
                                }
                            } catch (Exception unused2) {
                                return;
                            }
                    }
                }
            });
            try {
                dVarNewInstance2.show(fragmentManager2, "");
                return;
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        if (!oVar.E && oVar.isSplitable() && !App.getInstance().f11574v.getBoolean("pref_adult_zone_always_play_best", true)) {
            FragmentManager fragmentManager3 = getFragmentManager();
            kc.d dVarNewInstance3 = kc.d.newInstance(this, false);
            this.B0 = dVarNewInstance3;
            dVarNewInstance3.setloading();
            try {
                this.B0.show(fragmentManager3, "");
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            c cVar = new c(this, this);
            cVar.setHindiM3uSpliCallBack(this);
            cVar.process(oVar);
            return;
        }
        int i12 = App.getInstance().f11574v.getInt("player_index", 0);
        if (i12 <= 0 || i12 >= 4) {
            if (i12 != 4) {
                e(oVar);
                return;
            }
            try {
                App.getInstance().f11566n = true;
                try {
                    App.getInstance().f11573u.addtoWatching(this.Y);
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(oVar.D));
                intent.setDataAndType(Uri.parse(oVar.D), "video/mp4");
                startActivity(intent);
                return;
            } catch (Exception e14) {
                be.d.makeToast(this, e14.getMessage(), false);
                return;
            }
        }
        String title = this.Y.getTitle();
        if (this.Y.isSeries()) {
            StringBuilder sbU = ac.c.u(title, " - S");
            sbU.append(this.f11674d0);
            sbU.append("E");
            sbU.append(this.f11675e0);
            sbU.append(" - ");
            sbU.append(this.f11694x0);
            title = sbU.toString();
        }
        String str = title;
        try {
            PlayExternal(i12, oVar, str, this.Y, this, App.getInstance().f11574v.getInt(this.f11685o0, -1));
        } catch (Exception unused) {
            Toast.makeText(getBaseContext(), "Failed to load external Player, Make sure it is installed", 1).show();
            e(oVar);
        }
    }

    public final void e(o oVar) {
        String title = this.Y.getTitle();
        if (this.Y.isSeries()) {
            StringBuilder sbU = ac.c.u(title, " · S");
            sbU.append(this.f11674d0);
            sbU.append("E");
            sbU.append(this.f11675e0);
            title = sbU.toString();
        }
        App.getInstance().f11566n = true;
        try {
            App.getInstance().f11573u.addtoWatching(this.Y);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        Intent intent = new Intent(this, (Class<?>) SimpleVideoPlayer.class);
        intent.putExtra("mimeType", oVar.f13042r);
        intent.putExtra("season_year", this.f11677g0);
        intent.putExtra("movie", this.Y);
        intent.putExtra("title", title);
        intent.putExtra("language", oVar.f13045u);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (oVar.f13038n) {
            Iterator<o> it = this.X.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next.f13047w && next.f13038n && next.E) {
                    arrayList.add(next);
                }
            }
            ArrayList<o> arrayList2 = this.A0;
            if (arrayList2 != null) {
                Iterator<o> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    o next2 = it2.next();
                    if (next2.f13047w && next2.f13038n && next2.E) {
                        arrayList.add(next2);
                    }
                }
            }
        } else {
            Iterator<o> it3 = this.X.iterator();
            while (it3.hasNext()) {
                o next3 = it3.next();
                if (next3.f13047w && !next3.f13039o) {
                    arrayList.add(next3);
                }
            }
        }
        intent.putExtra("current_index", arrayList.indexOf(oVar));
        intent.putParcelableArrayListExtra("sources", arrayList);
        if (this.Y.isAnime() || this.Y.f12397o) {
            this.f11693w0 = "Episode " + this.f11675e0;
        }
        intent.putExtra("title_episode", this.f11693w0);
        intent.putExtra("season_number", this.f11674d0);
        intent.putExtra("episode_number", this.f11675e0);
        intent.putExtra("episode_count", this.f11676f0);
        intent.putExtra("episode", this.f11694x0);
        int duration = this.f11695y0;
        if (duration <= 0) {
            duration = this.Y.getDuration();
        }
        intent.putExtra("runtime", duration);
        intent.putExtra("streamUrl", oVar.D);
        intent.putExtra("movie_id", this.f11685o0);
        if (be.f.notNull(oVar.f13040p)) {
            intent.putExtra("referer", oVar.f13040p);
        }
        String str = this.Y.f12398p;
        if (str != null && !str.isEmpty()) {
            intent.putExtra("movie_rating", this.Y.f12398p + "");
        }
        startActivity(intent);
    }

    public final void f(String str, String str2, String str3, String str4) {
        this.f11693w0 = str3;
        if (this.f11679i0 == null || this.f11680j0 == null || this.Y.getType() != 1) {
            return;
        }
        if (str.length() > 0) {
            try {
                Picasso.get().load(str).fit().centerCrop().into(this.f11679i0);
            } catch (OutOfMemoryError e10) {
                e10.printStackTrace();
            }
        }
        if (str2.length() > 0) {
            this.f11680j0.setText(str2);
        }
        if (str3.length() > 0) {
            this.f11681k0.setText("S" + this.f11674d0 + "E" + this.f11675e0 + " · " + str3);
        }
        if (str4 == null || str4.length() <= 0) {
            return;
        }
        this.f11682l0.setText(str4);
    }

    public void linkClicked(o oVar, boolean z10) {
        String title = this.Y.getTitle();
        if (this.Y.isSeries()) {
            StringBuilder sbU = ac.c.u(title, " · S");
            sbU.append(this.f11674d0);
            sbU.append("E");
            sbU.append(this.f11675e0);
            title = sbU.toString();
        }
        App.getInstance().f11567o = true;
        if (oVar.f13047w) {
            d(oVar);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) WebPlayerActivity.class);
        String image_url = this.Y.getType() > 2 ? this.Y.getImage_url() : this.Y.getCover();
        if (getResources().getConfiguration().orientation == 1) {
            image_url = this.Y.getImage_url() != null ? this.Y.getImage_url().replace("w185", "w500").replace("w342", "w500") : this.Y.getCover();
        }
        if (this.Y.f12394b) {
            String str = App.getInstance().f11578z + getString(R.string.api_path_movie) + this.Y.getMovieId() + ".png";
            if (this.Y.isSeries()) {
                str = App.getInstance().f11578z + getString(R.string.api_path_tv) + this.Y.getMovieId() + ".png";
            }
            intent.putExtra("title_logo", str);
        }
        String str2 = this.Y.f12398p;
        if (str2 != null && !str2.isEmpty()) {
            intent.putExtra("movie_rating", this.Y.f12398p + "");
        }
        intent.putExtra("url", oVar.D);
        intent.putExtra("move_clock", false);
        intent.putExtra("poster", image_url);
        intent.putExtra("episode_number", this.f11675e0);
        intent.putExtra("season_number", this.f11674d0);
        intent.putExtra("title", title);
        if (this.Y.isAnime() || this.Y.f12397o) {
            this.f11693w0 = "Episode " + this.f11675e0;
        }
        intent.putExtra("title_episode", this.f11693w0);
        intent.putExtra("movie_url", this.Y.getUrl());
        intent.putExtra("movie", this.Y);
        intent.putExtra("title_simple", this.Y.getTitle());
        intent.putExtra("img_url", this.Y.getImage_url());
        intent.putExtra("movie_url", this.Y.getUrl());
        App.getInstance().f11566n = true;
        try {
            App.getInstance().f11573u.addtoWatching(this.Y);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        int duration = this.f11695y0;
        if (duration <= 0) {
            duration = this.Y.getDuration();
        }
        intent.putExtra("runtime", duration);
        intent.putExtra("BIG_POSTER_URL", "");
        startActivity(intent);
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        String stringExtra;
        super.onActivityResult(i10, i11, intent);
        if (i10 == 6261) {
            if (i11 != -1 || intent == null || (stringExtra = intent.getStringExtra("end_by")) == null) {
                return;
            }
            if (!stringExtra.equals("user")) {
                if (!stringExtra.equals("playback_completion") || this.Y.isSeries()) {
                    return;
                }
                App.getInstance().f11573u.markAsWatched(this.Y);
                App.getInstance().f11574v.edit().remove(this.f11685o0).apply();
                be.d.makeToast(this, "Playback completed. Marking as Watched", false);
                return;
            }
            long longExtra = intent.getLongExtra("position", -1L);
            if (longExtra > 0) {
                if (((int) ((100 * longExtra) / (this.Y.getDuration() * 60000))) > 95 && !this.Y.isSeries()) {
                    App.getInstance().f11573u.markAsWatched(this.Y);
                    App.getInstance().f11574v.edit().remove(this.f11685o0).apply();
                    return;
                }
                String str = this.f11685o0;
                if (str == null || str.isEmpty()) {
                    return;
                }
                App.getInstance().f11574v.edit().putInt(this.f11685o0, (int) longExtra).apply();
                return;
            }
            return;
        }
        if (i10 == 6565) {
            if (i11 == -1) {
                if (intent != null) {
                    long longExtra2 = intent.getLongExtra("extra_position", -1L);
                    if (longExtra2 > 0) {
                        if (((int) ((100 * longExtra2) / (this.Y.getDuration() * 60000))) > 95 && !this.Y.isSeries()) {
                            App.getInstance().f11573u.markAsWatched(this.Y);
                            App.getInstance().f11574v.edit().remove(this.f11685o0).apply();
                            return;
                        }
                        String str2 = this.f11685o0;
                        if (str2 == null || str2.isEmpty()) {
                            return;
                        }
                        App.getInstance().f11574v.edit().putInt(this.f11685o0, (int) longExtra2).apply();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i11 == 0) {
                be.d.makeToast(this, "No compatible cpu, incorrect VLC abi variant installed", false);
                return;
            }
            if (i11 == 2) {
                be.d.makeToast(this, "Connection failed to audio service", false);
                return;
            }
            if (i11 == 3) {
                be.d.makeToast(this, "Error with hardware acceleration, user refused to switch to software decoding", false);
            } else if (i11 == 4) {
                be.d.makeToast(this, "VLC is not able to play this file, it could be incorrect path/uri, not supported codec or broken file", false);
            } else {
                if (i11 != 5) {
                    return;
                }
                be.d.makeToast(this, "VLC continues playback, but for audio track only. (Audio file detected or user chose to)", false);
            }
        }
    }

    @Override // gd.h
    public void onAdded() {
        SystemEvent systemEvent = new SystemEvent();
        systemEvent.f12187a = SystemEvent.ACTION.REFRESH_COUNTER;
        EventBus.getDefault().post(systemEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        HashSet hashSet;
        super.onBackPressed();
        EventBus.getDefault().post(new Constants.a());
        if (AllDebridCommon.f12043n && (hashSet = AllDebridCommon.f12041b) != null && hashSet.size() > 0) {
            App.deleteAllMagnetsAllDebrid();
        }
        if (!RealDebridCommon.f12051p || RealDebridCommon.f12050o == null || AllDebridCommon.f12041b.size() <= 0) {
            return;
        }
        App.getInstance().deleteTorrentsRealDebridNew();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [ub.i0] */
    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) throws UnsupportedEncodingException {
        MenuItem menuItemFindItem;
        Movie movie;
        RelativeLayout relativeLayout;
        SpinKitView spinKitView;
        super.onCreate(bundle);
        this.f11687q0 = bundle;
        boolean z10 = true;
        z10 = true;
        z10 = true;
        final int i10 = 0;
        if (bundle == null) {
            ArrayList<String> arrayList = App.J;
            if (arrayList == null) {
                App.J = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            if (App.getInstance().f11574v.getBoolean("IS_RD_LOGGED_IN", false)) {
                App.getInstance().refreshTokenRD();
            }
            if (App.getInstance().f11574v.getBoolean("PREM_LOGGED_IN", false)) {
                PremiumizeCommon.f12045b = true;
                SharedPreferences sharedPreferences = App.getInstance().f11574v;
                String str = Constants.f12319a;
                PremiumizeCommon.f12046m = sharedPreferences.getString("prem_apikey", null);
            }
            if (App.getInstance().f11574v.getBoolean("ALL_DEBRID_LOGGED_IN", false)) {
                AllDebridCommon.f12043n = true;
                SharedPreferences sharedPreferences2 = App.getInstance().f11574v;
                String str2 = Constants.f12319a;
                AllDebridCommon.f12044o = sharedPreferences2.getString("all_debrid_apikey", null);
            }
        }
        this.f11686p0 = Constants.f12319a;
        this.Y = (Movie) getIntent().getSerializableExtra("movie");
        SharedPreferences sharedPreferences3 = App.getInstance().f11574v;
        String str3 = Constant.f12450b;
        this.f11684n0 = sharedPreferences3.getString("autoembed_url", "https://autoembed.co");
        RealDebridCommon.f12051p = App.getInstance().f11574v.getBoolean("IS_RD_LOGGED_IN", false);
        Movie movie2 = this.Y;
        if (movie2 == null || !movie2.isSeries()) {
            setContentView(R.layout.activity_links_movies);
        } else {
            setContentView(R.layout.activity_links);
        }
        this.f11689s0 = new Handler();
        this.f11690t0 = new Runnable(this) { // from class: ub.i0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ LinksActivity f20201m;

            {
                this.f20201m = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i11 = i10;
                LinksActivity linksActivity = this.f20201m;
                switch (i11) {
                    case 0:
                        SpinKitView spinKitView2 = linksActivity.S;
                        if (spinKitView2 != null) {
                            spinKitView2.setVisibility(8);
                            RelativeLayout relativeLayout2 = linksActivity.N;
                            if (relativeLayout2 != null) {
                                relativeLayout2.setVisibility(8);
                                break;
                            }
                        }
                        break;
                    case 1:
                        linksActivity.M.setOnClickListener(new k0(linksActivity, 4));
                        break;
                    case 2:
                        for (int i12 = 1; i12 < 5; i12++) {
                            StringBuilder sbV = ac.c.v("https://uflix.cc/mPlayer?movieid=", linksActivity.Y.getTitle().replaceAll("[-+.^:,]", "").trim().replace(StringUtils.SPACE, "-").replace("--", "-"), "-");
                            sbV.append(linksActivity.Y.I);
                            sbV.append("&stream=stream");
                            sbV.append(i12);
                            String string = sbV.toString();
                            hd.o oVar = new hd.o();
                            oVar.D = string;
                            oVar.C = o1.a.d("1080p - 720p - 480p - [UFLIX", i12, "]-[EMBED]");
                            oVar.F = true;
                            linksActivity.X.add(oVar);
                        }
                        int i13 = LinksActivity.C0;
                        linksActivity.getClass();
                        break;
                    case 3:
                        int i14 = LinksActivity.C0;
                        linksActivity.getClass();
                        SharedPreferences sharedPreferences4 = App.getInstance().f11574v;
                        String str4 = Constant.f12450b;
                        new td.c(linksActivity, linksActivity, sharedPreferences4.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID());
                        break;
                    case 4:
                        linksActivity.Y.getMovieId();
                        new hd.o();
                        hd.o oVar2 = new hd.o();
                        oVar2.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId();
                        oVar2.C = "1080p - 720p - 480p [FLIXVISION2]";
                        linksActivity.X.add(oVar2);
                        String str5 = "https://vidsrc.me/embed/" + linksActivity.Y.getMovieId();
                        hd.o oVar3 = new hd.o();
                        oVar3.D = str5;
                        oVar3.C = "1080p - 720p - 480p [FLIXVISION5]";
                        linksActivity.X.add(oVar3);
                        linksActivity.Z.notifyDataSetChanged();
                        linksActivity.W.setItemAnimator(null);
                        break;
                    case 5:
                        int i15 = LinksActivity.C0;
                        String strB = ac.c.B("S" + be.f.formatSeasonnumber(linksActivity.f11674d0), "E" + be.f.formatSeasonnumber(linksActivity.f11675e0));
                        for (int i16 = 1; i16 < 5; i16++) {
                            String str6 = "https://uflix.cc/sPlayer?serieid=" + linksActivity.Y.getTitle().toLowerCase().replace(StringUtils.SPACE, "-") + "-" + linksActivity.Y.I + "&episodeid=" + strB + "&stream=stream" + i16;
                            hd.o oVar4 = new hd.o();
                            oVar4.D = str6;
                            oVar4.C = o1.a.d("1080p - 720p - 480p - [UFLIX-", i16, "]-[EMBED]");
                            oVar4.F = true;
                            linksActivity.X.add(oVar4);
                        }
                        break;
                    case 6:
                        int i17 = LinksActivity.C0;
                        linksActivity.getClass();
                        SharedPreferences sharedPreferences5 = App.getInstance().f11574v;
                        String str7 = Constant.f12450b;
                        new td.f(linksActivity, linksActivity, sharedPreferences5.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID(), linksActivity.f11674d0, linksActivity.f11675e0);
                        break;
                    case 7:
                        int i18 = LinksActivity.C0;
                        String str8 = linksActivity.f11686p0 + "/ext/gotv.html?goto=" + linksActivity.Y.getMovieId() + "&s=" + linksActivity.f11674d0 + "&e=" + linksActivity.f11675e0;
                        hd.o oVar5 = new hd.o();
                        oVar5.D = str8;
                        oVar5.C = "1080p - 720p - 480p [FLIXVISION]";
                        linksActivity.X.add(oVar5);
                        oVar5.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId() + "&season=" + linksActivity.f11674d0 + "&episode=" + linksActivity.f11675e0;
                        oVar5.C = "1080p - 720p - 480p [FLIXVISION2]";
                        linksActivity.X.add(oVar5);
                        oVar5.D = linksActivity.f11684n0 + "/tv/tmdb/" + linksActivity.Y.getMovieId() + "-" + linksActivity.f11674d0 + "-" + linksActivity.f11694x0;
                        oVar5.C = "1080p - 720p - 480p-[FLIXVISION3]";
                        linksActivity.X.add(oVar5);
                        StringBuilder sb2 = new StringBuilder("https://vidsrc.me/embed/");
                        sb2.append(linksActivity.Y.getMovieId());
                        sb2.append("/");
                        sb2.append(linksActivity.f11674d0);
                        sb2.append("-");
                        String strM = ac.c.m(sb2, linksActivity.f11675e0, "/");
                        hd.o oVar6 = new hd.o();
                        oVar6.D = strM;
                        oVar6.C = "1080p - 720p - 480p [FLIXVISION5]";
                        linksActivity.X.add(oVar6);
                        linksActivity.Z.notifyDataSetChanged();
                        linksActivity.W.setItemAnimator(null);
                        break;
                    default:
                        linksActivity.M.setOnClickListener(new k0(linksActivity, 5));
                        break;
                }
            }
        };
        App.getInstance().f11574v.getInt("mouse_toggle_mode", 0);
        this.U = Typeface.createFromAsset(getAssets(), "fonts/pproduct_sans_rregular.ttf");
        this.V = Typeface.createFromAsset(getAssets(), "fonts/product_sans_bold.ttf");
        this.T = new c4.a();
        EventBus.getDefault().register(this);
        this.f11673c0 = (ImageView) findViewById(R.id.settings_image_view);
        this.K = (LinearLayout) findViewById(R.id.settings_button_movies_page);
        this.N = (RelativeLayout) findViewById(R.id.stop_rd_fetch_button);
        this.W = (RecyclerView) findViewById(R.id.listview_links);
        this.R = (TextView) findViewById(R.id.links_act_page_title_rd);
        this.f11679i0 = (ImageView) findViewById(R.id.mini_poster);
        this.f11671a0 = (ImageView) findViewById(R.id.refresh_button_imageview);
        this.P = (TextView) findViewById(R.id.links_act_page_title);
        this.Q = (TextView) findViewById(R.id.links_act_reload_text);
        this.f11672b0 = (ImageView) findViewById(R.id.settings_button_imageview);
        this.L = (RelativeLayout) findViewById(R.id.settings_button_links_act);
        this.O = (TextView) findViewById(R.id.links_act__settings_text);
        this.f11680j0 = (TextView) findViewById(R.id.plot_text);
        this.M = (RelativeLayout) findViewById(R.id.reload_button_links_act);
        this.S = (SpinKitView) findViewById(R.id.spin_kit_2);
        this.f11681k0 = (TextView) findViewById(R.id.episode_title);
        this.f11682l0 = (TextView) findViewById(R.id.aired_on);
        this.X = new MySourceArrayList(this);
        this.f11678h0 = (ImageView) findViewById(R.id.background_image);
        if (bundle != null && (spinKitView = this.S) != null) {
            spinKitView.setVisibility(8);
            this.N.setVisibility(8);
        }
        c0 c0Var = new c0(this, this.X);
        this.Z = c0Var;
        c0Var.setHasStableIds(true);
        this.W.setAdapter(this.Z);
        this.W.setLayoutManager(new CenterLayoutManager(this, 1, false));
        o1.a.h(8, this.W);
        if (this.f11673c0 != null) {
            this.K.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.j0

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ LinksActivity f20208m;

                {
                    this.f20208m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z11) {
                    int i11 = i10;
                    LinksActivity linksActivity = this.f20208m;
                    switch (i11) {
                        case 0:
                            if (!z11) {
                                linksActivity.f11673c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                break;
                            } else {
                                linksActivity.f11673c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                break;
                            }
                        case 1:
                            if (!z11) {
                                linksActivity.f11671a0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                linksActivity.Q.setTextColor(linksActivity.getResources().getColor(R.color.white));
                                linksActivity.M.animate().scaleX(1.0f).start();
                                linksActivity.M.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                linksActivity.f11671a0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                linksActivity.Q.setTextColor(linksActivity.getResources().getColor(R.color.black));
                                o1.a.k(linksActivity.M, 100L, 1.03f);
                                o1.a.r(linksActivity.M, 100L, 1.03f);
                                break;
                            }
                        default:
                            if (!z11) {
                                linksActivity.f11672b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                linksActivity.O.setTextColor(linksActivity.getResources().getColor(R.color.white));
                                linksActivity.L.animate().scaleX(1.0f).start();
                                linksActivity.L.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                linksActivity.f11672b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                linksActivity.O.setTextColor(linksActivity.getResources().getColor(R.color.black));
                                o1.a.k(linksActivity.L, 100L, 1.03f);
                                o1.a.r(linksActivity.L, 100L, 1.03f);
                                break;
                            }
                    }
                }
            });
        }
        LinearLayout linearLayout = this.K;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new k0(this, 0));
        }
        Movie movie3 = this.Y;
        if (movie3 == null) {
            return;
        }
        final int i11 = 2;
        String image_url = movie3.getType() > 2 ? this.Y.getImage_url() : this.Y.getCover();
        if (getResources().getConfiguration().orientation == 1 && this.Y.getImage_url() != null) {
            image_url = this.Y.getImage_url().replace("w185", "w500").replace("w342", "w500");
        }
        try {
            Picasso.get().load(image_url).fit().centerCrop().into(this.f11678h0);
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
        }
        if (this.Y.isSeries()) {
            qe.b bVar = this.f11683m0;
            if (bVar != null) {
                bVar.dispose();
            }
            String str4 = getIntent().getIntExtra("episode_id", -1) + "";
            this.f11683m0 = bc.a.getEpisode(this, this.Y.getMovieId() + "", getIntent().getIntExtra("season", -1) + "", str4).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new c1.c(this, 17), new n0(0));
        }
        if (this.Y.isSeries() || this.Y.isAnime() || this.Y.f12397o) {
            this.f11674d0 = getIntent().getIntExtra("season", 0);
            this.f11675e0 = getIntent().getIntExtra("episode_number", 0);
            this.f11677g0 = getIntent().getStringExtra("season_year");
            this.f11676f0 = getIntent().getIntExtra("episode_count", 0);
            this.Y.H = ac.c.m(new StringBuilder(), this.f11674d0, "");
        }
        if (this.Y.isAnime()) {
            fetchNineAnimeSource();
        } else {
            fetchFlixTorSource();
        }
        final int i12 = 3;
        if (bundle != null) {
            try {
                this.X.addAll(bundle.getParcelableArrayList("sources"));
                this.Z.notifyDataSetChanged();
                this.W.setItemAnimator(null);
                Menu menu = this.f11696z0;
                if (menu != null && (menuItemFindItem = menu.findItem(R.id.action_count)) != null) {
                    menuItemFindItem.setTitle(this.X.size() + "");
                }
            } catch (Exception unused) {
            }
        } else if (this.Y.getType() == 3) {
            String stringExtra = getIntent().getStringExtra("url");
            if (stringExtra != null) {
                stringExtra = stringExtra.replace("www9.gogoanime.io", "gogoanime.pe").replace("gogoanime.io", "gogoanime.pe");
            }
            this.f11675e0 = getIntent().getIntExtra("episode_number", 0);
            if (stringExtra != null) {
                new qd.d(this, this, this.Y).Process(stringExtra);
            }
        } else if (this.Y.isDrama()) {
            new rd.b(this, this.Y, this).process(getIntent().getStringExtra("url"));
        } else if (!App.getInstance().f11574v.getBoolean("pref_show_debrid_links_only", false)) {
            boolean z11 = App.getInstance().f11574v.getBoolean("hindi_include_english", true);
            if (this.Y.getType() == 0) {
                new Handler().postDelayed(new Runnable(this) { // from class: ub.i0

                    /* renamed from: m, reason: collision with root package name */
                    public final /* synthetic */ LinksActivity f20201m;

                    {
                        this.f20201m = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        int i112 = i11;
                        LinksActivity linksActivity = this.f20201m;
                        switch (i112) {
                            case 0:
                                SpinKitView spinKitView2 = linksActivity.S;
                                if (spinKitView2 != null) {
                                    spinKitView2.setVisibility(8);
                                    RelativeLayout relativeLayout2 = linksActivity.N;
                                    if (relativeLayout2 != null) {
                                        relativeLayout2.setVisibility(8);
                                        break;
                                    }
                                }
                                break;
                            case 1:
                                linksActivity.M.setOnClickListener(new k0(linksActivity, 4));
                                break;
                            case 2:
                                for (int i122 = 1; i122 < 5; i122++) {
                                    StringBuilder sbV = ac.c.v("https://uflix.cc/mPlayer?movieid=", linksActivity.Y.getTitle().replaceAll("[-+.^:,]", "").trim().replace(StringUtils.SPACE, "-").replace("--", "-"), "-");
                                    sbV.append(linksActivity.Y.I);
                                    sbV.append("&stream=stream");
                                    sbV.append(i122);
                                    String string = sbV.toString();
                                    hd.o oVar = new hd.o();
                                    oVar.D = string;
                                    oVar.C = o1.a.d("1080p - 720p - 480p - [UFLIX", i122, "]-[EMBED]");
                                    oVar.F = true;
                                    linksActivity.X.add(oVar);
                                }
                                int i13 = LinksActivity.C0;
                                linksActivity.getClass();
                                break;
                            case 3:
                                int i14 = LinksActivity.C0;
                                linksActivity.getClass();
                                SharedPreferences sharedPreferences4 = App.getInstance().f11574v;
                                String str42 = Constant.f12450b;
                                new td.c(linksActivity, linksActivity, sharedPreferences4.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID());
                                break;
                            case 4:
                                linksActivity.Y.getMovieId();
                                new hd.o();
                                hd.o oVar2 = new hd.o();
                                oVar2.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId();
                                oVar2.C = "1080p - 720p - 480p [FLIXVISION2]";
                                linksActivity.X.add(oVar2);
                                String str5 = "https://vidsrc.me/embed/" + linksActivity.Y.getMovieId();
                                hd.o oVar3 = new hd.o();
                                oVar3.D = str5;
                                oVar3.C = "1080p - 720p - 480p [FLIXVISION5]";
                                linksActivity.X.add(oVar3);
                                linksActivity.Z.notifyDataSetChanged();
                                linksActivity.W.setItemAnimator(null);
                                break;
                            case 5:
                                int i15 = LinksActivity.C0;
                                String strB = ac.c.B("S" + be.f.formatSeasonnumber(linksActivity.f11674d0), "E" + be.f.formatSeasonnumber(linksActivity.f11675e0));
                                for (int i16 = 1; i16 < 5; i16++) {
                                    String str6 = "https://uflix.cc/sPlayer?serieid=" + linksActivity.Y.getTitle().toLowerCase().replace(StringUtils.SPACE, "-") + "-" + linksActivity.Y.I + "&episodeid=" + strB + "&stream=stream" + i16;
                                    hd.o oVar4 = new hd.o();
                                    oVar4.D = str6;
                                    oVar4.C = o1.a.d("1080p - 720p - 480p - [UFLIX-", i16, "]-[EMBED]");
                                    oVar4.F = true;
                                    linksActivity.X.add(oVar4);
                                }
                                break;
                            case 6:
                                int i17 = LinksActivity.C0;
                                linksActivity.getClass();
                                SharedPreferences sharedPreferences5 = App.getInstance().f11574v;
                                String str7 = Constant.f12450b;
                                new td.f(linksActivity, linksActivity, sharedPreferences5.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID(), linksActivity.f11674d0, linksActivity.f11675e0);
                                break;
                            case 7:
                                int i18 = LinksActivity.C0;
                                String str8 = linksActivity.f11686p0 + "/ext/gotv.html?goto=" + linksActivity.Y.getMovieId() + "&s=" + linksActivity.f11674d0 + "&e=" + linksActivity.f11675e0;
                                hd.o oVar5 = new hd.o();
                                oVar5.D = str8;
                                oVar5.C = "1080p - 720p - 480p [FLIXVISION]";
                                linksActivity.X.add(oVar5);
                                oVar5.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId() + "&season=" + linksActivity.f11674d0 + "&episode=" + linksActivity.f11675e0;
                                oVar5.C = "1080p - 720p - 480p [FLIXVISION2]";
                                linksActivity.X.add(oVar5);
                                oVar5.D = linksActivity.f11684n0 + "/tv/tmdb/" + linksActivity.Y.getMovieId() + "-" + linksActivity.f11674d0 + "-" + linksActivity.f11694x0;
                                oVar5.C = "1080p - 720p - 480p-[FLIXVISION3]";
                                linksActivity.X.add(oVar5);
                                StringBuilder sb2 = new StringBuilder("https://vidsrc.me/embed/");
                                sb2.append(linksActivity.Y.getMovieId());
                                sb2.append("/");
                                sb2.append(linksActivity.f11674d0);
                                sb2.append("-");
                                String strM = ac.c.m(sb2, linksActivity.f11675e0, "/");
                                hd.o oVar6 = new hd.o();
                                oVar6.D = strM;
                                oVar6.C = "1080p - 720p - 480p [FLIXVISION5]";
                                linksActivity.X.add(oVar6);
                                linksActivity.Z.notifyDataSetChanged();
                                linksActivity.W.setItemAnimator(null);
                                break;
                            default:
                                linksActivity.M.setOnClickListener(new k0(linksActivity, 5));
                                break;
                        }
                    }
                }, 3000L);
                if (this.Y.getImdbID() != null && this.Y.getImdbID().length() > 0) {
                    new Handler().postDelayed(new Runnable(this) { // from class: ub.i0

                        /* renamed from: m, reason: collision with root package name */
                        public final /* synthetic */ LinksActivity f20201m;

                        {
                            this.f20201m = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            int i112 = i12;
                            LinksActivity linksActivity = this.f20201m;
                            switch (i112) {
                                case 0:
                                    SpinKitView spinKitView2 = linksActivity.S;
                                    if (spinKitView2 != null) {
                                        spinKitView2.setVisibility(8);
                                        RelativeLayout relativeLayout2 = linksActivity.N;
                                        if (relativeLayout2 != null) {
                                            relativeLayout2.setVisibility(8);
                                            break;
                                        }
                                    }
                                    break;
                                case 1:
                                    linksActivity.M.setOnClickListener(new k0(linksActivity, 4));
                                    break;
                                case 2:
                                    for (int i122 = 1; i122 < 5; i122++) {
                                        StringBuilder sbV = ac.c.v("https://uflix.cc/mPlayer?movieid=", linksActivity.Y.getTitle().replaceAll("[-+.^:,]", "").trim().replace(StringUtils.SPACE, "-").replace("--", "-"), "-");
                                        sbV.append(linksActivity.Y.I);
                                        sbV.append("&stream=stream");
                                        sbV.append(i122);
                                        String string = sbV.toString();
                                        hd.o oVar = new hd.o();
                                        oVar.D = string;
                                        oVar.C = o1.a.d("1080p - 720p - 480p - [UFLIX", i122, "]-[EMBED]");
                                        oVar.F = true;
                                        linksActivity.X.add(oVar);
                                    }
                                    int i13 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    break;
                                case 3:
                                    int i14 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    SharedPreferences sharedPreferences4 = App.getInstance().f11574v;
                                    String str42 = Constant.f12450b;
                                    new td.c(linksActivity, linksActivity, sharedPreferences4.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID());
                                    break;
                                case 4:
                                    linksActivity.Y.getMovieId();
                                    new hd.o();
                                    hd.o oVar2 = new hd.o();
                                    oVar2.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId();
                                    oVar2.C = "1080p - 720p - 480p [FLIXVISION2]";
                                    linksActivity.X.add(oVar2);
                                    String str5 = "https://vidsrc.me/embed/" + linksActivity.Y.getMovieId();
                                    hd.o oVar3 = new hd.o();
                                    oVar3.D = str5;
                                    oVar3.C = "1080p - 720p - 480p [FLIXVISION5]";
                                    linksActivity.X.add(oVar3);
                                    linksActivity.Z.notifyDataSetChanged();
                                    linksActivity.W.setItemAnimator(null);
                                    break;
                                case 5:
                                    int i15 = LinksActivity.C0;
                                    String strB = ac.c.B("S" + be.f.formatSeasonnumber(linksActivity.f11674d0), "E" + be.f.formatSeasonnumber(linksActivity.f11675e0));
                                    for (int i16 = 1; i16 < 5; i16++) {
                                        String str6 = "https://uflix.cc/sPlayer?serieid=" + linksActivity.Y.getTitle().toLowerCase().replace(StringUtils.SPACE, "-") + "-" + linksActivity.Y.I + "&episodeid=" + strB + "&stream=stream" + i16;
                                        hd.o oVar4 = new hd.o();
                                        oVar4.D = str6;
                                        oVar4.C = o1.a.d("1080p - 720p - 480p - [UFLIX-", i16, "]-[EMBED]");
                                        oVar4.F = true;
                                        linksActivity.X.add(oVar4);
                                    }
                                    break;
                                case 6:
                                    int i17 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    SharedPreferences sharedPreferences5 = App.getInstance().f11574v;
                                    String str7 = Constant.f12450b;
                                    new td.f(linksActivity, linksActivity, sharedPreferences5.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID(), linksActivity.f11674d0, linksActivity.f11675e0);
                                    break;
                                case 7:
                                    int i18 = LinksActivity.C0;
                                    String str8 = linksActivity.f11686p0 + "/ext/gotv.html?goto=" + linksActivity.Y.getMovieId() + "&s=" + linksActivity.f11674d0 + "&e=" + linksActivity.f11675e0;
                                    hd.o oVar5 = new hd.o();
                                    oVar5.D = str8;
                                    oVar5.C = "1080p - 720p - 480p [FLIXVISION]";
                                    linksActivity.X.add(oVar5);
                                    oVar5.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId() + "&season=" + linksActivity.f11674d0 + "&episode=" + linksActivity.f11675e0;
                                    oVar5.C = "1080p - 720p - 480p [FLIXVISION2]";
                                    linksActivity.X.add(oVar5);
                                    oVar5.D = linksActivity.f11684n0 + "/tv/tmdb/" + linksActivity.Y.getMovieId() + "-" + linksActivity.f11674d0 + "-" + linksActivity.f11694x0;
                                    oVar5.C = "1080p - 720p - 480p-[FLIXVISION3]";
                                    linksActivity.X.add(oVar5);
                                    StringBuilder sb2 = new StringBuilder("https://vidsrc.me/embed/");
                                    sb2.append(linksActivity.Y.getMovieId());
                                    sb2.append("/");
                                    sb2.append(linksActivity.f11674d0);
                                    sb2.append("-");
                                    String strM = ac.c.m(sb2, linksActivity.f11675e0, "/");
                                    hd.o oVar6 = new hd.o();
                                    oVar6.D = strM;
                                    oVar6.C = "1080p - 720p - 480p [FLIXVISION5]";
                                    linksActivity.X.add(oVar6);
                                    linksActivity.Z.notifyDataSetChanged();
                                    linksActivity.W.setItemAnimator(null);
                                    break;
                                default:
                                    linksActivity.M.setOnClickListener(new k0(linksActivity, 5));
                                    break;
                            }
                        }
                    }, 2000L);
                    String str5 = this.f11684n0 + "/movie/imdb/" + this.Y.getImdbID();
                    o oVar = new o();
                    oVar.D = str5;
                    oVar.C = "1080p - 720p - 480p-[FLIXVISION3]";
                    this.X.add(oVar);
                    String str6 = this.f11686p0 + "/ext/gomov.html?goto=" + this.Y.getImdbID();
                    o oVar2 = new o();
                    oVar2.D = str6;
                    oVar2.C = "1080p - 720p - 480p - [FLIXVISION6]";
                    this.X.add(oVar2);
                    String str7 = this.f11686p0 + "/ext/gomov0.html?goto=" + this.Y.getImdbID();
                    o oVar3 = new o();
                    oVar3.D = str7;
                    oVar3.C = "1080p - 720p - 480p - [FLIXVISION0]";
                    this.X.add(oVar3);
                    String str8 = this.f11686p0 + "/se_player.php?video_id=" + this.Y.getImdbID();
                    o oVar4 = new o();
                    oVar4.D = str8;
                    oVar4.C = "1080p - 720p - 480p - [FLIXVISION1]";
                    this.X.add(0, oVar4);
                }
                if (this.Y.getMovieId() > 0 && z11) {
                    final int i13 = 4;
                    new Handler().postDelayed(new Runnable(this) { // from class: ub.i0

                        /* renamed from: m, reason: collision with root package name */
                        public final /* synthetic */ LinksActivity f20201m;

                        {
                            this.f20201m = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            int i112 = i13;
                            LinksActivity linksActivity = this.f20201m;
                            switch (i112) {
                                case 0:
                                    SpinKitView spinKitView2 = linksActivity.S;
                                    if (spinKitView2 != null) {
                                        spinKitView2.setVisibility(8);
                                        RelativeLayout relativeLayout2 = linksActivity.N;
                                        if (relativeLayout2 != null) {
                                            relativeLayout2.setVisibility(8);
                                            break;
                                        }
                                    }
                                    break;
                                case 1:
                                    linksActivity.M.setOnClickListener(new k0(linksActivity, 4));
                                    break;
                                case 2:
                                    for (int i122 = 1; i122 < 5; i122++) {
                                        StringBuilder sbV = ac.c.v("https://uflix.cc/mPlayer?movieid=", linksActivity.Y.getTitle().replaceAll("[-+.^:,]", "").trim().replace(StringUtils.SPACE, "-").replace("--", "-"), "-");
                                        sbV.append(linksActivity.Y.I);
                                        sbV.append("&stream=stream");
                                        sbV.append(i122);
                                        String string = sbV.toString();
                                        hd.o oVar5 = new hd.o();
                                        oVar5.D = string;
                                        oVar5.C = o1.a.d("1080p - 720p - 480p - [UFLIX", i122, "]-[EMBED]");
                                        oVar5.F = true;
                                        linksActivity.X.add(oVar5);
                                    }
                                    int i132 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    break;
                                case 3:
                                    int i14 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    SharedPreferences sharedPreferences4 = App.getInstance().f11574v;
                                    String str42 = Constant.f12450b;
                                    new td.c(linksActivity, linksActivity, sharedPreferences4.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID());
                                    break;
                                case 4:
                                    linksActivity.Y.getMovieId();
                                    new hd.o();
                                    hd.o oVar22 = new hd.o();
                                    oVar22.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId();
                                    oVar22.C = "1080p - 720p - 480p [FLIXVISION2]";
                                    linksActivity.X.add(oVar22);
                                    String str52 = "https://vidsrc.me/embed/" + linksActivity.Y.getMovieId();
                                    hd.o oVar32 = new hd.o();
                                    oVar32.D = str52;
                                    oVar32.C = "1080p - 720p - 480p [FLIXVISION5]";
                                    linksActivity.X.add(oVar32);
                                    linksActivity.Z.notifyDataSetChanged();
                                    linksActivity.W.setItemAnimator(null);
                                    break;
                                case 5:
                                    int i15 = LinksActivity.C0;
                                    String strB = ac.c.B("S" + be.f.formatSeasonnumber(linksActivity.f11674d0), "E" + be.f.formatSeasonnumber(linksActivity.f11675e0));
                                    for (int i16 = 1; i16 < 5; i16++) {
                                        String str62 = "https://uflix.cc/sPlayer?serieid=" + linksActivity.Y.getTitle().toLowerCase().replace(StringUtils.SPACE, "-") + "-" + linksActivity.Y.I + "&episodeid=" + strB + "&stream=stream" + i16;
                                        hd.o oVar42 = new hd.o();
                                        oVar42.D = str62;
                                        oVar42.C = o1.a.d("1080p - 720p - 480p - [UFLIX-", i16, "]-[EMBED]");
                                        oVar42.F = true;
                                        linksActivity.X.add(oVar42);
                                    }
                                    break;
                                case 6:
                                    int i17 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    SharedPreferences sharedPreferences5 = App.getInstance().f11574v;
                                    String str72 = Constant.f12450b;
                                    new td.f(linksActivity, linksActivity, sharedPreferences5.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID(), linksActivity.f11674d0, linksActivity.f11675e0);
                                    break;
                                case 7:
                                    int i18 = LinksActivity.C0;
                                    String str82 = linksActivity.f11686p0 + "/ext/gotv.html?goto=" + linksActivity.Y.getMovieId() + "&s=" + linksActivity.f11674d0 + "&e=" + linksActivity.f11675e0;
                                    hd.o oVar52 = new hd.o();
                                    oVar52.D = str82;
                                    oVar52.C = "1080p - 720p - 480p [FLIXVISION]";
                                    linksActivity.X.add(oVar52);
                                    oVar52.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId() + "&season=" + linksActivity.f11674d0 + "&episode=" + linksActivity.f11675e0;
                                    oVar52.C = "1080p - 720p - 480p [FLIXVISION2]";
                                    linksActivity.X.add(oVar52);
                                    oVar52.D = linksActivity.f11684n0 + "/tv/tmdb/" + linksActivity.Y.getMovieId() + "-" + linksActivity.f11674d0 + "-" + linksActivity.f11694x0;
                                    oVar52.C = "1080p - 720p - 480p-[FLIXVISION3]";
                                    linksActivity.X.add(oVar52);
                                    StringBuilder sb2 = new StringBuilder("https://vidsrc.me/embed/");
                                    sb2.append(linksActivity.Y.getMovieId());
                                    sb2.append("/");
                                    sb2.append(linksActivity.f11674d0);
                                    sb2.append("-");
                                    String strM = ac.c.m(sb2, linksActivity.f11675e0, "/");
                                    hd.o oVar6 = new hd.o();
                                    oVar6.D = strM;
                                    oVar6.C = "1080p - 720p - 480p [FLIXVISION5]";
                                    linksActivity.X.add(oVar6);
                                    linksActivity.Z.notifyDataSetChanged();
                                    linksActivity.W.setItemAnimator(null);
                                    break;
                                default:
                                    linksActivity.M.setOnClickListener(new k0(linksActivity, 5));
                                    break;
                            }
                        }
                    }, 5000L);
                }
                if (App.getInstance().f11574v.getBoolean("pref_show_hindi_dubbed", false)) {
                    new ud.f(this, this.Y, this).process();
                    new ud.h(this, this.Y, this).process();
                    new ud.b(this, this.Y, this).process();
                    new ud.d(this, this.Y, this).process();
                }
                if (z11) {
                    if (RealDebridCommon.f12051p || PremiumizeCommon.f12045b || AllDebridCommon.f12043n) {
                        new j(this, this.Y, this).process(1);
                        new p(this, this.Y, this).process(1);
                        new i(this, this.Y, this).process(1);
                        new wd.c(this, this.Y, this).process(1);
                        new vd.f(this, this.Y, this).process(1);
                        new vd.b(this, this.Y, this).process(1);
                    }
                    new rd.f(this, this.Y, this).process();
                    new rd.d(this, this.Y, this).process();
                    new rd.h(this, this.Y, this).process();
                    new x(this, this.Y, this).process();
                    new qd.g(this, this.Y, this).process();
                    new s(this, this.Y, this).process();
                    new qd.b(this, this.Y, this).process();
                    new k(this, this.Y, this).process();
                    new qd.o(this, this.Y, this).Process();
                    new b0(this, this.Y, this).process();
                }
            } else {
                final int i14 = 5;
                new Handler().postDelayed(new Runnable(this) { // from class: ub.i0

                    /* renamed from: m, reason: collision with root package name */
                    public final /* synthetic */ LinksActivity f20201m;

                    {
                        this.f20201m = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        int i112 = i14;
                        LinksActivity linksActivity = this.f20201m;
                        switch (i112) {
                            case 0:
                                SpinKitView spinKitView2 = linksActivity.S;
                                if (spinKitView2 != null) {
                                    spinKitView2.setVisibility(8);
                                    RelativeLayout relativeLayout2 = linksActivity.N;
                                    if (relativeLayout2 != null) {
                                        relativeLayout2.setVisibility(8);
                                        break;
                                    }
                                }
                                break;
                            case 1:
                                linksActivity.M.setOnClickListener(new k0(linksActivity, 4));
                                break;
                            case 2:
                                for (int i122 = 1; i122 < 5; i122++) {
                                    StringBuilder sbV = ac.c.v("https://uflix.cc/mPlayer?movieid=", linksActivity.Y.getTitle().replaceAll("[-+.^:,]", "").trim().replace(StringUtils.SPACE, "-").replace("--", "-"), "-");
                                    sbV.append(linksActivity.Y.I);
                                    sbV.append("&stream=stream");
                                    sbV.append(i122);
                                    String string = sbV.toString();
                                    hd.o oVar5 = new hd.o();
                                    oVar5.D = string;
                                    oVar5.C = o1.a.d("1080p - 720p - 480p - [UFLIX", i122, "]-[EMBED]");
                                    oVar5.F = true;
                                    linksActivity.X.add(oVar5);
                                }
                                int i132 = LinksActivity.C0;
                                linksActivity.getClass();
                                break;
                            case 3:
                                int i142 = LinksActivity.C0;
                                linksActivity.getClass();
                                SharedPreferences sharedPreferences4 = App.getInstance().f11574v;
                                String str42 = Constant.f12450b;
                                new td.c(linksActivity, linksActivity, sharedPreferences4.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID());
                                break;
                            case 4:
                                linksActivity.Y.getMovieId();
                                new hd.o();
                                hd.o oVar22 = new hd.o();
                                oVar22.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId();
                                oVar22.C = "1080p - 720p - 480p [FLIXVISION2]";
                                linksActivity.X.add(oVar22);
                                String str52 = "https://vidsrc.me/embed/" + linksActivity.Y.getMovieId();
                                hd.o oVar32 = new hd.o();
                                oVar32.D = str52;
                                oVar32.C = "1080p - 720p - 480p [FLIXVISION5]";
                                linksActivity.X.add(oVar32);
                                linksActivity.Z.notifyDataSetChanged();
                                linksActivity.W.setItemAnimator(null);
                                break;
                            case 5:
                                int i15 = LinksActivity.C0;
                                String strB = ac.c.B("S" + be.f.formatSeasonnumber(linksActivity.f11674d0), "E" + be.f.formatSeasonnumber(linksActivity.f11675e0));
                                for (int i16 = 1; i16 < 5; i16++) {
                                    String str62 = "https://uflix.cc/sPlayer?serieid=" + linksActivity.Y.getTitle().toLowerCase().replace(StringUtils.SPACE, "-") + "-" + linksActivity.Y.I + "&episodeid=" + strB + "&stream=stream" + i16;
                                    hd.o oVar42 = new hd.o();
                                    oVar42.D = str62;
                                    oVar42.C = o1.a.d("1080p - 720p - 480p - [UFLIX-", i16, "]-[EMBED]");
                                    oVar42.F = true;
                                    linksActivity.X.add(oVar42);
                                }
                                break;
                            case 6:
                                int i17 = LinksActivity.C0;
                                linksActivity.getClass();
                                SharedPreferences sharedPreferences5 = App.getInstance().f11574v;
                                String str72 = Constant.f12450b;
                                new td.f(linksActivity, linksActivity, sharedPreferences5.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID(), linksActivity.f11674d0, linksActivity.f11675e0);
                                break;
                            case 7:
                                int i18 = LinksActivity.C0;
                                String str82 = linksActivity.f11686p0 + "/ext/gotv.html?goto=" + linksActivity.Y.getMovieId() + "&s=" + linksActivity.f11674d0 + "&e=" + linksActivity.f11675e0;
                                hd.o oVar52 = new hd.o();
                                oVar52.D = str82;
                                oVar52.C = "1080p - 720p - 480p [FLIXVISION]";
                                linksActivity.X.add(oVar52);
                                oVar52.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId() + "&season=" + linksActivity.f11674d0 + "&episode=" + linksActivity.f11675e0;
                                oVar52.C = "1080p - 720p - 480p [FLIXVISION2]";
                                linksActivity.X.add(oVar52);
                                oVar52.D = linksActivity.f11684n0 + "/tv/tmdb/" + linksActivity.Y.getMovieId() + "-" + linksActivity.f11674d0 + "-" + linksActivity.f11694x0;
                                oVar52.C = "1080p - 720p - 480p-[FLIXVISION3]";
                                linksActivity.X.add(oVar52);
                                StringBuilder sb2 = new StringBuilder("https://vidsrc.me/embed/");
                                sb2.append(linksActivity.Y.getMovieId());
                                sb2.append("/");
                                sb2.append(linksActivity.f11674d0);
                                sb2.append("-");
                                String strM = ac.c.m(sb2, linksActivity.f11675e0, "/");
                                hd.o oVar6 = new hd.o();
                                oVar6.D = strM;
                                oVar6.C = "1080p - 720p - 480p [FLIXVISION5]";
                                linksActivity.X.add(oVar6);
                                linksActivity.Z.notifyDataSetChanged();
                                linksActivity.W.setItemAnimator(null);
                                break;
                            default:
                                linksActivity.M.setOnClickListener(new k0(linksActivity, 5));
                                break;
                        }
                    }
                }, 3000L);
                if (this.Y.getImdbID() != null && this.Y.getImdbID().length() > 0) {
                    final int i15 = 6;
                    new Handler().postDelayed(new Runnable(this) { // from class: ub.i0

                        /* renamed from: m, reason: collision with root package name */
                        public final /* synthetic */ LinksActivity f20201m;

                        {
                            this.f20201m = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            int i112 = i15;
                            LinksActivity linksActivity = this.f20201m;
                            switch (i112) {
                                case 0:
                                    SpinKitView spinKitView2 = linksActivity.S;
                                    if (spinKitView2 != null) {
                                        spinKitView2.setVisibility(8);
                                        RelativeLayout relativeLayout2 = linksActivity.N;
                                        if (relativeLayout2 != null) {
                                            relativeLayout2.setVisibility(8);
                                            break;
                                        }
                                    }
                                    break;
                                case 1:
                                    linksActivity.M.setOnClickListener(new k0(linksActivity, 4));
                                    break;
                                case 2:
                                    for (int i122 = 1; i122 < 5; i122++) {
                                        StringBuilder sbV = ac.c.v("https://uflix.cc/mPlayer?movieid=", linksActivity.Y.getTitle().replaceAll("[-+.^:,]", "").trim().replace(StringUtils.SPACE, "-").replace("--", "-"), "-");
                                        sbV.append(linksActivity.Y.I);
                                        sbV.append("&stream=stream");
                                        sbV.append(i122);
                                        String string = sbV.toString();
                                        hd.o oVar5 = new hd.o();
                                        oVar5.D = string;
                                        oVar5.C = o1.a.d("1080p - 720p - 480p - [UFLIX", i122, "]-[EMBED]");
                                        oVar5.F = true;
                                        linksActivity.X.add(oVar5);
                                    }
                                    int i132 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    break;
                                case 3:
                                    int i142 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    SharedPreferences sharedPreferences4 = App.getInstance().f11574v;
                                    String str42 = Constant.f12450b;
                                    new td.c(linksActivity, linksActivity, sharedPreferences4.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID());
                                    break;
                                case 4:
                                    linksActivity.Y.getMovieId();
                                    new hd.o();
                                    hd.o oVar22 = new hd.o();
                                    oVar22.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId();
                                    oVar22.C = "1080p - 720p - 480p [FLIXVISION2]";
                                    linksActivity.X.add(oVar22);
                                    String str52 = "https://vidsrc.me/embed/" + linksActivity.Y.getMovieId();
                                    hd.o oVar32 = new hd.o();
                                    oVar32.D = str52;
                                    oVar32.C = "1080p - 720p - 480p [FLIXVISION5]";
                                    linksActivity.X.add(oVar32);
                                    linksActivity.Z.notifyDataSetChanged();
                                    linksActivity.W.setItemAnimator(null);
                                    break;
                                case 5:
                                    int i152 = LinksActivity.C0;
                                    String strB = ac.c.B("S" + be.f.formatSeasonnumber(linksActivity.f11674d0), "E" + be.f.formatSeasonnumber(linksActivity.f11675e0));
                                    for (int i16 = 1; i16 < 5; i16++) {
                                        String str62 = "https://uflix.cc/sPlayer?serieid=" + linksActivity.Y.getTitle().toLowerCase().replace(StringUtils.SPACE, "-") + "-" + linksActivity.Y.I + "&episodeid=" + strB + "&stream=stream" + i16;
                                        hd.o oVar42 = new hd.o();
                                        oVar42.D = str62;
                                        oVar42.C = o1.a.d("1080p - 720p - 480p - [UFLIX-", i16, "]-[EMBED]");
                                        oVar42.F = true;
                                        linksActivity.X.add(oVar42);
                                    }
                                    break;
                                case 6:
                                    int i17 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    SharedPreferences sharedPreferences5 = App.getInstance().f11574v;
                                    String str72 = Constant.f12450b;
                                    new td.f(linksActivity, linksActivity, sharedPreferences5.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID(), linksActivity.f11674d0, linksActivity.f11675e0);
                                    break;
                                case 7:
                                    int i18 = LinksActivity.C0;
                                    String str82 = linksActivity.f11686p0 + "/ext/gotv.html?goto=" + linksActivity.Y.getMovieId() + "&s=" + linksActivity.f11674d0 + "&e=" + linksActivity.f11675e0;
                                    hd.o oVar52 = new hd.o();
                                    oVar52.D = str82;
                                    oVar52.C = "1080p - 720p - 480p [FLIXVISION]";
                                    linksActivity.X.add(oVar52);
                                    oVar52.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId() + "&season=" + linksActivity.f11674d0 + "&episode=" + linksActivity.f11675e0;
                                    oVar52.C = "1080p - 720p - 480p [FLIXVISION2]";
                                    linksActivity.X.add(oVar52);
                                    oVar52.D = linksActivity.f11684n0 + "/tv/tmdb/" + linksActivity.Y.getMovieId() + "-" + linksActivity.f11674d0 + "-" + linksActivity.f11694x0;
                                    oVar52.C = "1080p - 720p - 480p-[FLIXVISION3]";
                                    linksActivity.X.add(oVar52);
                                    StringBuilder sb2 = new StringBuilder("https://vidsrc.me/embed/");
                                    sb2.append(linksActivity.Y.getMovieId());
                                    sb2.append("/");
                                    sb2.append(linksActivity.f11674d0);
                                    sb2.append("-");
                                    String strM = ac.c.m(sb2, linksActivity.f11675e0, "/");
                                    hd.o oVar6 = new hd.o();
                                    oVar6.D = strM;
                                    oVar6.C = "1080p - 720p - 480p [FLIXVISION5]";
                                    linksActivity.X.add(oVar6);
                                    linksActivity.Z.notifyDataSetChanged();
                                    linksActivity.W.setItemAnimator(null);
                                    break;
                                default:
                                    linksActivity.M.setOnClickListener(new k0(linksActivity, 5));
                                    break;
                            }
                        }
                    }, 2000L);
                }
                if (RealDebridCommon.f12051p || PremiumizeCommon.f12045b || AllDebridCommon.f12043n) {
                    new l(this, this.Y, this).process(1, this.f11674d0, this.f11675e0);
                    new wd.s(this, this.Y, this).process(this.f11674d0, this.f11675e0, 1);
                    new m(this, this.Y, this).process(this.f11674d0, this.f11675e0, 1);
                    new wd.f(this, this.Y, this).process(this.f11674d0, this.f11675e0, 1);
                    new vd.h(this, this.Y, this).process(this.f11674d0, this.f11675e0);
                    new vd.d(this, this.Y, this).process(this.f11674d0, this.f11675e0);
                }
                new sd.f(this, this.Y, this).process(this.f11674d0, this.f11675e0);
                new v(this, this.Y, this).process(this.f11674d0, this.f11675e0);
                new sd.l(this, this.Y, this).process(this.f11674d0, this.f11675e0);
                new z(this, this.Y, this).process(this.f11674d0, this.f11675e0);
                new qd.m(this, this.Y, this).process(this.f11674d0, this.f11675e0);
                new d0(this, this.Y, this).process(this.f11674d0, this.f11675e0);
                new u(this, this.Y, this).Process(this.f11674d0, this.f11675e0);
                new qd.i(this, this.Y, this).process(this.f11674d0, this.f11675e0);
                new q(this, this.Y, this).Process(this.f11675e0, this.f11674d0);
                new sd.h(this, this.Y, this).process(this.f11674d0, this.f11675e0);
                if (this.Y.getMovieId() > 0) {
                    final int i16 = 7;
                    new Handler().postDelayed(new Runnable(this) { // from class: ub.i0

                        /* renamed from: m, reason: collision with root package name */
                        public final /* synthetic */ LinksActivity f20201m;

                        {
                            this.f20201m = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            int i112 = i16;
                            LinksActivity linksActivity = this.f20201m;
                            switch (i112) {
                                case 0:
                                    SpinKitView spinKitView2 = linksActivity.S;
                                    if (spinKitView2 != null) {
                                        spinKitView2.setVisibility(8);
                                        RelativeLayout relativeLayout2 = linksActivity.N;
                                        if (relativeLayout2 != null) {
                                            relativeLayout2.setVisibility(8);
                                            break;
                                        }
                                    }
                                    break;
                                case 1:
                                    linksActivity.M.setOnClickListener(new k0(linksActivity, 4));
                                    break;
                                case 2:
                                    for (int i122 = 1; i122 < 5; i122++) {
                                        StringBuilder sbV = ac.c.v("https://uflix.cc/mPlayer?movieid=", linksActivity.Y.getTitle().replaceAll("[-+.^:,]", "").trim().replace(StringUtils.SPACE, "-").replace("--", "-"), "-");
                                        sbV.append(linksActivity.Y.I);
                                        sbV.append("&stream=stream");
                                        sbV.append(i122);
                                        String string = sbV.toString();
                                        hd.o oVar5 = new hd.o();
                                        oVar5.D = string;
                                        oVar5.C = o1.a.d("1080p - 720p - 480p - [UFLIX", i122, "]-[EMBED]");
                                        oVar5.F = true;
                                        linksActivity.X.add(oVar5);
                                    }
                                    int i132 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    break;
                                case 3:
                                    int i142 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    SharedPreferences sharedPreferences4 = App.getInstance().f11574v;
                                    String str42 = Constant.f12450b;
                                    new td.c(linksActivity, linksActivity, sharedPreferences4.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID());
                                    break;
                                case 4:
                                    linksActivity.Y.getMovieId();
                                    new hd.o();
                                    hd.o oVar22 = new hd.o();
                                    oVar22.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId();
                                    oVar22.C = "1080p - 720p - 480p [FLIXVISION2]";
                                    linksActivity.X.add(oVar22);
                                    String str52 = "https://vidsrc.me/embed/" + linksActivity.Y.getMovieId();
                                    hd.o oVar32 = new hd.o();
                                    oVar32.D = str52;
                                    oVar32.C = "1080p - 720p - 480p [FLIXVISION5]";
                                    linksActivity.X.add(oVar32);
                                    linksActivity.Z.notifyDataSetChanged();
                                    linksActivity.W.setItemAnimator(null);
                                    break;
                                case 5:
                                    int i152 = LinksActivity.C0;
                                    String strB = ac.c.B("S" + be.f.formatSeasonnumber(linksActivity.f11674d0), "E" + be.f.formatSeasonnumber(linksActivity.f11675e0));
                                    for (int i162 = 1; i162 < 5; i162++) {
                                        String str62 = "https://uflix.cc/sPlayer?serieid=" + linksActivity.Y.getTitle().toLowerCase().replace(StringUtils.SPACE, "-") + "-" + linksActivity.Y.I + "&episodeid=" + strB + "&stream=stream" + i162;
                                        hd.o oVar42 = new hd.o();
                                        oVar42.D = str62;
                                        oVar42.C = o1.a.d("1080p - 720p - 480p - [UFLIX-", i162, "]-[EMBED]");
                                        oVar42.F = true;
                                        linksActivity.X.add(oVar42);
                                    }
                                    break;
                                case 6:
                                    int i17 = LinksActivity.C0;
                                    linksActivity.getClass();
                                    SharedPreferences sharedPreferences5 = App.getInstance().f11574v;
                                    String str72 = Constant.f12450b;
                                    new td.f(linksActivity, linksActivity, sharedPreferences5.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID(), linksActivity.f11674d0, linksActivity.f11675e0);
                                    break;
                                case 7:
                                    int i18 = LinksActivity.C0;
                                    String str82 = linksActivity.f11686p0 + "/ext/gotv.html?goto=" + linksActivity.Y.getMovieId() + "&s=" + linksActivity.f11674d0 + "&e=" + linksActivity.f11675e0;
                                    hd.o oVar52 = new hd.o();
                                    oVar52.D = str82;
                                    oVar52.C = "1080p - 720p - 480p [FLIXVISION]";
                                    linksActivity.X.add(oVar52);
                                    oVar52.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId() + "&season=" + linksActivity.f11674d0 + "&episode=" + linksActivity.f11675e0;
                                    oVar52.C = "1080p - 720p - 480p [FLIXVISION2]";
                                    linksActivity.X.add(oVar52);
                                    oVar52.D = linksActivity.f11684n0 + "/tv/tmdb/" + linksActivity.Y.getMovieId() + "-" + linksActivity.f11674d0 + "-" + linksActivity.f11694x0;
                                    oVar52.C = "1080p - 720p - 480p-[FLIXVISION3]";
                                    linksActivity.X.add(oVar52);
                                    StringBuilder sb2 = new StringBuilder("https://vidsrc.me/embed/");
                                    sb2.append(linksActivity.Y.getMovieId());
                                    sb2.append("/");
                                    sb2.append(linksActivity.f11674d0);
                                    sb2.append("-");
                                    String strM = ac.c.m(sb2, linksActivity.f11675e0, "/");
                                    hd.o oVar6 = new hd.o();
                                    oVar6.D = strM;
                                    oVar6.C = "1080p - 720p - 480p [FLIXVISION5]";
                                    linksActivity.X.add(oVar6);
                                    linksActivity.Z.notifyDataSetChanged();
                                    linksActivity.W.setItemAnimator(null);
                                    break;
                                default:
                                    linksActivity.M.setOnClickListener(new k0(linksActivity, 5));
                                    break;
                            }
                        }
                    }, 5000L);
                }
                if (this.Y.getImdbID() != null && this.Y.getImdbID().length() > 0) {
                    StringBuilder sb2 = new StringBuilder("https://vidsrc.to/embed/tv/");
                    sb2.append(this.Y.getImdbID());
                    sb2.append("/");
                    sb2.append(this.f11674d0);
                    sb2.append("/");
                    String strM = ac.c.m(sb2, this.f11675e0, "/");
                    o oVar5 = new o();
                    oVar5.D = strM;
                    oVar5.C = "1080p - 720p - 480p [FLIXVISION5]";
                    this.X.add(oVar5);
                    String str9 = this.f11686p0 + "/se_player.php?video_id=" + this.Y.getImdbID() + "&s=" + this.f11674d0 + "&e=" + this.f11675e0;
                    o oVar6 = new o();
                    oVar6.D = str9;
                    oVar6.C = "1080p - 720p - 480p [FLIXVISION1]";
                    this.X.add(0, oVar6);
                }
            }
        } else if (this.Y.isSeries()) {
            if (this.Y.getImdbID() != null && this.Y.getImdbID().length() > 0) {
                SharedPreferences sharedPreferences4 = App.getInstance().f11574v;
                String str10 = Constant.f12450b;
                new td.f(this, this, sharedPreferences4.getString("pref_ml_host", getString(R.string.ml_host))).process(this.Y.getImdbID(), this.f11674d0, this.f11675e0);
            }
            if (RealDebridCommon.f12051p || PremiumizeCommon.f12045b || AllDebridCommon.f12043n) {
                new l(this, this.Y, this).process(this.f11674d0, this.f11675e0, 1);
                new wd.s(this, this.Y, this).process(this.f11674d0, this.f11675e0, 1);
                new m(this, this.Y, this).process(this.f11674d0, this.f11675e0, 1);
                new wd.f(this, this.Y, this).process(this.f11674d0, this.f11675e0, 1);
                new vd.h(this, this.Y, this).process(this.f11674d0, this.f11675e0);
                new vd.d(this, this.Y, this).process(this.f11674d0, this.f11675e0);
            }
        } else {
            SharedPreferences sharedPreferences5 = App.getInstance().f11574v;
            String str11 = Constant.f12450b;
            new td.c(this, this, sharedPreferences5.getString("pref_ml_host", getString(R.string.ml_host))).process(this.Y.getImdbID());
            if (RealDebridCommon.f12051p || PremiumizeCommon.f12045b || AllDebridCommon.f12043n) {
                new j(this, this.Y, this).process(1);
                new p(this, this.Y, this).process(1);
                new i(this, this.Y, this).process(1);
                new wd.c(this, this.Y, this).process(1);
                new vd.f(this, this.Y, this).process(1);
                new vd.b(this, this.Y, this).process(1);
            }
        }
        Movie movie4 = this.Y;
        if (movie4 != null) {
            if (movie4.isSeries()) {
                this.f11685o0 = this.Y.getMovieId() + "" + this.f11674d0 + "" + this.f11675e0;
            } else {
                this.f11685o0 = this.Y.getMovieId() + "";
            }
        }
        this.W.requestFocus();
        TextView textView = this.Q;
        if (textView != null) {
            this.T.applyFontToView(textView, this.U);
        }
        TextView textView2 = this.O;
        if (textView2 != null) {
            this.T.applyFontToView(textView2, this.U);
        }
        TextView textView3 = this.P;
        if (textView3 != null) {
            this.T.applyFontToView(textView3, this.U);
        }
        this.T.applyFontToView(this.f11680j0, this.U);
        this.T.applyFontToView(this.f11681k0, this.V);
        this.T.applyFontToView(this.f11682l0, this.U);
        RelativeLayout relativeLayout2 = this.L;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new k0(this, 2));
        }
        if (this.M != null) {
            Handler handler = new Handler();
            final int i17 = z10 ? 1 : 0;
            handler.postDelayed(new Runnable(this) { // from class: ub.i0

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ LinksActivity f20201m;

                {
                    this.f20201m = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i112 = i17;
                    LinksActivity linksActivity = this.f20201m;
                    switch (i112) {
                        case 0:
                            SpinKitView spinKitView2 = linksActivity.S;
                            if (spinKitView2 != null) {
                                spinKitView2.setVisibility(8);
                                RelativeLayout relativeLayout22 = linksActivity.N;
                                if (relativeLayout22 != null) {
                                    relativeLayout22.setVisibility(8);
                                    break;
                                }
                            }
                            break;
                        case 1:
                            linksActivity.M.setOnClickListener(new k0(linksActivity, 4));
                            break;
                        case 2:
                            for (int i122 = 1; i122 < 5; i122++) {
                                StringBuilder sbV = ac.c.v("https://uflix.cc/mPlayer?movieid=", linksActivity.Y.getTitle().replaceAll("[-+.^:,]", "").trim().replace(StringUtils.SPACE, "-").replace("--", "-"), "-");
                                sbV.append(linksActivity.Y.I);
                                sbV.append("&stream=stream");
                                sbV.append(i122);
                                String string = sbV.toString();
                                hd.o oVar52 = new hd.o();
                                oVar52.D = string;
                                oVar52.C = o1.a.d("1080p - 720p - 480p - [UFLIX", i122, "]-[EMBED]");
                                oVar52.F = true;
                                linksActivity.X.add(oVar52);
                            }
                            int i132 = LinksActivity.C0;
                            linksActivity.getClass();
                            break;
                        case 3:
                            int i142 = LinksActivity.C0;
                            linksActivity.getClass();
                            SharedPreferences sharedPreferences42 = App.getInstance().f11574v;
                            String str42 = Constant.f12450b;
                            new td.c(linksActivity, linksActivity, sharedPreferences42.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID());
                            break;
                        case 4:
                            linksActivity.Y.getMovieId();
                            new hd.o();
                            hd.o oVar22 = new hd.o();
                            oVar22.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId();
                            oVar22.C = "1080p - 720p - 480p [FLIXVISION2]";
                            linksActivity.X.add(oVar22);
                            String str52 = "https://vidsrc.me/embed/" + linksActivity.Y.getMovieId();
                            hd.o oVar32 = new hd.o();
                            oVar32.D = str52;
                            oVar32.C = "1080p - 720p - 480p [FLIXVISION5]";
                            linksActivity.X.add(oVar32);
                            linksActivity.Z.notifyDataSetChanged();
                            linksActivity.W.setItemAnimator(null);
                            break;
                        case 5:
                            int i152 = LinksActivity.C0;
                            String strB = ac.c.B("S" + be.f.formatSeasonnumber(linksActivity.f11674d0), "E" + be.f.formatSeasonnumber(linksActivity.f11675e0));
                            for (int i162 = 1; i162 < 5; i162++) {
                                String str62 = "https://uflix.cc/sPlayer?serieid=" + linksActivity.Y.getTitle().toLowerCase().replace(StringUtils.SPACE, "-") + "-" + linksActivity.Y.I + "&episodeid=" + strB + "&stream=stream" + i162;
                                hd.o oVar42 = new hd.o();
                                oVar42.D = str62;
                                oVar42.C = o1.a.d("1080p - 720p - 480p - [UFLIX-", i162, "]-[EMBED]");
                                oVar42.F = true;
                                linksActivity.X.add(oVar42);
                            }
                            break;
                        case 6:
                            int i172 = LinksActivity.C0;
                            linksActivity.getClass();
                            SharedPreferences sharedPreferences52 = App.getInstance().f11574v;
                            String str72 = Constant.f12450b;
                            new td.f(linksActivity, linksActivity, sharedPreferences52.getString("pref_ml_host", linksActivity.getString(R.string.ml_host))).process(linksActivity.Y.getImdbID(), linksActivity.f11674d0, linksActivity.f11675e0);
                            break;
                        case 7:
                            int i18 = LinksActivity.C0;
                            String str82 = linksActivity.f11686p0 + "/ext/gotv.html?goto=" + linksActivity.Y.getMovieId() + "&s=" + linksActivity.f11674d0 + "&e=" + linksActivity.f11675e0;
                            hd.o oVar522 = new hd.o();
                            oVar522.D = str82;
                            oVar522.C = "1080p - 720p - 480p [FLIXVISION]";
                            linksActivity.X.add(oVar522);
                            oVar522.D = "https://embed.smashystream.com/playere.php?tmdb=" + linksActivity.Y.getMovieId() + "&season=" + linksActivity.f11674d0 + "&episode=" + linksActivity.f11675e0;
                            oVar522.C = "1080p - 720p - 480p [FLIXVISION2]";
                            linksActivity.X.add(oVar522);
                            oVar522.D = linksActivity.f11684n0 + "/tv/tmdb/" + linksActivity.Y.getMovieId() + "-" + linksActivity.f11674d0 + "-" + linksActivity.f11694x0;
                            oVar522.C = "1080p - 720p - 480p-[FLIXVISION3]";
                            linksActivity.X.add(oVar522);
                            StringBuilder sb22 = new StringBuilder("https://vidsrc.me/embed/");
                            sb22.append(linksActivity.Y.getMovieId());
                            sb22.append("/");
                            sb22.append(linksActivity.f11674d0);
                            sb22.append("-");
                            String strM2 = ac.c.m(sb22, linksActivity.f11675e0, "/");
                            hd.o oVar62 = new hd.o();
                            oVar62.D = strM2;
                            oVar62.C = "1080p - 720p - 480p [FLIXVISION5]";
                            linksActivity.X.add(oVar62);
                            linksActivity.Z.notifyDataSetChanged();
                            linksActivity.W.setItemAnimator(null);
                            break;
                        default:
                            linksActivity.M.setOnClickListener(new k0(linksActivity, 5));
                            break;
                    }
                }
            }, 10000L);
            RelativeLayout relativeLayout3 = this.M;
            final int i18 = z10 ? 1 : 0;
            relativeLayout3.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.j0

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ LinksActivity f20208m;

                {
                    this.f20208m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z112) {
                    int i112 = i18;
                    LinksActivity linksActivity = this.f20208m;
                    switch (i112) {
                        case 0:
                            if (!z112) {
                                linksActivity.f11673c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                break;
                            } else {
                                linksActivity.f11673c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                break;
                            }
                        case 1:
                            if (!z112) {
                                linksActivity.f11671a0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                linksActivity.Q.setTextColor(linksActivity.getResources().getColor(R.color.white));
                                linksActivity.M.animate().scaleX(1.0f).start();
                                linksActivity.M.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                linksActivity.f11671a0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                linksActivity.Q.setTextColor(linksActivity.getResources().getColor(R.color.black));
                                o1.a.k(linksActivity.M, 100L, 1.03f);
                                o1.a.r(linksActivity.M, 100L, 1.03f);
                                break;
                            }
                        default:
                            if (!z112) {
                                linksActivity.f11672b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                linksActivity.O.setTextColor(linksActivity.getResources().getColor(R.color.white));
                                linksActivity.L.animate().scaleX(1.0f).start();
                                linksActivity.L.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                linksActivity.f11672b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                linksActivity.O.setTextColor(linksActivity.getResources().getColor(R.color.black));
                                o1.a.k(linksActivity.L, 100L, 1.03f);
                                o1.a.r(linksActivity.L, 100L, 1.03f);
                                break;
                            }
                    }
                }
            });
            this.L.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.j0

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ LinksActivity f20208m;

                {
                    this.f20208m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z112) {
                    int i112 = i11;
                    LinksActivity linksActivity = this.f20208m;
                    switch (i112) {
                        case 0:
                            if (!z112) {
                                linksActivity.f11673c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                break;
                            } else {
                                linksActivity.f11673c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                break;
                            }
                        case 1:
                            if (!z112) {
                                linksActivity.f11671a0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                linksActivity.Q.setTextColor(linksActivity.getResources().getColor(R.color.white));
                                linksActivity.M.animate().scaleX(1.0f).start();
                                linksActivity.M.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                linksActivity.f11671a0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                linksActivity.Q.setTextColor(linksActivity.getResources().getColor(R.color.black));
                                o1.a.k(linksActivity.M, 100L, 1.03f);
                                o1.a.r(linksActivity.M, 100L, 1.03f);
                                break;
                            }
                        default:
                            if (!z112) {
                                linksActivity.f11672b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                linksActivity.O.setTextColor(linksActivity.getResources().getColor(R.color.white));
                                linksActivity.L.animate().scaleX(1.0f).start();
                                linksActivity.L.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                linksActivity.f11672b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(linksActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                linksActivity.O.setTextColor(linksActivity.getResources().getColor(R.color.black));
                                o1.a.k(linksActivity.L, 100L, 1.03f);
                                o1.a.r(linksActivity.L, 100L, 1.03f);
                                break;
                            }
                    }
                }
            });
        }
        RelativeLayout relativeLayout4 = this.N;
        if (relativeLayout4 != null) {
            relativeLayout4.setOnClickListener(new k0(this, 3));
        }
        if (!RealDebridCommon.f12051p && !AllDebridCommon.f12043n && !PremiumizeCommon.f12045b) {
            z10 = false;
        }
        this.f11688r0 = z10;
        if (!z10 || (movie = this.Y) == null || movie.isAnime() || this.Y.isDrama() || (relativeLayout = this.N) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.links, menu);
        this.f11696z0 = menu;
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SystemEvent systemEvent) {
        RelativeLayout relativeLayout;
        TextView textView;
        try {
            SystemEvent.ACTION action = systemEvent.f12187a;
            if (action == SystemEvent.ACTION.RELOAD_LIST || action == SystemEvent.ACTION.REFRESH_COUNTER) {
                this.Z.notifyDataSetChanged();
                this.W.setItemAnimator(null);
                SpinKitView spinKitView = this.S;
                if (spinKitView != null) {
                    spinKitView.setVisibility(0);
                }
                if (RealDebridCommon.f12051p && (relativeLayout = this.N) != null) {
                    relativeLayout.setVisibility(0);
                }
                this.f11689s0.removeCallbacks(this.f11690t0);
                this.f11689s0.postDelayed(this.f11690t0, this.f11688r0 ? 35000L : 12000L);
                TextView textView2 = this.P;
                if (textView2 != null) {
                    textView2.setText("" + this.f11692v0);
                }
                TextView textView3 = this.R;
                if (textView3 != null && this.X.f12409b > 0) {
                    textView3.setText(this.X.f12409b + "");
                }
            }
            if (!this.f11691u0 || (textView = this.R) == null) {
                return;
            }
            textView.setVisibility(0);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        if (this.f11687q0 == null && App.getInstance().f11566n) {
            SharedPreferences sharedPreferences = App.getInstance().f11574v;
            if (((int) ((sharedPreferences.getInt(this.Y.getMovieId() + "", -1) * 100) / (this.Y.getDuration() * 60000))) > 95 && !this.Y.isSeries()) {
                App.getInstance().f11573u.markAsWatched(this.Y);
                App.getInstance().f11574v.edit().remove(this.f11685o0).apply();
            }
        }
        super.onResume();
    }

    @Override // androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("sources", this.X);
    }

    private OkHttpClient getFlixTorClient() {
        if (this.flixtorClient == null) {
            this.flixtorClient = new OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS).connectTimeout(15, TimeUnit.SECONDS).followRedirects(true).followSslRedirects(true).build();
        }
        return this.flixtorClient;
    }

    private void addSourceToList(final o source) {
        if (source == null) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: ub.i0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ LinksActivity f20201m = LinksActivity.this;

            @Override // java.lang.Runnable
            public final void run() {
                LinksActivity linksActivity = this.f20201m;
                linksActivity.X.add(0, source);
                linksActivity.Z.notifyDataSetChanged();
                linksActivity.W.setItemAnimator(null);
            }
        });
    }

    private void fetchFlixTorSource() {
        final Movie movie = this.Y;
        if (movie == null || movie.isAnime()) {
            return;
        }
        final int season = this.f11674d0;
        final int episode = this.f11675e0;
        new Thread(new Runnable() { // from class: ub.i0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ LinksActivity f20201m = LinksActivity.this;

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    FlixTorFetcher fetcher = new FlixTorFetcher(getFlixTorClient(), System.getProperty("http.agent", "Mozilla/5.0 (Android)"));
                    boolean isTv = movie.isSeries();
                    String watchUrl = fetcher.search(movie.getTitle(), isTv);
                    if (isTv) {
                        if (watchUrl == null) {
                            watchUrl = fetcher.buildTvWatchUrl(movie.getMovieId(), season, episode);
                        } else if (!watchUrl.contains("?ep=")) {
                            String connector = watchUrl.contains("?") ? "&" : "?";
                            watchUrl = watchUrl + connector + "ep=" + season + ":" + episode;
                        }
                    } else if (watchUrl == null) {
                        watchUrl = fetcher.buildMovieWatchUrl(movie.getMovieId());
                    }
                    String stream = fetcher.resolveStream(watchUrl, isTv ? Integer.valueOf(season) : null, isTv ? Integer.valueOf(episode) : null);
                    if (stream != null) {
                        o source = new o();
                        source.D = stream;
                        source.C = isTv ? "FlixTor TV [AUTO]" : "FlixTor Movie [AUTO]";
                        source.f13047w = true;
                        addSourceToList(source);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }).start();
    }

    private void fetchNineAnimeSource() {
        final Movie movie = this.Y;
        if (movie == null || !movie.isAnime()) {
            return;
        }
        final int episode = this.f11675e0;
        new Thread(new Runnable() { // from class: ub.i0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ LinksActivity f20201m = LinksActivity.this;

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    NineAnimeFetcher fetcher = new NineAnimeFetcher(getFlixTorClient(), System.getProperty("http.agent", "Mozilla/5.0 (Android)"));
                    String watchUrl = fetcher.search(movie.getTitle());
                    String stream = fetcher.resolveEpisode(watchUrl, episode);
                    if (stream != null) {
                        o source = new o();
                        source.D = stream;
                        source.C = "NineAnime [AUTO]";
                        source.f13047w = true;
                        addSourceToList(source);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }).start();
    }

    public void unlockLinkAllRebrid(o oVar) {
        if (App.isADSupported(oVar.D)) {
            oVar.D.contains("rapidgator.net");
            bc.a.unlockLinkAllDebrid(oVar.D).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new l0(this, oVar, 1), new u8.a(29));
        }
    }

    @Override // gd.f
    public void OnSuccess(o oVar) {
        boolean z10 = oVar.f13047w;
        int i10 = 0;
        if (z10) {
            this.f11692v0++;
            this.X.add(0, oVar);
        } else if (oVar.f13044t) {
            if (RealDebridCommon.f12051p && (oVar.f13048x || App.isRdSupported(oVar.D))) {
                bc.a.getLinkRealDebrid(oVar.D, RealDebridCommon.f12049n, RealDebridCommon.f12047b).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new l0(this, oVar, 0), new m0(i10, oVar));
            }
            if (AllDebridCommon.f12043n) {
                unlockLinkAllRebrid(oVar);
            }
        } else {
            if (z10) {
                this.f11692v0++;
            }
            this.X.add(oVar);
        }
        if ((oVar.A || oVar.f13050z || oVar.B) && oVar.f13047w) {
            this.f11691u0 = true;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(lc.c cVar) {
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(o oVar) {
        if (oVar.f13047w) {
            this.f11692v0++;
        }
        this.X.add(oVar);
    }
}
