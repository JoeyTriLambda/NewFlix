package flix.com.vision.activities;

import a8.e;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.activity.d;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.b;
import flix.com.vision.R;
import flix.com.vision.activities.player.YouTubeWebviewActivity;
import ub.q0;

/* loaded from: classes2.dex */
public class YouTubePlayerActivity extends com.google.android.youtube.player.a {

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f11878t = 0;

    /* renamed from: q, reason: collision with root package name */
    public String f11880q;

    /* renamed from: r, reason: collision with root package name */
    public YouTubePlayerView f11881r;

    /* renamed from: p, reason: collision with root package name */
    public final String f11879p = "AIzaSyBzhds8N-w2US3XGiZ0gsGoXQolv3H1r1E";

    /* renamed from: s, reason: collision with root package name */
    public boolean f11882s = false;

    public class a implements b.a {
        public a() {
        }

        @Override // com.google.android.youtube.player.b.a
        public void onInitializationFailure(b.InterfaceC0093b interfaceC0093b, YouTubeInitializationResult youTubeInitializationResult) {
            YouTubePlayerActivity youTubePlayerActivity = YouTubePlayerActivity.this;
            Intent intent = new Intent(youTubePlayerActivity, (Class<?>) YouTubeWebviewActivity.class);
            intent.putExtra("url", "https://www.youtube.com/watch?v=" + youTubePlayerActivity.f11880q);
            youTubePlayerActivity.startActivity(intent);
            youTubePlayerActivity.finish();
        }

        @Override // com.google.android.youtube.player.b.a
        public void onInitializationSuccess(b.InterfaceC0093b interfaceC0093b, com.google.android.youtube.player.b bVar, boolean z10) {
            e eVar = (e) bVar;
            eVar.loadVideo(YouTubePlayerActivity.this.f11880q);
            eVar.setFullscreen(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f11882s) {
            return;
        }
        this.f11882s = true;
        new Handler().postDelayed(new d(this, 29), 2000L);
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle("Exit");
        dVarNewInstance.setMessage("Do you really want to and exit trailer?");
        dVarNewInstance.setButton1("CANCEL", new q0(15));
        dVarNewInstance.setButton2("YES", new androidx.mediarouter.app.b(this, 9));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.google.android.youtube.player.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_you_tube_player);
        this.f11881r = (YouTubePlayerView) findViewById(R.id.player);
        this.f11880q = getIntent().getStringExtra("id");
        this.f11881r.initialize(this.f11879p, new a());
    }
}
