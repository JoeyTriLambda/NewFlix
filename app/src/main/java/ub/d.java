package ub;

import android.content.DialogInterface;
import flix.com.vision.activities.AnimeSearchResultActivityClassic;

/* compiled from: AnimeSearchResultActivityClassic.java */
/* loaded from: classes2.dex */
public final class d implements DialogInterface.OnDismissListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnimeSearchResultActivityClassic f20164b;

    public d(AnimeSearchResultActivityClassic animeSearchResultActivityClassic) {
        this.f20164b = animeSearchResultActivityClassic;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f20164b.finish();
    }
}
