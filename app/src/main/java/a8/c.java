package a8;

import android.content.Context;
import android.content.res.Resources;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f376a;

    public c(Context context) {
        Resources resources = context.getResources();
        Map<String, String> mapA = f.a((resources == null || resources.getConfiguration() == null || resources.getConfiguration().locale == null) ? Locale.getDefault() : resources.getConfiguration().locale);
        this.f376a = mapA.get("error_initializing_player");
        mapA.get("get_youtube_app_title");
        mapA.get("get_youtube_app_text");
        mapA.get("get_youtube_app_action");
        mapA.get("enable_youtube_app_title");
        mapA.get("enable_youtube_app_text");
        mapA.get("enable_youtube_app_action");
        mapA.get("update_youtube_app_title");
        mapA.get("update_youtube_app_text");
        mapA.get("update_youtube_app_action");
    }
}
