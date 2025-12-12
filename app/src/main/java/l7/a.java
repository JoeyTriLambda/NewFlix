package l7;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.drawerlayout.widget.DrawerLayout;
import flix.com.vision.App;
import flix.com.vision.activities.AnimeDetailActivity;
import flix.com.vision.activities.AnimeSearchResultActivty;
import flix.com.vision.activities.AnimesListActivity;
import flix.com.vision.activities.DramaDetailActivity;
import flix.com.vision.activities.DramaFilterActivity;
import flix.com.vision.activities.DramaSearchActivityMobile;
import flix.com.vision.activities.DramaSearchResultActivity;
import flix.com.vision.activities.FilterActivity;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.activities.SearchActivityClassic;
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.activities.adult.AdultCategoriesActivity;
import flix.com.vision.activities.adult.AdultHistoryActivity;
import flix.com.vision.activities.adult.AdultVideosActivity;
import flix.com.vision.activities.adult.AdultVideosFavoritesActivity;
import flix.com.vision.activities.adult.AdultVideosSearchActivity;
import flix.com.vision.activities.leanback.FilterActivityLeanBack;
import flix.com.vision.tv.TVCategoriesActivity2;
import io.github.giangpham96.expandable_textview.ExpandableTextView;
import java.util.ArrayList;
import v7.k;
import zf.i;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f15916b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f15917m;

    public /* synthetic */ a(Object obj, int i10) {
        this.f15916b = i10;
        this.f15917m = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i10 = this.f15916b;
        Object obj = this.f15917m;
        switch (i10) {
            case 0:
                ((DrawerLayout) obj).setScrimColor(o0.a.setAlphaComponent(-1728053248, p6.a.lerp(b.f15918a, 0, valueAnimator.getAnimatedFraction())));
                break;
            case 1:
                k kVar = (k) obj;
                kVar.getClass();
                kVar.f20561d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 2:
                ArrayList<String> arrayList = App.B;
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable.setGradientRadius(450.0f);
                ((View) obj).setBackground(gradientDrawable);
                break;
            case 3:
                AnimeDetailActivity animeDetailActivity = (AnimeDetailActivity) obj;
                int i11 = AnimeDetailActivity.f11584e0;
                animeDetailActivity.getClass();
                GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable2.setGradientRadius(450.0f);
                animeDetailActivity.f11585a0.setBackground(gradientDrawable2);
                break;
            case 4:
                AnimeSearchResultActivty animeSearchResultActivty = (AnimeSearchResultActivty) obj;
                int i12 = AnimeSearchResultActivty.f11596a0;
                animeSearchResultActivty.getClass();
                GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable3.setGradientRadius(450.0f);
                animeSearchResultActivty.Y.setBackground(gradientDrawable3);
                break;
            case 5:
                AnimesListActivity animesListActivity = (AnimesListActivity) obj;
                int i13 = AnimesListActivity.f11597f0;
                animesListActivity.getClass();
                GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable4.setGradientRadius(450.0f);
                animesListActivity.Z.setBackground(gradientDrawable4);
                break;
            case 6:
                DramaDetailActivity dramaDetailActivity = (DramaDetailActivity) obj;
                int i14 = DramaDetailActivity.f11610b0;
                dramaDetailActivity.getClass();
                GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable5.setGradientRadius(450.0f);
                dramaDetailActivity.Y.setBackground(gradientDrawable5);
                break;
            case 7:
                DramaFilterActivity dramaFilterActivity = (DramaFilterActivity) obj;
                int i15 = DramaFilterActivity.f11616a0;
                dramaFilterActivity.getClass();
                GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable6.setGradientRadius(450.0f);
                dramaFilterActivity.P.setBackground(gradientDrawable6);
                break;
            case 8:
                DramaSearchActivityMobile dramaSearchActivityMobile = (DramaSearchActivityMobile) obj;
                int i16 = DramaSearchActivityMobile.U;
                dramaSearchActivityMobile.getClass();
                GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable7.setGradientRadius(450.0f);
                dramaSearchActivityMobile.K.setBackground(gradientDrawable7);
                break;
            case 9:
                DramaSearchResultActivity dramaSearchResultActivity = (DramaSearchResultActivity) obj;
                int i17 = DramaSearchResultActivity.f11655a0;
                dramaSearchResultActivity.getClass();
                GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable8.setGradientRadius(450.0f);
                dramaSearchResultActivity.X.setBackground(gradientDrawable8);
                break;
            case 10:
                FilterActivity filterActivity = (FilterActivity) obj;
                int i18 = FilterActivity.f11656o0;
                filterActivity.getClass();
                GradientDrawable gradientDrawable9 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable9.setGradientRadius(450.0f);
                filterActivity.X.setBackground(gradientDrawable9);
                break;
            case 11:
                MainActivity mainActivity = (MainActivity) obj;
                int i19 = MainActivity.f11697v0;
                mainActivity.getClass();
                GradientDrawable gradientDrawable10 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable10.setGradientRadius(450.0f);
                mainActivity.U.setBackground(gradientDrawable10);
                break;
            case 12:
                MovieDetailActivity movieDetailActivity = (MovieDetailActivity) obj;
                int i20 = MovieDetailActivity.f11726u1;
                movieDetailActivity.getClass();
                GradientDrawable gradientDrawable11 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable11.setGradientRadius(450.0f);
                movieDetailActivity.f11734d1.setBackground(gradientDrawable11);
                break;
            case 13:
                SearchActivityClassic searchActivityClassic = (SearchActivityClassic) obj;
                int i21 = SearchActivityClassic.O;
                searchActivityClassic.getClass();
                GradientDrawable gradientDrawable12 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable12.setGradientRadius(450.0f);
                searchActivityClassic.K.setBackground(gradientDrawable12);
                break;
            case 14:
                SearchActivityTV searchActivityTV = (SearchActivityTV) obj;
                int i22 = SearchActivityTV.f11775j0;
                searchActivityTV.getClass();
                GradientDrawable gradientDrawable13 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable13.setGradientRadius(450.0f);
                searchActivityTV.f11780e0.setBackground(gradientDrawable13);
                break;
            case 15:
                AdultCategoriesActivity adultCategoriesActivity = (AdultCategoriesActivity) obj;
                int i23 = AdultCategoriesActivity.f11887a0;
                adultCategoriesActivity.getClass();
                GradientDrawable gradientDrawable14 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable14.setGradientRadius(450.0f);
                adultCategoriesActivity.M.setBackground(gradientDrawable14);
                break;
            case 16:
                AdultHistoryActivity adultHistoryActivity = (AdultHistoryActivity) obj;
                int i24 = AdultHistoryActivity.X;
                adultHistoryActivity.getClass();
                GradientDrawable gradientDrawable15 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable15.setGradientRadius(450.0f);
                adultHistoryActivity.L.setBackground(gradientDrawable15);
                break;
            case 17:
                AdultVideosActivity adultVideosActivity = (AdultVideosActivity) obj;
                int i25 = AdultVideosActivity.f11889g0;
                adultVideosActivity.getClass();
                GradientDrawable gradientDrawable16 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable16.setGradientRadius(450.0f);
                adultVideosActivity.M.setBackground(gradientDrawable16);
                break;
            case 18:
                AdultVideosFavoritesActivity adultVideosFavoritesActivity = (AdultVideosFavoritesActivity) obj;
                int i26 = AdultVideosFavoritesActivity.X;
                adultVideosFavoritesActivity.getClass();
                GradientDrawable gradientDrawable17 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable17.setGradientRadius(450.0f);
                adultVideosFavoritesActivity.L.setBackground(gradientDrawable17);
                break;
            case 19:
                AdultVideosSearchActivity adultVideosSearchActivity = (AdultVideosSearchActivity) obj;
                int i27 = AdultVideosSearchActivity.Z;
                adultVideosSearchActivity.getClass();
                GradientDrawable gradientDrawable18 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable18.setGradientRadius(450.0f);
                adultVideosSearchActivity.K.setBackground(gradientDrawable18);
                break;
            case 20:
                FilterActivityLeanBack filterActivityLeanBack = (FilterActivityLeanBack) obj;
                int i28 = FilterActivityLeanBack.f11904o0;
                filterActivityLeanBack.getClass();
                GradientDrawable gradientDrawable19 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable19.setGradientRadius(450.0f);
                filterActivityLeanBack.X.setBackground(gradientDrawable19);
                break;
            case 21:
                TVCategoriesActivity2 tVCategoriesActivity2 = (TVCategoriesActivity2) obj;
                int i29 = TVCategoriesActivity2.f12477l0;
                tVCategoriesActivity2.getClass();
                GradientDrawable gradientDrawable20 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{((Integer) valueAnimator.getAnimatedValue()).intValue(), -16777216});
                gradientDrawable20.setGradientRadius(450.0f);
                tVCategoriesActivity2.L.setBackground(gradientDrawable20);
                break;
            default:
                ExpandableTextView expandableTextView = (ExpandableTextView) obj;
                int i30 = ExpandableTextView.C;
                i.checkNotNullParameter(expandableTextView, "this$0");
                i.checkNotNullParameter(valueAnimator, "value");
                ViewGroup.LayoutParams layoutParams = expandableTextView.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = expandableTextView.getLayoutParams();
                Object animatedValue = valueAnimator.getAnimatedValue();
                i.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                layoutParams2.height = ((Integer) animatedValue).intValue();
                expandableTextView.setLayoutParams(layoutParams);
                break;
        }
    }
}
