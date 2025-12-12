package ub;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import flix.com.vision.App;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class s0 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20267b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ kc.d f20268m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ wb.a f20269n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f20270o;

    public /* synthetic */ s0(wb.a aVar, kc.d dVar, Object obj, int i10) {
        this.f20267b = i10;
        this.f20269n = aVar;
        this.f20268m = dVar;
        this.f20270o = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20267b;
        kc.d dVar = this.f20268m;
        Object obj = this.f20270o;
        wb.a aVar = this.f20269n;
        switch (i10) {
            case 0:
                MainActivity mainActivity = (MainActivity) aVar;
                FragmentManager fragmentManager = (FragmentManager) obj;
                int i11 = MainActivity.f11697v0;
                mainActivity.getClass();
                dVar.dismiss();
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra("android.intent.extra.EMAIL", "info@flixvision.tv");
                intent.putExtra("android.intent.extra.SUBJECT", "Flix Vision App");
                if (intent.resolveActivity(mainActivity.getPackageManager()) != null) {
                    mainActivity.startActivity(intent);
                }
                try {
                    dVar.show(fragmentManager, "");
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
                String str = Constant.f12450b;
                editorEdit.putBoolean("discord_check", true).apply();
                break;
            default:
                SearchActivityTV searchActivityTV = (SearchActivityTV) aVar;
                Movie movie = (Movie) obj;
                int i12 = SearchActivityTV.f11775j0;
                searchActivityTV.getClass();
                dVar.dismiss();
                if (movie != null) {
                    searchActivityTV.openMovieintent(movie);
                    break;
                }
                break;
        }
    }
}
