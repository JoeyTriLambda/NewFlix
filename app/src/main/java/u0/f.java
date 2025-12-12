package u0;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;

/* compiled from: FontProvider.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final d f19932a = new d(0);

    /* compiled from: FontProvider.java */
    public interface a {
        void close();

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);
    }

    /* compiled from: FontProvider.java */
    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final ContentProviderClient f19933a;

        public b(Context context, Uri uri) {
            this.f19933a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // u0.f.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f19933a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }

        @Override // u0.f.a
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f19933a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e10) {
                Log.w("FontsProvider", "Unable to query the content provider", e10);
                return null;
            }
        }
    }

    /* compiled from: FontProvider.java */
    public static class c implements a {

        /* renamed from: a, reason: collision with root package name */
        public final ContentProviderClient f19934a;

        public c(Context context, Uri uri) {
            this.f19934a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // u0.f.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f19934a;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }

        @Override // u0.f.a
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f19934a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e10) {
                Log.w("FontsProvider", "Unable to query the content provider", e10);
                return null;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a A[LOOP:1: B:14:0x0057->B:29:0x009a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x009e A[EDGE_INSN: B:81:0x009e->B:31:0x009e BREAK  A[LOOP:1: B:14:0x0057->B:29:0x009a], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static u0.m.a a(android.content.Context r21, android.os.CancellationSignal r22, u0.g r23) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.f.a(android.content.Context, android.os.CancellationSignal, u0.g):u0.m$a");
    }
}
