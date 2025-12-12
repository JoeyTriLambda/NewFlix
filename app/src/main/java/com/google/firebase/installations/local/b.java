package com.google.firebase.installations.local;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.a;

/* compiled from: PersistedInstallationEntry.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class b {

    /* compiled from: PersistedInstallationEntry.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract b build();

        public abstract a setAuthToken(String str);

        public abstract a setExpiresInSecs(long j10);

        public abstract a setFirebaseInstallationId(String str);

        public abstract a setFisError(String str);

        public abstract a setRefreshToken(String str);

        public abstract a setRegistrationStatus(PersistedInstallation.RegistrationStatus registrationStatus);

        public abstract a setTokenCreationEpochInSecs(long j10);
    }

    static {
        builder().build();
    }

    public static a builder() {
        return new a.C0101a().setTokenCreationEpochInSecs(0L).setRegistrationStatus(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION).setExpiresInSecs(0L);
    }

    public abstract String getAuthToken();

    public abstract long getExpiresInSecs();

    public abstract String getFirebaseInstallationId();

    public abstract String getFisError();

    public abstract String getRefreshToken();

    public abstract PersistedInstallation.RegistrationStatus getRegistrationStatus();

    public abstract long getTokenCreationEpochInSecs();

    public boolean isErrored() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR;
    }

    public boolean isNotGenerated() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.NOT_GENERATED || getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    public boolean isRegistered() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTERED;
    }

    public boolean isUnregistered() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.UNREGISTERED;
    }

    public boolean shouldAttemptMigration() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    public abstract a toBuilder();

    public b withAuthToken(String str, long j10, long j11) {
        return toBuilder().setAuthToken(str).setExpiresInSecs(j10).setTokenCreationEpochInSecs(j11).build();
    }

    public b withClearedAuthToken() {
        return toBuilder().setAuthToken(null).build();
    }

    public b withFisError(String str) {
        return toBuilder().setFisError(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR).build();
    }

    public b withNoGeneratedFid() {
        return toBuilder().setRegistrationStatus(PersistedInstallation.RegistrationStatus.NOT_GENERATED).build();
    }

    public b withRegisteredFid(String str, String str2, long j10, String str3, long j11) {
        return toBuilder().setFirebaseInstallationId(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTERED).setAuthToken(str3).setRefreshToken(str2).setExpiresInSecs(j11).setTokenCreationEpochInSecs(j10).build();
    }

    public b withUnregisteredFid(String str) {
        return toBuilder().setFirebaseInstallationId(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.UNREGISTERED).build();
    }
}
