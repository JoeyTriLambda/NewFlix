package ac;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;
import flix.com.vision.R;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;

/* compiled from: CastAdapter.java */
/* loaded from: classes2.dex */
public final class j extends RecyclerView.Adapter<b> {

    /* renamed from: d, reason: collision with root package name */
    public final Activity f475d;

    /* renamed from: e, reason: collision with root package name */
    public final int f476e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<hd.b> f477f;

    /* renamed from: g, reason: collision with root package name */
    public final Typeface f478g;

    /* renamed from: h, reason: collision with root package name */
    public final c4.a f479h;

    /* compiled from: CastAdapter.java */
    public class a implements View.OnFocusChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f480b;

        public a(b bVar) {
            this.f480b = bVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            j jVar = j.this;
            b bVar = this.f480b;
            if (!z10) {
                o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                bVar.f486y.setBorderColor(jVar.f475d.getResources().getColor(R.color.transparent));
                bVar.f484w.setEllipsize(TextUtils.TruncateAt.END);
                bVar.f484w.setFocusableInTouchMode(false);
                bVar.f484w.setHorizontallyScrolling(false);
                bVar.f484w.setSelected(false);
                bVar.f484w.setHorizontalFadingEdgeEnabled(true);
                bVar.f485x.setHorizontalFadingEdgeEnabled(true);
                bVar.f485x.setEllipsize(TextUtils.TruncateAt.END);
                bVar.f485x.setFocusableInTouchMode(false);
                bVar.f485x.setHorizontallyScrolling(false);
                bVar.f485x.setSelected(false);
                return;
            }
            o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
            bVar.f486y.setBorderColor(jVar.f475d.getResources().getColor(R.color.white));
            bVar.f484w.setFocusable(true);
            bVar.f484w.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            bVar.f484w.setMarqueeRepeatLimit(6);
            bVar.f484w.setFocusableInTouchMode(true);
            bVar.f484w.setHorizontallyScrolling(true);
            bVar.f484w.setSelected(true);
            bVar.f484w.setHorizontalFadingEdgeEnabled(true);
            bVar.f485x.setHorizontalFadingEdgeEnabled(true);
            bVar.f485x.setFocusable(true);
            bVar.f485x.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            bVar.f485x.setMarqueeRepeatLimit(6);
            bVar.f485x.setFocusableInTouchMode(true);
            bVar.f485x.setHorizontallyScrolling(true);
            bVar.f485x.setSelected(true);
        }
    }

    /* compiled from: CastAdapter.java */
    public class b extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public hd.b f482u;

        /* renamed from: v, reason: collision with root package name */
        public final View f483v;

        /* renamed from: w, reason: collision with root package name */
        public final TextView f484w;

        /* renamed from: x, reason: collision with root package name */
        public final TextView f485x;

        /* renamed from: y, reason: collision with root package name */
        public final CircleImageView f486y;

        public b(j jVar, View view) {
            super(view);
            this.f483v = view;
            this.f486y = (CircleImageView) view.findViewById(R.id.image_cast);
            this.f484w = (TextView) view.findViewById(R.id.cast_name);
            this.f485x = (TextView) view.findViewById(R.id.cast_name_actor);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.z
        public String toString() {
            return super.toString() + " '" + ((Object) this.f484w.getText()) + "'";
        }
    }

    public j(Context context, ArrayList arrayList, Activity activity, int i10) {
        this.f477f = arrayList;
        this.f475d = activity;
        this.f476e = i10;
        AssetManager assets = activity.getAssets();
        String str = Constant.f12450b;
        this.f478g = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f479h = new c4.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f477f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b(this, c.c(viewGroup, R.layout.cast_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(b bVar, int i10) {
        TextView textView = bVar.f484w;
        c4.a aVar = this.f479h;
        Typeface typeface = this.f478g;
        aVar.applyFontToView(textView, typeface);
        TextView textView2 = bVar.f485x;
        aVar.applyFontToView(textView2, typeface);
        ArrayList<hd.b> arrayList = this.f477f;
        hd.b bVar2 = arrayList.get(i10);
        bVar.f482u = bVar2;
        bVar.f484w.setText(bVar2.getName());
        textView2.setText(bVar.f482u.f12974b);
        try {
            String img_url = arrayList.get(i10).getImg_url();
            CircleImageView circleImageView = bVar.f486y;
            if (img_url == null || arrayList.get(i10).getImg_url().length() < 10) {
                Picasso.get().load(arrayList.get(i10).f12975c == 0 ? R.drawable.cast_ : R.drawable.cast_2).fit().centerCrop().into(circleImageView);
            } else {
                Picasso.get().load(arrayList.get(i10).getImg_url()).fit().centerCrop().into(circleImageView);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        ub.v vVar = new ub.v(9, this, bVar);
        View view = bVar.f483v;
        view.setOnClickListener(vVar);
        view.setOnFocusChangeListener(new a(bVar));
    }
}
