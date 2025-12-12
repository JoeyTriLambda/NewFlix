package com.unity3d.services.banners;

import android.content.Context;
import bg.a;
import com.unity3d.services.core.misc.ViewUtilities;
import zf.f;
import zf.i;

/* compiled from: UnityBannerSize.kt */
/* loaded from: classes2.dex */
public final class UnityBannerSize {
    private final int height;
    private final int width;
    public static final Companion Companion = new Companion(null);
    private static final UnityBannerSize leaderboard = new UnityBannerSize(728, 90);
    private static final UnityBannerSize iabStandard = new UnityBannerSize(468, 60);
    private static final UnityBannerSize standard = new UnityBannerSize(320, 50);

    /* compiled from: UnityBannerSize.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final UnityBannerSize getDynamicSize(Context context) {
            i.checkNotNullParameter(context, "context");
            int iRoundToInt = a.roundToInt(ViewUtilities.dpFromPx(context, context.getResources().getDisplayMetrics().widthPixels));
            return iRoundToInt >= getLeaderboard().getWidth() ? getLeaderboard() : iRoundToInt >= getIabStandard().getWidth() ? getIabStandard() : getStandard();
        }

        public final UnityBannerSize getIabStandard() {
            return UnityBannerSize.iabStandard;
        }

        public final UnityBannerSize getLeaderboard() {
            return UnityBannerSize.leaderboard;
        }

        public final UnityBannerSize getStandard() {
            return UnityBannerSize.standard;
        }
    }

    public UnityBannerSize(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    public static final UnityBannerSize getDynamicSize(Context context) {
        return Companion.getDynamicSize(context);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }
}
