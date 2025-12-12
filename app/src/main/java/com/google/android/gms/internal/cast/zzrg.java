package com.google.android.gms.internal.cast;

import e8.c;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzrg<V> extends zzsf implements c<V> {
    static final boolean zza;
    private static final Logger zzb;
    private static final zza zzc;
    private static final Object zzd;
    private volatile zzd listeners;
    private volatile Object value;
    private volatile zzk waiters;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    abstract class zza {
        public /* synthetic */ zza(zzrf zzrfVar) {
        }

        public abstract zzd zza(zzrg zzrgVar, zzd zzdVar);

        public abstract zzk zzb(zzrg zzrgVar, zzk zzkVar);

        public abstract void zzc(zzk zzkVar, zzk zzkVar2);

        public abstract void zzd(zzk zzkVar, Thread thread);

        public abstract boolean zze(zzrg zzrgVar, zzd zzdVar, zzd zzdVar2);

        public abstract boolean zzf(zzrg zzrgVar, Object obj, Object obj2);

        public abstract boolean zzg(zzrg zzrgVar, zzk zzkVar, zzk zzkVar2);
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    final class zzb {
        static final zzb zza;
        static final zzb zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzrg.zza) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        public zzb(boolean z10, Throwable th2) {
            this.zzc = z10;
            this.zzd = th2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.cast.zzrg.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        public zzc(Throwable th2) {
            th2.getClass();
            this.zzb = th2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        public zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        public zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<zzrg, zzk> zzc;
        final AtomicReferenceFieldUpdater<zzrg, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzrg, Object> zze;

        public zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final zzd zza(zzrg zzrgVar, zzd zzdVar) {
            return this.zzd.getAndSet(zzrgVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final zzk zzb(zzrg zzrgVar, zzk zzkVar) {
            return this.zzc.getAndSet(zzrgVar, zzkVar);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final void zzc(zzk zzkVar, zzk zzkVar2) {
            this.zzb.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final void zzd(zzk zzkVar, Thread thread) {
            this.zza.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final boolean zze(zzrg zzrgVar, zzd zzdVar, zzd zzdVar2) {
            return zzrh.zza(this.zzd, zzrgVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final boolean zzf(zzrg zzrgVar, Object obj, Object obj2) {
            return zzrh.zza(this.zze, zzrgVar, obj, obj2);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final boolean zzg(zzrg zzrgVar, zzk zzkVar, zzk zzkVar2) {
            return zzrh.zza(this.zzc, zzrgVar, zzkVar, zzkVar2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    final class zzf<V> implements Runnable {
        final zzrg<V> zza;
        final c<? extends V> zzb;

        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    final class zzg extends zza {
        public /* synthetic */ zzg(zzri zzriVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final zzd zza(zzrg zzrgVar, zzd zzdVar) {
            zzd zzdVar2;
            synchronized (zzrgVar) {
                zzdVar2 = zzrgVar.listeners;
                if (zzdVar2 != zzdVar) {
                    zzrgVar.listeners = zzdVar;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final zzk zzb(zzrg zzrgVar, zzk zzkVar) {
            zzk zzkVar2;
            synchronized (zzrgVar) {
                zzkVar2 = zzrgVar.waiters;
                if (zzkVar2 != zzkVar) {
                    zzrgVar.waiters = zzkVar;
                }
            }
            return zzkVar2;
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final void zzc(zzk zzkVar, zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final void zzd(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final boolean zze(zzrg zzrgVar, zzd zzdVar, zzd zzdVar2) {
            synchronized (zzrgVar) {
                if (zzrgVar.listeners != zzdVar) {
                    return false;
                }
                zzrgVar.listeners = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final boolean zzf(zzrg zzrgVar, Object obj, Object obj2) {
            synchronized (zzrgVar) {
                if (zzrgVar.value != obj) {
                    return false;
                }
                zzrgVar.value = obj2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final boolean zzg(zzrg zzrgVar, zzk zzkVar, zzk zzkVar2) {
            synchronized (zzrgVar) {
                if (zzrgVar.waiters != zzkVar) {
                    return false;
                }
                zzrgVar.waiters = zzkVar2;
                return true;
            }
        }

        private zzg() {
            super(null);
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    interface zzh<V> extends c<V> {
        @Override // e8.c
        /* synthetic */ void addListener(Runnable runnable, Executor executor);
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    abstract class zzi<V> extends zzrg<V> implements zzh<V> {
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.cast.zzrg.zzj.1
                        @Override // java.security.PrivilegedExceptionAction
                        public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
                try {
                    zzc = unsafe.objectFieldOffset(zzrg.class.getDeclaredField("waiters"));
                    zzb = unsafe.objectFieldOffset(zzrg.class.getDeclaredField("listeners"));
                    zzd = unsafe.objectFieldOffset(zzrg.class.getDeclaredField("value"));
                    zze = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                    zzf = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                    zza = unsafe;
                } catch (NoSuchFieldException e10) {
                    throw new RuntimeException(e10);
                } catch (RuntimeException e11) {
                    throw e11;
                }
            } catch (PrivilegedActionException e12) {
                throw new RuntimeException("Could not initialize intrinsics", e12.getCause());
            }
        }

        public /* synthetic */ zzj(zzrk zzrkVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final zzd zza(zzrg zzrgVar, zzd zzdVar) {
            zzd zzdVar2;
            do {
                zzdVar2 = zzrgVar.listeners;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzrgVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final zzk zzb(zzrg zzrgVar, zzk zzkVar) {
            zzk zzkVar2;
            do {
                zzkVar2 = zzrgVar.waiters;
                if (zzkVar == zzkVar2) {
                    break;
                }
            } while (!zzg(zzrgVar, zzkVar2, zzkVar));
            return zzkVar2;
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final void zzc(zzk zzkVar, zzk zzkVar2) {
            zza.putObject(zzkVar, zzf, zzkVar2);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final void zzd(zzk zzkVar, Thread thread) {
            zza.putObject(zzkVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final boolean zze(zzrg zzrgVar, zzd zzdVar, zzd zzdVar2) {
            return zzrj.zza(zza, zzrgVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final boolean zzf(zzrg zzrgVar, Object obj, Object obj2) {
            return zzrj.zza(zza, zzrgVar, zzd, obj, obj2);
        }

        @Override // com.google.android.gms.internal.cast.zzrg.zza
        public final boolean zzg(zzrg zzrgVar, zzk zzkVar, zzk zzkVar2) {
            return zzrj.zza(zza, zzrgVar, zzc, zzkVar, zzkVar2);
        }

        private zzj() {
            super(null);
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    final class zzk {
        static final zzk zza = new zzk(false);
        volatile zzk next;
        volatile Thread thread;

        public zzk() {
            zzrg.zzc.zzd(this, Thread.currentThread());
        }

        public zzk(boolean z10) {
        }
    }

    static {
        boolean z10;
        Throwable th2;
        Throwable th3;
        zza zzgVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        zza = z10;
        zzb = Logger.getLogger(zzrg.class.getName());
        byte b10 = 0;
        try {
            zzgVar = new zzj(null);
            th3 = null;
            th2 = null;
        } catch (Error | RuntimeException e10) {
            try {
                th2 = null;
                th3 = e10;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzrg.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzrg.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzrg.class, Object.class, "value"));
            } catch (Error | RuntimeException e11) {
                th2 = e11;
                th3 = e10;
                zzgVar = new zzg(b10 == true ? 1 : 0);
            }
        }
        zzc = zzgVar;
        if (th2 != null) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th3);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
        zzd = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object zzn(c cVar) {
        Throwable thZzf;
        if (cVar instanceof zzh) {
            Object zzbVar = ((zzrg) cVar).value;
            if (zzbVar instanceof zzb) {
                zzb zzbVar2 = (zzb) zzbVar;
                if (zzbVar2.zzc) {
                    Throwable th2 = zzbVar2.zzd;
                    zzbVar = th2 != null ? new zzb(false, th2) : zzb.zzb;
                }
            }
            zzbVar.getClass();
            return zzbVar;
        }
        if ((cVar instanceof zzsf) && (thZzf = ((zzsf) cVar).zzf()) != null) {
            return new zzc(thZzf);
        }
        boolean zIsCancelled = cVar.isCancelled();
        if ((!zza) && zIsCancelled) {
            zzb zzbVar3 = zzb.zzb;
            zzbVar3.getClass();
            return zzbVar3;
        }
        try {
            Object objZzo = zzo(cVar);
            return zIsCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(cVar)))) : objZzo == null ? zzd : objZzo;
        } catch (Error e10) {
            e = e10;
            return new zzc(e);
        } catch (CancellationException e11) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(cVar)), e11)) : new zzb(false, e11);
        } catch (RuntimeException e12) {
            e = e12;
            return new zzc(e);
        } catch (ExecutionException e13) {
            return zIsCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(cVar)), e13)) : new zzc(e13.getCause());
        }
    }

    private static Object zzo(Future future) throws ExecutionException {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void zzp(StringBuilder sb2) {
        try {
            Object objZzo = zzo(this);
            sb2.append("SUCCESS, result=[");
            if (objZzo == null) {
                sb2.append("null");
            } else if (objZzo == this) {
                sb2.append("this future");
            } else {
                sb2.append(objZzo.getClass().getName());
                sb2.append("@");
                sb2.append(Integer.toHexString(System.identityHashCode(objZzo)));
            }
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e10.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        }
    }

    private final void zzq(StringBuilder sb2) {
        String strConcat;
        int length = sb2.length();
        sb2.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb2.append(", setFuture=[");
            zzr(sb2, ((zzf) obj).zzb);
            sb2.append("]");
        } else {
            try {
                strConcat = zzfb.zza(zze());
            } catch (RuntimeException | StackOverflowError e10) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(e10.getClass()));
            }
            if (strConcat != null) {
                sb2.append(", info=[");
                sb2.append(strConcat);
                sb2.append("]");
            }
        }
        if (isDone()) {
            sb2.delete(length, sb2.length());
            zzp(sb2);
        }
    }

    private final void zzr(StringBuilder sb2, Object obj) {
        try {
            if (obj == this) {
                sb2.append("this future");
            } else {
                sb2.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e10) {
            sb2.append("Exception thrown from implementation: ");
            sb2.append(e10.getClass());
        }
    }

    private static void zzs(zzrg zzrgVar, boolean z10) {
        zzd zzdVar;
        zzd zzdVar2 = null;
        while (true) {
            for (zzk zzkVarZzb = zzc.zzb(zzrgVar, zzk.zza); zzkVarZzb != null; zzkVarZzb = zzkVarZzb.next) {
                Thread thread = zzkVarZzb.thread;
                if (thread != null) {
                    zzkVarZzb.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            zzrgVar.zzj();
            zzd zzdVar3 = zzdVar2;
            zzd zzdVarZza = zzc.zza(zzrgVar, zzd.zza);
            zzd zzdVar4 = zzdVar3;
            while (zzdVarZza != null) {
                zzd zzdVar5 = zzdVarZza.next;
                zzdVarZza.next = zzdVar4;
                zzdVar4 = zzdVarZza;
                zzdVarZza = zzdVar5;
            }
            while (zzdVar4 != null) {
                Runnable runnable = zzdVar4.zzb;
                zzdVar = zzdVar4.next;
                runnable.getClass();
                if (runnable instanceof zzf) {
                    zzf zzfVar = (zzf) runnable;
                    zzrgVar = zzfVar.zza;
                    if (zzrgVar.value == zzfVar) {
                        if (zzc.zzf(zzrgVar, zzfVar, zzn(zzfVar.zzb))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzdVar4.zzc;
                    executor.getClass();
                    zzt(runnable, executor);
                }
                zzdVar4 = zzdVar;
            }
            return;
            zzdVar2 = zzdVar;
        }
    }

    private static void zzt(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            zzb.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e10);
        }
    }

    private final void zzu(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 != zzk.zza) {
                zzk zzkVar3 = null;
                while (zzkVar2 != null) {
                    zzk zzkVar4 = zzkVar2.next;
                    if (zzkVar2.thread != null) {
                        zzkVar3 = zzkVar2;
                    } else if (zzkVar3 != null) {
                        zzkVar3.next = zzkVar4;
                        if (zzkVar3.thread == null) {
                            break;
                        }
                    } else if (!zzc.zzg(this, zzkVar2, zzkVar4)) {
                        break;
                    }
                    zzkVar2 = zzkVar4;
                }
                return;
            }
            return;
        }
    }

    private static final Object zzv(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th2 = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th2);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzd) {
            return null;
        }
        return obj;
    }

    @Override // e8.c
    public final void addListener(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzez.zzc(runnable, "Runnable was null.");
        zzez.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listeners) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzc.zze(this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listeners;
                }
            } while (zzdVar != zzd.zza);
        }
        zzt(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        zzb zzbVar;
        Object obj = this.value;
        if (!(obj instanceof zzf) && !(obj == null)) {
            return false;
        }
        if (zza) {
            zzbVar = new zzb(z10, new CancellationException("Future.cancel() was called."));
        } else {
            zzbVar = z10 ? zzb.zza : zzb.zzb;
            zzbVar.getClass();
        }
        boolean z11 = false;
        zzrg<V> zzrgVar = this;
        while (true) {
            if (zzc.zzf(zzrgVar, obj, zzbVar)) {
                zzs(zzrgVar, z10);
                if (!(obj instanceof zzf)) {
                    break;
                }
                c<? extends V> cVar = ((zzf) obj).zzb;
                if (!(cVar instanceof zzh)) {
                    cVar.cancel(z10);
                    break;
                }
                zzrgVar = (zzrg) cVar;
                obj = zzrgVar.value;
                if (!(obj == null) && !(obj instanceof zzf)) {
                    break;
                }
                z11 = true;
            } else {
                obj = zzrgVar.value;
                if (!(obj instanceof zzf)) {
                    return z11;
                }
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return zzv(obj2);
        }
        zzk zzkVar = this.waiters;
        if (zzkVar != zzk.zza) {
            zzk zzkVar2 = new zzk();
            do {
                zza zzaVar = zzc;
                zzaVar.zzc(zzkVar2, zzkVar);
                if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzu(zzkVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return zzv(obj);
                }
                zzkVar = this.waiters;
            } while (zzkVar != zzk.zza);
        }
        Object obj3 = this.value;
        obj3.getClass();
        return zzv(obj3);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (this.value != null) & (!(r0 instanceof zzf));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (this.value instanceof zzb) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            zzp(sb2);
        } else {
            zzq(sb2);
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String zze() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // com.google.android.gms.internal.cast.zzsf
    public final Throwable zzf() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    public final boolean zzk(Object obj) {
        if (obj == null) {
            obj = zzd;
        }
        if (!zzc.zzf(this, null, obj)) {
            return false;
        }
        zzs(this, false);
        return true;
    }

    public final boolean zzl(Throwable th2) {
        if (!zzc.zzf(this, null, new zzc(th2))) {
            return false;
        }
        zzs(this, false);
        return true;
    }

    public final boolean zzm() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z10 = true;
            if ((obj != null) & (!(obj instanceof zzf))) {
                return zzv(obj);
            }
            long j11 = 0;
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzk zzkVar = this.waiters;
                if (zzkVar != zzk.zza) {
                    zzk zzkVar2 = new zzk();
                    do {
                        zza zzaVar = zzc;
                        zzaVar.zzc(zzkVar2, zzkVar);
                        if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) & (!(obj2 instanceof zzf))) {
                                        return zzv(obj2);
                                    }
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    zzu(zzkVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zzu(zzkVar2);
                            j11 = 0;
                        } else {
                            zzkVar = this.waiters;
                        }
                    } while (zzkVar != zzk.zza);
                }
                Object obj3 = this.value;
                obj3.getClass();
                return zzv(obj3);
            }
            while (nanos > j11) {
                Object obj4 = this.value;
                if ((obj4 != null) & (!(obj4 instanceof zzf))) {
                    return zzv(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = jNanoTime - System.nanoTime();
                    j11 = 0;
                } else {
                    throw new InterruptedException();
                }
            }
            String string = toString();
            String string2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = string2.toLowerCase(locale);
            String strConcat = "Waited " + j10 + StringUtils.SPACE + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j12 = -nanos;
                long jConvert = timeUnit.convert(j12, TimeUnit.NANOSECONDS);
                long nanos2 = j12 - timeUnit.toNanos(jConvert);
                if (jConvert != 0 && nanos2 <= 1000) {
                    z10 = false;
                }
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + StringUtils.SPACE + lowerCase;
                    if (z10) {
                        strConcat3 = strConcat3.concat(",");
                    }
                    strConcat2 = strConcat3.concat(StringUtils.SPACE);
                }
                if (z10) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = strConcat2.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(ac.c.C(strConcat, " for ", string));
        }
        throw new InterruptedException();
    }

    public void zzj() {
    }
}
