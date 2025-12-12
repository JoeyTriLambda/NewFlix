package cz.msebera.android.httpclient.extras;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Provider;
import java.security.SecureRandomSpi;

@TargetApi(4)
/* loaded from: classes2.dex */
public final class PRNGFixes {
    private static final byte[] BUILD_FINGERPRINT_AND_DEVICE_SERIAL = getBuildFingerprintAndDeviceSerial();
    private static final int VERSION_CODE_JELLY_BEAN = 16;
    private static final int VERSION_CODE_JELLY_BEAN_MR2 = 18;

    public static class LinuxPRNGSecureRandom extends SecureRandomSpi {
        private static final File URANDOM_FILE = new File("/dev/urandom");
        private static final Object sLock = new Object();
        private static DataInputStream sUrandomIn;
        private static OutputStream sUrandomOut;
        private boolean mSeeded;

        private DataInputStream getUrandomInputStream() {
            DataInputStream dataInputStream;
            synchronized (sLock) {
                if (sUrandomIn == null) {
                    try {
                        sUrandomIn = new DataInputStream(new FileInputStream(URANDOM_FILE));
                    } catch (IOException e10) {
                        throw new SecurityException("Failed to open " + URANDOM_FILE + " for reading", e10);
                    }
                }
                dataInputStream = sUrandomIn;
            }
            return dataInputStream;
        }

        private OutputStream getUrandomOutputStream() throws IOException {
            OutputStream outputStream;
            synchronized (sLock) {
                if (sUrandomOut == null) {
                    sUrandomOut = new FileOutputStream(URANDOM_FILE);
                }
                outputStream = sUrandomOut;
            }
            return outputStream;
        }

        @Override // java.security.SecureRandomSpi
        public byte[] engineGenerateSeed(int i10) {
            byte[] bArr = new byte[i10];
            engineNextBytes(bArr);
            return bArr;
        }

        @Override // java.security.SecureRandomSpi
        public void engineNextBytes(byte[] bArr) {
            DataInputStream urandomInputStream;
            if (!this.mSeeded) {
                engineSetSeed(PRNGFixes.generateSeed());
            }
            try {
                synchronized (sLock) {
                    urandomInputStream = getUrandomInputStream();
                }
                synchronized (urandomInputStream) {
                    urandomInputStream.readFully(bArr);
                }
            } catch (IOException e10) {
                throw new SecurityException("Failed to read from " + URANDOM_FILE, e10);
            }
        }

        @Override // java.security.SecureRandomSpi
        public void engineSetSeed(byte[] bArr) {
            OutputStream urandomOutputStream;
            try {
                try {
                    synchronized (sLock) {
                        urandomOutputStream = getUrandomOutputStream();
                    }
                    urandomOutputStream.write(bArr);
                    urandomOutputStream.flush();
                } catch (IOException unused) {
                    Log.w("PRNGFixes", "Failed to mix seed into " + URANDOM_FILE);
                }
            } finally {
                this.mSeeded = true;
            }
        }
    }

    public static class LinuxPRNGSecureRandomProvider extends Provider {
        public LinuxPRNGSecureRandomProvider() {
            super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
            put("SecureRandom.SHA1PRNG", LinuxPRNGSecureRandom.class.getName());
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }

    private PRNGFixes() {
    }

    public static void apply() throws SecurityException {
        applyOpenSSLFix();
        installLinuxPRNGSecureRandom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] generateSeed() throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeLong(System.currentTimeMillis());
            dataOutputStream.writeLong(System.nanoTime());
            dataOutputStream.writeInt(Process.myPid());
            dataOutputStream.writeInt(Process.myUid());
            dataOutputStream.write(BUILD_FINGERPRINT_AND_DEVICE_SERIAL);
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            throw new SecurityException("Failed to generate seed", e10);
        }
    }

    private static byte[] getBuildFingerprintAndDeviceSerial() {
        StringBuilder sb2 = new StringBuilder();
        String str = Build.FINGERPRINT;
        if (str != null) {
            sb2.append(str);
        }
        String deviceSerialNumber = getDeviceSerialNumber();
        if (deviceSerialNumber != null) {
            sb2.append(deviceSerialNumber);
        }
        try {
            return sb2.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 encoding not supported");
        }
    }

    private static String getDeviceSerialNumber() {
        try {
            return (String) Build.class.getField("SERIAL").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void applyOpenSSLFix() throws SecurityException {
    }

    private static void installLinuxPRNGSecureRandom() throws SecurityException {
    }
}
