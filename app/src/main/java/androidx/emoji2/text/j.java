package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.util.SparseArray;
import android.view.KeyEvent;
import androidx.emoji2.text.f;
import androidx.emoji2.text.o;
import java.util.Arrays;

/* compiled from: EmojiProcessor.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final f.i f2627a;

    /* renamed from: b, reason: collision with root package name */
    public final o f2628b;

    /* renamed from: c, reason: collision with root package name */
    public final f.d f2629c;

    /* compiled from: EmojiProcessor.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f2630a = 1;

        /* renamed from: b, reason: collision with root package name */
        public final o.a f2631b;

        /* renamed from: c, reason: collision with root package name */
        public o.a f2632c;

        /* renamed from: d, reason: collision with root package name */
        public o.a f2633d;

        /* renamed from: e, reason: collision with root package name */
        public int f2634e;

        /* renamed from: f, reason: collision with root package name */
        public int f2635f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f2636g;

        /* renamed from: h, reason: collision with root package name */
        public final int[] f2637h;

        public a(o.a aVar, boolean z10, int[] iArr) {
            this.f2631b = aVar;
            this.f2632c = aVar;
            this.f2636g = z10;
            this.f2637h = iArr;
        }

        public final int a(int i10) {
            SparseArray<o.a> sparseArray = this.f2632c.f2658a;
            o.a aVar = sparseArray == null ? null : sparseArray.get(i10);
            int i11 = 2;
            if (this.f2630a != 2) {
                if (aVar == null) {
                    b();
                    i11 = 1;
                } else {
                    this.f2630a = 2;
                    this.f2632c = aVar;
                    this.f2635f = 1;
                }
            } else if (aVar != null) {
                this.f2632c = aVar;
                this.f2635f++;
            } else {
                if (i10 == 65038) {
                    b();
                } else {
                    if (!(i10 == 65039)) {
                        o.a aVar2 = this.f2632c;
                        if (aVar2.f2659b != null) {
                            if (this.f2635f != 1) {
                                this.f2633d = aVar2;
                                b();
                            } else if (c()) {
                                this.f2633d = this.f2632c;
                                b();
                            } else {
                                b();
                            }
                            i11 = 3;
                        } else {
                            b();
                        }
                    }
                }
                i11 = 1;
            }
            this.f2634e = i10;
            return i11;
        }

        public final void b() {
            this.f2630a = 1;
            this.f2632c = this.f2631b;
            this.f2635f = 0;
        }

        public final boolean c() {
            int[] iArr;
            if (this.f2632c.f2659b.isDefaultEmoji()) {
                return true;
            }
            if (this.f2634e == 65039) {
                return true;
            }
            return this.f2636g && ((iArr = this.f2637h) == null || Arrays.binarySearch(iArr, this.f2632c.f2659b.getCodepointAt(0)) < 0);
        }
    }

    public j(o oVar, f.i iVar, d dVar) {
        this.f2627a = iVar;
        this.f2628b = oVar;
        this.f2629c = dVar;
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z10) {
        k[] kVarArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!(selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd) && (kVarArr = (k[]) editable.getSpans(selectionStart, selectionEnd, k.class)) != null && kVarArr.length > 0) {
            for (k kVar : kVarArr) {
                int spanStart = editable.getSpanStart(kVar);
                int spanEnd = editable.getSpanEnd(kVar);
                if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b(CharSequence charSequence, int i10, int i11, i iVar) {
        if (iVar.getHasGlyph() == 0) {
            iVar.setHasGlyph(((d) this.f2629c).hasGlyph(charSequence, i10, i11, iVar.getSdkAdded()));
        }
        return iVar.getHasGlyph() == 2;
    }
}
