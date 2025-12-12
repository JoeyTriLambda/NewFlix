package ac;

import ac.b0;
import ac.c0;
import ac.d;
import ac.d0;
import ac.f;
import ac.h;
import ac.k;
import ac.l;
import ac.m;
import ac.n;
import ac.r;
import ac.t;
import ac.w;
import ac.y;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.SearchResultsActivity;
import flix.com.vision.activities.SeriesDetailActivity;
import flix.com.vision.tv.ChannelsListActivityImport;
import flix.com.vision.tv.TVCategoriesActivity2;
import flix.com.vision.tv.TVChannelFavoritesActivity;
import flix.com.vision.tv.TVChannelSearchActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f387b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.Adapter f388m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.z f389n;

    public /* synthetic */ b(RecyclerView.Adapter adapter, RecyclerView.z zVar, int i10) {
        this.f387b = i10;
        this.f388m = adapter;
        this.f389n = zVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        int i10 = this.f387b;
        RecyclerView.z zVar = this.f389n;
        RecyclerView.Adapter adapter = this.f388m;
        switch (i10) {
            case 0:
                d dVar = (d) adapter;
                d.a aVar = (d.a) zVar;
                dVar.getClass();
                if (!z10) {
                    if (App.getInstance().f11574v.getBoolean("pref_adult_zone_animate", false)) {
                        o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                    }
                    aVar.f411v.setBackground(null);
                    break;
                } else {
                    if (App.getInstance().f11574v.getBoolean("pref_adult_zone_animate", false)) {
                        o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
                    }
                    aVar.f411v.setBackground(dVar.f409g.getResources().getDrawable(R.drawable.season_item_border_selected));
                    break;
                }
            case 1:
                f fVar = (f) adapter;
                f.a aVar2 = (f.a) zVar;
                fVar.getClass();
                if (!z10) {
                    if (App.getInstance().f11574v.getBoolean("pref_adult_zone_animate", true)) {
                        o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                    }
                    aVar2.f448v.setBackground(null);
                    break;
                } else {
                    if (App.getInstance().f11574v.getBoolean("pref_adult_zone_animate", true)) {
                        o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
                    }
                    aVar2.f448v.setBackground(fVar.f445e.getResources().getDrawable(R.drawable.season_item_border_selected));
                    break;
                }
            case 2:
                h hVar = (h) adapter;
                h.a aVar3 = (h.a) zVar;
                hVar.getClass();
                if (!z10) {
                    o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                    aVar3.f463v.setBackground(null);
                    aVar3.f463v.setBackground(null);
                    TextView textView = aVar3.f465x;
                    textView.setHorizontalFadingEdgeEnabled(false);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setMarqueeRepeatLimit(6);
                    textView.setFocusableInTouchMode(false);
                    textView.setHorizontallyScrolling(false);
                    textView.setSelected(false);
                    break;
                } else {
                    o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
                    aVar3.f463v.setBackground(hVar.f459g.getResources().getDrawable(R.drawable.rounded_border_poster));
                    TextView textView2 = aVar3.f465x;
                    textView2.setHorizontalFadingEdgeEnabled(true);
                    textView2.setFocusable(true);
                    textView2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    textView2.setMarqueeRepeatLimit(6);
                    textView2.setFocusableInTouchMode(true);
                    textView2.setHorizontallyScrolling(true);
                    textView2.setSelected(true);
                    break;
                }
            case 3:
                k kVar = (k) adapter;
                k.b bVar = (k.b) zVar;
                int i11 = kVar.f487d;
                if (!z10) {
                    if (i11 != 200) {
                        o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                        break;
                    }
                } else {
                    Activity activity = kVar.f489f;
                    if (activity instanceof ChannelsListActivityImport) {
                        ((ChannelsListActivityImport) activity).ToastChannel(bVar.f493u.f12984q);
                    } else if (activity instanceof TVChannelSearchActivity) {
                        ((TVChannelSearchActivity) activity).ToastChannel(bVar.f493u.f12984q);
                    } else if (activity instanceof TVChannelFavoritesActivity) {
                        ((TVChannelFavoritesActivity) activity).ToastChannel(bVar.f493u.f12984q);
                    }
                    if (i11 != 200) {
                        o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
                        break;
                    }
                }
                break;
            case 4:
                l.a aVar4 = (l.a) zVar;
                Activity activity2 = ((l) adapter).f499f;
                if (!z10) {
                    o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                    aVar4.f503w.setBackgroundColor(activity2.getResources().getColor(R.color.transparent));
                    aVar4.f504x.setAlpha(1.0f);
                    break;
                } else {
                    o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
                    aVar4.f503w.setBackgroundColor(activity2.getResources().getColor(R.color.colorAccent));
                    aVar4.f504x.setAlpha(0.8f);
                    break;
                }
            case 5:
                m mVar = (m) adapter;
                m.a aVar5 = (m.a) zVar;
                mVar.getClass();
                if (!z10) {
                    aVar5.f510v.setBackground(null);
                    aVar5.f510v.setBackground(null);
                    TextView textView3 = aVar5.f512x;
                    textView3.setHorizontalFadingEdgeEnabled(false);
                    textView3.setEllipsize(TextUtils.TruncateAt.END);
                    textView3.setMarqueeRepeatLimit(6);
                    textView3.setFocusableInTouchMode(false);
                    textView3.setHorizontallyScrolling(false);
                    textView3.setSelected(false);
                    break;
                } else {
                    aVar5.f510v.setBackground(mVar.f507e.getResources().getDrawable(R.drawable.rounded_border_poster));
                    TextView textView4 = aVar5.f512x;
                    textView4.setHorizontalFadingEdgeEnabled(true);
                    textView4.setFocusable(true);
                    textView4.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    textView4.setMarqueeRepeatLimit(6);
                    textView4.setFocusableInTouchMode(true);
                    textView4.setHorizontallyScrolling(true);
                    textView4.setSelected(true);
                    break;
                }
            case 6:
                n nVar = (n) adapter;
                n.a aVar6 = (n.a) zVar;
                nVar.getClass();
                if (!z10) {
                    aVar6.f519v.setBackground(null);
                    aVar6.f519v.setBackground(null);
                    TextView textView5 = aVar6.f521x;
                    textView5.setHorizontalFadingEdgeEnabled(false);
                    textView5.setEllipsize(TextUtils.TruncateAt.END);
                    textView5.setMarqueeRepeatLimit(6);
                    textView5.setFocusableInTouchMode(false);
                    textView5.setHorizontallyScrolling(false);
                    textView5.setSelected(false);
                    break;
                } else {
                    aVar6.f519v.setBackground(nVar.f516e.getResources().getDrawable(R.drawable.rounded_border_poster));
                    TextView textView6 = aVar6.f521x;
                    textView6.setHorizontalFadingEdgeEnabled(true);
                    textView6.setFocusable(true);
                    textView6.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    textView6.setMarqueeRepeatLimit(6);
                    textView6.setFocusableInTouchMode(true);
                    textView6.setHorizontallyScrolling(true);
                    textView6.setSelected(true);
                    break;
                }
            case 7:
                r.a aVar7 = (r.a) zVar;
                Context context = ((r) adapter).f550h;
                if (!z10) {
                    aVar7.f553w.setTextColor(context.getResources().getColor(R.color.white));
                    break;
                } else {
                    aVar7.f553w.setTextColor(context.getResources().getColor(R.color.black));
                    break;
                }
            case 8:
                t tVar = (t) adapter;
                t.b bVar2 = (t.b) zVar;
                Activity activity3 = tVar.f562h;
                if (!z10) {
                    if (App.getInstance().f11574v.getBoolean("pref_adult_zone_animate", true) && ((activity3 instanceof MainActivity) || (activity3 instanceof SearchResultsActivity))) {
                        o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                    }
                    bVar2.f571v.setBackground(null);
                    TextView textView7 = bVar2.f573x;
                    textView7.setHorizontalFadingEdgeEnabled(false);
                    textView7.setEllipsize(TextUtils.TruncateAt.END);
                    textView7.setMarqueeRepeatLimit(6);
                    textView7.setFocusableInTouchMode(false);
                    textView7.setHorizontallyScrolling(false);
                    textView7.setSelected(false);
                    break;
                } else {
                    MainActivity mainActivity = tVar.f567m;
                    if (mainActivity != null) {
                        try {
                            bVar2.A.invalidate();
                            b2.b bVarGenerate = b2.b.from(((BitmapDrawable) bVar2.A.getDrawable()).getBitmap()).generate();
                            bVar2.f570u.f12403u = bVarGenerate.getDarkVibrantColor(0);
                            mainActivity.extractDominantColor(bVar2.f570u.f12403u);
                        } catch (Exception unused) {
                        }
                    }
                    if (App.getInstance().f11574v.getBoolean("pref_adult_zone_animate", true) && ((activity3 instanceof MainActivity) || (activity3 instanceof SearchResultsActivity))) {
                        o1.a.c(view, 26.0f, 26.0f, 26.0f, 1.1f).scaleY(1.1f).start();
                    }
                    bVar2.f571v.setBackground(activity3.getResources().getDrawable(R.drawable.rounded_border_poster));
                    TextView textView8 = bVar2.f573x;
                    textView8.setHorizontalFadingEdgeEnabled(true);
                    textView8.setFocusable(true);
                    textView8.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    textView8.setMarqueeRepeatLimit(6);
                    textView8.setFocusableInTouchMode(true);
                    textView8.setHorizontallyScrolling(true);
                    textView8.setSelected(true);
                    break;
                }
                break;
            case 9:
                w wVar = (w) adapter;
                w.a aVar8 = (w.a) zVar;
                SeriesDetailActivity seriesDetailActivity = wVar.f586d;
                if (!z10) {
                    aVar8.f596x.setBackground(null);
                    aVar8.f595w.setVisibility(4);
                    int i12 = wVar.f589g;
                    int i13 = aVar8.f593u.f13013m;
                    RelativeLayout relativeLayout = aVar8.f596x;
                    if (i12 != i13) {
                        relativeLayout.setBackground(null);
                        break;
                    } else {
                        relativeLayout.setBackground(seriesDetailActivity.getResources().getDrawable(R.drawable.season_item_border_selected));
                        break;
                    }
                } else {
                    aVar8.f596x.setBackground(seriesDetailActivity.getResources().getDrawable(R.drawable.season_item_border));
                    aVar8.f595w.setVisibility(0);
                    break;
                }
            case 10:
                y yVar = (y) adapter;
                y.a aVar9 = (y.a) zVar;
                int i14 = yVar.f601d;
                if (!z10) {
                    if (i14 != 200) {
                        o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                        break;
                    }
                } else {
                    gd.l lVar = yVar.f602e;
                    if (lVar instanceof TVCategoriesActivity2) {
                        ((TVCategoriesActivity2) lVar).ToastChannel(aVar9.f604u.getCategoryName());
                    }
                    if (i14 != 200) {
                        o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
                        break;
                    }
                }
                break;
            case 11:
                b0 b0Var = (b0) adapter;
                b0.a aVar10 = (b0.a) zVar;
                b0Var.getClass();
                if (!z10) {
                    aVar10.f393v.setBackground(null);
                    break;
                } else {
                    aVar10.f393v.setBackground(b0Var.f391e.getResources().getDrawable(R.drawable.season_item_border_selected));
                    break;
                }
            case 12:
                c0 c0Var = (c0) adapter;
                c0.a aVar11 = (c0.a) zVar;
                c0Var.getClass();
                if (!z10) {
                    aVar11.f403v.setBackground(null);
                    TextView textView9 = aVar11.f405x;
                    textView9.setHorizontalFadingEdgeEnabled(false);
                    textView9.setEllipsize(TextUtils.TruncateAt.END);
                    textView9.setMarqueeRepeatLimit(6);
                    textView9.setFocusableInTouchMode(false);
                    textView9.setHorizontallyScrolling(false);
                    textView9.setSelected(false);
                    break;
                } else {
                    aVar11.f403v.setBackground(c0Var.f401h.getResources().getDrawable(R.drawable.season_item_border_selected));
                    TextView textView10 = aVar11.f405x;
                    textView10.setHorizontalFadingEdgeEnabled(true);
                    textView10.setFocusable(true);
                    textView10.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    textView10.setMarqueeRepeatLimit(6);
                    textView10.setFocusableInTouchMode(true);
                    textView10.setHorizontallyScrolling(true);
                    textView10.setSelected(true);
                    break;
                }
            default:
                d0 d0Var = (d0) adapter;
                d0.b bVar3 = (d0.b) zVar;
                if (!z10) {
                    d0Var.getClass();
                    bVar3.f427v.setBackground(null);
                    TextView textView11 = bVar3.f429x;
                    textView11.setHorizontalFadingEdgeEnabled(false);
                    textView11.setEllipsize(TextUtils.TruncateAt.END);
                    textView11.setMarqueeRepeatLimit(6);
                    textView11.setFocusableInTouchMode(false);
                    textView11.setHorizontallyScrolling(false);
                    textView11.setSelected(false);
                    break;
                } else {
                    MainActivity mainActivity2 = d0Var.f423l;
                    if (mainActivity2 != null) {
                        try {
                            bVar3.A.invalidate();
                            b2.b bVarGenerate2 = b2.b.from(((BitmapDrawable) bVar3.A.getDrawable()).getBitmap()).generate();
                            bVar3.f426u.f12403u = bVarGenerate2.getDarkVibrantColor(0);
                            mainActivity2.extractDominantColor(bVar3.f426u.f12403u);
                        } catch (Exception unused2) {
                        }
                    }
                    bVar3.f427v.setBackground(d0Var.f418g.getResources().getDrawable(R.drawable.rounded_border_poster));
                    TextView textView12 = bVar3.f429x;
                    textView12.setHorizontalFadingEdgeEnabled(true);
                    textView12.setFocusable(true);
                    textView12.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    textView12.setMarqueeRepeatLimit(6);
                    textView12.setFocusableInTouchMode(true);
                    textView12.setHorizontallyScrolling(true);
                    textView12.setSelected(true);
                    break;
                }
        }
    }
}
