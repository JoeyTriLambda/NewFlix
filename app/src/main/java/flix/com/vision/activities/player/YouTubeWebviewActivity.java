package flix.com.vision.activities.player;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.github.ybq.android.spinkit.SpinKitView;
import com.squareup.picasso.Picasso;
import fd.b;
import flix.com.vision.R;
import flix.com.vision.helpers.CursorLayout;
import gd.m;
import org.adblockplus.libadblockplus.android.webview.AdblockWebView;
import ub.q0;
import vb.d;

/* loaded from: classes2.dex */
public class YouTubeWebviewActivity extends wb.a implements m {
    public static final /* synthetic */ int U = 0;
    public String K;
    public b L;
    public Animation M;
    public RelativeLayout N;
    public SpinKitView O;
    public AdblockWebView P;
    public View Q;
    public ImageView R;
    public ImageView S;
    public boolean T = false;

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            YouTubeWebviewActivity youTubeWebviewActivity = YouTubeWebviewActivity.this;
            youTubeWebviewActivity.O.setVisibility(8);
            if (youTubeWebviewActivity.T) {
                youTubeWebviewActivity.getClass();
                try {
                    youTubeWebviewActivity.N.setVisibility(8);
                    youTubeWebviewActivity.S.clearAnimation();
                    youTubeWebviewActivity.S.setAlpha(1.0f);
                } catch (Exception unused) {
                }
            }
            youTubeWebviewActivity.R.setVisibility(8);
            youTubeWebviewActivity.P.setVisibility(0);
            new Handler().postDelayed(new d(this, 2), 1500L);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_you_tube_webview);
        View decorView = getWindow().getDecorView();
        this.Q = decorView;
        if (decorView != null) {
            decorView.setSystemUiVisibility(1028);
        }
        this.L = new b();
        this.S = (ImageView) findViewById(R.id.title_poster_img);
        this.N = (RelativeLayout) findViewById(R.id.buffering_layout);
        this.R = (ImageView) findViewById(R.id.poster_yt);
        this.O = (SpinKitView) findViewById(R.id.loader);
        this.P = (AdblockWebView) findViewById(R.id.webview);
        CursorLayout cursorLayout = (CursorLayout) findViewById(R.id.cursorLayout);
        if (cursorLayout != null) {
            cursorLayout.setActivity(this);
        }
        this.P.setWebViewClient(new WebViewClient());
        String stringExtra = getIntent().getStringExtra("url");
        String stringExtra2 = getIntent().getStringExtra("poster");
        if (stringExtra2 != null && !stringExtra2.isEmpty()) {
            try {
                try {
                    Picasso.get().load(stringExtra2).fit().centerCrop().into(this.R);
                } catch (Exception unused) {
                }
            } catch (OutOfMemoryError e10) {
                e10.printStackTrace();
            }
        }
        String stringExtra3 = getIntent().getStringExtra("title_logo");
        this.K = stringExtra3;
        if (stringExtra3 != null && !stringExtra3.isEmpty() && this.N != null) {
            this.T = true;
            try {
                Picasso.get().load(this.K).into(this.S);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            this.M = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_infinite);
            this.O.setVisibility(8);
            try {
                this.S.setAlpha(1.0f);
                this.N.setVisibility(0);
                this.S.startAnimation(this.M);
            } catch (Exception unused2) {
            }
        }
        AdblockWebView adblockWebView = this.P;
        if (adblockWebView != null && stringExtra != null) {
            adblockWebView.loadUrl(stringExtra);
        }
        this.P.setWebViewClient(new a());
        this.P.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.P.getSettings().setSupportMultipleWindows(true);
        this.P.getSettings().setAllowFileAccess(true);
        this.P.getSettings().setJavaScriptEnabled(true);
        this.P.getSettings().setAllowContentAccess(true);
    }

    @Override // r.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.L.getDirectionPressed(keyEvent) != 10) {
            return super.onKeyDown(i10, keyEvent);
        }
        showDialog();
        return true;
    }

    @Override // r.j, androidx.fragment.app.p, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.Q.setSystemUiVisibility(5894);
        }
    }

    @Override // gd.m
    public void showDialog() {
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle("Exit");
        dVarNewInstance.setMessage("Do you really want to and exit trailer?");
        dVarNewInstance.setButton1("CANCEL", new q0(25));
        dVarNewInstance.setButton2("YES", new androidx.mediarouter.app.b(this, 11));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // gd.m
    public void infoToggle(boolean z10) {
    }
}
