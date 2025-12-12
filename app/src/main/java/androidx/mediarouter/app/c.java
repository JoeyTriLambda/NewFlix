package androidx.mediarouter.app;

import a2.n;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.mediarouter.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import r.u;

/* compiled from: MediaRouteChooserDialog.java */
/* loaded from: classes.dex */
public final class c extends u {
    public Button A;
    public ProgressBar B;
    public ListView C;
    public C0035c D;
    public final e E;
    public boolean F;
    public long G;
    public final a H;

    /* renamed from: q, reason: collision with root package name */
    public final a2.n f3602q;

    /* renamed from: r, reason: collision with root package name */
    public final b f3603r;

    /* renamed from: s, reason: collision with root package name */
    public a2.m f3604s;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList<n.g> f3605t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f3606u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f3607v;

    /* renamed from: w, reason: collision with root package name */
    public RelativeLayout f3608w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f3609x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f3610y;

    /* renamed from: z, reason: collision with root package name */
    public LinearLayout f3611z;

    /* compiled from: MediaRouteChooserDialog.java */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            c cVar = c.this;
            if (i10 == 1) {
                cVar.c((List) message.obj);
                return;
            }
            if (i10 == 2) {
                if (cVar.f3605t.isEmpty()) {
                    cVar.d(2);
                    a aVar = cVar.H;
                    aVar.removeMessages(2);
                    aVar.removeMessages(3);
                    aVar.sendMessageDelayed(aVar.obtainMessage(3), 15000L);
                    return;
                }
                return;
            }
            if (i10 == 3 && cVar.f3605t.isEmpty()) {
                cVar.d(3);
                a aVar2 = cVar.H;
                aVar2.removeMessages(2);
                aVar2.removeMessages(3);
                aVar2.removeMessages(1);
                cVar.f3602q.removeCallback(cVar.f3603r);
            }
        }
    }

    /* compiled from: MediaRouteChooserDialog.java */
    public final class b extends n.a {
        public b() {
        }

        @Override // a2.n.a
        public void onRouteAdded(a2.n nVar, n.g gVar) {
            c.this.refreshRoutes();
        }

        @Override // a2.n.a
        public void onRouteChanged(a2.n nVar, n.g gVar) {
            c.this.refreshRoutes();
        }

        @Override // a2.n.a
        public void onRouteRemoved(a2.n nVar, n.g gVar) {
            c.this.refreshRoutes();
        }

        @Override // a2.n.a
        public void onRouteSelected(a2.n nVar, n.g gVar) {
            c.this.dismiss();
        }
    }

    /* compiled from: MediaRouteChooserDialog.java */
    /* renamed from: androidx.mediarouter.app.c$c, reason: collision with other inner class name */
    public static final class C0035c extends ArrayAdapter<n.g> implements AdapterView.OnItemClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f3614b;

        /* renamed from: m, reason: collision with root package name */
        public final Drawable f3615m;

        /* renamed from: n, reason: collision with root package name */
        public final Drawable f3616n;

        /* renamed from: o, reason: collision with root package name */
        public final Drawable f3617o;

        /* renamed from: p, reason: collision with root package name */
        public final Drawable f3618p;

        public C0035c(Context context, List<n.g> list) {
            super(context, 0, list);
            this.f3614b = LayoutInflater.from(context);
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.mediaRouteDefaultIconDrawable, R.attr.mediaRouteTvIconDrawable, R.attr.mediaRouteSpeakerIconDrawable, R.attr.mediaRouteSpeakerGroupIconDrawable});
            this.f3615m = s.a.getDrawable(context, typedArrayObtainStyledAttributes.getResourceId(0, 0));
            this.f3616n = s.a.getDrawable(context, typedArrayObtainStyledAttributes.getResourceId(1, 0));
            this.f3617o = s.a.getDrawable(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
            this.f3618p = s.a.getDrawable(context, typedArrayObtainStyledAttributes.getResourceId(3, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
            /*
                r6 = this;
                r0 = 0
                if (r8 != 0) goto Lb
                android.view.LayoutInflater r8 = r6.f3614b
                int r1 = androidx.mediarouter.R.layout.mr_chooser_list_item
                android.view.View r8 = r8.inflate(r1, r9, r0)
            Lb:
                java.lang.Object r7 = r6.getItem(r7)
                a2.n$g r7 = (a2.n.g) r7
                int r9 = androidx.mediarouter.R.id.mr_chooser_route_name
                android.view.View r9 = r8.findViewById(r9)
                android.widget.TextView r9 = (android.widget.TextView) r9
                int r1 = androidx.mediarouter.R.id.mr_chooser_route_desc
                android.view.View r1 = r8.findViewById(r1)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r2 = r7.getName()
                r9.setText(r2)
                java.lang.String r2 = r7.getDescription()
                int r3 = r7.getConnectionState()
                r4 = 2
                r5 = 1
                if (r3 == r4) goto L3d
                int r3 = r7.getConnectionState()
                if (r3 != r5) goto L3b
                goto L3d
            L3b:
                r3 = 0
                goto L3e
            L3d:
                r3 = 1
            L3e:
                if (r3 == 0) goto L52
                boolean r3 = android.text.TextUtils.isEmpty(r2)
                if (r3 != 0) goto L52
                r3 = 80
                r9.setGravity(r3)
                r1.setVisibility(r0)
                r1.setText(r2)
                goto L61
            L52:
                r0 = 16
                r9.setGravity(r0)
                r9 = 8
                r1.setVisibility(r9)
                java.lang.String r9 = ""
                r1.setText(r9)
            L61:
                boolean r9 = r7.isEnabled()
                r8.setEnabled(r9)
                int r9 = androidx.mediarouter.R.id.mr_chooser_route_icon
                android.view.View r9 = r8.findViewById(r9)
                android.widget.ImageView r9 = (android.widget.ImageView) r9
                if (r9 == 0) goto Lbd
                android.net.Uri r0 = r7.getIconUri()
                if (r0 == 0) goto La0
                android.content.Context r1 = r6.getContext()     // Catch: java.io.IOException -> L8c
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.io.IOException -> L8c
                java.io.InputStream r1 = r1.openInputStream(r0)     // Catch: java.io.IOException -> L8c
                r2 = 0
                android.graphics.drawable.Drawable r0 = android.graphics.drawable.Drawable.createFromStream(r1, r2)     // Catch: java.io.IOException -> L8c
                if (r0 == 0) goto La0
                goto Lba
            L8c:
                r1 = move-exception
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "Failed to load "
                r2.<init>(r3)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                java.lang.String r2 = "MediaRouteChooserDialog"
                android.util.Log.w(r2, r0, r1)
            La0:
                int r0 = r7.getDeviceType()
                if (r0 == r5) goto Lb7
                if (r0 == r4) goto Lb4
                boolean r7 = r7.isGroup()
                if (r7 == 0) goto Lb1
                android.graphics.drawable.Drawable r7 = r6.f3618p
                goto Lb9
            Lb1:
                android.graphics.drawable.Drawable r7 = r6.f3615m
                goto Lb9
            Lb4:
                android.graphics.drawable.Drawable r7 = r6.f3617o
                goto Lb9
            Lb7:
                android.graphics.drawable.Drawable r7 = r6.f3616n
            Lb9:
                r0 = r7
            Lba:
                r9.setImageDrawable(r0)
            Lbd:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.c.C0035c.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            return getItem(i10).isEnabled();
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            n.g item = getItem(i10);
            if (item.isEnabled()) {
                ImageView imageView = (ImageView) view.findViewById(R.id.mr_chooser_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.mr_chooser_route_progress_bar);
                if (imageView != null && progressBar != null) {
                    imageView.setVisibility(8);
                    progressBar.setVisibility(0);
                }
                item.select();
            }
        }
    }

    /* compiled from: MediaRouteChooserDialog.java */
    public static final class d implements Comparator<n.g> {

        /* renamed from: b, reason: collision with root package name */
        public static final d f3619b = new d();

        @Override // java.util.Comparator
        public int compare(n.g gVar, n.g gVar2) {
            return gVar.getName().compareToIgnoreCase(gVar2.getName());
        }
    }

    /* compiled from: MediaRouteChooserDialog.java */
    public final class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                c.this.dismiss();
            }
        }
    }

    public c(Context context) {
        this(context, 0);
    }

    public final void c(List<n.g> list) {
        this.G = SystemClock.uptimeMillis();
        this.f3605t.clear();
        this.f3605t.addAll(list);
        this.D.notifyDataSetChanged();
        a aVar = this.H;
        aVar.removeMessages(3);
        aVar.removeMessages(2);
        if (!list.isEmpty()) {
            d(1);
        } else {
            d(0);
            aVar.sendMessageDelayed(aVar.obtainMessage(2), 5000L);
        }
    }

    public final void d(int i10) {
        if (i10 == 0) {
            setTitle(R.string.mr_chooser_title);
            this.C.setVisibility(8);
            this.f3607v.setVisibility(0);
            this.B.setVisibility(0);
            this.f3611z.setVisibility(8);
            this.A.setVisibility(8);
            this.f3610y.setVisibility(8);
            this.f3608w.setVisibility(8);
            return;
        }
        if (i10 == 1) {
            setTitle(R.string.mr_chooser_title);
            this.C.setVisibility(0);
            this.f3607v.setVisibility(8);
            this.B.setVisibility(8);
            this.f3611z.setVisibility(8);
            this.A.setVisibility(8);
            this.f3610y.setVisibility(8);
            this.f3608w.setVisibility(8);
            return;
        }
        if (i10 == 2) {
            setTitle(R.string.mr_chooser_title);
            this.C.setVisibility(8);
            this.f3607v.setVisibility(8);
            this.B.setVisibility(0);
            this.f3611z.setVisibility(8);
            this.A.setVisibility(8);
            this.f3610y.setVisibility(4);
            this.f3608w.setVisibility(0);
            return;
        }
        if (i10 != 3) {
            return;
        }
        setTitle(R.string.mr_chooser_zero_routes_found_title);
        this.C.setVisibility(8);
        this.f3607v.setVisibility(8);
        this.B.setVisibility(8);
        this.f3611z.setVisibility(0);
        this.A.setVisibility(0);
        this.f3610y.setVisibility(0);
        this.f3608w.setVisibility(0);
    }

    @Override // r.u, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            getContext().unregisterReceiver(this.E);
        } catch (IllegalArgumentException unused) {
        }
        super.dismiss();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.F = true;
        this.f3602q.addCallback(this.f3604s, this.f3603r, 1);
        refreshRoutes();
        a aVar = this.H;
        aVar.removeMessages(2);
        aVar.removeMessages(3);
        aVar.removeMessages(1);
        aVar.sendMessageDelayed(aVar.obtainMessage(2), 5000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013c  */
    @Override // r.u, androidx.activity.h, android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r7) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.c.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.F = false;
        this.f3602q.removeCallback(this.f3603r);
        a aVar = this.H;
        aVar.removeMessages(1);
        aVar.removeMessages(2);
        aVar.removeMessages(3);
        super.onDetachedFromWindow();
    }

    public boolean onFilterRoute(n.g gVar) {
        return !gVar.isDefaultOrBluetooth() && gVar.isEnabled() && gVar.matchesSelector(this.f3604s);
    }

    public void onFilterRoutes(List<n.g> list) {
        int size = list.size();
        while (true) {
            int i10 = size - 1;
            if (size <= 0) {
                return;
            }
            if (!onFilterRoute(list.get(i10))) {
                list.remove(i10);
            }
            size = i10;
        }
    }

    public void refreshRoutes() {
        if (this.F) {
            ArrayList arrayList = new ArrayList(this.f3602q.getRoutes());
            onFilterRoutes(arrayList);
            Collections.sort(arrayList, d.f3619b);
            if (SystemClock.uptimeMillis() - this.G >= 300) {
                c(arrayList);
                return;
            }
            a aVar = this.H;
            aVar.removeMessages(1);
            aVar.sendMessageAtTime(aVar.obtainMessage(1, arrayList), this.G + 300);
        }
    }

    public void setRouteSelector(a2.m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f3604s.equals(mVar)) {
            return;
        }
        this.f3604s = mVar;
        if (this.F) {
            a2.n nVar = this.f3602q;
            b bVar = this.f3603r;
            nVar.removeCallback(bVar);
            nVar.addCallback(mVar, bVar, 1);
        }
        refreshRoutes();
    }

    @Override // r.u, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.f3606u.setText(charSequence);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(Context context, int i10) {
        ContextThemeWrapper contextThemeWrapperA = r.a(context, i10, false);
        super(contextThemeWrapperA, r.b(contextThemeWrapperA));
        this.f3604s = a2.m.f182c;
        this.H = new a();
        this.f3602q = a2.n.getInstance(getContext());
        this.f3603r = new b();
        this.E = new e();
    }

    @Override // r.u, android.app.Dialog
    public void setTitle(int i10) {
        this.f3606u.setText(i10);
    }
}
