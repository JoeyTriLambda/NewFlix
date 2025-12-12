package n1;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.f;
import java.lang.ref.WeakReference;

/* compiled from: EmojiInputFilter.java */
/* loaded from: classes.dex */
public final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f16456a;

    /* renamed from: b, reason: collision with root package name */
    public a f16457b;

    /* compiled from: EmojiInputFilter.java */
    public static class a extends f.e {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f16458a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference f16459b;

        public a(TextView textView, d dVar) {
            this.f16458a = new WeakReference(textView);
            this.f16459b = new WeakReference(dVar);
        }

        @Override // androidx.emoji2.text.f.e
        public void onInitialized() {
            CharSequence text;
            CharSequence charSequenceProcess;
            InputFilter[] filters;
            super.onInitialized();
            TextView textView = (TextView) this.f16458a.get();
            InputFilter inputFilter = (InputFilter) this.f16459b.get();
            boolean z10 = false;
            if (inputFilter != null && textView != null && (filters = textView.getFilters()) != null) {
                int i10 = 0;
                while (true) {
                    if (i10 >= filters.length) {
                        break;
                    }
                    if (filters[i10] == inputFilter) {
                        z10 = true;
                        break;
                    }
                    i10++;
                }
            }
            if (z10 && textView.isAttachedToWindow() && text != (charSequenceProcess = androidx.emoji2.text.f.get().process((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceProcess);
                int selectionEnd = Selection.getSelectionEnd(charSequenceProcess);
                textView.setText(charSequenceProcess);
                if (charSequenceProcess instanceof Spannable) {
                    Spannable spannable = (Spannable) charSequenceProcess;
                    if (selectionStart >= 0 && selectionEnd >= 0) {
                        Selection.setSelection(spannable, selectionStart, selectionEnd);
                    } else if (selectionStart >= 0) {
                        Selection.setSelection(spannable, selectionStart);
                    } else if (selectionEnd >= 0) {
                        Selection.setSelection(spannable, selectionEnd);
                    }
                }
            }
        }
    }

    public d(TextView textView) {
        this.f16456a = textView;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        TextView textView = this.f16456a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int loadState = androidx.emoji2.text.f.get().getLoadState();
        if (loadState != 0) {
            boolean z10 = true;
            if (loadState == 1) {
                if (i13 == 0 && i12 == 0 && spanned.length() == 0 && charSequence == textView.getText()) {
                    z10 = false;
                }
                if (!z10 || charSequence == null) {
                    return charSequence;
                }
                if (i10 != 0 || i11 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i10, i11);
                }
                return androidx.emoji2.text.f.get().process(charSequence, 0, charSequence.length());
            }
            if (loadState != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.f fVar = androidx.emoji2.text.f.get();
        if (this.f16457b == null) {
            this.f16457b = new a(textView, this);
        }
        fVar.registerInitCallback(this.f16457b);
        return charSequence;
    }
}
