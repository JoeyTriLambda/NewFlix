package ub;

import flix.com.vision.App;
import flix.com.vision.activities.SearchResultsActivity;
import flix.com.vision.models.Movie;
import flix.com.vision.utils.JsonUtils;
import java.util.ArrayList;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class t1 implements se.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20277b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SearchResultsActivity f20278m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f20279n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f20280o;

    public /* synthetic */ t1(SearchResultsActivity searchResultsActivity, int i10, int i11, int i12) {
        this.f20277b = i12;
        this.f20278m = searchResultsActivity;
        this.f20279n = i10;
        this.f20280o = i11;
    }

    @Override // se.f
    public final void accept(Object obj) {
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        int i10 = this.f20277b;
        int i11 = this.f20280o;
        int i12 = this.f20279n;
        SearchResultsActivity searchResultsActivity = this.f20278m;
        switch (i10) {
            case 0:
                searchResultsActivity.f11797f0.setVisibility(8);
                ArrayList<Movie> searchMovies = JsonUtils.parseSearchMovies((com.google.gson.o) obj, i12);
                int size = searchMovies.size();
                ArrayList<Movie> arrayList = searchResultsActivity.U;
                if (size >= 1) {
                    arrayList.addAll(App.getInstance().filterList(searchMovies));
                    if (i12 == searchResultsActivity.T) {
                        ArrayList<Movie> arrayList2 = searchResultsActivity.V;
                        arrayList2.addAll(App.getInstance().filterList(searchMovies));
                        if (arrayList2.size() == 0) {
                            searchResultsActivity.f11798g0.notifyDataSetChanged();
                        } else {
                            searchResultsActivity.f11798g0.notifyItemRangeInserted(arrayList2.size() - 1, searchMovies.size());
                        }
                    }
                    if (arrayList.size() == 100) {
                        sb4 = new StringBuilder();
                        sb4.append(arrayList.size());
                        sb4.append("+");
                    } else {
                        sb4 = new StringBuilder();
                        sb4.append(arrayList.size());
                        sb4.append("");
                    }
                    String string = sb4.toString();
                    if (i11 >= 5) {
                        searchResultsActivity.N.setText("Movies · " + string);
                        break;
                    } else {
                        searchResultsActivity.d(i11 + 1);
                        break;
                    }
                } else {
                    if (arrayList.size() == 100) {
                        sb5 = new StringBuilder();
                        sb5.append(arrayList.size());
                        sb5.append("+");
                    } else {
                        sb5 = new StringBuilder();
                        sb5.append(arrayList.size());
                        sb5.append("");
                    }
                    String string2 = sb5.toString();
                    searchResultsActivity.N.setText("Movies · " + string2);
                    break;
                }
            default:
                searchResultsActivity.f11797f0.setVisibility(8);
                ArrayList<Movie> searchMovies2 = JsonUtils.parseSearchMovies((com.google.gson.o) obj, i12);
                int size2 = searchMovies2.size();
                ArrayList<Movie> arrayList3 = searchResultsActivity.X;
                if (size2 >= 1) {
                    arrayList3.addAll(App.getInstance().filterList(searchMovies2));
                    if (i12 == searchResultsActivity.T) {
                        ArrayList<Movie> arrayList4 = searchResultsActivity.V;
                        arrayList4.addAll(App.getInstance().filterList(searchMovies2));
                        if (arrayList4.size() == 0) {
                            searchResultsActivity.f11798g0.notifyDataSetChanged();
                        } else {
                            searchResultsActivity.f11798g0.notifyItemRangeInserted(arrayList4.size() - 1, searchMovies2.size());
                        }
                    }
                    if (arrayList3.size() == 100) {
                        sb2 = new StringBuilder();
                        sb2.append(arrayList3.size());
                        sb2.append("+");
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(arrayList3.size());
                        sb2.append("");
                    }
                    String string3 = sb2.toString();
                    if (i11 >= 5) {
                        searchResultsActivity.M.setText("Series · " + string3);
                        break;
                    } else {
                        searchResultsActivity.f(i11 + 1);
                        break;
                    }
                } else {
                    if (arrayList3.size() == 100) {
                        sb3 = new StringBuilder();
                        sb3.append(arrayList3.size());
                        sb3.append("+");
                    } else {
                        sb3 = new StringBuilder();
                        sb3.append(arrayList3.size());
                        sb3.append("");
                    }
                    String string4 = sb3.toString();
                    searchResultsActivity.M.setText("Series · " + string4);
                    break;
                }
        }
    }
}
