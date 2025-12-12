package okhttp3.internal.publicsuffix;

import ah.e;
import ah.m;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.StringsKt__StringsKt;
import lf.h;
import mf.j;
import mf.k;
import mf.q;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import org.apache.commons.lang3.ClassUtils;
import wf.a;
import zf.f;
import zf.i;

/* compiled from: PublicSuffixDatabase.kt */
/* loaded from: classes2.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final Companion Companion = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {42};
    private static final List<String> PREVAILING_RULE = j.listOf("*");
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    /* compiled from: PublicSuffixDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i10) {
            int i11;
            boolean z10;
            int iAnd;
            int iAnd2;
            int length = bArr.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = (i12 + length) / 2;
                while (i13 > -1 && bArr[i13] != 10) {
                    i13--;
                }
                int i14 = i13 + 1;
                int i15 = 1;
                while (true) {
                    i11 = i14 + i15;
                    if (bArr[i11] == 10) {
                        break;
                    }
                    i15++;
                }
                int i16 = i11 - i14;
                int i17 = i10;
                boolean z11 = false;
                int i18 = 0;
                int i19 = 0;
                while (true) {
                    if (z11) {
                        iAnd = 46;
                        z10 = false;
                    } else {
                        z10 = z11;
                        iAnd = Util.and(bArr2[i17][i18], 255);
                    }
                    iAnd2 = iAnd - Util.and(bArr[i14 + i19], 255);
                    if (iAnd2 != 0) {
                        break;
                    }
                    i19++;
                    i18++;
                    if (i19 == i16) {
                        break;
                    }
                    if (bArr2[i17].length != i18) {
                        z11 = z10;
                    } else {
                        if (i17 == bArr2.length - 1) {
                            break;
                        }
                        i17++;
                        z11 = true;
                        i18 = -1;
                    }
                }
                if (iAnd2 >= 0) {
                    if (iAnd2 <= 0) {
                        int i20 = i16 - i19;
                        int length2 = bArr2[i17].length - i18;
                        int length3 = bArr2.length;
                        for (int i21 = i17 + 1; i21 < length3; i21++) {
                            length2 += bArr2[i21].length;
                        }
                        if (length2 >= i20) {
                            if (length2 <= i20) {
                                Charset charset = StandardCharsets.UTF_8;
                                i.checkNotNullExpressionValue(charset, "UTF_8");
                                return new String(bArr, i14, i16, charset);
                            }
                        }
                    }
                    i12 = i11 + 1;
                }
                length = i14 - 1;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }
    }

    private final List<String> findMatchingRule(List<String> list) throws InterruptedException {
        String str;
        String str2;
        String strBinarySearch;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (!(this.publicSuffixListBytes != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i10 = 0; i10 < size; i10++) {
            String str3 = list.get(i10);
            Charset charset = StandardCharsets.UTF_8;
            i.checkNotNullExpressionValue(charset, "UTF_8");
            byte[] bytes = str3.getBytes(charset);
            i.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i10] = bytes;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                str = null;
                break;
            }
            int i12 = i11 + 1;
            Companion companion = Companion;
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                i.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                bArr2 = null;
            }
            String strBinarySearch2 = companion.binarySearch(bArr2, bArr, i11);
            if (strBinarySearch2 != null) {
                str = strBinarySearch2;
                break;
            }
            i11 = i12;
        }
        if (size > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            int i13 = 0;
            while (i13 < length) {
                int i14 = i13 + 1;
                bArr3[i13] = WILDCARD_LABEL;
                Companion companion2 = Companion;
                byte[] bArr4 = this.publicSuffixListBytes;
                if (bArr4 == null) {
                    i.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    bArr4 = null;
                }
                String strBinarySearch3 = companion2.binarySearch(bArr4, bArr3, i13);
                if (strBinarySearch3 != null) {
                    str2 = strBinarySearch3;
                    break;
                }
                i13 = i14;
            }
            str2 = null;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            int i15 = size - 1;
            int i16 = 0;
            while (i16 < i15) {
                int i17 = i16 + 1;
                Companion companion3 = Companion;
                byte[] bArr5 = this.publicSuffixExceptionListBytes;
                if (bArr5 == null) {
                    i.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                    bArr5 = null;
                }
                strBinarySearch = companion3.binarySearch(bArr5, bArr, i16);
                if (strBinarySearch != null) {
                    break;
                }
                i16 = i17;
            }
            strBinarySearch = null;
        } else {
            strBinarySearch = null;
        }
        if (strBinarySearch != null) {
            return StringsKt__StringsKt.split$default((CharSequence) i.stringPlus("!", strBinarySearch), new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR}, false, 0, 6, (Object) null);
        }
        if (str == null && str2 == null) {
            return PREVAILING_RULE;
        }
        List<String> listSplit$default = str == null ? null : StringsKt__StringsKt.split$default((CharSequence) str, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR}, false, 0, 6, (Object) null);
        if (listSplit$default == null) {
            listSplit$default = k.emptyList();
        }
        List<String> listSplit$default2 = str2 != null ? StringsKt__StringsKt.split$default((CharSequence) str2, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR}, false, 0, 6, (Object) null) : null;
        if (listSplit$default2 == null) {
            listSplit$default2 = k.emptyList();
        }
        return listSplit$default.size() > listSplit$default2.size() ? listSplit$default : listSplit$default2;
    }

    private final void readTheList() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        e eVarBuffer = m.buffer(new ah.j(m.source(resourceAsStream)));
        try {
            byte[] byteArray = eVarBuffer.readByteArray(eVarBuffer.readInt());
            byte[] byteArray2 = eVarBuffer.readByteArray(eVarBuffer.readInt());
            h hVar = h.f16056a;
            a.closeFinally(eVarBuffer, null);
            synchronized (this) {
                i.checkNotNull(byteArray);
                this.publicSuffixListBytes = byteArray;
                i.checkNotNull(byteArray2);
                this.publicSuffixExceptionListBytes = byteArray2;
            }
            this.readCompleteLatch.countDown();
        } finally {
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e10) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e10);
                    if (z10) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> splitDomain(String str) {
        List<String> listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR}, false, 0, 6, (Object) null);
        return i.areEqual(q.last(listSplit$default), "") ? q.dropLast(listSplit$default, 1) : listSplit$default;
    }

    public final String getEffectiveTldPlusOne(String str) throws InterruptedException {
        int size;
        int size2;
        i.checkNotNullParameter(str, ClientCookie.DOMAIN_ATTR);
        String unicode = IDN.toUnicode(str);
        i.checkNotNullExpressionValue(unicode, "unicodeDomain");
        List<String> listSplitDomain = splitDomain(unicode);
        List<String> listFindMatchingRule = findMatchingRule(listSplitDomain);
        if (listSplitDomain.size() == listFindMatchingRule.size() && listFindMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (listFindMatchingRule.get(0).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size();
        } else {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size() + 1;
        }
        return hg.f.joinToString$default(hg.f.drop(q.asSequence(splitDomain(str)), size - size2), ".", null, null, 0, null, null, 62, null);
    }

    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        i.checkNotNullParameter(bArr, "publicSuffixListBytes");
        i.checkNotNullParameter(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
