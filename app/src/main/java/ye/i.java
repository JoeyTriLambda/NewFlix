package ye;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ObservableBlockingSubscribe.java */
/* loaded from: classes2.dex */
public final class i {
    public static <T> void subscribe(ne.o<? extends T> oVar, ne.q<? super T> qVar) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        qVar.onSubscribe(blockingObserver);
        oVar.subscribe(blockingObserver);
        while (!blockingObserver.isDisposed()) {
            Object objPoll = linkedBlockingQueue.poll();
            if (objPoll == null) {
                try {
                    objPoll = linkedBlockingQueue.take();
                } catch (InterruptedException e10) {
                    blockingObserver.dispose();
                    qVar.onError(e10);
                    return;
                }
            }
            if (blockingObserver.isDisposed() || objPoll == BlockingObserver.f13570m || NotificationLite.acceptFull(objPoll, qVar)) {
                return;
            }
        }
    }

    public static <T> void subscribe(ne.o<? extends T> oVar) {
        cf.d dVar = new cf.d();
        LambdaObserver lambdaObserver = new LambdaObserver(Functions.emptyConsumer(), dVar, dVar, Functions.emptyConsumer());
        oVar.subscribe(lambdaObserver);
        cf.c.awaitForComplete(dVar, lambdaObserver);
        Throwable th2 = dVar.f5275b;
        if (th2 != null) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    public static <T> void subscribe(ne.o<? extends T> oVar, se.f<? super T> fVar, se.f<? super Throwable> fVar2, se.a aVar) {
        ue.a.requireNonNull(fVar, "onNext is null");
        ue.a.requireNonNull(fVar2, "onError is null");
        ue.a.requireNonNull(aVar, "onComplete is null");
        subscribe(oVar, new LambdaObserver(fVar, fVar2, aVar, Functions.emptyConsumer()));
    }
}
