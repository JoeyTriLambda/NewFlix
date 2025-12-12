package ub;

import android.content.DialogInterface;
import flix.com.vision.activities.AnimeSearchResultActivityClassic;

/* compiled from: AnimeSearchResultActivityClassic.java */
/* loaded from: classes2.dex */
public final class c implements DialogInterface.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnimeSearchResultActivityClassic f20159b;

    public c(AnimeSearchResultActivityClassic animeSearchResultActivityClassic) {
        this.f20159b = animeSearchResultActivityClassic;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        this.f20159b.finish();
    }
}
