package com.google.android.youtube.player;

import a8.e;
import a8.g;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.google.android.youtube.player.b;
import com.google.android.youtube.player.internal.i;
import com.google.android.youtube.player.internal.w;

/* loaded from: classes.dex */
public final class c implements i.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f9564a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ YouTubePlayerView f9565b;

    public c(YouTubePlayerView youTubePlayerView, a aVar) {
        this.f9565b = youTubePlayerView;
        this.f9564a = aVar;
    }

    @Override // com.google.android.youtube.player.internal.i.a
    public final void a() {
        YouTubePlayerView youTubePlayerView = this.f9565b;
        a8.b bVar = youTubePlayerView.f9550o;
        a8.d dVar = youTubePlayerView.f9553r;
        if (bVar != null) {
            try {
                boolean zA = false;
                e eVar = new e(youTubePlayerView.f9550o, com.google.android.youtube.player.internal.a.a().a(this.f9564a, youTubePlayerView.f9550o, false));
                youTubePlayerView.f9551p = eVar;
                View viewA = eVar.a();
                youTubePlayerView.f9552q = viewA;
                youTubePlayerView.addView(viewA);
                youTubePlayerView.removeView(dVar);
                youTubePlayerView.f9549n.a(youTubePlayerView);
                if (youTubePlayerView.f9556u != null) {
                    Bundle bundle = youTubePlayerView.f9555t;
                    if (bundle != null) {
                        zA = youTubePlayerView.f9551p.a(bundle);
                        youTubePlayerView.f9555t = null;
                    }
                    youTubePlayerView.f9556u.onInitializationSuccess(youTubePlayerView.f9554s, youTubePlayerView.f9551p, zA);
                    youTubePlayerView.f9556u = null;
                }
            } catch (w.a e10) {
                g.a("Error creating YouTubePlayerView", e10);
                YouTubeInitializationResult youTubeInitializationResult = YouTubeInitializationResult.INTERNAL_ERROR;
                youTubePlayerView.f9551p = null;
                dVar.c();
                b.a aVar = youTubePlayerView.f9556u;
                if (aVar != null) {
                    aVar.onInitializationFailure(youTubePlayerView.f9554s, youTubeInitializationResult);
                    youTubePlayerView.f9556u = null;
                }
            }
        }
        youTubePlayerView.f9550o = null;
    }

    @Override // com.google.android.youtube.player.internal.i.a
    public final void b() {
        e eVar;
        YouTubePlayerView youTubePlayerView = this.f9565b;
        if (!youTubePlayerView.f9557v && (eVar = youTubePlayerView.f9551p) != null) {
            eVar.f();
        }
        youTubePlayerView.f9553r.a();
        if (youTubePlayerView.indexOfChild(youTubePlayerView.f9553r) < 0) {
            youTubePlayerView.addView(youTubePlayerView.f9553r);
            youTubePlayerView.removeView(youTubePlayerView.f9552q);
        }
        youTubePlayerView.f9552q = null;
        youTubePlayerView.f9551p = null;
        youTubePlayerView.f9550o = null;
    }
}
