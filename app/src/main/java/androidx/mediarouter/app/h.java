package androidx.mediarouter.app;

import a2.n;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.mediarouter.R;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: MediaRouteControllerDialog.java */
/* loaded from: classes.dex */
public final class h extends androidx.appcompat.app.d {
    public static final int C0;
    public Button A;
    public final AccessibilityManager A0;
    public ImageButton B;
    public final a B0;
    public MediaRouteExpandCollapseButton C;
    public FrameLayout D;
    public LinearLayout E;
    public FrameLayout F;
    public FrameLayout G;
    public ImageView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public final boolean L;
    public final boolean M;
    public LinearLayout N;
    public RelativeLayout O;
    public LinearLayout P;
    public View Q;
    public OverlayListView R;
    public l S;
    public ArrayList T;
    public Set<n.g> U;
    public Set<n.g> V;
    public HashSet W;
    public SeekBar X;
    public k Y;
    public n.g Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f3628a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f3629b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f3630c0;

    /* renamed from: d0, reason: collision with root package name */
    public final int f3631d0;

    /* renamed from: e0, reason: collision with root package name */
    public HashMap f3632e0;

    /* renamed from: f0, reason: collision with root package name */
    public MediaControllerCompat f3633f0;

    /* renamed from: g0, reason: collision with root package name */
    public final i f3634g0;

    /* renamed from: h0, reason: collision with root package name */
    public PlaybackStateCompat f3635h0;

    /* renamed from: i0, reason: collision with root package name */
    public MediaDescriptionCompat f3636i0;

    /* renamed from: j0, reason: collision with root package name */
    public AsyncTaskC0036h f3637j0;

    /* renamed from: k0, reason: collision with root package name */
    public Bitmap f3638k0;

    /* renamed from: l0, reason: collision with root package name */
    public Uri f3639l0;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f3640m0;

    /* renamed from: n0, reason: collision with root package name */
    public Bitmap f3641n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f3642o0;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f3643p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f3644q0;

    /* renamed from: r, reason: collision with root package name */
    public final a2.n f3645r;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f3646r0;

    /* renamed from: s, reason: collision with root package name */
    public final j f3647s;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f3648s0;

    /* renamed from: t, reason: collision with root package name */
    public final n.g f3649t;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f3650t0;

    /* renamed from: u, reason: collision with root package name */
    public final Context f3651u;

    /* renamed from: u0, reason: collision with root package name */
    public int f3652u0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f3653v;

    /* renamed from: v0, reason: collision with root package name */
    public int f3654v0;

    /* renamed from: w, reason: collision with root package name */
    public boolean f3655w;

    /* renamed from: w0, reason: collision with root package name */
    public int f3656w0;

    /* renamed from: x, reason: collision with root package name */
    public int f3657x;

    /* renamed from: x0, reason: collision with root package name */
    public Interpolator f3658x0;

    /* renamed from: y, reason: collision with root package name */
    public View f3659y;

    /* renamed from: y0, reason: collision with root package name */
    public final Interpolator f3660y0;

    /* renamed from: z, reason: collision with root package name */
    public Button f3661z;

    /* renamed from: z0, reason: collision with root package name */
    public final Interpolator f3662z0;

    /* compiled from: MediaRouteControllerDialog.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f(true);
            hVar.R.requestLayout();
            hVar.R.getViewTreeObserver().addOnGlobalLayoutListener(new androidx.mediarouter.app.f(hVar));
        }
    }

    /* compiled from: MediaRouteControllerDialog.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.dismiss();
        }
    }

    /* compiled from: MediaRouteControllerDialog.java */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws PendingIntent.CanceledException {
            PendingIntent sessionActivity;
            h hVar = h.this;
            MediaControllerCompat mediaControllerCompat = hVar.f3633f0;
            if (mediaControllerCompat == null || (sessionActivity = mediaControllerCompat.getSessionActivity()) == null) {
                return;
            }
            try {
                sessionActivity.send();
                hVar.dismiss();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("MediaRouteCtrlDialog", sessionActivity + " was not sent, it had been canceled.");
            }
        }
    }

    /* compiled from: MediaRouteControllerDialog.java */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            boolean z10 = !hVar.f3646r0;
            hVar.f3646r0 = z10;
            if (z10) {
                hVar.R.setVisibility(0);
            }
            hVar.f3658x0 = hVar.f3646r0 ? hVar.f3660y0 : hVar.f3662z0;
            hVar.o(true);
        }
    }

    /* compiled from: MediaRouteControllerDialog.java */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f3667b;

        public f(boolean z10) {
            this.f3667b = z10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i10;
            Bitmap bitmap;
            h hVar = h.this;
            hVar.F.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            if (hVar.f3648s0) {
                hVar.f3650t0 = true;
                return;
            }
            int i11 = hVar.N.getLayoutParams().height;
            h.j(hVar.N, -1);
            hVar.p(hVar.e());
            View decorView = hVar.getWindow().getDecorView();
            decorView.measure(View.MeasureSpec.makeMeasureSpec(hVar.getWindow().getAttributes().width, 1073741824), 0);
            h.j(hVar.N, i11);
            if (hVar.f3659y == null && (hVar.H.getDrawable() instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) hVar.H.getDrawable()).getBitmap()) != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                i10 = width >= height ? (int) (((hVar.f3657x * height) / width) + 0.5f) : (int) (((hVar.f3657x * 9.0f) / 16.0f) + 0.5f);
                hVar.H.setScaleType(bitmap.getWidth() >= bitmap.getHeight() ? ImageView.ScaleType.FIT_XY : ImageView.ScaleType.FIT_CENTER);
            } else {
                i10 = 0;
            }
            int iH = hVar.h(hVar.e());
            int size = hVar.T.size();
            boolean zI = hVar.i();
            n.g gVar = hVar.f3649t;
            int size2 = zI ? gVar.getMemberRoutes().size() * hVar.f3629b0 : 0;
            if (size > 0) {
                size2 += hVar.f3631d0;
            }
            int iMin = Math.min(size2, hVar.f3630c0);
            if (!hVar.f3646r0) {
                iMin = 0;
            }
            int iMax = Math.max(i10, iMin) + iH;
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            int iHeight = rect.height() - (hVar.E.getMeasuredHeight() - hVar.F.getMeasuredHeight());
            if (hVar.f3659y != null || i10 <= 0 || iMax > iHeight) {
                if (hVar.N.getMeasuredHeight() + hVar.R.getLayoutParams().height >= hVar.F.getMeasuredHeight()) {
                    hVar.H.setVisibility(8);
                }
                iMax = iMin + iH;
                i10 = 0;
            } else {
                hVar.H.setVisibility(0);
                h.j(hVar.H, i10);
            }
            if (!hVar.e() || iMax > iHeight) {
                hVar.O.setVisibility(8);
            } else {
                hVar.O.setVisibility(0);
            }
            hVar.p(hVar.O.getVisibility() == 0);
            int iH2 = hVar.h(hVar.O.getVisibility() == 0);
            int iMax2 = Math.max(i10, iMin) + iH2;
            if (iMax2 > iHeight) {
                iMin -= iMax2 - iHeight;
            } else {
                iHeight = iMax2;
            }
            hVar.N.clearAnimation();
            hVar.R.clearAnimation();
            hVar.F.clearAnimation();
            boolean z10 = this.f3667b;
            if (z10) {
                hVar.d(hVar.N, iH2);
                hVar.d(hVar.R, iMin);
                hVar.d(hVar.F, iHeight);
            } else {
                h.j(hVar.N, iH2);
                h.j(hVar.R, iMin);
                h.j(hVar.F, iHeight);
            }
            h.j(hVar.D, rect.height());
            List<n.g> memberRoutes = gVar.getMemberRoutes();
            if (memberRoutes.isEmpty()) {
                hVar.T.clear();
                hVar.S.notifyDataSetChanged();
                return;
            }
            if (n.listUnorderedEquals(hVar.T, memberRoutes)) {
                hVar.S.notifyDataSetChanged();
                return;
            }
            HashMap itemBoundMap = z10 ? n.getItemBoundMap(hVar.R, hVar.S) : null;
            HashMap itemBitmapMap = z10 ? n.getItemBitmapMap(hVar.f3651u, hVar.R, hVar.S) : null;
            hVar.U = n.getItemsAdded(hVar.T, memberRoutes);
            hVar.V = n.getItemsRemoved(hVar.T, memberRoutes);
            hVar.T.addAll(0, hVar.U);
            hVar.T.removeAll(hVar.V);
            hVar.S.notifyDataSetChanged();
            if (z10 && hVar.f3646r0) {
                if (hVar.V.size() + hVar.U.size() > 0) {
                    hVar.R.setEnabled(false);
                    hVar.R.requestLayout();
                    hVar.f3648s0 = true;
                    hVar.R.getViewTreeObserver().addOnGlobalLayoutListener(new androidx.mediarouter.app.j(hVar, itemBoundMap, itemBitmapMap));
                    return;
                }
            }
            hVar.U = null;
            hVar.V = null;
        }
    }

    /* compiled from: MediaRouteControllerDialog.java */
    public final class g implements View.OnClickListener {
        public g() {
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r11) {
            /*
                r10 = this;
                int r11 = r11.getId()
                r0 = 1
                androidx.mediarouter.app.h r1 = androidx.mediarouter.app.h.this
                r2 = 16908313(0x1020019, float:2.38773E-38)
                if (r11 == r2) goto Lc5
                r3 = 16908314(0x102001a, float:2.3877302E-38)
                if (r11 != r3) goto L13
                goto Lc5
            L13:
                int r2 = androidx.mediarouter.R.id.mr_control_playback_ctrl
                if (r11 != r2) goto Lbd
                android.support.v4.media.session.MediaControllerCompat r11 = r1.f3633f0
                if (r11 == 0) goto Ld8
                android.support.v4.media.session.PlaybackStateCompat r11 = r1.f3635h0
                if (r11 == 0) goto Ld8
                int r11 = r11.getState()
                r2 = 3
                r3 = 0
                if (r11 != r2) goto L29
                r11 = 1
                goto L2a
            L29:
                r11 = 0
            L2a:
                r4 = 0
                if (r11 == 0) goto L4c
                android.support.v4.media.session.PlaybackStateCompat r2 = r1.f3635h0
                long r6 = r2.getActions()
                r8 = 514(0x202, double:2.54E-321)
                long r6 = r6 & r8
                int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r2 == 0) goto L3d
                r2 = 1
                goto L3e
            L3d:
                r2 = 0
            L3e:
                if (r2 == 0) goto L4c
                android.support.v4.media.session.MediaControllerCompat r11 = r1.f3633f0
                android.support.v4.media.session.MediaControllerCompat$TransportControls r11 = r11.getTransportControls()
                r11.pause()
                int r3 = androidx.mediarouter.R.string.mr_controller_pause
                goto L8a
            L4c:
                if (r11 == 0) goto L6c
                android.support.v4.media.session.PlaybackStateCompat r2 = r1.f3635h0
                long r6 = r2.getActions()
                r8 = 1
                long r6 = r6 & r8
                int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r2 == 0) goto L5d
                r2 = 1
                goto L5e
            L5d:
                r2 = 0
            L5e:
                if (r2 == 0) goto L6c
                android.support.v4.media.session.MediaControllerCompat r11 = r1.f3633f0
                android.support.v4.media.session.MediaControllerCompat$TransportControls r11 = r11.getTransportControls()
                r11.stop()
                int r3 = androidx.mediarouter.R.string.mr_controller_stop
                goto L8a
            L6c:
                if (r11 != 0) goto L8a
                android.support.v4.media.session.PlaybackStateCompat r11 = r1.f3635h0
                long r6 = r11.getActions()
                r8 = 516(0x204, double:2.55E-321)
                long r6 = r6 & r8
                int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r11 == 0) goto L7c
                goto L7d
            L7c:
                r0 = 0
            L7d:
                if (r0 == 0) goto L8a
                android.support.v4.media.session.MediaControllerCompat r11 = r1.f3633f0
                android.support.v4.media.session.MediaControllerCompat$TransportControls r11 = r11.getTransportControls()
                r11.play()
                int r3 = androidx.mediarouter.R.string.mr_controller_play
            L8a:
                android.view.accessibility.AccessibilityManager r11 = r1.A0
                if (r11 == 0) goto Ld8
                boolean r0 = r11.isEnabled()
                if (r0 == 0) goto Ld8
                if (r3 == 0) goto Ld8
                r0 = 16384(0x4000, float:2.2959E-41)
                android.view.accessibility.AccessibilityEvent r0 = android.view.accessibility.AccessibilityEvent.obtain(r0)
                android.content.Context r1 = r1.f3651u
                java.lang.String r2 = r1.getPackageName()
                r0.setPackageName(r2)
                java.lang.Class<androidx.mediarouter.app.h$g> r2 = androidx.mediarouter.app.h.g.class
                java.lang.String r2 = r2.getName()
                r0.setClassName(r2)
                java.util.List r2 = r0.getText()
                java.lang.String r1 = r1.getString(r3)
                r2.add(r1)
                r11.sendAccessibilityEvent(r0)
                goto Ld8
            Lbd:
                int r0 = androidx.mediarouter.R.id.mr_close
                if (r11 != r0) goto Ld8
                r1.dismiss()
                goto Ld8
            Lc5:
                a2.n$g r3 = r1.f3649t
                boolean r3 = r3.isSelected()
                if (r3 == 0) goto Ld5
                if (r11 != r2) goto Ld0
                r0 = 2
            Ld0:
                a2.n r11 = r1.f3645r
                r11.unselect(r0)
            Ld5:
                r1.dismiss()
            Ld8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.h.g.onClick(android.view.View):void");
        }
    }

    /* compiled from: MediaRouteControllerDialog.java */
    /* renamed from: androidx.mediarouter.app.h$h, reason: collision with other inner class name */
    public class AsyncTaskC0036h extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f3670a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f3671b;

        /* renamed from: c, reason: collision with root package name */
        public int f3672c;

        /* renamed from: d, reason: collision with root package name */
        public long f3673d;

        public AsyncTaskC0036h() {
            MediaDescriptionCompat mediaDescriptionCompat = h.this.f3636i0;
            Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
            if (iconBitmap != null && iconBitmap.isRecycled()) {
                Log.w("MediaRouteCtrlDialog", "Can't fetch the given art bitmap because it's already recycled.");
                iconBitmap = null;
            }
            this.f3670a = iconBitmap;
            MediaDescriptionCompat mediaDescriptionCompat2 = h.this.f3636i0;
            this.f3671b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
        }

        public final BufferedInputStream a(Uri uri) throws IOException {
            InputStream inputStreamOpenInputStream;
            String lowerCase = uri.getScheme().toLowerCase();
            if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
                inputStreamOpenInputStream = h.this.f3651u.getContentResolver().openInputStream(uri);
            } else {
                URLConnection uRLConnectionOpenConnection = new URL(uri.toString()).openConnection();
                int i10 = h.C0;
                uRLConnectionOpenConnection.setConnectTimeout(i10);
                uRLConnectionOpenConnection.setReadTimeout(i10);
                inputStreamOpenInputStream = uRLConnectionOpenConnection.getInputStream();
            }
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            return new BufferedInputStream(inputStreamOpenInputStream);
        }

        public Bitmap getIconBitmap() {
            return this.f3670a;
        }

        public Uri getIconUri() {
            return this.f3671b;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            this.f3673d = SystemClock.uptimeMillis();
            h hVar = h.this;
            hVar.f3640m0 = false;
            hVar.f3641n0 = null;
            hVar.f3642o0 = 0;
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x00a5: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:42:0x00a5 */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00d4  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00e6  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.graphics.Bitmap doInBackground(java.lang.Void... r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 283
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.h.AsyncTaskC0036h.doInBackground(java.lang.Void[]):android.graphics.Bitmap");
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            h hVar = h.this;
            hVar.f3637j0 = null;
            Bitmap bitmap2 = hVar.f3638k0;
            Bitmap bitmap3 = this.f3670a;
            boolean zEquals = w0.c.equals(bitmap2, bitmap3);
            Uri uri = this.f3671b;
            if (zEquals && w0.c.equals(hVar.f3639l0, uri)) {
                return;
            }
            hVar.f3638k0 = bitmap3;
            hVar.f3641n0 = bitmap;
            hVar.f3639l0 = uri;
            hVar.f3642o0 = this.f3672c;
            hVar.f3640m0 = true;
            hVar.l(SystemClock.uptimeMillis() - this.f3673d > 120);
        }
    }

    /* compiled from: MediaRouteControllerDialog.java */
    public final class i extends MediaControllerCompat.Callback {
        public i() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaDescriptionCompat description = mediaMetadataCompat == null ? null : mediaMetadataCompat.getDescription();
            h hVar = h.this;
            hVar.f3636i0 = description;
            hVar.m();
            hVar.l(false);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            h hVar = h.this;
            hVar.f3635h0 = playbackStateCompat;
            hVar.l(false);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionDestroyed() {
            h hVar = h.this;
            MediaControllerCompat mediaControllerCompat = hVar.f3633f0;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.unregisterCallback(hVar.f3634g0);
                hVar.f3633f0 = null;
            }
        }
    }

    /* compiled from: MediaRouteControllerDialog.java */
    public final class j extends n.a {
        public j() {
        }

        @Override // a2.n.a
        public void onRouteChanged(a2.n nVar, n.g gVar) {
            h.this.l(true);
        }

        @Override // a2.n.a
        public void onRouteUnselected(a2.n nVar, n.g gVar) {
            h.this.l(false);
        }

        @Override // a2.n.a
        public void onRouteVolumeChanged(a2.n nVar, n.g gVar) {
            h hVar = h.this;
            SeekBar seekBar = (SeekBar) hVar.f3632e0.get(gVar);
            int volume = gVar.getVolume();
            int i10 = h.C0;
            if (seekBar == null || hVar.Z == gVar) {
                return;
            }
            seekBar.setProgress(volume);
        }
    }

    /* compiled from: MediaRouteControllerDialog.java */
    public class k implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public final a f3677b = new a();

        /* compiled from: MediaRouteControllerDialog.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h hVar = h.this;
                if (hVar.Z != null) {
                    hVar.Z = null;
                    if (hVar.f3643p0) {
                        hVar.l(hVar.f3644q0);
                    }
                }
            }
        }

        public k() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                n.g gVar = (n.g) seekBar.getTag();
                int i11 = h.C0;
                gVar.requestSetVolume(i10);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            h hVar = h.this;
            if (hVar.Z != null) {
                hVar.X.removeCallbacks(this.f3677b);
            }
            hVar.Z = (n.g) seekBar.getTag();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            h.this.X.postDelayed(this.f3677b, 500L);
        }
    }

    /* compiled from: MediaRouteControllerDialog.java */
    public class l extends ArrayAdapter<n.g> {

        /* renamed from: b, reason: collision with root package name */
        public final float f3680b;

        public l(Context context, List<n.g> list) {
            super(context, 0, list);
            this.f3680b = r.d(context);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            h hVar = h.this;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mr_controller_volume_item, viewGroup, false);
            } else {
                hVar.getClass();
                h.j((LinearLayout) view.findViewById(R.id.volume_item_container), hVar.f3629b0);
                View viewFindViewById = view.findViewById(R.id.mr_volume_item_icon);
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                int i11 = hVar.f3628a0;
                layoutParams.width = i11;
                layoutParams.height = i11;
                viewFindViewById.setLayoutParams(layoutParams);
            }
            n.g item = getItem(i10);
            if (item != null) {
                boolean zIsEnabled = item.isEnabled();
                TextView textView = (TextView) view.findViewById(R.id.mr_name);
                textView.setEnabled(zIsEnabled);
                textView.setText(item.getName());
                MediaRouteVolumeSlider mediaRouteVolumeSlider = (MediaRouteVolumeSlider) view.findViewById(R.id.mr_volume_slider);
                r.k(viewGroup.getContext(), mediaRouteVolumeSlider, hVar.R);
                mediaRouteVolumeSlider.setTag(item);
                hVar.f3632e0.put(item, mediaRouteVolumeSlider);
                mediaRouteVolumeSlider.setHideThumb(!zIsEnabled);
                mediaRouteVolumeSlider.setEnabled(zIsEnabled);
                if (zIsEnabled) {
                    if (hVar.L && item.getVolumeHandling() == 1) {
                        mediaRouteVolumeSlider.setMax(item.getVolumeMax());
                        mediaRouteVolumeSlider.setProgress(item.getVolume());
                        mediaRouteVolumeSlider.setOnSeekBarChangeListener(hVar.Y);
                    } else {
                        mediaRouteVolumeSlider.setMax(100);
                        mediaRouteVolumeSlider.setProgress(100);
                        mediaRouteVolumeSlider.setEnabled(false);
                    }
                }
                ((ImageView) view.findViewById(R.id.mr_volume_item_icon)).setAlpha(zIsEnabled ? 255 : (int) (this.f3680b * 255.0f));
                ((LinearLayout) view.findViewById(R.id.volume_item_container)).setVisibility(hVar.W.contains(item) ? 4 : 0);
                Set<n.g> set = hVar.U;
                if (set != null && set.contains(item)) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                    alphaAnimation.setDuration(0L);
                    alphaAnimation.setFillEnabled(true);
                    alphaAnimation.setFillAfter(true);
                    view.clearAnimation();
                    view.startAnimation(alphaAnimation);
                }
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            return false;
        }
    }

    static {
        Log.isLoggable("MediaRouteCtrlDialog", 3);
        C0 = (int) TimeUnit.SECONDS.toMillis(30L);
    }

    public h(Context context) {
        this(context, 0);
    }

    public static void j(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    public final void d(ViewGroup viewGroup, int i10) {
        androidx.mediarouter.app.i iVar = new androidx.mediarouter.app.i(viewGroup.getLayoutParams().height, i10, viewGroup);
        iVar.setDuration(this.f3652u0);
        iVar.setInterpolator(this.f3658x0);
        viewGroup.startAnimation(iVar);
    }

    public final boolean e() {
        return this.f3659y == null && !(this.f3636i0 == null && this.f3635h0 == null);
    }

    public final void f(boolean z10) {
        Set<n.g> set;
        int firstVisiblePosition = this.R.getFirstVisiblePosition();
        for (int i10 = 0; i10 < this.R.getChildCount(); i10++) {
            View childAt = this.R.getChildAt(i10);
            n.g item = this.S.getItem(firstVisiblePosition + i10);
            if (!z10 || (set = this.U) == null || !set.contains(item)) {
                ((LinearLayout) childAt.findViewById(R.id.volume_item_container)).setVisibility(0);
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
                alphaAnimation.setDuration(0L);
                animationSet.addAnimation(alphaAnimation);
                new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f).setDuration(0L);
                animationSet.setFillAfter(true);
                animationSet.setFillEnabled(true);
                childAt.clearAnimation();
                childAt.startAnimation(animationSet);
            }
        }
        this.R.stopAnimationAll();
        if (z10) {
            return;
        }
        g(false);
    }

    public final void g(boolean z10) {
        this.U = null;
        this.V = null;
        this.f3648s0 = false;
        if (this.f3650t0) {
            this.f3650t0 = false;
            o(z10);
        }
        this.R.setEnabled(true);
    }

    public final int h(boolean z10) {
        if (!z10 && this.P.getVisibility() != 0) {
            return 0;
        }
        int paddingBottom = this.N.getPaddingBottom() + this.N.getPaddingTop() + 0;
        if (z10) {
            paddingBottom += this.O.getMeasuredHeight();
        }
        int measuredHeight = this.P.getVisibility() == 0 ? this.P.getMeasuredHeight() + paddingBottom : paddingBottom;
        return (z10 && this.P.getVisibility() == 0) ? measuredHeight + this.Q.getMeasuredHeight() : measuredHeight;
    }

    public final boolean i() {
        n.g gVar = this.f3649t;
        return gVar.isGroup() && gVar.getMemberRoutes().size() > 1;
    }

    public final void k(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.f3633f0;
        i iVar = this.f3634g0;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(iVar);
            this.f3633f0 = null;
        }
        if (token != null && this.f3655w) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.f3651u, token);
            this.f3633f0 = mediaControllerCompat2;
            mediaControllerCompat2.registerCallback(iVar);
            MediaMetadataCompat metadata = this.f3633f0.getMetadata();
            this.f3636i0 = metadata != null ? metadata.getDescription() : null;
            this.f3635h0 = this.f3633f0.getPlaybackState();
            m();
            l(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l(boolean r13) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.h.l(boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m() {
        /*
            r6 = this;
            android.view.View r0 = r6.f3659y
            if (r0 != 0) goto L6a
            android.support.v4.media.MediaDescriptionCompat r0 = r6.f3636i0
            r1 = 0
            if (r0 != 0) goto Lb
            r0 = r1
            goto Lf
        Lb:
            android.graphics.Bitmap r0 = r0.getIconBitmap()
        Lf:
            android.support.v4.media.MediaDescriptionCompat r2 = r6.f3636i0
            if (r2 != 0) goto L14
            goto L18
        L14:
            android.net.Uri r1 = r2.getIconUri()
        L18:
            androidx.mediarouter.app.h$h r2 = r6.f3637j0
            if (r2 != 0) goto L1f
            android.graphics.Bitmap r2 = r6.f3638k0
            goto L23
        L1f:
            android.graphics.Bitmap r2 = r2.getIconBitmap()
        L23:
            androidx.mediarouter.app.h$h r3 = r6.f3637j0
            if (r3 != 0) goto L2a
            android.net.Uri r3 = r6.f3639l0
            goto L2e
        L2a:
            android.net.Uri r3 = r3.getIconUri()
        L2e:
            r4 = 0
            r5 = 1
            if (r2 == r0) goto L34
        L32:
            r0 = 1
            goto L4a
        L34:
            if (r2 != 0) goto L49
            if (r3 == 0) goto L3f
            boolean r0 = r3.equals(r1)
            if (r0 == 0) goto L3f
            goto L43
        L3f:
            if (r3 != 0) goto L45
            if (r1 != 0) goto L45
        L43:
            r0 = 1
            goto L46
        L45:
            r0 = 0
        L46:
            if (r0 != 0) goto L49
            goto L32
        L49:
            r0 = 0
        L4a:
            if (r0 == 0) goto L6a
            boolean r0 = r6.i()
            if (r0 == 0) goto L57
            boolean r0 = r6.M
            if (r0 != 0) goto L57
            goto L6a
        L57:
            androidx.mediarouter.app.h$h r0 = r6.f3637j0
            if (r0 == 0) goto L5e
            r0.cancel(r5)
        L5e:
            androidx.mediarouter.app.h$h r0 = new androidx.mediarouter.app.h$h
            r0.<init>()
            r6.f3637j0 = r0
            java.lang.Void[] r1 = new java.lang.Void[r4]
            r0.execute(r1)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.h.m():void");
    }

    public final void n() throws Resources.NotFoundException {
        Context context = this.f3651u;
        int dialogWidth = n.getDialogWidth(context);
        getWindow().setLayout(dialogWidth, -2);
        View decorView = getWindow().getDecorView();
        this.f3657x = (dialogWidth - decorView.getPaddingLeft()) - decorView.getPaddingRight();
        Resources resources = context.getResources();
        this.f3628a0 = resources.getDimensionPixelSize(R.dimen.mr_controller_volume_group_list_item_icon_size);
        this.f3629b0 = resources.getDimensionPixelSize(R.dimen.mr_controller_volume_group_list_item_height);
        this.f3630c0 = resources.getDimensionPixelSize(R.dimen.mr_controller_volume_group_list_max_height);
        this.f3638k0 = null;
        this.f3639l0 = null;
        m();
        l(false);
    }

    public final void o(boolean z10) {
        this.F.requestLayout();
        this.F.getViewTreeObserver().addOnGlobalLayoutListener(new f(z10));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3655w = true;
        a2.m mVar = a2.m.f182c;
        j jVar = this.f3647s;
        a2.n nVar = this.f3645r;
        nVar.addCallback(mVar, jVar, 2);
        k(nVar.getMediaSessionToken());
    }

    @Override // androidx.appcompat.app.d, r.u, androidx.activity.h, android.app.Dialog
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.mr_controller_material_dialog_b);
        findViewById(android.R.id.button3).setVisibility(8);
        g gVar = new g();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mr_expandable_area);
        this.D = frameLayout;
        frameLayout.setOnClickListener(new b());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mr_dialog_area);
        this.E = linearLayout;
        linearLayout.setOnClickListener(new c());
        int i10 = androidx.appcompat.R.attr.colorPrimary;
        Context context = this.f3651u;
        int iG = r.g(context, 0, i10);
        if (o0.a.calculateContrast(iG, r.g(context, 0, android.R.attr.colorBackground)) < 3.0d) {
            iG = r.g(context, 0, androidx.appcompat.R.attr.colorAccent);
        }
        Button button = (Button) findViewById(android.R.id.button2);
        this.f3661z = button;
        button.setText(R.string.mr_controller_disconnect);
        this.f3661z.setTextColor(iG);
        this.f3661z.setOnClickListener(gVar);
        Button button2 = (Button) findViewById(android.R.id.button1);
        this.A = button2;
        button2.setText(R.string.mr_controller_stop_casting);
        this.A.setTextColor(iG);
        this.A.setOnClickListener(gVar);
        this.K = (TextView) findViewById(R.id.mr_name);
        ((ImageButton) findViewById(R.id.mr_close)).setOnClickListener(gVar);
        this.G = (FrameLayout) findViewById(R.id.mr_custom_control);
        this.F = (FrameLayout) findViewById(R.id.mr_default_control);
        d dVar = new d();
        ImageView imageView = (ImageView) findViewById(R.id.mr_art);
        this.H = imageView;
        imageView.setOnClickListener(dVar);
        findViewById(R.id.mr_control_title_container).setOnClickListener(dVar);
        this.N = (LinearLayout) findViewById(R.id.mr_media_main_control);
        this.Q = findViewById(R.id.mr_control_divider);
        this.O = (RelativeLayout) findViewById(R.id.mr_playback_control);
        this.I = (TextView) findViewById(R.id.mr_control_title);
        this.J = (TextView) findViewById(R.id.mr_control_subtitle);
        ImageButton imageButton = (ImageButton) findViewById(R.id.mr_control_playback_ctrl);
        this.B = imageButton;
        imageButton.setOnClickListener(gVar);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.mr_volume_control);
        this.P = linearLayout2;
        linearLayout2.setVisibility(8);
        SeekBar seekBar = (SeekBar) findViewById(R.id.mr_volume_slider);
        this.X = seekBar;
        n.g gVar2 = this.f3649t;
        seekBar.setTag(gVar2);
        k kVar = new k();
        this.Y = kVar;
        this.X.setOnSeekBarChangeListener(kVar);
        this.R = (OverlayListView) findViewById(R.id.mr_volume_group_list);
        this.T = new ArrayList();
        l lVar = new l(this.R.getContext(), this.T);
        this.S = lVar;
        this.R.setAdapter((ListAdapter) lVar);
        this.W = new HashSet();
        LinearLayout linearLayout3 = this.N;
        OverlayListView overlayListView = this.R;
        boolean zI = i();
        int iG2 = r.g(context, 0, i10);
        int iG3 = r.g(context, 0, androidx.appcompat.R.attr.colorPrimaryDark);
        if (zI && r.c(context, 0) == -570425344) {
            iG3 = iG2;
            iG2 = -1;
        }
        linearLayout3.setBackgroundColor(iG2);
        overlayListView.setBackgroundColor(iG3);
        linearLayout3.setTag(Integer.valueOf(iG2));
        overlayListView.setTag(Integer.valueOf(iG3));
        r.k(context, (MediaRouteVolumeSlider) this.X, this.N);
        HashMap map = new HashMap();
        this.f3632e0 = map;
        map.put(gVar2, this.X);
        MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = (MediaRouteExpandCollapseButton) findViewById(R.id.mr_group_expand_collapse);
        this.C = mediaRouteExpandCollapseButton;
        mediaRouteExpandCollapseButton.setOnClickListener(new e());
        this.f3658x0 = this.f3646r0 ? this.f3660y0 : this.f3662z0;
        this.f3652u0 = context.getResources().getInteger(R.integer.mr_controller_volume_group_list_animation_duration_ms);
        this.f3654v0 = context.getResources().getInteger(R.integer.mr_controller_volume_group_list_fade_in_duration_ms);
        this.f3656w0 = context.getResources().getInteger(R.integer.mr_controller_volume_group_list_fade_out_duration_ms);
        View viewOnCreateMediaControlView = onCreateMediaControlView(bundle);
        this.f3659y = viewOnCreateMediaControlView;
        if (viewOnCreateMediaControlView != null) {
            this.G.addView(viewOnCreateMediaControlView);
            this.G.setVisibility(0);
        }
        this.f3653v = true;
        n();
    }

    public View onCreateMediaControlView(Bundle bundle) {
        return null;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f3645r.removeCallback(this.f3647s);
        k(null);
        this.f3655w = false;
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.app.d, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 25 && i10 != 24) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (this.M || !this.f3646r0) {
            this.f3649t.requestUpdateVolume(i10 == 25 ? -1 : 1);
        }
        return true;
    }

    @Override // androidx.appcompat.app.d, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 == 25 || i10 == 24) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public final void p(boolean z10) {
        int i10 = 0;
        this.Q.setVisibility((this.P.getVisibility() == 0 && z10) ? 0 : 8);
        LinearLayout linearLayout = this.N;
        if (this.P.getVisibility() == 8 && !z10) {
            i10 = 8;
        }
        linearLayout.setVisibility(i10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public h(Context context, int i10) {
        ContextThemeWrapper contextThemeWrapperA = r.a(context, i10, true);
        super(contextThemeWrapperA, r.b(contextThemeWrapperA));
        this.L = true;
        this.B0 = new a();
        Context context2 = getContext();
        this.f3651u = context2;
        this.f3634g0 = new i();
        a2.n nVar = a2.n.getInstance(context2);
        this.f3645r = nVar;
        this.M = a2.n.isGroupVolumeUxEnabled();
        this.f3647s = new j();
        this.f3649t = nVar.getSelectedRoute();
        k(nVar.getMediaSessionToken());
        this.f3631d0 = context2.getResources().getDimensionPixelSize(R.dimen.mr_controller_volume_group_list_padding_top);
        this.A0 = (AccessibilityManager) context2.getSystemService("accessibility");
        this.f3660y0 = AnimationUtils.loadInterpolator(contextThemeWrapperA, R.interpolator.mr_linear_out_slow_in);
        this.f3662z0 = AnimationUtils.loadInterpolator(contextThemeWrapperA, R.interpolator.mr_fast_out_slow_in);
        new AccelerateDecelerateInterpolator();
    }

    /* compiled from: MediaRouteControllerDialog.java */
    public class c implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
