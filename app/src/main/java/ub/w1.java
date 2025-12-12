package ub;

import android.view.View;
import flix.com.vision.App;
import flix.com.vision.activities.SeriesDetailActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class w1 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20309b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SeriesDetailActivity f20310m;

    public /* synthetic */ w1(SeriesDetailActivity seriesDetailActivity, int i10) {
        this.f20309b = i10;
        this.f20310m = seriesDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20309b;
        SeriesDetailActivity seriesDetailActivity = this.f20310m;
        switch (i10) {
            case 0:
                int i11 = SeriesDetailActivity.f11800h0;
                seriesDetailActivity.getClass();
                App.getInstance().f11572t.traktAddToWatchedHistoryEpisode(seriesDetailActivity.X, seriesDetailActivity.f11803c0, seriesDetailActivity.f11804d0);
                break;
            default:
                if (seriesDetailActivity.R.size() >= 2) {
                    try {
                        kc.e.newInstance(seriesDetailActivity, seriesDetailActivity, seriesDetailActivity.R, seriesDetailActivity.f11803c0).show(seriesDetailActivity.getFragmentManager(), "");
                        break;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        return;
                    }
                }
                break;
        }
    }
}
