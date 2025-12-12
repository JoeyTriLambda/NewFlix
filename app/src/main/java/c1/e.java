package c1;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* compiled from: InputContentInfoCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final c f5010a;

    /* compiled from: InputContentInfoCompat.java */
    public interface c {
        Uri getContentUri();

        ClipDescription getDescription();

        Object getInputContentInfo();

        Uri getLinkUri();

        void requestPermission();
    }

    public e(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f5010a = new a(uri, clipDescription, uri2);
        } else {
            this.f5010a = new b(uri, clipDescription, uri2);
        }
    }

    public static e wrap(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new e(new a(obj));
        }
        return null;
    }

    public Uri getContentUri() {
        return this.f5010a.getContentUri();
    }

    public ClipDescription getDescription() {
        return this.f5010a.getDescription();
    }

    public Uri getLinkUri() {
        return this.f5010a.getLinkUri();
    }

    public void requestPermission() {
        this.f5010a.requestPermission();
    }

    public Object unwrap() {
        return this.f5010a.getInputContentInfo();
    }

    /* compiled from: InputContentInfoCompat.java */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final InputContentInfo f5011a;

        public a(Object obj) {
            this.f5011a = (InputContentInfo) obj;
        }

        @Override // c1.e.c
        public Uri getContentUri() {
            return this.f5011a.getContentUri();
        }

        @Override // c1.e.c
        public ClipDescription getDescription() {
            return this.f5011a.getDescription();
        }

        @Override // c1.e.c
        public Object getInputContentInfo() {
            return this.f5011a;
        }

        @Override // c1.e.c
        public Uri getLinkUri() {
            return this.f5011a.getLinkUri();
        }

        @Override // c1.e.c
        public void requestPermission() {
            this.f5011a.requestPermission();
        }

        public a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f5011a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public e(a aVar) {
        this.f5010a = aVar;
    }

    /* compiled from: InputContentInfoCompat.java */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f5012a;

        /* renamed from: b, reason: collision with root package name */
        public final ClipDescription f5013b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f5014c;

        public b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f5012a = uri;
            this.f5013b = clipDescription;
            this.f5014c = uri2;
        }

        @Override // c1.e.c
        public Uri getContentUri() {
            return this.f5012a;
        }

        @Override // c1.e.c
        public ClipDescription getDescription() {
            return this.f5013b;
        }

        @Override // c1.e.c
        public Object getInputContentInfo() {
            return null;
        }

        @Override // c1.e.c
        public Uri getLinkUri() {
            return this.f5014c;
        }

        @Override // c1.e.c
        public void requestPermission() {
        }
    }
}
