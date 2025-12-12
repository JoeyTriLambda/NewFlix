package fd;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import flix.com.vision.activities.LinksActivity;

/* compiled from: PlayerHub.java */
/* loaded from: classes2.dex */
public final class h {
    public static void PlayMXPlayer(Activity activity, String str, String str2, String str3, String str4, int i10) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("title", str);
        }
        bundle.putBoolean("secure_uri", true);
        if (i10 > 10000) {
            bundle.putInt("position", i10);
        }
        bundle.putBoolean("return_result", true);
        bundle.putInt("video_zoom", 0);
        bundle.putBoolean("sticky", false);
        if (str4 != null && !str4.isEmpty()) {
            bundle.putStringArray("headers", new String[]{"Referer", str4});
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtras(bundle);
        intent.setDataAndType(Uri.parse(str2), "video/*");
        intent.setPackage(getMXPlayerPackage(activity));
        if (activity instanceof LinksActivity) {
            activity.startActivityForResult(intent, 6261);
        } else {
            activity.startActivity(intent);
        }
    }

    public static void PlayVLC(Activity activity, String str, String str2, String str3, String str4, int i10) {
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString("title", str);
            }
            if (i10 > 1000) {
                bundle.putInt("position", i10);
                bundle.putBoolean("from_start", false);
            } else {
                bundle.putInt("position", 0);
                bundle.putBoolean("from_start", true);
            }
            if (str3 != null && !str3.isEmpty()) {
                bundle.putStringArray("headers", new String[]{"User-Agent", str3});
            }
            if (str4 != null && !str4.isEmpty()) {
                bundle.putStringArray("referrer", new String[]{"Referrer", str4});
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtras(bundle);
            intent.setDataAndType(Uri.parse(str2), "video/*");
            intent.setComponent(new ComponentName("org.videolan.vlc", "org.videolan.vlc.gui.video.VideoPlayerActivity"));
            if (activity instanceof LinksActivity) {
                activity.startActivityForResult(intent, 6565);
            } else {
                activity.startActivity(intent);
            }
        } catch (Exception e10) {
            be.d.makeToast(activity, e10.getMessage(), false);
        }
    }

    public static void PlayXPlayer(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("title", str);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtras(bundle);
        intent.setDataAndType(Uri.parse(str2), "video/*");
        intent.setPackage("video.player.videoplayer");
        context.startActivity(intent);
    }

    public static String getMXPlayerPackage(Context context) {
        return isPackageInstalled(context, "com.mxtech.videoplayer.pro") ? "com.mxtech.videoplayer.pro" : "com.mxtech.videoplayer.ad";
    }

    public static boolean isPackageInstalled(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
