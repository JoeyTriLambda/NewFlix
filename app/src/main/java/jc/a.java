package jc;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Environment;
import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.models.Anime;
import flix.com.vision.models.Movie;
import flix.com.vision.models.PreferenceEntry;
import flix.com.vision.models.PreferencesModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BackupRestore.java */
/* loaded from: classes2.dex */
public final class a {
    public static void BackupPreferences(Activity activity) throws IOException {
        if (m0.a.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            Toast.makeText(activity, "Please grant Permission and retry", 0).show();
            l0.a.requestPermissions(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
            return;
        }
        Toast.makeText(activity.getBaseContext(), "Backing up your data...", 1).show();
        String str = Environment.getExternalStorageDirectory() + "/FLIXVISION_DATA/";
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (!file.exists()) {
                Toast.makeText(activity, "Could not Restore Data. Please Check Storage Access Permissions for FlixVision", 0).show();
                return;
            }
        }
        String strB = ac.c.B(str, "BACKUP");
        PreferencesModel preferences = getPreferences();
        try {
            File file2 = new File(strB);
            if (file2.exists()) {
                file2.delete();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(strB), false));
            objectOutputStream.writeObject(preferences);
            objectOutputStream.close();
            Toast.makeText(activity, "Successfully backed up your data...", 1).show();
        } catch (IOException e12) {
            e12.printStackTrace();
            Toast.makeText(activity, "Could not Restore Data. Please Check Storage Access Permissions for FlixVision", 0).show();
        }
    }

    public static void RestoreBackup(Activity activity) throws ClassNotFoundException, IOException {
        String str;
        if (m0.a.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            Toast.makeText(activity, "Please grant Permission and retry", 0).show();
            l0.a.requestPermissions(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
            return;
        }
        Toast.makeText(activity, "Restoring your data...", 1).show();
        PreferencesModel preferencesModel = null;
        try {
            str = Environment.getExternalStorageDirectory() + "/FLIXVISION_DATA/BACKUP";
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (ClassNotFoundException e11) {
            e11.printStackTrace();
        }
        if (!new File(str).exists()) {
            Toast.makeText(activity, "Could not Restore your data. Please Check Storage Access Permissions for FlixVision", 1).show();
            return;
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(str)));
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        if (object != null && (object instanceof PreferencesModel)) {
            preferencesModel = (PreferencesModel) object;
        }
        if (preferencesModel == null) {
            Toast.makeText(activity, "Could not Restore your data. Please Check Storage Access Permissions for FlixVision", 1).show();
            return;
        }
        try {
            ArrayList<PreferenceEntry> arrayList = preferencesModel.f12421b;
            ArrayList<Movie> arrayList2 = preferencesModel.f12422m;
            ArrayList<Movie> arrayList3 = preferencesModel.f12423n;
            ArrayList<Anime> arrayList4 = preferencesModel.f12424o;
            ArrayList<Anime> arrayList5 = preferencesModel.f12425p;
            SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
            Iterator<PreferenceEntry> it = arrayList.iterator();
            while (it.hasNext()) {
                PreferenceEntry next = it.next();
                int iOrdinal = next.f12416p.ordinal();
                if (iOrdinal == 0) {
                    editorEdit.putInt(next.f12412b, next.f12415o);
                } else if (iOrdinal == 1) {
                    editorEdit.putString(next.f12412b, next.f12413m);
                } else if (iOrdinal == 2) {
                    editorEdit.putBoolean(next.f12412b, next.f12414n);
                }
            }
            editorEdit.apply();
            Iterator<Movie> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                App.getInstance().f11573u.addMovieFavorites(it2.next());
            }
            Iterator<Movie> it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                App.getInstance().f11573u.addtoWatching(it3.next());
            }
            Iterator<Anime> it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                App.getInstance().f11573u.addMovieFavorites_Anime(it4.next().toMovie());
            }
            Iterator<Anime> it5 = arrayList5.iterator();
            while (it5.hasNext()) {
                App.getInstance().f11573u.addMovieHistory_ANIME(it5.next().toMovie());
            }
        } catch (Exception e12) {
            e12.printStackTrace();
            Toast.makeText(activity, "Could not Restore your data. Please Check Storage Access Permissions for FlixVision", 1).show();
        }
        Toast.makeText(activity, "Successfully Restored your data...", 1).show();
    }

    public static String getBackupFileLocation(Activity activity) {
        if (m0.a.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            return null;
        }
        String str = Environment.getExternalStorageDirectory() + "/FLIXVISION_DATA/BACKUP";
        if (new File(str).exists()) {
            return str;
        }
        return null;
    }

    public static PreferencesModel getPreferences() {
        boolean z10;
        PreferencesModel preferencesModel = new PreferencesModel();
        for (Map.Entry<String, ?> entry : App.getInstance().f11574v.getAll().entrySet()) {
            if (!entry.getKey().equals("prefs_sub_lang_set_1") && !entry.getKey().equals("change_player")) {
                PreferenceEntry preferenceEntry = new PreferenceEntry();
                preferenceEntry.f12412b = entry.getKey();
                boolean z11 = true;
                if (entry.getValue() instanceof String) {
                    preferenceEntry.f12413m = (String) entry.getValue();
                    preferenceEntry.f12416p = PreferenceEntry.VALUE_TYPE.STRING;
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (entry.getValue() instanceof Integer) {
                    preferenceEntry.f12415o = ((Integer) entry.getValue()).intValue();
                    preferenceEntry.f12416p = PreferenceEntry.VALUE_TYPE.INTEGER;
                    z10 = true;
                }
                if (entry.getValue() instanceof Boolean) {
                    preferenceEntry.f12414n = ((Boolean) entry.getValue()).booleanValue();
                    preferenceEntry.f12416p = PreferenceEntry.VALUE_TYPE.BOOLEAN;
                } else {
                    z11 = z10;
                }
                if (z11) {
                    preferencesModel.f12421b.add(preferenceEntry);
                }
            }
        }
        ArrayList<Anime> arrayList = preferencesModel.f12424o;
        arrayList.addAll(App.getInstance().f11573u.getFavoritesMoviesFromDb_Anime());
        ArrayList<Anime> arrayList2 = preferencesModel.f12425p;
        arrayList2.addAll(App.getInstance().f11573u.getWatchedMoviesFromDb_Anime());
        ArrayList<Movie> arrayList3 = preferencesModel.f12422m;
        arrayList3.addAll(App.getInstance().f11573u.getFavoritesMoviesFromDb());
        ArrayList<Movie> arrayList4 = preferencesModel.f12423n;
        arrayList4.addAll(App.getInstance().f11573u.getWatchedMoviesFromDb());
        try {
            Collections.reverse(arrayList3);
            Collections.reverse(arrayList);
            Collections.reverse(arrayList4);
            Collections.reverse(arrayList2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return preferencesModel;
    }
}
