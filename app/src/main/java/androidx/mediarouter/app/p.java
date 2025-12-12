package androidx.mediarouter.app;

import a2.i;
import a2.n;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.mediarouter.R;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import r.u;

/* compiled from: MediaRouteDynamicControllerDialog.java */
/* loaded from: classes.dex */
public final class p extends u {

    /* renamed from: e0, reason: collision with root package name */
    public static final /* synthetic */ int f3724e0 = 0;
    public boolean A;
    public long B;
    public final a C;
    public RecyclerView D;
    public h E;
    public j F;
    public HashMap G;
    public n.g H;
    public HashMap I;
    public boolean J;
    public boolean K;
    public boolean L;
    public ImageButton M;
    public Button N;
    public ImageView O;
    public View P;
    public ImageView Q;
    public TextView R;
    public TextView S;
    public String T;
    public MediaControllerCompat U;
    public final e V;
    public MediaDescriptionCompat W;
    public d X;
    public Bitmap Y;
    public Uri Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f3725a0;

    /* renamed from: b0, reason: collision with root package name */
    public Bitmap f3726b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f3727c0;

    /* renamed from: d0, reason: collision with root package name */
    public final boolean f3728d0;

    /* renamed from: q, reason: collision with root package name */
    public final a2.n f3729q;

    /* renamed from: r, reason: collision with root package name */
    public final g f3730r;

    /* renamed from: s, reason: collision with root package name */
    public a2.m f3731s;

    /* renamed from: t, reason: collision with root package name */
    public n.g f3732t;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f3733u;

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f3734v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f3735w;

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList f3736x;

    /* renamed from: y, reason: collision with root package name */
    public final Context f3737y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f3738z;

    /* compiled from: MediaRouteDynamicControllerDialog.java */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            p pVar = p.this;
            if (i10 == 1) {
                pVar.h();
            } else if (i10 == 2 && pVar.H != null) {
                pVar.H = null;
                pVar.i();
            }
        }
    }

    /* compiled from: MediaRouteDynamicControllerDialog.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p.this.dismiss();
        }
    }

    /* compiled from: MediaRouteDynamicControllerDialog.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p pVar = p.this;
            if (pVar.f3732t.isSelected()) {
                pVar.f3729q.unselect(2);
            }
            pVar.dismiss();
        }
    }

    /* compiled from: MediaRouteDynamicControllerDialog.java */
    public class d extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f3742a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f3743b;

        /* renamed from: c, reason: collision with root package name */
        public int f3744c;

        public d() {
            MediaDescriptionCompat mediaDescriptionCompat = p.this.W;
            Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
            if (iconBitmap != null && iconBitmap.isRecycled()) {
                Log.w("MediaRouteCtrlDialog", "Can't fetch the given art bitmap because it's already recycled.");
                iconBitmap = null;
            }
            this.f3742a = iconBitmap;
            MediaDescriptionCompat mediaDescriptionCompat2 = p.this.W;
            this.f3743b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
        }

        public final BufferedInputStream a(Uri uri) throws IOException {
            InputStream inputStreamOpenInputStream;
            String lowerCase = uri.getScheme().toLowerCase();
            if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
                inputStreamOpenInputStream = p.this.f3737y.getContentResolver().openInputStream(uri);
            } else {
                URLConnection uRLConnectionOpenConnection = new URL(uri.toString()).openConnection();
                uRLConnectionOpenConnection.setConnectTimeout(30000);
                uRLConnectionOpenConnection.setReadTimeout(30000);
                inputStreamOpenInputStream = uRLConnectionOpenConnection.getInputStream();
            }
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            return new BufferedInputStream(inputStreamOpenInputStream);
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            p pVar = p.this;
            pVar.f3725a0 = false;
            pVar.f3726b0 = null;
            pVar.f3727c0 = 0;
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0095: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:36:0x0095 */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00d8  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.graphics.Bitmap doInBackground(java.lang.Void... r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 269
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.p.d.doInBackground(java.lang.Void[]):android.graphics.Bitmap");
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            p pVar = p.this;
            pVar.X = null;
            Bitmap bitmap2 = pVar.Y;
            Bitmap bitmap3 = this.f3742a;
            boolean zEquals = w0.c.equals(bitmap2, bitmap3);
            Uri uri = this.f3743b;
            if (zEquals && w0.c.equals(pVar.Z, uri)) {
                return;
            }
            pVar.Y = bitmap3;
            pVar.f3726b0 = bitmap;
            pVar.Z = uri;
            pVar.f3727c0 = this.f3744c;
            pVar.f3725a0 = true;
            pVar.f();
        }
    }

    /* compiled from: MediaRouteDynamicControllerDialog.java */
    public final class e extends MediaControllerCompat.Callback {
        public e() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaDescriptionCompat description = mediaMetadataCompat == null ? null : mediaMetadataCompat.getDescription();
            p pVar = p.this;
            pVar.W = description;
            pVar.c();
            pVar.f();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionDestroyed() {
            p pVar = p.this;
            MediaControllerCompat mediaControllerCompat = pVar.U;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.unregisterCallback(pVar.V);
                pVar.U = null;
            }
        }
    }

    /* compiled from: MediaRouteDynamicControllerDialog.java */
    public abstract class f extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public n.g f3747u;

        /* renamed from: v, reason: collision with root package name */
        public final ImageButton f3748v;

        /* renamed from: w, reason: collision with root package name */
        public final MediaRouteVolumeSlider f3749w;

        /* compiled from: MediaRouteDynamicControllerDialog.java */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f fVar = f.this;
                p pVar = p.this;
                if (pVar.H != null) {
                    pVar.C.removeMessages(2);
                }
                n.g gVar = fVar.f3747u;
                p pVar2 = p.this;
                pVar2.H = gVar;
                int iMax = 1;
                boolean z10 = !view.isActivated();
                if (z10) {
                    iMax = 0;
                } else {
                    Integer num = (Integer) pVar2.I.get(fVar.f3747u.getId());
                    if (num != null) {
                        iMax = Math.max(1, num.intValue());
                    }
                }
                fVar.o(z10);
                fVar.f3749w.setProgress(iMax);
                fVar.f3747u.requestSetVolume(iMax);
                pVar2.C.sendEmptyMessageDelayed(2, 500L);
            }
        }

        public f(View view, ImageButton imageButton, MediaRouteVolumeSlider mediaRouteVolumeSlider) {
            int color;
            int color2;
            super(view);
            this.f3748v = imageButton;
            this.f3749w = mediaRouteVolumeSlider;
            Context context = p.this.f3737y;
            int i10 = R.drawable.mr_cast_mute_button;
            int i11 = r.f3784a;
            Drawable drawableWrap = p0.a.wrap(s.a.getDrawable(context, i10));
            if (r.i(context)) {
                p0.a.setTint(drawableWrap, m0.a.getColor(context, r.f3784a));
            }
            imageButton.setImageDrawable(drawableWrap);
            Context context2 = p.this.f3737y;
            if (r.i(context2)) {
                color = m0.a.getColor(context2, R.color.mr_cast_progressbar_progress_and_thumb_light);
                color2 = m0.a.getColor(context2, R.color.mr_cast_progressbar_background_light);
            } else {
                color = m0.a.getColor(context2, R.color.mr_cast_progressbar_progress_and_thumb_dark);
                color2 = m0.a.getColor(context2, R.color.mr_cast_progressbar_background_dark);
            }
            mediaRouteVolumeSlider.setColor(color, color2);
        }

        public final void n(n.g gVar) {
            this.f3747u = gVar;
            int volume = gVar.getVolume();
            boolean z10 = volume == 0;
            ImageButton imageButton = this.f3748v;
            imageButton.setActivated(z10);
            imageButton.setOnClickListener(new a());
            n.g gVar2 = this.f3747u;
            MediaRouteVolumeSlider mediaRouteVolumeSlider = this.f3749w;
            mediaRouteVolumeSlider.setTag(gVar2);
            mediaRouteVolumeSlider.setMax(gVar.getVolumeMax());
            mediaRouteVolumeSlider.setProgress(volume);
            mediaRouteVolumeSlider.setOnSeekBarChangeListener(p.this.F);
        }

        public final void o(boolean z10) {
            ImageButton imageButton = this.f3748v;
            if (imageButton.isActivated() == z10) {
                return;
            }
            imageButton.setActivated(z10);
            p pVar = p.this;
            if (z10) {
                pVar.I.put(this.f3747u.getId(), Integer.valueOf(this.f3749w.getProgress()));
            } else {
                pVar.I.remove(this.f3747u.getId());
            }
        }
    }

    /* compiled from: MediaRouteDynamicControllerDialog.java */
    public final class g extends n.a {
        public g() {
        }

        @Override // a2.n.a
        public void onRouteAdded(a2.n nVar, n.g gVar) {
            p.this.h();
        }

        @Override // a2.n.a
        public void onRouteChanged(a2.n nVar, n.g gVar) {
            boolean z10;
            n.g.a dynamicGroupState;
            p pVar = p.this;
            if (gVar != pVar.f3732t || gVar.getDynamicGroupController() == null) {
                z10 = false;
            } else {
                for (n.g gVar2 : gVar.getProvider().getRoutes()) {
                    if (!pVar.f3732t.getMemberRoutes().contains(gVar2) && (dynamicGroupState = pVar.f3732t.getDynamicGroupState(gVar2)) != null && dynamicGroupState.isGroupable() && !pVar.f3734v.contains(gVar2)) {
                        z10 = true;
                        break;
                    }
                }
                z10 = false;
            }
            if (!z10) {
                pVar.h();
            } else {
                pVar.i();
                pVar.g();
            }
        }

        @Override // a2.n.a
        public void onRouteRemoved(a2.n nVar, n.g gVar) {
            p.this.h();
        }

        @Override // a2.n.a
        public void onRouteSelected(a2.n nVar, n.g gVar) {
            p pVar = p.this;
            pVar.f3732t = gVar;
            pVar.i();
            pVar.g();
        }

        @Override // a2.n.a
        public void onRouteUnselected(a2.n nVar, n.g gVar) {
            p.this.h();
        }

        @Override // a2.n.a
        public void onRouteVolumeChanged(a2.n nVar, n.g gVar) {
            f fVar;
            gVar.getVolume();
            int i10 = p.f3724e0;
            p pVar = p.this;
            if (pVar.H == gVar || (fVar = (f) pVar.G.get(gVar.getId())) == null) {
                return;
            }
            int volume = fVar.f3747u.getVolume();
            fVar.o(volume == 0);
            fVar.f3749w.setProgress(volume);
        }
    }

    /* compiled from: MediaRouteDynamicControllerDialog.java */
    public static final class i implements Comparator<n.g> {

        /* renamed from: b, reason: collision with root package name */
        public static final i f3781b = new i();

        @Override // java.util.Comparator
        public int compare(n.g gVar, n.g gVar2) {
            return gVar.getName().compareToIgnoreCase(gVar2.getName());
        }
    }

    /* compiled from: MediaRouteDynamicControllerDialog.java */
    public class j implements SeekBar.OnSeekBarChangeListener {
        public j() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                n.g gVar = (n.g) seekBar.getTag();
                f fVar = (f) p.this.G.get(gVar.getId());
                if (fVar != null) {
                    fVar.o(i10 == 0);
                }
                gVar.requestSetVolume(i10);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            p pVar = p.this;
            if (pVar.H != null) {
                pVar.C.removeMessages(2);
            }
            pVar.H = (n.g) seekBar.getTag();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            p.this.C.sendEmptyMessageDelayed(2, 500L);
        }
    }

    static {
        Log.isLoggable("MediaRouteCtrlDialog", 3);
    }

    public p(Context context) {
        this(context, 0);
    }

    public final void c() {
        MediaDescriptionCompat mediaDescriptionCompat = this.W;
        Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
        MediaDescriptionCompat mediaDescriptionCompat2 = this.W;
        Uri iconUri = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
        d dVar = this.X;
        Bitmap bitmap = dVar == null ? this.Y : dVar.f3742a;
        Uri uri = dVar == null ? this.Z : dVar.f3743b;
        if (bitmap != iconBitmap || (bitmap == null && !w0.c.equals(uri, iconUri))) {
            d dVar2 = this.X;
            if (dVar2 != null) {
                dVar2.cancel(true);
            }
            d dVar3 = new d();
            this.X = dVar3;
            dVar3.execute(new Void[0]);
        }
    }

    public final void d(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.U;
        e eVar = this.V;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(eVar);
            this.U = null;
        }
        if (token != null && this.A) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.f3737y, token);
            this.U = mediaControllerCompat2;
            mediaControllerCompat2.registerCallback(eVar);
            MediaMetadataCompat metadata = this.U.getMetadata();
            this.W = metadata != null ? metadata.getDescription() : null;
            c();
            f();
        }
    }

    public final void e() {
        Context context = this.f3737y;
        getWindow().setLayout(n.getDialogWidthForDynamicGroup(context), n.getDialogHeight(context));
        this.Y = null;
        this.Z = null;
        c();
        f();
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.p.f():void");
    }

    public final void g() {
        ArrayList arrayList = this.f3733u;
        arrayList.clear();
        ArrayList arrayList2 = this.f3734v;
        arrayList2.clear();
        ArrayList arrayList3 = this.f3735w;
        arrayList3.clear();
        arrayList.addAll(this.f3732t.getMemberRoutes());
        for (n.g gVar : this.f3732t.getProvider().getRoutes()) {
            n.g.a dynamicGroupState = this.f3732t.getDynamicGroupState(gVar);
            if (dynamicGroupState != null) {
                if (dynamicGroupState.isGroupable()) {
                    arrayList2.add(gVar);
                }
                if (dynamicGroupState.isTransferable()) {
                    arrayList3.add(gVar);
                }
            }
        }
        onFilterRoutes(arrayList2);
        onFilterRoutes(arrayList3);
        i iVar = i.f3781b;
        Collections.sort(arrayList, iVar);
        Collections.sort(arrayList2, iVar);
        Collections.sort(arrayList3, iVar);
        this.E.d();
    }

    public final void h() {
        if (this.A) {
            if (SystemClock.uptimeMillis() - this.B < 300) {
                a aVar = this.C;
                aVar.removeMessages(1);
                aVar.sendEmptyMessageAtTime(1, this.B + 300);
                return;
            }
            if ((this.H != null || this.J) ? true : !this.f3738z) {
                this.K = true;
                return;
            }
            this.K = false;
            if (!this.f3732t.isSelected() || this.f3732t.isDefaultOrBluetooth()) {
                dismiss();
            }
            this.B = SystemClock.uptimeMillis();
            this.E.c();
        }
    }

    public final void i() {
        if (this.K) {
            h();
        }
        if (this.L) {
            f();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A = true;
        a2.m mVar = this.f3731s;
        g gVar = this.f3730r;
        a2.n nVar = this.f3729q;
        nVar.addCallback(mVar, gVar, 1);
        g();
        d(nVar.getMediaSessionToken());
    }

    @Override // r.u, androidx.activity.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mr_cast_dialog);
        int i10 = r.f3784a;
        View decorView = getWindow().getDecorView();
        Context context = this.f3737y;
        decorView.setBackgroundColor(m0.a.getColor(context, r.i(context) ? R.color.mr_dynamic_dialog_background_light : R.color.mr_dynamic_dialog_background_dark));
        ImageButton imageButton = (ImageButton) findViewById(R.id.mr_cast_close_button);
        this.M = imageButton;
        imageButton.setColorFilter(-1);
        this.M.setOnClickListener(new b());
        Button button = (Button) findViewById(R.id.mr_cast_stop_button);
        this.N = button;
        button.setTextColor(-1);
        this.N.setOnClickListener(new c());
        this.E = new h();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mr_cast_list);
        this.D = recyclerView;
        recyclerView.setAdapter(this.E);
        this.D.setLayoutManager(new LinearLayoutManager(context));
        this.F = new j();
        this.G = new HashMap();
        this.I = new HashMap();
        this.O = (ImageView) findViewById(R.id.mr_cast_meta_background);
        this.P = findViewById(R.id.mr_cast_meta_black_scrim);
        this.Q = (ImageView) findViewById(R.id.mr_cast_meta_art);
        TextView textView = (TextView) findViewById(R.id.mr_cast_meta_title);
        this.R = textView;
        textView.setTextColor(-1);
        TextView textView2 = (TextView) findViewById(R.id.mr_cast_meta_subtitle);
        this.S = textView2;
        textView2.setTextColor(-1);
        this.T = context.getResources().getString(R.string.mr_cast_dialog_title_view_placeholder);
        this.f3738z = true;
        e();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A = false;
        this.f3729q.removeCallback(this.f3730r);
        this.C.removeCallbacksAndMessages(null);
        d(null);
    }

    public boolean onFilterRoute(n.g gVar) {
        return !gVar.isDefaultOrBluetooth() && gVar.isEnabled() && gVar.matchesSelector(this.f3731s) && this.f3732t != gVar;
    }

    public void onFilterRoutes(List<n.g> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (!onFilterRoute(list.get(size))) {
                list.remove(size);
            }
        }
    }

    public void setRouteSelector(a2.m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f3731s.equals(mVar)) {
            return;
        }
        this.f3731s = mVar;
        if (this.A) {
            a2.n nVar = this.f3729q;
            g gVar = this.f3730r;
            nVar.removeCallback(gVar);
            nVar.addCallback(mVar, gVar, 1);
            g();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public p(Context context, int i10) {
        ContextThemeWrapper contextThemeWrapperA = r.a(context, i10, false);
        super(contextThemeWrapperA, r.b(contextThemeWrapperA));
        this.f3731s = a2.m.f182c;
        this.f3733u = new ArrayList();
        this.f3734v = new ArrayList();
        this.f3735w = new ArrayList();
        this.f3736x = new ArrayList();
        this.C = new a();
        Context context2 = getContext();
        this.f3737y = context2;
        a2.n nVar = a2.n.getInstance(context2);
        this.f3729q = nVar;
        this.f3728d0 = a2.n.isGroupVolumeUxEnabled();
        this.f3730r = new g();
        this.f3732t = nVar.getSelectedRoute();
        this.V = new e();
        d(nVar.getMediaSessionToken());
    }

    /* compiled from: MediaRouteDynamicControllerDialog.java */
    public final class h extends RecyclerView.Adapter<RecyclerView.z> {

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList<f> f3753d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        public final LayoutInflater f3754e;

        /* renamed from: f, reason: collision with root package name */
        public final Drawable f3755f;

        /* renamed from: g, reason: collision with root package name */
        public final Drawable f3756g;

        /* renamed from: h, reason: collision with root package name */
        public final Drawable f3757h;

        /* renamed from: i, reason: collision with root package name */
        public final Drawable f3758i;

        /* renamed from: j, reason: collision with root package name */
        public f f3759j;

        /* renamed from: k, reason: collision with root package name */
        public final int f3760k;

        /* renamed from: l, reason: collision with root package name */
        public final AccelerateDecelerateInterpolator f3761l;

        /* compiled from: MediaRouteDynamicControllerDialog.java */
        public class a extends Animation {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f3763b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ int f3764m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ View f3765n;

            public a(int i10, int i11, View view) {
                this.f3763b = i10;
                this.f3764m = i11;
                this.f3765n = view;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f10, Transformation transformation) {
                int i10 = this.f3763b;
                int i11 = this.f3764m + ((int) ((i10 - r0) * f10));
                int i12 = p.f3724e0;
                View view = this.f3765n;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = i11;
                view.setLayoutParams(layoutParams);
            }
        }

        /* compiled from: MediaRouteDynamicControllerDialog.java */
        public class c extends RecyclerView.z {

            /* renamed from: u, reason: collision with root package name */
            public final View f3767u;

            /* renamed from: v, reason: collision with root package name */
            public final ImageView f3768v;

            /* renamed from: w, reason: collision with root package name */
            public final ProgressBar f3769w;

            /* renamed from: x, reason: collision with root package name */
            public final TextView f3770x;

            /* renamed from: y, reason: collision with root package name */
            public final float f3771y;

            /* renamed from: z, reason: collision with root package name */
            public n.g f3772z;

            public c(View view) {
                super(view);
                this.f3767u = view;
                this.f3768v = (ImageView) view.findViewById(R.id.mr_cast_group_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.mr_cast_group_progress_bar);
                this.f3769w = progressBar;
                this.f3770x = (TextView) view.findViewById(R.id.mr_cast_group_name);
                this.f3771y = r.d(p.this.f3737y);
                r.j(p.this.f3737y, progressBar);
            }
        }

        /* compiled from: MediaRouteDynamicControllerDialog.java */
        public class d extends f {

            /* renamed from: y, reason: collision with root package name */
            public final TextView f3773y;

            /* renamed from: z, reason: collision with root package name */
            public final int f3774z;

            public d(View view) throws Resources.NotFoundException {
                super(view, (ImageButton) view.findViewById(R.id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(R.id.mr_cast_volume_slider));
                this.f3773y = (TextView) view.findViewById(R.id.mr_group_volume_route_name);
                Resources resources = p.this.f3737y.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(R.dimen.mr_dynamic_volume_group_list_item_height, typedValue, true);
                this.f3774z = (int) typedValue.getDimension(displayMetrics);
            }
        }

        /* compiled from: MediaRouteDynamicControllerDialog.java */
        public class e extends RecyclerView.z {

            /* renamed from: u, reason: collision with root package name */
            public final TextView f3775u;

            public e(View view) {
                super(view);
                this.f3775u = (TextView) view.findViewById(R.id.mr_cast_header_name);
            }
        }

        /* compiled from: MediaRouteDynamicControllerDialog.java */
        public class f {

            /* renamed from: a, reason: collision with root package name */
            public final Object f3776a;

            /* renamed from: b, reason: collision with root package name */
            public final int f3777b;

            public f(Object obj, int i10) {
                this.f3776a = obj;
                this.f3777b = i10;
            }

            public Object getData() {
                return this.f3776a;
            }

            public int getType() {
                return this.f3777b;
            }
        }

        /* compiled from: MediaRouteDynamicControllerDialog.java */
        public class g extends f {
            public final ProgressBar A;
            public final TextView B;
            public final RelativeLayout C;
            public final CheckBox D;
            public final float E;
            public final int F;
            public final a G;

            /* renamed from: y, reason: collision with root package name */
            public final View f3778y;

            /* renamed from: z, reason: collision with root package name */
            public final ImageView f3779z;

            /* compiled from: MediaRouteDynamicControllerDialog.java */
            public class a implements View.OnClickListener {
                public a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g gVar = g.this;
                    boolean z10 = !gVar.p(gVar.f3747u);
                    boolean zIsGroup = gVar.f3747u.isGroup();
                    h hVar = h.this;
                    if (z10) {
                        p.this.f3729q.addMemberToDynamicGroup(gVar.f3747u);
                    } else {
                        p.this.f3729q.removeMemberFromDynamicGroup(gVar.f3747u);
                    }
                    gVar.q(z10, !zIsGroup);
                    if (zIsGroup) {
                        List<n.g> memberRoutes = p.this.f3732t.getMemberRoutes();
                        for (n.g gVar2 : gVar.f3747u.getMemberRoutes()) {
                            if (memberRoutes.contains(gVar2) != z10) {
                                f fVar = (f) p.this.G.get(gVar2.getId());
                                if (fVar instanceof g) {
                                    ((g) fVar).q(z10, true);
                                }
                            }
                        }
                    }
                    n.g gVar3 = gVar.f3747u;
                    p pVar = p.this;
                    List<n.g> memberRoutes2 = pVar.f3732t.getMemberRoutes();
                    int iMax = Math.max(1, memberRoutes2.size());
                    if (gVar3.isGroup()) {
                        Iterator<n.g> it = gVar3.getMemberRoutes().iterator();
                        while (it.hasNext()) {
                            if (memberRoutes2.contains(it.next()) != z10) {
                                iMax += z10 ? 1 : -1;
                            }
                        }
                    } else {
                        iMax += z10 ? 1 : -1;
                    }
                    p pVar2 = p.this;
                    boolean z11 = pVar2.f3728d0 && pVar2.f3732t.getMemberRoutes().size() > 1;
                    boolean z12 = pVar.f3728d0 && iMax >= 2;
                    if (z11 != z12) {
                        RecyclerView.z zVarFindViewHolderForAdapterPosition = pVar.D.findViewHolderForAdapterPosition(0);
                        if (zVarFindViewHolderForAdapterPosition instanceof d) {
                            d dVar = (d) zVarFindViewHolderForAdapterPosition;
                            hVar.a(dVar.f4041a, z12 ? dVar.f3774z : 0);
                        }
                    }
                }
            }

            public g(View view) throws Resources.NotFoundException {
                super(view, (ImageButton) view.findViewById(R.id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(R.id.mr_cast_volume_slider));
                this.G = new a();
                this.f3778y = view;
                this.f3779z = (ImageView) view.findViewById(R.id.mr_cast_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.mr_cast_route_progress_bar);
                this.A = progressBar;
                this.B = (TextView) view.findViewById(R.id.mr_cast_route_name);
                this.C = (RelativeLayout) view.findViewById(R.id.mr_cast_volume_layout);
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.mr_cast_checkbox);
                this.D = checkBox;
                p pVar = p.this;
                Context context = pVar.f3737y;
                Drawable drawableWrap = p0.a.wrap(s.a.getDrawable(context, R.drawable.mr_cast_checkbox));
                if (r.i(context)) {
                    p0.a.setTint(drawableWrap, m0.a.getColor(context, r.f3784a));
                }
                checkBox.setButtonDrawable(drawableWrap);
                Context context2 = pVar.f3737y;
                r.j(context2, progressBar);
                this.E = r.d(context2);
                Resources resources = context2.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(R.dimen.mr_dynamic_dialog_row_height, typedValue, true);
                this.F = (int) typedValue.getDimension(displayMetrics);
            }

            public final boolean p(n.g gVar) {
                if (gVar.isSelected()) {
                    return true;
                }
                n.g.a dynamicGroupState = p.this.f3732t.getDynamicGroupState(gVar);
                return dynamicGroupState != null && dynamicGroupState.getSelectionState() == 3;
            }

            public final void q(boolean z10, boolean z11) {
                CheckBox checkBox = this.D;
                checkBox.setEnabled(false);
                this.f3778y.setEnabled(false);
                checkBox.setChecked(z10);
                if (z10) {
                    this.f3779z.setVisibility(4);
                    this.A.setVisibility(0);
                }
                if (z11) {
                    h.this.a(this.C, z10 ? this.F : 0);
                }
            }
        }

        public h() {
            this.f3754e = LayoutInflater.from(p.this.f3737y);
            int i10 = R.attr.mediaRouteDefaultIconDrawable;
            Context context = p.this.f3737y;
            this.f3755f = r.e(context, i10);
            this.f3756g = r.e(context, R.attr.mediaRouteTvIconDrawable);
            this.f3757h = r.e(context, R.attr.mediaRouteSpeakerIconDrawable);
            this.f3758i = r.e(context, R.attr.mediaRouteSpeakerGroupIconDrawable);
            this.f3760k = context.getResources().getInteger(R.integer.mr_cast_volume_slider_layout_animation_duration_ms);
            this.f3761l = new AccelerateDecelerateInterpolator();
            d();
        }

        public final void a(View view, int i10) {
            a aVar = new a(i10, view.getLayoutParams().height, view);
            aVar.setAnimationListener(new b());
            aVar.setDuration(this.f3760k);
            aVar.setInterpolator(this.f3761l);
            view.startAnimation(aVar);
        }

        public final Drawable b(n.g gVar) {
            Uri iconUri = gVar.getIconUri();
            if (iconUri != null) {
                try {
                    Drawable drawableCreateFromStream = Drawable.createFromStream(p.this.f3737y.getContentResolver().openInputStream(iconUri), null);
                    if (drawableCreateFromStream != null) {
                        return drawableCreateFromStream;
                    }
                } catch (IOException e10) {
                    Log.w("MediaRouteCtrlDialog", "Failed to load " + iconUri, e10);
                }
            }
            int deviceType = gVar.getDeviceType();
            return deviceType != 1 ? deviceType != 2 ? gVar.isGroup() ? this.f3758i : this.f3755f : this.f3757h : this.f3756g;
        }

        public final void c() {
            p pVar = p.this;
            pVar.f3736x.clear();
            ArrayList arrayList = pVar.f3736x;
            ArrayList arrayList2 = pVar.f3734v;
            ArrayList arrayList3 = new ArrayList();
            for (n.g gVar : pVar.f3732t.getProvider().getRoutes()) {
                n.g.a dynamicGroupState = pVar.f3732t.getDynamicGroupState(gVar);
                if (dynamicGroupState != null && dynamicGroupState.isGroupable()) {
                    arrayList3.add(gVar);
                }
            }
            arrayList.addAll(n.getItemsRemoved(arrayList2, arrayList3));
            notifyDataSetChanged();
        }

        public final void d() {
            ArrayList<f> arrayList = this.f3753d;
            arrayList.clear();
            p pVar = p.this;
            this.f3759j = new f(pVar.f3732t, 1);
            ArrayList arrayList2 = pVar.f3733u;
            if (arrayList2.isEmpty()) {
                arrayList.add(new f(pVar.f3732t, 3));
            } else {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(new f((n.g) it.next(), 3));
                }
            }
            ArrayList arrayList3 = pVar.f3734v;
            boolean zIsEmpty = arrayList3.isEmpty();
            boolean z10 = false;
            Context context = pVar.f3737y;
            if (!zIsEmpty) {
                Iterator it2 = arrayList3.iterator();
                boolean z11 = false;
                while (it2.hasNext()) {
                    n.g gVar = (n.g) it2.next();
                    if (!arrayList2.contains(gVar)) {
                        if (!z11) {
                            i.b dynamicGroupController = pVar.f3732t.getDynamicGroupController();
                            String groupableSelectionTitle = dynamicGroupController != null ? dynamicGroupController.getGroupableSelectionTitle() : null;
                            if (TextUtils.isEmpty(groupableSelectionTitle)) {
                                groupableSelectionTitle = context.getString(R.string.mr_dialog_groupable_header);
                            }
                            arrayList.add(new f(groupableSelectionTitle, 2));
                            z11 = true;
                        }
                        arrayList.add(new f(gVar, 3));
                    }
                }
            }
            ArrayList arrayList4 = pVar.f3735w;
            if (!arrayList4.isEmpty()) {
                Iterator it3 = arrayList4.iterator();
                while (it3.hasNext()) {
                    n.g gVar2 = (n.g) it3.next();
                    n.g gVar3 = pVar.f3732t;
                    if (gVar3 != gVar2) {
                        if (!z10) {
                            i.b dynamicGroupController2 = gVar3.getDynamicGroupController();
                            String transferableSectionTitle = dynamicGroupController2 != null ? dynamicGroupController2.getTransferableSectionTitle() : null;
                            if (TextUtils.isEmpty(transferableSectionTitle)) {
                                transferableSectionTitle = context.getString(R.string.mr_dialog_transferable_header);
                            }
                            arrayList.add(new f(transferableSectionTitle, 2));
                            z10 = true;
                        }
                        arrayList.add(new f(gVar2, 4));
                    }
                }
            }
            c();
        }

        public f getItem(int i10) {
            return i10 == 0 ? this.f3759j : this.f3753d.get(i10 - 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f3753d.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i10) {
            return getItem(i10).getType();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.z zVar, int i10) {
            n.g.a dynamicGroupState;
            int itemViewType = getItemViewType(i10);
            f item = getItem(i10);
            p pVar = p.this;
            if (itemViewType == 1) {
                pVar.G.put(((n.g) item.getData()).getId(), (f) zVar);
                d dVar = (d) zVar;
                p pVar2 = p.this;
                i = pVar2.f3728d0 && pVar2.f3732t.getMemberRoutes().size() > 1 ? dVar.f3774z : 0;
                View view = dVar.f4041a;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = i;
                view.setLayoutParams(layoutParams);
                n.g gVar = (n.g) item.getData();
                dVar.n(gVar);
                dVar.f3773y.setText(gVar.getName());
                return;
            }
            if (itemViewType == 2) {
                e eVar = (e) zVar;
                eVar.getClass();
                eVar.f3775u.setText(item.getData().toString());
                return;
            }
            if (itemViewType != 3) {
                if (itemViewType != 4) {
                    throw new IllegalStateException();
                }
                c cVar = (c) zVar;
                cVar.getClass();
                n.g gVar2 = (n.g) item.getData();
                cVar.f3772z = gVar2;
                ImageView imageView = cVar.f3768v;
                imageView.setVisibility(0);
                cVar.f3769w.setVisibility(4);
                h hVar = h.this;
                List<n.g> memberRoutes = p.this.f3732t.getMemberRoutes();
                f = ((memberRoutes.size() == 1 && memberRoutes.get(0) == gVar2) ? 0 : 1) == 0 ? cVar.f3771y : 1.0f;
                View view2 = cVar.f3767u;
                view2.setAlpha(f);
                view2.setOnClickListener(new q(cVar));
                imageView.setImageDrawable(hVar.b(gVar2));
                cVar.f3770x.setText(gVar2.getName());
                return;
            }
            pVar.G.put(((n.g) item.getData()).getId(), (f) zVar);
            g gVar3 = (g) zVar;
            gVar3.getClass();
            n.g gVar4 = (n.g) item.getData();
            h hVar2 = h.this;
            p pVar3 = p.this;
            if (gVar4 == pVar3.f3732t && gVar4.getMemberRoutes().size() > 0) {
                Iterator<n.g> it = gVar4.getMemberRoutes().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n.g next = it.next();
                    if (!pVar3.f3734v.contains(next)) {
                        gVar4 = next;
                        break;
                    }
                }
            }
            gVar3.n(gVar4);
            Drawable drawableB = hVar2.b(gVar4);
            ImageView imageView2 = gVar3.f3779z;
            imageView2.setImageDrawable(drawableB);
            gVar3.B.setText(gVar4.getName());
            CheckBox checkBox = gVar3.D;
            checkBox.setVisibility(0);
            boolean zP = gVar3.p(gVar4);
            boolean z10 = !pVar3.f3736x.contains(gVar4) && (!gVar3.p(gVar4) || pVar3.f3732t.getMemberRoutes().size() >= 2) && (!gVar3.p(gVar4) || ((dynamicGroupState = pVar3.f3732t.getDynamicGroupState(gVar4)) != null && dynamicGroupState.isUnselectable()));
            checkBox.setChecked(zP);
            gVar3.A.setVisibility(4);
            imageView2.setVisibility(0);
            View view3 = gVar3.f3778y;
            view3.setEnabled(z10);
            checkBox.setEnabled(z10);
            gVar3.f3748v.setEnabled(z10 || zP);
            if (!z10 && !zP) {
                z = false;
            }
            gVar3.f3749w.setEnabled(z);
            g.a aVar = gVar3.G;
            view3.setOnClickListener(aVar);
            checkBox.setOnClickListener(aVar);
            if (zP && !gVar3.f3747u.isGroup()) {
                i = gVar3.F;
            }
            RelativeLayout relativeLayout = gVar3.C;
            ViewGroup.LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
            layoutParams2.height = i;
            relativeLayout.setLayoutParams(layoutParams2);
            float f10 = gVar3.E;
            view3.setAlpha((z10 || zP) ? 1.0f : f10);
            if (!z10 && zP) {
                f = f10;
            }
            checkBox.setAlpha(f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.z onCreateViewHolder(ViewGroup viewGroup, int i10) {
            LayoutInflater layoutInflater = this.f3754e;
            if (i10 == 1) {
                return new d(layoutInflater.inflate(R.layout.mr_cast_group_volume_item, viewGroup, false));
            }
            if (i10 == 2) {
                return new e(layoutInflater.inflate(R.layout.mr_cast_header_item, viewGroup, false));
            }
            if (i10 == 3) {
                return new g(layoutInflater.inflate(R.layout.mr_cast_route_item, viewGroup, false));
            }
            if (i10 == 4) {
                return new c(layoutInflater.inflate(R.layout.mr_cast_group_item, viewGroup, false));
            }
            throw new IllegalStateException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.z zVar) {
            super.onViewRecycled(zVar);
            p.this.G.values().remove(zVar);
        }

        /* compiled from: MediaRouteDynamicControllerDialog.java */
        public class b implements Animation.AnimationListener {
            public b() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                p pVar = p.this;
                pVar.J = false;
                pVar.i();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                p.this.J = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        }
    }
}
