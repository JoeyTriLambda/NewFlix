package x0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;

/* compiled from: ContentInfoCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final f f21233a;

    /* compiled from: ContentInfoCompat.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC0311c f21234a;

        public a(ClipData clipData, int i10) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f21234a = new b(clipData, i10);
            } else {
                this.f21234a = new d(clipData, i10);
            }
        }

        public c build() {
            return this.f21234a.build();
        }

        public a setExtras(Bundle bundle) {
            this.f21234a.setExtras(bundle);
            return this;
        }

        public a setFlags(int i10) {
            this.f21234a.setFlags(i10);
            return this;
        }

        public a setLinkUri(Uri uri) {
            this.f21234a.setLinkUri(uri);
            return this;
        }
    }

    /* compiled from: ContentInfoCompat.java */
    public static final class b implements InterfaceC0311c {

        /* renamed from: a, reason: collision with root package name */
        public final ContentInfo.Builder f21235a;

        public b(ClipData clipData, int i10) {
            this.f21235a = new ContentInfo.Builder(clipData, i10);
        }

        @Override // x0.c.InterfaceC0311c
        public c build() {
            return new c(new e(this.f21235a.build()));
        }

        @Override // x0.c.InterfaceC0311c
        public void setExtras(Bundle bundle) {
            this.f21235a.setExtras(bundle);
        }

        @Override // x0.c.InterfaceC0311c
        public void setFlags(int i10) {
            this.f21235a.setFlags(i10);
        }

        @Override // x0.c.InterfaceC0311c
        public void setLinkUri(Uri uri) {
            this.f21235a.setLinkUri(uri);
        }
    }

    /* compiled from: ContentInfoCompat.java */
    /* renamed from: x0.c$c, reason: collision with other inner class name */
    public interface InterfaceC0311c {
        c build();

        void setExtras(Bundle bundle);

        void setFlags(int i10);

        void setLinkUri(Uri uri);
    }

    /* compiled from: ContentInfoCompat.java */
    public static final class d implements InterfaceC0311c {

        /* renamed from: a, reason: collision with root package name */
        public final ClipData f21236a;

        /* renamed from: b, reason: collision with root package name */
        public final int f21237b;

        /* renamed from: c, reason: collision with root package name */
        public int f21238c;

        /* renamed from: d, reason: collision with root package name */
        public Uri f21239d;

        /* renamed from: e, reason: collision with root package name */
        public Bundle f21240e;

        public d(ClipData clipData, int i10) {
            this.f21236a = clipData;
            this.f21237b = i10;
        }

        @Override // x0.c.InterfaceC0311c
        public c build() {
            return new c(new g(this));
        }

        @Override // x0.c.InterfaceC0311c
        public void setExtras(Bundle bundle) {
            this.f21240e = bundle;
        }

        @Override // x0.c.InterfaceC0311c
        public void setFlags(int i10) {
            this.f21238c = i10;
        }

        @Override // x0.c.InterfaceC0311c
        public void setLinkUri(Uri uri) {
            this.f21239d = uri;
        }
    }

    /* compiled from: ContentInfoCompat.java */
    public static final class e implements f {

        /* renamed from: a, reason: collision with root package name */
        public final ContentInfo f21241a;

        public e(ContentInfo contentInfo) {
            this.f21241a = (ContentInfo) w0.h.checkNotNull(contentInfo);
        }

        @Override // x0.c.f
        public ClipData getClip() {
            return this.f21241a.getClip();
        }

        @Override // x0.c.f
        public int getFlags() {
            return this.f21241a.getFlags();
        }

        @Override // x0.c.f
        public int getSource() {
            return this.f21241a.getSource();
        }

        @Override // x0.c.f
        public ContentInfo getWrapped() {
            return this.f21241a;
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f21241a + "}";
        }
    }

    /* compiled from: ContentInfoCompat.java */
    public interface f {
        ClipData getClip();

        int getFlags();

        int getSource();

        ContentInfo getWrapped();
    }

    /* compiled from: ContentInfoCompat.java */
    public static final class g implements f {

        /* renamed from: a, reason: collision with root package name */
        public final ClipData f21242a;

        /* renamed from: b, reason: collision with root package name */
        public final int f21243b;

        /* renamed from: c, reason: collision with root package name */
        public final int f21244c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri f21245d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f21246e;

        public g(d dVar) {
            this.f21242a = (ClipData) w0.h.checkNotNull(dVar.f21236a);
            this.f21243b = w0.h.checkArgumentInRange(dVar.f21237b, 0, 5, "source");
            this.f21244c = w0.h.checkFlagsArgument(dVar.f21238c, 1);
            this.f21245d = dVar.f21239d;
            this.f21246e = dVar.f21240e;
        }

        @Override // x0.c.f
        public ClipData getClip() {
            return this.f21242a;
        }

        @Override // x0.c.f
        public int getFlags() {
            return this.f21244c;
        }

        @Override // x0.c.f
        public int getSource() {
            return this.f21243b;
        }

        @Override // x0.c.f
        public ContentInfo getWrapped() {
            return null;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder("ContentInfoCompat{clip=");
            sb2.append(this.f21242a.getDescription());
            sb2.append(", source=");
            int i10 = this.f21243b;
            sb2.append(i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? String.valueOf(i10) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
            sb2.append(", flags=");
            int i11 = this.f21244c;
            sb2.append((i11 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i11));
            Uri uri = this.f21245d;
            if (uri == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + uri.toString().length() + ")";
            }
            sb2.append(str);
            return ac.c.o(sb2, this.f21246e != null ? ", hasExtras" : "", "}");
        }
    }

    public c(f fVar) {
        this.f21233a = fVar;
    }

    public static c toContentInfoCompat(ContentInfo contentInfo) {
        return new c(new e(contentInfo));
    }

    public ClipData getClip() {
        return this.f21233a.getClip();
    }

    public int getFlags() {
        return this.f21233a.getFlags();
    }

    public int getSource() {
        return this.f21233a.getSource();
    }

    public ContentInfo toContentInfo() {
        ContentInfo wrapped = this.f21233a.getWrapped();
        Objects.requireNonNull(wrapped);
        return wrapped;
    }

    public String toString() {
        return this.f21233a.toString();
    }
}
