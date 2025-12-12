package flix.com.vision.cast;

import android.content.Context;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.SessionProvider;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import flix.com.vision.R;
import java.util.List;

/* loaded from: classes2.dex */
public class CastOptionsProvider implements OptionsProvider {
    @Override // com.google.android.gms.cast.framework.OptionsProvider
    public List<SessionProvider> getAdditionalSessionProviders(Context context) {
        return null;
    }

    @Override // com.google.android.gms.cast.framework.OptionsProvider
    public CastOptions getCastOptions(Context context) {
        return new CastOptions.Builder().setReceiverApplicationId(context.getString(R.string.app_id)).setCastMediaOptions(new CastMediaOptions.Builder().setNotificationOptions(new NotificationOptions.Builder().setTargetActivityClassName(ExpandedControlsActivity.class.getName()).build()).setExpandedControllerActivityClassName(ExpandedControlsActivity.class.getName()).build()).build();
    }
}
