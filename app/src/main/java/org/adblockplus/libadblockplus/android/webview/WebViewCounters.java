package org.adblockplus.libadblockplus.android.webview;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import org.adblockplus.libadblockplus.android.webview.AdblockWebView;

/* loaded from: classes2.dex */
public final class WebViewCounters {
    private final Runnable allowlistedIncrementRunnable;
    private final Runnable allowlistedResetRunnable;
    private final Runnable blockedIncrementRunnable;
    private final Runnable blockedResetRunnable;
    private EventsListener eventsListener;
    private int blockedCounter = 0;
    private int allowlistedCounter = 0;
    private final Handler handler = new Handler(Looper.getMainLooper());

    public interface EventsListener {
        void onAllowlistedChanged(int i10);

        void onBlockedChanged(int i10);
    }

    public static class IncrementAllowlistedOperation implements WeakRunnable.Operation {
        private IncrementAllowlistedOperation() {
        }

        @Override // org.adblockplus.libadblockplus.android.webview.WebViewCounters.WeakRunnable.Operation
        public void run(WebViewCounters webViewCounters) {
            WebViewCounters.access$604(webViewCounters);
            webViewCounters.notifyAllowlistedChanged();
        }
    }

    public static class IncrementBlockedOperation implements WeakRunnable.Operation {
        private IncrementBlockedOperation() {
        }

        @Override // org.adblockplus.libadblockplus.android.webview.WebViewCounters.WeakRunnable.Operation
        public void run(WebViewCounters webViewCounters) {
            WebViewCounters.access$404(webViewCounters);
            webViewCounters.notifyBlockedChanged();
        }
    }

    public static class ResetAllowlistedOperation implements WeakRunnable.Operation {
        private ResetAllowlistedOperation() {
        }

        @Override // org.adblockplus.libadblockplus.android.webview.WebViewCounters.WeakRunnable.Operation
        public void run(WebViewCounters webViewCounters) {
            webViewCounters.allowlistedCounter = 0;
            webViewCounters.notifyAllowlistedChanged();
        }
    }

    public static class ResetBlockedOperation implements WeakRunnable.Operation {
        private ResetBlockedOperation() {
        }

        @Override // org.adblockplus.libadblockplus.android.webview.WebViewCounters.WeakRunnable.Operation
        public void run(WebViewCounters webViewCounters) {
            webViewCounters.blockedCounter = 0;
            webViewCounters.notifyBlockedChanged();
        }
    }

    public static final class WeakRunnable implements Runnable {
        private Operation operation;
        private WeakReference<WebViewCounters> weakCounters;

        public interface Operation {
            void run(WebViewCounters webViewCounters);
        }

        public WeakRunnable(WebViewCounters webViewCounters, Operation operation) {
            this.weakCounters = new WeakReference<>(webViewCounters);
            this.operation = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebViewCounters webViewCounters = this.weakCounters.get();
            if (webViewCounters != null) {
                this.operation.run(webViewCounters);
            }
        }
    }

    public WebViewCounters(EventsListener eventsListener) {
        this.blockedResetRunnable = new WeakRunnable(this, new ResetBlockedOperation());
        this.blockedIncrementRunnable = new WeakRunnable(this, new IncrementBlockedOperation());
        this.allowlistedResetRunnable = new WeakRunnable(this, new ResetAllowlistedOperation());
        this.allowlistedIncrementRunnable = new WeakRunnable(this, new IncrementAllowlistedOperation());
        this.eventsListener = eventsListener;
    }

    public static /* synthetic */ int access$404(WebViewCounters webViewCounters) {
        int i10 = webViewCounters.blockedCounter + 1;
        webViewCounters.blockedCounter = i10;
        return i10;
    }

    public static /* synthetic */ int access$604(WebViewCounters webViewCounters) {
        int i10 = webViewCounters.allowlistedCounter + 1;
        webViewCounters.allowlistedCounter = i10;
        return i10;
    }

    public static AdblockWebView.EventsListener bindAdblockWebView(EventsListener eventsListener) {
        return new AdblockWebView.EventsListener() { // from class: org.adblockplus.libadblockplus.android.webview.WebViewCounters.1
            @Override // org.adblockplus.libadblockplus.android.webview.AdblockWebView.EventsListener
            public void onNavigation() {
                WebViewCounters.this.resetBlocked();
                WebViewCounters.this.resetAllowlisted();
            }

            @Override // org.adblockplus.libadblockplus.android.webview.AdblockWebView.EventsListener
            public void onResourceLoadingAllowlisted(AdblockWebView.EventsListener.AllowlistedResourceInfo allowlistedResourceInfo) {
                WebViewCounters.this.incrementAllowlisted();
            }

            @Override // org.adblockplus.libadblockplus.android.webview.AdblockWebView.EventsListener
            public void onResourceLoadingBlocked(AdblockWebView.EventsListener.BlockedResourceInfo blockedResourceInfo) {
                WebViewCounters.this.incrementBlocked();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAllowlistedChanged() {
        EventsListener eventsListener = this.eventsListener;
        if (eventsListener != null) {
            eventsListener.onAllowlistedChanged(this.allowlistedCounter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBlockedChanged() {
        EventsListener eventsListener = this.eventsListener;
        if (eventsListener != null) {
            eventsListener.onBlockedChanged(this.blockedCounter);
        }
    }

    public void incrementAllowlisted() {
        this.handler.post(this.allowlistedIncrementRunnable);
    }

    public void incrementBlocked() {
        this.handler.post(this.blockedIncrementRunnable);
    }

    public void resetAllowlisted() {
        this.handler.post(this.allowlistedResetRunnable);
    }

    public void resetBlocked() {
        this.handler.post(this.blockedResetRunnable);
    }
}
