package ja;

import android.app.UiModeManager;
import android.content.Context;
import android.util.Log;
import ig.l;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt__StringsKt;
import mf.k;
import org.apache.commons.lang3.StringUtils;
import zf.i;

/* compiled from: Utils.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f14683a = new b();

    public final boolean isForegroundRunning(boolean z10, Context context) {
        i.checkNotNullParameter(context, "mContext");
        return isTV(context) || z10;
    }

    public final boolean isTV(Context context) {
        i.checkNotNullParameter(context, "mContext");
        Object systemService = context.getSystemService("uimode");
        i.checkNotNull(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
        if (((UiModeManager) systemService).getCurrentModeType() == 4) {
            Log.d("DeviceTypeRuntimeCheck", "Running on a TV Device");
            return true;
        }
        Log.d("DeviceTypeRuntimeCheck", "Running on a non-TV Device");
        return false;
    }

    public final File writeConfigToFile(Context context, String str, boolean z10) throws IOException {
        int i10;
        int i11;
        int i12;
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(str, "response");
        File file = new File(context.getFilesDir(), "mproxy.cfg");
        try {
            if (file.exists() && !file.delete()) {
                Log.w("ConfigManagerUtil", "mproxy config file cannot be deleted");
            } else if (file.createNewFile()) {
                List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{StringUtils.LF}, false, 0, 6, (Object) null);
                String strReplace$default = l.replace$default(StringsKt__StringsKt.substringAfter$default((String) listSplit$default.get(0), "-r", (String) null, 2, (Object) null), ",", ":", false, 4, (Object) null);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                StringBuilder sb2 = new StringBuilder("proxy -r");
                String strSubstring = strReplace$default.substring(0, strReplace$default.length() - 1);
                i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb2.append(strSubstring);
                bufferedWriter.append((CharSequence) sb2.toString());
                bufferedWriter.newLine();
                Log.d("ConfigManagerUtil", "mproxy config file response " + str);
                Log.d("ConfigManagerUtil", "mproxy config file response split " + StringsKt__StringsKt.split$default((CharSequence) StringsKt__StringsKt.trim(str).toString(), new String[]{StringUtils.LF}, false, 0, 6, (Object) null));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("mproxy config file response count ");
                List listSplit$default2 = StringsKt__StringsKt.split$default((CharSequence) StringsKt__StringsKt.trim(str).toString(), new String[]{StringUtils.LF}, false, 0, 6, (Object) null);
                if ((listSplit$default2 instanceof Collection) && listSplit$default2.isEmpty()) {
                    i10 = 0;
                } else {
                    Iterator it = listSplit$default2.iterator();
                    i10 = 0;
                    while (it.hasNext()) {
                        if (StringsKt__StringsKt.contains$default((CharSequence) it.next(), (CharSequence) "config", false, 2, (Object) null) && (i10 = i10 + 1) < 0) {
                            k.throwCountOverflow();
                        }
                    }
                }
                sb3.append(i10);
                Log.d("ConfigManagerUtil", sb3.toString());
                List listSplit$default3 = StringsKt__StringsKt.split$default((CharSequence) StringsKt__StringsKt.trim(str).toString(), new String[]{StringUtils.LF}, false, 0, 6, (Object) null);
                if ((listSplit$default3 instanceof Collection) && listSplit$default3.isEmpty()) {
                    i12 = 1;
                    i11 = 0;
                } else {
                    Iterator it2 = listSplit$default3.iterator();
                    i11 = 0;
                    while (it2.hasNext()) {
                        if (StringsKt__StringsKt.contains$default((CharSequence) it2.next(), (CharSequence) "config", false, 2, (Object) null) && (i11 = i11 + 1) < 0) {
                            k.throwCountOverflow();
                        }
                    }
                    i12 = 1;
                }
                if (i11 > i12) {
                    String strReplace$default2 = l.replace$default(StringsKt__StringsKt.substringAfter$default((String) listSplit$default.get(i12), "-r", (String) null, 2, (Object) null), ",", ":", false, 4, (Object) null);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("socks -r");
                    String strSubstring2 = strReplace$default2.substring(0, strReplace$default2.length() - 1);
                    i.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb4.append(strSubstring2);
                    bufferedWriter.append((CharSequence) sb4.toString());
                    bufferedWriter.newLine();
                }
                if (z10) {
                    File file2 = new File(context.getFilesDir(), "log");
                    Log.d("ConfigManagerUtil", "Enable logging to file " + file2);
                    bufferedWriter.append((CharSequence) ("log " + file2.getAbsolutePath() + " D"));
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                bufferedWriter.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                Log.d("ConfigManagerUtil", "mproxy config file wrote mproxy.cfg");
                Log.d("ConfigManagerUtil", "Config:\n" + a.f14682a.toString(file) + "\n=========");
            } else {
                Log.w("ConfigManagerUtil", "mproxy config file creation failed");
            }
        } catch (Exception e10) {
            Log.e("ConfigManagerUtil", "File write failed: " + e10);
        }
        return file;
    }
}
