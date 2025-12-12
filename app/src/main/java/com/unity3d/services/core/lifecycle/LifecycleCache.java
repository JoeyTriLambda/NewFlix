package com.unity3d.services.core.lifecycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import androidx.lifecycle.u;
import com.unity3d.scar.adapter.common.i;
import com.unity3d.services.core.configuration.ConfigurationReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@TargetApi(14)
/* loaded from: classes2.dex */
public class LifecycleCache implements Application.ActivityLifecycleCallbacks, j {
    private boolean _newLifecycle;
    private LifecycleEvent _currentState = LifecycleEvent.RESUMED;
    private boolean _appActive = true;
    private boolean _lifecycleAppActive = true;
    private int _numStarted = 0;
    private final Set<IAppActiveListener> _appActiveListeners = new HashSet();
    private final Set<IAppEventListener> _appStateListeners = new HashSet();

    /* renamed from: com.unity3d.services.core.lifecycle.LifecycleCache$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public LifecycleCache(ConfigurationReader configurationReader) {
        this._newLifecycle = false;
        this._newLifecycle = configurationReader.getCurrentConfiguration().getExperiments().isJetpackLifecycle();
        startProcessLifecycleObserving();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerLifecycleObserver() {
        u.get().getLifecycle().addObserver(this);
    }

    private void startProcessLifecycleObserving() {
        i.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.lifecycle.LifecycleCache.1
            @Override // java.lang.Runnable
            public void run() {
                LifecycleCache.this.registerLifecycleObserver();
            }
        });
    }

    public synchronized void addActiveListener(IAppActiveListener iAppActiveListener) {
        this._appActiveListeners.add(iAppActiveListener);
    }

    public synchronized void addStateListener(IAppEventListener iAppEventListener) {
        this._appStateListeners.add(iAppEventListener);
    }

    public LifecycleEvent getCurrentState() {
        return this._currentState;
    }

    public boolean isAppActive() {
        return this._newLifecycle ? this._lifecycleAppActive : this._appActive;
    }

    public synchronized void notifyActiveListeners() {
        Iterator<IAppActiveListener> it = this._appActiveListeners.iterator();
        while (it.hasNext()) {
            it.next().onAppStateChanged(this._appActive);
        }
    }

    public synchronized void notifyStateListeners(LifecycleEvent lifecycleEvent) {
        Iterator<IAppEventListener> it = this._appStateListeners.iterator();
        while (it.hasNext()) {
            it.next().onLifecycleEvent(lifecycleEvent);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this._currentState = LifecycleEvent.CREATED;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this._currentState = LifecycleEvent.DESTROYED;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        LifecycleEvent lifecycleEvent = LifecycleEvent.PAUSED;
        this._currentState = lifecycleEvent;
        notifyStateListeners(lifecycleEvent);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        LifecycleEvent lifecycleEvent = LifecycleEvent.RESUMED;
        this._currentState = lifecycleEvent;
        notifyStateListeners(lifecycleEvent);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this._currentState = LifecycleEvent.SAVE_INSTANCE_STATE;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this._currentState = LifecycleEvent.STARTED;
        if (this._numStarted == 0) {
            this._appActive = true;
            if (!this._newLifecycle) {
                notifyActiveListeners();
            }
        }
        this._numStarted++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this._currentState = LifecycleEvent.STOPPED;
        int i10 = this._numStarted - 1;
        this._numStarted = i10;
        if (i10 <= 0) {
            this._numStarted = 0;
            this._appActive = false;
            if (this._newLifecycle) {
                return;
            }
            notifyActiveListeners();
        }
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, Lifecycle.Event event) {
        int i10 = AnonymousClass2.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()];
        if (i10 == 1) {
            this._lifecycleAppActive = false;
            if (this._newLifecycle) {
                notifyActiveListeners();
                return;
            }
            return;
        }
        if (i10 != 2) {
            return;
        }
        this._lifecycleAppActive = true;
        if (this._newLifecycle) {
            notifyActiveListeners();
        }
    }

    public synchronized void removeActiveListener(IAppActiveListener iAppActiveListener) {
        this._appActiveListeners.remove(iAppActiveListener);
    }

    public synchronized void removeStateListener(IAppEventListener iAppEventListener) {
        this._appStateListeners.remove(iAppEventListener);
    }
}
