package com.google.android.youtube.player;

import a8.e;
import android.app.Activity;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.b;

/* loaded from: classes.dex */
public class a extends Activity {

    /* renamed from: b, reason: collision with root package name */
    public C0092a f9559b;

    /* renamed from: m, reason: collision with root package name */
    public YouTubePlayerView f9560m;

    /* renamed from: n, reason: collision with root package name */
    public int f9561n;

    /* renamed from: o, reason: collision with root package name */
    public Bundle f9562o;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9559b = new C0092a();
        this.f9562o = bundle != null ? bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        YouTubePlayerView youTubePlayerView = this.f9560m;
        if (youTubePlayerView != null) {
            boolean zIsFinishing = isFinishing();
            e eVar = youTubePlayerView.f9551p;
            if (eVar != null) {
                eVar.b(zIsFinishing);
                youTubePlayerView.f9557v = true;
                e eVar2 = youTubePlayerView.f9551p;
                if (eVar2 != null) {
                    eVar2.a(zIsFinishing);
                }
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        e eVar;
        this.f9561n = 1;
        YouTubePlayerView youTubePlayerView = this.f9560m;
        if (youTubePlayerView != null && (eVar = youTubePlayerView.f9551p) != null) {
            eVar.d();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        e eVar;
        super.onResume();
        this.f9561n = 2;
        YouTubePlayerView youTubePlayerView = this.f9560m;
        if (youTubePlayerView == null || (eVar = youTubePlayerView.f9551p) == null) {
            return;
        }
        eVar.c();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundleH;
        super.onSaveInstanceState(bundle);
        YouTubePlayerView youTubePlayerView = this.f9560m;
        if (youTubePlayerView != null) {
            e eVar = youTubePlayerView.f9551p;
            bundleH = eVar == null ? youTubePlayerView.f9555t : eVar.h();
        } else {
            bundleH = this.f9562o;
        }
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", bundleH);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f9561n = 1;
        YouTubePlayerView youTubePlayerView = this.f9560m;
        if (youTubePlayerView != null) {
            youTubePlayerView.b();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        e eVar;
        this.f9561n = 0;
        YouTubePlayerView youTubePlayerView = this.f9560m;
        if (youTubePlayerView != null && (eVar = youTubePlayerView.f9551p) != null) {
            eVar.e();
        }
        super.onStop();
    }

    /* renamed from: com.google.android.youtube.player.a$a, reason: collision with other inner class name */
    public final class C0092a implements YouTubePlayerView.b {
        public C0092a() {
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView) {
            e eVar;
            a aVar = a.this;
            YouTubePlayerView youTubePlayerView2 = aVar.f9560m;
            if (youTubePlayerView2 != null && youTubePlayerView2 != youTubePlayerView) {
                youTubePlayerView2.f9557v = true;
                e eVar2 = youTubePlayerView2.f9551p;
                if (eVar2 != null) {
                    eVar2.a(true);
                }
            }
            aVar.f9560m = youTubePlayerView;
            if (aVar.f9561n > 0) {
                youTubePlayerView.b();
            }
            if (aVar.f9561n < 2 || (eVar = youTubePlayerView.f9551p) == null) {
                return;
            }
            eVar.c();
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView, String str, b.a aVar) {
            a aVar2 = a.this;
            Bundle bundle = aVar2.f9562o;
            if (youTubePlayerView.f9551p == null && youTubePlayerView.f9556u == null) {
                a8.a.a(aVar2, "activity cannot be null");
                youTubePlayerView.f9554s = (b.InterfaceC0093b) a8.a.a(youTubePlayerView, "provider cannot be null");
                youTubePlayerView.f9556u = (b.a) a8.a.a(aVar, "listener cannot be null");
                youTubePlayerView.f9555t = bundle;
                youTubePlayerView.f9553r.b();
                a8.b bVarA = com.google.android.youtube.player.internal.a.a().a(youTubePlayerView.getContext(), str, new c(youTubePlayerView, aVar2), new d(youTubePlayerView));
                youTubePlayerView.f9550o = bVarA;
                bVarA.e();
            }
            aVar2.f9562o = null;
        }
    }
}
