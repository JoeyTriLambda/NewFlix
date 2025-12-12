package ac;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.R;
import flix.com.vision.models.torrent.UserTorrent;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;

/* compiled from: UserTorrentAdapter.java */
/* loaded from: classes2.dex */
public final class b0 extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<UserTorrent> f390d;

    /* renamed from: e, reason: collision with root package name */
    public final Activity f391e;

    /* compiled from: UserTorrentAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public UserTorrent f392u;

        /* renamed from: v, reason: collision with root package name */
        public final View f393v;

        /* renamed from: w, reason: collision with root package name */
        public final TextView f394w;

        /* renamed from: x, reason: collision with root package name */
        public final TextView f395x;

        /* renamed from: y, reason: collision with root package name */
        public final TextView f396y;

        public a(b0 b0Var, View view) {
            super(view);
            this.f393v = view;
            this.f394w = (TextView) view.findViewById(R.id.link_main_label);
            this.f395x = (TextView) view.findViewById(R.id.link_detail_view);
            this.f396y = (TextView) view.findViewById(R.id.link_source);
        }
    }

    public b0(Activity activity, ArrayList<UserTorrent> arrayList) {
        this.f390d = arrayList;
        this.f391e = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f390d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.user_torrent_item_view_new, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        UserTorrent userTorrent = this.f390d.get(i10);
        aVar.f392u = userTorrent;
        boolean z10 = userTorrent.clicked;
        TextView textView = aVar.f394w;
        TextView textView2 = aVar.f395x;
        if (z10) {
            textView2.setAlpha(0.4f);
            textView.setAlpha(0.4f);
        } else {
            textView2.setAlpha(1.0f);
            textView.setAlpha(1.0f);
        }
        BaseProcessor.TorrentServiceType torrentServiceType = aVar.f392u.source_type;
        BaseProcessor.TorrentServiceType torrentServiceType2 = BaseProcessor.TorrentServiceType.PREMIUMIZE;
        Activity activity = this.f391e;
        TextView textView3 = aVar.f396y;
        if (torrentServiceType == torrentServiceType2) {
            textView2.setText("File ID: " + aVar.f392u.file_id + " - " + aVar.f392u.file_size_label);
            StringBuilder sb2 = new StringBuilder("PREMIUMIZE - ");
            sb2.append(aVar.f392u.status);
            textView3.setText(sb2.toString());
            String str = aVar.f392u.status;
            if (str == null || !str.equals("finished")) {
                textView3.setTextColor(activity.getResources().getColor(R.color.md_red_500));
            } else {
                textView3.setTextColor(activity.getResources().getColor(R.color.md_green_500));
            }
        } else if (torrentServiceType == BaseProcessor.TorrentServiceType.ALL_DEBRID) {
            textView2.setText("File ID: " + aVar.f392u.file_id + " - " + aVar.f392u.file_size_label);
            StringBuilder sb3 = new StringBuilder("ALLDEBRID - ");
            sb3.append(aVar.f392u.status);
            textView3.setText(sb3.toString());
            String str2 = aVar.f392u.status;
            if (str2 == null || !str2.equals("Ready")) {
                textView3.setTextColor(activity.getResources().getColor(R.color.md_red_500));
            } else {
                textView3.setTextColor(activity.getResources().getColor(R.color.md_green_500));
            }
        } else if (torrentServiceType == BaseProcessor.TorrentServiceType.REAL_DEBRID) {
            textView3.setText("REAL-DEBRID");
            textView3.setTextColor(activity.getResources().getColor(R.color.md_green_500));
            textView2.setText("File ID: " + aVar.f392u.file_id + " - " + aVar.f392u.file_size_label);
            StringBuilder sb4 = new StringBuilder("REAL-DEBRID - ");
            sb4.append(aVar.f392u.status);
            textView3.setText(sb4.toString());
            String str3 = aVar.f392u.status;
            if (str3 == null || !str3.contains("error")) {
                textView3.setTextColor(activity.getResources().getColor(R.color.md_green_500));
            } else {
                textView3.setTextColor(activity.getResources().getColor(R.color.md_red_500));
            }
        }
        textView2.setTextColor(-416706);
        if (aVar.f392u == null) {
            return;
        }
        b bVar = new b(this, aVar, 11);
        View view = aVar.f393v;
        view.setOnFocusChangeListener(bVar);
        textView.setText(aVar.f392u.filename);
        view.setOnClickListener(new ub.v(18, this, aVar));
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: ac.a0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return true;
            }
        });
    }
}
