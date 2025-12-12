package n1;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* compiled from: EmojiEditTextHelper.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final C0205a f16448a;

    /* compiled from: EmojiEditTextHelper.java */
    /* renamed from: n1.a$a, reason: collision with other inner class name */
    public static class C0205a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final EditText f16449a;

        /* renamed from: b, reason: collision with root package name */
        public final g f16450b;

        public C0205a(EditText editText, boolean z10) {
            this.f16449a = editText;
            g gVar = new g(editText, z10);
            this.f16450b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(n1.b.getInstance());
        }
    }

    /* compiled from: EmojiEditTextHelper.java */
    public static class b {
    }

    public a(EditText editText, boolean z10) {
        w0.h.checkNotNull(editText, "editText cannot be null");
        this.f16448a = new C0205a(editText, z10);
    }

    public KeyListener getKeyListener(KeyListener keyListener) {
        this.f16448a.getClass();
        if (keyListener instanceof e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
    }

    public InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        C0205a c0205a = this.f16448a;
        c0205a.getClass();
        return inputConnection instanceof c ? inputConnection : new c(c0205a.f16449a, inputConnection, editorInfo);
    }

    public void setEnabled(boolean z10) {
        this.f16448a.f16450b.setEnabled(z10);
    }
}
