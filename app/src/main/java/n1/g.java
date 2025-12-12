package n1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.f;
import java.lang.ref.WeakReference;

/* compiled from: EmojiTextWatcher.java */
/* loaded from: classes.dex */
public final class g implements TextWatcher {

    /* renamed from: b, reason: collision with root package name */
    public final EditText f16467b;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f16468m;

    /* renamed from: n, reason: collision with root package name */
    public a f16469n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f16470o = true;

    /* compiled from: EmojiTextWatcher.java */
    public static class a extends f.e {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f16471a;

        public a(EditText editText) {
            this.f16471a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.f.e
        public void onInitialized() {
            super.onInitialized();
            g.a((EditText) this.f16471a.get(), 1);
        }
    }

    public g(EditText editText, boolean z10) {
        this.f16467b = editText;
        this.f16468m = z10;
    }

    public static void a(EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.f.get().process(editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        EditText editText = this.f16467b;
        if (editText.isInEditMode()) {
            return;
        }
        if (!((this.f16470o && (this.f16468m || androidx.emoji2.text.f.isConfigured())) ? false : true) && i11 <= i12 && (charSequence instanceof Spannable)) {
            int loadState = androidx.emoji2.text.f.get().getLoadState();
            if (loadState != 0) {
                if (loadState == 1) {
                    androidx.emoji2.text.f.get().process((Spannable) charSequence, i10, i10 + i12, Integer.MAX_VALUE, 0);
                    return;
                } else if (loadState != 3) {
                    return;
                }
            }
            androidx.emoji2.text.f fVar = androidx.emoji2.text.f.get();
            if (this.f16469n == null) {
                this.f16469n = new a(editText);
            }
            fVar.registerInitCallback(this.f16469n);
        }
    }

    public void setEnabled(boolean z10) {
        if (this.f16470o != z10) {
            if (this.f16469n != null) {
                androidx.emoji2.text.f.get().unregisterInitCallback(this.f16469n);
            }
            this.f16470o = z10;
            if (z10) {
                a(this.f16467b, androidx.emoji2.text.f.get().getLoadState());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
