package androidx.mediarouter.app;

import a2.n;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.mediarouter.R;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import r.u;

/* compiled from: MediaRouteDynamicChooserDialog.java */
/* loaded from: classes.dex */
public final class o extends u {
    public long A;
    public final a B;

    /* renamed from: q, reason: collision with root package name */
    public final a2.n f3693q;

    /* renamed from: r, reason: collision with root package name */
    public final c f3694r;

    /* renamed from: s, reason: collision with root package name */
    public final Context f3695s;

    /* renamed from: t, reason: collision with root package name */
    public a2.m f3696t;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f3697u;

    /* renamed from: v, reason: collision with root package name */
    public d f3698v;

    /* renamed from: w, reason: collision with root package name */
    public RecyclerView f3699w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f3700x;

    /* renamed from: y, reason: collision with root package name */
    public n.g f3701y;

    /* renamed from: z, reason: collision with root package name */
    public final long f3702z;

    /* compiled from: MediaRouteDynamicChooserDialog.java */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            List list = (List) message.obj;
            o oVar = o.this;
            oVar.getClass();
            oVar.A = SystemClock.uptimeMillis();
            oVar.f3697u.clear();
            oVar.f3697u.addAll(list);
            oVar.f3698v.a();
        }
    }

    /* compiled from: MediaRouteDynamicChooserDialog.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o.this.dismiss();
        }
    }

    /* compiled from: MediaRouteDynamicChooserDialog.java */
    public final class c extends n.a {
        public c() {
        }

        @Override // a2.n.a
        public void onRouteAdded(a2.n nVar, n.g gVar) {
            o.this.refreshRoutes();
        }

        @Override // a2.n.a
        public void onRouteChanged(a2.n nVar, n.g gVar) {
            o.this.refreshRoutes();
        }

        @Override // a2.n.a
        public void onRouteRemoved(a2.n nVar, n.g gVar) {
            o.this.refreshRoutes();
        }

        @Override // a2.n.a
        public void onRouteSelected(a2.n nVar, n.g gVar) {
            o.this.dismiss();
        }
    }

    /* compiled from: MediaRouteDynamicChooserDialog.java */
    public final class d extends RecyclerView.Adapter<RecyclerView.z> {

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList<b> f3706d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        public final LayoutInflater f3707e;

        /* renamed from: f, reason: collision with root package name */
        public final Drawable f3708f;

        /* renamed from: g, reason: collision with root package name */
        public final Drawable f3709g;

        /* renamed from: h, reason: collision with root package name */
        public final Drawable f3710h;

        /* renamed from: i, reason: collision with root package name */
        public final Drawable f3711i;

        /* compiled from: MediaRouteDynamicChooserDialog.java */
        public class a extends RecyclerView.z {

            /* renamed from: u, reason: collision with root package name */
            public final TextView f3713u;

            public a(View view) {
                super(view);
                this.f3713u = (TextView) view.findViewById(R.id.mr_picker_header_name);
            }

            public void bindHeaderView(b bVar) {
                this.f3713u.setText(bVar.getData().toString());
            }
        }

        /* compiled from: MediaRouteDynamicChooserDialog.java */
        public class b {

            /* renamed from: a, reason: collision with root package name */
            public final Object f3714a;

            /* renamed from: b, reason: collision with root package name */
            public final int f3715b;

            public b(Object obj) {
                this.f3714a = obj;
                if (obj instanceof String) {
                    this.f3715b = 1;
                } else {
                    if (!(obj instanceof n.g)) {
                        throw new IllegalArgumentException();
                    }
                    this.f3715b = 2;
                }
            }

            public Object getData() {
                return this.f3714a;
            }

            public int getType() {
                return this.f3715b;
            }
        }

        /* compiled from: MediaRouteDynamicChooserDialog.java */
        public class c extends RecyclerView.z {

            /* renamed from: u, reason: collision with root package name */
            public final View f3716u;

            /* renamed from: v, reason: collision with root package name */
            public final ImageView f3717v;

            /* renamed from: w, reason: collision with root package name */
            public final ProgressBar f3718w;

            /* renamed from: x, reason: collision with root package name */
            public final TextView f3719x;

            /* compiled from: MediaRouteDynamicChooserDialog.java */
            public class a implements View.OnClickListener {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ n.g f3721b;

                public a(n.g gVar) {
                    this.f3721b = gVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c cVar = c.this;
                    o oVar = o.this;
                    n.g gVar = this.f3721b;
                    oVar.f3701y = gVar;
                    gVar.select();
                    cVar.f3717v.setVisibility(4);
                    cVar.f3718w.setVisibility(0);
                }
            }

            public c(View view) {
                super(view);
                this.f3716u = view;
                this.f3717v = (ImageView) view.findViewById(R.id.mr_picker_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.mr_picker_route_progress_bar);
                this.f3718w = progressBar;
                this.f3719x = (TextView) view.findViewById(R.id.mr_picker_route_name);
                r.j(o.this.f3695s, progressBar);
            }

            /* JADX WARN: Removed duplicated region for block: B:9:0x0056  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void bindRouteView(androidx.mediarouter.app.o.d.b r6) {
                /*
                    r5 = this;
                    java.lang.Object r6 = r6.getData()
                    a2.n$g r6 = (a2.n.g) r6
                    r0 = 0
                    android.view.View r1 = r5.f3716u
                    r1.setVisibility(r0)
                    android.widget.ProgressBar r0 = r5.f3718w
                    r2 = 4
                    r0.setVisibility(r2)
                    androidx.mediarouter.app.o$d$c$a r0 = new androidx.mediarouter.app.o$d$c$a
                    r0.<init>(r6)
                    r1.setOnClickListener(r0)
                    java.lang.String r0 = r6.getName()
                    android.widget.TextView r1 = r5.f3719x
                    r1.setText(r0)
                    androidx.mediarouter.app.o$d r0 = androidx.mediarouter.app.o.d.this
                    r0.getClass()
                    android.net.Uri r1 = r6.getIconUri()
                    if (r1 == 0) goto L56
                    androidx.mediarouter.app.o r2 = androidx.mediarouter.app.o.this     // Catch: java.io.IOException -> L42
                    android.content.Context r2 = r2.f3695s     // Catch: java.io.IOException -> L42
                    android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.io.IOException -> L42
                    java.io.InputStream r2 = r2.openInputStream(r1)     // Catch: java.io.IOException -> L42
                    r3 = 0
                    android.graphics.drawable.Drawable r1 = android.graphics.drawable.Drawable.createFromStream(r2, r3)     // Catch: java.io.IOException -> L42
                    if (r1 == 0) goto L56
                    goto L72
                L42:
                    r2 = move-exception
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    java.lang.String r4 = "Failed to load "
                    r3.<init>(r4)
                    r3.append(r1)
                    java.lang.String r1 = r3.toString()
                    java.lang.String r3 = "RecyclerAdapter"
                    android.util.Log.w(r3, r1, r2)
                L56:
                    int r1 = r6.getDeviceType()
                    r2 = 1
                    if (r1 == r2) goto L6f
                    r2 = 2
                    if (r1 == r2) goto L6c
                    boolean r6 = r6.isGroup()
                    if (r6 == 0) goto L69
                    android.graphics.drawable.Drawable r6 = r0.f3711i
                    goto L71
                L69:
                    android.graphics.drawable.Drawable r6 = r0.f3708f
                    goto L71
                L6c:
                    android.graphics.drawable.Drawable r6 = r0.f3710h
                    goto L71
                L6f:
                    android.graphics.drawable.Drawable r6 = r0.f3709g
                L71:
                    r1 = r6
                L72:
                    android.widget.ImageView r6 = r5.f3717v
                    r6.setImageDrawable(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.o.d.c.bindRouteView(androidx.mediarouter.app.o$d$b):void");
            }
        }

        public d() {
            this.f3707e = LayoutInflater.from(o.this.f3695s);
            int i10 = R.attr.mediaRouteDefaultIconDrawable;
            Context context = o.this.f3695s;
            this.f3708f = r.e(context, i10);
            this.f3709g = r.e(context, R.attr.mediaRouteTvIconDrawable);
            this.f3710h = r.e(context, R.attr.mediaRouteSpeakerIconDrawable);
            this.f3711i = r.e(context, R.attr.mediaRouteSpeakerGroupIconDrawable);
            a();
        }

        public final void a() {
            ArrayList<b> arrayList = this.f3706d;
            arrayList.clear();
            o oVar = o.this;
            arrayList.add(new b(oVar.f3695s.getString(R.string.mr_chooser_title)));
            Iterator it = oVar.f3697u.iterator();
            while (it.hasNext()) {
                arrayList.add(new b((n.g) it.next()));
            }
            notifyDataSetChanged();
        }

        public b getItem(int i10) {
            return this.f3706d.get(i10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f3706d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i10) {
            return this.f3706d.get(i10).getType();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.z zVar, int i10) {
            int itemViewType = getItemViewType(i10);
            b item = getItem(i10);
            if (itemViewType == 1) {
                ((a) zVar).bindHeaderView(item);
            } else if (itemViewType != 2) {
                Log.w("RecyclerAdapter", "Cannot bind item to ViewHolder because of wrong view type");
            } else {
                ((c) zVar).bindRouteView(item);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.z onCreateViewHolder(ViewGroup viewGroup, int i10) {
            LayoutInflater layoutInflater = this.f3707e;
            if (i10 == 1) {
                return new a(layoutInflater.inflate(R.layout.mr_picker_header_item, viewGroup, false));
            }
            if (i10 == 2) {
                return new c(layoutInflater.inflate(R.layout.mr_picker_route_item, viewGroup, false));
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MediaRouteDynamicChooserDialog.java */
    public static final class e implements Comparator<n.g> {

        /* renamed from: b, reason: collision with root package name */
        public static final e f3723b = new e();

        @Override // java.util.Comparator
        public int compare(n.g gVar, n.g gVar2) {
            return gVar.getName().compareToIgnoreCase(gVar2.getName());
        }
    }

    public o(Context context) {
        this(context, 0);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3700x = true;
        this.f3693q.addCallback(this.f3696t, this.f3694r, 1);
        refreshRoutes();
    }

    @Override // r.u, androidx.activity.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mr_picker_dialog);
        int i10 = r.f3784a;
        View decorView = getWindow().getDecorView();
        Context context = this.f3695s;
        decorView.setBackgroundColor(m0.a.getColor(context, r.i(context) ? R.color.mr_dynamic_dialog_background_light : R.color.mr_dynamic_dialog_background_dark));
        this.f3697u = new ArrayList();
        ((ImageButton) findViewById(R.id.mr_picker_close_button)).setOnClickListener(new b());
        this.f3698v = new d();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mr_picker_list);
        this.f3699w = recyclerView;
        recyclerView.setAdapter(this.f3698v);
        this.f3699w.setLayoutManager(new LinearLayoutManager(context));
        getWindow().setLayout(n.getDialogWidthForDynamicGroup(context), n.getDialogHeight(context));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3700x = false;
        this.f3693q.removeCallback(this.f3694r);
        this.B.removeMessages(1);
    }

    public boolean onFilterRoute(n.g gVar) {
        return !gVar.isDefaultOrBluetooth() && gVar.isEnabled() && gVar.matchesSelector(this.f3696t);
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
        if (this.f3701y == null && this.f3700x) {
            ArrayList arrayList = new ArrayList(this.f3693q.getRoutes());
            onFilterRoutes(arrayList);
            Collections.sort(arrayList, e.f3723b);
            long jUptimeMillis = SystemClock.uptimeMillis() - this.A;
            long j10 = this.f3702z;
            if (jUptimeMillis < j10) {
                a aVar = this.B;
                aVar.removeMessages(1);
                aVar.sendMessageAtTime(aVar.obtainMessage(1, arrayList), this.A + j10);
            } else {
                this.A = SystemClock.uptimeMillis();
                this.f3697u.clear();
                this.f3697u.addAll(arrayList);
                this.f3698v.a();
            }
        }
    }

    public void setRouteSelector(a2.m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f3696t.equals(mVar)) {
            return;
        }
        this.f3696t = mVar;
        if (this.f3700x) {
            a2.n nVar = this.f3693q;
            c cVar = this.f3694r;
            nVar.removeCallback(cVar);
            nVar.addCallback(mVar, cVar, 1);
        }
        refreshRoutes();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public o(Context context, int i10) {
        ContextThemeWrapper contextThemeWrapperA = r.a(context, i10, false);
        super(contextThemeWrapperA, r.b(contextThemeWrapperA));
        this.f3696t = a2.m.f182c;
        this.B = new a();
        Context context2 = getContext();
        this.f3693q = a2.n.getInstance(context2);
        this.f3694r = new c();
        this.f3695s = context2;
        this.f3702z = context2.getResources().getInteger(R.integer.mr_update_routes_delay_ms);
    }
}
