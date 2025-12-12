package androidx.recyclerview.widget;

import android.view.View;

/* compiled from: ViewBoundsCheck.java */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final b f4253a;

    /* renamed from: b, reason: collision with root package name */
    public final a f4254b = new a();

    /* compiled from: ViewBoundsCheck.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f4255a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f4256b;

        /* renamed from: c, reason: collision with root package name */
        public int f4257c;

        /* renamed from: d, reason: collision with root package name */
        public int f4258d;

        /* renamed from: e, reason: collision with root package name */
        public int f4259e;

        public final boolean a() {
            int i10 = this.f4255a;
            int i11 = 2;
            if ((i10 & 7) != 0) {
                int i12 = this.f4258d;
                int i13 = this.f4256b;
                if ((((i12 > i13 ? 1 : i12 == i13 ? 2 : 4) << 0) & i10) == 0) {
                    return false;
                }
            }
            if ((i10 & 112) != 0) {
                int i14 = this.f4258d;
                int i15 = this.f4257c;
                if ((((i14 > i15 ? 1 : i14 == i15 ? 2 : 4) << 4) & i10) == 0) {
                    return false;
                }
            }
            if ((i10 & 1792) != 0) {
                int i16 = this.f4259e;
                int i17 = this.f4256b;
                if ((((i16 > i17 ? 1 : i16 == i17 ? 2 : 4) << 8) & i10) == 0) {
                    return false;
                }
            }
            if ((i10 & 28672) != 0) {
                int i18 = this.f4259e;
                int i19 = this.f4257c;
                if (i18 > i19) {
                    i11 = 1;
                } else if (i18 != i19) {
                    i11 = 4;
                }
                if ((i10 & (i11 << 12)) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /* compiled from: ViewBoundsCheck.java */
    public interface b {
        View getChildAt(int i10);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    public w(b bVar) {
        this.f4253a = bVar;
    }

    public final View a(int i10, int i11, int i12, int i13) {
        b bVar = this.f4253a;
        int parentStart = bVar.getParentStart();
        int parentEnd = bVar.getParentEnd();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            View childAt = bVar.getChildAt(i10);
            int childStart = bVar.getChildStart(childAt);
            int childEnd = bVar.getChildEnd(childAt);
            a aVar = this.f4254b;
            aVar.f4256b = parentStart;
            aVar.f4257c = parentEnd;
            aVar.f4258d = childStart;
            aVar.f4259e = childEnd;
            if (i12 != 0) {
                aVar.f4255a = i12 | 0;
                if (aVar.a()) {
                    return childAt;
                }
            }
            if (i13 != 0) {
                aVar.f4255a = i13 | 0;
                if (aVar.a()) {
                    view = childAt;
                }
            }
            i10 += i14;
        }
        return view;
    }

    public final boolean b(View view) {
        b bVar = this.f4253a;
        int parentStart = bVar.getParentStart();
        int parentEnd = bVar.getParentEnd();
        int childStart = bVar.getChildStart(view);
        int childEnd = bVar.getChildEnd(view);
        a aVar = this.f4254b;
        aVar.f4256b = parentStart;
        aVar.f4257c = parentEnd;
        aVar.f4258d = childStart;
        aVar.f4259e = childEnd;
        aVar.f4255a = 24579 | 0;
        return aVar.a();
    }
}
