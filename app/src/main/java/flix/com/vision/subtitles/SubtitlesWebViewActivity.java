package flix.com.vision.subtitles;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.squareup.picasso.Picasso;
import fd.b;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.helpers.CursorLayout;
import flix.com.vision.subtitles.SubtitlesWebViewActivity;
import gd.m;
import kc.d;
import org.adblockplus.libadblockplus.android.webview.AdblockWebView;
import ub.q0;
import ub.v;

/* loaded from: classes2.dex */
public class SubtitlesWebViewActivity extends wb.a implements m {
    public static final /* synthetic */ int R = 0;
    public LinearLayout K;
    public TextView L;
    public b M;
    public SpinKitView N;
    public AdblockWebView O;
    public View P;
    public ImageView Q;

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SubtitlesWebViewActivity subtitlesWebViewActivity = SubtitlesWebViewActivity.this;
            LinearLayout linearLayout = subtitlesWebViewActivity.K;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            subtitlesWebViewActivity.N.setVisibility(8);
            subtitlesWebViewActivity.Q.setVisibility(8);
            subtitlesWebViewActivity.O.setVisibility(0);
            subtitlesWebViewActivity.showDialogHelp();
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
        setContentView(R.layout.subtitle_webview_activity);
        View decorView = getWindow().getDecorView();
        this.P = decorView;
        decorView.setSystemUiVisibility(1028);
        this.M = new b();
        this.K = (LinearLayout) findViewById(R.id.info_layout);
        this.Q = (ImageView) findViewById(R.id.poster_yt);
        this.N = (SpinKitView) findViewById(R.id.loader);
        this.L = (TextView) findViewById(R.id.title_text_view);
        this.O = (AdblockWebView) findViewById(R.id.webview);
        CursorLayout cursorLayout = (CursorLayout) findViewById(R.id.cursorLayout);
        if (cursorLayout != null) {
            cursorLayout.setActivity(this);
        }
        this.O.setWebViewClient(new WebViewClient());
        this.O.setDownloadListener(new DownloadListener() { // from class: zd.b
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                int i10 = SubtitlesWebViewActivity.R;
                SubtitlesWebViewActivity subtitlesWebViewActivity = this.f22715a;
                subtitlesWebViewActivity.getClass();
                if (str == null || str.length() <= 0) {
                    return;
                }
                subtitlesWebViewActivity.showDialogSubtitle(str);
            }
        });
        String stringExtra = getIntent().getStringExtra("url");
        String stringExtra2 = getIntent().getStringExtra("title");
        if (stringExtra2 != null) {
            boolean z10 = !stringExtra2.isEmpty();
            TextView textView = this.L;
            if (z10 & (textView != null)) {
                textView.setText(stringExtra2);
            }
        }
        try {
            try {
                Picasso.get().load(R.drawable.open_sub_logo).fit().centerCrop().into(this.Q);
            } catch (OutOfMemoryError e10) {
                e10.printStackTrace();
            }
        } catch (Exception unused) {
        }
        AdblockWebView adblockWebView = this.O;
        if (adblockWebView != null && stringExtra != null) {
            adblockWebView.loadUrl(stringExtra);
        }
        this.O.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.O.getSettings().setSupportMultipleWindows(true);
        this.O.getSettings().setAllowFileAccess(true);
        this.O.setWebViewClient(new a());
        this.O.getSettings().setJavaScriptEnabled(true);
        this.O.getSettings().setAllowContentAccess(true);
    }

    @Override // r.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.M.getDirectionPressed(keyEvent) != 10) {
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
            this.P.setSystemUiVisibility(5894);
        }
    }

    @Override // gd.m
    public void showDialog() {
        FragmentManager fragmentManager = getFragmentManager();
        d dVarNewInstance = d.newInstance(this, true);
        dVarNewInstance.setTitle("Exit");
        dVarNewInstance.setMessage("Do you really want to and exit without downloading Subtitles?");
        dVarNewInstance.setButton1("CANCEL", new q0(27));
        dVarNewInstance.setButton2("YES", new androidx.mediarouter.app.b(this, 13));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void showDialogHelp() {
        if (App.getInstance().f11574v.getBoolean("open_sub_help_shown", false)) {
            return;
        }
        FragmentManager fragmentManager = getFragmentManager();
        d dVarNewInstance = d.newInstance(this, false);
        dVarNewInstance.setTitle("How to Download Subtitles?");
        dVarNewInstance.setMessage("Simply scroll down and select a .SRT or .VTT Subtitle file and we'll download it for you");
        dVarNewInstance.setButton2("GOT IT", new q0(26));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void showDialogSubtitle(String str) {
        String strSubstring = str.length() > 100 ? str.substring(str.lastIndexOf("/") + 1, str.length()) : str;
        FragmentManager fragmentManager = getFragmentManager();
        d dVarNewInstance = d.newInstance(this, true);
        dVarNewInstance.setTitle("Download this Subtitle?");
        dVarNewInstance.setMessage(strSubstring);
        dVarNewInstance.setButton1("CANCEL", new q0(28));
        dVarNewInstance.setButton2("YES", new v(22, this, str));
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
