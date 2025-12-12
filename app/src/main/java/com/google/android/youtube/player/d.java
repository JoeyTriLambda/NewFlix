package com.google.android.youtube.player;

import com.google.android.youtube.player.b;
import com.google.android.youtube.player.internal.i;

/* loaded from: classes.dex */
public final class d implements i.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ YouTubePlayerView f9566a;

    public d(YouTubePlayerView youTubePlayerView) {
        this.f9566a = youTubePlayerView;
    }

    @Override // com.google.android.youtube.player.internal.i.b
    public final void a(YouTubeInitializationResult youTubeInitializationResult) {
        int i10 = YouTubePlayerView.f9546w;
        YouTubePlayerView youTubePlayerView = this.f9566a;
        youTubePlayerView.f9551p = null;
        youTubePlayerView.f9553r.c();
        b.a aVar = youTubePlayerView.f9556u;
        if (aVar != null) {
            aVar.onInitializationFailure(youTubePlayerView.f9554s, youTubeInitializationResult);
            youTubePlayerView.f9556u = null;
        }
        youTubePlayerView.f9550o = null;
    }
}
