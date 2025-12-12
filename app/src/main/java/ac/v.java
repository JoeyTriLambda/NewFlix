package ac;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.R;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import java.util.ArrayList;

/* compiled from: PlayerEpisodeAdapter.java */
/* loaded from: classes2.dex */
public final class v extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<hd.f> f581d;

    /* renamed from: e, reason: collision with root package name */
    public int f582e;

    /* renamed from: f, reason: collision with root package name */
    public final SimpleVideoPlayer f583f;

    /* compiled from: PlayerEpisodeAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public final TextView f584u;

        /* renamed from: v, reason: collision with root package name */
        public final View f585v;

        public a(v vVar, View view) {
            super(view);
            this.f585v = view;
            this.f584u = (TextView) view.findViewById(R.id.rowTextView);
        }
    }

    public v(SimpleVideoPlayer simpleVideoPlayer, ArrayList<hd.f> arrayList, int i10) {
        this.f582e = i10;
        this.f581d = arrayList;
        this.f583f = simpleVideoPlayer;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f581d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.episode_player_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        hd.f fVar = this.f581d.get(i10);
        aVar.getClass();
        aVar.f584u.setText(String.format("Episode %d", Integer.valueOf(fVar.f13001u)));
        ac.a aVar2 = new ac.a(this, i10, 4);
        View view = aVar.f585v;
        view.setOnClickListener(aVar2);
        int i11 = this.f582e;
        SimpleVideoPlayer simpleVideoPlayer = this.f583f;
        if (i10 == i11) {
            view.setBackgroundColor(simpleVideoPlayer.getResources().getColor(R.color.accent));
        } else {
            view.setBackgroundColor(simpleVideoPlayer.getResources().getColor(R.color.white));
        }
        view.setOnFocusChangeListener(new ub.b(6));
    }
}
