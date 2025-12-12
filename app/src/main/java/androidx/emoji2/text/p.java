package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SpannableBuilder.java */
/* loaded from: classes.dex */
public final class p extends SpannableStringBuilder {

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f2660b;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f2661m;

    /* compiled from: SpannableBuilder.java */
    public static class a implements TextWatcher, SpanWatcher {

        /* renamed from: b, reason: collision with root package name */
        public final Object f2662b;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicInteger f2663m = new AtomicInteger(0);

        public a(Object obj) {
            this.f2662b = obj;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f2662b).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ((TextWatcher) this.f2662b).beforeTextChanged(charSequence, i10, i11, i12);
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i10, int i11) {
            if (this.f2663m.get() <= 0 || !(obj instanceof k)) {
                ((SpanWatcher) this.f2662b).onSpanAdded(spannable, obj, i10, i11);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x001c A[PHI: r11
  0x001c: PHI (r11v1 int) = (r11v0 int), (r11v3 int) binds: [B:8:0x0011, B:12:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.text.SpanWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onSpanChanged(android.text.Spannable r9, java.lang.Object r10, int r11, int r12, int r13, int r14) {
            /*
                r8 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r8.f2663m
                int r0 = r0.get()
                if (r0 <= 0) goto Ld
                boolean r0 = r10 instanceof androidx.emoji2.text.k
                if (r0 == 0) goto Ld
                return
            Ld:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 28
                if (r0 >= r1) goto L1c
                r0 = 0
                if (r11 <= r12) goto L17
                r11 = 0
            L17:
                if (r13 <= r14) goto L1c
                r4 = r11
                r6 = 0
                goto L1e
            L1c:
                r4 = r11
                r6 = r13
            L1e:
                java.lang.Object r11 = r8.f2662b
                r1 = r11
                android.text.SpanWatcher r1 = (android.text.SpanWatcher) r1
                r2 = r9
                r3 = r10
                r5 = r12
                r7 = r14
                r1.onSpanChanged(r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.p.a.onSpanChanged(android.text.Spannable, java.lang.Object, int, int, int, int):void");
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i10, int i11) {
            if (this.f2663m.get() <= 0 || !(obj instanceof k)) {
                ((SpanWatcher) this.f2662b).onSpanRemoved(spannable, obj, i10, i11);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ((TextWatcher) this.f2662b).onTextChanged(charSequence, i10, i11, i12);
        }
    }

    public p(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        this.f2661m = new ArrayList();
        w0.h.checkNotNull(cls, "watcherClass cannot be null");
        this.f2660b = cls;
    }

    public static p create(Class<?> cls, CharSequence charSequence) {
        return new p(cls, charSequence);
    }

    public final void a() {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f2661m;
            if (i10 >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i10)).f2663m.incrementAndGet();
            i10++;
        }
    }

    public final a b(Object obj) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f2661m;
            if (i10 >= arrayList.size()) {
                return null;
            }
            a aVar = (a) arrayList.get(i10);
            if (aVar.f2662b == obj) {
                return aVar;
            }
            i10++;
        }
    }

    public void beginBatchEdit() {
        a();
    }

    public final boolean c(Object obj) {
        if (obj != null) {
            return this.f2660b == obj.getClass();
        }
        return false;
    }

    public final void d() {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f2661m;
            if (i10 >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i10)).f2663m.decrementAndGet();
            i10++;
        }
    }

    public void endBatchEdit() {
        d();
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f2661m;
            if (i10 >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i10)).onTextChanged(this, 0, length(), length());
            i10++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        a aVarB;
        if (c(obj) && (aVarB = b(obj)) != null) {
            obj = aVarB;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        a aVarB;
        if (c(obj) && (aVarB = b(obj)) != null) {
            obj = aVarB;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        a aVarB;
        if (c(obj) && (aVarB = b(obj)) != null) {
            obj = aVarB;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        if (!(this.f2660b == cls)) {
            return (T[]) super.getSpans(i10, i11, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i10, i11, a.class);
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, aVarArr.length));
        for (int i12 = 0; i12 < aVarArr.length; i12++) {
            tArr[i12] = aVarArr[i12].f2662b;
        }
        return tArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000b  */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int nextSpanTransition(int r2, int r3, java.lang.Class r4) {
        /*
            r1 = this;
            if (r4 == 0) goto Lb
            java.lang.Class<?> r0 = r1.f2660b
            if (r0 != r4) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            if (r0 == 0) goto Ld
        Lb:
            java.lang.Class<androidx.emoji2.text.p$a> r4 = androidx.emoji2.text.p.a.class
        Ld:
            int r2 = super.nextSpanTransition(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.p.nextSpanTransition(int, int, java.lang.Class):int");
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        a aVarB;
        if (c(obj)) {
            aVarB = b(obj);
            if (aVarB != null) {
                obj = aVarB;
            }
        } else {
            aVarB = null;
        }
        super.removeSpan(obj);
        if (aVarB != null) {
            this.f2661m.remove(aVarB);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (c(obj)) {
            a aVar = new a(obj);
            this.f2661m.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i10, i11, i12);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i10, int i11) {
        return new p(this.f2660b, this, i10, i11);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i10, int i11) {
        super.delete(i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i10, CharSequence charSequence) {
        super.insert(i10, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i10, int i11, CharSequence charSequence) {
        a();
        super.replace(i10, i11, charSequence);
        d();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i10, CharSequence charSequence, int i11, int i12) {
        super.insert(i10, charSequence, i11, i12);
        return this;
    }

    public p(Class<?> cls, CharSequence charSequence, int i10, int i11) {
        super(charSequence, i10, i11);
        this.f2661m = new ArrayList();
        w0.h.checkNotNull(cls, "watcherClass cannot be null");
        this.f2660b = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i10, int i11, CharSequence charSequence, int i12, int i13) {
        a();
        super.replace(i10, i11, charSequence, i12, i13);
        d();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c10) {
        super.append(c10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11) {
        super.append(charSequence, i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i10) {
        super.append(charSequence, obj, i10);
        return this;
    }
}
