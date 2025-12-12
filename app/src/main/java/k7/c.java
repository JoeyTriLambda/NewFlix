package k7;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.l;
import java.util.Objects;

/* compiled from: MaterialBackOrchestrator.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final a f15018a;

    /* renamed from: b, reason: collision with root package name */
    public final k7.b f15019b;

    /* renamed from: c, reason: collision with root package name */
    public final View f15020c;

    /* compiled from: MaterialBackOrchestrator.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public OnBackInvokedCallback f15021a;

        public OnBackInvokedCallback a(k7.b bVar) {
            Objects.requireNonNull(bVar);
            return new l(bVar, 2);
        }

        public void startListeningForBackCallbacks(k7.b bVar, View view, boolean z10) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.f15021a == null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback onBackInvokedCallbackA = a(bVar);
                this.f15021a = onBackInvokedCallbackA;
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(z10 ? 1000000 : 0, onBackInvokedCallbackA);
            }
        }

        public void stopListeningForBackCallbacks(View view) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (onBackInvokedDispatcherFindOnBackInvokedDispatcher == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f15021a);
            this.f15021a = null;
        }
    }

    /* compiled from: MaterialBackOrchestrator.java */
    public static class b extends a {

        /* compiled from: MaterialBackOrchestrator.java */
        public class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k7.b f15022a;

            public a(k7.b bVar) {
                this.f15022a = bVar;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                if (b.this.f15021a != null) {
                    this.f15022a.cancelBackProgress();
                }
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f15022a.handleBackInvoked();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                if (b.this.f15021a != null) {
                    this.f15022a.updateBackProgress(new androidx.activity.b(backEvent));
                }
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                if (b.this.f15021a != null) {
                    this.f15022a.startBackProgress(new androidx.activity.b(backEvent));
                }
            }
        }

        @Override // k7.c.a
        public final OnBackInvokedCallback a(k7.b bVar) {
            return new a(bVar);
        }
    }

    public <T extends View & k7.b> c(T t10) {
        this(t10, t10);
    }

    public boolean shouldListenForBackCallbacks() {
        return this.f15018a != null;
    }

    public void startListeningForBackCallbacksWithPriorityOverlay() {
        a aVar = this.f15018a;
        if (aVar != null) {
            aVar.startListeningForBackCallbacks(this.f15019b, this.f15020c, true);
        }
    }

    public void stopListeningForBackCallbacks() {
        a aVar = this.f15018a;
        if (aVar != null) {
            aVar.stopListeningForBackCallbacks(this.f15020c);
        }
    }

    public c(k7.b bVar, View view) {
        int i10 = Build.VERSION.SDK_INT;
        this.f15018a = i10 >= 34 ? new b() : i10 >= 33 ? new a() : null;
        this.f15019b = bVar;
        this.f15020c = view;
    }
}
