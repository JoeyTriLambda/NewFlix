package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.q;

/* compiled from: ItemAlignment.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final a f3313a = new a(1);

    /* renamed from: b, reason: collision with root package name */
    public final a f3314b;

    /* renamed from: c, reason: collision with root package name */
    public a f3315c;

    /* compiled from: ItemAlignment.java */
    public static final class a extends q.a {

        /* renamed from: f, reason: collision with root package name */
        public final int f3316f;

        public a(int i10) {
            this.f3316f = i10;
        }

        public int getAlignmentPosition(View view) {
            return r.a(view, this, this.f3316f);
        }
    }

    public p() {
        a aVar = new a(0);
        this.f3314b = aVar;
        this.f3315c = aVar;
    }

    public final a mainAxis() {
        return this.f3315c;
    }

    public final void setOrientation(int i10) {
        if (i10 == 0) {
            this.f3315c = this.f3314b;
        } else {
            this.f3315c = this.f3313a;
        }
    }
}
