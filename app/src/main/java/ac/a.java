package ac;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.activities.SeriesDetailActivity;
import flix.com.vision.activities.player.PlayerActivityLiveTV;
import flix.com.vision.tv.ChannelsListActivity2;
import flix.com.vision.tv.ChannelsListActivityImport;
import flix.com.vision.tv.PlayerActivityLiveExtended;
import flix.com.vision.tv.PlayerActivityLiveExternal;
import flix.com.vision.tv.TVChannelFavoritesActivity;
import flix.com.vision.tv.TVChannelSearchActivity;
import java.util.ArrayList;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f384b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f385m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.Adapter f386n;

    public /* synthetic */ a(RecyclerView.Adapter adapter, int i10, int i11) {
        this.f384b = i11;
        this.f386n = adapter;
        this.f385m = i10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f384b;
        int i11 = this.f385m;
        RecyclerView.Adapter adapter = this.f386n;
        switch (i10) {
            case 0:
                ((d) adapter).f409g.openCategory(i11);
                break;
            case 1:
                ((f) adapter).f446f.openAdultVideo(i11);
                break;
            case 2:
                k kVar = (k) adapter;
                Activity activity = kVar.f489f;
                boolean z10 = activity instanceof PlayerActivityLiveTV;
                ArrayList<hd.d> arrayList = kVar.f491h;
                if (!z10) {
                    if (!(activity instanceof ChannelsListActivity2)) {
                        if (!(activity instanceof PlayerActivityLiveExtended)) {
                            if (!(activity instanceof PlayerActivityLiveExternal)) {
                                if (!(activity instanceof ChannelsListActivityImport)) {
                                    if (!(activity instanceof TVChannelSearchActivity)) {
                                        if (activity instanceof TVChannelFavoritesActivity) {
                                            ((TVChannelFavoritesActivity) activity).playChannel(arrayList.get(i11));
                                            break;
                                        }
                                    } else {
                                        ((TVChannelSearchActivity) activity).playChannel(arrayList.get(i11));
                                        break;
                                    }
                                } else {
                                    ((ChannelsListActivityImport) activity).playChannel(arrayList.get(i11));
                                    break;
                                }
                            } else {
                                ((PlayerActivityLiveExternal) activity).playChannel(i11);
                                break;
                            }
                        } else {
                            ((PlayerActivityLiveExtended) activity).playChannel(i11);
                            break;
                        }
                    } else {
                        ((ChannelsListActivity2) activity).OpenChannel(arrayList.get(i11));
                        break;
                    }
                } else {
                    ((PlayerActivityLiveTV) activity).playChannel(arrayList.get(i11), false);
                    break;
                }
                break;
            case 3:
                q qVar = (q) adapter;
                ArrayList<hd.f> arrayList2 = qVar.f537g;
                boolean z11 = arrayList2.get(i11).f13005y;
                SeriesDetailActivity seriesDetailActivity = qVar.f538h;
                if (!z11) {
                    Toast.makeText(seriesDetailActivity, "Episode will be available on " + arrayList2.get(i11).f12993m, 1).show();
                    break;
                } else {
                    seriesDetailActivity.openEpisode(i11);
                    break;
                }
            case 4:
                v vVar = (v) adapter;
                vVar.f583f.openEpisode(i11);
                vVar.f582e = i11;
                break;
            default:
                w wVar = (w) adapter;
                wVar.f587e.openSeason(i11);
                wVar.f589g = i11 + 1;
                wVar.notifyDataSetChanged();
                new Handler().postDelayed(new n0.h(i11, 2, wVar), 500L);
                break;
        }
    }
}
