package androidx.emoji2.text;

import androidx.emoji2.text.f;

/* compiled from: EmojiCompat.java */
/* loaded from: classes.dex */
public final class e extends f.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.a f2595a;

    public e(f.a aVar) {
        this.f2595a = aVar;
    }

    @Override // androidx.emoji2.text.f.h
    public void onFailed(Throwable th2) {
        this.f2595a.f2609a.a(th2);
    }

    @Override // androidx.emoji2.text.f.h
    public void onLoaded(o oVar) {
        f.a aVar = this.f2595a;
        if (oVar == null) {
            aVar.f2609a.a(new IllegalArgumentException("metadataRepo cannot be null"));
            return;
        }
        aVar.f2608c = oVar;
        aVar.f2607b = new j(aVar.f2608c, new f.i(), aVar.f2609a.f2606i);
        aVar.f2609a.b();
    }
}
