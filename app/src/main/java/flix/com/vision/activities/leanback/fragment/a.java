package flix.com.vision.activities.leanback.fragment;

import ac.c;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.g0;
import com.squareup.picasso.Picasso;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.DramaHomeActivity;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.activities.leanback.FilterActivityLeanBack;
import flix.com.vision.activities.leanback.MainActivityLeanback;
import flix.com.vision.activities.leanback.fragment.TVListFragmentMain;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import me.grantland.widget.AutofitTextView;

/* compiled from: HomeFragment.java */
/* loaded from: classes2.dex */
public class a extends Fragment {

    /* renamed from: h0, reason: collision with root package name */
    public final MainActivityLeanback f11947h0;

    /* renamed from: i0, reason: collision with root package name */
    public FragmentContainerView f11948i0;

    /* renamed from: j0, reason: collision with root package name */
    public c4.a f11949j0;

    /* renamed from: k0, reason: collision with root package name */
    public Typeface f11950k0;

    /* renamed from: l0, reason: collision with root package name */
    public TVListFragmentMain f11951l0;

    /* renamed from: m0, reason: collision with root package name */
    public TextView f11952m0;

    /* renamed from: n0, reason: collision with root package name */
    public TextView f11953n0;

    /* renamed from: o0, reason: collision with root package name */
    public TextView f11954o0;

    /* renamed from: p0, reason: collision with root package name */
    public AutofitTextView f11955p0;

    /* renamed from: q0, reason: collision with root package name */
    public ImageView f11956q0;

    /* renamed from: r0, reason: collision with root package name */
    public final TVListFragmentMain.ContentTypeLB f11957r0;

    public a(MainActivityLeanback mainActivityLeanback, TVListFragmentMain.ContentTypeLB contentTypeLB) {
        this.f11957r0 = TVListFragmentMain.ContentTypeLB.HOME;
        this.f11947h0 = mainActivityLeanback;
        this.f11957r0 = contentTypeLB;
    }

    public void finished() {
        MainActivityLeanback mainActivityLeanback = this.f11947h0;
        if (mainActivityLeanback != null) {
            mainActivityLeanback.finished();
        }
    }

    public int getSelectedPosition() {
        TVListFragmentMain tVListFragmentMain = this.f11951l0;
        if (tVListFragmentMain != null) {
            return tVListFragmentMain.getSelectedPosition();
        }
        return -1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    public void onMovieClicked(Movie movie) {
        App.getInstance().f11566n = false;
        MainActivityLeanback mainActivityLeanback = this.f11947h0;
        if (mainActivityLeanback != null) {
            mainActivityLeanback.openMovieintent(movie);
            return;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) MovieDetailActivity.class);
        intent.putExtra("movie", movie);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void onMovieSelected(Movie movie) {
        this.f11955p0.setText(movie.getTitle());
        this.f11953n0.setText(movie.getOverview());
        if (movie.isSeries()) {
            this.f11954o0.setText(" · Series");
        } else {
            this.f11954o0.setText(" · Film");
        }
        String year = movie.getYear();
        String genres = movie.getGenres();
        if (genres != null && genres.length() > 2) {
            year = c.C(year, " · ", genres);
        }
        this.f11952m0.setText(year);
        try {
            String str = App.I ? "w1280/" : "w780/";
            Picasso.get().load("https://www.themoviedb.org/t/p/" + str + movie.f12400r).fit().centerCrop().into(this.f11956q0);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void onNetworkClicked(ld.a aVar) {
        if (aVar.f16048b == 9991) {
            Intent intent = new Intent(getActivity(), (Class<?>) DramaHomeActivity.class);
            intent.setFlags(268435456);
            startActivity(intent);
        } else {
            Intent intent2 = new Intent(getActivity(), (Class<?>) FilterActivityLeanBack.class);
            intent2.putExtra("network", aVar.f16048b);
            intent2.setFlags(268435456);
            startActivity(intent2);
        }
    }

    public void onNetworkSelected(ld.a aVar) {
        this.f11955p0.setText(aVar.f16050d.getTitle());
        this.f11953n0.setText(aVar.f16050d.getOverview());
        if (aVar.f16050d.isSeries()) {
            this.f11954o0.setText(" · Series");
        } else {
            this.f11954o0.setText(" · Film");
        }
        String year = aVar.f16050d.getYear();
        String genres = aVar.f16050d.getGenres();
        if (genres != null && genres.length() > 2) {
            year = c.C(year, " · ", genres);
        }
        this.f11952m0.setText(year);
        try {
            Picasso.get().load(aVar.f16050d.f12395m).fit().centerCrop().into(this.f11956q0);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f11954o0 = (TextView) view.findViewById(R.id.type_text_view);
        this.f11948i0 = (FragmentContainerView) view.findViewById(R.id.list_fragment);
        view.findViewById(R.id.gradient_horizontal);
        this.f11956q0 = (ImageView) view.findViewById(R.id.img_banner);
        this.f11955p0 = (AutofitTextView) view.findViewById(R.id.title);
        this.f11952m0 = (TextView) view.findViewById(R.id.subtitle);
        this.f11953n0 = (TextView) view.findViewById(R.id.description);
        this.f11949j0 = new c4.a();
        AssetManager assets = getActivity().getAssets();
        String str = Constant.f12450b;
        this.f11950k0 = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f11949j0.applyFontToView(this.f11955p0, Typeface.createFromAsset(getActivity().getAssets(), "fonts/product_sans_bold.ttf"));
        this.f11949j0.applyFontToView(this.f11952m0, this.f11950k0);
        this.f11949j0.applyFontToView(this.f11953n0, this.f11950k0);
        TVListFragmentMain tVListFragmentMain = new TVListFragmentMain(this.f11957r0);
        this.f11951l0 = tVListFragmentMain;
        tVListFragmentMain.setOnContentSelectedListener(this);
        g0 g0VarBeginTransaction = getChildFragmentManager().beginTransaction();
        g0VarBeginTransaction.add(R.id.list_fragment, this.f11951l0);
        g0VarBeginTransaction.commit();
    }

    public void reloadWatchedHistory() {
        TVListFragmentMain tVListFragmentMain = this.f11951l0;
        if (tVListFragmentMain != null) {
            tVListFragmentMain.reloadWatchedHistory();
        }
    }

    public void requestFocus1() {
        FragmentContainerView fragmentContainerView = this.f11948i0;
        if (fragmentContainerView == null) {
            return;
        }
        fragmentContainerView.requestFocus();
    }

    public void setSelectedPosition(int i10) {
        this.f11951l0.setSelectedPosition(i10, true);
    }

    public a() {
        this.f11957r0 = TVListFragmentMain.ContentTypeLB.HOME;
    }

    public void setHome() {
    }
}
