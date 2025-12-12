package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: EmojiCompat.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f2596j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static volatile f f2597k;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f2598a;

    /* renamed from: b, reason: collision with root package name */
    public final b0.d f2599b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f2600c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f2601d;

    /* renamed from: e, reason: collision with root package name */
    public final a f2602e;

    /* renamed from: f, reason: collision with root package name */
    public final g f2603f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2604g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2605h;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.emoji2.text.d f2606i;

    /* compiled from: EmojiCompat.java */
    public static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        public volatile j f2607b;

        /* renamed from: c, reason: collision with root package name */
        public volatile o f2608c;

        public a(f fVar) {
            super(fVar);
        }
    }

    /* compiled from: EmojiCompat.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final f f2609a;

        public b(f fVar) {
            this.f2609a = fVar;
        }
    }

    /* compiled from: EmojiCompat.java */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final g f2610a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2611b = -16711936;

        /* renamed from: c, reason: collision with root package name */
        public int f2612c = 0;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.emoji2.text.d f2613d = new androidx.emoji2.text.d();

        public c(g gVar) {
            w0.h.checkNotNull(gVar, "metadataLoader cannot be null.");
            this.f2610a = gVar;
        }

        public final g getMetadataRepoLoader() {
            return this.f2610a;
        }

        public c setMetadataLoadStrategy(int i10) {
            this.f2612c = i10;
            return this;
        }
    }

    /* compiled from: EmojiCompat.java */
    public interface d {
    }

    /* compiled from: EmojiCompat.java */
    /* renamed from: androidx.emoji2.text.f$f, reason: collision with other inner class name */
    public static class RunnableC0025f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f2614b;

        /* renamed from: m, reason: collision with root package name */
        public final Throwable f2615m;

        /* renamed from: n, reason: collision with root package name */
        public final int f2616n;

        public RunnableC0025f(List list, int i10, Throwable th2) {
            w0.h.checkNotNull(list, "initCallbacks cannot be null");
            this.f2614b = new ArrayList(list);
            this.f2616n = i10;
            this.f2615m = th2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = this.f2614b;
            int size = arrayList.size();
            int i10 = 0;
            if (this.f2616n != 1) {
                while (i10 < size) {
                    ((e) arrayList.get(i10)).onFailed(this.f2615m);
                    i10++;
                }
            } else {
                while (i10 < size) {
                    ((e) arrayList.get(i10)).onInitialized();
                    i10++;
                }
            }
        }
    }

    /* compiled from: EmojiCompat.java */
    public interface g {
        void load(h hVar);
    }

    /* compiled from: EmojiCompat.java */
    public static abstract class h {
        public abstract void onFailed(Throwable th2);

        public abstract void onLoaded(o oVar);
    }

    /* compiled from: EmojiCompat.java */
    public static class i {
    }

    public f(c cVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f2598a = reentrantReadWriteLock;
        this.f2600c = 3;
        cVar.getClass();
        this.f2604g = cVar.f2611b;
        g gVar = cVar.f2610a;
        this.f2603f = gVar;
        int i10 = cVar.f2612c;
        this.f2605h = i10;
        this.f2606i = cVar.f2613d;
        this.f2601d = new Handler(Looper.getMainLooper());
        this.f2599b = new b0.d();
        a aVar = new a(this);
        this.f2602e = aVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i10 == 0) {
            try {
                this.f2600c = 0;
            } catch (Throwable th2) {
                this.f2598a.writeLock().unlock();
                throw th2;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (getLoadState() == 0) {
            try {
                gVar.load(new androidx.emoji2.text.e(aVar));
            } catch (Throwable th3) {
                a(th3);
            }
        }
    }

    public static f get() {
        f fVar;
        synchronized (f2596j) {
            fVar = f2597k;
            w0.h.checkState(fVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x004e, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x008b, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00a9 A[EDGE_INSN: B:96:0x00a9->B:72:0x00a9 BREAK  A[LOOP:2: B:53:0x0077->B:64:0x008e, LOOP_LABEL: LOOP:2: B:53:0x0077->B:64:0x008e], EDGE_INSN: B:99:0x00a9->B:72:0x00a9 BREAK  A[LOOP:2: B:53:0x0077->B:64:0x008e]] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ac A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean handleDeleteSurroundingText(android.view.inputmethod.InputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.f.handleDeleteSurroundingText(android.view.inputmethod.InputConnection, android.text.Editable, int, int, boolean):boolean");
    }

    public static boolean handleOnKeyDown(Editable editable, int i10, KeyEvent keyEvent) {
        if (!(i10 != 67 ? i10 != 112 ? false : j.a(editable, keyEvent, true) : j.a(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    public static f init(c cVar) {
        f fVar = f2597k;
        if (fVar == null) {
            synchronized (f2596j) {
                fVar = f2597k;
                if (fVar == null) {
                    fVar = new f(cVar);
                    f2597k = fVar;
                }
            }
        }
        return fVar;
    }

    public static boolean isConfigured() {
        return f2597k != null;
    }

    public final void a(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        this.f2598a.writeLock().lock();
        try {
            this.f2600c = 2;
            arrayList.addAll(this.f2599b);
            this.f2599b.clear();
            this.f2598a.writeLock().unlock();
            this.f2601d.post(new RunnableC0025f(arrayList, this.f2600c, th2));
        } catch (Throwable th3) {
            this.f2598a.writeLock().unlock();
            throw th3;
        }
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f2598a.writeLock().lock();
        try {
            this.f2600c = 1;
            arrayList.addAll(this.f2599b);
            this.f2599b.clear();
            this.f2598a.writeLock().unlock();
            this.f2601d.post(new RunnableC0025f(arrayList, this.f2600c, null));
        } catch (Throwable th2) {
            this.f2598a.writeLock().unlock();
            throw th2;
        }
    }

    public int getEmojiSpanIndicatorColor() {
        return this.f2604g;
    }

    public int getLoadState() {
        this.f2598a.readLock().lock();
        try {
            return this.f2600c;
        } finally {
            this.f2598a.readLock().unlock();
        }
    }

    public boolean isEmojiSpanIndicatorEnabled() {
        return false;
    }

    public void load() {
        w0.h.checkState(this.f2605h == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (getLoadState() == 1) {
            return;
        }
        this.f2598a.writeLock().lock();
        try {
            if (this.f2600c == 0) {
                return;
            }
            this.f2600c = 0;
            this.f2598a.writeLock().unlock();
            a aVar = this.f2602e;
            f fVar = aVar.f2609a;
            try {
                fVar.f2603f.load(new androidx.emoji2.text.e(aVar));
            } catch (Throwable th2) {
                fVar.a(th2);
            }
        } finally {
            this.f2598a.writeLock().unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01b1 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.CharSequence process(java.lang.CharSequence r18, int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.f.process(java.lang.CharSequence, int, int, int, int):java.lang.CharSequence");
    }

    public void registerInitCallback(e eVar) {
        w0.h.checkNotNull(eVar, "initCallback cannot be null");
        this.f2598a.writeLock().lock();
        try {
            if (this.f2600c == 1 || this.f2600c == 2) {
                this.f2601d.post(new RunnableC0025f(Arrays.asList((e) w0.h.checkNotNull(eVar, "initCallback cannot be null")), this.f2600c, null));
            } else {
                this.f2599b.add(eVar);
            }
        } finally {
            this.f2598a.writeLock().unlock();
        }
    }

    public void unregisterInitCallback(e eVar) {
        w0.h.checkNotNull(eVar, "initCallback cannot be null");
        ReentrantReadWriteLock reentrantReadWriteLock = this.f2598a;
        reentrantReadWriteLock.writeLock().lock();
        try {
            this.f2599b.remove(eVar);
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public void updateEditorInfo(EditorInfo editorInfo) {
        if (!(getLoadState() == 1) || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        a aVar = this.f2602e;
        aVar.getClass();
        editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", aVar.f2608c.f2654a.version());
        Bundle bundle = editorInfo.extras;
        aVar.f2609a.getClass();
        bundle.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }

    /* compiled from: EmojiCompat.java */
    public static abstract class e {
        public void onInitialized() {
        }

        public void onFailed(Throwable th2) {
        }
    }

    public CharSequence process(CharSequence charSequence) {
        return process(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence process(CharSequence charSequence, int i10, int i11) {
        return process(charSequence, i10, i11, Integer.MAX_VALUE);
    }

    public CharSequence process(CharSequence charSequence, int i10, int i11, int i12) {
        return process(charSequence, i10, i11, i12, 0);
    }
}
