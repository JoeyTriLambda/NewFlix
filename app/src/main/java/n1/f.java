package n1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* compiled from: EmojiTextViewHelper.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final b f16462a;

    /* compiled from: EmojiTextViewHelper.java */
    public static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f16463a;

        /* renamed from: b, reason: collision with root package name */
        public final d f16464b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f16465c = true;

        public a(TextView textView) {
            this.f16463a = textView;
            this.f16464b = new d(textView);
        }

        @Override // n1.f.b
        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            if (!this.f16465c) {
                SparseArray sparseArray = new SparseArray(1);
                for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                    InputFilter inputFilter = inputFilterArr[i10];
                    if (inputFilter instanceof d) {
                        sparseArray.put(i10, inputFilter);
                    }
                }
                if (sparseArray.size() == 0) {
                    return inputFilterArr;
                }
                int length = inputFilterArr.length;
                InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
                int i11 = 0;
                for (int i12 = 0; i12 < length; i12++) {
                    if (sparseArray.indexOfKey(i12) < 0) {
                        inputFilterArr2[i11] = inputFilterArr[i12];
                        i11++;
                    }
                }
                return inputFilterArr2;
            }
            int length2 = inputFilterArr.length;
            int i13 = 0;
            while (true) {
                d dVar = this.f16464b;
                if (i13 >= length2) {
                    InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                    System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                    inputFilterArr3[length2] = dVar;
                    return inputFilterArr3;
                }
                if (inputFilterArr[i13] == dVar) {
                    return inputFilterArr;
                }
                i13++;
            }
        }

        @Override // n1.f.b
        public final void b(boolean z10) {
            if (z10) {
                TextView textView = this.f16463a;
                textView.setTransformationMethod(d(textView.getTransformationMethod()));
            }
        }

        @Override // n1.f.b
        public final void c(boolean z10) {
            this.f16465c = z10;
            TextView textView = this.f16463a;
            textView.setTransformationMethod(d(textView.getTransformationMethod()));
            textView.setFilters(a(textView.getFilters()));
        }

        @Override // n1.f.b
        public final TransformationMethod d(TransformationMethod transformationMethod) {
            return this.f16465c ? ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod) : transformationMethod instanceof h ? ((h) transformationMethod).getOriginalTransformationMethod() : transformationMethod;
        }

        @Override // n1.f.b
        public boolean isEnabled() {
            return this.f16465c;
        }
    }

    /* compiled from: EmojiTextViewHelper.java */
    public static class b {
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            throw null;
        }

        public void b(boolean z10) {
            throw null;
        }

        public void c(boolean z10) {
            throw null;
        }

        public TransformationMethod d(TransformationMethod transformationMethod) {
            throw null;
        }

        public boolean isEnabled() {
            throw null;
        }
    }

    /* compiled from: EmojiTextViewHelper.java */
    public static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        public final a f16466a;

        public c(TextView textView) {
            this.f16466a = new a(textView);
        }

        @Override // n1.f.b
        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            return androidx.emoji2.text.f.isConfigured() ^ true ? inputFilterArr : this.f16466a.a(inputFilterArr);
        }

        @Override // n1.f.b
        public final void b(boolean z10) {
            if (!androidx.emoji2.text.f.isConfigured()) {
                return;
            }
            this.f16466a.b(z10);
        }

        @Override // n1.f.b
        public final void c(boolean z10) {
            boolean z11 = !androidx.emoji2.text.f.isConfigured();
            a aVar = this.f16466a;
            if (z11) {
                aVar.f16465c = z10;
            } else {
                aVar.c(z10);
            }
        }

        @Override // n1.f.b
        public final TransformationMethod d(TransformationMethod transformationMethod) {
            return androidx.emoji2.text.f.isConfigured() ^ true ? transformationMethod : this.f16466a.d(transformationMethod);
        }

        @Override // n1.f.b
        public boolean isEnabled() {
            return this.f16466a.isEnabled();
        }
    }

    public f(TextView textView, boolean z10) {
        w0.h.checkNotNull(textView, "textView cannot be null");
        if (z10) {
            this.f16462a = new a(textView);
        } else {
            this.f16462a = new c(textView);
        }
    }

    public InputFilter[] getFilters(InputFilter[] inputFilterArr) {
        return this.f16462a.a(inputFilterArr);
    }

    public boolean isEnabled() {
        return this.f16462a.isEnabled();
    }

    public void setAllCaps(boolean z10) {
        this.f16462a.b(z10);
    }

    public void setEnabled(boolean z10) {
        this.f16462a.c(z10);
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
        return this.f16462a.d(transformationMethod);
    }
}
