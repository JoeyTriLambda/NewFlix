package flix.com.vision.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.loopj.android.http.AsyncHttpClient;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.SplashScreenActivity;
import flix.com.vision.activities.leanback.MainActivityLeanback;
import flix.com.vision.tv.Constant;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Calendar;
import r.j;

/* loaded from: classes2.dex */
public class SplashScreenActivity extends j {
    public static final /* synthetic */ int O = 0;
    public Typeface K;
    public SpinKitView L;
    public TextView M;
    public MediaPlayer N;

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MainActivity.resetFilter();
        try {
            if ((getIntent().getFlags() & 4194304) != 0) {
                finish();
                return;
            }
        } catch (Exception unused) {
        }
        setContentView(R.layout.activity_splash_screen);
        this.L = (SpinKitView) findViewById(R.id.loader);
        this.M = (TextView) findViewById(R.id.version);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.K = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        new c4.a().applyFontToView(this.M, this.K);
        final int i10 = 0;
        new Handler().postDelayed(new Runnable(this) { // from class: ub.j2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ SplashScreenActivity f20213m;

            {
                this.f20213m = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, Resources.NotFoundException, IOException, IllegalArgumentException {
                int i11 = i10;
                final SplashScreenActivity splashScreenActivity = this.f20213m;
                switch (i11) {
                    case 0:
                        splashScreenActivity.L.setVisibility(0);
                        break;
                    case 1:
                        int i12 = SplashScreenActivity.O;
                        splashScreenActivity.getClass();
                        try {
                            Intent intent = new Intent(splashScreenActivity, (Class<?>) MainActivityLeanback.class);
                            if (!App.K || App.getInstance().f11574v.getInt("pref_tv_layout", 0) != 0) {
                                intent = new Intent(splashScreenActivity, (Class<?>) MainActivity.class);
                                intent.putExtras(splashScreenActivity.getIntent().getExtras());
                                splashScreenActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            }
                            splashScreenActivity.startActivity(intent);
                        } catch (Exception unused2) {
                            splashScreenActivity.startActivity(new Intent(splashScreenActivity, (Class<?>) MainActivity.class));
                            splashScreenActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        }
                        splashScreenActivity.finish();
                        break;
                    default:
                        int i13 = SplashScreenActivity.O;
                        splashScreenActivity.getClass();
                        if (App.K) {
                            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = splashScreenActivity.getResources().openRawResourceFd(R.raw.flix_sound);
                            FileDescriptor fileDescriptor = assetFileDescriptorOpenRawResourceFd.getFileDescriptor();
                            MediaPlayer mediaPlayer = new MediaPlayer();
                            splashScreenActivity.N = mediaPlayer;
                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: ub.k2
                                @Override // android.media.MediaPlayer.OnCompletionListener
                                public final void onCompletion(MediaPlayer mediaPlayer2) {
                                    int i14 = SplashScreenActivity.O;
                                    SplashScreenActivity splashScreenActivity2 = splashScreenActivity;
                                    splashScreenActivity2.getClass();
                                    try {
                                        splashScreenActivity2.N.release();
                                    } catch (Exception unused3) {
                                    }
                                }
                            });
                            try {
                                splashScreenActivity.N.setDataSource(fileDescriptor, assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                                splashScreenActivity.N.setLooping(false);
                                splashScreenActivity.N.prepare();
                                splashScreenActivity.N.seekTo(AsyncHttpClient.DEFAULT_RETRY_SLEEP_TIME_MILLIS);
                                splashScreenActivity.N.setVolume(0.4f, 0.4f);
                                splashScreenActivity.N.start();
                                break;
                            } catch (IOException | Exception unused3) {
                                return;
                            }
                        }
                        break;
                }
            }
        }, 4000L);
        final int i11 = 1;
        try {
            String str2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            String str3 = Calendar.getInstance().get(1) + "";
            this.M.setText("©" + str3 + " flixvision.tv · v" + str2);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        } catch (Exception unused2) {
            this.M.setText("© FLIX VISION");
        }
        new Handler().postDelayed(new Runnable(this) { // from class: ub.j2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ SplashScreenActivity f20213m;

            {
                this.f20213m = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, Resources.NotFoundException, IOException, IllegalArgumentException {
                int i112 = i11;
                final SplashScreenActivity splashScreenActivity = this.f20213m;
                switch (i112) {
                    case 0:
                        splashScreenActivity.L.setVisibility(0);
                        break;
                    case 1:
                        int i12 = SplashScreenActivity.O;
                        splashScreenActivity.getClass();
                        try {
                            Intent intent = new Intent(splashScreenActivity, (Class<?>) MainActivityLeanback.class);
                            if (!App.K || App.getInstance().f11574v.getInt("pref_tv_layout", 0) != 0) {
                                intent = new Intent(splashScreenActivity, (Class<?>) MainActivity.class);
                                intent.putExtras(splashScreenActivity.getIntent().getExtras());
                                splashScreenActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            }
                            splashScreenActivity.startActivity(intent);
                        } catch (Exception unused22) {
                            splashScreenActivity.startActivity(new Intent(splashScreenActivity, (Class<?>) MainActivity.class));
                            splashScreenActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        }
                        splashScreenActivity.finish();
                        break;
                    default:
                        int i13 = SplashScreenActivity.O;
                        splashScreenActivity.getClass();
                        if (App.K) {
                            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = splashScreenActivity.getResources().openRawResourceFd(R.raw.flix_sound);
                            FileDescriptor fileDescriptor = assetFileDescriptorOpenRawResourceFd.getFileDescriptor();
                            MediaPlayer mediaPlayer = new MediaPlayer();
                            splashScreenActivity.N = mediaPlayer;
                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: ub.k2
                                @Override // android.media.MediaPlayer.OnCompletionListener
                                public final void onCompletion(MediaPlayer mediaPlayer2) {
                                    int i14 = SplashScreenActivity.O;
                                    SplashScreenActivity splashScreenActivity2 = splashScreenActivity;
                                    splashScreenActivity2.getClass();
                                    try {
                                        splashScreenActivity2.N.release();
                                    } catch (Exception unused3) {
                                    }
                                }
                            });
                            try {
                                splashScreenActivity.N.setDataSource(fileDescriptor, assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                                splashScreenActivity.N.setLooping(false);
                                splashScreenActivity.N.prepare();
                                splashScreenActivity.N.seekTo(AsyncHttpClient.DEFAULT_RETRY_SLEEP_TIME_MILLIS);
                                splashScreenActivity.N.setVolume(0.4f, 0.4f);
                                splashScreenActivity.N.start();
                                break;
                            } catch (IOException | Exception unused3) {
                                return;
                            }
                        }
                        break;
                }
            }
        }, 7000L);
        if (App.getInstance().f11574v.getBoolean("pref_play_intro_sound", true)) {
            final int i12 = 2;
            new Handler().postDelayed(new Runnable(this) { // from class: ub.j2

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ SplashScreenActivity f20213m;

                {
                    this.f20213m = this;
                }

                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException, Resources.NotFoundException, IOException, IllegalArgumentException {
                    int i112 = i12;
                    final SplashScreenActivity splashScreenActivity = this.f20213m;
                    switch (i112) {
                        case 0:
                            splashScreenActivity.L.setVisibility(0);
                            break;
                        case 1:
                            int i122 = SplashScreenActivity.O;
                            splashScreenActivity.getClass();
                            try {
                                Intent intent = new Intent(splashScreenActivity, (Class<?>) MainActivityLeanback.class);
                                if (!App.K || App.getInstance().f11574v.getInt("pref_tv_layout", 0) != 0) {
                                    intent = new Intent(splashScreenActivity, (Class<?>) MainActivity.class);
                                    intent.putExtras(splashScreenActivity.getIntent().getExtras());
                                    splashScreenActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                }
                                splashScreenActivity.startActivity(intent);
                            } catch (Exception unused22) {
                                splashScreenActivity.startActivity(new Intent(splashScreenActivity, (Class<?>) MainActivity.class));
                                splashScreenActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            }
                            splashScreenActivity.finish();
                            break;
                        default:
                            int i13 = SplashScreenActivity.O;
                            splashScreenActivity.getClass();
                            if (App.K) {
                                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = splashScreenActivity.getResources().openRawResourceFd(R.raw.flix_sound);
                                FileDescriptor fileDescriptor = assetFileDescriptorOpenRawResourceFd.getFileDescriptor();
                                MediaPlayer mediaPlayer = new MediaPlayer();
                                splashScreenActivity.N = mediaPlayer;
                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: ub.k2
                                    @Override // android.media.MediaPlayer.OnCompletionListener
                                    public final void onCompletion(MediaPlayer mediaPlayer2) {
                                        int i14 = SplashScreenActivity.O;
                                        SplashScreenActivity splashScreenActivity2 = splashScreenActivity;
                                        splashScreenActivity2.getClass();
                                        try {
                                            splashScreenActivity2.N.release();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                });
                                try {
                                    splashScreenActivity.N.setDataSource(fileDescriptor, assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                                    splashScreenActivity.N.setLooping(false);
                                    splashScreenActivity.N.prepare();
                                    splashScreenActivity.N.seekTo(AsyncHttpClient.DEFAULT_RETRY_SLEEP_TIME_MILLIS);
                                    splashScreenActivity.N.setVolume(0.4f, 0.4f);
                                    splashScreenActivity.N.start();
                                    break;
                                } catch (IOException | Exception unused3) {
                                    return;
                                }
                            }
                            break;
                    }
                }
            }, 3500L);
        }
    }
}
