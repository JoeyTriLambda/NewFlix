package bd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.processors.english.BaseProcessor;
import gd.f;
import java.util.ArrayList;

/* compiled from: GogoExtractor.java */
/* loaded from: classes2.dex */
public final class e extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final String f4866f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f4867g;

    public e(Context context, String str, f fVar) {
        this.f4866f = str;
        this.f4867g = context;
        this.f12431b = fVar;
        new ArrayList();
    }

    public void process(String str) {
        new d(this, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
