package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.fasterxml.jackson.core.JsonPointer;
import com.unity3d.ads.metadata.MediationMetaData;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f2124p = {"_display_name", "_size"};

    /* renamed from: q, reason: collision with root package name */
    public static final File f2125q = new File("/");

    /* renamed from: r, reason: collision with root package name */
    public static final HashMap<String, b> f2126r = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final Object f2127b;

    /* renamed from: m, reason: collision with root package name */
    public String f2128m;

    /* renamed from: n, reason: collision with root package name */
    public b f2129n;

    /* renamed from: o, reason: collision with root package name */
    public final int f2130o;

    public static class a {
        public static File[] a(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    public interface b {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    public static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final String f2131a;

        /* renamed from: b, reason: collision with root package name */
        public final HashMap<String, File> f2132b = new HashMap<>();

        public c(String str) {
            this.f2131a = str;
        }

        public static boolean a(String str, String str2) {
            String strA = FileProvider.a(str);
            String strA2 = FileProvider.a(str2);
            if (!strA.equals(strA2)) {
                if (!strA.startsWith(strA2 + JsonPointer.SEPARATOR)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.content.FileProvider.b
        public File getFileForUri(Uri uri) throws IOException {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.f2132b.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException(ac.c.i("Unable to find configured root for ", uri));
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (a(canonicalFile.getPath(), file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        @Override // androidx.core.content.FileProvider.b
        public Uri getUriForFile(File file) throws IOException {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f2132b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (a(canonicalPath, path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException(ac.c.j("Failed to find configured root that contains ", canonicalPath));
                }
                String path2 = entry.getValue().getPath();
                return new Uri.Builder().scheme("content").authority(this.f2131a).encodedPath(Uri.encode(entry.getKey()) + JsonPointer.SEPARATOR + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }
    }

    public FileProvider() {
        this(0);
    }

    public static String a(String str) {
        return (str.length() <= 0 || str.charAt(str.length() + (-1)) != '/') ? str : str.substring(0, str.length() - 1);
    }

    public static b c(Context context, String str, int i10) {
        b bVarD;
        HashMap<String, b> map = f2126r;
        synchronized (map) {
            bVarD = map.get(str);
            if (bVarD == null) {
                try {
                    try {
                        bVarD = d(context, str, i10);
                        map.put(str, bVarD);
                    } catch (IOException e10) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e10);
                    }
                } catch (XmlPullParserException e11) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e11);
                }
            }
        }
        return bVarD;
    }

    public static c d(Context context, String str, int i10) throws XmlPullParserException, IOException {
        c cVar = new c(str);
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (providerInfoResolveContentProvider == null) {
            throw new IllegalArgumentException(ac.c.j("Couldn't find meta-data for provider with authority ", str));
        }
        if (providerInfoResolveContentProvider.metaData == null && i10 != 0) {
            Bundle bundle = new Bundle(1);
            providerInfoResolveContentProvider.metaData = bundle;
            bundle.putInt("android.support.FILE_PROVIDER_PATHS", i10);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return cVar;
            }
            if (next == 2) {
                String name = xmlResourceParserLoadXmlMetaData.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, MediationMetaData.KEY_NAME);
                String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, ClientCookie.PATH_ATTR);
                if ("root-path".equals(name)) {
                    externalStorageDirectory = f2125q;
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] externalFilesDirs = m0.a.getExternalFilesDirs(context, null);
                    if (externalFilesDirs.length > 0) {
                        externalStorageDirectory = externalFilesDirs[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] externalCacheDirs = m0.a.getExternalCacheDirs(context);
                    if (externalCacheDirs.length > 0) {
                        externalStorageDirectory = externalCacheDirs[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] fileArrA = a.a(context);
                    if (fileArrA.length > 0) {
                        externalStorageDirectory = fileArrA[0];
                    }
                }
                if (externalStorageDirectory == null) {
                    continue;
                } else {
                    if (attributeValue2 != null) {
                        externalStorageDirectory = new File(externalStorageDirectory, attributeValue2);
                    }
                    if (TextUtils.isEmpty(attributeValue)) {
                        throw new IllegalArgumentException("Name must not be empty");
                    }
                    try {
                        cVar.f2132b.put(attributeValue, externalStorageDirectory.getCanonicalFile());
                    } catch (IOException e10) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + externalStorageDirectory, e10);
                    }
                }
            }
        }
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return c(context, str, 0).getUriForFile(file);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority.split(";")[0];
        synchronized (this.f2127b) {
            this.f2128m = str;
        }
        HashMap<String, b> map = f2126r;
        synchronized (map) {
            map.remove(str);
        }
    }

    public final b b() {
        b bVar;
        synchronized (this.f2127b) {
            w0.c.requireNonNull(this.f2128m, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
            if (this.f2129n == null) {
                this.f2129n = c(getContext(), this.f2128m, this.f2130o);
            }
            bVar = this.f2129n;
        }
        return bVar;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return b().getFileForUri(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileForUri = b().getFileForUri(uri);
        int iLastIndexOf = fileForUri.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        int i10;
        File fileForUri = b().getFileForUri(uri);
        if ("r".equals(str)) {
            i10 = 268435456;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i10 = 738197504;
        } else if ("wa".equals(str)) {
            i10 = 704643072;
        } else if ("rw".equals(str)) {
            i10 = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                throw new IllegalArgumentException(ac.c.j("Invalid mode: ", str));
            }
            i10 = 1006632960;
        }
        return ParcelFileDescriptor.open(fileForUri, i10);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i10;
        File fileForUri = b().getFileForUri(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f2124p;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i11 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i11] = "_display_name";
                i10 = i11 + 1;
                objArr[i11] = queryParameter == null ? fileForUri.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i11] = "_size";
                i10 = i11 + 1;
                objArr[i11] = Long.valueOf(fileForUri.length());
            }
            i11 = i10;
        }
        String[] strArr4 = new String[i11];
        System.arraycopy(strArr3, 0, strArr4, 0, i11);
        Object[] objArr2 = new Object[i11];
        System.arraycopy(objArr, 0, objArr2, 0, i11);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public FileProvider(int i10) {
        this.f2127b = new Object();
        this.f2130o = i10;
    }
}
