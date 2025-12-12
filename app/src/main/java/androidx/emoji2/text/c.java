package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import java.util.List;

/* compiled from: DefaultEmojiCompatConfig.java */
/* loaded from: classes.dex */
public final class c {

    /* compiled from: DefaultEmojiCompatConfig.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final b f2592a;

        public a(b bVar) {
            this.f2592a = bVar == null ? Build.VERSION.SDK_INT >= 28 ? new d() : new C0024c() : bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x003e A[EDGE_INSN: B:32:0x003e->B:16:0x003e BREAK  A[LOOP:0: B:3:0x001b->B:35:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[LOOP:0: B:3:0x001b->B:35:?, LOOP_END, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public androidx.emoji2.text.f.c create(android.content.Context r9) {
            /*
                r8 = this;
                android.content.pm.PackageManager r0 = r9.getPackageManager()
                java.lang.String r1 = "Package manager required to locate emoji font provider"
                w0.h.checkNotNull(r0, r1)
                android.content.Intent r1 = new android.content.Intent
                java.lang.String r2 = "androidx.content.action.LOAD_EMOJI_FONT"
                r1.<init>(r2)
                androidx.emoji2.text.c$b r2 = r8.f2592a
                r3 = 0
                java.util.List r1 = r2.queryIntentContentProviders(r0, r1, r3)
                java.util.Iterator r1 = r1.iterator()
            L1b:
                boolean r4 = r1.hasNext()
                r5 = 0
                if (r4 == 0) goto L3d
                java.lang.Object r4 = r1.next()
                android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
                android.content.pm.ProviderInfo r4 = r2.getProviderInfo(r4)
                if (r4 == 0) goto L39
                android.content.pm.ApplicationInfo r6 = r4.applicationInfo
                if (r6 == 0) goto L39
                int r6 = r6.flags
                r7 = 1
                r6 = r6 & r7
                if (r6 != r7) goto L39
                goto L3a
            L39:
                r7 = 0
            L3a:
                if (r7 == 0) goto L1b
                goto L3e
            L3d:
                r4 = r5
            L3e:
                if (r4 != 0) goto L42
            L40:
                r2 = r5
                goto L71
            L42:
                java.lang.String r1 = r4.authority     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
                java.lang.String r4 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
                android.content.pm.Signature[] r0 = r2.getSigningSignatures(r0, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
                r2.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
                int r6 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
            L50:
                if (r3 >= r6) goto L5e
                r7 = r0[r3]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
                byte[] r7 = r7.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
                r2.add(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
                int r3 = r3 + 1
                goto L50
            L5e:
                java.util.List r0 = java.util.Collections.singletonList(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
                u0.g r2 = new u0.g     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
                java.lang.String r3 = "emojicompat-emoji-font"
                r2.<init>(r1, r4, r3, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6a
                goto L71
            L6a:
                r0 = move-exception
                java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
                android.util.Log.wtf(r1, r0)
                goto L40
            L71:
                if (r2 != 0) goto L74
                goto L79
            L74:
                androidx.emoji2.text.l r5 = new androidx.emoji2.text.l
                r5.<init>(r9, r2)
            L79:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.c.a.create(android.content.Context):androidx.emoji2.text.f$c");
        }
    }

    /* compiled from: DefaultEmojiCompatConfig.java */
    public static class b {
        public ProviderInfo getProviderInfo(ResolveInfo resolveInfo) {
            throw null;
        }

        public Signature[] getSigningSignatures(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        public List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, int i10) {
            throw null;
        }
    }

    /* compiled from: DefaultEmojiCompatConfig.java */
    /* renamed from: androidx.emoji2.text.c$c, reason: collision with other inner class name */
    public static class C0024c extends b {
        @Override // androidx.emoji2.text.c.b
        public ProviderInfo getProviderInfo(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.emoji2.text.c.b
        public List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, int i10) {
            return packageManager.queryIntentContentProviders(intent, i10);
        }
    }

    /* compiled from: DefaultEmojiCompatConfig.java */
    public static class d extends C0024c {
        @Override // androidx.emoji2.text.c.b
        public Signature[] getSigningSignatures(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    public static l create(Context context) {
        return (l) new a(null).create(context);
    }
}
