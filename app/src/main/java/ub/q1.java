package ub;

import flix.com.vision.App;
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.models.Movie;
import flix.com.vision.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class q1 implements se.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20254b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SearchActivityTV f20255m;

    public /* synthetic */ q1(SearchActivityTV searchActivityTV, int i10) {
        this.f20254b = i10;
        this.f20255m = searchActivityTV;
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = this.f20254b;
        SearchActivityTV searchActivityTV = this.f20255m;
        switch (i10) {
            case 0:
                int i11 = SearchActivityTV.f11775j0;
                searchActivityTV.getClass();
                ArrayList<Movie> searchMulti = JsonUtils.parseSearchMulti((com.google.gson.o) obj);
                int size = searchMulti.size();
                ArrayList<Movie> arrayList = searchActivityTV.M;
                if (size > 0) {
                    searchActivityTV.T.setVisibility(8);
                    arrayList.clear();
                }
                arrayList.addAll(searchMulti);
                searchActivityTV.N.notifyDataSetChanged();
                searchActivityTV.V.scrollToPosition(0);
                searchActivityTV.V.clearFocus();
                searchActivityTV.K.setVisibility(4);
                break;
            case 1:
                searchActivityTV.K.setVisibility(4);
                break;
            default:
                ArrayList<Movie> listMovie = JsonUtils.parseListMovie((com.google.gson.o) obj, searchActivityTV.f11782g0);
                if (listMovie.size() > 0) {
                    searchActivityTV.T.setVisibility(0);
                }
                boolean z10 = searchActivityTV.f11783h0;
                ArrayList<Movie> arrayList2 = searchActivityTV.L;
                ArrayList<Movie> arrayList3 = searchActivityTV.M;
                if (z10) {
                    arrayList3.clear();
                    arrayList2.clear();
                }
                arrayList2.addAll(App.getInstance().filterList(listMovie));
                arrayList3.addAll(App.getInstance().filterList(listMovie));
                if (!searchActivityTV.f11783h0) {
                    Collections.shuffle(arrayList3);
                    searchActivityTV.N.notifyDataSetChanged();
                    searchActivityTV.V.scrollToPosition(0);
                    searchActivityTV.K.setVisibility(4);
                    break;
                } else {
                    searchActivityTV.f11783h0 = false;
                    searchActivityTV.f11782g0 = searchActivityTV.f11782g0 == 0 ? 1 : 0;
                    searchActivityTV.d();
                    break;
                }
        }
    }
}
