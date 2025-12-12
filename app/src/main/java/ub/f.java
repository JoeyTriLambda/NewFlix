package ub;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import flix.com.vision.App;
import flix.com.vision.activities.AnimeSearchResultActivityClassic;
import flix.com.vision.activities.AnimesListActivity;
import flix.com.vision.activities.DramaHomeActivity;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.activities.SearchResultsActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class f implements AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20175b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ wb.a f20176m;

    public /* synthetic */ f(wb.a aVar, int i10) {
        this.f20175b = i10;
        this.f20176m = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        int i11 = this.f20175b;
        wb.a aVar = this.f20176m;
        switch (i11) {
            case 0:
                AnimesListActivity animesListActivity = (AnimesListActivity) aVar;
                String suggestionAtPosition = animesListActivity.K.getSuggestionAtPosition(i10);
                if (suggestionAtPosition != null && suggestionAtPosition.length() >= 1) {
                    Intent intent = new Intent(animesListActivity, (Class<?>) AnimeSearchResultActivityClassic.class);
                    intent.putExtra("query", suggestionAtPosition);
                    animesListActivity.startActivity(intent);
                    break;
                }
                break;
            case 1:
                DramaHomeActivity dramaHomeActivity = (DramaHomeActivity) aVar;
                String suggestionAtPosition2 = dramaHomeActivity.L.getSuggestionAtPosition(i10);
                if (suggestionAtPosition2 != null && suggestionAtPosition2.length() >= 1) {
                    Intent intent2 = new Intent(dramaHomeActivity, (Class<?>) AnimeSearchResultActivityClassic.class);
                    intent2.putExtra("query", suggestionAtPosition2);
                    dramaHomeActivity.startActivity(intent2);
                    break;
                }
                break;
            case 2:
                MainActivity mainActivity = (MainActivity) aVar;
                String suggestionAtPosition3 = mainActivity.f11698a0.getSuggestionAtPosition(i10);
                if (suggestionAtPosition3 != null && suggestionAtPosition3.length() >= 1) {
                    Intent intent3 = new Intent(mainActivity, (Class<?>) SearchResultsActivity.class);
                    intent3.putExtra("query", suggestionAtPosition3);
                    intent3.putExtra("tv_shows_only", App.getInstance().f11574v.getInt("content_type", 0) == 1);
                    mainActivity.startActivity(intent3);
                    mainActivity.f11698a0.saveQueryToDb(suggestionAtPosition3, System.currentTimeMillis());
                    break;
                }
                break;
            default:
                MovieDetailActivity movieDetailActivity = (MovieDetailActivity) aVar;
                String suggestionAtPosition4 = movieDetailActivity.G0.getSuggestionAtPosition(i10);
                if (suggestionAtPosition4 != null && suggestionAtPosition4.length() >= 1) {
                    Intent intent4 = new Intent(movieDetailActivity, (Class<?>) SearchResultsActivity.class);
                    intent4.putExtra("query", suggestionAtPosition4);
                    movieDetailActivity.startActivity(intent4);
                    movieDetailActivity.G0.saveQueryToDb(suggestionAtPosition4, System.currentTimeMillis());
                    break;
                }
                break;
        }
    }
}
