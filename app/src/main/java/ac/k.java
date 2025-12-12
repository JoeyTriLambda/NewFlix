package ac;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.tv.ChannelsListActivityImport;
import java.util.ArrayList;

/* compiled from: ChannelAdapter.java */
/* loaded from: classes2.dex */
public final class k extends RecyclerView.Adapter<b> {

    /* renamed from: d, reason: collision with root package name */
    public final int f487d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f488e;

    /* renamed from: f, reason: collision with root package name */
    public final Activity f489f;

    /* renamed from: g, reason: collision with root package name */
    public ChannelsListActivityImport f490g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList<hd.d> f491h;

    /* compiled from: ChannelAdapter.java */
    public class b extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public hd.d f493u;

        /* renamed from: v, reason: collision with root package name */
        public final View f494v;

        /* renamed from: w, reason: collision with root package name */
        public final TextView f495w;

        /* renamed from: x, reason: collision with root package name */
        public final ImageView f496x;

        public b(k kVar, View view) {
            super(view);
            this.f494v = view;
            this.f495w = (TextView) view.findViewById(R.id.channel_text_view);
            this.f496x = (ImageView) view.findViewById(R.id.image_v);
        }
    }

    public k(Context context, ArrayList<hd.d> arrayList, Activity activity, int i10, int i11) {
        this.f487d = 100;
        this.f488e = context;
        this.f491h = arrayList;
        this.f489f = activity;
        new fd.a();
        new fd.f(context);
        this.f487d = i11;
        ArrayList<String> arrayList2 = App.B;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f491h.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewC = c.c(viewGroup, R.layout.channel_item_view, viewGroup, false);
        if (this.f487d == 200) {
            viewC = c.c(viewGroup, R.layout.channel_item_view_list, viewGroup, false);
        }
        return new b(this, viewC);
    }

    public void setImportActivity(ChannelsListActivityImport channelsListActivityImport) {
        this.f490g = channelsListActivityImport;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(ac.k.b r5, int r6) {
        /*
            r4 = this;
            android.view.View r0 = r5.f494v
            r1 = 1
            if (r6 != 0) goto L7
            r2 = 1
            goto L8
        L7:
            r2 = 0
        L8:
            r0.setSelected(r2)
            java.util.ArrayList<hd.d> r0 = r4.f491h
            java.lang.Object r0 = r0.get(r6)
            hd.d r0 = (hd.d) r0
            r5.f493u = r0
            android.widget.TextView r2 = r5.f495w
            java.lang.String r0 = r0.f12984q
            r2.setText(r0)
            hd.d r0 = r5.f493u
            java.lang.String r0 = r0.f12985r
            android.widget.ImageView r2 = r5.f496x
            if (r0 == 0) goto L58
            int r0 = r0.length()
            r3 = 10
            if (r0 <= r3) goto L58
            hd.d r0 = r5.f493u
            java.lang.String r0 = r0.f12985r
            java.lang.String r3 = "http"
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L58
            com.squareup.picasso.Picasso r0 = com.squareup.picasso.Picasso.get()     // Catch: java.lang.Exception -> L4d java.lang.OutOfMemoryError -> L4f
            hd.d r3 = r5.f493u     // Catch: java.lang.Exception -> L4d java.lang.OutOfMemoryError -> L4f
            java.lang.String r3 = r3.f12985r     // Catch: java.lang.Exception -> L4d java.lang.OutOfMemoryError -> L4f
            com.squareup.picasso.l r0 = r0.load(r3)     // Catch: java.lang.Exception -> L4d java.lang.OutOfMemoryError -> L4f
            ac.k$a r3 = new ac.k$a     // Catch: java.lang.Exception -> L4d java.lang.OutOfMemoryError -> L4f
            r3.<init>(r5)     // Catch: java.lang.Exception -> L4d java.lang.OutOfMemoryError -> L4f
            r0.into(r2, r3)     // Catch: java.lang.Exception -> L4d java.lang.OutOfMemoryError -> L4f
            goto L79
        L4d:
            r0 = move-exception
            goto L54
        L4f:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Exception -> L4d
            goto L79
        L54:
            r0.printStackTrace()
            goto L79
        L58:
            com.squareup.picasso.Picasso r0 = com.squareup.picasso.Picasso.get()     // Catch: java.lang.Exception -> L6f java.lang.OutOfMemoryError -> L71
            r3 = 2131231695(0x7f0803cf, float:1.8079478E38)
            com.squareup.picasso.l r0 = r0.load(r3)     // Catch: java.lang.Exception -> L6f java.lang.OutOfMemoryError -> L71
            com.squareup.picasso.l r0 = r0.fit()     // Catch: java.lang.Exception -> L6f java.lang.OutOfMemoryError -> L71
            com.squareup.picasso.l r0 = r0.centerCrop()     // Catch: java.lang.Exception -> L6f java.lang.OutOfMemoryError -> L71
            r0.into(r2)     // Catch: java.lang.Exception -> L6f java.lang.OutOfMemoryError -> L71
            goto L79
        L6f:
            r0 = move-exception
            goto L76
        L71:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Exception -> L6f
            goto L79
        L76:
            r0.printStackTrace()
        L79:
            ac.a r0 = new ac.a
            r2 = 2
            r0.<init>(r4, r6, r2)
            android.view.View r2 = r5.f494v
            r2.setOnClickListener(r0)
            ac.e r0 = new ac.e
            r0.<init>(r4, r6, r5, r1)
            r2.setOnLongClickListener(r0)
            ac.b r6 = new ac.b
            r0 = 3
            r6.<init>(r4, r5, r0)
            r2.setOnFocusChangeListener(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ac.k.onBindViewHolder(ac.k$b, int):void");
    }

    /* compiled from: ChannelAdapter.java */
    public class a implements sa.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f492a;

        public a(b bVar) {
            this.f492a = bVar;
        }

        @Override // sa.b
        public void onSuccess() {
            this.f492a.f496x.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }

        @Override // sa.b
        public void onError(Exception exc) {
        }
    }
}
