package n1;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;

/* compiled from: EmojiKeyListener.java */
/* loaded from: classes.dex */
public final class e implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final KeyListener f16460a;

    /* renamed from: b, reason: collision with root package name */
    public final a f16461b;

    /* compiled from: EmojiKeyListener.java */
    public static class a {
        public boolean handleKeyDown(Editable editable, int i10, KeyEvent keyEvent) {
            return androidx.emoji2.text.f.handleOnKeyDown(editable, i10, keyEvent);
        }
    }

    public e(KeyListener keyListener) {
        a aVar = new a();
        this.f16460a = keyListener;
        this.f16461b = aVar;
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i10) {
        this.f16460a.clearMetaKeyState(view, editable, i10);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f16460a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i10, KeyEvent keyEvent) {
        return this.f16461b.handleKeyDown(editable, i10, keyEvent) || this.f16460a.onKeyDown(view, editable, i10, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f16460a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i10, KeyEvent keyEvent) {
        return this.f16460a.onKeyUp(view, editable, i10, keyEvent);
    }
}
