package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.extras.Base64;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
final class NTLMEngineImpl implements NTLMEngine {
    static final int FLAG_DOMAIN_PRESENT = 4096;
    static final int FLAG_REQUEST_128BIT_KEY_EXCH = 536870912;
    static final int FLAG_REQUEST_56BIT_ENCRYPTION = Integer.MIN_VALUE;
    static final int FLAG_REQUEST_ALWAYS_SIGN = 32768;
    static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 1073741824;
    static final int FLAG_REQUEST_LAN_MANAGER_KEY = 128;
    static final int FLAG_REQUEST_NTLM2_SESSION = 524288;
    static final int FLAG_REQUEST_NTLMv1 = 512;
    static final int FLAG_REQUEST_OEM_ENCODING = 2;
    static final int FLAG_REQUEST_SEAL = 32;
    static final int FLAG_REQUEST_SIGN = 16;
    static final int FLAG_REQUEST_TARGET = 4;
    static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
    static final int FLAG_REQUEST_VERSION = 33554432;
    static final int FLAG_TARGETINFO_PRESENT = 8388608;
    static final int FLAG_WORKSTATION_PRESENT = 8192;
    private static final byte[] MAGIC_TLS_SERVER_ENDPOINT;
    static final int MSV_AV_CHANNEL_BINDINGS = 10;
    static final int MSV_AV_DNS_COMPUTER_NAME = 3;
    static final int MSV_AV_DNS_DOMAIN_NAME = 4;
    static final int MSV_AV_DNS_TREE_NAME = 5;
    static final int MSV_AV_EOL = 0;
    static final int MSV_AV_FLAGS = 6;
    static final int MSV_AV_FLAGS_ACCOUNT_AUTH_CONSTAINED = 1;
    static final int MSV_AV_FLAGS_MIC = 2;
    static final int MSV_AV_FLAGS_UNTRUSTED_TARGET_SPN = 4;
    static final int MSV_AV_NB_COMPUTER_NAME = 1;
    static final int MSV_AV_NB_DOMAIN_NAME = 2;
    static final int MSV_AV_SINGLE_HOST = 8;
    static final int MSV_AV_TARGET_NAME = 9;
    static final int MSV_AV_TIMESTAMP = 7;
    private static final SecureRandom RND_GEN;
    private static final byte[] SEAL_MAGIC_CLIENT;
    private static final byte[] SEAL_MAGIC_SERVER;
    private static final byte[] SIGNATURE;
    private static final byte[] SIGN_MAGIC_CLIENT;
    private static final byte[] SIGN_MAGIC_SERVER;
    private static final String TYPE_1_MESSAGE;
    private static final Charset UNICODE_LITTLE_UNMARKED = Charset.forName("UnicodeLittleUnmarked");
    private static final Charset DEFAULT_CHARSET = Consts.ASCII;

    public static class CipherGen {
        protected final byte[] challenge;
        protected byte[] clientChallenge;
        protected byte[] clientChallenge2;
        protected final long currentTime;
        protected final String domain;
        protected byte[] lanManagerSessionKey;
        protected byte[] lm2SessionResponse;
        protected byte[] lmHash;
        protected byte[] lmResponse;
        protected byte[] lmUserSessionKey;
        protected byte[] lmv2Hash;
        protected byte[] lmv2Response;
        protected byte[] ntlm2SessionResponse;
        protected byte[] ntlm2SessionResponseUserSessionKey;
        protected byte[] ntlmHash;
        protected byte[] ntlmResponse;
        protected byte[] ntlmUserSessionKey;
        protected byte[] ntlmv2Blob;
        protected byte[] ntlmv2Hash;
        protected byte[] ntlmv2Response;
        protected byte[] ntlmv2UserSessionKey;
        protected final String password;
        protected final Random random;
        protected byte[] secondaryKey;
        protected final String target;
        protected final byte[] targetInformation;
        protected byte[] timestamp;
        protected final String user;

        @Deprecated
        public CipherGen(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
            this(NTLMEngineImpl.RND_GEN, System.currentTimeMillis(), str, str2, str3, bArr, str4, bArr2, bArr3, bArr4, bArr5, bArr6);
        }

        public byte[] getClientChallenge() throws NTLMEngineException {
            if (this.clientChallenge == null) {
                this.clientChallenge = NTLMEngineImpl.makeRandomChallenge(this.random);
            }
            return this.clientChallenge;
        }

        public byte[] getClientChallenge2() throws NTLMEngineException {
            if (this.clientChallenge2 == null) {
                this.clientChallenge2 = NTLMEngineImpl.makeRandomChallenge(this.random);
            }
            return this.clientChallenge2;
        }

        public byte[] getLM2SessionResponse() throws NTLMEngineException {
            if (this.lm2SessionResponse == null) {
                byte[] clientChallenge = getClientChallenge();
                byte[] bArr = new byte[24];
                this.lm2SessionResponse = bArr;
                System.arraycopy(clientChallenge, 0, bArr, 0, clientChallenge.length);
                byte[] bArr2 = this.lm2SessionResponse;
                Arrays.fill(bArr2, clientChallenge.length, bArr2.length, (byte) 0);
            }
            return this.lm2SessionResponse;
        }

        public byte[] getLMHash() throws NTLMEngineException {
            if (this.lmHash == null) {
                this.lmHash = NTLMEngineImpl.lmHash(this.password);
            }
            return this.lmHash;
        }

        public byte[] getLMResponse() throws NTLMEngineException {
            if (this.lmResponse == null) {
                this.lmResponse = NTLMEngineImpl.lmResponse(getLMHash(), this.challenge);
            }
            return this.lmResponse;
        }

        public byte[] getLMUserSessionKey() throws NTLMEngineException {
            if (this.lmUserSessionKey == null) {
                this.lmUserSessionKey = new byte[16];
                System.arraycopy(getLMHash(), 0, this.lmUserSessionKey, 0, 8);
                Arrays.fill(this.lmUserSessionKey, 8, 16, (byte) 0);
            }
            return this.lmUserSessionKey;
        }

        public byte[] getLMv2Hash() throws NTLMEngineException {
            if (this.lmv2Hash == null) {
                this.lmv2Hash = NTLMEngineImpl.lmv2Hash(this.domain, this.user, getNTLMHash());
            }
            return this.lmv2Hash;
        }

        public byte[] getLMv2Response() throws NTLMEngineException {
            if (this.lmv2Response == null) {
                this.lmv2Response = NTLMEngineImpl.lmv2Response(getLMv2Hash(), this.challenge, getClientChallenge());
            }
            return this.lmv2Response;
        }

        public byte[] getLanManagerSessionKey() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, NTLMEngineException {
            if (this.lanManagerSessionKey == null) {
                try {
                    byte[] bArr = new byte[14];
                    System.arraycopy(getLMHash(), 0, bArr, 0, 8);
                    Arrays.fill(bArr, 8, 14, (byte) -67);
                    Key keyCreateDESKey = NTLMEngineImpl.createDESKey(bArr, 0);
                    Key keyCreateDESKey2 = NTLMEngineImpl.createDESKey(bArr, 7);
                    byte[] bArr2 = new byte[8];
                    System.arraycopy(getLMResponse(), 0, bArr2, 0, 8);
                    Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher.init(1, keyCreateDESKey);
                    byte[] bArrDoFinal = cipher.doFinal(bArr2);
                    Cipher cipher2 = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher2.init(1, keyCreateDESKey2);
                    byte[] bArrDoFinal2 = cipher2.doFinal(bArr2);
                    byte[] bArr3 = new byte[16];
                    this.lanManagerSessionKey = bArr3;
                    System.arraycopy(bArrDoFinal, 0, bArr3, 0, bArrDoFinal.length);
                    System.arraycopy(bArrDoFinal2, 0, this.lanManagerSessionKey, bArrDoFinal.length, bArrDoFinal2.length);
                } catch (Exception e10) {
                    throw new NTLMEngineException(e10.getMessage(), e10);
                }
            }
            return this.lanManagerSessionKey;
        }

        public byte[] getNTLM2SessionResponse() throws NTLMEngineException {
            if (this.ntlm2SessionResponse == null) {
                this.ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(getNTLMHash(), this.challenge, getClientChallenge());
            }
            return this.ntlm2SessionResponse;
        }

        public byte[] getNTLM2SessionResponseUserSessionKey() throws NTLMEngineException {
            if (this.ntlm2SessionResponseUserSessionKey == null) {
                byte[] lM2SessionResponse = getLM2SessionResponse();
                byte[] bArr = this.challenge;
                byte[] bArr2 = new byte[bArr.length + lM2SessionResponse.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                System.arraycopy(lM2SessionResponse, 0, bArr2, this.challenge.length, lM2SessionResponse.length);
                this.ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(bArr2, getNTLMUserSessionKey());
            }
            return this.ntlm2SessionResponseUserSessionKey;
        }

        public byte[] getNTLMHash() throws NTLMEngineException {
            if (this.ntlmHash == null) {
                this.ntlmHash = NTLMEngineImpl.ntlmHash(this.password);
            }
            return this.ntlmHash;
        }

        public byte[] getNTLMResponse() throws NTLMEngineException {
            if (this.ntlmResponse == null) {
                this.ntlmResponse = NTLMEngineImpl.lmResponse(getNTLMHash(), this.challenge);
            }
            return this.ntlmResponse;
        }

        public byte[] getNTLMUserSessionKey() throws NTLMEngineException {
            if (this.ntlmUserSessionKey == null) {
                MD4 md4 = new MD4();
                md4.update(getNTLMHash());
                this.ntlmUserSessionKey = md4.getOutput();
            }
            return this.ntlmUserSessionKey;
        }

        public byte[] getNTLMv2Blob() throws NTLMEngineException {
            if (this.ntlmv2Blob == null) {
                this.ntlmv2Blob = NTLMEngineImpl.createBlob(getClientChallenge2(), this.targetInformation, getTimestamp());
            }
            return this.ntlmv2Blob;
        }

        public byte[] getNTLMv2Hash() throws NTLMEngineException {
            if (this.ntlmv2Hash == null) {
                this.ntlmv2Hash = NTLMEngineImpl.ntlmv2Hash(this.domain, this.user, getNTLMHash());
            }
            return this.ntlmv2Hash;
        }

        public byte[] getNTLMv2Response() throws NTLMEngineException {
            if (this.ntlmv2Response == null) {
                this.ntlmv2Response = NTLMEngineImpl.lmv2Response(getNTLMv2Hash(), this.challenge, getNTLMv2Blob());
            }
            return this.ntlmv2Response;
        }

        public byte[] getNTLMv2UserSessionKey() throws NTLMEngineException {
            if (this.ntlmv2UserSessionKey == null) {
                byte[] nTLMv2Hash = getNTLMv2Hash();
                byte[] bArr = new byte[16];
                System.arraycopy(getNTLMv2Response(), 0, bArr, 0, 16);
                this.ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(bArr, nTLMv2Hash);
            }
            return this.ntlmv2UserSessionKey;
        }

        public byte[] getSecondaryKey() throws NTLMEngineException {
            if (this.secondaryKey == null) {
                this.secondaryKey = NTLMEngineImpl.makeSecondaryKey(this.random);
            }
            return this.secondaryKey;
        }

        public byte[] getTimestamp() {
            if (this.timestamp == null) {
                long j10 = (this.currentTime + 11644473600000L) * 10000;
                this.timestamp = new byte[8];
                for (int i10 = 0; i10 < 8; i10++) {
                    this.timestamp[i10] = (byte) j10;
                    j10 >>>= 8;
                }
            }
            return this.timestamp;
        }

        public CipherGen(Random random, long j10, String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
            this.lmHash = null;
            this.lmResponse = null;
            this.ntlmHash = null;
            this.ntlmResponse = null;
            this.ntlmv2Hash = null;
            this.lmv2Hash = null;
            this.lmv2Response = null;
            this.ntlmv2Blob = null;
            this.ntlmv2Response = null;
            this.ntlm2SessionResponse = null;
            this.lm2SessionResponse = null;
            this.lmUserSessionKey = null;
            this.ntlmUserSessionKey = null;
            this.ntlmv2UserSessionKey = null;
            this.ntlm2SessionResponseUserSessionKey = null;
            this.lanManagerSessionKey = null;
            this.random = random;
            this.currentTime = j10;
            this.domain = str;
            this.target = str4;
            this.user = str2;
            this.password = str3;
            this.challenge = bArr;
            this.targetInformation = bArr2;
            this.clientChallenge = bArr3;
            this.clientChallenge2 = bArr4;
            this.secondaryKey = bArr5;
            this.timestamp = bArr6;
        }

        @Deprecated
        public CipherGen(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2) {
            this(NTLMEngineImpl.RND_GEN, System.currentTimeMillis(), str, str2, str3, bArr, str4, bArr2);
        }

        public CipherGen(Random random, long j10, String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2) {
            this(random, j10, str, str2, str3, bArr, str4, bArr2, null, null, null, null);
        }
    }

    public static class HMACMD5 {
        protected final byte[] ipad;
        protected final MessageDigest md5;
        protected final byte[] opad;

        public HMACMD5(byte[] bArr) {
            MessageDigest md5 = NTLMEngineImpl.getMD5();
            this.md5 = md5;
            this.ipad = new byte[64];
            this.opad = new byte[64];
            int length = bArr.length;
            if (length > 64) {
                md5.update(bArr);
                bArr = md5.digest();
                length = bArr.length;
            }
            int i10 = 0;
            while (i10 < length) {
                this.ipad[i10] = (byte) (54 ^ bArr[i10]);
                this.opad[i10] = (byte) (92 ^ bArr[i10]);
                i10++;
            }
            while (i10 < 64) {
                this.ipad[i10] = 54;
                this.opad[i10] = 92;
                i10++;
            }
            this.md5.reset();
            this.md5.update(this.ipad);
        }

        public byte[] getOutput() {
            byte[] bArrDigest = this.md5.digest();
            this.md5.update(this.opad);
            return this.md5.digest(bArrDigest);
        }

        public void update(byte[] bArr) {
            this.md5.update(bArr);
        }

        public void update(byte[] bArr, int i10, int i11) {
            this.md5.update(bArr, i10, i11);
        }
    }

    public static class Handle {
        private final byte[] exportedSessionKey;
        private final boolean isConnection;
        final Mode mode;
        private final Cipher rc4;
        private byte[] sealingKey;
        int sequenceNumber = 0;
        private byte[] signingKey;

        public Handle(byte[] bArr, Mode mode, boolean z10) throws NTLMEngineException {
            this.exportedSessionKey = bArr;
            this.isConnection = z10;
            this.mode = mode;
            try {
                MessageDigest md5 = NTLMEngineImpl.getMD5();
                MessageDigest md52 = NTLMEngineImpl.getMD5();
                md5.update(bArr);
                md52.update(bArr);
                if (mode == Mode.CLIENT) {
                    md5.update(NTLMEngineImpl.SIGN_MAGIC_CLIENT);
                    md52.update(NTLMEngineImpl.SEAL_MAGIC_CLIENT);
                } else {
                    md5.update(NTLMEngineImpl.SIGN_MAGIC_SERVER);
                    md52.update(NTLMEngineImpl.SEAL_MAGIC_SERVER);
                }
                this.signingKey = md5.digest();
                this.sealingKey = md52.digest();
                this.rc4 = initCipher();
            } catch (Exception e10) {
                throw new NTLMEngineException(e10.getMessage(), e10);
            }
        }

        private void advanceMessageSequence() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NTLMEngineException {
            if (!this.isConnection) {
                MessageDigest md5 = NTLMEngineImpl.getMD5();
                md5.update(this.sealingKey);
                byte[] bArr = new byte[4];
                NTLMEngineImpl.writeULong(bArr, this.sequenceNumber, 0);
                md5.update(bArr);
                this.sealingKey = md5.digest();
                initCipher();
            }
            this.sequenceNumber++;
        }

        private byte[] computeSignature(byte[] bArr) {
            byte[] bArr2 = new byte[16];
            bArr2[0] = 1;
            bArr2[1] = 0;
            bArr2[2] = 0;
            bArr2[3] = 0;
            HMACMD5 hmacmd5 = new HMACMD5(this.signingKey);
            hmacmd5.update(NTLMEngineImpl.encodeLong(this.sequenceNumber));
            hmacmd5.update(bArr);
            byte[] bArr3 = new byte[8];
            System.arraycopy(hmacmd5.getOutput(), 0, bArr3, 0, 8);
            System.arraycopy(encrypt(bArr3), 0, bArr2, 4, 8);
            NTLMEngineImpl.encodeLong(bArr2, 12, this.sequenceNumber);
            return bArr2;
        }

        private byte[] decrypt(byte[] bArr) {
            return this.rc4.update(bArr);
        }

        private byte[] encrypt(byte[] bArr) {
            return this.rc4.update(bArr);
        }

        private Cipher initCipher() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NTLMEngineException {
            try {
                Cipher cipher = Cipher.getInstance("RC4");
                if (this.mode == Mode.CLIENT) {
                    cipher.init(1, new SecretKeySpec(this.sealingKey, "RC4"));
                } else {
                    cipher.init(2, new SecretKeySpec(this.sealingKey, "RC4"));
                }
                return cipher;
            } catch (Exception e10) {
                throw new NTLMEngineException(e10.getMessage(), e10);
            }
        }

        private boolean validateSignature(byte[] bArr, byte[] bArr2) {
            return Arrays.equals(bArr, computeSignature(bArr2));
        }

        public byte[] decryptAndVerifySignedMessage(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NTLMEngineException {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            int length = bArr.length - 16;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, 16, bArr3, 0, length);
            byte[] bArrDecrypt = decrypt(bArr3);
            if (!validateSignature(bArr2, bArrDecrypt)) {
                throw new NTLMEngineException("Wrong signature");
            }
            advanceMessageSequence();
            return bArrDecrypt;
        }

        public byte[] getSealingKey() {
            return this.sealingKey;
        }

        public byte[] getSigningKey() {
            return this.signingKey;
        }

        public byte[] signAndEncryptMessage(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NTLMEngineException {
            byte[] bArrEncrypt = encrypt(bArr);
            byte[] bArrComputeSignature = computeSignature(bArr);
            byte[] bArr2 = new byte[bArrComputeSignature.length + bArrEncrypt.length];
            System.arraycopy(bArrComputeSignature, 0, bArr2, 0, bArrComputeSignature.length);
            System.arraycopy(bArrEncrypt, 0, bArr2, bArrComputeSignature.length, bArrEncrypt.length);
            advanceMessageSequence();
            return bArr2;
        }
    }

    public static class MD4 {
        protected int A = 1732584193;
        protected int B = -271733879;
        protected int C = -1732584194;
        protected int D = 271733878;
        protected long count = 0;
        protected final byte[] dataBuffer = new byte[64];

        public byte[] getOutput() {
            int i10 = (int) (this.count & 63);
            int i11 = i10 < 56 ? 56 - i10 : 120 - i10;
            byte[] bArr = new byte[i11 + 8];
            bArr[0] = -128;
            for (int i12 = 0; i12 < 8; i12++) {
                bArr[i11 + i12] = (byte) ((this.count * 8) >>> (i12 * 8));
            }
            update(bArr);
            byte[] bArr2 = new byte[16];
            NTLMEngineImpl.writeULong(bArr2, this.A, 0);
            NTLMEngineImpl.writeULong(bArr2, this.B, 4);
            NTLMEngineImpl.writeULong(bArr2, this.C, 8);
            NTLMEngineImpl.writeULong(bArr2, this.D, 12);
            return bArr2;
        }

        public void processBuffer() {
            int[] iArr = new int[16];
            for (int i10 = 0; i10 < 16; i10++) {
                byte[] bArr = this.dataBuffer;
                int i11 = i10 * 4;
                iArr[i10] = (bArr[i11] & 255) + ((bArr[i11 + 1] & 255) << 8) + ((bArr[i11 + 2] & 255) << 16) + ((bArr[i11 + 3] & 255) << 24);
            }
            int i12 = this.A;
            int i13 = this.B;
            int i14 = this.C;
            int i15 = this.D;
            round1(iArr);
            round2(iArr);
            round3(iArr);
            this.A += i12;
            this.B += i13;
            this.C += i14;
            this.D += i15;
        }

        public void round1(int[] iArr) {
            int iRotintlft = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + iArr[0], 3);
            this.A = iRotintlft;
            int iRotintlft2 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(iRotintlft, this.B, this.C) + iArr[1], 7);
            this.D = iRotintlft2;
            int iRotintlft3 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(iRotintlft2, this.A, this.B) + iArr[2], 11);
            this.C = iRotintlft3;
            int iRotintlft4 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(iRotintlft3, this.D, this.A) + iArr[3], 19);
            this.B = iRotintlft4;
            int iRotintlft5 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(iRotintlft4, this.C, this.D) + iArr[4], 3);
            this.A = iRotintlft5;
            int iRotintlft6 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(iRotintlft5, this.B, this.C) + iArr[5], 7);
            this.D = iRotintlft6;
            int iRotintlft7 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(iRotintlft6, this.A, this.B) + iArr[6], 11);
            this.C = iRotintlft7;
            int iRotintlft8 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(iRotintlft7, this.D, this.A) + iArr[7], 19);
            this.B = iRotintlft8;
            int iRotintlft9 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(iRotintlft8, this.C, this.D) + iArr[8], 3);
            this.A = iRotintlft9;
            int iRotintlft10 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(iRotintlft9, this.B, this.C) + iArr[9], 7);
            this.D = iRotintlft10;
            int iRotintlft11 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(iRotintlft10, this.A, this.B) + iArr[10], 11);
            this.C = iRotintlft11;
            int iRotintlft12 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(iRotintlft11, this.D, this.A) + iArr[11], 19);
            this.B = iRotintlft12;
            int iRotintlft13 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(iRotintlft12, this.C, this.D) + iArr[12], 3);
            this.A = iRotintlft13;
            int iRotintlft14 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(iRotintlft13, this.B, this.C) + iArr[13], 7);
            this.D = iRotintlft14;
            int iRotintlft15 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(iRotintlft14, this.A, this.B) + iArr[14], 11);
            this.C = iRotintlft15;
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(iRotintlft15, this.D, this.A) + iArr[15], 19);
        }

        public void round2(int[] iArr) {
            int iRotintlft = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + iArr[0] + 1518500249, 3);
            this.A = iRotintlft;
            int iRotintlft2 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(iRotintlft, this.B, this.C) + iArr[4] + 1518500249, 5);
            this.D = iRotintlft2;
            int iRotintlft3 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(iRotintlft2, this.A, this.B) + iArr[8] + 1518500249, 9);
            this.C = iRotintlft3;
            int iRotintlft4 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(iRotintlft3, this.D, this.A) + iArr[12] + 1518500249, 13);
            this.B = iRotintlft4;
            int iRotintlft5 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(iRotintlft4, this.C, this.D) + iArr[1] + 1518500249, 3);
            this.A = iRotintlft5;
            int iRotintlft6 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(iRotintlft5, this.B, this.C) + iArr[5] + 1518500249, 5);
            this.D = iRotintlft6;
            int iRotintlft7 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(iRotintlft6, this.A, this.B) + iArr[9] + 1518500249, 9);
            this.C = iRotintlft7;
            int iRotintlft8 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(iRotintlft7, this.D, this.A) + iArr[13] + 1518500249, 13);
            this.B = iRotintlft8;
            int iRotintlft9 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(iRotintlft8, this.C, this.D) + iArr[2] + 1518500249, 3);
            this.A = iRotintlft9;
            int iRotintlft10 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(iRotintlft9, this.B, this.C) + iArr[6] + 1518500249, 5);
            this.D = iRotintlft10;
            int iRotintlft11 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(iRotintlft10, this.A, this.B) + iArr[10] + 1518500249, 9);
            this.C = iRotintlft11;
            int iRotintlft12 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(iRotintlft11, this.D, this.A) + iArr[14] + 1518500249, 13);
            this.B = iRotintlft12;
            int iRotintlft13 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(iRotintlft12, this.C, this.D) + iArr[3] + 1518500249, 3);
            this.A = iRotintlft13;
            int iRotintlft14 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(iRotintlft13, this.B, this.C) + iArr[7] + 1518500249, 5);
            this.D = iRotintlft14;
            int iRotintlft15 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(iRotintlft14, this.A, this.B) + iArr[11] + 1518500249, 9);
            this.C = iRotintlft15;
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(iRotintlft15, this.D, this.A) + iArr[15] + 1518500249, 13);
        }

        public void round3(int[] iArr) {
            int iRotintlft = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + iArr[0] + 1859775393, 3);
            this.A = iRotintlft;
            int iRotintlft2 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(iRotintlft, this.B, this.C) + iArr[8] + 1859775393, 9);
            this.D = iRotintlft2;
            int iRotintlft3 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(iRotintlft2, this.A, this.B) + iArr[4] + 1859775393, 11);
            this.C = iRotintlft3;
            int iRotintlft4 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(iRotintlft3, this.D, this.A) + iArr[12] + 1859775393, 15);
            this.B = iRotintlft4;
            int iRotintlft5 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(iRotintlft4, this.C, this.D) + iArr[2] + 1859775393, 3);
            this.A = iRotintlft5;
            int iRotintlft6 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(iRotintlft5, this.B, this.C) + iArr[10] + 1859775393, 9);
            this.D = iRotintlft6;
            int iRotintlft7 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(iRotintlft6, this.A, this.B) + iArr[6] + 1859775393, 11);
            this.C = iRotintlft7;
            int iRotintlft8 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(iRotintlft7, this.D, this.A) + iArr[14] + 1859775393, 15);
            this.B = iRotintlft8;
            int iRotintlft9 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(iRotintlft8, this.C, this.D) + iArr[1] + 1859775393, 3);
            this.A = iRotintlft9;
            int iRotintlft10 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(iRotintlft9, this.B, this.C) + iArr[9] + 1859775393, 9);
            this.D = iRotintlft10;
            int iRotintlft11 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(iRotintlft10, this.A, this.B) + iArr[5] + 1859775393, 11);
            this.C = iRotintlft11;
            int iRotintlft12 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(iRotintlft11, this.D, this.A) + iArr[13] + 1859775393, 15);
            this.B = iRotintlft12;
            int iRotintlft13 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(iRotintlft12, this.C, this.D) + iArr[3] + 1859775393, 3);
            this.A = iRotintlft13;
            int iRotintlft14 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(iRotintlft13, this.B, this.C) + iArr[11] + 1859775393, 9);
            this.D = iRotintlft14;
            int iRotintlft15 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(iRotintlft14, this.A, this.B) + iArr[7] + 1859775393, 11);
            this.C = iRotintlft15;
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(iRotintlft15, this.D, this.A) + iArr[15] + 1859775393, 15);
        }

        public void update(byte[] bArr) {
            byte[] bArr2;
            int i10 = (int) (this.count & 63);
            int i11 = 0;
            while (true) {
                int length = (bArr.length - i11) + i10;
                bArr2 = this.dataBuffer;
                if (length < bArr2.length) {
                    break;
                }
                int length2 = bArr2.length - i10;
                System.arraycopy(bArr, i11, bArr2, i10, length2);
                this.count += length2;
                i11 += length2;
                processBuffer();
                i10 = 0;
            }
            if (i11 < bArr.length) {
                int length3 = bArr.length - i11;
                System.arraycopy(bArr, i11, bArr2, i10, length3);
                this.count += length3;
            }
        }
    }

    public enum Mode {
        CLIENT,
        SERVER
    }

    public static class Type1Message extends NTLMMessage {
        private final byte[] domainBytes;
        private final int flags;
        private final byte[] hostBytes;

        public Type1Message(String str, String str2) throws NTLMEngineException {
            this(str, str2, null);
        }

        private int getDefaultFlags() {
            return -1576500735;
        }

        @Override // cz.msebera.android.httpclient.impl.auth.NTLMEngineImpl.NTLMMessage
        public void buildMessage() {
            byte[] bArr = this.domainBytes;
            int length = bArr != null ? bArr.length : 0;
            byte[] bArr2 = this.hostBytes;
            int length2 = bArr2 != null ? bArr2.length : 0;
            prepareResponse(length2 + 40 + length, 1);
            addULong(this.flags);
            addUShort(length);
            addUShort(length);
            addULong(length2 + 32 + 8);
            addUShort(length2);
            addUShort(length2);
            addULong(40);
            addUShort(261);
            addULong(2600);
            addUShort(3840);
            byte[] bArr3 = this.hostBytes;
            if (bArr3 != null) {
                addBytes(bArr3);
            }
            byte[] bArr4 = this.domainBytes;
            if (bArr4 != null) {
                addBytes(bArr4);
            }
        }

        public Type1Message(String str, String str2, Integer num) throws NTLMEngineException {
            this.flags = num == null ? getDefaultFlags() : num.intValue();
            String strConvertHost = NTLMEngineImpl.convertHost(str2);
            String strConvertDomain = NTLMEngineImpl.convertDomain(str);
            this.hostBytes = strConvertHost != null ? strConvertHost.getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED) : null;
            this.domainBytes = strConvertDomain != null ? strConvertDomain.toUpperCase(Locale.ROOT).getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED) : null;
        }

        public Type1Message() {
            this.hostBytes = null;
            this.domainBytes = null;
            this.flags = getDefaultFlags();
        }
    }

    public static class Type2Message extends NTLMMessage {
        protected final byte[] challenge;
        protected final int flags;
        protected String target;
        protected byte[] targetInfo;

        public Type2Message(String str) throws NTLMEngineException {
            this(Base64.decode(str.getBytes(NTLMEngineImpl.DEFAULT_CHARSET), 2));
        }

        public byte[] getChallenge() {
            return this.challenge;
        }

        public int getFlags() {
            return this.flags;
        }

        public String getTarget() {
            return this.target;
        }

        public byte[] getTargetInfo() {
            return this.targetInfo;
        }

        public Type2Message(byte[] bArr) throws NTLMEngineException {
            super(bArr, 2);
            byte[] bArr2 = new byte[8];
            this.challenge = bArr2;
            readBytes(bArr2, 24);
            int uLong = readULong(20);
            this.flags = uLong;
            this.target = null;
            if (getMessageLength() >= 20) {
                byte[] securityBuffer = readSecurityBuffer(12);
                if (securityBuffer.length != 0) {
                    this.target = new String(securityBuffer, NTLMEngineImpl.getCharset(uLong));
                }
            }
            this.targetInfo = null;
            if (getMessageLength() >= 48) {
                byte[] securityBuffer2 = readSecurityBuffer(40);
                if (securityBuffer2.length != 0) {
                    this.targetInfo = securityBuffer2;
                }
            }
        }
    }

    public static class Type3Message extends NTLMMessage {
        protected final boolean computeMic;
        protected final byte[] domainBytes;
        protected final byte[] exportedSessionKey;
        protected final byte[] hostBytes;
        protected byte[] lmResp;
        protected byte[] ntResp;
        protected final byte[] sessionKey;
        protected final byte[] type1Message;
        protected final int type2Flags;
        protected final byte[] type2Message;
        protected final byte[] userBytes;

        public Type3Message(String str, String str2, String str3, String str4, byte[] bArr, int i10, String str5, byte[] bArr2) throws NTLMEngineException {
            this(str, str2, str3, str4, bArr, i10, str5, bArr2, null, null, null);
        }

        private byte[] addGssMicAvsToTargetInfo(byte[] bArr, Certificate certificate) throws NTLMEngineException, CertificateEncodingException {
            byte[] bArr2 = new byte[bArr.length + 8 + 20];
            int length = bArr.length - 4;
            System.arraycopy(bArr, 0, bArr2, 0, length);
            NTLMEngineImpl.writeUShort(bArr2, 6, length);
            NTLMEngineImpl.writeUShort(bArr2, 4, length + 2);
            NTLMEngineImpl.writeULong(bArr2, 2, length + 4);
            NTLMEngineImpl.writeUShort(bArr2, 10, length + 8);
            NTLMEngineImpl.writeUShort(bArr2, 16, length + 10);
            try {
                byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(certificate.getEncoded());
                byte[] bArr3 = new byte[NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT.length + 20 + bArrDigest.length];
                NTLMEngineImpl.writeULong(bArr3, 53, 16);
                System.arraycopy(NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT, 0, bArr3, 20, NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT.length);
                System.arraycopy(bArrDigest, 0, bArr3, NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT.length + 20, bArrDigest.length);
                System.arraycopy(NTLMEngineImpl.getMD5().digest(bArr3), 0, bArr2, length + 12, 16);
                return bArr2;
            } catch (NoSuchAlgorithmException e10) {
                throw new NTLMEngineException(e10.getMessage(), e10);
            } catch (CertificateEncodingException e11) {
                throw new NTLMEngineException(e11.getMessage(), e11);
            }
        }

        @Override // cz.msebera.android.httpclient.impl.auth.NTLMEngineImpl.NTLMMessage
        public void buildMessage() {
            int i10;
            int length = this.ntResp.length;
            int length2 = this.lmResp.length;
            byte[] bArr = this.domainBytes;
            int length3 = bArr != null ? bArr.length : 0;
            byte[] bArr2 = this.hostBytes;
            int length4 = bArr2 != null ? bArr2.length : 0;
            int length5 = this.userBytes.length;
            byte[] bArr3 = this.sessionKey;
            int length6 = bArr3 != null ? bArr3.length : 0;
            int i11 = (this.computeMic ? 16 : 0) + 72;
            int i12 = i11 + length2;
            int i13 = i12 + length;
            int i14 = i13 + length3;
            int i15 = i14 + length5;
            int i16 = i15 + length4;
            prepareResponse(i16 + length6, 3);
            addUShort(length2);
            addUShort(length2);
            addULong(i11);
            addUShort(length);
            addUShort(length);
            addULong(i12);
            addUShort(length3);
            addUShort(length3);
            addULong(i13);
            addUShort(length5);
            addUShort(length5);
            addULong(i14);
            addUShort(length4);
            addUShort(length4);
            addULong(i15);
            addUShort(length6);
            addUShort(length6);
            addULong(i16);
            addULong(this.type2Flags);
            addUShort(261);
            addULong(2600);
            addUShort(3840);
            if (this.computeMic) {
                i10 = this.currentOutputPosition;
                this.currentOutputPosition = i10 + 16;
            } else {
                i10 = -1;
            }
            addBytes(this.lmResp);
            addBytes(this.ntResp);
            addBytes(this.domainBytes);
            addBytes(this.userBytes);
            addBytes(this.hostBytes);
            byte[] bArr4 = this.sessionKey;
            if (bArr4 != null) {
                addBytes(bArr4);
            }
            if (this.computeMic) {
                HMACMD5 hmacmd5 = new HMACMD5(this.exportedSessionKey);
                hmacmd5.update(this.type1Message);
                hmacmd5.update(this.type2Message);
                hmacmd5.update(this.messageContents);
                byte[] output = hmacmd5.getOutput();
                System.arraycopy(output, 0, this.messageContents, i10, output.length);
            }
        }

        public byte[] getEncryptedRandomSessionKey() {
            return this.sessionKey;
        }

        public byte[] getExportedSessionKey() {
            return this.exportedSessionKey;
        }

        public Type3Message(Random random, long j10, String str, String str2, String str3, String str4, byte[] bArr, int i10, String str5, byte[] bArr2) throws NTLMEngineException {
            this(random, j10, str, str2, str3, str4, bArr, i10, str5, bArr2, null, null, null);
        }

        public Type3Message(String str, String str2, String str3, String str4, byte[] bArr, int i10, String str5, byte[] bArr2, Certificate certificate, byte[] bArr3, byte[] bArr4) throws NTLMEngineException {
            this(NTLMEngineImpl.RND_GEN, System.currentTimeMillis(), str, str2, str3, str4, bArr, i10, str5, bArr2, certificate, bArr3, bArr4);
        }

        public Type3Message(Random random, long j10, String str, String str2, String str3, String str4, byte[] bArr, int i10, String str5, byte[] bArr2, Certificate certificate, byte[] bArr3, byte[] bArr4) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, NTLMEngineException, CertificateEncodingException {
            byte[] bArr5;
            byte[] lMUserSessionKey;
            if (random != null) {
                this.type2Flags = i10;
                this.type1Message = bArr3;
                this.type2Message = bArr4;
                String strConvertHost = NTLMEngineImpl.convertHost(str2);
                String strConvertDomain = NTLMEngineImpl.convertDomain(str);
                if (certificate != null) {
                    byte[] bArrAddGssMicAvsToTargetInfo = addGssMicAvsToTargetInfo(bArr2, certificate);
                    this.computeMic = true;
                    bArr5 = bArrAddGssMicAvsToTargetInfo;
                } else {
                    this.computeMic = false;
                    bArr5 = bArr2;
                }
                CipherGen cipherGen = new CipherGen(random, j10, strConvertDomain, str3, str4, bArr, str5, bArr5);
                try {
                    if ((NTLMEngineImpl.FLAG_TARGETINFO_PRESENT & i10) != 0 && bArr2 != null && str5 != null) {
                        this.ntResp = cipherGen.getNTLMv2Response();
                        this.lmResp = cipherGen.getLMv2Response();
                        if ((i10 & 128) != 0) {
                            lMUserSessionKey = cipherGen.getLanManagerSessionKey();
                        } else {
                            lMUserSessionKey = cipherGen.getNTLMv2UserSessionKey();
                        }
                    } else if ((NTLMEngineImpl.FLAG_REQUEST_NTLM2_SESSION & i10) != 0) {
                        this.ntResp = cipherGen.getNTLM2SessionResponse();
                        this.lmResp = cipherGen.getLM2SessionResponse();
                        if ((i10 & 128) != 0) {
                            lMUserSessionKey = cipherGen.getLanManagerSessionKey();
                        } else {
                            lMUserSessionKey = cipherGen.getNTLM2SessionResponseUserSessionKey();
                        }
                    } else {
                        this.ntResp = cipherGen.getNTLMResponse();
                        this.lmResp = cipherGen.getLMResponse();
                        if ((i10 & 128) != 0) {
                            lMUserSessionKey = cipherGen.getLanManagerSessionKey();
                        } else {
                            lMUserSessionKey = cipherGen.getNTLMUserSessionKey();
                        }
                    }
                } catch (NTLMEngineException unused) {
                    this.ntResp = new byte[0];
                    this.lmResp = cipherGen.getLMResponse();
                    if ((i10 & 128) != 0) {
                        lMUserSessionKey = cipherGen.getLanManagerSessionKey();
                    } else {
                        lMUserSessionKey = cipherGen.getLMUserSessionKey();
                    }
                }
                if ((i10 & 16) != 0) {
                    if ((NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH & i10) != 0) {
                        byte[] secondaryKey = cipherGen.getSecondaryKey();
                        this.exportedSessionKey = secondaryKey;
                        this.sessionKey = NTLMEngineImpl.RC4(secondaryKey, lMUserSessionKey);
                    } else {
                        this.sessionKey = lMUserSessionKey;
                        this.exportedSessionKey = lMUserSessionKey;
                    }
                } else if (!this.computeMic) {
                    this.sessionKey = null;
                    this.exportedSessionKey = null;
                } else {
                    throw new NTLMEngineException("Cannot sign/seal: no exported session key");
                }
                Charset charset = NTLMEngineImpl.getCharset(i10);
                this.hostBytes = strConvertHost != null ? strConvertHost.getBytes(charset) : null;
                this.domainBytes = strConvertDomain != null ? strConvertDomain.toUpperCase(Locale.ROOT).getBytes(charset) : null;
                this.userBytes = str3.getBytes(charset);
                return;
            }
            throw new NTLMEngineException("Random generator not available");
        }
    }

    static {
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception unused) {
            secureRandom = null;
        }
        RND_GEN = secureRandom;
        SIGNATURE = getNullTerminatedAsciiString("NTLMSSP");
        SIGN_MAGIC_SERVER = getNullTerminatedAsciiString("session key to server-to-client signing key magic constant");
        SIGN_MAGIC_CLIENT = getNullTerminatedAsciiString("session key to client-to-server signing key magic constant");
        SEAL_MAGIC_SERVER = getNullTerminatedAsciiString("session key to server-to-client sealing key magic constant");
        SEAL_MAGIC_CLIENT = getNullTerminatedAsciiString("session key to client-to-server sealing key magic constant");
        MAGIC_TLS_SERVER_ENDPOINT = "tls-server-end-point:".getBytes(Consts.ASCII);
        TYPE_1_MESSAGE = new Type1Message().getResponse();
    }

    public static int F(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    public static int G(int i10, int i11, int i12) {
        return (i10 & i12) | (i10 & i11) | (i11 & i12);
    }

    public static int H(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    public static byte[] RC4(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NTLMEngineException {
        try {
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(bArr2, "RC4"));
            return cipher.doFinal(bArr);
        } catch (Exception e10) {
            throw new NTLMEngineException(e10.getMessage(), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String convertDomain(String str) {
        return stripDotSuffix(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String convertHost(String str) {
        return stripDotSuffix(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] createBlob(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[bArr3.length + 8 + 8 + 4 + bArr2.length + 4];
        System.arraycopy(new byte[]{1, 1, 0, 0}, 0, bArr4, 0, 4);
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, bArr4, 4, 4);
        System.arraycopy(bArr3, 0, bArr4, 8, bArr3.length);
        int length = bArr3.length + 8;
        System.arraycopy(bArr, 0, bArr4, length, 8);
        int i10 = length + 8;
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, bArr4, i10, 4);
        int i11 = i10 + 4;
        System.arraycopy(bArr2, 0, bArr4, i11, bArr2.length);
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, bArr4, i11 + bArr2.length, 4);
        return bArr4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Key createDESKey(byte[] bArr, int i10) {
        byte[] bArr2 = new byte[7];
        System.arraycopy(bArr, i10, bArr2, 0, 7);
        byte[] bArr3 = {bArr2[0], (byte) ((bArr2[0] << 7) | ((bArr2[1] & 255) >>> 1)), (byte) ((bArr2[1] << 6) | ((bArr2[2] & 255) >>> 2)), (byte) ((bArr2[2] << 5) | ((bArr2[3] & 255) >>> 3)), (byte) ((bArr2[3] << 4) | ((bArr2[4] & 255) >>> 4)), (byte) ((bArr2[4] << 3) | ((bArr2[5] & 255) >>> 5)), (byte) ((bArr2[5] << 2) | ((bArr2[6] & 255) >>> 6)), (byte) (bArr2[6] << 1)};
        oddParity(bArr3);
        return new SecretKeySpec(bArr3, "DES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] encodeLong(int i10) {
        byte[] bArr = new byte[4];
        encodeLong(bArr, 0, i10);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Charset getCharset(int i10) throws NTLMEngineException {
        if ((i10 & 1) == 0) {
            return DEFAULT_CHARSET;
        }
        Charset charset = UNICODE_LITTLE_UNMARKED;
        if (charset != null) {
            return charset;
        }
        throw new NTLMEngineException("Unicode not supported");
    }

    public static MessageDigest getMD5() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("MD5 message digest doesn't seem to exist - fatal error: " + e10.getMessage(), e10);
        }
    }

    private static byte[] getNullTerminatedAsciiString(String str) {
        byte[] bytes = str.getBytes(Consts.ASCII);
        byte[] bArr = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        bArr[bytes.length] = 0;
        return bArr;
    }

    public static String getType1Message(String str, String str2) {
        return TYPE_1_MESSAGE;
    }

    public static String getType3Message(String str, String str2, String str3, String str4, byte[] bArr, int i10, String str5, byte[] bArr2) throws NTLMEngineException {
        return new Type3Message(str4, str3, str, str2, bArr, i10, str5, bArr2).getResponse();
    }

    public static byte[] hmacMD5(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        HMACMD5 hmacmd5 = new HMACMD5(bArr2);
        hmacmd5.update(bArr);
        return hmacmd5.getOutput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] lmHash(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, NTLMEngineException {
        try {
            String upperCase = str.toUpperCase(Locale.ROOT);
            Charset charset = Consts.ASCII;
            byte[] bytes = upperCase.getBytes(charset);
            byte[] bArr = new byte[14];
            System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 14));
            Key keyCreateDESKey = createDESKey(bArr, 0);
            Key keyCreateDESKey2 = createDESKey(bArr, 7);
            byte[] bytes2 = "KGS!@#$%".getBytes(charset);
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, keyCreateDESKey);
            byte[] bArrDoFinal = cipher.doFinal(bytes2);
            cipher.init(1, keyCreateDESKey2);
            byte[] bArrDoFinal2 = cipher.doFinal(bytes2);
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArrDoFinal, 0, bArr2, 0, 8);
            System.arraycopy(bArrDoFinal2, 0, bArr2, 8, 8);
            return bArr2;
        } catch (Exception e10) {
            throw new NTLMEngineException(e10.getMessage(), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] lmResponse(byte[] bArr, byte[] bArr2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, NTLMEngineException {
        try {
            byte[] bArr3 = new byte[21];
            System.arraycopy(bArr, 0, bArr3, 0, 16);
            Key keyCreateDESKey = createDESKey(bArr3, 0);
            Key keyCreateDESKey2 = createDESKey(bArr3, 7);
            Key keyCreateDESKey3 = createDESKey(bArr3, 14);
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, keyCreateDESKey);
            byte[] bArrDoFinal = cipher.doFinal(bArr2);
            cipher.init(1, keyCreateDESKey2);
            byte[] bArrDoFinal2 = cipher.doFinal(bArr2);
            cipher.init(1, keyCreateDESKey3);
            byte[] bArrDoFinal3 = cipher.doFinal(bArr2);
            byte[] bArr4 = new byte[24];
            System.arraycopy(bArrDoFinal, 0, bArr4, 0, 8);
            System.arraycopy(bArrDoFinal2, 0, bArr4, 8, 8);
            System.arraycopy(bArrDoFinal3, 0, bArr4, 16, 8);
            return bArr4;
        } catch (Exception e10) {
            throw new NTLMEngineException(e10.getMessage(), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] lmv2Hash(String str, String str2, byte[] bArr) throws NTLMEngineException {
        Charset charset = UNICODE_LITTLE_UNMARKED;
        if (charset == null) {
            throw new NTLMEngineException("Unicode not supported");
        }
        HMACMD5 hmacmd5 = new HMACMD5(bArr);
        Locale locale = Locale.ROOT;
        hmacmd5.update(str2.toUpperCase(locale).getBytes(charset));
        if (str != null) {
            hmacmd5.update(str.toUpperCase(locale).getBytes(charset));
        }
        return hmacmd5.getOutput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] lmv2Response(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        HMACMD5 hmacmd5 = new HMACMD5(bArr);
        hmacmd5.update(bArr2);
        hmacmd5.update(bArr3);
        byte[] output = hmacmd5.getOutput();
        byte[] bArr4 = new byte[output.length + bArr3.length];
        System.arraycopy(output, 0, bArr4, 0, output.length);
        System.arraycopy(bArr3, 0, bArr4, output.length, bArr3.length);
        return bArr4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] makeRandomChallenge(Random random) {
        byte[] bArr = new byte[8];
        synchronized (random) {
            random.nextBytes(bArr);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] makeSecondaryKey(Random random) {
        byte[] bArr = new byte[16];
        synchronized (random) {
            random.nextBytes(bArr);
        }
        return bArr;
    }

    public static byte[] ntlm2SessionResponse(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NTLMEngineException {
        try {
            MessageDigest md5 = getMD5();
            md5.update(bArr2);
            md5.update(bArr3);
            byte[] bArrDigest = md5.digest();
            byte[] bArr4 = new byte[8];
            System.arraycopy(bArrDigest, 0, bArr4, 0, 8);
            return lmResponse(bArr, bArr4);
        } catch (Exception e10) {
            if (e10 instanceof NTLMEngineException) {
                throw ((NTLMEngineException) e10);
            }
            throw new NTLMEngineException(e10.getMessage(), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] ntlmHash(String str) throws NTLMEngineException {
        Charset charset = UNICODE_LITTLE_UNMARKED;
        if (charset == null) {
            throw new NTLMEngineException("Unicode not supported");
        }
        byte[] bytes = str.getBytes(charset);
        MD4 md4 = new MD4();
        md4.update(bytes);
        return md4.getOutput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] ntlmv2Hash(String str, String str2, byte[] bArr) throws NTLMEngineException {
        Charset charset = UNICODE_LITTLE_UNMARKED;
        if (charset == null) {
            throw new NTLMEngineException("Unicode not supported");
        }
        HMACMD5 hmacmd5 = new HMACMD5(bArr);
        hmacmd5.update(str2.toUpperCase(Locale.ROOT).getBytes(charset));
        if (str != null) {
            hmacmd5.update(str.getBytes(charset));
        }
        return hmacmd5.getOutput();
    }

    private static void oddParity(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            if (((((((((b10 >>> 7) ^ (b10 >>> 6)) ^ (b10 >>> 5)) ^ (b10 >>> 4)) ^ (b10 >>> 3)) ^ (b10 >>> 2)) ^ (b10 >>> 1)) & 1) == 0) {
                bArr[i10] = (byte) (b10 | 1);
            } else {
                bArr[i10] = (byte) (b10 & (-2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] readSecurityBuffer(byte[] bArr, int i10) {
        int uShort = readUShort(bArr, i10);
        int uLong = readULong(bArr, i10 + 4);
        if (bArr.length < uLong + uShort) {
            return new byte[uShort];
        }
        byte[] bArr2 = new byte[uShort];
        System.arraycopy(bArr, uLong, bArr2, 0, uShort);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readULong(byte[] bArr, int i10) {
        if (bArr.length < i10 + 4) {
            return 0;
        }
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readUShort(byte[] bArr, int i10) {
        if (bArr.length < i10 + 2) {
            return 0;
        }
        return ((bArr[i10 + 1] & 255) << 8) | (bArr[i10] & 255);
    }

    public static int rotintlft(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    private static String stripDotSuffix(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(46);
        return iIndexOf != -1 ? str.substring(0, iIndexOf) : str;
    }

    public static void writeULong(byte[] bArr, int i10, int i11) {
        bArr[i11] = (byte) (i10 & 255);
        bArr[i11 + 1] = (byte) ((i10 >> 8) & 255);
        bArr[i11 + 2] = (byte) ((i10 >> 16) & 255);
        bArr[i11 + 3] = (byte) ((i10 >> 24) & 255);
    }

    public static void writeUShort(byte[] bArr, int i10, int i11) {
        bArr[i11] = (byte) (i10 & 255);
        bArr[i11 + 1] = (byte) ((i10 >> 8) & 255);
    }

    @Override // cz.msebera.android.httpclient.impl.auth.NTLMEngine
    public String generateType1Msg(String str, String str2) throws NTLMEngineException {
        return getType1Message(str2, str);
    }

    @Override // cz.msebera.android.httpclient.impl.auth.NTLMEngine
    public String generateType3Msg(String str, String str2, String str3, String str4, String str5) throws NTLMEngineException {
        Type2Message type2Message = new Type2Message(str5);
        return getType3Message(str, str2, str4, str3, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void encodeLong(byte[] bArr, int i10, int i11) {
        bArr[i10 + 0] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
    }

    public static class NTLMMessage {
        protected int currentOutputPosition;
        protected byte[] messageContents;

        public NTLMMessage() {
            this.messageContents = null;
            this.currentOutputPosition = 0;
        }

        public void addByte(byte b10) {
            byte[] bArr = this.messageContents;
            int i10 = this.currentOutputPosition;
            bArr[i10] = b10;
            this.currentOutputPosition = i10 + 1;
        }

        public void addBytes(byte[] bArr) {
            if (bArr == null) {
                return;
            }
            for (byte b10 : bArr) {
                byte[] bArr2 = this.messageContents;
                int i10 = this.currentOutputPosition;
                bArr2[i10] = b10;
                this.currentOutputPosition = i10 + 1;
            }
        }

        public void addULong(int i10) {
            addByte((byte) (i10 & 255));
            addByte((byte) ((i10 >> 8) & 255));
            addByte((byte) ((i10 >> 16) & 255));
            addByte((byte) ((i10 >> 24) & 255));
        }

        public void addUShort(int i10) {
            addByte((byte) (i10 & 255));
            addByte((byte) ((i10 >> 8) & 255));
        }

        public void buildMessage() {
            throw new RuntimeException("Message builder not implemented for ".concat(getClass().getName()));
        }

        public byte[] getBytes() {
            if (this.messageContents == null) {
                buildMessage();
            }
            byte[] bArr = this.messageContents;
            int length = bArr.length;
            int i10 = this.currentOutputPosition;
            if (length > i10) {
                byte[] bArr2 = new byte[i10];
                System.arraycopy(bArr, 0, bArr2, 0, i10);
                this.messageContents = bArr2;
            }
            return this.messageContents;
        }

        public int getMessageLength() {
            return this.currentOutputPosition;
        }

        public int getPreambleLength() {
            return NTLMEngineImpl.SIGNATURE.length + 4;
        }

        public String getResponse() {
            return new String(Base64.encode(getBytes(), 2), Consts.ASCII);
        }

        public void prepareResponse(int i10, int i11) {
            this.messageContents = new byte[i10];
            this.currentOutputPosition = 0;
            addBytes(NTLMEngineImpl.SIGNATURE);
            addULong(i11);
        }

        public byte readByte(int i10) throws NTLMEngineException {
            byte[] bArr = this.messageContents;
            if (bArr.length >= i10 + 1) {
                return bArr[i10];
            }
            throw new NTLMEngineException("NTLM: Message too short");
        }

        public void readBytes(byte[] bArr, int i10) throws NTLMEngineException {
            byte[] bArr2 = this.messageContents;
            if (bArr2.length < bArr.length + i10) {
                throw new NTLMEngineException("NTLM: Message too short");
            }
            System.arraycopy(bArr2, i10, bArr, 0, bArr.length);
        }

        public byte[] readSecurityBuffer(int i10) throws NTLMEngineException {
            return NTLMEngineImpl.readSecurityBuffer(this.messageContents, i10);
        }

        public int readULong(int i10) throws NTLMEngineException {
            return NTLMEngineImpl.readULong(this.messageContents, i10);
        }

        public int readUShort(int i10) throws NTLMEngineException {
            return NTLMEngineImpl.readUShort(this.messageContents, i10);
        }

        public NTLMMessage(String str, int i10) throws NTLMEngineException {
            this(Base64.decode(str.getBytes(NTLMEngineImpl.DEFAULT_CHARSET), 2), i10);
        }

        public NTLMMessage(byte[] bArr, int i10) throws NTLMEngineException {
            this.currentOutputPosition = 0;
            this.messageContents = bArr;
            if (bArr.length >= NTLMEngineImpl.SIGNATURE.length) {
                for (int i11 = 0; i11 < NTLMEngineImpl.SIGNATURE.length; i11++) {
                    if (this.messageContents[i11] != NTLMEngineImpl.SIGNATURE[i11]) {
                        throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
                    }
                }
                int uLong = readULong(NTLMEngineImpl.SIGNATURE.length);
                if (uLong == i10) {
                    this.currentOutputPosition = this.messageContents.length;
                    return;
                }
                throw new NTLMEngineException("NTLM type " + Integer.toString(i10) + " message expected - instead got type " + Integer.toString(uLong));
            }
            throw new NTLMEngineException("NTLM message decoding error - packet too short");
        }
    }

    public static String getType3Message(String str, String str2, String str3, String str4, byte[] bArr, int i10, String str5, byte[] bArr2, Certificate certificate, byte[] bArr3, byte[] bArr4) throws NTLMEngineException {
        return new Type3Message(str4, str3, str, str2, bArr, i10, str5, bArr2, certificate, bArr3, bArr4).getResponse();
    }
}
