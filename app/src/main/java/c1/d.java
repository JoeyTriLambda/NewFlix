package c1;

import android.annotation.SuppressLint;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import w0.h;

/* compiled from: InputConnectionCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class d {

    /* compiled from: InputConnectionCompat.java */
    public class a extends InputConnectionWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f5008a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InputConnection inputConnection, c cVar) {
            super(inputConnection, false);
            this.f5008a = cVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i10, Bundle bundle) {
            if (((c1.c) this.f5008a).a(e.wrap(inputContentInfo), i10, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i10, bundle);
        }
    }

    /* compiled from: InputConnectionCompat.java */
    public class b extends InputConnectionWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f5009a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InputConnection inputConnection, c cVar) {
            super(inputConnection, false);
            this.f5009a = cVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String str, Bundle bundle) throws Throwable {
            boolean z10;
            ResultReceiver resultReceiver;
            c cVar = this.f5009a;
            boolean zA = false;
            zA = false;
            zA = false;
            zA = false;
            if (bundle != null) {
                if (!TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
                    z10 = TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str);
                }
                try {
                    resultReceiver = (ResultReceiver) bundle.getParcelable(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER");
                } catch (Throwable th2) {
                    th = th2;
                    resultReceiver = null;
                }
                try {
                    Uri uri = (Uri) bundle.getParcelable(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI");
                    ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION");
                    Uri uri2 = (Uri) bundle.getParcelable(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI");
                    int i10 = bundle.getInt(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS");
                    Bundle bundle2 = (Bundle) bundle.getParcelable(z10 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS");
                    if (uri != null && clipDescription != null) {
                        zA = ((c1.c) cVar).a(new e(uri, clipDescription, uri2), i10, bundle2);
                    }
                    if (resultReceiver != null) {
                        resultReceiver.send(zA ? 1 : 0, null);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (resultReceiver != null) {
                        resultReceiver.send(0, null);
                    }
                    throw th;
                }
            }
            if (zA) {
                return true;
            }
            return super.performPrivateCommand(str, bundle);
        }
    }

    /* compiled from: InputConnectionCompat.java */
    public interface c {
    }

    @Deprecated
    public static InputConnection createWrapper(InputConnection inputConnection, EditorInfo editorInfo, c cVar) {
        w0.c.requireNonNull(inputConnection, "inputConnection must be non-null");
        w0.c.requireNonNull(editorInfo, "editorInfo must be non-null");
        w0.c.requireNonNull(cVar, "onCommitContentListener must be non-null");
        return Build.VERSION.SDK_INT >= 25 ? new a(inputConnection, cVar) : c1.b.getContentMimeTypes(editorInfo).length == 0 ? inputConnection : new b(inputConnection, cVar);
    }

    public static InputConnection createWrapper(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        h.checkNotNull(view);
        return createWrapper(inputConnection, editorInfo, new c1.c(view, 0));
    }
}
