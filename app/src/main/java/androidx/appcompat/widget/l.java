package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.R;
import x0.c;

/* compiled from: AppCompatEditText.java */
/* loaded from: classes.dex */
public class l extends EditText implements x0.x, d1.l {

    /* renamed from: b, reason: collision with root package name */
    public final e f1427b;

    /* renamed from: m, reason: collision with root package name */
    public final b0 f1428m;

    /* renamed from: n, reason: collision with root package name */
    public final a0 f1429n;

    /* renamed from: o, reason: collision with root package name */
    public final d1.j f1430o;

    /* renamed from: p, reason: collision with root package name */
    public final m f1431p;

    /* renamed from: q, reason: collision with root package name */
    public a f1432q;

    /* compiled from: AppCompatEditText.java */
    public class a {
        public a() {
        }

        public TextClassifier getTextClassifier() {
            return l.super.getTextClassifier();
        }

        public void setTextClassifier(TextClassifier textClassifier) {
            l.super.setTextClassifier(textClassifier);
        }
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    private a getSuperCaller() {
        if (this.f1432q == null) {
            this.f1432q = new a();
        }
        return this.f1432q;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1427b;
        if (eVar != null) {
            eVar.a();
        }
        b0 b0Var = this.f1428m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d1.i.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1427b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1427b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1428m.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1428m.e();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        a0 a0Var;
        return (Build.VERSION.SDK_INT >= 28 || (a0Var = this.f1429n) == null) ? getSuperCaller().getTextClassifier() : a0Var.getTextClassifier();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] onReceiveContentMimeTypes;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1428m.getClass();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 30 && inputConnectionOnCreateInputConnection != null) {
            c1.b.setInitialSurroundingText(editorInfo, getText());
        }
        c8.i.g(this, inputConnectionOnCreateInputConnection, editorInfo);
        if (inputConnectionOnCreateInputConnection != null && i10 <= 30 && (onReceiveContentMimeTypes = x0.j0.getOnReceiveContentMimeTypes(this)) != null) {
            c1.b.setContentMimeTypes(editorInfo, onReceiveContentMimeTypes);
            inputConnectionOnCreateInputConnection = c1.d.createWrapper(this, inputConnectionOnCreateInputConnection, editorInfo);
        }
        return this.f1431p.f1446b.onCreateInputConnection(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        int i10 = Build.VERSION.SDK_INT;
        boolean zA = false;
        if (i10 < 31 && i10 >= 24 && dragEvent.getLocalState() == null && x0.j0.getOnReceiveContentMimeTypes(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                zA = w.a(dragEvent, this, activity);
            }
        }
        if (zA) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // x0.x
    public x0.c onReceiveContent(x0.c cVar) {
        return this.f1430o.onReceiveContent(this, cVar);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i10) {
        if (Build.VERSION.SDK_INT < 31 && x0.j0.getOnReceiveContentMimeTypes(this) != null && (i10 == 16908322 || i10 == 16908337)) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                x0.j0.performReceiveContent(this, new c.a(primaryClip, 1).setFlags(i10 != 16908322 ? 1 : 0).build());
            }
            i = 1;
        }
        if (i != 0) {
            return true;
        }
        return super.onTextContextMenuItem(i10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1427b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f1427b;
        if (eVar != null) {
            eVar.f(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1428m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1428m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d1.i.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f1431p.f1446b.setEnabled(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1431p.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1427b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1427b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f1428m;
        b0Var.k(colorStateList);
        b0Var.b();
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f1428m;
        b0Var.l(mode);
        b0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        b0 b0Var = this.f1428m;
        if (b0Var != null) {
            b0Var.g(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        a0 a0Var;
        if (Build.VERSION.SDK_INT >= 28 || (a0Var = this.f1429n) == null) {
            getSuperCaller().setTextClassifier(textClassifier);
        } else {
            a0Var.setTextClassifier(textClassifier);
        }
    }

    public l(Context context, AttributeSet attributeSet, int i10) {
        super(z0.wrap(context), attributeSet, i10);
        x0.checkAppCompatTheme(this, getContext());
        e eVar = new e(this);
        this.f1427b = eVar;
        eVar.d(attributeSet, i10);
        b0 b0Var = new b0(this);
        this.f1428m = b0Var;
        b0Var.f(attributeSet, i10);
        b0Var.b();
        this.f1429n = new a0(this);
        this.f1430o = new d1.j();
        m mVar = new m(this);
        this.f1431p = mVar;
        mVar.b(attributeSet, i10);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = mVar.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
