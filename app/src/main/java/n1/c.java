package n1;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;

/* compiled from: EmojiInputConnection.java */
/* loaded from: classes.dex */
public final class c extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f16454a;

    /* renamed from: b, reason: collision with root package name */
    public final a f16455b;

    /* compiled from: EmojiInputConnection.java */
    public static class a {
        public boolean handleDeleteSurroundingText(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
            return androidx.emoji2.text.f.handleDeleteSurroundingText(inputConnection, editable, i10, i11, z10);
        }

        public void updateEditorInfoAttrs(EditorInfo editorInfo) {
            if (androidx.emoji2.text.f.isConfigured()) {
                androidx.emoji2.text.f.get().updateEditorInfo(editorInfo);
            }
        }
    }

    public c(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        a aVar = new a();
        super(inputConnection, false);
        this.f16454a = editText;
        this.f16455b = aVar;
        aVar.updateEditorInfoAttrs(editorInfo);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i10, int i11) {
        return this.f16455b.handleDeleteSurroundingText(this, this.f16454a.getEditableText(), i10, i11, false) || super.deleteSurroundingText(i10, i11);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i10, int i11) {
        return this.f16455b.handleDeleteSurroundingText(this, this.f16454a.getEditableText(), i10, i11, true) || super.deleteSurroundingTextInCodePoints(i10, i11);
    }
}
