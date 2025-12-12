package ub;

import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.utils.JsonUtils;
import java.util.ArrayList;

/* compiled from: MovieDetailActivity.java */
/* loaded from: classes2.dex */
public final class m1 implements se.f<com.google.gson.o> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MovieDetailActivity f20233b;

    public m1(MovieDetailActivity movieDetailActivity) {
        this.f20233b = movieDetailActivity;
    }

    @Override // se.f
    public void accept(com.google.gson.o oVar) throws Exception {
        ArrayList<String> suggestions = JsonUtils.parseSuggestions(oVar);
        MovieDetailActivity movieDetailActivity = this.f20233b;
        movieDetailActivity.G0.clearSuggestions();
        movieDetailActivity.G0.addSuggestions(suggestions);
    }
}
