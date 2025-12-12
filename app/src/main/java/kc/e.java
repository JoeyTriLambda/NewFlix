package kc;

import ac.w;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.R;
import flix.com.vision.activities.SeriesDetailActivity;
import flix.com.vision.helpers.CenterLayoutManager;
import gd.k;
import hd.j;
import java.util.ArrayList;

/* compiled from: SeasonDialogFragment.java */
/* loaded from: classes2.dex */
public final class e extends DialogFragment implements k {

    /* renamed from: o, reason: collision with root package name */
    public static int f15070o;

    /* renamed from: p, reason: collision with root package name */
    public static Activity f15071p;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f15072b;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<j> f15073m;

    /* renamed from: n, reason: collision with root package name */
    public k f15074n;

    public static e newInstance(Activity activity, k kVar, ArrayList<j> arrayList, int i10) {
        e eVar = new e();
        f15071p = activity;
        f15070o = i10;
        eVar.f15074n = kVar;
        eVar.f15073m = arrayList;
        return eVar;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        onDismiss(dialogInterface);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.seasons_dialog_fragment, viewGroup, false);
        getDialog().getWindow().requestFeature(1);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recyclerview_seasons);
        this.f15072b = recyclerView;
        o1.a.h(18, recyclerView);
        this.f15072b.setLayoutManager(new CenterLayoutManager(f15071p, 1, false));
        this.f15072b.setAdapter(new w((SeriesDetailActivity) f15071p, this, this.f15073m, f15070o));
        setCancelable(true);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // gd.k
    public void openSeason(int i10) {
        k kVar = this.f15074n;
        if (kVar != null) {
            kVar.openSeason(i10);
        }
        dismiss();
    }
}
